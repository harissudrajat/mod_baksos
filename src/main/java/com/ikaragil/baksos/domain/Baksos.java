package com.ikaragil.baksos.domain;

public class Baksos {
    private Long id;
    private String kode;
    private String deskripsi;
    private String tgl_baksos;
    private Integer id_jenis;
    private String longitude;
    private String latitude;
    private String alamat;
    private Integer id_penanggungjawab;
    private Integer id_korwil;
    private Integer id_keadaan;
    private Integer id_barang;
    private String quantity;
    private String satuan;
    private String tgl_input;
    private Integer id_user;
    private String status;

    public Baksos(Long id, String kode, String deskripsi, String tgl_baksos, Integer id_jenis, String longitude, String latitude, String alamat, Integer id_penanggungjawab, Integer id_korwil, Integer id_keadaan, Integer id_barang, String quantity, String satuan, String tgl_input, Integer id_user, String status) {
        this.id = id;
        this.kode = kode;
        this.deskripsi = deskripsi;
        this.tgl_baksos = tgl_baksos;
        this.id_jenis = id_jenis;
        this.longitude = longitude;
        this.latitude = latitude;
        this.alamat = alamat;
        this.id_penanggungjawab = id_penanggungjawab;
        this.id_korwil = id_korwil;
        this.id_keadaan = id_keadaan;
        this.id_barang = id_barang;
        this.quantity = quantity;
        this.satuan = satuan;
        this.tgl_input = tgl_input;
        this.id_user = id_user;
        this.status = status;
    }

    public Baksos() {
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

    public Integer getId_jenis() {
        return id_jenis;
    }

    public void setId_jenis(Integer id_jenis) {
        this.id_jenis = id_jenis;
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

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public Integer getId_penanggungjawab() {
        return id_penanggungjawab;
    }

    public void setId_penanggungjawab(Integer id_penanggungjawab) {
        this.id_penanggungjawab = id_penanggungjawab;
    }

    public Integer getId_korwil() {
        return id_korwil;
    }

    public void setId_korwil(Integer id_korwil) {
        this.id_korwil = id_korwil;
    }

    public Integer getId_keadaan() {
        return id_keadaan;
    }

    public void setId_keadaan(Integer id_keadaan) {
        this.id_keadaan = id_keadaan;
    }

    public Integer getId_barang() {
        return id_barang;
    }

    public void setId_barang(Integer id_barang) {
        this.id_barang = id_barang;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getSatuan() {
        return satuan;
    }

    public void setSatuan(String satuan) {
        this.satuan = satuan;
    }

    public String getTgl_input() {
        return tgl_input;
    }

    public void setTgl_input(String tgl_input) {
        this.tgl_input = tgl_input;
    }

    public Integer getId_user() {
        return id_user;
    }

    public void setId_user(Integer id_user) {
        this.id_user = id_user;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Baksos{" +
                "id=" + id +
                ", kode='" + kode + '\'' +
                ", deskripsi='" + deskripsi + '\'' +
                ", tgl_baksos='" + tgl_baksos + '\'' +
                ", id_jenis=" + id_jenis +
                ", longitude='" + longitude + '\'' +
                ", latitude='" + latitude + '\'' +
                ", alamat='" + alamat + '\'' +
                ", id_penanggungjawab=" + id_penanggungjawab +
                ", id_korwil=" + id_korwil +
                ", id_keadaan=" + id_keadaan +
                ", id_barang=" + id_barang +
                ", quantity='" + quantity + '\'' +
                ", satuan='" + satuan + '\'' +
                ", tgl_input='" + tgl_input + '\'' +
                ", id_user=" + id_user +
                ", status='" + status + '\'' +
                '}';
    }
}
