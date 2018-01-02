package com.ikaragil.baksos.service.impl;

import com.ikaragil.baksos.domain.Korwil;
import com.ikaragil.baksos.repository.impl.KorwilDaoImpl;
import com.ikaragil.baksos.service.KorwilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KorwilServiceImpl implements KorwilService {

    @Autowired
    private KorwilDaoImpl korwilDao;

    @Override
    public List<Korwil> findAll() {
        return korwilDao.findAll();
    }

    @Override
    public int create(Korwil korwil) {
        return korwilDao.create(korwil);
    }

    @Override
    public int update(Korwil korwil) {
        return korwilDao.update(korwil);
    }

    @Override
    public int delete(Korwil korwil) {
        return korwilDao.delete(korwil);
    }

    @Override
    public List<Korwil> findById(Integer id) {
        return korwilDao.findById(id);
    }

    @Override
    public List<Korwil> findByNama(String nama) {
        return korwilDao.findByNama(nama);
    }

    @Override
    public List<Korwil> orderByNama() {
        return korwilDao.orderByNama();
    }
}
