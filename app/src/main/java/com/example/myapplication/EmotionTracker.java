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
import java.util.Date;
import java.text.SimpleDateFormat;

public class EmotionTracker extends AppCompatActivity {
    static ArrayList<String> entries = new ArrayList<>();
    static ArrayAdapter arrayAdapter;
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yy hh:mm");
    String currentDate = sdf.format(new Date());

    @Override
    public boolean onCreateOptionsMenu(Menu m) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.add_emotion, m);
        return super.onCreateOptionsMenu(m);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);
        if (item.getItemId() == R.id.add_emotion) {
            Intent intent = new Intent(getApplicationContext(), EmotionTrackerEditor.class);
            startActivity(intent);
            return true;
        }
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emotion_tracker);
        setTitle("Emotion Tracker");
        ListView listView = (ListView) findViewById(R.id.listView2);
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("com.example.myapplication", Context.MODE_PRIVATE);
        HashSet<String> stringSet = (HashSet<String>) sharedPreferences.getStringSet("entries", null);
        if (stringSet == null) {
            if (entries.isEmpty()) {
                entries.add("[exampleDate]: 5 - Best Day Ever!!");
            }
        } else {
            entries = new ArrayList<>(stringSet);
        }

        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, entries);
        listView.setAdapter(arrayAdapter);

//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Intent intent = new Intent(getApplicationContext(), EmotionTrackerEditor.class);
//                intent.putExtra("entryId", i);
//                startActivity(intent);
//            }
//        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                final int itemToDelete = i;
                new AlertDialog.Builder(EmotionTracker.this)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setTitle("Are you sure?")
                        .setMessage("Do you want to delete this tracker item?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                entries.remove(itemToDelete);
                                arrayAdapter.notifyDataSetChanged();

                                SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("com.example.myapplication", Context.MODE_PRIVATE);
                                HashSet<String> stringSet = new HashSet(EmotionTracker.entries);
                                sharedPreferences.edit().putStringSet("entries", stringSet).apply();
                            }
                        })
                        .setNegativeButton("No", null)
                        .show();
                return true; //Makes sure that you don't also get a short click, if it were false you would also get a short click
            }
        });
    }

}
