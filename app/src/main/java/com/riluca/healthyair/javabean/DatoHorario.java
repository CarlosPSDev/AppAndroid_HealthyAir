package com.riluca.healthyair.javabean;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "Dato_Horario")
public class DatoHorario {
    @Element(name="provincia")
    private String provincia;
    @Element(name="municipio")
    private String municipio;
    @Element(name="estacion")
    private String estacion;
    @Element(name="magnitud")
    private String magnitud;
    @Element(name="punto_muestreo")
    private String puntoMuestreo;
    @Element(name="ano")
    private String anio;
    @Element(name="mes")
    private String mes;
    @Element(name="dia")
    private String dia;
    @Element(name="H01")
    private String h01;
    @Element(name="V01")
    private String v01;
    @Element(name="H02")
    private String h02;
    @Element(name="V02")
    private String v02;
    @Element(name="H03")
    private String h03;
    @Element(name="V03")
    private String v03;
    @Element(name="H04")
    private String h04;
    @Element(name="V04")
    private String v04;
    @Element(name="H05")
    private String h05;
    @Element(name="V05")
    private String v05;
    @Element(name="H06")
    private String h06;
    @Element(name="V06")
    private String v06;
    @Element(name="H07")
    private String h07;
    @Element(name="V07")
    private String v07;
    @Element(name="H08")
    private String h08;
    @Element(name="V08")
    private String v08;
    @Element(name="H09")
    private String h09;
    @Element(name="V09")
    private String v09;
    @Element(name="H10")
    private String h10;
    @Element(name="V10")
    private String v10;
    @Element(name="H11")
    private String h11;
    @Element(name="V11")
    private String v11;
    @Element(name="H12")
    private String h12;
    @Element(name="V12")
    private String v12;
    @Element(name="H13")
    private String h13;
    @Element(name="V13")
    private String v13;
    @Element(name="H14")
    private String h14;
    @Element(name="V14")
    private String v14;
    @Element(name="H15")
    private String h15;
    @Element(name="V15")
    private String v15;
    @Element(name="H16")
    private String h16;
    @Element(name="V16")
    private String v16;
    @Element(name="H17")
    private String h17;
    @Element(name="V17")
    private String v17;
    @Element(name="H18")
    private String h18;
    @Element(name="V18")
    private String v18;
    @Element(name="H19")
    private String h19;
    @Element(name="V19")
    private String v19;
    @Element(name="H20")
    private String h20;
    @Element(name="V20")
    private String v20;
    @Element(name="H21")
    private String h21;
    @Element(name="V21")
    private String v21;
    @Element(name="H22")
    private String h22;
    @Element(name="V22")
    private String v22;
    @Element(name="H23")
    private String h23;
    @Element(name="V23")
    private String v23;
    @Element(name="H24")
    private String h24;
    @Element(name="V24")
    private String v24;

    public DatoHorario() {}

    /*public DatoHorario(String provincia, String municipio, String estacion, String magnitud, String puntoMuestreo, String anio, String mes, String dia, String h01, String v01, String h02, String v02, String h03, String v03, String h04, String v04, String h05, String v05, String h06, String v06, String h07, String v07, String h08, String v08, String h09, String v09, String h10, String v10, String h11, String v11, String h12, String v12, String h13, String v13, String h14, String v14, String h15, String v15, String h16, String v16, String h17, String v17, String h18, String v18, String h19, String v19, String h20, String v20, String h21, String v21, String h22, String v22, String h23, String v23, String h24, String v24) {
        this.provincia = provincia;
        this.municipio = municipio;
        this.estacion = estacion;
        this.magnitud = magnitud;
        this.puntoMuestreo = puntoMuestreo;
        this.anio = anio;
        this.mes = mes;
        this.dia = dia;
        this.h01 = h01;
        this.v01 = v01;
        this.h02 = h02;
        this.v02 = v02;
        this.h03 = h03;
        this.v03 = v03;
        this.h04 = h04;
        this.v04 = v04;
        this.h05 = h05;
        this.v05 = v05;
        this.h06 = h06;
        this.v06 = v06;
        this.h07 = h07;
        this.v07 = v07;
        this.h08 = h08;
        this.v08 = v08;
        this.h09 = h09;
        this.v09 = v09;
        this.h10 = h10;
        this.v10 = v10;
        this.h11 = h11;
        this.v11 = v11;
        this.h12 = h12;
        this.v12 = v12;
        this.h13 = h13;
        this.v13 = v13;
        this.h14 = h14;
        this.v14 = v14;
        this.h15 = h15;
        this.v15 = v15;
        this.h16 = h16;
        this.v16 = v16;
        this.h17 = h17;
        this.v17 = v17;
        this.h18 = h18;
        this.v18 = v18;
        this.h19 = h19;
        this.v19 = v19;
        this.h20 = h20;
        this.v20 = v20;
        this.h21 = h21;
        this.v21 = v21;
        this.h22 = h22;
        this.v22 = v22;
        this.h23 = h23;
        this.v23 = v23;
        this.h24 = h24;
        this.v24 = v24;
    }*/

    public String getProvincia() {
        return provincia;
    }

    public String getMunicipio() {
        return municipio;
    }

    public String getEstacion() {
        return estacion;
    }

    public String getMagnitud() {
        return magnitud;
    }

    public String getPuntoMuestreo() {
        return puntoMuestreo;
    }

    public String getAnio() {
        return anio;
    }

    public String getMes() {
        return mes;
    }

    public String getDia() {
        return dia;
    }

    public String getH08() {
        return h08;
    }

    public String getH16() {
        return h16;
    }

    public String getH24() {
        return h24;
    }


}
