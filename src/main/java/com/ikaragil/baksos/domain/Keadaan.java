package com.ikaragil.baksos.domain;

public class Keadaan {

    private Long id;
    private String nama;

    public Keadaan(Long id, String nama) {
        this.id = id;
        this.nama = nama;
    }

    public Keadaan() {
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
        return "Keadaan{" +
                "id=" + id +
                ", nama='" + nama + '\'' +
                '}';
    }
}
