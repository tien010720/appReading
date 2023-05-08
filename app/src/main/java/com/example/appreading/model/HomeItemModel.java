package com.example.appreading.model;

import android.os.Parcel;
import android.os.Parcelable;

public class HomeItemModel implements Parcelable {

    private String id;
    private String image;
    private String name;
    private String author;
    private String trangthai;
    private String chap;
    private String content;

    public String toLowerCase() {
        return null;
    }

    public HomeItemModel(String id, String name1, String image1, String author,
                         String trangthai, String chap, String content) {
        this.id         = id;
        this.image      = image1;
        this.name       = name1;
        this.author     = author;
        this.trangthai  = trangthai;
        this.chap       = chap;
        this.content    = content;
    }

    protected HomeItemModel(Parcel in) {
        id          = in.readString();
        image       = in.readString();
        name        = in.readString();
        author      = in.readString();
        trangthai   = in.readString();
        chap        = in.readString();
        content     = in.readString();
    }

    public static final Creator<HomeItemModel> CREATOR = new Creator<HomeItemModel>() {
        @Override
        public HomeItemModel createFromParcel(Parcel in) {
            return new HomeItemModel(in);
        }

        @Override
        public HomeItemModel[] newArray(int size) {
            return new HomeItemModel[size];
        }
    };

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getChap() {
        return chap;
    }

    public void setChap(String chap) {
        this.chap = chap;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(image);
        dest.writeString(name);
        dest.writeString(author);
        dest.writeString(trangthai);
        dest.writeString(chap);
        dest.writeString(content);
    }
}
