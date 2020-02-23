package com.example.ram2.Adapter;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.example.ram2.Imagedetails;
import com.example.ram2.MainActivity;
import com.example.ram2.R;
import com.example.ram2.model.Model;
import java.util.List;

import static android.provider.ContactsContract.CommonDataKinds.Website.URL;
public class ModelAdapter extends RecyclerView.Adapter<ModelAdapter.MovieViewHolder> {
    private List<Model> movies;
    private int rowLayout;
    private Context context;
    public static class MovieViewHolder extends RecyclerView.ViewHolder {
        TextView Email;
        TextView FirstName;
        TextView LastName;
        ImageView rating_image;
        public MovieViewHolder(View v) {
            super(v);
            Email = (TextView) v.findViewById(R.id.title);
            FirstName = (TextView) v.findViewById(R.id.subtitle);
            LastName = (TextView) v.findViewById(R.id.description);
            rating_image = (ImageView) v.findViewById(R.id.rating_image);
        }
    }
    public ModelAdapter(List<Model> movies, int content_list_item_model, Activity applicationcContext) {
        this.movies = movies;
        this.rowLayout = content_list_item_model;
        this.context = applicationcContext;
    }
    @Override
    public ModelAdapter.MovieViewHolder onCreateViewHolder(ViewGroup parent,
                                                           int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new MovieViewHolder(view);
    }
    @Override
    public void onBindViewHolder(MovieViewHolder holder, final int position) {
        holder.Email.setText(movies.get(position).getEmail());
        holder.FirstName.setText(movies.get(position).getFirstName());
        holder.LastName.setText(movies.get(position).getLastName());
//       holder.avatar.setText(movies.get(position).getAvatar());
        Glide.with(context).load(movies.get(position).getAvatar()).into(holder.rating_image);
        holder.rating_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,Imagedetails.class);
                intent.putExtra("https://reqres.in/api/users?page=1",movies.get(position).getAvatar());
                context.startActivity(intent);
            }
        });
    }
    private void startActivityForResult(Intent i, int i1) {
    }
    public int getItemCount() {
        return movies.size();
    }
}
