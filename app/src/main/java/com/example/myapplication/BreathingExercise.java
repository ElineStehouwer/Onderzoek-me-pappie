package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import java.util.concurrent.TimeUnit;

public class BreathingExercise extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breathing_exercise);
    }

    public int startBreathingTimer(View v) throws InterruptedException {
        ProgressBar pb = findViewById(R.id.ProgressBar);
        int progress = 0;
        int state = 0;
        int cycles = 0;

        while (progress <= pb.getMax() && cycles < 3) {
            pb.setProgress(progress);
            Thread.sleep(0,1000);
            progress++;
            if (progress > (pb.getMax())) {
                state++;
                switch (state) {
                    case 0: // Breathe in (5s)
                        pb.setMax(50);
                        progress = 0;
                        break;
                    case 1: // Hold1 (6s)
                        pb.setMax(6000);
                        progress = 0;
                        break;
                    case 2: // Breathe Out (7s)
                        pb.setMax(7000);
                        progress = 0;
                        break;
                    case 3: // Hold2 (6s)
                        state = 0;
                        cycles++;
                        pb.setMax(6000);
                        progress = 0;
                        break;
                }
            }
        }

        return 0;
    }
}