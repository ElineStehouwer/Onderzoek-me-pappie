package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{

    private final String[] data1, data2, data3, data4;
    private final int[] images;
    private final Context context;

    public MyAdapter(Context context, String[] s1, String[] s2, String[] s3, String[] s4, int[] images) {
        this.context = context;
        data1 = s1;
        data2 = s2;
        data3 = s3;
        data4 = s4;
        this.images = images;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.text1.setText(data1[position]);
        holder.text2.setText(data2[position]);
        holder.text3.setText(data3[position]);
        holder.text4.setText(data4[position]);
        holder.text4.setOnClickListener(new View.OnClickListener() {@Override
            public void onClick (View v) {
            String website = data4[holder.getAdapterPosition()];
            Intent browserIntent = new Intent (Intent.ACTION_VIEW, Uri.parse(website));
            context.startActivity(browserIntent);
        }
        });
        holder.myImage.setImageResource(images[position]);
    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView text1, text2, text3, text4;
        ImageView myImage;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            text1 = itemView.findViewById(R.id.name);
            text2 = itemView.findViewById(R.id.location);
            text3 = itemView.findViewById(R.id.number);
            text4 = itemView.findViewById(R.id.link);
            myImage = itemView.findViewById(R.id.picture);
        }
    }
}
