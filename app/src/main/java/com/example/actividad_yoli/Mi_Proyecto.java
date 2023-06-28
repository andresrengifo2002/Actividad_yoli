package com.example.actividad_yoli;

import android.media.Image;

public class Mi_Proyecto {
    private int number;
    private String nombre;

    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }



    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        String[] urlPartes=url.split("/");
        int id= Integer.parseInt( urlPartes[urlPartes.length-1]);

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


}
