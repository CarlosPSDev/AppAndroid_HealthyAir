package com.riluca.healthyair.ui.normative;

import android.os.Parcel;
import android.os.Parcelable;

public class Escenario implements Parcelable {

    private String textoSuperior;
    private String textoInferior;

    public Escenario(String textoSuperior, String textoInferior) {
        this.textoSuperior = textoSuperior;
        this.textoInferior = textoInferior;
    }

    protected Escenario(Parcel in) {
        textoSuperior = in.readString();
        textoInferior = in.readString();
    }

    public static final Parcelable.Creator<Escenario> CREATOR = new Parcelable.Creator<Escenario>() {
        @Override
        public Escenario createFromParcel(Parcel in) {
            return new Escenario(in);
        }

        @Override
        public Escenario[] newArray(int size) {
            return new Escenario[size];
        }
    };

    public String getTextoSuperior() {
        return textoSuperior;
    }

    public String getTextoInferior() {
        return textoInferior;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(textoSuperior);
        dest.writeString(textoInferior);
    }
}
