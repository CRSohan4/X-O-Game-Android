package com.example.crsohan.xogamemultiplayer;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Stack;

public class MainActivity extends AppCompatActivity {
    private TextView oneBtn;
    private TextView twoBtn;
    private TextView threeBtn;
    private TextView fourBtn;
    private TextView fiveBtn;
    private TextView sixBtn;
    private TextView sevenBtn;
    private TextView eightBtn;
    private TextView nineBtn;
    private TextView one;
    private TextView two;
    private TextView three;
    private TextView four;
    private TextView five;
    private TextView six;
    private TextView seven;
    private TextView eight;
    private TextView nine;
    private stack stk1;
    private TextView player1;
    private TextView player2;
    private TextView player1Points, player2Points;
    private Button playBtn, rematchBtn;
    static int count = 9;
    static int player1Value = 0;
    static int player2Value = 0;
    static String player1Name = "";
    static String player2Name = "";
    private TextView displayLive;

    private ImageView winRight, winLeft, winOneHorizontal;
    private ImageView winTwoHorizontal, winThreeHorizontal;
    private ImageView winOneVertical, winTwoVertical, winThreeVertical;

    private AlertDialog.Builder dialogBuilder;
    private AlertDialog dialog;
    //for alertDialog box
    private EditText insertPlayer1, insertplayer2;
    private Button letsGoBtn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        oneBtn = findViewById(R.id.oneBtn);
        twoBtn = findViewById(R.id.twoBtn);
        threeBtn = findViewById(R.id.threeBtn);
        fourBtn = findViewById(R.id.fourBtn);
        fiveBtn = findViewById(R.id.fiveBtn);
        sixBtn = findViewById(R.id.sixBtn);
        sevenBtn = findViewById(R.id.sevenBtn);
        eightBtn = findViewById(R.id.eightBtn);
        nineBtn = findViewById(R.id.nineBtn);
        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        four = findViewById(R.id.four);
        five = findViewById(R.id.five);
        six = findViewById(R.id.six);
        seven = findViewById(R.id.seven);
        eight = findViewById(R.id.eight);
        nine = findViewById(R.id.nine);
        player1 = findViewById(R.id.player1);
        player2 = findViewById(R.id.player2);
        player1Points = findViewById(R.id.Player1Points);
        player2Points = findViewById(R.id.player2Points);
        playBtn = findViewById(R.id.startBtn);
        rematchBtn = findViewById(R.id.rematchBtn);
        displayLive = findViewById(R.id.displayLive);
        winLeft = findViewById(R.id.winLeft);
        winRight = findViewById(R.id.winRight);
        winOneHorizontal = findViewById(R.id.winOneHorizontal);
        winTwoHorizontal = findViewById(R.id.winTwoHorizontal);
        winThreeHorizontal = findViewById(R.id.winThreeHorizontal);
        winOneVertical = findViewById(R.id.winOneVertical);
        winTwoVertical = findViewById(R.id.winTwoVertical);
        winThreeVertical = findViewById(R.id.winThreeVertical);

        //addingToStack();
        disableButtons();
        rematchBtnDisable();
        addingToStack();
        disableWinningLines();

        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popup();
            }
        });

        rematchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                disableWinningLines();
                enableButtons();
                clearTextViews();
                displayLive.setText(player1.getText().toString() + "'s" + " turn.");
                count = 9;
            }
        });

        oneBtn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
             //   Toast.makeText(MainActivity.this, "one btn clicked", Toast.LENGTH_SHORT).show();
                StringBuilder str = new StringBuilder();
                str.append(stk1.show(count));
                checkPlayers();
                one.setText(str);
                count --;
                if (oneBtn.hasOnClickListeners()) {
                    oneBtn.setEnabled(false);
                }
                resultCheck();
                //testing stack
