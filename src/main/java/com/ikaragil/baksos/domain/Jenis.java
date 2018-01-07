package com.ikaragil.baksos.domain;

public class Jenis {

    private Long id;
    private String nama;

    public Jenis(Long id, String nama) {
        this.id = id;
        this.nama = nama;
    }

    public Jenis() {
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

    @Override
    public String toString() {
        return "Jenis{" +
                "id=" + id +
                ", nama='" + nama + '\'' +
                '}';
    }
}
