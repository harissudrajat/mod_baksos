package com.ikaragil.baksos.repository.impl;

import com.ikaragil.baksos.domain.PenanggungJawab;
import com.ikaragil.baksos.repository.PenanggungJawabDao;
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
public class PenanggungJawabDaoImpl implements PenanggungJawabDao {

    Logger log = LoggerFactory.getLogger(PenanggungJawabDaoImpl.class);

    @Autowired
    private JdbcTemplate jdbc;

    /*QUERY*/
    private static final String findAll = "SELECT * FROM penanggung_jawab";
    private static final String create = "INSERT INTO penanggung_jawab (nama, alamat, jabatan) VALUE (?,?,?)";
    private static final String update = "UPDATE penanggung_jawab SET nama=?, alamat=?, jabatan=? WHERE id=?";
    private static final String delete = "DELETE FROM penanggung_jawab WHERE id=?";
    private static final String orderByNama = "SELECT * FROM penanggung_jawab ORDER BY nama";
    private static final String findById = "SELECT * FROM penanggung_jawab WHERE id=?";
    private static final String findByNama = "SELECT * FROM penanggung_jawab WHERE nama=?";


    @Override
    public List<PenanggungJawab> findAll() {
        return jdbc.query(findAll, new PJRowMapper());
    }

    @Override
    public int create(PenanggungJawab penanggungJawab) {
        return jdbc.update(create, new Object[]{
                penanggungJawab.getNama(),
                penanggungJawab.getAlamat(),
                penanggungJawab.getJabatan()
        });
    }

    @Override
    public int update(PenanggungJawab penanggungJawab) {
        return jdbc.update(update, new Object[]{
                penanggungJawab.getNama(),
                penanggungJawab.getAlamat(),
                penanggungJawab.getJabatan(),
                penanggungJawab.getId()
        });
    }

    @Override
    public int delete(PenanggungJawab penanggungJawab) {
        return jdbc.update(delete, new Object[]{
                penanggungJawab.getId()
        });
    }

    @Override
    public List<PenanggungJawab> orderByNama() {
        return jdbc.query(orderByNama, new PJRowMapper());
    }

    @Override
    public List<PenanggungJawab> findById(Integer id) {
        return jdbc.query(findById, new Object[]{id}, new PJRowMapper());
    }

    @Override
    public List<PenanggungJawab> findByNama(String nama) {
        return jdbc.query(findByNama, new Object[]{nama}, new PJRowMapper());
    }

    private class PJRowMapper implements RowMapper<PenanggungJawab> {
        @Override
        public PenanggungJawab mapRow(ResultSet rs, int i) throws SQLException {
            PenanggungJawab pj = new PenanggungJawab();
            pj.setId(rs.getLong("id"));
            pj.setNama(rs.getString("nama"));
            pj.setAlamat(rs.getString("alamat"));
            pj.setJabatan(rs.getString("jabatan"));
            return pj;
        }
    }
}
