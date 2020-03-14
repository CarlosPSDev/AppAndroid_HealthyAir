package com.riluca.healthyair.javabean;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;

@Root(name = "Datos")
public class Datos {
    @ElementList(name = "Dato_Horario", inline = true)
    private ArrayList<DatoHorario> listaDatos;

    public ArrayList<DatoHorario> getListaDatos() {
        return listaDatos;
    }

    /*public void setListaDatos(ArrayList<DatoHorario> listaDatos) {
        this.listaDatos = listaDatos;
    }*/
}
