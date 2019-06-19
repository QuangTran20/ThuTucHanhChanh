package com.it.sunny.thutuchanhchanh.model;

import java.io.Serializable;
import java.util.Date;

public class TinTuc implements Serializable {

    public int ID;
    public int IDLoaiTin;
    public String TieuDe;
    public String HinhAnh;
    public String MoTa;
    public String NoiDung;
    public String TacGia;
    public String NgayDang;

    public TinTuc(int ID, int IDLoaiTin, String tieuDe, String hinhAnh, String moTa, String noiDung, String tacGia, String ngayDang) {
        this.ID = ID;
        this.IDLoaiTin = IDLoaiTin;
        TieuDe = tieuDe;
        HinhAnh = hinhAnh;
        MoTa = moTa;
        NoiDung = noiDung;
        TacGia = tacGia;
        NgayDang = ngayDang;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getIDLoaiTin() {
        return IDLoaiTin;
    }

    public void setIDLoaiTin(int IDLoaiTin) {
        this.IDLoaiTin = IDLoaiTin;
    }

    public String getTieuDe() {
        return TieuDe;
    }

    public void setTieuDe(String tieuDe) {
        TieuDe = tieuDe;
    }

    public String getHinhAnh() {
        return HinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        HinhAnh = hinhAnh;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String moTa) {
        MoTa = moTa;
    }

    public String getNoiDung() {
        return NoiDung;
    }

    public void setNoiDung(String noiDung) {
        NoiDung = noiDung;
    }

    public String getTacGia() {
        return TacGia;
    }

    public void setTacGia(String tacGia) {
        TacGia = tacGia;
    }

    public String getNgayDang() {
        return NgayDang;
    }

    public void setNgayDang(String ngayDang) {
        NgayDang = ngayDang;
    }
}
