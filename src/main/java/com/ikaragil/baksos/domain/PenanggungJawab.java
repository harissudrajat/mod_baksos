package com.ikaragil.baksos.domain;

public class PenanggungJawab {
    private Long id;
    private String nama;
    private String alamat;
    private String jabatan;

    public PenanggungJawab(Long id, String nama, String alamat, String jabatan) {
        this.id = id;
        this.nama = nama;
        this.alamat = alamat;
        this.jabatan = jabatan;
    }

    public PenanggungJawab() {
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

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    @Override
    public String toString() {
        return "PenanggungJawab{" +
                "id=" + id +
                ", nama='" + nama + '\'' +
                ", alamat='" + alamat + '\'' +
                ", jabatan='" + jabatan + '\'' +
                '}';
    }
}
