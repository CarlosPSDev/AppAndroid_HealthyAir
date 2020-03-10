package com.riluca.healthyair.javabean;

public class Estacion {  //Parcelable??
    private String id;
    private String nombre;
    private String direccion;
    private String longitud;
    private String latitud;

    public Estacion() {}

    public Estacion(String id, String nombre, String direccion, String longitud, String latitud) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.longitud = longitud;
        this.latitud = latitud;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getLongitud() {
        return longitud;
    }

    public String getLatitud() {
        return latitud;
    }
}
