package com.ikaragil.baksos.service.impl;

import com.ikaragil.baksos.domain.Korwil;
import com.ikaragil.baksos.domain.Search;
import com.ikaragil.baksos.repository.impl.KorwilDaoImpl;
import com.ikaragil.baksos.service.KorwilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class KorwilServiceImpl implements KorwilService {

    @Autowired
    private KorwilDaoImpl korwilDao;


    @Override
    public Map findByNama(Search search) {
        Map m = new HashMap();
        if (search.getKey().equals("nama")) {
            List<Korwil> findBynama = korwilDao.findByNama(search.getValue());
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
        List<Korwil> findAll = korwilDao.findAll();
        if (findAll.isEmpty()) {
            m.put("kode", "01");
            m.put("response", "Data Tidak Ditemukan");
        } else {
            m.put("data", findAll);
            m.put("kode", "00");
            m.put("response", "Data Kosong");
        }
        return m;
    }

    @Override
    public Map create(Korwil korwil) {
        Map m = new HashMap();
        if (korwil.getId() == null) {
            m.put("data", korwilDao.create(korwil));
            m.put("kode", "00");
            m.put("response", "Sukses");
        } else {
            m.put("kode", "01");
            m.put("response", "Gagal");
        }
        return m;
    }

    @Override
    public Map update(Korwil korwil) {
        Map m = new HashMap();
        if (korwil.getId() != null) {
            List<Korwil> findById = korwilDao.findById(korwil.getId());
            if (findById.isEmpty()) {
                m.put("kode", "01");
                m.put("response", "Id not found");
            } else {
                m.put("data", korwilDao.update(korwil));
                m.put("kode", "00");
                m.put("response", "Sukses");
            }
        } else {
            m.put("kode", "02");
            m.put("response", "Keyword Salah");
        }
        return m;
    }

    @Override
    public Map delete(Korwil korwil) {
        Map m = new HashMap();
        if (korwil.getId() == null) {
            System.out.println(korwil);
            m.put("kode", "01");
            m.put("response", "id is not allow null");
        } else {
            List<Korwil> korwils = korwilDao.findById(Long.parseLong(korwil.getId().toString()));
            if (korwils.isEmpty()) {
                m.put("kode", "01");
                m.put("response", "Korwil ID is not found");
            } else {
                m.put("data", korwilDao.delete(korwil));
                m.put("kode", "00");
                m.put("response", "Berhasil di Hapus");
            }
        }
        return m;
    }

    @Override
    public Map findById(Search search) {
        Map m = new HashMap();
        if (search.getKey().equals("id")) {
            List<Korwil> findById = korwilDao.findById(Long.parseLong(search.getValue()));
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
        try {
            if (search.getKey().equals("nama")) {
                List<Korwil> orderByNama = korwilDao.orderByNama();
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
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
