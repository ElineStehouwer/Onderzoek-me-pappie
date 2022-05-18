package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class StressNDepressedMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stress_ndepressed_menu);
    }


    public void openMeditation (View v) {
        Intent i = new Intent(this, MeditationOptions.class);
        startActivity(i);
    }

    public void openBreathing (View v) {
        Intent i = new Intent ( this, BreathingMenu.class);
        startActivity(i);
    }
}