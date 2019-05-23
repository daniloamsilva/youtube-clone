package com.app.daniloaugustoyoutube.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.app.daniloaugustoyoutube.R;
import com.app.daniloaugustoyoutube.adapter.AdapterVideo;
import com.app.daniloaugustoyoutube.api.YoutubeService;
import com.app.daniloaugustoyoutube.helper.RetrofitConfig;
import com.app.daniloaugustoyoutube.helper.YoutubeConfig;
import com.app.daniloaugustoyoutube.model.Resultado;
import com.app.daniloaugustoyoutube.model.Video;
import com.miguelcatalan.materialsearchview.MaterialSearchView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    // Widgets
    private RecyclerView recyclerVideos;
    private MaterialSearchView searchView;

    private List<Video> videos = new ArrayList<>();
    private AdapterVideo adapterVideo;

    // Retrofit
    private Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializar componentes
        recyclerVideos = findViewById(R.id.recyclerVideos);
        searchView = findViewById(R.id.searchView);

        // Configurações iniciais
        retrofit = RetrofitConfig.getRetrofit();

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

        // Configuração dos métodos para SearchView
        searchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        searchView.setOnSearchViewListener(new MaterialSearchView.SearchViewListener() {
            @Override
            public void onSearchViewShown() {

            }

            @Override
            public void onSearchViewClosed() {

            }
        });

    }

    private void recuperarVideos(){
        YoutubeService youtubeService = retrofit.create(YoutubeService.class);
        youtubeService.recuperarVideos(
                "snippet", "date", "20",
                YoutubeConfig.CHAVE_YOUTUBE_API,
                YoutubeConfig.CANAL_ID
        ).enqueue(new Callback<Resultado>() {
            @Override
            public void onResponse(Call<Resultado> call, Response<Resultado> response) {
                Log.d("resultado", "onResponse: " + response);
                if (response.isSuccessful()){
                    Resultado resultado = response.body();
                    Log.d("resultado", "onResponse: " + resultado.regionCode);
                }
            }

            @Override
            public void onFailure(Call<Resultado> call, Throwable t) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);

        MenuItem item = menu.findItem(R.id.menu_search);
        searchView.setMenuItem(item);

        return true;
    }
}
