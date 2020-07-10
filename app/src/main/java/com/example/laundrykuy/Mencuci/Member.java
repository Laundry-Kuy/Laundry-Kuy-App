package com.example.laundrykuy.Mencuci;

public class Member {
    private String jenis_laundry;
    private String atas_nama;
    private String alamat;
    private String tanggal_laundry;
    private String status_pakaian;
    private String paket_laundry;
    private String paket_pengantaran;
    private String estimasi_berat_pakaian;
    private String estimasi_tarif_laundry;
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

    public String getPaket_laundry() {  return paket_laundry;    }

    public void setPaket_laundry(String paket_laundry) {  this.paket_laundry = paket_laundry;    }

    public String getPaket_pengantaran() {
        return paket_pengantaran;
    }

    public void setPaket_pengantaran(String paket_pengantaran) {
        this.paket_pengantaran = paket_pengantaran;
    }

    public String getEstimasi_berat_pakaian() {
        return estimasi_berat_pakaian;
    }

    public void setEstimasi_berat_pakaian(String estimasi_berat_pakaian) {
        this.estimasi_berat_pakaian = estimasi_berat_pakaian;
    }

    public String getEstimasi_tarif_laundry() {
        return estimasi_tarif_laundry;
    }

    public void setEstimasi_tarif_laundry(String estimasi_tarif_laundry) {
        this.estimasi_tarif_laundry = estimasi_tarif_laundry;
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


    public Member (String atas_nama, String tanggal_laundry, String status_pakaian, String alamat, String paket_laundry, String paket_pengantaran, String estimasi_berat_pakaian, String estimasi_tarif_laundry, String jenis_laundry) {
        this.atas_nama = atas_nama;
        this.tanggal_laundry = tanggal_laundry;
        this.status_pakaian = status_pakaian;
        this.alamat = alamat;
        this.paket_laundry = paket_laundry;
        this.paket_pengantaran= paket_pengantaran;
        this.estimasi_berat_pakaian = estimasi_berat_pakaian;
        this.estimasi_tarif_laundry= estimasi_tarif_laundry;
        this.jenis_laundry = jenis_laundry;
    }

}
