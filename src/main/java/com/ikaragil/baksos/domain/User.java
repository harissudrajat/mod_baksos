package com.ikaragil.baksos.domain;

public class User {

    private Long id;
    private String nama;
    private Long id_korwil;
    private String tgl_input;
    private String tgl_update;

    public User(Long id, String nama, Long id_korwil, String tgl_input, String tgl_update) {
        this.id = id;
        this.nama = nama;
        this.id_korwil = id_korwil;
        this.tgl_input = tgl_input;
        this.tgl_update = tgl_update;
    }

    public User() {
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

    public Long getId_korwil() {
        return id_korwil;
    }

    public void setId_korwil(Long id_korwil) {
        this.id_korwil = id_korwil;
    }

    public String getTgl_input() {
        return tgl_input;
    }

    public void setTgl_input(String tgl_input) {
        this.tgl_input = tgl_input;
    }

    public String getTgl_update() {
        return tgl_update;
    }

    public void setTgl_update(String tgl_update) {
        this.tgl_update = tgl_update;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nama='" + nama + '\'' +
                ", id_korwil=" + id_korwil +
                ", tgl_input='" + tgl_input + '\'' +
                ", tgl_update='" + tgl_update + '\'' +
                '}';
    }
}
