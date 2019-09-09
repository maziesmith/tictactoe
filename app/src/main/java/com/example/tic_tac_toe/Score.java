package com.example.tic_tac_toe;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.app.AlertDialog;


import com.example.rodger.tictactoe.R;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

public class Score extends StartNewGame {
    private ListView score_lv;
    private static List<String> nameArr = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        score_lv = (ListView) findViewById(R.id.scoreList);
        //Set up list

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nameArr);

        try {
        //Append match score and names to the score list
        nameArr.add(0, getIntent().getExtras().getString("firstplayername") + " wins: " + getIntent().getExtras().getInt("player1score") + " vs " + getIntent().getExtras().getString("secondplayername") + " wins: " + getIntent().getExtras().getInt("player2score"));
            score_lv.setAdapter(arrayAdapter);


        }catch (Exception e){
            AlertDialog alertDialog = new AlertDialog.Builder(this).create();
            alertDialog.setTitle("Something went wrong...");
//            StringWriter sw = new StringWriter();
//            e.printStackTrace(new PrintWriter(sw));
//            String exceptionAsString = sw.toString();
//            alertDialog.setMessage(exceptionAsString);
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alertDialog.show();

        }


        //Clear Scores button
        final Button clearButton = findViewById(R.id.ClearScorebutton);

        clearButton.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        score_lv = (ListView) findViewById(R.id.scoreList);
                        nameArr.clear();
                        score_lv.setAdapter(null);
                    }
                });

    }
}