//                StringBuilder str = new StringBuilder();
//                for(int i=0;i<10;i++){
//                    str.append(stk.show(i));
//                }
//                player1.setText(str);
            }
        });

        twoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             //   Toast.makeText(MainActivity.this, "two btn clicked", Toast.LENGTH_SHORT).show();
                StringBuilder str = new StringBuilder();
                str.append(stk1.show(count));
                checkPlayers();
                two.setText(str);
                count --;
                if (twoBtn.hasOnClickListeners()) {
                    twoBtn.setEnabled(false);
                }
                resultCheck();
            }
        });

        threeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Toast.makeText(MainActivity.this, "three btn clicked", Toast.LENGTH_SHORT).show();
                StringBuilder str = new StringBuilder();
                str.append(stk1.show(count));
                checkPlayers();
                three.setText(str);
                count --;
                if (threeBtn.hasOnClickListeners()) {
                    threeBtn.setEnabled(false);
                }
                resultCheck();
            }
        });

        fourBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  Toast.makeText(MainActivity.this, "four btn clicked", Toast.LENGTH_SHORT).show();
                StringBuilder str = new StringBuilder();
                str.append(stk1.show(count));
                checkPlayers();
                four.setText(str);
                count --;
                if (fourBtn.hasOnClickListeners()) {
                    fourBtn.setEnabled(false);
                }
                resultCheck();
            }
        });

        fiveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Toast.makeText(MainActivity.this, "five btn clicked", Toast.LENGTH_SHORT).show();
                StringBuilder str = new StringBuilder();
                str.append(stk1.show(count));
                checkPlayers();
                five.setText(str);
                count --;
                if (fiveBtn.hasOnClickListeners()) {
                    fiveBtn.setEnabled(false);
                }
                resultCheck();
            }
        });

        sixBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  Toast.makeText(MainActivity.this, "six btn clicked", Toast.LENGTH_SHORT).show();
                StringBuilder str = new StringBuilder();
                str.append(stk1.show(count));
                checkPlayers();
                six.setText(str);
                count --;
                if (sixBtn.hasOnClickListeners()) {
                    sixBtn.setEnabled(false);
                }
                resultCheck();
            }
        });

        sevenBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  Toast.makeText(MainActivity.this, "seven btn clicked", Toast.LENGTH_SHORT).show();
                StringBuilder str = new StringBuilder();
                str.append(stk1.show(count));
                checkPlayers();
                seven.setText(str);
                count --;
                if (sevenBtn.hasOnClickListeners()) {
                    sevenBtn.setEnabled(false);
                }
                resultCheck();
            }
        });

        eightBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  Toast.makeText(MainActivity.this, "eight btn clicked", Toast.LENGTH_SHORT).show();
                StringBuilder str = new StringBuilder();
                str.append(stk1.show(count));
                checkPlayers();
                eight.setText(str);
                count --;
                if (eightBtn.hasOnClickListeners()) {
                    eightBtn.setEnabled(false);
                }
                resultCheck();
            }
        });



        nineBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             //   Toast.makeText(MainActivity.this, "nine btn clicked", Toast.LENGTH_SHORT).show();
                StringBuilder str = new StringBuilder();
                str.append(stk1.show(count));
                checkPlayers();
                nine.setText(str);
                count --;
                if (nineBtn.hasOnClickListeners()) {
                    nineBtn.setEnabled(false);
                }
                resultCheck();
            }
        });

    }

    private void popup() {
        dialogBuilder = new AlertDialog.Builder(this);
        View view = getLayoutInflater().inflate(R.layout.enter_names,null);
        insertPlayer1 = view.findViewById(R.id.firstPlayerName);
        insertplayer2 = view.findViewById(R.id.secondPlayerName);
        letsGoBtn = view.findViewById(R.id.letsGoBtn);

        dialogBuilder.setView(view);
        dialog = dialogBuilder.show();

        letsGoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player1Name = insertPlayer1.getText().toString();
                player2Name = insertplayer2.getText().toString();
                if(insertPlayer1.getText().toString().equals("")) {
                    player1.setText("Player 1");
                }else{
                    player1.setText(player1Name.toString());
                }
                if (insertplayer2.getText().toString().equals("")) {
                    player2.setText("Player 2");
                }else {
                    player2.setText(player2Name.toString());
                }
                displayLive.setText(player1.getText().toString() + "'s" + " turn.");
                enableButtons();
                rematchBtnEnable();
                playBtn.setEnabled(false);
                dialog.cancel();
            }
        });
    }

    private void addingToStack() {
        stk1 = new stack();
        stk1.push('O');
        stk1.push('X');
        stk1.push('O');
        stk1.push('X');
        stk1.push('O');
        stk1.push('X');
        stk1.push('O');
        stk1.push('X');
        stk1.push('O');

    }



    private void resultCheck(){
        String ones = one.getText().toString();
        String twos = two.getText().toString();
        String threes = three.getText().toString();
        String fours = four.getText().toString();
        String fives = five.getText().toString();
        String sixs = six.getText().toString();
        String sevens = seven.getText().toString();
        String eights = eight.getText().toString();
        String nines = nine.getText().toString();

        if(ones.equals("O") && twos.equals("O") && threes.equals("O")){
            //player1 wins
            disableButtons();
            incPlayer1Points();
            winOneHorizontal.setVisibility(View.VISIBLE);
            displayLive.setText(player1.getText().toString() + " Wins...");

        }else if(fours.equals("O") && fives.equals("O") && sixs.equals("O")){
            //player1 wins
            disableButtons();
            incPlayer1Points();
            winTwoHorizontal.setVisibility(View.VISIBLE);
            displayLive.setText(player1.getText().toString() + " Wins...");


        }else if(sevens.equals("O") && eights.equals("O") && nines.equals("O")){
            //player1 wins
            disableButtons();
            incPlayer1Points();
            winThreeHorizontal.setVisibility(View.VISIBLE);
            displayLive.setText(player1.getText().toString() + " Wins...");


        }else if(ones.equals("O") && fours.equals("O") && sevens.equals("O")){
            //player1 wins
            disableButtons();
            incPlayer1Points();
            winOneVertical.setVisibility(View.VISIBLE);
            displayLive.setText(player1.getText().toString() + " Wins...");


        }else if(twos.equals("O") && fives.equals("O") && eights.equals("O")){
            //player1 wins
            disableButtons();
            incPlayer1Points();
            winTwoVertical.setVisibility(View.VISIBLE);
            displayLive.setText(player1.getText().toString() + " Wins...");


        }else if(threes.equals("O") && sixs.equals("O") && nines.equals("O")){
            //player1 wins
            disableButtons();
            incPlayer1Points();
            winThreeVertical.setVisibility(View.VISIBLE);
            displayLive.setText(player1.getText().toString() + " Wins...");


        }else if(ones.equals("O") && fives.equals("O") && nines.equals("O")){
            //player1 wins
            disableButtons();
            incPlayer1Points();
            winRight.setVisibility(View.VISIBLE);
            displayLive.setText(player1.getText().toString() + " Wins...");


        }else if(threes.equals("O") && fives.equals("O") && sevens.equals("O")){
            //player1 wins
            disableButtons();
            incPlayer1Points();
            winLeft.setVisibility(View.VISIBLE);
            displayLive.setText(player1.getText().toString() + " Wins...");


        }else{
            if(ones.equals("X") && twos.equals("X") && threes.equals("X")){
                //player2 wins
                disableButtons();
                incPlayer2Points();
                winOneHorizontal.setVisibility(View.VISIBLE);
                displayLive.setText(player2.getText().toString() + " Wins...");


            }else if(fours.equals("X") && fives.equals("X") && sixs.equals("X")){
                //player2 wins
                disableButtons();
                incPlayer2Points();
                winTwoHorizontal.setVisibility(View.VISIBLE);
                displayLive.setText(player2.getText().toString() + " Wins...");


            }else if(sevens.equals("X") && eights.equals("X") && nines.equals("X")){
                //player2 wins
                disableButtons();
                incPlayer2Points();
                winThreeHorizontal.setVisibility(View.VISIBLE);
                displayLive.setText(player2.getText().toString() + " Wins...");


            }else if(ones.equals("X") && fours.equals("X") && sevens.equals("X")){
                //player2 wins
                disableButtons();
                incPlayer2Points();
                winOneVertical.setVisibility(View.VISIBLE);
                displayLive.setText(player2.getText().toString() + " Wins...");


            }else if(twos.equals("X") && fives.equals("X") && eights.equals("X")){
                //player2 wins
                disableButtons();
                incPlayer2Points();
                winTwoVertical.setVisibility(View.VISIBLE);
                displayLive.setText(player2.getText().toString() + " Wins...");


            }else if(threes.equals("X") && sixs.equals("X") && nines.equals("X")){
                //player2 wins
                disableButtons();
                incPlayer2Points();
                winThreeVertical.setVisibility(View.VISIBLE);
                displayLive.setText(player2.getText().toString() + " Wins...");

            }else if(ones.equals("X") && fives.equals("X") && nines.equals("X")){
                //pleyer2 wins
                disableButtons();
                incPlayer2Points();
                winRight.setVisibility(View.VISIBLE);
                displayLive.setText(player2.getText().toString() + " Wins...");


            }else if(threes.equals("X") && fives.equals("X") && sevens.equals("X")){
                //player2 wins
                disableButtons();
                incPlayer2Points();
                winLeft.setVisibility(View.VISIBLE);
                displayLive.setText(player2.getText().toString() + " Wins...");

            }
        }
    }

    private void disableButtons(){
        oneBtn.setEnabled(false);
        twoBtn.setEnabled(false);
        threeBtn.setEnabled(false);
        fourBtn.setEnabled(false);
        fiveBtn.setEnabled(false);
        sixBtn.setEnabled(false);
        sevenBtn.setEnabled(false);
        eightBtn.setEnabled(false);
        nineBtn.setEnabled(false);

    }

    private void enableButtons(){
        oneBtn.setEnabled(true);
        twoBtn.setEnabled(true);
        threeBtn.setEnabled(true);
        fourBtn.setEnabled(true);
        fiveBtn.setEnabled(true);
        sixBtn.setEnabled(true);
        sevenBtn.setEnabled(true);
        eightBtn.setEnabled(true);
        nineBtn.setEnabled(true);
    }

    private void clearTextViews(){
        one.setText("");
        two.setText("");
        three.setText("");
        four.setText("");
        five.setText("");
        six.setText("");
        seven.setText("");
        eight.setText("");
        nine.setText("");
    }

    private void incPlayer1Points(){
        player1Value = player1Value + 1;
        player1Points.setText(String.valueOf(player1Value));
    }

    private void incPlayer2Points(){
        player2Value = player2Value + 1;
        player2Points.setText(String.valueOf(player2Value));
    }

    private void checkPlayers(){
        if(stk1.show(count) == 'X') {
            if (count >1) {
                displayLive.setText(player1.getText().toString() + "'s" + " turn.");

            }
            else {
                //if (!displayLive.getText().toString().equals(player1.getText().toString() + "'s" + " Wins...")) {
                    displayLive.setText("Draw");
                //}
            }

        }else {
            if (count >1) {
                displayLive.setText(player2.getText().toString() + "'s" + " turn.");

            } else {
               // if (!displayLive.getText().toString().equals(player2.getText().toString() + "'s" + " Wins...")) {
                    displayLive.setText("Draw");
               // }
            }
        }
    }

    private void rematchBtnDisable(){
        rematchBtn.setEnabled(false);
    }

    private void rematchBtnEnable(){
        rematchBtn.setEnabled(true);
    }

    //Winning lines
    private void disableWinningLines(){
        winRight.setVisibility(View.INVISIBLE);
        winLeft.setVisibility(View.INVISIBLE);
        winOneHorizontal.setVisibility(View.INVISIBLE);
        winTwoHorizontal.setVisibility(View.INVISIBLE);
        winThreeHorizontal.setVisibility(View.INVISIBLE);
        winOneVertical.setVisibility(View.INVISIBLE);
        winTwoVertical.setVisibility(View.INVISIBLE);
        winThreeVertical.setVisibility(View.INVISIBLE);
    }

    //menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        getMenuInflater().inflate(R.menu.reset_btn, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);

        switch(item.getItemId()){
            case R.id.reset_btn:
                player1Points.setText("0");
                player2Points.setText("0");
                player1.setText("Player 1");
                player2.setText("Player 2");
                clearTextViews();
                disableButtons();
                disableWinningLines();
                count = 9;

                popup();

        }
        return true;
    }
}
