package com.example.ungdungmuabandogo.model;

import java.io.Serializable;

public class ChiTietHD implements Serializable {
    public int ID;
    public int Madonhang;
    public int Masanpham;
    public String Tensanpham;
    public Integer Giasanpham;
    public int SLsanpham;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getMadonhang() {
        return Madonhang;
    }

    public void setMadonhang(int madonhang) {
        Madonhang = madonhang;
    }

    public int getMasanpham() {
        return Masanpham;
    }

    public void setMasanpham(int masanpham) {
        Masanpham = masanpham;
    }

    public String getTensanpham() {
        return Tensanpham;
    }

    public void setTensanpham(String tensanpham) {
        Tensanpham = tensanpham;
    }

    public Integer getGiasanpham() {
        return Giasanpham;
    }

    public void setGiasanpham(Integer giasanpham) {
        Giasanpham = giasanpham;
    }

    public int getSLsanpham() {
        return SLsanpham;
    }

    public void setSLsanpham(int SLsanpham) {
        this.SLsanpham = SLsanpham;
    }

    public ChiTietHD(int ID, int madonhang, int masanpham, String tensanpham, Integer giasanpham, int SLsanpham) {
        this.ID = ID;
        Madonhang = madonhang;
        Masanpham = masanpham;
        Tensanpham = tensanpham;
        Giasanpham = giasanpham;
        this.SLsanpham = SLsanpham;
    }
}
