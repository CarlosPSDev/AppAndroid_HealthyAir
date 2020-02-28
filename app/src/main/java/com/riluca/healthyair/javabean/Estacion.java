package com.riluca.healthyair.javabean;

public class Estacion {  //Parcelable??
    private String id;
    private String longitud;
    private String latitud;

    public Estacion(String id, String longitud, String latitud) {
        this.id = id;
        this.longitud = longitud;
        this.latitud = latitud;
    }

    public String getId() {
        return id;
    }

    public String getLongitud() {
        return longitud;
    }

    public String getLatitud() {
        return latitud;
    }
}
