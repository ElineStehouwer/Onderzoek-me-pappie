package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ExamAnxietyHelp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam_anxiety_help);
    }

    public void openEverything (View v) {
        Class someClass = null;
        Button button = (Button) v;
        switch (button.getText().toString()) {
            case "Meditation":
                someClass = MeditationOptionsActivity.class;
                break;
            case "Tips":
                someClass = ExamTips.class;
                break;
            case "Distraction":
                someClass = ExamDistraction.class;
                break;
        }
        Intent i = new Intent(this, someClass);
        startActivity(i);
    }

}