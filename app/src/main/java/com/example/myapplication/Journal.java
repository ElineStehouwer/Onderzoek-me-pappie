package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashSet;

public class Journal extends AppCompatActivity {
    static ArrayList<String> notes = new ArrayList<>(); //Stores the journal entries added to the journal
    static ArrayAdapter arrayAdapter;


    /**
     *   Adds the OptionsMenu add_note.xml to the activity.
     * */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.add_note, menu);
        return super.onCreateOptionsMenu(menu);
    }


    /**
     *   Specifies what has to happen when our option in the option menu is
     *   selected. We make sure that when the add_note menu option is selected,
     *   the JournalEditor class is opened.
     * */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);
        if (item.getItemId() == R.id.add_note) {
            Intent intent = new Intent(getApplicationContext(), JournalEditor.class);
            startActivity(intent);
            return true;
        }
        return false;
    }

    /**
     * In this onCreate method the following things happen: the locally saved
     * journal additions get restored in the listview, using SharedPreferences.
     * Also an on click and on long click listener is set to the items in the list
     * view.
     * */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_journal);
        ListView listView = (ListView) findViewById(R.id.listView);

        //Restore the journal additions saved locally on the phone
        SharedPreferences sharedPreferences = getApplicationContext().
                getSharedPreferences("com.example.myapplication", Context.MODE_PRIVATE);
        HashSet<String> stringSet = (HashSet<String>) sharedPreferences.getStringSet("notes", null);
        //When there are no locally saved journal additions, then we will add an example note.
        if (stringSet == null) {
            if (notes.isEmpty()) {
                notes.add("Example note");
            }
        } else {
            notes = new ArrayList<>(stringSet);
        }
        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, notes);
        listView.setAdapter(arrayAdapter);

        // Set an onItemClickListener to the ListView, this will make it so that if the user
        // clicks on a journal entry, they will go to the JournalEditor and they will be
        // able to edit the entry.
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), JournalEditor.class);
                intent.putExtra("noteId", i);
                startActivity(intent);
            }
        });

        // Set an onItemLongClickListener to the ListView, this will make it so that if the
        // user long clicks on a journal entry, they will get a pop-up asking them if they
        // want to delete the entry they long clicked on. Here they can choose yes or no
        // in case of yes the entry gets deleted (also from the local storage), in case of no
        // it doesn't.
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                final int itemToDelete = i;
                new AlertDialog.Builder(Journal.this)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setTitle("Are you sure?")
                        .setMessage("Do you want to delete this journal item?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                notes.remove(itemToDelete);
                                arrayAdapter.notifyDataSetChanged();

                                SharedPreferences sharedPreferences = getApplicationContext().
                                        getSharedPreferences
                                                ("com.example.myapplication", Context.MODE_PRIVATE);
                                HashSet<String> stringSet = new HashSet(Journal.notes);
                                sharedPreferences.edit().putStringSet("notes", stringSet).apply();
                            }
                        })
                        .setNegativeButton("No", null)
                        .show();
                return true; //Makes sure that you don't also get a short click, if it were false you would also get a short click
            }
        });
    }
}