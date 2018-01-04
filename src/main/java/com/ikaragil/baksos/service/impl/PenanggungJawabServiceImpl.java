package com.ikaragil.baksos.service.impl;

import com.ikaragil.baksos.domain.PenanggungJawab;
import com.ikaragil.baksos.domain.Search;
import com.ikaragil.baksos.repository.impl.PenanggungJawabDaoImpl;
import com.ikaragil.baksos.service.PenanggungJawabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PenanggungJawabServiceImpl implements PenanggungJawabService {

    @Autowired
    private PenanggungJawabDaoImpl pjDao;

    @Override
    public Map findByNama(Search search) {
        Map m = new HashMap();
        if (search.getKey().equals("nama")) {
            List<PenanggungJawab> findBynama = pjDao.findByNama(search.getValue());
            if (findBynama.isEmpty()) {
                m.put("kode", "01");
                m.put("response", "Data Tidak Ditemukan");
            } else {
                m.put("data", findBynama);
                m.put("kode", "00");
                m.put("response", "Data Ditemukan");
            }
        } else {
            m.put("kode", "02");
            m.put("response", "Keyword Salah");
        }
        return m;
    }

    @Override
    public Map findAll() {
        Map m = new HashMap();
        List<PenanggungJawab> findAll = pjDao.findAll();
        if (findAll.isEmpty()) {
            m.put("kode", "01");
            m.put("response", "Data Tidak Ditemukan");
        } else {
            m.put("data", findAll);
            m.put("kode", "00");
            m.put("response", "Data Ditemukan");
        }
        return m;
    }

    @Override
    public Map create(PenanggungJawab pj) {
        Map m = new HashMap();
        if (pj.getId() == null) {
            m.put("data", pjDao.create(pj));
            m.put("kode", "00");
            m.put("response", "Sukses");
        } else {
            m.put("kode", "01");
            m.put("response", "Gagal");
        }
        return m;
    }

    @Override
    public Map update(PenanggungJawab pj) {
        Map m = new HashMap();
        if (pj.getId() != null) {
            m.put("data", pjDao.update(pj));
            m.put("kode", "00");
            m.put("response", "Sukses");
        } else {
            m.put("kode", "01");
            m.put("response", "Gagal");
        }
        return m;
    }

    @Override
    public Map delete(PenanggungJawab pj) {
        Map m = new HashMap();
        if (pj.getId() != null) {
            m.put("data", pjDao.delete(pj));
            m.put("kode", "00");
            m.put("response", "Sukses");
        } else {
            m.put("kode", "01");
            m.put("response", "Gagal");
        }
        return m;
    }

    @Override
    public Map findById(Search search) {
        Map m = new HashMap();
        if (search.getKey().equals("id")) {
            List<PenanggungJawab> findById = pjDao.findById(Integer.parseInt(search.getValue()));
            if (findById.isEmpty()) {
                m.put("kode", "01");
                m.put("response", "Data Tidak Ditemukan");
            } else {
                m.put("data", findById);
                m.put("kode", "00");
                m.put("response", "Data Ditemukan");
            }
        } else {
            m.put("kode", "02");
            m.put("response", "Keyword Salah");
        }
        return m;
    }

    @Override
    public Map orderByNama(Search search) {
        Map m = new HashMap();
        if (search.getKey().equals("nama")) {
            List<PenanggungJawab> orderByNama = pjDao.orderByNama();
            if (orderByNama.isEmpty()) {
                m.put("kode", "01");
                m.put("response", "Data Tidak Ditemukan");
            } else {
                m.put("data", orderByNama);
                m.put("kode", "00");
                m.put("response", "Data Ditemukan");
            }
        } else {
            m.put("kode", "02");
            m.put("response", "Keyword Salah");
        }
        return m;
    }
}
