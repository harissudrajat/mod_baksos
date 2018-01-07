package com.ikaragil.baksos.service.impl;

import com.ikaragil.baksos.domain.Jenis;
import com.ikaragil.baksos.domain.Search;
import com.ikaragil.baksos.repository.impl.JenisDaoImpl;
import com.ikaragil.baksos.service.JenisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class JenisServiceImpl implements JenisService {

    @Autowired
    private JenisDaoImpl jenisDao;

    @Override
    public Map findAll() {
        Map m = new HashMap();
        List<Jenis> findAll = jenisDao.findAll();
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
    public Map create(Jenis jenis) {
        Map m = new HashMap();
        if (jenis.getId() == null) {
            m.put("data", jenisDao.create(jenis));
            m.put("kode", "00");
            m.put("response", "Sukses");
        } else {
            m.put("kode", "01");
            m.put("response", "Gagal");
        }
        return m;
    }

    @Override
    public Map update(Jenis jenis) {
        Map m = new HashMap();
        if (jenis.getId() != null) {
            List<Jenis> findById = jenisDao.findById(jenis.getId());
            if (findById.isEmpty()) {
                m.put("kode", "01");
                m.put("response", "Id not found");
            } else {
                m.put("data", jenisDao.update(jenis));
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
    public Map delete(Jenis jenis) {
        Map m = new HashMap();
        if (jenis.getId() != null) {
            List<Jenis> findById = jenisDao.findById(jenis.getId());
            if (findById.isEmpty()) {
                m.put("kode", "01");
                m.put("response", "Id not found");
            } else {
                m.put("data", jenisDao.delete(jenis));
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
            List<Jenis> findById = jenisDao.findById(Long.parseLong(search.getValue()));
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
    public Map findByNama(Search search) {
        Map m = new HashMap();
        if (search.getKey().equals("nama")) {
            List<Jenis> findByNama = jenisDao.findByNama(search.getValue());
            if (findByNama.isEmpty()) {
                m.put("kode", "01");
                m.put("response", "Data Tidak Ditemukan");
            } else {
                m.put("data", findByNama);
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
            List<Jenis> orderByNama = jenisDao.orderByNama();
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
