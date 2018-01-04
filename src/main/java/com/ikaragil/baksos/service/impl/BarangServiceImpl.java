package com.ikaragil.baksos.service.impl;

import com.ikaragil.baksos.domain.Barang;
import com.ikaragil.baksos.domain.Search;
import com.ikaragil.baksos.repository.impl.BarangDaoImpl;
import com.ikaragil.baksos.service.BarangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BarangServiceImpl implements BarangService {

    @Autowired
    private BarangDaoImpl barangDao;

    @Override
    public Map findAll() {
        Map m = new HashMap();
        List<Barang> findAll = barangDao.findAll();
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
    public Map create(Barang barang) {
        Map m = new HashMap();
        if (barang.getId() == null) {
            m.put("data", barangDao.create(barang));
            m.put("kode", "00");
            m.put("response", "Sukses");
        } else {
            m.put("kode", "01");
            m.put("response", "Gagal");
        }
        return m;
    }

    @Override
    public Map update(Barang barang) {
        Map m = new HashMap();
        if (barang.getId() != null) {
            m.put("data", barangDao.update(barang));
            m.put("kode", "00");
            m.put("response", "Sukses");
        } else {
            m.put("kode", "01");
            m.put("response", "Gagal");
        }
        return m;
    }

    @Override
    public Map delete(Barang barang) {
        Map m = new HashMap();
        if (barang.getId() != null) {
            m.put("data", barangDao.delete(barang));
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
            List<Barang> findById = barangDao.findById(Integer.parseInt(search.getValue()));
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
            List<Barang> findByNama = barangDao.findByNama(search.getValue());
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
            List<Barang> orderNama = barangDao.orderByNama();
            if (orderNama.isEmpty()) {
                m.put("kode", "01");
                m.put("response", "Data Tidak Ditemukan");
            } else {
                m.put("data", orderNama);
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
