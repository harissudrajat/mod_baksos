package com.ikaragil.baksos.service.impl;

import com.ikaragil.baksos.domain.Jenis;
import com.ikaragil.baksos.repository.impl.JenisDaoImpl;
import com.ikaragil.baksos.service.JenisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JenisServiceImpl implements JenisService {

    @Autowired
    private JenisDaoImpl jenisDao;

    @Override
    public List<Jenis> findAll() {
        return jenisDao.findAll();
    }

    @Override
    public int create(Jenis jenis) {
        return jenisDao.create(jenis);
    }

    @Override
    public int update(Jenis jenis) {
        return jenisDao.update(jenis);
    }

    @Override
    public int delete(Jenis jenis) {
        return jenisDao.delete(jenis);
    }

    @Override
    public List<Jenis> findById(Integer id) {
        return jenisDao.findById(id);
    }

    @Override
    public List<Jenis> findByNama(String nama) {
        return jenisDao.findByNama(nama);
    }

    @Override
    public List<Jenis> orderByNama() {
        return jenisDao.orderByNama();
    }

}
