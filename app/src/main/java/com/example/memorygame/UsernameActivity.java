package com.example.memorygame;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class UsernameActivity extends AppCompatActivity {

    static String hardness;
    static String theme;
    static boolean singlePlayer;
    RadioButton radioBtn1;
    RadioButton radioBtn2;
    RadioButton radioBtn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_username);
        radioBtn1 = findViewById(R.id.radioButton1);
        radioBtn2 = findViewById(R.id.radioButton2);
        radioBtn3 = findViewById(R.id.radioButton3);
        radioBtn1.setChecked(true);
        String name = "";
        List<String> listNames = new ArrayList<>();

        for (int i = 1; i < 4; i++){
            hardness = (i == 1 ? "easy" : i == 2 ? "medium" : "hard");

            for (int j = 1; j < 11; j++){
                SharedPreferences names = getSharedPreferences(hardness, Context.MODE_PRIVATE);
                name = names.getString(String.valueOf(j),null);
                if (name != null) listNames.add(name.substring(0, name.indexOf(",")));
                else j=11;
            }
        }
        final ListView listViewNames = findViewById(R.id.listNames);
        SimpleAdapter simpleAdapter = new SimpleAdapter(this,listNames);
        listViewNames.setAdapter(simpleAdapter);

        listViewNames.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (((AutoCompleteTextView) findViewById(R.id.userName)).getText().toString().equals("")) {
                    ((AutoCompleteTextView) findViewById(R.id.userName)).setText(String.valueOf(listViewNames.getItemAtPosition(position)));
                }
                else if (((AutoCompleteTextView) findViewById(R.id.userName2)).getText().toString().equals("")){
                    ((AutoCompleteTextView) findViewById(R.id.userName2)).setText(String.valueOf(listViewNames.getItemAtPosition(position)));
                }
            }
        });
    }

    public void mainWindow(View view) {
        finish();

    }

    public void startGameActivity(){
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
    }

    public void onClickGame(View view) {
        AutoCompleteTextView player1 = findViewById(R.id.userName);
        AutoCompleteTextView player2 = findViewById(R.id.userName2);
        MainActivity.m_userName1 = player1.getText().toString();
        MainActivity.m_userName2 = player2.getText().toString();

        String[] HARDNESS = {"Easy PZ(3X4)", "Normal-ish (4X4)", "Hardcore (5x4)"};

        AlertDialog.Builder dBuilder = new AlertDialog.Builder(UsernameActivity.this);
        dBuilder.setTitle("Choose Difficulty:")
                .setItems(HARDNESS, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch(which){
                            case 0:
                                hardness = "easy";
                                radioBtnCheck();
                                startGameActivity();
                                UsernameActivity.this.finish();
                                break;
                            case 1:
                                hardness = "medium";
                                radioBtnCheck();
                                startGameActivity();
                                UsernameActivity.this.finish();
                                break;
                            case 2:
                                hardness = "hard";
                                radioBtnCheck();
                                startGameActivity();
                                UsernameActivity.this.finish();
                                break;
                            default:
                                break;
                        }
                    }
                });

        if (MainActivity.m_userName1.length()>=2 && MainActivity.m_userName2.isEmpty()){
            singlePlayer = true;
            Toast.makeText(getApplicationContext(), R.string.singlePM_u, Toast.LENGTH_LONG).show();
            dBuilder.create().show();
        }
        else if(MainActivity.m_userName1.length()>=2 && MainActivity.m_userName2.length()>=2){
            singlePlayer = false;
            Toast.makeText(getApplicationContext(), R.string.multiPM_u, Toast.LENGTH_LONG).show();
            dBuilder.create().show();
        }
        else if(MainActivity.m_userName1.isEmpty() && MainActivity.m_userName2.length()>=2){
            Toast.makeText(getApplicationContext(), R.string.onPlayerOne_u, Toast.LENGTH_LONG).show();
        }
        else if(MainActivity.m_userName1.length()>0 || MainActivity.m_userName2.length()>0){
            Toast.makeText(getApplicationContext(), R.string.longerNick_u, Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(getApplicationContext(), R.string.insNick_u, Toast.LENGTH_LONG).show();
        }
    }


    private void radioBtnCheck() {
        if (radioBtn1.isChecked()){
            theme = radioBtn1.getTag().toString();
        }
        else if (radioBtn2.isChecked()){
            theme = radioBtn2.getTag().toString();
        }
        else if (radioBtn3.isChecked()){
            theme = radioBtn3.getTag().toString();
        }
    }

    public void onClickUserName(View view) {
        //((AutoCompleteTextView) findViewById(R.id.userName)).setText(((TextView) view).getText().toString());
    }
}
