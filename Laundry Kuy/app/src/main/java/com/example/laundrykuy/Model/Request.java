package com.example.laundrykuy.Model;

import java.io.Serializable;

public class Request implements Serializable {

    private String nama;
    private String telpon;
    private String alamat;
    private String email;
    private String foto;
    private String key;

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) { this.foto = foto;    }



    public Request(){

    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTelpon() {
        return telpon;
    }

    public void setTelpon(String telpon) {
        this.telpon = telpon;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getEmail() { return email;    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Request(String nama, String telpon, String alamat, String email, String foto) {
        this.nama = nama;
        this.telpon = telpon;
        this.alamat = alamat;
        this.email = email;
        this.foto = foto;
    }



    @Override
    public String toString(){
        return ""+nama+"\n"+
                ""+telpon+"\n"+
                ""+alamat+"\n"+
                ""+email;
    }


}
