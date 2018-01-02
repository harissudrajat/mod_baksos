package com.ikaragil.baksos.service.impl;

import com.ikaragil.baksos.domain.PenanggungJawab;
import com.ikaragil.baksos.repository.impl.PenanggungJawabDaoImpl;
import com.ikaragil.baksos.service.PenanggungJawabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PenanggungJawabServiceImpl implements PenanggungJawabService {

    @Autowired
    private PenanggungJawabDaoImpl pjDao;

    @Override
    public List<PenanggungJawab> findAll() {
        return pjDao.findAll();
    }

    @Override
    public int create(PenanggungJawab penanggungJawab) {
        return pjDao.create(penanggungJawab);
    }

    @Override
    public int update(PenanggungJawab penanggungJawab) {
        return pjDao.update(penanggungJawab);
    }

    @Override
    public int delete(PenanggungJawab penanggungJawab) {
        return pjDao.delete(penanggungJawab);
    }

    @Override
    public List<PenanggungJawab> findById(Integer id) {
        return pjDao.findById(id);
    }

    @Override
    public List<PenanggungJawab> findByNama(String nama) {
        return pjDao.findByNama(nama);
    }

    @Override
    public List<PenanggungJawab> orderByNama() {
        return pjDao.orderByNama();
    }
}
