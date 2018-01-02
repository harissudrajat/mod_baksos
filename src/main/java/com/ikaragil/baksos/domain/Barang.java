package com.ikaragil.baksos.domain;

public class Barang {

    private Long id;
    private String nama;
    private Integer id_keadaaan;

    public Barang(Long id, String nama, Integer id_keadaaan) {
        this.id = id;
        this.nama = nama;
        this.id_keadaaan = id_keadaaan;
    }

    public Barang() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Integer getId_keadaaan() {
        return id_keadaaan;
    }

    public void setId_keadaaan(Integer id_keadaaan) {
        this.id_keadaaan = id_keadaaan;
    }

    @Override
    public String toString() {
        return "Barang{" +
                "id=" + id +
                ", nama='" + nama + '\'' +
                ", id_keadaaan=" + id_keadaaan +
                '}';
    }
}
