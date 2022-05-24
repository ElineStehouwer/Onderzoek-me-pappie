package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

public class BreathingOptions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breathing_options);
    }

    public void openBreathingExercise (View v) {
        Intent i = new Intent ( this, BreathingExercise.class);
        startActivity(i);
    }

    public void openBreathingExplanation (View v) {
        Intent i = new Intent ( this, BreathingExplanation.class);
        startActivity(i);
    }


}