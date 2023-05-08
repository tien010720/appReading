package com.example.appreading.model;

import android.os.Parcel;
import android.os.Parcelable;

public class ChapModel implements Parcelable {
    private String chap1;
    private String content1;
    private String id_tr1;
    private String id1;
    public ChapModel(String id, String chap, String content, String id_tr){
        this.id1=id;
        this.chap1=chap;
        this.content1=content;
        this.id_tr1=id_tr;
    }

    public ChapModel(String chap){
        this.chap1=chap;
    }

    protected ChapModel(Parcel in) {
        id1         = in.readString();
        chap1       = in.readString();
        content1    = in.readString();
        id_tr1      = in.readString();
    }

    public static final Parcelable.Creator<ChapModel> CREATOR = new Parcelable.Creator<ChapModel>() {
        @Override
        public ChapModel createFromParcel(Parcel in) {
            return new ChapModel(in);
        }

        @Override
        public ChapModel[] newArray(int size) {
            return new ChapModel[size];
        }
    };


    public String getChap1() {
        return chap1;
    }

    public void setChap1(String chap) {
        this.chap1 = chap;
    }

    public String getContent1() {
        return content1;
    }

    public void setContent1(String content) {
        this.content1 = content;
    }

    public String getId_tr1() {
        return id_tr1;
    }

    public void setId_tr1(String id_tr) {
        this.id_tr1 = id_tr;
    }

    public String getId1() {
        return id1;
    }

    public void setId1(String id) {
        this.id1 = id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id_tr1);
        dest.writeString(id1);
        dest.writeString(chap1);
        dest.writeString(content1);
    }
}
