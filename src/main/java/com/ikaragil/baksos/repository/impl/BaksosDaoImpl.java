package com.ikaragil.baksos.repository.impl;

import com.ikaragil.baksos.domain.Baksos;
import com.ikaragil.baksos.repository.BaksosDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class BaksosDaoImpl implements BaksosDao {

    /*QUERY*/
    private static final String create = "INSERT INTO baksos (kode,deskripsi,tgl_baksos,id_jenis,longitude, latitude,alamat,id_pj,id_korwil,id_keadaan,id_barang,qty,satuan,tgl_input,id_user,ket) VALUE (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private static final String update = "UPDATE baksos SET kode=?, deskripsi=?, tgl_baksos=?, id_jenis=?, longitude=?, latitude=?, alamat=?, id_pj=?, id_korwil=?, id_keadaan=?, id_barang=?, qty=?, satuan=?, tgl_input=?, id_user=?,ket=? WHERE id=?";
    private static final String delete = "DELETE FROM baksos WHERE id=?";
    private static final String orderByNama = "SELECT * FROM baksos ORDER BY kode";
    private static final String findAll = "SELECT * FROM baksos";
    private static final String findById = "SELECT * FROM baksos WHERE id=?";
    private static final String findByNama = "SELECT * FROM baksos WHERE kode=?";
    private static final String findByKorwil = "SELECT * FROM baksos WHERE id_korwil=?";
    private static final String findByStatus = "SELECT * FROM baksos WHERE ket=?";
    private static final String countKode = "SELECT COUNT(id) FROM baksos";

    @Autowired
    private JdbcTemplate jdbc;

    @Override
    public List<Baksos> findAll() {
        return jdbc.query(findAll, new BaksosRowMapper());
    }

    @Override
    public int create(Baksos baksos) {
        return jdbc.update(create, new Object[]{
                baksos.getKode(),
                baksos.getDeskripsi(),
                baksos.getTgl_baksos(),
                baksos.getId_jenis(),
                baksos.getLongitude(),
                baksos.getLatitude(),
                baksos.getAlamat(),
                baksos.getId_penanggungjawab(),
                baksos.getId_korwil(),
                baksos.getId_keadaan(),
                baksos.getId_barang(),
                baksos.getQuantity(),
                baksos.getSatuan(),
                baksos.getTgl_input(),
                baksos.getId_user(),
                baksos.getStatus()
        });
    }

    @Override
    public int update(Baksos baksos) {
        return jdbc.update(update, new Object[]{
                baksos.getKode(),
                baksos.getDeskripsi(),
                baksos.getTgl_baksos(),
                baksos.getId_jenis(),
                baksos.getLongitude(),
                baksos.getLatitude(),
                baksos.getAlamat(),
                baksos.getId_penanggungjawab(),
                baksos.getId_korwil(),
                baksos.getId_keadaan(),
                baksos.getId_barang(),
                baksos.getQuantity(),
                baksos.getSatuan(),
                baksos.getTgl_input(),
                baksos.getId_user(),
                baksos.getStatus(),
                baksos.getId()
        });
    }

    @Override
    public int delete(Baksos baksos) {
        return jdbc.update(delete, new Object[]{baksos.getId()});
    }

    @Override
    public List<Baksos> orderByNama() {
        return jdbc.query(orderByNama, new BaksosRowMapper());
    }

    @Override
    public List<Baksos> findById(Integer id) {
        return jdbc.query(findById, new Object[]{id}, new BaksosRowMapper());
    }

    @Override
    public List<Baksos> findByKode(String kode) {
        return jdbc.query(findByNama, new Object[]{kode}, new BaksosRowMapper());
    }

    @Override
    public List<String> getLastKode() {
        return jdbc.query(countKode, new KodeRowMapper());
    }

    @Override
    public List<Baksos> findByKorwil(Integer id_korwil) {
        return jdbc.query(findByKorwil, new Object[]{id_korwil}, new BaksosRowMapper());
    }

    @Override
    public List<Baksos> findByStatus(String status) {
        return jdbc.query(findByStatus, new Object[]{status}, new BaksosRowMapper());
    }

    private class BaksosRowMapper implements RowMapper<Baksos> {
        @Override
        public Baksos mapRow(ResultSet rs, int i) throws SQLException {
            Baksos baksos = new Baksos();
            baksos.setId(rs.getLong("id"));
            baksos.setKode(rs.getString("kode"));
            baksos.setDeskripsi(rs.getString("deskripsi"));
            baksos.setTgl_baksos(rs.getString("tgl_baksos"));
            baksos.setLongitude(rs.getString("longitude"));
            baksos.setLatitude(rs.getString("latitude"));
            baksos.setAlamat(rs.getString("alamat"));
            baksos.setId_penanggungjawab(rs.getInt("id_pj"));
            baksos.setId_korwil(rs.getInt("id_korwil"));
            baksos.setId_keadaan(rs.getInt("id_keadaan"));
            baksos.setId_barang(rs.getInt("id_barang"));
            baksos.setQuantity(rs.getString("qty"));
            baksos.setSatuan(rs.getString("satuan"));
            baksos.setTgl_input(rs.getString("tgl_input"));
            baksos.setId_user(rs.getInt("id_user"));
            baksos.setStatus(rs.getString("ket"));
            return baksos;
        }
    }

    private class KodeRowMapper implements RowMapper<String> {
        @Override
        public String mapRow(ResultSet resultSet, int i) throws SQLException {
            return resultSet.getString("jumlah");
        }
    }
}
