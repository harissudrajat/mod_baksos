package com.ikaragil.baksos.repository.impl;

import com.ikaragil.baksos.domain.Keadaan;
import com.ikaragil.baksos.repository.KeadaanDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class KeadaanDaoImpl implements KeadaanDao {

    @Autowired
    private JdbcTemplate jdbc;

    /*QUERY*/
    private static final String findAll = "SELECT * FROM keadaan";
    private static final String create = "INSERT INTO keadaan (nama) VALUE (?)";
    private static final String update = "UPDATE keadaan SET nama=? WHERE id=?";
    private static final String delete = "DELETE FROM keadaan WHERE id=?";
    private static final String orderByNama = "SELECT * FROM keadaan ORDER BY nama";
    private static final String findById = "SELECT * FROM keadaan WHERE id=?";
    private static final String findByNama = "SELECT * FROM keadaan WHERE nama=?";

    @Override
    public List<Keadaan> findAll() {
        return jdbc.query(findAll, new KeadaanRowMapper());
    }

    @Override
    public int create(Keadaan keadaan) {
        return jdbc.update(create, new Object[]{keadaan.getNama()});
    }

    @Override
    public int update(Keadaan keadaan) {
        return jdbc.update(update, new Object[]{keadaan.getNama(), keadaan.getId()});
    }

    @Override
    public int delete(Keadaan keadaan) {
        return jdbc.update(delete, new Object[]{keadaan.getId()});
    }

    @Override
    public List<Keadaan> orderByNama() {
        return jdbc.query(orderByNama, new KeadaanRowMapper());
    }

    @Override
    public List<Keadaan> findById(Long id) {
        return jdbc.query(findById, new Object[]{id}, new KeadaanRowMapper());
    }

    @Override
    public List<Keadaan> findByNama(String nama) {
        return jdbc.query(findByNama, new Object[]{nama}, new KeadaanRowMapper());
    }

    private class KeadaanRowMapper implements RowMapper<Keadaan> {
        @Override
        public Keadaan mapRow(ResultSet rs, int i) throws SQLException {
            Keadaan kd = new Keadaan();
            kd.setId(rs.getLong("id"));
            kd.setNama(rs.getString("nama"));
            return kd;
        }
    }
}
