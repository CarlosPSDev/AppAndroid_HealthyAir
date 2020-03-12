package com.riluca.healthyair.ui.contaminantes;

import android.os.Parcel;
import android.os.Parcelable;

public class ItemLista implements Parcelable{

    private int idPhoto;
    private String textoSuperior;
    private String textoInferior;

    public ItemLista(int idPhoto, String textoSuperior, String textoInferior) {
        this.idPhoto = idPhoto;
        this.textoSuperior = textoSuperior;
        this.textoInferior = textoInferior;
    }

    protected ItemLista(Parcel in) {
        idPhoto = in.readInt();
        textoSuperior = in.readString();
        textoInferior = in.readString();
    }

    public static final Parcelable.Creator<ItemLista> CREATOR = new Parcelable.Creator<ItemLista>() {
        @Override
        public ItemLista createFromParcel(Parcel in) {
            return new ItemLista(in);
        }

        @Override
        public ItemLista[] newArray(int size) {
            return new ItemLista[size];
        }
    };

    public int getIdPhoto() {
        return idPhoto;
    }

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
        dest.writeInt(idPhoto);
        dest.writeString(textoSuperior);
        dest.writeString(textoInferior);
    }
}
