package com.example.laundrykuy.Status;
import com.google.firebase.database.Exclude;

import java.util.HashMap;
import java.util.Map;
public class StatusReq {
    private String atas_nama;
    private String tanggal_laundry;
    private String status_pakaian;

    public String getAtas_nama() {
        return atas_nama;
    }

    public void setAtas_nama(String atas_nama) {
        this.atas_nama = atas_nama;
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


    public StatusReq() {
    }

    public StatusReq(String atas_nama, String tanggal_laundry, String status_pakaian) {
        this.atas_nama = atas_nama;
        this.tanggal_laundry = tanggal_laundry;
        this.status_pakaian = status_pakaian;
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
