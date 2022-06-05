package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ExamAnxietyHelp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam_anxiety_help);
    }

    public void openMeditation(View v) {
        Intent i = new Intent(this, MeditationOptionsActivity.class);
        startActivity(i);
    }

    public void openTips (View v) {
        Intent i = new Intent(this, ExamTips.class);
        startActivity(i);
    }

    public void openDistraction (View v) {
        Intent i = new Intent(this, ExamDistraction.class);
        startActivity(i);
    }
}