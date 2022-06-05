package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

public class TenMinSess extends AppCompatActivity {

    MediaPlayer sound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ten_min_sess);
    }

    public void onStart (View v) {
        if (sound == null) {
            sound = MediaPlayer.create(this, R.raw.video3);
        }
        sound.start();
    }

    public void onPause (View v) {
        if (sound.isPlaying()) {
            sound.pause();
        }
    }

    public void onStop () {
        super.onStop();
        sound.release();
        sound = null;
    }

}