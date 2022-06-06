package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Jokes extends AppCompatActivity {

    private String[] jokes;
    private TextView joke;
    private int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jokes);
        index = 0;
        jokes = getResources().getStringArray(R.array.jokes);
        joke = (TextView) findViewById(R.id.joke);
        joke.setText(jokes[0]);
    }

    public void onNext (View v) {
        index++;
        if (index < jokes.length) {
            joke.setText(jokes[index]);
        }
        else {
            new AlertDialog.Builder(Jokes.this)
                    .setTitle("You have seen all of our jokes.")
                    .setMessage("Do you want to go to the beginning, or go back to the distraction?")
                    .setPositiveButton("Beginning", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            index =0;
                            joke.setText(jokes[index]);
                        }
                    })
                    .setNegativeButton("Go back", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent intent = new Intent(Jokes.this, ExamDistraction.class);
                            startActivity(intent);
                        }
                    }).show();
        }
    }
}