package com.example.laundrykuy.Model;

import java.io.Serializable;

public class Request implements Serializable {

    private String nama;
    private String telpon;
    private String alamat;
    private String email;
    private String foto;
    private String key;




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


    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) { this.foto = foto;    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Request(String nama,String alamat, String telpon,  String email, String foto) {
        this.nama = nama;
        this.alamat = alamat;
        this.telpon = telpon;
        this.email = email;
        this.foto = foto;
    }



    @Override
    public String toString(){
        return ""+nama+"\n"+
                ""+alamat+"\n"+
                ""+telpon+"\n"+
                ""+email;
    }


}
