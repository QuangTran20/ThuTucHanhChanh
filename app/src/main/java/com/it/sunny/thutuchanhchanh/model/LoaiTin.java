package com.it.sunny.thutuchanhchanh.model;

public class LoaiTin {

    private int Id;
    private String LoaiTin;
    private String Hinh;

    public LoaiTin(int id, String loaitin, String hinh) {
        Id = id;
        this.LoaiTin = loaitin;
        this.Hinh = hinh;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getLoaitin() {
        return LoaiTin;
    }

    public void setLoaitin(String loaitin) {
        this.LoaiTin = loaitin;
    }

    public String getHinh() {
        return Hinh;
    }

    public void setHinh(String hinh) {
        this.Hinh = hinh;
    }
}
