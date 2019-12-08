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
    int Carta;
    ImageView Imagem;
    public void Compara_cartas(final int Carta, final ImageView Imagem) {
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
                } else {
                    new CountDownTimer(500, 100) { // 5000 = 5 sec

                        public void onTick(long millisUntilFinished) {
                            Imagem.setImageResource(cars[Carta]);
                        }
    CountDownTimer cTimer = null; //Declare timer

                        public void onFinish() {
                            if(!Cards_Paired.contains(Carta)) {
                                Imagem.setImageResource(R.drawable.carta_back);
                            }
                            if(!Cards_Paired.contains(carta1)) {
                                CartaAnterior.setImageResource(R.drawable.carta_back);
                            }
                        }
                    }.start();


                    carta1 = 100;

                }
            }

        }
    }

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
                Carta=Posicoes_rand[0];
                Imagem=img_1;
                Compara_cartas(Carta, Imagem);
                break;
            case R.id.cardView2:
                Carta=Posicoes_rand[1];
                Imagem=img_2;
                Compara_cartas(Carta, Imagem);
                break;
            case R.id.cardView3:
                Carta=Posicoes_rand[2];
                Imagem=img_3;
                Compara_cartas(Carta, Imagem);
                break;
            case R.id.cardView4:
                Carta=Posicoes_rand[3];
                Imagem=img_4;
                Compara_cartas(Carta, Imagem);
                break;
            case R.id.cardView5:
                Carta=Posicoes_rand[4];
                Imagem=img_5;
                Compara_cartas(Carta, Imagem);
                break;
            case R.id.cardView6:
                Carta=Posicoes_rand[5];
                Imagem=img_6;
                Compara_cartas(Carta, Imagem);
                break;
            case R.id.cardView7:
                Carta=Posicoes_rand[6];
                Imagem=img_7;
                Compara_cartas(Carta, Imagem);
                break;
            case R.id.cardView8:
                Carta=Posicoes_rand[7];
                Imagem=img_8;
                Compara_cartas(Carta, Imagem);
                break;
            case R.id.cardView9:
                Carta=Posicoes_rand[8];
                Imagem=img_9;
                Compara_cartas(Carta, Imagem);
                break;
            case R.id.cardView10:
                Carta=Posicoes_rand[9];
                Imagem=img_10;
                Compara_cartas(Carta, Imagem);
                break;
            case R.id.cardView11:
                Carta=Posicoes_rand[10];
                Imagem=img_11;
                Compara_cartas(Carta, Imagem);
                break;
            case R.id.cardView12:
                Carta=Posicoes_rand[11];
                Imagem=img_12;
                Compara_cartas(Carta, Imagem);
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
        cTimer = new CountDownTimer(5000, 1000) {
            public void onTick(long millisUntilFinished) {
                TextView timer = findViewById(R.id.textTimer);
                timer.setText(String.valueOf((int)(Math.ceil((millisUntilFinished/1000)+1)))); //Calculate time left in seconds and show on TextView
            }
            public void onFinish() {
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
}
