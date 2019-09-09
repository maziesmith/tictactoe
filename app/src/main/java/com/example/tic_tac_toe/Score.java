package com.example.tic_tac_toe;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.rodger.tictactoe.R;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Score extends StartNewGame {

    private static final List nameArr = new ArrayList<Object>();
    private ListView score_lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        score_lv = (ListView) findViewById(R.id.scoreList);
        //Set up list
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nameArr);

        //read data from Saved File to update the ListView with ALL items from the file
        nameArr.clear();
        readFile(fileName);
//        nameArr.add(readFile(fileName));
        score_lv.setAdapter(arrayAdapter);

        /*
        //Append match score and names to the score list
        nameArr.add(getIntent().getExtras().getString("firstplayername") + " wins: " + getIntent().getExtras().getInt("player1score") + " vs " + getIntent().getExtras().getString("secondplayername") + " wins: " + getIntent().getExtras().getInt("player2score"));
        score_lv.setAdapter(arrayAdapter);
        */

        //Clear Scores button
        final Button clearButton = findViewById(R.id.ClearScorebutton);

        clearButton.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        //delete Scores file
                        deleteFile(fileName);
                        Toast.makeText(getBaseContext(), "List Cleared", Toast.LENGTH_LONG).show();
                        //clear List display
                        nameArr.clear();
                        score_lv.setAdapter(null);
                    }
                });

    }

    //as soon as this Activity starts, we read from the Output File
    public String readFile(String file){
        StringBuilder text = new StringBuilder();
        try{
            FileInputStream fis = openFileInput(file);
            BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
            String line;

            while((line = reader.readLine()) != null){
//                text.insert(0,line);
//                text.insert(0,'\n');
                nameArr.add(0,line);
            }
            reader.close();
        }catch(Exception e){
            e.printStackTrace();
            Toast.makeText(Score.this,"Error retrieving Scores file!",Toast.LENGTH_LONG).show();
        }
        return text.toString();
    }
}
