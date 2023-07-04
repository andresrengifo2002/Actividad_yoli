package com.example.actividad_yoli;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ActividadApi {


    @GET("jokes/random")
    Call<ActividadR> obtenerListrandom();
}
