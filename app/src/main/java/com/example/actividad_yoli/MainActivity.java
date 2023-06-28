package com.example.actividad_yoli;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;

    RecyclerView recyclerView;

    ListaMi_ProyectoAdapter listaMi_proyectoAdapter;

    Retrofit retrofit;


    private final String TAG = "chukapi";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById((R.id.recycler1));


        listaMi_proyectoAdapter = new ListaMi_ProyectoAdapter(this);
        recyclerView.setAdapter(listaMi_proyectoAdapter);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, true);
        recyclerView.setLayoutManager(linearLayoutManager);


        retrofit = new Retrofit.Builder()
                .baseUrl("https://api.chucknorris.io/jokes/random")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        imageView = findViewById(R.id.imagenGlide);
        obtenerDatos();

    }
    private void obtenerDatos(){
        ActividadApi service = retrofit.create(ActividadApi.class);
        Call<ActividadR>actividadRCall = service.obtenerListrandom();
        actividadRCall.enqueue(new Callback<ActividadR>() {
            @Override
            public void onResponse(Call<ActividadR> call, Response<ActividadR> response) {
                if (response.isSuccessful()){
                    ActividadR actividadR = response.body();
                    List<Mi_Proyecto> listami_proyecto = actividadR.getResult();
                    for (int i = 0; i < listami_proyecto.size(); i++) {
                        Mi_Proyecto m = listami_proyecto.get(i);
                        Log.e(TAG, "mi_proyecto" + m.getNombre());
                    }
                    listaMi_proyectoAdapter.add((ArrayList<Mi_Proyecto>) listami_proyecto);
                }
                else {
                    Log.e(TAG,"onResponse" + response.errorBody() );
                }

            }

            @Override
            public void onFailure(Call<ActividadR> call, Throwable t) {
                Log.e(TAG,"onFailure" + t.getMessage() );

            }
        });
    }
    private void setImageView() {
        String url = "https://api.chucknorris.io/img/chucknorris_logo_coloured_small@2x.png";
        Glide.with(this)
                .load(url)

                .into(imageView);
    }
}