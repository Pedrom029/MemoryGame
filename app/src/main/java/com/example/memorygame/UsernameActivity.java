package com.example.memorygame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import android.widget.Toast;

public class UsernameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_username);
        SharedPreferences names = getSharedPreferences("names", Context.MODE_PRIVATE);
        String name = "";

        for (int i=1 ; i < 11 ; i++) {
            name = names.getString(String.valueOf(i), null);
            if (i==1){
                TextView name1 = findViewById(R.id.textName1);
                name1.setText(name);
            }
            if (i==2){
                TextView name2 = findViewById(R.id.textName2);
                name2.setText(name);
            }
            else if (i == 3) {
                TextView name3 = findViewById(R.id.textName3);
                name3.setText(name);
            }
            else if (i == 4) {
                TextView name4 = findViewById(R.id.textName4);
                name4.setText(name);
            }
            else if (i == 5) {
                TextView name5 = findViewById(R.id.textName5);
                name5.setText(name);
            }
        }
    }

    public void mainWindow(View view) {
        finish();
    }

    public void onClickGame(View view) {
        AutoCompleteTextView source = findViewById(R.id.userName);
        MainActivity.m_userName = source.getText().toString();

        if (MainActivity.m_userName.length()>3){

            Intent intent = new Intent(this, GameActivity.class);
            startActivity(intent);
            finish();
        }
        else if(MainActivity.m_userName.length()<3 && MainActivity.m_userName.length()>0){
            Toast.makeText(getApplicationContext(),R.string.longerNick, Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(getApplicationContext(),R.string.insNick, Toast.LENGTH_LONG).show();
        }
    }

    public void userClick(View view) {
        String nome = "";
        AutoCompleteTextView _userName = findViewById(R.id.userName);

        TextView t = (TextView) view;
        nome = t.getText().toString();

        _userName.setText(nome);
    }
}
