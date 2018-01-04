package com.ikaragil.baksos.repository.impl;

import com.ikaragil.baksos.domain.Korwil;
import com.ikaragil.baksos.repository.KorwilDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class KorwilDaoImpl implements KorwilDao {

    /*QUERY*/
    private static final String findAll = "SELECT * FROM korwil";
    private static final String create = "INSERT INTO korwil (nama, alamat) VALUE (?,?)";
    private static final String update = "UPDATE korwil SET nama=?, alamat=? WHERE id=?";
    private static final String delete = "DELETE FROM korwil WHERE id=?";
    private static final String orderByNama = "SELECT * FROM korwil ORDER BY nama";
    private static final String findById = "SELECT * FROM korwil WHERE id=?";
    private static final String findByNama = "SELECT * FROM korwil WHERE nama=?";

    @Autowired
    private JdbcTemplate jdbc;

    @Override
    public List<Korwil> findAll() {
        return jdbc.query(findAll, new KorwilRowMapper());
    }

    @Override
    public int create(Korwil korwil) {
        return jdbc.update(create, new Object[]{
                korwil.getNama(),
                korwil.getAlamat()
        });
    }

    @Override
    public int update(Korwil korwil) {
        return jdbc.update(update, new Object[]{
                korwil.getNama(),
                korwil.getAlamat(),
                korwil.getId()
        });
    }

    @Override
    public int delete(Korwil korwil) {
        return jdbc.update(delete, new Object[]{
                korwil.getId()
        });
    }

    @Override
    public List<Korwil> orderByNama() {
        return jdbc.query(orderByNama, new KorwilRowMapper());
    }

    @Override
    public List<Korwil> findById(Integer id) {
        return jdbc.query(findById, new Object[]{id}, new KorwilRowMapper());
    }

    @Override
    public List<Korwil> findByNama(String nama) {
        return jdbc.query(findByNama, new Object[]{nama}, new KorwilRowMapper());
    }

    private class KorwilRowMapper implements RowMapper<Korwil> {
        @Override
        public Korwil mapRow(ResultSet rs, int i) throws SQLException {
            Korwil korwil = new Korwil();
            korwil.setId(rs.getLong("id"));
            korwil.setNama(rs.getString("nama"));
            korwil.setAlamat(rs.getString("alamat"));
            return korwil;
        }
    }
}
