package com.example.tic_tac_toe;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.rodger.tictactoe.R;

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
        nameArr.add(getIntent().getExtras().getString("firstplayername") + " wins: " + getIntent().getExtras().getInt("player1score") + " vs " + getIntent().getExtras().getString("secondplayername") + " wins: " + getIntent().getExtras().getInt("player2score"));
        score_lv.setAdapter(arrayAdapter);

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
