package com.ikaragil.baksos.service.impl;

import com.ikaragil.baksos.domain.Keadaan;
import com.ikaragil.baksos.domain.Search;
import com.ikaragil.baksos.repository.impl.KeadaanDaoImpl;
import com.ikaragil.baksos.service.KeadaanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class KeadaanServiceImpl implements KeadaanService {

    @Autowired
    private KeadaanDaoImpl keadaanDao;

    @Override
    public Map findByNama(Search search) {
        Map m = new HashMap();
        if (search.getKey().equals("nama")) {
            List<Keadaan> findBynama = keadaanDao.findByNama(search.getValue());
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
        List<Keadaan> findAll = keadaanDao.findAll();
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
    public Map create(Keadaan keadaan) {
        Map m = new HashMap();
        if (keadaan.getId() == null) {
            m.put("data", keadaanDao.create(keadaan));
            m.put("kode", "00");
            m.put("response", "Sukses");
        } else {
            m.put("kode", "01");
            m.put("response", "Gagal");
        }
        return m;
    }

    @Override
    public Map update(Keadaan keadaan) {
        Map m = new HashMap();
        if (keadaan.getId() != null) {
            List<Keadaan> findId = keadaanDao.findById(keadaan.getId());
            if (findId.isEmpty()) {
                m.put("kode", "01");
                m.put("response", "Id tidak ditemukan");
            } else {
                m.put("data", keadaanDao.update(keadaan));
                m.put("kode", "00");
                m.put("response", "Sukses");
            }
        } else {
            m.put("kode", "01");
            m.put("response", "Gagal");
        }
        return m;
    }

    @Override
    public Map delete(Keadaan keadaan) {
        Map m = new HashMap();
        if (keadaan.getId() != null) {
            List<Keadaan> findId = keadaanDao.findById(keadaan.getId());
            if (findId.isEmpty()) {
                m.put("kode", "01");
                m.put("response", "Id tidak ditemukan");
            } else {
                m.put("data", keadaanDao.delete(keadaan));
                m.put("kode", "00");
                m.put("response", "Sukses");
            }
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
            List<Keadaan> findById = keadaanDao.findById(Long.parseLong(search.getValue()));
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
            List<Keadaan> orderByNama = keadaanDao.orderByNama();
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
