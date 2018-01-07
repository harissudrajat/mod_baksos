package com.ikaragil.baksos.service.impl;

import com.ikaragil.baksos.domain.Baksos;
import com.ikaragil.baksos.domain.BaksosDetail;
import com.ikaragil.baksos.domain.Search;
import com.ikaragil.baksos.repository.impl.BaksosDaoImpl;
import com.ikaragil.baksos.service.BaksosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BaksosServiceImpl implements BaksosService {

    @Autowired
    private BaksosDaoImpl baksosDao;

    @Override
    public Map findByKorwil(Search search) {
        Map m = new HashMap();
        if (search.getKey().equals("korwil")) {
            List<Baksos> findKorwil = baksosDao.findByKorwil(Integer.parseInt(search.getValue()));
            if (findKorwil.isEmpty()) {
                m.put("kode", "01");
                m.put("response", "Data Tidak Ditemukan");
            } else {
                m.put("data", findKorwil);
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
    public Map findByStatus(Search search) {
        Map m = new HashMap();
        if (search.getKey().equals("status")) {
            List<Baksos> baksosList = baksosDao.findByStatus(search.getValue());
            if (baksosList.isEmpty()) {
                m.put("kode", "01");
                m.put("response", "Status Tidak Ditemukan");
            } else {
                m.put("data", baksosList);
                m.put("kode", "00");
                m.put("response", "Status Ditemukan");
            }
        } else {
            m.put("kode", "02");
            m.put("response", "Keyword Salah");
        }
        return m;
    }

    @Override
    public Map findByKode(Search search) {
        Map m = new HashMap();
        if (search.getKey().equals("kode")) {
            List<Baksos> findByKode = baksosDao.findByKode(search.getValue());
            if (findByKode.isEmpty()) {
                m.put("kode", "01");
                m.put("response", "Data Tidak Ditemukan ");
            } else {
                m.put("data", findByKode);
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
    public Map getDetail(Search search) {
        Map m = new HashMap();
        if (search.getKey().equals("kode")) {
            List<BaksosDetail> details = baksosDao.getDetail(search.getValue());
            if (details.isEmpty()) {
                m.put("kode", "01");
                m.put("response", "Kode Tidak Ditemukan");
            } else {
                m.put("data", details);
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
        List<Baksos> findAll = baksosDao.findAll();
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
    public Map create(Baksos baksos) {
        Map m = new HashMap();
        if (baksos.getId() == null) {
            List<String> lastId = baksosDao.getLastId();
            String tgl = baksos.getTgl_baksos().substring(0, 6);
            if (lastId.size() == 0) {
                String id = "0";
                baksos.setKode("IKA" + tgl + "-" + (Integer.parseInt(id) + 1));
            } else {
                baksos.setKode("IKA" + tgl + "-" + (Integer.parseInt(lastId.get(0)) + 1));
            }
            m.put("data", baksosDao.create(baksos));
            m.put("kode", "00");
            m.put("response", "Sukses");
        } else {
            m.put("kode", "01");
            m.put("response", "Gagal");
        }

        return m;
    }

    @Override
    public Map update(Baksos baksos) {
        Map m = new HashMap();
        if (baksos.getId() != null) {
            List<Baksos> findById = baksosDao.findById(baksos.getId());
            if (findById.isEmpty()) {
                m.put("kode", "01");
                m.put("response", "Id not found");
            } else {
                m.put("data", baksosDao.update(baksos));
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
    public Map delete(Baksos baksos) {
        Map m = new HashMap();
        if (baksos.getId() != null) {
            List<Baksos> findById = baksosDao.findById(baksos.getId());
            if (findById.isEmpty()) {
                m.put("kode", "01");
                m.put("response", "Id not found");
            } else {
                m.put("data", baksosDao.delete(baksos));
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
            List<Baksos> findById = baksosDao.findById(Long.parseLong(search.getValue()));
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
        if (search.getKey().equals("kode")) {
            List<Baksos> orderByNama = baksosDao.orderByNama();
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
