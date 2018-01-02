package com.ikaragil.baksos.service.impl;

import com.ikaragil.baksos.domain.User;
import com.ikaragil.baksos.repository.impl.UserDaoImpl;
import com.ikaragil.baksos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDaoImpl userDao;

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public int create(User user) {
        return userDao.create(user);
    }

    @Override
    public int update(User user) {
        return userDao.update(user);
    }

    @Override
    public int delete(User user) {
        return userDao.delete(user);
    }

    @Override
    public List<User> findById(Integer id) {
        return userDao.findById(id);
    }

    @Override
    public List<User> findByNama(String nama) {
        return userDao.findByNama(nama);
    }

    @Override
    public List<User> orderByNama() {
        return userDao.orderByNama();
    }
}
