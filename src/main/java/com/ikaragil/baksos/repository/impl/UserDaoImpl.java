package com.ikaragil.baksos.repository.impl;

import com.ikaragil.baksos.domain.User;
import com.ikaragil.baksos.repository.UserDao;
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
public class UserDaoImpl implements UserDao {

    Logger log = LoggerFactory.getLogger(UserDaoImpl.class);

    @Autowired
    private JdbcTemplate jdbc;

    /*QUERY*/
    private static final String findAll = "SELECT * FROM petugas";
    private static final String create = "INSERT INTO petugas (nama, alamat, id_korwil, tgl_input) VALUE (?,?,?,?)";
    private static final String update = "UPDATE petugas SET nama=?, alamat=?, jabatan=?, id_korwil=?, tgl_update=? WHERE id=?";
    private static final String delete = "DELETE FROM petugas WHERE id=?";
    private static final String orderByNama = "SELECT * FROM petugas ORDER BY nama";
    private static final String findById = "SELECT * FROM petugas WHERE id=?";
    private static final String findByNama = "SELECT * FROM petugas WHERE nama=?";

    @Override
    public List<User> findAll() {
        return jdbc.query(findAll, new UserRowMapper());
    }

    @Override
    public int create(User user) {
        return jdbc.update(create, new Object[]{
                user.getNama(),
                user.getId_korwil(),
                user.getTgl_input()
        });
    }

    @Override
    public int update(User user) {
        return jdbc.update(update, new Object[]{
                user.getNama(),
                user.getId_korwil(),
                user.getTgl_update(),
                user.getId()
        });
    }

    @Override
    public int delete(User user) {
        return jdbc.update(delete, new Object[]{
                user.getId()
        });
    }

    @Override
    public List<User> orderByNama() {
        return jdbc.query(orderByNama, new UserRowMapper());
    }

    @Override
    public List<User> findById(Integer id) {
        return jdbc.query(findById, new Object[]{id}, new UserRowMapper());
    }

    @Override
    public List<User> findByNama(String nama) {
        return jdbc.query(findByNama, new Object[]{nama}, new UserRowMapper());
    }

    private class UserRowMapper implements RowMapper<User> {
        @Override
        public User mapRow(ResultSet rs, int i) throws SQLException {
            User user = new User();
            user.setId(rs.getLong("id"));
            user.setNama(rs.getString("nama"));
            user.setId_korwil(rs.getLong("id_korwil"));
            user.setTgl_input(rs.getString("tgl_input"));
            user.setTgl_update(rs.getString("tgl_update"));
            return user;
        }
    }
}
