package com.example.memorygame;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class GameActivity extends AppCompatActivity {
    int[] Posicoes_rand;
    int Pares=0;
    int carta1=100;
    int carta2=100;
    ImageView CartaAnterior = null;
    ImageView img_1;
    ImageView img_2;
    ImageView img_3;
    ImageView img_4;
    ImageView img_5;
    ImageView img_6;
    ImageView img_7;
    ImageView img_8;
    ImageView img_9;
    ImageView img_10;
    ImageView img_11;
    ImageView img_12;
    ImageView img_13;
    ImageView img_14;
    ImageView img_15;
    ImageView img_16;
    ImageView img_17;
    ImageView img_18;
    ImageView img_19;
    ImageView img_20;


    final int[] cars={R.drawable.alfaromeo, R.drawable.bmw, R.drawable.ferrari, R.drawable.mazda, R.drawable.honda, R.drawable.mercedes, R.drawable.nissan, R.drawable.toyota};
    public void onClick(View view){
        img_1=findViewById(R.id.cardView1);
        img_2=findViewById(R.id.cardView2);
        img_3=findViewById(R.id.cardView3);
        img_4=findViewById(R.id.cardView4);
        img_5=findViewById(R.id.cardView5);
        img_6=findViewById(R.id.cardView6);
        img_7=findViewById(R.id.cardView7);
        img_8=findViewById(R.id.cardView8);
        img_9=findViewById(R.id.cardView9);
        img_10=findViewById(R.id.cardView10);
        img_11=findViewById(R.id.cardView11);
        img_12=findViewById(R.id.cardView12);
        img_13=findViewById(R.id.cardView13);
        img_14=findViewById(R.id.cardView14);
        img_15=findViewById(R.id.cardView15);
        img_16=findViewById(R.id.cardView16);
        img_17=findViewById(R.id.cardView17);
        img_18=findViewById(R.id.cardView18);
        img_19=findViewById(R.id.cardView19);
        img_20=findViewById(R.id.cardView20);
        switch (view.getId()){
            case R.id.cardView1:
                if(carta1==100) {
                    carta1=Posicoes_rand[0];
                    CartaAnterior=img_1;
                    img_1.setImageResource(cars[Posicoes_rand[0]]);
                }
                else{
                    if((carta1 == Posicoes_rand[0])&&(CartaAnterior!=img_1)){
                        img_1.setImageResource(cars[Posicoes_rand[0]]);
                        carta1=100;
                        img_1.setEnabled(false);
                        CartaAnterior.setEnabled(false);
                    }
                    else{
                        new CountDownTimer(500, 100) { // 5000 = 5 sec

                            public void onTick(long millisUntilFinished) {
                                img_1.setImageResource(cars[Posicoes_rand[0]]);
                            }

                            public void onFinish() {
                                img_1.setImageResource(R.drawable.carta_back);
                                CartaAnterior.setImageResource(R.drawable.carta_back);
                            }
                        }.start();


                        carta1=100;

                    }
                }
                break;
            case R.id.cardView2:
                if(carta1==100) {
                    carta1=Posicoes_rand[1];
                    CartaAnterior=img_2;
                    img_2.setImageResource(cars[Posicoes_rand[1]]);
                }
                else{
                    if((carta1 == Posicoes_rand[1])&&(CartaAnterior!=img_2)){
                        img_2.setImageResource(cars[Posicoes_rand[1]]);
                        carta1=100;
                        img_2.setEnabled(false);
                        CartaAnterior.setEnabled(false);
                    }
                    else{
                        new CountDownTimer(500, 100) { // 5000 = 5 sec

                            public void onTick(long millisUntilFinished) {
                                img_2.setImageResource(cars[Posicoes_rand[1]]);
                            }

                            public void onFinish() {
                                img_2.setImageResource(R.drawable.carta_back);
                                CartaAnterior.setImageResource(R.drawable.carta_back);
                            }
                        }.start();

                        carta1=100;

                    }
                }

                break;
            case R.id.cardView3:
                if(carta1==100) {
                    carta1=Posicoes_rand[2];
                    CartaAnterior=img_3;
                    img_3.setImageResource(cars[Posicoes_rand[2]]);
                }
                else{
                    if((carta1 == Posicoes_rand[2])&&(CartaAnterior!=img_3)){
                        img_3.setImageResource(cars[Posicoes_rand[2]]);
                        carta1=100;
                        img_3.setEnabled(false);
                        CartaAnterior.setEnabled(false);
                    }
                    else{
                        new CountDownTimer(500, 100) { // 5000 = 5 sec

                            public void onTick(long millisUntilFinished) {
                                img_3.setImageResource(cars[Posicoes_rand[2]]);
                            }

                            public void onFinish() {
                                img_3.setImageResource(R.drawable.carta_back);
                                CartaAnterior.setImageResource(R.drawable.carta_back);
                            }
                        }.start();

                        carta1=100;

                    }
                }
                break;

            case R.id.cardView4:
                if(carta1==100) {
                    carta1=Posicoes_rand[3];
                    CartaAnterior=img_4;
                    img_4.setImageResource(cars[Posicoes_rand[3]]);
                }
                else{
                    if((carta1 == Posicoes_rand[3])&&(CartaAnterior!=img_4)){
                        img_4.setImageResource(cars[Posicoes_rand[3]]);
                        carta1=100;
                        img_4.setEnabled(false);
                        CartaAnterior.setEnabled(false);
                    }
                    else{
                        new CountDownTimer(500, 100) { // 5000 = 5 sec

                            public void onTick(long millisUntilFinished) {
                                img_4.setImageResource(cars[Posicoes_rand[3]]);
                            }

                            public void onFinish() {
                                img_4.setImageResource(R.drawable.carta_back);
                                CartaAnterior.setImageResource(R.drawable.carta_back);
                            }
                        }.start();

                        carta1=100;

                    }
                }
                break;
            case R.id.cardView5:
                if(carta1==100) {
                    carta1=Posicoes_rand[4];
                    CartaAnterior=img_5;
                    img_5.setImageResource(cars[Posicoes_rand[4]]);
                }
                else{
                    if((carta1 == Posicoes_rand[4])&&(CartaAnterior!=img_5)){
                        img_5.setImageResource(cars[Posicoes_rand[4]]);
                        carta1=100;
                        img_5.setEnabled(false);
                        CartaAnterior.setEnabled(false);
                    }
                    else{
                        new CountDownTimer(500, 100) { // 5000 = 5 sec

                            public void onTick(long millisUntilFinished) {
                                img_5.setImageResource(cars[Posicoes_rand[4]]);
                            }

                            public void onFinish() {
                                img_5.setImageResource(R.drawable.carta_back);
                                CartaAnterior.setImageResource(R.drawable.carta_back);
                            }
                        }.start();

                        carta1=100;

                    }
                }
                break;
            case R.id.cardView6:
                if(carta1==100) {
                    carta1=Posicoes_rand[5];
                    CartaAnterior=img_6;
                    img_6.setImageResource(cars[Posicoes_rand[5]]);
                }
                else{
                    if((carta1 == Posicoes_rand[5])&&(CartaAnterior!=img_6)){
                        img_6.setImageResource(cars[Posicoes_rand[5]]);
                        carta1=100;
                        img_6.setEnabled(false);
                        CartaAnterior.setEnabled(false);
                    }
                    else{
                        new CountDownTimer(300, 100) { // 5000 = 5 sec

                            public void onTick(long millisUntilFinished) {
                                img_6.setImageResource(cars[Posicoes_rand[5]]);
                            }

                            public void onFinish() {
                                img_6.setImageResource(R.drawable.carta_back);
                                CartaAnterior.setImageResource(R.drawable.carta_back);

                            }
                        }.start();


                        carta1=100;

                    }
                }
                break;
            case R.id.cardView7:
                if(carta1==100) {
                    carta1=Posicoes_rand[6];
                    CartaAnterior=img_7;
                    img_7.setImageResource(cars[Posicoes_rand[6]]);
                }
                else{
                    if((carta1 == Posicoes_rand[6])&&(CartaAnterior!=img_7)){
                        img_7.setImageResource(cars[Posicoes_rand[6]]);
                        carta1=100;
                        img_7.setEnabled(false);
                        CartaAnterior.setEnabled(false);
                    }
                    else{
                        new CountDownTimer(500, 100) { // 5000 = 5 sec

                            public void onTick(long millisUntilFinished) {
                                img_7.setImageResource(cars[Posicoes_rand[6]]);
                            }

                            public void onFinish() {
                                img_7.setImageResource(R.drawable.carta_back);
                                CartaAnterior.setImageResource(R.drawable.carta_back);
                            }
                        }.start();

                        carta1=100;

                    }
                }
                break;
            case R.id.cardView8:
                if(carta1==100) {
                    carta1=Posicoes_rand[7];
                    CartaAnterior=img_8;
                    img_8.setImageResource(cars[Posicoes_rand[7]]);
                }
                else{
                    if((carta1 == Posicoes_rand[7])&&(CartaAnterior!=img_8)){
                        img_8.setImageResource(cars[Posicoes_rand[7]]);
                        carta1=100;
                        img_8.setEnabled(false);
                        CartaAnterior.setEnabled(false);
                    }
                    else{
                        new CountDownTimer(500, 100) { // 5000 = 5 sec

                            public void onTick(long millisUntilFinished) {
                                img_8.setImageResource(cars[Posicoes_rand[7]]);
                            }

                            public void onFinish() {
                                img_8.setImageResource(R.drawable.carta_back);
                                CartaAnterior.setImageResource(R.drawable.carta_back);
                            }
                        }.start();

                        carta1=100;

                    }
                }
                break;
            case R.id.cardView9:
                if(carta1==100) {
                    carta1=Posicoes_rand[8];
                    CartaAnterior=img_9;
                    img_9.setImageResource(cars[Posicoes_rand[8]]);
                }
                else{
                    if((carta1 == Posicoes_rand[8])&&(CartaAnterior!=img_9)){
                        img_9.setImageResource(cars[Posicoes_rand[8]]);
                        carta1=100;
                        img_9.setEnabled(false);
                        CartaAnterior.setEnabled(false);
                    }
                    else{
                        new CountDownTimer(500, 100) { // 5000 = 5 sec

                            public void onTick(long millisUntilFinished) {
                                img_9.setImageResource(cars[Posicoes_rand[8]]);
                            }

                            public void onFinish() {
                                img_9.setImageResource(R.drawable.carta_back);
                                CartaAnterior.setImageResource(R.drawable.carta_back);
                            }
                        }.start();

                        carta1=100;

                    }
                }
                break;
            case R.id.cardView10:
                if(carta1==100) {
                    carta1=Posicoes_rand[9];
                    CartaAnterior=img_10;
                    img_10.setImageResource(cars[Posicoes_rand[9]]);
                }
                else{
                    if((carta1 == Posicoes_rand[9])&&(CartaAnterior!=img_10)){
                        img_10.setImageResource(cars[Posicoes_rand[9]]);
                        carta1=100;
                        img_10.setEnabled(false);
                        CartaAnterior.setEnabled(false);
                    }
                    else{
                        new CountDownTimer(500, 100) { // 5000 = 5 sec

                            public void onTick(long millisUntilFinished) {
                                img_10.setImageResource(cars[Posicoes_rand[9]]);
                            }

                            public void onFinish() {
                                img_10.setImageResource(R.drawable.carta_back);
                                CartaAnterior.setImageResource(R.drawable.carta_back);
                            }
                        }.start();

                        carta1=100;

                    }
                }
                break;
            case R.id.cardView11:
                if(carta1==100) {
                    carta1=Posicoes_rand[10];
                    CartaAnterior=img_11;
                    img_11.setImageResource(cars[Posicoes_rand[10]]);
                }
                else{
                    if((carta1 == Posicoes_rand[10])&&(CartaAnterior!=img_11)){
                        img_11.setImageResource(cars[Posicoes_rand[10]]);
                        carta1=100;
                        img_11.setEnabled(false);
                        CartaAnterior.setEnabled(false);
                    }
                    else{
                        new CountDownTimer(500, 100) { // 5000 = 5 sec

                            public void onTick(long millisUntilFinished) {
                                img_11.setImageResource(cars[Posicoes_rand[10]]);
                            }

                            public void onFinish() {
                                img_11.setImageResource(R.drawable.carta_back);
                                CartaAnterior.setImageResource(R.drawable.carta_back);
                            }
                        }.start();

                        carta1=100;

                    }
                }
                break;
            case R.id.cardView12:
                if(carta1==100) {
                    carta1=Posicoes_rand[11];
                    CartaAnterior=img_12;
                    img_12.setImageResource(cars[Posicoes_rand[11]]);
                }
                else{
                    if((carta1 == Posicoes_rand[11])&&(CartaAnterior!=img_12)){
                        img_12.setImageResource(cars[Posicoes_rand[11]]);
                        carta1=100;
                        img_12.setEnabled(false);
                        CartaAnterior.setEnabled(false);
                    }
                    else{
                        new CountDownTimer(500, 100) { // 5000 = 5 sec

                            public void onTick(long millisUntilFinished) {
                                img_12.setImageResource(cars[Posicoes_rand[11]]);
                            }

                            public void onFinish() {
                                img_12.setImageResource(R.drawable.carta_back);
                                CartaAnterior.setImageResource(R.drawable.carta_back);
                            }
                        }.start();

                        carta1=100;

                    }
                }
                break;
            case R.id.cardView13:
                img_13.setImageResource(cars[Posicoes_rand[12]]);
                break;
            case R.id.cardView14:
                img_14.setImageResource(cars[Posicoes_rand[13]]);
                break;
            case R.id.cardView15:
                img_15.setImageResource(cars[Posicoes_rand[14]]);
                break;
            case R.id.cardView16:
                img_16.setImageResource(cars[Posicoes_rand[15]]);
                break;
            case R.id.cardView17:
                img_17.setImageResource(cars[Posicoes_rand[16]]);
                break;
            case R.id.cardView18:
                img_18.setImageResource(cars[Posicoes_rand[17]]);
                break;
            case R.id.cardView19:
                img_19.setImageResource(cars[Posicoes_rand[18]]);
                break;
            case R.id.cardView20:
                img_20.setImageResource(cars[Posicoes_rand[19]]);
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

}
