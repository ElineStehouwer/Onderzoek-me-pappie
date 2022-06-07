package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

public class MeditationListener extends AppCompatActivity {
    private MediaPlayer sound;
    private int soundId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meditation_listener);
        Intent intent = getIntent();
        int meditationId = intent.getIntExtra("ID", -1);
        switch (meditationId) {
            case 1:
                soundId = R.raw.videoplayback;
                break;
            case 2:
                soundId = R.raw.video2;
                break;
            case 3:
                soundId = R.raw.video3;
        }
    }

    public void onStart (View v) {
        if (sound == null) {
            sound = MediaPlayer.create(this, soundId);
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
        if (sound != null) {
            sound.release();
            sound = null;
        }

    }

}