package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Images extends AppCompatActivity {
    private int[] pictures = {R.drawable.pic8, R.drawable.pic2, R.drawable.pic5, R.drawable.pic4, R.drawable.pic6, R.drawable.pic7};
    private ImageView picture;
    private int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_images);
        picture = (ImageView) findViewById(R.id.funnypicture);
        picture.setImageResource(pictures[0]);
        index = 0;
    }

    public void onNext (View v) {
        index++;
        if (index < pictures.length) {
            picture.setImageResource(pictures[index]);
        } else {
            new AlertDialog.Builder(Images.this)
                    .setTitle("You have seen all of our images.")
                    .setMessage("Do you want to go to the beginning, or go back to the distraction?")
                    .setPositiveButton("Beginning", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            index = 0;
                            picture.setImageResource(pictures[index]);
                        }
                    })
                    .setNegativeButton("Go back", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent intent = new Intent(Images.this, ExamDistraction.class);
                            startActivity(intent);
                        }
                    }).show();
        }
    }
}