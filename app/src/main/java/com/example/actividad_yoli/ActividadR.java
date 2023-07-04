package com.example.actividad_yoli;

import java.util.ArrayList;
import java.util.List;

public class ActividadR {
    private List<Mi_Proyecto> categories = new ArrayList<Mi_Proyecto>();

    public List<Mi_Proyecto>getCategories(){
        return categories;
    }
    public void setResult(List<Mi_Proyecto> result){
        this.categories = result;
    }
}
