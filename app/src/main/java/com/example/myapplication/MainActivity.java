package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.sql.SQLOutput;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openContacting (View v) {
        Intent i = new Intent(this, ContactingProfessionalsActivity.class);
        startActivity(i);
    }

    public void openSNDmenu (View v) {
        Intent i = new Intent(this, SNDmenu.class);
        startActivity(i);
    }

    public void openEmotionTracker (View v) {
        Intent i = new Intent (this, EmotionTracker.class);
        startActivity(i);
    }

    public void openGoalTracker (View v) {
        Intent i = new Intent (this, GoalTracker.class);
        startActivity(i);
    }

    public void openExamAnxietyHelp(View v) {
        Intent i = new Intent (this, ExamAnxietyHelp.class);
        startActivity(i);
    }
}