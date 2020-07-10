package com.example.laundrykuy.Mencuci;

import com.google.firebase.database.Exclude;

import java.util.HashMap;
import java.util.Map;

public class Member {
    private String jenis_laundry;
    private String atas_nama;
    private String alamat;
    private String tanggal_laundry;
    private String status_pakaian;
    private String key ;
    private String userId;

    public Member() {
    }

    public String getJenis_laundry() {
        return jenis_laundry;
    }

    public void setJenis_laundry(String jenis_laundry) {
        this.jenis_laundry = jenis_laundry;
    }

    public String getAtas_nama() {
        return atas_nama;
    }

    public void setAtas_nama(String atas_nama) {
        this.atas_nama = atas_nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getTanggal_laundry() {
        return tanggal_laundry;
    }

    public void setTanggal_laundry(String tanggal_laundry) {
        this.tanggal_laundry = tanggal_laundry;
    }

    public String getStatus_pakaian() {
        return status_pakaian;
    }

    public void setStatus_pakaian(String status_pakaian) {
        this.status_pakaian = status_pakaian;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }


    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("atas_nama", atas_nama);
        result.put("tanggal_laundry", tanggal_laundry);
        result.put("status_pakaian", status_pakaian);
        return result;
    }

}
