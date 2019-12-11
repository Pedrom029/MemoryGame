package com.example.memorygame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.RadioButton;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.util.ArrayList;
import java.util.List;

public class ScoreActivity extends AppCompatActivity {
    private AdView mAdView;
    //@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        ((RadioButton) findViewById(R.id.radioButtonEasy)).setChecked(true); //Set RadioButton Easy Checked

        createList("easy"); //Create list for Hardness=easy

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {

            }
        });
        mAdView = findViewById(R.id.adView_s);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }

    public void onRadioClick(View view) {
        String hardness = ((RadioButton) view).getText().toString();
        createList(hardness);
    }

    public void createList(String hardness){
        List<String> listNames = new ArrayList<>();
        List<String> listScores = new ArrayList<>();
        String item = "";

        SharedPreferences scores = getSharedPreferences(hardness, Context.MODE_PRIVATE);

        for (int i = 1; i < 11; i ++){
            item = scores.getString(String.valueOf(i),null);
            if (item != null){
                listNames.add(item.substring(0, item.indexOf(",")));
                listScores.add(item.substring(item.indexOf(",")+1));
            }
            else{
                i = 11;
            }
        }
        ListView listViewScores = findViewById(R.id.listScores);
        ListView listViewNames = findViewById(R.id.listNames);

        SimpleAdapter simpleAdapter = new SimpleAdapter(this,listNames);
        listViewNames.setAdapter(simpleAdapter);
        simpleAdapter = new SimpleAdapter(this, listScores);
        listViewScores.setAdapter(simpleAdapter);
    }
}
