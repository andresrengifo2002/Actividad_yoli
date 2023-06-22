package com.example.actividad_yoli;

import androidx.appcompat.app.AppCompatActivity;

import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static  String TAG  ;
    private Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        retrofit = new Retrofit.Builder()
                .baseUrl("http://127.0.0.1:8000/api/panaderia/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    private void obtenerDatos(int offset){
        ActividadApi service = retrofit.create(ActividadApi.class);
        Call<ActividadR>actividadRCall = service.obtenerListpanaderia();
        actividadRCall.enqueue(new Callback<ActividadR>() {
            @Override
            public void onResponse(Call<ActividadR> call, Response<ActividadR> response) {
                if (response.isSuccessful()){
                    ActividadR actividadR = response.body();
                    List<Mi_Proyecto> listami_proyecto = actividadR.getResult();
                    for (int i = 0; i < listami_proyecto.size(); i++){
                        Mi_Proyecto m = listami_proyecto.get(i);
                        Log.e(TAG,"mi_proyecto" + m.getNombre());
                    }
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
}