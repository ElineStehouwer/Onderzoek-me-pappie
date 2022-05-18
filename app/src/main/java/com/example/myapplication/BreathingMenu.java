package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class BreathingMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breathing_exercise);
    }

    public void openBreatingExercise() {
        Intent i = new Intent(this, BreathingExercise.class);
        startActivity(i);
    }

    public void openbreathingExplanation() {
        Intent i = new Intent(this, BreathingExplanation.class);
        startActivity(i);
    }
}