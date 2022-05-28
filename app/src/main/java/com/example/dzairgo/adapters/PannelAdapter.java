package com.example.dzairgo.adapters;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dzairgo.R;

import java.util.ArrayList;

public class PannelAdapter extends RecyclerView.Adapter<PannelAdapter.MyViewHolder> {
    ArrayList<Drawable> images;
    public PannelAdapter(ArrayList<Drawable> images){
    this.images = images;
    }

    @NonNull
    @Override
    public PannelAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.one_image ,parent,false);
        PannelAdapter.MyViewHolder holder =  new PannelAdapter.MyViewHolder(view) ;
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull PannelAdapter.MyViewHolder holder, int position) {
        holder.img.setImageDrawable(images.get(position));
        holder.img.setClipToOutline(true);
        holder.img.setScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView img ;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.image);
        }
    }
}
