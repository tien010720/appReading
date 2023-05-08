package com.example.appreading.model;

public class CommentModel {
    public String cmt;
    public String img;
    public int img1;

    public CommentModel(String cmt, int img1){
        this.cmt=cmt;
        this.img1=img1;
    }

    public CommentModel(String cmt, String img) {
        this.cmt = cmt;
        this.img = img;
    }

    public String getCmt() {
        return cmt;
    }

    public void setCmt(String cmt) {
        this.cmt = cmt;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getImg1() {
        return img1;
    }

    public void setImg1(int img1) {
        this.img1 = img1;
    }
}
