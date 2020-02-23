package org.test.rectrofitdemo;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import org.test.rectrofitdemo.POJO.TestModel;

import java.time.Instant;
import java.util.List;

public class ContentAdaptor extends RecyclerView.Adapter<ContentAdaptor.MovieViewHolder>{

    private List<TestModel> movies;
    private int rowLayout;
    private Context context;

    public static class MovieViewHolder extends RecyclerView.ViewHolder {
        TextView email;
        TextView firstName;
        TextView lastName;
        ImageView img;

        public MovieViewHolder(View v) {
            super(v);
            email = (TextView) v.findViewById(R.id.email);
            firstName = (TextView) v.findViewById(R.id.firstname);
            lastName = (TextView) v.findViewById(R.id.lastname);
            img = v.findViewById(R.id.img);

        }
    }
    public ContentAdaptor(List<TestModel> movies, int rowLayout, Context context) {
        this.movies = movies;
        this.rowLayout = rowLayout;
        this.context = context;
    }



    @NonNull
    @Override
    public ContentAdaptor.MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, final int position) {
        holder.email.setText(movies.get(position).getEmail());
        holder.firstName.setText(movies.get(position).getFirstName());
        holder.lastName.setText(movies.get(position).getLastName());
      // holder.avatar.setText(movies.get(position).getAvatar());
        Glide.with(context).load(movies.get(position).getAvatar()).into(holder.img);

        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(context,GlideImage.class);
                i.putExtra("https://reqres.in/api/users?page=1",movies.get(position).getAvatar());
               context.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount()

    {
        return movies.size();
    }
}
