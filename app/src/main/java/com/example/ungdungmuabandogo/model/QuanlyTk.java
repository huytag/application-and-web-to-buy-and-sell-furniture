package com.example.ungdungmuabandogo.model;

public class QuanlyTk {
    public int id;
    public String tenuser;
    public String email;
    public String pass;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenuser() {
        return tenuser;
    }

    public void setTenuser(String tenuser) {
        this.tenuser = tenuser;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public QuanlyTk(int id, String tenuser, String email, String pass) {
        this.id = id;
        this.tenuser = tenuser;
        this.email = email;
        this.pass = pass;
    }
}
