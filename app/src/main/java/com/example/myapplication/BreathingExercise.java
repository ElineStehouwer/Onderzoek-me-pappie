package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class BreathingExercise extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stress_depression_handling);
    }

    public class openStartBreathing(View v) {
        Intent i = new Intent(this, StartBreathing.class);
        startActivity(i);
        System.out.println("Hello");
    }


}
