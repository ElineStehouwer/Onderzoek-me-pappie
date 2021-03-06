package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SNDmenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sndmenu);
        setTitle("Stress & Depression Handling");
    }

    public void openMeditation (View v) {
        Intent i = new Intent(this, MeditationOptionsActivity.class);
        startActivity(i);
    }

    public void openBreathing (View v) {
        Intent i = new Intent ( this, BreathingOptions.class);
        startActivity(i);
    }

    public void openJournal (View v) {
        Intent i = new Intent (this, Journal.class);
        startActivity(i);
    }
}