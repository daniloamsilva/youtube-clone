package com.app.daniloaugustoyoutube.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.app.daniloaugustoyoutube.R;
import com.app.daniloaugustoyoutube.adapter.AdapterVideo;
import com.app.daniloaugustoyoutube.model.Video;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String GOOGLE_API_KEY = "AIzaSyBtSmK-ixd68-6ud46pG2dtLY1BedE3H0w";

    // Widgets
    private RecyclerView recyclerVideos;

    private List<Video> videos = new ArrayList<>();
    private AdapterVideo adapterVideo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializar componentes
        recyclerVideos = findViewById(R.id.recyclerVideos);

        // Configuração da toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Youtube");
        setSupportActionBar(toolbar);

        // Configuração RecyclerView
        recuperarVideos();
        adapterVideo = new AdapterVideo(videos, this);
        recyclerVideos.setHasFixedSize(true);
        recyclerVideos.setLayoutManager(new LinearLayoutManager(this));
        recyclerVideos.setAdapter(adapterVideo);

    }

    private void recuperarVideos(){
        Video video1 = new Video();
        video1.setTitulo("Vídeo 1 muito interessante.");
        videos.add(video1);

        Video video2 = new Video();
        video2.setTitulo("Vídeo 2 muito interessante.");
        videos.add(video2);
    }

}
