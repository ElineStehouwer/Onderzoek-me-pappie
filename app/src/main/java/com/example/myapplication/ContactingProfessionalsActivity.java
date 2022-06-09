package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

public class ContactingProfessionalsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private String[] names, locations, numbers, links;
    private final int[] images = {R.drawable.vivi_luicks,R.drawable.annelena_de_vletter, R.drawable.alexandra_dullaart,
            R.drawable.robert_van_den_bosch, R.drawable.niels_nederveld, R.drawable.irene_kurpershoek,
            R.drawable.amrah_van_til, R.drawable.loes_dols};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacting_professionals);

        recyclerView = findViewById(R.id.recyclerView);

        names = getResources().getStringArray(R.array.names);
        locations = getResources().getStringArray(R.array.location);
        numbers = getResources().getStringArray(R.array.number);
        links = getResources().getStringArray(R.array.links);

        MyAdapter adapter = new MyAdapter(this, names, locations, numbers, links, images);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }


}