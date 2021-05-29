package com.example.ungdungmuabandogo.model;

import java.io.Serializable;

public class ChitietKH implements Serializable {
    public int ID;
    public String Tenkhachhang;
    public String Sdt;
    public String Email;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTenkhachhang() {
        return Tenkhachhang;
    }

    public void setTenkhachhang(String tenkhachhang) {
        Tenkhachhang = tenkhachhang;
    }

    public String getSdt() {
        return Sdt;
    }

    public void setSdt(String sdt) {
        Sdt = sdt;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public ChitietKH(int ID, String tenkhachhang, String sdt, String email) {
        this.ID = ID;
        Tenkhachhang = tenkhachhang;
        Sdt = sdt;
        Email = email;
    }
}
