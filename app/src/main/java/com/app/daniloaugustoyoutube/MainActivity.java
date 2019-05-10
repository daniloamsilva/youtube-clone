package com.app.daniloaugustoyoutube;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class MainActivity extends YouTubeBaseActivity
                implements YouTubePlayer.OnInitializedListener {

    private YouTubePlayerView youTubePlayerView;
    private static final String GOOGLE_API_KEY = "AIzaSyBtSmK-ixd68-6ud46pG2dtLY1BedE3H0w";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        youTubePlayerView = findViewById(R.id.viewYoutubePlayer);
        youTubePlayerView.initialize(GOOGLE_API_KEY, this);

    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean foiRestaurado) {
        //youTubePlayer.loadVideo("Hy7hMIMb7rI");
        if (!foiRestaurado) {
            youTubePlayer.cueVideo("Hy7hMIMb7rI");
        }
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        Toast.makeText(this, "Erro ao iniciar o Player", Toast.LENGTH_SHORT).show();
    }
}
