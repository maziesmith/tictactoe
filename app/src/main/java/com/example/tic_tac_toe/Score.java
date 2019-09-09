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

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        score_lv = (ListView) findViewById(R.id.scoreList);
        //Set up list
        List<String> nameArr = new ArrayList<String>();
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nameArr);


        //Append match score and names to the score list
        try {
            if(getIntent().getExtras().getString("firstplayername").length()>0 && getIntent().getExtras().getString("secondplayername").length()>0 && getIntent().getExtras().getInt("player1score") >= 0 && getIntent().getExtras().getInt("player2score")>=0) {

                nameArr.add(getIntent().getExtras().getString("firstplayername") + " wins: " + getIntent().getExtras().getInt("player1score") + " vs " + getIntent().getExtras().getString("secondplayername") + " wins: " + getIntent().getExtras().getInt("player2score"));
                score_lv.setAdapter(arrayAdapter);
            }else{
nameArr.add("No scores to display");
                score_lv.setAdapter(arrayAdapter);
            }

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
                        score_lv.setAdapter(null);
                    }
                });

    }
}
