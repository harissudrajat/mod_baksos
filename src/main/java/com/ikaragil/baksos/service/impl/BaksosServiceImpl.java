package com.ikaragil.baksos.service.impl;

import com.ikaragil.baksos.domain.Baksos;
import com.ikaragil.baksos.repository.impl.BaksosDaoImpl;
import com.ikaragil.baksos.service.BaksosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BaksosServiceImpl implements BaksosService {

    @Autowired
    private BaksosDaoImpl baksosDao;

    @Override
    public List<Baksos> findByKorwil(Integer id_korwil) {
        return baksosDao.findByKorwil(id_korwil);
    }

    @Override
    public List<Baksos> findByStatus(String status) {
        try {
            return baksosDao.findByStatus(status);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Baksos> findAll() {
        try {
            return baksosDao.findAll();
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public int create(Baksos baksos) {
        return baksosDao.create(baksos);
    }

    @Override
    public int update(Baksos baksos) {
        return baksosDao.update(baksos);
    }

    @Override
    public int delete(Baksos baksos) {
        return baksosDao.delete(baksos);
    }

    @Override
    public List<Baksos> findById(Integer id) {
        return baksosDao.findById(id);
    }

    @Override
    public List<Baksos> findByNama(String nama) {
        return baksosDao.findByNama(nama);
    }

    @Override
    public List<Baksos> orderByNama() {
        return baksosDao.orderByNama();
    }
}
