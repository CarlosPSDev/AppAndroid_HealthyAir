package com.riluca.healthyair.ui.normative;

import android.os.Parcel;
import android.os.Parcelable;

public class Escenario implements Parcelable {

    private int ivPhoto;
    private String textoSuperior;
    private String textoInferior;

    public Escenario(int ivPhoto, String textoSuperior, String textoInferior) {
        this.ivPhoto = ivPhoto;
        this.textoSuperior = textoSuperior;
        this.textoInferior = textoInferior;
    }

    protected Escenario(Parcel in) {
        ivPhoto = in.readInt();
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

    public int getIvPhoto() {
        return ivPhoto;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(ivPhoto);
        dest.writeString(textoSuperior);
        dest.writeString(textoInferior);
    }
}
