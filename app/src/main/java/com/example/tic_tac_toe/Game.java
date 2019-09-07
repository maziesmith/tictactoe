package com.example.tic_tac_toe;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.view.View;
import android.widget.GridLayout;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;
import android.content.ServiceConnection;

import com.example.rodger.tictactoe.R;

import static com.example.rodger.tictactoe.R.*;


public class Game extends StartNewGame {

    //these are variables that our ENTIRE class can use
    int player1 = 1; //player one starts
    //set a variable to control buttons already pressed
    int TL = 0, TC = 0, TR = 0, CL = 0, C = 0, CR = 0, BL = 0, BC = 0, BR = 0;
    int TL2 = 0, TC2 = 0, TR2 = 0, CL2 = 0, C2 = 0, CR2 = 0, BL2 = 0, BC2 = 0, BR2 = 0;
    int p1score = 0;
    int p2score = 0;

    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //get player names from Start New Game screen
        Bundle sngdata = getIntent().getExtras();
        if (sngdata == null) {
            return;
        }
        String p1name = sngdata.getString("player1name");
        Bundle sngdata2 = getIntent().getExtras();
        if (sngdata2 == null) {
            return;
        }
        String p2name = sngdata2.getString("player2name");


        super.onCreate(savedInstanceState);
        setContentView(layout.activity_game);
        final GridLayout bckscreen = (GridLayout) findViewById(id.screen);
        bckscreen.setBackgroundColor(Color.BLUE);

        //Start service to play background music
        //Intent mServiceIntent = new Intent(this, TTTIntent.class);
        //bckMusic musicOn = new bckMusic();
        //musicOn.playMe(mediaPlayer);
        mediaPlayer = MediaPlayer.create(this, raw.jazzonsg);
        mediaPlayer.start();

        final Button TLbutton = (Button) findViewById(id.topleftbutton);
        final Button TCbutton = (Button) findViewById(id.topcenterbutton);
        final Button TRbutton = (Button) findViewById(id.toprightbutton);
        final Button CLbutton = (Button) findViewById(id.centerleftbutton);
        final Button Cbutton = (Button) findViewById(id.centerbutton);
        final Button CRbutton = (Button) findViewById(id.centerrightbutton);
        final Button BLbutton = (Button) findViewById(id.bottomleftbutton);
        final Button BCbutton = (Button) findViewById(id.bottomcenterbutton);
        final Button BRbutton = (Button) findViewById(id.bottomrightbutton);

        final Wincheck WIN = new Wincheck();

