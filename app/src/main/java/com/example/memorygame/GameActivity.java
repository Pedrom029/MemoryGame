package com.example.memorygame;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameActivity extends AppCompatActivity {
    String choosenTheme = UsernameActivity.theme;
    boolean isSinglePlayer = UsernameActivity.singlePlayer;
    int[] randomPos;
    int pairs =0;
    int card1 =100;
    int pairsNeeded =10;
    List<Integer> cardsPaired = new ArrayList<>();
    ImageView lastCard = null;
    int wait =0;
    CountDownTimer cTimer = null; //Declare timer
    int card;
    ImageView image;
    int [] positions;
    int Player=0;
    int [] correctPairs = new int[2]; //pairs correct per player
    int [] wrongPairs = new int [2]; //pairs wrong per player
    int[] theme={};
    final int[] cars={R.drawable.alfaromeo, R.drawable.bmw, R.drawable.ferrari, R.drawable.mazda, R.drawable.honda, R.drawable.mercedes, R.drawable.nissan, R.drawable.toyota, R.drawable.volkswagen, R.drawable.subaru};
    final int[] networks={R.drawable.facebook, R.drawable.googleplus, R.drawable.instagram, R.drawable.linkedin, R.drawable.pinterest, R.drawable.snapchat, R.drawable.twitter, R.drawable.whatsapp, R.drawable.youtube, R.drawable.vkontakte};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        LinearLayout llayout5 = findViewById(R.id.lineView5);
        LinearLayout llayout4 = findViewById(R.id.lineView4);

        final LinearLayout Linear_l=findViewById(R.id.linearLayout);
        //img_1.setImageResource(cars[0]);
        if("cars".equals(choosenTheme)){
            theme=cars;
        }
        if("networks".equals(choosenTheme)){
            theme=networks;
        }


        if(UsernameActivity.hardness.equals("easy")){
            llayout5.setVisibility(View.GONE);
            llayout4.setVisibility(View.GONE);
            positions = new int[] {0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5};
            pairsNeeded =6;
            initializeGame(positions);
        }
        else if(UsernameActivity.hardness.equals("medium")){
            llayout5.setVisibility(View.GONE);
            positions = new int[] {0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7};
            pairsNeeded =8;
            initializeGame(positions);
        }
        else if(UsernameActivity.hardness.equals("hard")){
            positions = new int[] {0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9};
            pairsNeeded =10;
            initializeGame(positions);
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

    public void initializeGame(int[] positions){
        cardsPaired.clear();
        wait=0;
        pairs=0;
        card1=100;
        lastCard=null;
        randomPos = randomizeArray(positions);
        correctPairs[0]=0;
        correctPairs[1]=0;
        wrongPairs[0] = 0;
        wrongPairs[1] = 0;

        //Os id de todas as image views
        final int[] imagens={R.id.cardView1,R.id.cardView2,R.id.cardView3,R.id.cardView4,R.id.cardView5,R.id.cardView6,
                R.id.cardView7,R.id.cardView8,R.id.cardView9,R.id.cardView10,R.id.cardView11,R.id.cardView12,
                R.id.cardView13,R.id.cardView14,R.id.cardView15,R.id.cardView16,R.id.cardView17,R.id.cardView18,
                R.id.cardView19,R.id.cardView20};
        new CountDownTimer(1000, 100) {

            public void onTick(long millisUntilFinished) {
                for(int i = 0; i< randomPos.length; i++) {
                    image =findViewById(imagens[i]);
                    image.setImageResource(theme[randomPos[i]]);
                }
            }

            public void onFinish() {
                for(int i = 0; i< randomPos.length; i++) {
                    image =findViewById(imagens[i]);
                    image.setEnabled(true);
                    image.setImageResource(R.drawable.carta_back);
                }
            }
        }.start();

    }

    public void compareCards(final int card, final ImageView image) {
        if(wait ==0 && !cardsPaired.contains(card)) {
            //if (!cardsPaired.contains(card)) {
            if (card1 == 100) {
                card1 = card;
                lastCard = image;
                image.setImageResource(theme[card]);
            } else {
                if ((card1 == card) && (lastCard != image)) {
                    image.setImageResource(theme[card]);
                    cardsPaired.add(card);
                    image.setEnabled(false);
                    lastCard.setEnabled(false);
                    pairs = pairs +1;
                    correctPairs[Player] += 1;
                    if (pairsNeeded == pairs){
                        String dialogMessage = "";
                        if (cTimer != null) cTimer.cancel();
                        int pointsPlayer0 = calculateScore((double)wrongPairs[0],correctPairs[0]);
                        saveScore(MainActivity.m_userName1,pointsPlayer0);
                        dialogMessage = MainActivity.m_userName1 + ": " + pointsPlayer0 + " points";
                        if (!isSinglePlayer) {
                            saveScore(MainActivity.m_userName2,calculateScore((double)wrongPairs[0],correctPairs[0]));
                            int pointsPlayer1 = calculateScore((double)wrongPairs[1],correctPairs[1]);
                            dialogMessage += "\n" + MainActivity.m_userName2 + ": " + pointsPlayer1 + " points";
                        }
                        new AlertDialog.Builder(GameActivity.this)
                                .setTitle("Game finished!!")
                                .setMessage(dialogMessage)
                                .setPositiveButton("Exit", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        GameActivity.this.finish();
                                    }
                                }).create().show();
                    }
                } else {
                    new CountDownTimer(300, 100) { // 5000 = 5 sec

                        public void onTick(long millisUntilFinished) {
                            image.setImageResource(theme[card]);
                            wait = 1;
                        }

                        public void onFinish() {
                            wrongPairs[Player] += 1;
                            if(Player==1){
                                Player=0;
                            }
                            else{
                                Player=1;
                            }
                            if (!cardsPaired.contains(card)) {
                                image.setImageResource(R.drawable.carta_back);
                            }
                            if (!cardsPaired.contains(card1)) {
                                lastCard.setImageResource(R.drawable.carta_back);
                            }
                            wait = 0;
                        }
                    }.start();
                }
                card1 = 100;
            }
            //}
        }
    }


    public void onClick(View view){
        switch (view.getId()){
            case R.id.cardView1:
                card = randomPos[0];
                image =findViewById(R.id.cardView1);
                compareCards(card, image);
                break;
            case R.id.cardView2:
                card = randomPos[1];
                image =findViewById(R.id.cardView2);
                compareCards(card, image);
                break;
            case R.id.cardView3:
                card = randomPos[2];
                image =findViewById(R.id.cardView3);
                compareCards(card, image);
                break;
            case R.id.cardView4:
                card = randomPos[3];
                image =findViewById(R.id.cardView4);
                compareCards(card, image);
                break;
            case R.id.cardView5:
                card = randomPos[4];
                image =findViewById(R.id.cardView5);
                compareCards(card, image);
                break;
            case R.id.cardView6:
                card = randomPos[5];
                image =findViewById(R.id.cardView6);
                compareCards(card, image);
                break;
            case R.id.cardView7:
                card = randomPos[6];
                image =findViewById(R.id.cardView7);
                compareCards(card, image);
                break;
            case R.id.cardView8:
                card = randomPos[7];
                image =findViewById(R.id.cardView8);
                compareCards(card, image);
                break;
            case R.id.cardView9:
                card = randomPos[8];
                image =findViewById(R.id.cardView9);
                compareCards(card, image);
                break;
            case R.id.cardView10:
                card = randomPos[9];
                image =findViewById(R.id.cardView10);
                compareCards(card, image);
                break;
            case R.id.cardView11:
                card = randomPos[10];
                image =findViewById(R.id.cardView11);
                compareCards(card, image);
                break;
            case R.id.cardView12:
                card = randomPos[11];
                image =findViewById(R.id.cardView12);
                compareCards(card, image);
                break;
            case R.id.cardView13:
                card = randomPos[12];
                image =findViewById(R.id.cardView13);
                compareCards(card, image);
                break;
            case R.id.cardView14:
                card = randomPos[13];
                image =findViewById(R.id.cardView14);
                compareCards(card, image);
                break;
            case R.id.cardView15:
                card = randomPos[14];
                image =findViewById(R.id.cardView15);
                compareCards(card, image);
                break;
            case R.id.cardView16:
                card = randomPos[15];
                image =findViewById(R.id.cardView16);
                compareCards(card, image);
                break;
            case R.id.cardView17:
                card = randomPos[16];
                image =findViewById(R.id.cardView17);
                compareCards(card, image);
                break;
            case R.id.cardView18:
                card = randomPos[17];
                image =findViewById(R.id.cardView18);
                compareCards(card, image);
                break;
            case R.id.cardView19:
                card = randomPos[18];
                image =findViewById(R.id.cardView19);
                compareCards(card, image);
                break;
            case R.id.cardView20:
                card = randomPos[19];
                image =findViewById(R.id.cardView20);
                compareCards(card, image);
                break;

        }
    }

    public static int[] randomizeArray(int[] array){
        Random rgen = new Random();  // Random number generator

        for (int i=0; i<array.length; i++) {
            int randomPosition = rgen.nextInt(array.length);
            int temp = array[i];
            array[i] = array[randomPosition];
            array[randomPosition] = temp;
        }

        return array;
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

    //calculate scores function
    private int calculateScore(double wrong, int correct){
        double hardnessFactor = 0;
        if (UsernameActivity.hardness.equals("easy")) hardnessFactor = 10;
        if (UsernameActivity.hardness.equals("medium")) hardnessFactor = 25;
        if (UsernameActivity.hardness.equals("hard")) hardnessFactor = 50;
        if (wrong == 0) wrong = 0.5;
        TextView timeView = findViewById(R.id.textTimer);
        Double calculatedScore = ((double)correct/wrong)* (Double.parseDouble(timeView.getText().toString())+hardnessFactor);
        return (int) Math.ceil(calculatedScore);
    }

    //save scores function
    private void saveScore(String userName, int score) {

        SharedPreferences scores = getSharedPreferences(UsernameActivity.hardness, Context.MODE_PRIVATE);
        SharedPreferences.Editor editorScores = scores.edit();

        int scorePos = 0; //score to be tested
        String namePos = "";

        for (int i = 1; i<11;i++){
            namePos = scores.getString(String.valueOf(i), null);
            if (namePos != null){
                scorePos = Integer.parseInt(namePos.substring(namePos.indexOf(",")+1));
                namePos = namePos.substring(0,namePos.indexOf(","));
            }
            else{
                i = 11;
            }
            if (userName.equals(namePos)){
                if (scorePos < score){
                    editorScores.putString(String.valueOf(i), namePos + "," + score);
                }
                score = 0;
                i = 11;
            }
        }
        if (score > 0) {
            for (int i = 1; i < 11; i++) {
                namePos = scores.getString(String.valueOf(i), null);
                if (namePos == null) {
                    editorScores.putString(String.valueOf(i), userName + "," + score);
                    //editorScores.apply();
                    i = 11;
                } else {
                    scorePos = Integer.parseInt(namePos.substring(namePos.indexOf(",")+1));
                    if (scorePos < score) {
                        if (i == 10) {
                            editorScores.putString(String.valueOf(i), userName + "," + score);
                        } else {
                            for (int j = 9; i < j + 1; j--) {
                                namePos = scores.getString(String.valueOf(j),null);
                                if (namePos != null){
                                    scorePos = Integer.parseInt(namePos.substring(namePos.indexOf(",") + 1));
                                    namePos = namePos.substring(0, namePos.indexOf(","));
                                    editorScores.putString(String.valueOf(j + 1), namePos + "," + scorePos);
                                }
                            }
                            editorScores.putString(String.valueOf(i), userName + "," + score);
                        }
                        i = 11;
                    }
                }
            }
        }
        editorScores.apply();
    }
}
