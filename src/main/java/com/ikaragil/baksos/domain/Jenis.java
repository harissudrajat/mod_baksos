package com.ikaragil.baksos.domain;

public class Jenis {

    private Integer id;
    private String nama;

    public Jenis(Integer id, String nama) {
        this.id = id;
        this.nama = nama;
    }

    public Jenis() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    @Override
    public String toString() {
        return "Jenis{" +
                "id=" + id +
                ", nama='" + nama + '\'' +
                '}';
    }
}
