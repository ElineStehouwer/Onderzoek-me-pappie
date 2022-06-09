package com.example.myapplication;


import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;


public class BreathingExercise extends AppCompatActivity {

    ProgressBar pb;
    int counter, state, loops;
    Timer timer;
    TextView text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breathing_exercise);
        setTitle("Breathing");
        counter = 0;
        state =1;
        loops =0;
        timer = new Timer();
        text = (TextView) findViewById(R.id.textView11);
        startTimer();

    }


    public void startTimer() {
        pb = (ProgressBar) findViewById(R.id.ProgressBar);
        pb.setMax(100);
        TimerTask timertask = new TimerTask() {
            @Override
            public void run() {
                counter++;
                pb.setProgress(counter);
                if (counter == 100) {
                    counter = 0;
                    state++;
                    changeText(state);

                }
            }
        };
        timer.schedule(timertask, 0, 100);

    }




    public void changeText(int state) {
        switch (state) {
            case 0: // Breathe In (5s)
//                pb.setMax(90);
                runOnUiThread(new Runnable () {
                    @Override
                    public void run () {
                        text.setText("Breathe In");
                    }
                });
                break;
            case 1: // Hold1 (6s)
//                pb.setMax(100);

                runOnUiThread(new Runnable () {
                    @Override
                    public void run () {
                        text.setText("Hold Your Breath");
                    }
                });
                break;
            case 2: // Breathe Out (7s)
//               pb.setMax(110);
                runOnUiThread(new Runnable () {
                    @Override
                    public void run () {
                        text.setText("Breathe Out");
                    }
                });
                break;
            case 3: // Hold2 (5s)
//                pb.setMax(80);
                this.state = -1;
                loops++;
                runOnUiThread(new Runnable () {
                    @Override
                    public void run () {
                        text.setText("Hold Your Breath");

                    }
                });
                break;
        }

    }
}











//        ProgressBar pb = findViewById(R.id.ProgressBar);
////        int duration = 0;
//        int state = 0;
//        int cycles = 0;
//        int progress = 0;
//
//        pb.setProgress(0);
//        while (progress <= pb.getMax() && cycles < 3) {
//            pb.incrementProgressBy(1);
//            Thread.sleep(1,0);
//            progress++;
//            if (progress > (pb.getMax())) {
//                state++;
//                changeText(state);
//                switch (state) {
//                    case 0: // Breathe in (5s)
//                        pb.setMax(5000);
//                        progress = 0;
//                        pb.setProgress(0,true);
//                        break;
//                    case 1: // Hold1 (6s)
//                        pb.setMax(6000);
//                        progress = 0;
//                        pb.setProgress(0,true);
//                        break;
//                    case 2: // Breathe Out (7s)
//                        pb.setMax(7000);
//                        progress = 0;
//                        pb.setProgress(0,true);
//                        break;
//                    case 3: // Hold2 (6s)
//                        state = 0;
//                        cycles++;
//                        pb.setMax(6000);
//                        progress = 0;
//                        pb.setProgress(0,true);
//                        break;
//                }
//            }
//        }



//        ObjectAnimator animation;
//
//        pb.setMax(duration);
//        pb.setProgress(0);
//
//        while (cycles < 3) {
//            changeText(state);
//
//            switch (state) {
//                case 0: // Breathe in (5s)
//                    duration = 5000;
//                    break;
//                case 1: // Hold1 (6s)
//                    duration = 6000;
//                    break;
//                case 2: // Breathe Out (7s)
//                    duration = 7000;
//                    break;
//                case 3: // Hold2 (6s)
//                    duration = 6000;
//                    cycles++;
//                    break;
//            }
//
//            animation = ObjectAnimator.ofInt(pb, "progress", 1);
//            animation.setDuration(duration);
//            animation.start();
//            state++;
//
//
//        }


