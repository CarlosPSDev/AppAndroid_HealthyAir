package com.riluca.healthyair.javabean;

public class Estaciones {
    private String longitud;
    private String latitud;

    public Estaciones(String longitud, String latitud) {
        this.longitud = longitud;
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public String getLatitud() {
        return latitud;
    }
}
