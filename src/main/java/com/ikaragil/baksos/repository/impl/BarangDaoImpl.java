package com.ikaragil.baksos.repository.impl;

import com.ikaragil.baksos.domain.Barang;
import com.ikaragil.baksos.domain.Search;
import com.ikaragil.baksos.repository.BarangDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class BarangDaoImpl implements BarangDao {

    Logger log = LoggerFactory.getLogger(BarangDaoImpl.class);

    /*QUERY*/
    private static final String findAll = "SELECT*FROM barang";
    private static final String create = "INSERT INTO barang (nama, id_keadaan) VALUE (?,?)";
    private static final String update = "UPDATE barang SET nama=?, id_keadaan=? WHERE id=?";
    private static final String delete = "DELETE FROM barang WHERE id=?";
    private static final String orderByNama = "SELECT*FROM barang ORDER BY nama";
    private static final String findById = "SELECT*FROM barang WHERE id=?";
    private static final String findByNama = "SELECT*FROM barang WHERE nama=?";

    @Autowired
    private JdbcTemplate jdbc;

    @Override
    public List<Barang> findAll() {
        return jdbc.query(findAll, new BarangRowMapper());
    }

    @Override
    public int create(Barang barang) {
        return jdbc.update(create, new Object[]{
                barang.getNama(),
                barang.getId_keadaaan()
        });
    }

    @Override
    public int update(Barang barang) {
        return jdbc.update(update, new Object[]{
                barang.getNama(),
                barang.getId_keadaaan(),
                barang.getId()
        });
    }

    @Override
    public int delete(Barang barang) {
        return jdbc.update(delete, new Object[]{
                barang.getId()
        });
    }

    @Override
    public List<Barang> orderByNama() {
        return jdbc.query(orderByNama, new BarangRowMapper());
    }

    @Override
    public List<Barang> findById(Integer id) {
        return jdbc.query(findById, new Object[]{id}, new BarangRowMapper());
    }

    @Override
    public List<Barang> findByNama(String nama) {
        return jdbc.query(findByNama, new Object[]{nama}, new BarangRowMapper());
    }

    private class BarangRowMapper implements RowMapper<Barang> {
        @Override
        public Barang mapRow(ResultSet rs, int i) throws SQLException {
            Barang brg = new Barang();
            brg.setId(rs.getLong("id"));
            brg.setNama(rs.getString("nama"));
            brg.setId_keadaaan(rs.getInt("id_keadaan"));
            return brg;
        }
    }
}
