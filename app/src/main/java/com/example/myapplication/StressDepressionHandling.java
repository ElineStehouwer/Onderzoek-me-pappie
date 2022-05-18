package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class StressDepressionHandling extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stress_depression_handling);
    }
    public void openBreathing(View v) {
        Intent i = new Intent(this, BreathingExercise.class);
        startActivity(i);
        System.out.println("Hello");
    }
}