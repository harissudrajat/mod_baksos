package com.ikaragil.baksos.domain;

public class BaksosDetail {

    private Long id;
    private String kode;
    private String deskripsi ;
    private String tgl_baksos;
    private String jenis_baksos;
    private String longitude;
    private String latitude;
    private String alamat_baksos;
    private String penanggung_jawab;
    private String jabatan_pj;
    private String alamat_pj;
    private String korwil_pelaksana;
    private String kondisi;
    private String barang_bantuan;
    private String qty;
    private String satuan;
    private String nama_petugas;
    private String korwil_petugas;
    private String status;

    public BaksosDetail(Long id, String kode, String deskripsi, String tgl_baksos, String jenis_baksos, String longitude, String latitude, String alamat_baksos, String penanggung_jawab, String jabatan_pj, String alamat_pj, String korwil_pelaksana, String kondisi, String barang_bantuan, String qty, String satuan, String nama_petugas, String korwil_petugas, String status) {
        this.id = id;
        this.kode = kode;
        this.deskripsi = deskripsi;
        this.tgl_baksos = tgl_baksos;
        this.jenis_baksos = jenis_baksos;
        this.longitude = longitude;
        this.latitude = latitude;
        this.alamat_baksos = alamat_baksos;
        this.penanggung_jawab = penanggung_jawab;
        this.jabatan_pj = jabatan_pj;
        this.alamat_pj = alamat_pj;
        this.korwil_pelaksana = korwil_pelaksana;
        this.kondisi = kondisi;
        this.barang_bantuan = barang_bantuan;
        this.qty = qty;
        this.satuan = satuan;
        this.nama_petugas = nama_petugas;
        this.korwil_petugas = korwil_petugas;
        this.status = status;
    }

    public BaksosDetail() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getTgl_baksos() {
        return tgl_baksos;
    }

    public void setTgl_baksos(String tgl_baksos) {
        this.tgl_baksos = tgl_baksos;
    }

    public String getJenis_baksos() {
        return jenis_baksos;
    }

    public void setJenis_baksos(String jenis_baksos) {
        this.jenis_baksos = jenis_baksos;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getAlamat_baksos() {
        return alamat_baksos;
    }

    public void setAlamat_baksos(String alamat_baksos) {
        this.alamat_baksos = alamat_baksos;
    }

    public String getPenanggung_jawab() {
        return penanggung_jawab;
    }

    public void setPenanggung_jawab(String penanggung_jawab) {
        this.penanggung_jawab = penanggung_jawab;
    }

    public String getJabatan_pj() {
        return jabatan_pj;
    }

    public void setJabatan_pj(String jabatan_pj) {
        this.jabatan_pj = jabatan_pj;
    }

    public String getAlamat_pj() {
        return alamat_pj;
    }

    public void setAlamat_pj(String alamat_pj) {
        this.alamat_pj = alamat_pj;
    }

    public String getKorwil_pelaksana() {
        return korwil_pelaksana;
    }

    public void setKorwil_pelaksana(String korwil_pelaksana) {
        this.korwil_pelaksana = korwil_pelaksana;
    }

    public String getKondisi() {
        return kondisi;
    }

    public void setKondisi(String kondisi) {
        this.kondisi = kondisi;
    }

    public String getBarang_bantuan() {
        return barang_bantuan;
    }

    public void setBarang_bantuan(String barang_bantuan) {
        this.barang_bantuan = barang_bantuan;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getSatuan() {
        return satuan;
    }

    public void setSatuan(String satuan) {
        this.satuan = satuan;
    }

    public String getNama_petugas() {
        return nama_petugas;
    }

    public void setNama_petugas(String nama_petugas) {
        this.nama_petugas = nama_petugas;
    }

    public String getKorwil_petugas() {
        return korwil_petugas;
    }

    public void setKorwil_petugas(String korwil_petugas) {
        this.korwil_petugas = korwil_petugas;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "BaksosDetail{" +
                "id=" + id +
                ", kode='" + kode + '\'' +
                ", deskripsi='" + deskripsi + '\'' +
                ", tgl_baksos='" + tgl_baksos + '\'' +
                ", jenis_baksos='" + jenis_baksos + '\'' +
                ", longitude='" + longitude + '\'' +
                ", latitude='" + latitude + '\'' +
                ", alamat_baksos='" + alamat_baksos + '\'' +
                ", penanggung_jawab='" + penanggung_jawab + '\'' +
                ", jabatan_pj='" + jabatan_pj + '\'' +
                ", alamat_pj='" + alamat_pj + '\'' +
                ", korwil_pelaksana='" + korwil_pelaksana + '\'' +
                ", kondisi='" + kondisi + '\'' +
                ", barang_bantuan='" + barang_bantuan + '\'' +
                ", qty='" + qty + '\'' +
                ", satuan='" + satuan + '\'' +
                ", nama_petugas='" + nama_petugas + '\'' +
                ", korwil_petugas='" + korwil_petugas + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
