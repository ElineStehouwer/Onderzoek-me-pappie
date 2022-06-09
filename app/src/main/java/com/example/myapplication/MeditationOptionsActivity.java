package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MeditationOptionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meditation_options);
        setTitle("Meditation");
    }

    /**
     *   Opens MeditationListener activity and adds the right ID
     *   corresponding to the text on the button that was clicked on.
     * */
    public void openMeditation(View v) {
        Button button = (Button) v;
        Intent i = new Intent(this, MeditationListener.class);
        switch(button.getText().toString()) {
            case "1-Minute Session":
                i.putExtra("ID", 1);
                break;
            case "5-Minute Session":
                i.putExtra("ID", 2);
                break;
            case "10-Minute Session":
                i.putExtra("ID", 3);
                break;
        }
        startActivity(i);
    }

    public void openMeditationTips (View v) {
        Intent i = new Intent (this, MeditationTips.class);
        startActivity(i);
    }
}