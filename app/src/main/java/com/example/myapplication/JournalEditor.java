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

public class JournalEditor extends AppCompatActivity {
    private int noteId;  //Indicate which notes in the ArrayList notes is being edited


    /**
     *   In this method the text the user puts into the EditText is saved in the journal
     *   and locally on the phone.
     * */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_journal_editor);
        EditText editText = (EditText) findViewById(R.id.editTextTextMultiLine);
        Intent intent = getIntent();
        noteId = intent.getIntExtra("noteId", -1);
        // If we are editing an existing entry, then we want to set the text of our EditText
        // to the text of that already existing entry. If we are creating a new entry, then
        // we will first add an entry entry to the notes ArrayList, then give noteId the
        // right value and then update the ListView.
        if (noteId != -1) {
            editText.setText(Journal.notes.get(noteId));
        } else {
            Journal.notes.add("");
            noteId = Journal.notes.size()-1;
            Journal.arrayAdapter.notifyDataSetChanged();
        }

        // We add an textChangedListener to our EditText. We change the onTextChanged function
        // to set the text of our notes ArrayList of the note we are editing to the text that
        // was put in the EditText and update the ListView. Then we make sure to save the
        // edited text in the local storage using SharedPreferences.
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Journal.notes.set(noteId, charSequence.toString());
                Journal.arrayAdapter.notifyDataSetChanged();

                SharedPreferences sharedPreferences = getApplicationContext().
                        getSharedPreferences("com.example.myapplication", Context.MODE_PRIVATE);
                HashSet<String> stringSet = new HashSet(Journal.notes);
                sharedPreferences.edit().putStringSet("notes", stringSet).apply();
            }

            @Override
            public void afterTextChanged(Editable editable) {}
        });
    }
}