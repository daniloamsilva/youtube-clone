package com.app.daniloaugustoyoutube.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.daniloaugustoyoutube.R;
import com.app.daniloaugustoyoutube.model.Item;
import com.app.daniloaugustoyoutube.model.Video;

import java.util.ArrayList;
import java.util.List;

public class AdapterVideo extends RecyclerView.Adapter<AdapterVideo.MyViewHolder> {

    private List<Item> videos = new ArrayList<>();
    private Context context;

    public AdapterVideo(List<Item> videos, Context context) {
        this.videos = videos;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.adapter_video, viewGroup, false);
        return new AdapterVideo.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        Item video = videos.get(i);
        myViewHolder.titulo.setText(video.snippet.title);

    }

    @Override
    public int getItemCount() {
        return videos.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView titulo;
        TextView descrição;
        TextView data;
        ImageView capa;

        public MyViewHolder (View itemView){
            super(itemView);

            titulo = itemView.findViewById(R.id.textTitulo);
            capa = itemView.findViewById(R.id.imageCapa);

        }

    }

}
