package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

public class MeditationListener extends AppCompatActivity {
    private MediaPlayer sound;
    private int soundId;  //The id of the R.raw file that holds the
                            // sound corresponding to the ID that was passed with the intent

    /**
     *   Gets the ID that was put with the intent and based on that id give
     *   the soundId the right id value.
     * */
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

    /**
     *   If the start button is pressed, this method is called. Then the
     *   MediaPlayer sound is created using the soundId, if it wasn't already,
     *   and the audio stored in sound is started.
     * */
    public void onStart (View v) {
        if (sound == null) {
            sound = MediaPlayer.create(this, soundId);
        }
        sound.start();
    }


    /**
     *   If the pause button is pressed, this method is called. Then the
     *   MediaPlayer sound is paused, if it wasn't already.
     * */
    public void onPause (View v) {
        if (sound.isPlaying()) {
            sound.pause();
        }
    }


    /**
     *   If the activity is closed, this method is called. Then the
     *   MediaPlayer sound will be released and set to null, if it wasn't
     *   already.
     * */
    public void onStop () {
        super.onStop();
        if (sound != null) {
            sound.release();
            sound = null;
        }

    }

}