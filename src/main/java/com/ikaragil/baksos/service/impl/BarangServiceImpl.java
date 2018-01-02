package com.ikaragil.baksos.service.impl;

import com.ikaragil.baksos.domain.Barang;
import com.ikaragil.baksos.repository.impl.BarangDaoImpl;
import com.ikaragil.baksos.service.BarangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BarangServiceImpl implements BarangService {

    @Autowired
    private BarangDaoImpl barangDao;

    @Override
    public List<Barang> findAll() {
        return barangDao.findAll();
    }

    @Override
    public int create(Barang barang) {
        return barangDao.create(barang);
    }

    @Override
    public int update(Barang barang) {
        return barangDao.update(barang);
    }

    @Override
    public int delete(Barang barang) {
        return barangDao.delete(barang);
    }

    @Override
    public List<Barang> findById(Integer id) {
        return barangDao.findById(id);
    }

    @Override
    public List<Barang> findByNama(String nama) {
        return barangDao.findByNama(nama);
    }

    @Override
    public List<Barang> orderByNama() {
        return barangDao.orderByNama();
    }
}
