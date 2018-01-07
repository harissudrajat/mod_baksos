package com.ikaragil.baksos.repository.impl;

import com.ikaragil.baksos.domain.Baksos;
import com.ikaragil.baksos.domain.BaksosDetail;
import com.ikaragil.baksos.repository.BaksosDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
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
    private static final String countId = "SELECT COUNT(id) AS jumlah FROM baksos";
    private static final String lastId = "SELECT id AS akhir FROM baksos ORDER BY id DESC LIMIT 1";
    private static final String detail = "SELECT b.id, b.kode, b.deskripsi, b.tgl_baksos, jns.nama AS 'jenis_baksos', b.longitude, b.latitude, b.alamat AS 'alamat_baksos', pj.nama AS 'penanggung_jawab', pj.jabatan AS 'jabatan_pj', pj.alamat AS 'alamat_pj', kr.nama AS 'korwil_pelaksana', kd.nama AS 'kondisi',br.nama AS 'barang_bantuan', b.qty, b.satuan, ptg.nama AS 'nama_petugas', krw.nama AS 'korwil_petugas', b.ket AS 'status' FROM ((((((( baksos b JOIN jenis jns ON b.id_jenis = jns.id ) JOIN penanggung_jawab pj ON b.id_pj = pj.id) JOIN korwil kr ON b.id_korwil = kr.id) JOIN keadaan kd ON b.id_keadaan = kd.id) JOIN barang br ON kd.id = br.id_keadaan) JOIN petugas ptg ON b.id_user = ptg.id ) JOIN korwil krw ON ptg.id_korwil = krw.id) WHERE b.kode = ?";

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
    public List<Baksos> findById(Long id) {
        return jdbc.query(findById, new Object[]{id}, new BaksosRowMapper());
    }

    @Override
    public List<Baksos> findByKode(String kode) {
        return jdbc.query(findByNama, new Object[]{kode}, new BaksosRowMapper());
    }

    @Override
    public List<String> getCountId() {
        return jdbc.query(countId, new KodeRowMapper());
    }

    @Override
    public List<String> getLastId() {
        return jdbc.query(lastId, new IdRowMapper());
    }

    @Override
    public List<BaksosDetail> getDetail(String kode) {
        return jdbc.query(detail, new Object[]{kode}, new BaksosDetailRowMapper());
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

    private class IdRowMapper implements RowMapper<String> {
        @Override
        public String mapRow(ResultSet resultSet, int i) throws SQLException {
            return resultSet.getString("akhir");
        }
    }

    private class BaksosDetailRowMapper implements RowMapper<BaksosDetail> {
        @Override
        public BaksosDetail mapRow(ResultSet rs, int i) throws SQLException {
            BaksosDetail bd = new BaksosDetail();
            bd.setId(rs.getLong("id"));
            bd.setKode(rs.getString("kode"));
            bd.setDeskripsi(rs.getString("deskripsi"));
            bd.setTgl_baksos(rs.getString("tgl_baksos"));
            bd.setJenis_baksos(rs.getString("jenis_baksos"));
            bd.setLongitude(rs.getString("longitude"));
            bd.setLatitude(rs.getString("latitude"));
            bd.setAlamat_baksos(rs.getString("alamat_baksos"));
            bd.setPenanggung_jawab(rs.getString("penanggung_jawab"));
            bd.setJabatan_pj(rs.getString("jabatan_pj"));
            bd.setAlamat_pj(rs.getString("alamat_pj"));
            bd.setKorwil_pelaksana(rs.getString("korwil_pelaksana"));
            bd.setKondisi(rs.getString("kondisi"));
            bd.setBarang_bantuan(rs.getString("barang_bantuan"));
            bd.setQty(rs.getString("qty"));
            bd.setSatuan(rs.getString("satuan"));
            bd.setNama_petugas(rs.getString("nama_petugas"));
            bd.setKorwil_petugas(rs.getString("korwil_petugas"));
            bd.setStatus(rs.getString("status"));
            return bd;
        }
    }
}