        TLbutton.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        if (player1 == 1 && TL == 0 && TL2 == 0) {
                            TLbutton.setText("X");

                            player1 = 0; //player2's turn
                            TL = 1;
                            bckscreen.setBackgroundColor(Color.YELLOW);

                            WIN.checkWin(TL, TC, TR, CL, C, CR, BL, BC, BR, TL2, TC2, TR2, CL2, C2, CR2, BL2, BC2, BR2);
                        } else if (player1 == 0 && TL2 < 2 && TL != 1) {
                            TLbutton.setText("O");


                            player1 = 1; //player1's turn
                            TL2 = 2;
                            bckscreen.setBackgroundColor(Color.BLUE);
                            WIN.checkWin(TL, TC, TR, CL, C, CR, BL, BC, BR, TL2, TC2, TR2, CL2, C2, CR2, BL2, BC2, BR2);
                        }


                    }
                }

        );


        TCbutton.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {

                        if (player1 == 1 && TC == 0 && TC2 == 0) {
                            TCbutton.setText("X");

                            player1 = 0;
                            TC = 1;
                            bckscreen.setBackgroundColor(Color.YELLOW);
                            WIN.checkWin(TL, TC, TR, CL, C, CR, BL, BC, BR, TL2, TC2, TR2, CL2, C2, CR2, BL2, BC2, BR2);
                        } else if (player1 == 0 && TC2 < 2 && TC != 1) {
                            TCbutton.setText("O");

                            player1 = 1;
                            TC2 = 2;
                            bckscreen.setBackgroundColor(Color.BLUE);
                            WIN.checkWin(TL, TC, TR, CL, C, CR, BL, BC, BR, TL2, TC2, TR2, CL2, C2, CR2, BL2, BC2, BR2);
                        }

                    }
                }
        );


        TRbutton.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        if (player1 == 1 && TR == 0 && TR2 == 0) {
                            TRbutton.setText("X");

                            player1 = 0;
                            TR = 1;
                            bckscreen.setBackgroundColor(Color.YELLOW);
                            WIN.checkWin(TL, TC, TR, CL, C, CR, BL, BC, BR, TL2, TC2, TR2, CL2, C2, CR2, BL2, BC2, BR2);
                        } else if (player1 == 0 && TR2 < 2 && TR != 1) {
                            TRbutton.setText("O");

                            player1 = 1;
                            TR2 = 2;
                            bckscreen.setBackgroundColor(Color.BLUE);
                            WIN.checkWin(TL, TC, TR, CL, C, CR, BL, BC, BR, TL2, TC2, TR2, CL2, C2, CR2, BL2, BC2, BR2);
                        }
                    }
                }
        );


        CLbutton.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        if (player1 == 1 && CL == 0 && CL2 == 0) {
                            CLbutton.setText("X");

                            player1 = 0;
                            CL = 1;
                            bckscreen.setBackgroundColor(Color.YELLOW);
                            WIN.checkWin(TL, TC, TR, CL, C, CR, BL, BC, BR, TL2, TC2, TR2, CL2, C2, CR2, BL2, BC2, BR2);
                        } else if (player1 == 0 && CL2 < 2 && CL != 1) {
                            CLbutton.setText("O");

                            player1 = 1;
                            CL2 = 2;
                            bckscreen.setBackgroundColor(Color.BLUE);
                            WIN.checkWin(TL, TC, TR, CL, C, CR, BL, BC, BR, TL2, TC2, TR2, CL2, C2, CR2, BL2, BC2, BR2);
                        }
                    }
                }
        );


        Cbutton.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        if (player1 == 1 && C == 0 && C2 == 0) {
                            Cbutton.setText("X");

                            player1 = 0;
                            C = 1;
                            bckscreen.setBackgroundColor(Color.YELLOW);
                            WIN.checkWin(TL, TC, TR, CL, C, CR, BL, BC, BR, TL2, TC2, TR2, CL2, C2, CR2, BL2, BC2, BR2);
                        } else if (player1 == 0 && C2 < 2 && C != 1) {
                            Cbutton.setText("O");

                            player1 = 1;
                            C2 = 2;
                            bckscreen.setBackgroundColor(Color.BLUE);
                            WIN.checkWin(TL, TC, TR, CL, C, CR, BL, BC, BR, TL2, TC2, TR2, CL2, C2, CR2, BL2, BC2, BR2);
                        }
                    }
                }
        );


        CRbutton.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        if (player1 == 1 && CR == 0 && CR2 == 0) {
                            CRbutton.setText("X");

                            player1 = 0;
                            CR = 1;
                            bckscreen.setBackgroundColor(Color.YELLOW);
                            WIN.checkWin(TL, TC, TR, CL, C, CR, BL, BC, BR, TL2, TC2, TR2, CL2, C2, CR2, BL2, BC2, BR2);
                        } else if (player1 == 0 && CR2 < 2 && CR != 1) {
                            CRbutton.setText("O");


                            player1 = 1;
                            CR2 = 2;
                            bckscreen.setBackgroundColor(Color.BLUE);
                            WIN.checkWin(TL, TC, TR, CL, C, CR, BL, BC, BR, TL2, TC2, TR2, CL2, C2, CR2, BL2, BC2, BR2);
                        }

                    }
                }

        );

        BLbutton.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        if (player1 == 1 && BL == 0 && BL2 == 0) {
                            BLbutton.setText("X");

                            player1 = 0;
                            BL = 1;
                            bckscreen.setBackgroundColor(Color.YELLOW);
                            WIN.checkWin(TL, TC, TR, CL, C, CR, BL, BC, BR, TL2, TC2, TR2, CL2, C2, CR2, BL2, BC2, BR2);
                        } else if (player1 == 0 && BL2 < 2 && BL != 1) {
                            BLbutton.setText("O");

                            player1 = 1;
                            BL2 = 2;
                            bckscreen.setBackgroundColor(Color.BLUE);
                            WIN.checkWin(TL, TC, TR, CL, C, CR, BL, BC, BR, TL2, TC2, TR2, CL2, C2, CR2, BL2, BC2, BR2);
                        }
                    }
                }
        );


        BCbutton.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        if (player1 == 1 && BC == 0 && BC2 == 0) {
                            BCbutton.setText("X");

                            player1 = 0;
                            BC = 1;
                            bckscreen.setBackgroundColor(Color.YELLOW);
                            WIN.checkWin(TL, TC, TR, CL, C, CR, BL, BC, BR, TL2, TC2, TR2, CL2, C2, CR2, BL2, BC2, BR2);
                        } else if (player1 == 0 && BC2 < 2 && BC != 1) {
                            BCbutton.setText("O");

                            player1 = 1;
                            BC2 = 2;
                            bckscreen.setBackgroundColor(Color.BLUE);
                            WIN.checkWin(TL, TC, TR, CL, C, CR, BL, BC, BR, TL2, TC2, TR2, CL2, C2, CR2, BL2, BC2, BR2);
                        }
                    }
                }
        );


        BRbutton.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        if (player1 == 1 && BR == 0 && BR2 == 0) {
                            BRbutton.setText("X");

                            player1 = 0;
                            BR = 1;
                            bckscreen.setBackgroundColor(Color.YELLOW);
                            WIN.checkWin(TL, TC, TR, CL, C, CR, BL, BC, BR, TL2, TC2, TR2, CL2, C2, CR2, BL2, BC2, BR2);
                        } else if (player1 == 0 && BR2 < 2 && BR != 1) {
                            BRbutton.setText("O");

                            player1 = 1;
                            BR2 = 2;
                            bckscreen.setBackgroundColor(Color.BLUE);
                            WIN.checkWin(TL, TC, TR, CL, C, CR, BL, BC, BR, TL2, TC2, TR2, CL2, C2, CR2, BL2, BC2, BR2);
                        }
                    }
                }
        );

        //Restart button
        final Button restartbutton = (Button) findViewById(id.restartbutton);

        restartbutton.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        TLbutton.setText(" ");
                        TLbutton.setEnabled(true);
                        TCbutton.setText(" ");
                        TCbutton.setEnabled(true);
                        TRbutton.setText(" ");
                        TRbutton.setEnabled(true);
                        CRbutton.setText(" ");
                        CRbutton.setEnabled(true);
                        Cbutton.setText(" ");
                        Cbutton.setEnabled(true);
                        CLbutton.setText(" ");
                        CLbutton.setEnabled(true);
                        BRbutton.setText(" ");
                        BRbutton.setEnabled(true);
                        BCbutton.setText(" ");
                        BCbutton.setEnabled(true);
                        BLbutton.setText(" ");
                        BLbutton.setEnabled(true);

                        TL = 0;
                        TC = 0;
                        TR = 0;
                        CL = 0;
                        C = 0;
                        CR = 0;
                        BL = 0;
                        BC = 0;
                        BR = 0;
                        TL2 = 0;
                        TC2 = 0;
                        TR2 = 0;
                        CL2 = 0;
                        C2 = 0;
                        CR2 = 0;
                        BL2 = 0;
                        BC2 = 0;
                        BR2 = 0;

                        Toast.makeText(getApplicationContext(), "New round!", Toast.LENGTH_LONG).show();
                        bckscreen.setBackgroundColor(Color.WHITE);
                    }
                }
        );

        //Scores Button code
        final Button seescoresButton = (Button) findViewById(id.scorebutton);

        //get player names scores and pass them to the Score view
        final String playername1 = getIntent().getExtras().getString("firstplayername");
        final String playername2 = getIntent().getExtras().getString("secondplayername");
        //get player scores SO FAR and pass them to the Score view

        seescoresButton.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        Intent j = new Intent(Game.this, Score.class);
                        j.putExtra("firstplayername",playername1);
                        j.putExtra("secondplayername",playername2);
                        j.putExtra("player1score",p1score);
                        j.putExtra("player2score",p2score);
                        startActivity(j);
                    }
                }

        );

    }


    //win logic
    public class Wincheck {
        public void checkWin(int TL, int TC, int TR, int CL, int C, int CR, int BL, int BC, int BR, int TL2, int TC2, int TR2, int CL2, int C2, int CR2, int BL2, int BC2, int BR2) {
            int x1, x2, x3, x4, x5, x6, x7, x8, x9;
            int x12, x22, x32, x42, x52, x62, x72, x82, x92;
            final GridLayout bckscreenWIN = (GridLayout) findViewById(id.screen);


            final Button TLbutton = (Button) findViewById(id.topleftbutton);
            final Button TCbutton = (Button) findViewById(id.topcenterbutton);
            final Button TRbutton = (Button) findViewById(id.toprightbutton);
            final Button CLbutton = (Button) findViewById(id.centerleftbutton);
            final Button Cbutton = (Button) findViewById(id.centerbutton);
            final Button CRbutton = (Button) findViewById(id.centerrightbutton);
            final Button BLbutton = (Button) findViewById(id.bottomleftbutton);
            final Button BCbutton = (Button) findViewById(id.bottomcenterbutton);
            final Button BRbutton = (Button) findViewById(id.bottomrightbutton);


            x1 = TL;
            x2 = TC;
            x3 = TR;
            x4 = CL;
            x5 = C;
            x6 = CR;
            x7 = BL;
            x8 = BC;
            x9 = BR;
            x12 = TL2;
            x22 = TC2;
            x32 = TR2;
            x42 = CL2;
            x52 = C2;
            x62 = CR2;
            x72 = BL2;
            x82 = BC2;
            x92 = BR2;

            //transfer player names from Start New Game activity
            String playername1 = getIntent().getExtras().getString("firstplayername");
            String playername2 = getIntent().getExtras().getString("secondplayername");
            //make sure the names of the Strings you pass are the appropriate ones

            if ((x1 + x2 + x3) == 3 || (x4 + x5 + x6) == 3 || (x7 + x8 + x9) == 3 || (x1 + x4 + x7) == 3 || (x1 + x5 + x9) == 3 || (x2 + x5 + x8) == 3 || (x3 + x5 + x7) == 3 || (x3 + x6 + x9) == 3 || (x7 + x5 + x3) == 3) {
                Toast.makeText(getApplicationContext(), "You win " + playername1, Toast.LENGTH_LONG).show();
                bckscreenWIN.setBackgroundColor(Color.YELLOW);

                TLbutton.setEnabled(false);
                TCbutton.setEnabled(false);
                TRbutton.setEnabled(false);
                CLbutton.setEnabled(false);
                Cbutton.setEnabled(false);
                CRbutton.setEnabled(false);
                BLbutton.setEnabled(false);
                BCbutton.setEnabled(false);
                BRbutton.setEnabled(false);

                //increase player 1 score by 1 and display on screen
                p1score += 1;
                TextView score1 = (TextView) findViewById(id.showp1s);
                score1.setText(String.valueOf(p1score));
                //player 2 starts next turn
                player1=0;

            } else if ((x12 + x22 + x32) == 6 || (x42 + x52 + x62) == 6 || (x72 + x82 + x92) == 6 || (x12 + x42 + x72) == 6 || (x12 + x52 + x92) == 6 || (x22 + x52 + x82) == 6 || (x32 + x52 + x72) == 6 || (x32 + x62 + x92) == 6 || (x72 + x52 + x32) == 6) {
                Toast.makeText(getApplicationContext(), "You win " + playername2, Toast.LENGTH_LONG).show();
                bckscreenWIN.setBackgroundColor(Color.BLUE);

                TLbutton.setEnabled(false);
                TCbutton.setEnabled(false);
                TRbutton.setEnabled(false);
                CLbutton.setEnabled(false);
                Cbutton.setEnabled(false);
                CRbutton.setEnabled(false);
                BLbutton.setEnabled(false);
                BCbutton.setEnabled(false);
                BRbutton.setEnabled(false);

                //increase player 2 score by 1 and display on screen
                p2score += 1;
                TextView score2 = (TextView) findViewById(id.showp2s);
                score2.setText(String.valueOf(p2score));
                //player 1 starts next turn
                player1=1;
            }
        }

    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        mediaPlayer.stop();
    }
}




