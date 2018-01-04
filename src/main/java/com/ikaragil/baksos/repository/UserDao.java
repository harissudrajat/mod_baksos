package com.ikaragil.baksos.repository;

import com.ikaragil.baksos.domain.User;

import java.util.List;

public interface UserDao extends BaseDao<User> {

    List<User> findByNama(String nama);
}
