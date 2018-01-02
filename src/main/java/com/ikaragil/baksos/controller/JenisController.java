package com.ikaragil.baksos.controller;

import com.ikaragil.baksos.domain.Jenis;
import com.ikaragil.baksos.domain.Search;
import com.ikaragil.baksos.service.impl.JenisServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/jenis")
public class JenisController {

    @Autowired
    private JenisServiceImpl jenisService;

    Logger log = LoggerFactory.getLogger(JenisController.class);

    @GetMapping(value = "")
    public Map findAll() {
        Map m = new HashMap();
        m.put("response", "00");
        m.put("message", "Sukses");
        m.put("data", jenisService.findAll());
        log.info("INFO FINDALL JENIS : " + m);
        return m;
    }

    @PostMapping(value = "/save")
    public Map addEdit(@RequestBody Jenis jenis) {
        Map m = new HashMap();
        if (jenis.getId() == null) {
            m.put("response", "00");
            m.put("message", "Sukses");
            m.put("data", jenisService.create(jenis));
        } else if (jenis.getId() != null) {
            m.put("response", "00");
            m.put("message", "Sukses");
            m.put("data", jenisService.update(jenis));
        } else {
            m.put("response", "02");
            m.put("message", "Gagal !!!");
        }
        log.info("CONTROLLER ADD-EDIT: " + m);
        return m;
    }

    @DeleteMapping(value = "/delete")
    public Map delete(@RequestBody Jenis jenis) {
        Map m = new HashMap();
        if (jenis.getId() != null) {
            m.put("response", "00");
            m.put("message", "Sukses");
            m.put("data", jenisService.delete(jenis));
        } else {
            m.put("response", "02");
            m.put("message", "Gagal");
        }
        log.info("INFO CONT DELETE : " + m);
        return m;
    }

    @PostMapping(value = "/order")
    public Map order(@RequestBody Search search) {
        Map m = new HashMap();
        if (search.getValue().equals("nama")) {
            m.put("response", "00");
            m.put("message", "Sukses Order By Nama");
            m.put("data", jenisService.orderByNama());
        } else {
            m.put("response", "02");
            m.put("message", "GAGAL !!!");
        }
        log.info("INFO CONT ORDER : " + m);
        return m;
    }

    @PostMapping(value = "/find")
    public Map findByName(@RequestBody Search search) {
        Map m = new HashMap();
        if (search.getKey().equals("id")) {
            List<Jenis> jenisId = jenisService.findById(Integer.parseInt(search.getValue()));
            System.out.println("GET ID: " + search.getValue());
            if (jenisId != null) {
                m.put("response", "00");
                m.put("message", "Id ditemukan");
                m.put("data", jenisId);
            } else {
                m.put("response", "01");
                m.put("message", "Id Tidak Berhasil ditemukan");
            }
        } else if (search.getKey().equals("nama")) {
            List<Jenis> jenisNama = jenisService.findByNama(search.getValue());
            System.out.println("GET NAMA: " + search.getValue());
            if (jenisNama != null) {
                m.put("response", "00");
                m.put("message", "Nama ditemukan");
                m.put("data", jenisNama);
            } else {
                m.put("response", "01");
                m.put("message", "Nama Tidak Berhasil ditemukan");
            }
        } else {
            m.put("response", "02");
            m.put("message", "Gagal !!!");
        }
        log.info("Info Searching : " + m.toString());
        return m;
    }


}
