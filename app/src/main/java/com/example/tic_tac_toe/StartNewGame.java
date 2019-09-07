package com.example.tic_tac_toe;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.app.IntentService;
import android.app.Service;
import android.content.Intent;

import com.example.rodger.tictactoe.R;
import static com.example.rodger.tictactoe.R.id.p1name;
import static com.example.rodger.tictactoe.R.id.p2name;


public class StartNewGame extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_new_game);
        final Button start = (Button) findViewById(R.id.startgamebutton);

        //get player names and pass them to the actual game

        final EditText P1 = (EditText)findViewById(p1name);
        final EditText P2 = (EditText)findViewById(p2name);

        ImageView image = (ImageView) findViewById(R.id.gifimage);
        image.setImageResource(R.drawable.getready2);


        start.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        //get player names and pass them to the actual game
                        String p1n = P1.getText().toString();
                        String p2n = P2.getText().toString();
                        Intent i = new Intent(StartNewGame.this, Game.class);
                        i.putExtra("firstplayername",p1n);
                        i.putExtra("secondplayername",p2n);
                        startActivity(i);
                    }
                }
        );

    }
    //For the upper menu bar to display Help and About
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.your_menu, menu);
        return true;
    }
    //For Action bar menu items
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.help:{
                final Dialog dialog = new Dialog(this);
                dialog.setContentView(R.layout.dialog_demo);
                dialog.setTitle("Need help?");
                dialog.show();
                break;
            }
            case R.id.about: {
                //Perform your click operation
                AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
                builder1.setMessage("This TicTacToe app game was made with much love. I hope you enjoy it!!!");
                builder1.setCancelable(true);

                builder1.setPositiveButton(
                        "Close",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

                AlertDialog alert11 = builder1.create();
                alert11.show();
                break;
            }

        }
        return super.onOptionsItemSelected(item);
    }
}
