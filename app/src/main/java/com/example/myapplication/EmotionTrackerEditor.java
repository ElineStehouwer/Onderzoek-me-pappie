package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.util.HashSet;

public class EmotionTrackerEditor extends AppCompatActivity {
    private int noteId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_journal_editor);
        EditText editText = (EditText) findViewById(R.id.editTextTextMultiLine);
        Intent intent = getIntent();
        noteId = intent.getIntExtra("noteId", -1);
        if (noteId != -1) {
            editText.setText(EmotionTracker.notes.get(noteId));
        } else {
            EmotionTracker.notes.add("");
            noteId = EmotionTracker.notes.size()-1;
            EmotionTracker.arrayAdapter.notifyDataSetChanged();
        }
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                EmotionTracker.notes.set(noteId, charSequence.toString());
                EmotionTracker.arrayAdapter.notifyDataSetChanged();

                SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("com.example.myapplication", Context.MODE_PRIVATE);
                HashSet<String> stringSet = new HashSet(EmotionTracker.notes);
                sharedPreferences.edit().putStringSet("notes", stringSet).apply();
            }

            @Override
            public void afterTextChanged(Editable editable) {}
        });
    }
}

