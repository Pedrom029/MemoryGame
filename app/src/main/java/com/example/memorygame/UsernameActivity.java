package com.example.memorygame;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

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
        SharedPreferences names = getSharedPreferences("names", Context.MODE_PRIVATE);
        radioBtn1 = findViewById(R.id.radioButton1);
        radioBtn2 = findViewById(R.id.radioButton2);
        radioBtn3 = findViewById(R.id.radioButton3);
        radioBtn1.setChecked(true);
        String name;

        for (int i = 1 ; i < 11 ; i++) {
            name = names.getString(String.valueOf(i), null);
            if (i == 1){
                TextView name1 = findViewById(R.id.textName1);
                name1.setText(name);
            }
            if (i == 2){
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
            else if (i == 6) {
                TextView name6 = findViewById(R.id.textName6);
                name6.setText(name);
            }
            else if (i == 7) {
                TextView name7 = findViewById(R.id.textName7);
                name7.setText(name);
            }
        }
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

        String[] HARDNESS = {"Can I play daddy?", "Bring 'em on!", "Nightmare"};

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

    public void userClick(View view) {
        String nome;
        AutoCompleteTextView _userName = findViewById(R.id.userName);

        TextView t = (TextView) view;
        nome = t.getText().toString();

        _userName.setText(nome);
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
}
