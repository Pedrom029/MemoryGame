package com.example.memorygame;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class GameActivity extends AppCompatActivity {
    int[] Posicoes_rand;
    int Pares=0;
    int carta1=100;
    int carta2=100;
    List<Integer> Cards_Paired = new ArrayList<Integer>();
    ImageView CartaAnterior = null;
    int espera=0;
    CountDownTimer cTimer = null; //Declare timer
    int wrongPairs_1 = 0; //Wrong pairs for player 1
    int wrongPairs_2 = 0; //Wrong pairs for player 2
    int correctPairs_1 = 0; //Correct pairs for player 1
    int correctPairs_2 = 0; //Correct pairs for player 2
    int player = 1; //Active player
    int Carta;
    ImageView Imagem;

    public void Compara_cartas(final int Carta, final ImageView Imagem) {
        if(espera==0) {
            if (!Cards_Paired.contains(Carta)) {
                if (carta1 == 100) {
                    carta1 = Carta;
                    CartaAnterior = Imagem;
                    Imagem.setImageResource(cars[Carta]);
                } else {
                    if ((carta1 == Carta) && (CartaAnterior != Imagem)) {
                        Imagem.setImageResource(cars[Carta]);
                        Cards_Paired.add(Carta);
                        Imagem.setEnabled(false);
                        CartaAnterior.setEnabled(false);
                        if (player == 1) {
                            correctPairs_1 += 1;
                        }
                        else if (player == 2) {
                            correctPairs_2 += 1;
                        }
                    } else {
                        new CountDownTimer(300, 100) { // 5000 = 5 sec

                            public void onTick(long millisUntilFinished) {
                                Imagem.setImageResource(cars[Carta]);
                                espera = 1;
                            }

                            public void onFinish() {
                                if (!Cards_Paired.contains(Carta)) {
                                    Imagem.setImageResource(R.drawable.carta_back);
                                }
                                if (!Cards_Paired.contains(carta1)) {
                                    CartaAnterior.setImageResource(R.drawable.carta_back);
                                }
                                espera = 0;
                                if (player == 1) {
                                    wrongPairs_1 += 1;
                                }
                                else if (player == 2) {
                                    wrongPairs_2 += 1;
                                }
                            }
                        }.start();

                    }
                    carta1 = 100;
                }

            }
        }
    }

    final int[] cars={R.drawable.alfaromeo, R.drawable.bmw, R.drawable.ferrari, R.drawable.mazda, R.drawable.honda, R.drawable.mercedes, R.drawable.nissan, R.drawable.toyota, R.drawable.volkswagen, R.drawable.subaru};

    public void onClick(View view){
        switch (view.getId()){
            case R.id.cardView1:
                Carta=Posicoes_rand[0];
                Imagem=findViewById(R.id.cardView1);
                Compara_cartas(Carta, Imagem);
                break;
            case R.id.cardView2:
                Carta=Posicoes_rand[1];
                Imagem=findViewById(R.id.cardView2);
                Compara_cartas(Carta, Imagem);
                break;
            case R.id.cardView3:
                Carta=Posicoes_rand[2];
                Imagem=findViewById(R.id.cardView3);
                Compara_cartas(Carta, Imagem);
                break;
            case R.id.cardView4:
                Carta=Posicoes_rand[3];
                Imagem=findViewById(R.id.cardView4);
                Compara_cartas(Carta, Imagem);
                break;
            case R.id.cardView5:
                Carta=Posicoes_rand[4];
                Imagem=findViewById(R.id.cardView5);
                Compara_cartas(Carta, Imagem);
                break;
            case R.id.cardView6:
                Carta=Posicoes_rand[5];
                Imagem=findViewById(R.id.cardView6);
                Compara_cartas(Carta, Imagem);
                break;
            case R.id.cardView7:
                Carta=Posicoes_rand[6];
                Imagem=findViewById(R.id.cardView7);
                Compara_cartas(Carta, Imagem);
                break;
            case R.id.cardView8:
                Carta=Posicoes_rand[7];
                Imagem=findViewById(R.id.cardView8);
                Compara_cartas(Carta, Imagem);
                break;
            case R.id.cardView9:
                Carta=Posicoes_rand[8];
                Imagem=findViewById(R.id.cardView9);
                Compara_cartas(Carta, Imagem);
                break;
            case R.id.cardView10:
                Carta=Posicoes_rand[9];
                Imagem=findViewById(R.id.cardView10);
                Compara_cartas(Carta, Imagem);
                break;
            case R.id.cardView11:
                Carta=Posicoes_rand[10];
                Imagem=findViewById(R.id.cardView11);
                Compara_cartas(Carta, Imagem);
                break;
            case R.id.cardView12:
                Carta=Posicoes_rand[11];
                Imagem=findViewById(R.id.cardView12);
                Compara_cartas(Carta, Imagem);
                break;
            case R.id.cardView13:
                Carta=Posicoes_rand[12];
                Imagem=findViewById(R.id.cardView13);
                Compara_cartas(Carta, Imagem);
                break;
            case R.id.cardView14:
                Carta=Posicoes_rand[13];
                Imagem=findViewById(R.id.cardView14);
                Compara_cartas(Carta, Imagem);
                break;
            case R.id.cardView15:
                Carta=Posicoes_rand[14];
                Imagem=findViewById(R.id.cardView15);
                Compara_cartas(Carta, Imagem);
                break;
            case R.id.cardView16:
                Carta=Posicoes_rand[15];
                Imagem=findViewById(R.id.cardView16);
                Compara_cartas(Carta, Imagem);
                break;
            case R.id.cardView17:
                Carta=Posicoes_rand[16];
                Imagem=findViewById(R.id.cardView17);
                Compara_cartas(Carta, Imagem);
                break;
            case R.id.cardView18:
                Carta=Posicoes_rand[17];
                Imagem=findViewById(R.id.cardView18);
                Compara_cartas(Carta, Imagem);
                break;
            case R.id.cardView19:
                Carta=Posicoes_rand[18];
                Imagem=findViewById(R.id.cardView19);
                Compara_cartas(Carta, Imagem);
                break;
            case R.id.cardView20:
                Carta=Posicoes_rand[19];
                Imagem=findViewById(R.id.cardView20);
                Compara_cartas(Carta, Imagem);
                break;

        }



    }

    public static int[] RandomizeArray(int[] array){
        Random rgen = new Random();  // Random number generator

        for (int i=0; i<array.length; i++) {
            int randomPosition = rgen.nextInt(array.length);
            int temp = array[i];
            array[i] = array[randomPosition];
            array[randomPosition] = temp;
        }

        return array;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        LinearLayout llayout5 = findViewById(R.id.lineView5);
        LinearLayout llayout4 = findViewById(R.id.lineView4);

        final LinearLayout Linear_l=findViewById(R.id.linearLayout);
        //img_1.setImageResource(cars[0]);


        if(UsernameActivity.hardness.equals("easy")){
            llayout5.setVisibility(View.GONE);
            llayout4.setVisibility(View.GONE);
            int[] Posicoes= new int[] {0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5};
            Posicoes_rand=RandomizeArray(Posicoes);



        }
        else if(UsernameActivity.hardness.equals("medium")){
            llayout5.setVisibility(View.GONE);
            int[] Posicoes= new int[] {0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7};
            Posicoes_rand=RandomizeArray(Posicoes);
        }
        else if(UsernameActivity.hardness.equals("hard")){
            int[] Posicoes= new int[] {0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9};
            Posicoes_rand=RandomizeArray(Posicoes);

        }

       startTimer(); //Start timer
    }

    @Override
    public void onBackPressed(){
        new AlertDialog.Builder(this)
                .setTitle("Chickening out already?")
                .setMessage("Press Stay if you are brave.\nPress Exit to cower in shame.")
                .setNegativeButton("Stay", null)
                .setPositiveButton("Exit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        GameActivity.this.finish();
                    }
                }).create().show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (cTimer != null)
            cTimer.cancel();
    }

    //start timer function
    void startTimer() {
        cTimer = new CountDownTimer(60000, 1000) {
            public void onTick(long millisUntilFinished) {
                TextView timer = findViewById(R.id.textTimer);
                timer.setText(String.valueOf((int)(Math.ceil((millisUntilFinished/1000)+1)))); //Calculate time left in seconds and show on TextView
            }
            public void onFinish() {
                TextView timer = findViewById(R.id.textTimer);
                timer.setText("0");
                new AlertDialog.Builder(GameActivity.this)  //AlertDialog to inform user that he lost due to time
                    .setTitle("Time over!")
                    .setMessage("Better luck next time!")
                    .setPositiveButton("Exit", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            GameActivity.this.finish();
                        }
                    }).create().show();
            }
        };
        cTimer.start();
    }

    //save scores function
    private void saveScore(String userName, int score) {

        SharedPreferences scores = getSharedPreferences(UsernameActivity.hardness, Context.MODE_PRIVATE);
        SharedPreferences.Editor editorScores = scores.edit();

        int scorePos = 0; //score a ser analizado
        String namePos = "";

        for (int i = 1; i<11;i++){
            namePos = scores.getString(String.valueOf(i), null);
            scorePos = Integer.parseInt(namePos.substring(namePos.indexOf(",")+1));
            namePos = namePos.substring(0,namePos.indexOf(",")-1);
            if (userName.equals(namePos)){
                if (scorePos < score){
                    editorScores.putString(String.valueOf(i), namePos + "," + score);
                }
                score = 0;
                i=11;
            }
        }
        if (score>0) {
            for (int i = 1; i < 11; i++) {
                namePos = scores.getString(String.valueOf(i), null);
                if (namePos == null) {
                    editorScores.putString(String.valueOf(i), namePos + "," + score);
                    editorScores.apply();
                    i = 11;
                } else {
                    scorePos = Integer.parseInt(namePos.substring(namePos.indexOf(",")+1));
                    if (scorePos < score) {
                        if (i == 10) {
                            editorScores.putString(String.valueOf(i), namePos + "," + score);
                        } else {
                            for (int j = 9; i < j + 1; j--) {
                                scorePos = Integer.parseInt(namePos.substring(namePos.indexOf(",")+1));
                                if (scorePos != 10) {
                                    editorScores.putString(String.valueOf(j+1), namePos + "," + score);
                                }
                            }
                            editorScores.putString(String.valueOf(i), namePos + "," + score);
                        }
                        i = 11;
                    }
                }
            }
        }
        editorScores.apply();
    }

    //calculate scores function
    private int calculateScore(int wrong, int correct){
        int calculatedScore = (int)Math.ceil((correct/wrong)*10000);
        return calculatedScore;
    }
}


