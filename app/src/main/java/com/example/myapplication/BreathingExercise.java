package com.example.myapplication;


import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;



public class BreathingExercise extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breathing_exercise);
        setTitle("Breathing");
    }


    public int startBreathingTimer(View v) throws InterruptedException {
        int state = 0;
        for (int i = 0; i < 600000000; i++) {
            changeText(state);
            Thread.sleep(6000);
            state++;
        }

        return 0;
    }

    public void changeText(int state) {
        TextView text = findViewById(R.id.textView11);
        switch (state) {
            case 0: // Breathe In
                text.setText("Breathe In");
                break;
            case 1: // Hold1
                text.setText("Hold Your Breath");
                break;
            case 2: // Breathe Out
                text.setText("Breathe Out");
                break;
            case 3: // Hold2
                text.setText("Hold Your Breath");
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


