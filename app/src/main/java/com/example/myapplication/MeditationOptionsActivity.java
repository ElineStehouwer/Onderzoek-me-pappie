package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MeditationOptionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meditation_options);
        setTitle("Meditation");
    }

    public void openOneMinSess (View v) {
        Intent i = new Intent(this, oneMinSess.class);
        startActivity(i);
    }

    public void openTwoMinSess (View v) {
        Intent i = new Intent (this, TwoMinSess.class);
        startActivity(i);
    }

    public void openTenMinSess (View v) {
        Intent i = new Intent (this, TenMinSess.class);
        startActivity(i);
    }

    public void openMeditationTips (View v) {
        Intent i = new Intent (this, MeditationTips.class);
        startActivity(i);
    }
}