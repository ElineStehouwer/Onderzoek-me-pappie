package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

public class ContactingProfessionalsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private String[] s1, s2, s3, s4;
    private final int[] images = {R.drawable.vivi_luicks,R.drawable.annelena_de_vletter, R.drawable.alexandra_dullaart,
            R.drawable.robert_van_den_bosch, R.drawable.niels_nederveld, R.drawable.irene_kurpershoek,
            R.drawable.amrah_van_til, R.drawable.loes_dols};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacting_professionals);

        recyclerView = findViewById(R.id.recyclerView);

        s1 = getResources().getStringArray(R.array.names);
        s2 = getResources().getStringArray(R.array.location);
        s3 = getResources().getStringArray(R.array.number);
        s4 = getResources().getStringArray(R.array.links);

        MyAdapter adapter = new MyAdapter(this, s1, s2, s3, s4, images);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }


}