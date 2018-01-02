package com.ikaragil.baksos.service.impl;

import com.ikaragil.baksos.domain.Keadaan;
import com.ikaragil.baksos.repository.impl.KeadaanDaoImpl;
import com.ikaragil.baksos.service.KeadaanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KeadaanServiceImpl implements KeadaanService {

    @Autowired
    private KeadaanDaoImpl keadaanDao;

    @Override
    public List<Keadaan> findAll() {
        return keadaanDao.findAll();
    }

    @Override
    public int create(Keadaan keadaan) {
        return keadaanDao.create(keadaan);
    }

    @Override
    public int update(Keadaan keadaan) {
        return keadaanDao.update(keadaan);
    }

    @Override
    public int delete(Keadaan keadaan) {
        return keadaanDao.delete(keadaan);
    }

    @Override
    public List<Keadaan> findById(Integer id) {
        return keadaanDao.findById(id);
    }

    @Override
    public List<Keadaan> findByNama(String nama) {
        return keadaanDao.findByNama(nama);
    }

    @Override
    public List<Keadaan> orderByNama() {
        return keadaanDao.orderByNama();
    }
}
