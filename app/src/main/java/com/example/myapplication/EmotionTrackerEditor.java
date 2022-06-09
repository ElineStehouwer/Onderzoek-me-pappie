package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;

public class EmotionTrackerEditor extends AppCompatActivity {
    private int entryId;
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yy");
    String currentDate = sdf.format(new Date());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emotion_tracker_editor);
//        EditText editText = (EditText) findViewById(R.id.editTextTextMultiLine);
//        Intent intent = getIntent();
//        entryId = intent.getIntExtra("entryId", -1);
//        if (entryId != -1) {
//            editText.setText(EmotionTracker.entries.get(entryId));
//        } else {
        EmotionTracker.entries.add("");
        entryId = EmotionTracker.entries.size() - 1;
        EmotionTracker.arrayAdapter.notifyDataSetChanged();
//        }
//
//        editText.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
//
//            @Override
//            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//                EmotionTracker.entries.set(entryId, charSequence.toString());
//                EmotionTracker.arrayAdapter.notifyDataSetChanged();
//
//                SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("com.example.myapplication", Context.MODE_PRIVATE);
//                HashSet<String> stringSet = new HashSet(EmotionTracker.entries);
//                sharedPreferences.edit().putStringSet("entries", stringSet).apply();
//            }
//
//            @Override
//            public void afterTextChanged(Editable editable) {}
//        });
    }

    public void setScore (View v) {
        EmotionTracker.entries.set (entryId, getScore(v));
        EmotionTracker.arrayAdapter.notifyDataSetChanged();
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("com.example.myapplication", Context.MODE_PRIVATE);
        HashSet<String> stringSet = new HashSet(EmotionTracker.entries);
        sharedPreferences.edit().putStringSet("entries", stringSet).apply();
        Intent intent = new Intent (this, EmotionTracker.class);
        startActivity(intent);
    }


    public String getScore(View v) {
        String score = "";
        int id = v.getId();
        switch (id) {
            case (R.id.button5):
                score = "1 - Worst day ever :(";
                break;
            case (R.id.button6):
                score = "2 - Could be better";
                break;
            case (R.id.button7):
                score = "3 - Just a normal day";
                break;
            case (R.id.button8):
                score = "4 - I'm feeling great";
                break;
            case (R.id.button9):
                score = "5 - Best day ever!!";
                break;
        }
        String s = currentDate + ": " + score;
        return s;
    }
}

