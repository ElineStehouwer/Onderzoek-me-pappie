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

    private final String[] names, locations, numbers, links;
    private final int[] images;
    private final Context context;

    public MyAdapter(Context context, String[] s1, String[] s2, String[] s3, String[] s4, int[] images) {
        this.context = context;
        names = s1;
        locations = s2;
        numbers = s3;
        links = s4;
        this.images = images;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    /**
     *   In this method we set the contents of our view to the right content
     *   corresponding to the contents at the position position in our String
     *   and integer arrays.
     *   We also give the TextView of the links an onClick listener which will
     *   open the website corresponding to the link stored at links[position].
     * */
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.text1.setText(names[position]);
        holder.text2.setText(locations[position]);
        holder.text3.setText(numbers[position]);
        holder.text4.setText(links[position]);
        holder.text4.setOnClickListener(new View.OnClickListener() {@Override
            public void onClick (View v) {
            String website = links[holder.getAdapterPosition()];
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

    /**
     *   Here we make our personal ViewHolder class to match our xml layout file
     *   my_row.xml.
     * */

    public static class MyViewHolder extends RecyclerView.ViewHolder{
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
