package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openContacting (View v) {
        Intent i = new Intent(this, ContactingProfessionalsActivity.class);
        startActivity(i);
        System.out.println("Hello");
    }

    public void openStressNDepressedMenu (View v) {
        Intent i = new Intent(this, StressNDepressedMenu.class);
        startActivity(i);
        System.out.println("Hello");
    }
}