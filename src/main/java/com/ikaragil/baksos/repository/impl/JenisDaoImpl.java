package com.ikaragil.baksos.repository.impl;

import com.ikaragil.baksos.domain.Jenis;
import com.ikaragil.baksos.repository.JenisDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class JenisDaoImpl implements JenisDao {

    /*QUERY START*/
    private static final String findAll = "SELECT * FROM baksos_jenis";
    private static final String create = "INSERT INTO baksos_jenis (nama) VALUE(?)";
    private static final String update = "UPDATE baksos_jenis SET nama=? WHERE id=?";
    private static final String delete = "DELETE FROM baksos_jenis WHERE id=?";
    private static final String orderByNama = "SELECT * FROM baksos_jenis ORDER BY nama";
    private static final String findById = "SELECT * FROM baksos_jenis WHERE id=?";
    private static final String findByName = "SELECT * FROM baksos_jenis WHERE nama=?";


    @Autowired
    private JdbcTemplate jdbcTemplate;

    Logger log = LoggerFactory.getLogger(JenisDaoImpl.class);

    @Override
    public List<Jenis> findAll() {
        return jdbcTemplate.query(findAll, new JenisRowMapper());
    }

    @Override
    public int create(Jenis jenis) {
        return jdbcTemplate.update(create, new Object[]{
                jenis.getNama()
        });
    }

    @Override
    public int update(Jenis jenis) {
        return jdbcTemplate.update(update, new Object[]{
                jenis.getNama(),
                jenis.getId()
        });
    }

    @Override
    public int delete(Jenis jenis) {
        return jdbcTemplate.update(delete, new Object[]{
                jenis.getId()
        });
    }

    @Override
    public List<Jenis> orderByNama() {
        return jdbcTemplate.query(orderByNama, new JenisRowMapper());
    }

    @Override
    public List<Jenis> findById(Integer id) {
        try {
            return jdbcTemplate.query(findById, new Object[]{id}, new JenisRowMapper());
        } catch (Exception e) {
            System.out.println("ERROR FIND ID: " + e.getMessage());
            return null;
        }
    }

    @Override
    public List<Jenis> findByNama(String nama) {
        try {
            return jdbcTemplate.query(findByName, new Object[]{nama}, new JenisRowMapper());
        } catch (Exception e) {
            System.out.println("ERROR FIND NAMA" + e.getMessage());
            return null;
        }
    }

    private class JenisRowMapper implements RowMapper<Jenis> {
        @Override
        public Jenis mapRow(ResultSet rs, int numRow) throws SQLException {
            Jenis jns = new Jenis();
            jns.setId(rs.getInt("id"));
            jns.setNama(rs.getString("nama"));
            return jns;
        }
    }
}
