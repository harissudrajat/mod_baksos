package com.ikaragil.baksos.controller;

import com.ikaragil.baksos.domain.PenanggungJawab;
import com.ikaragil.baksos.domain.Search;
import com.ikaragil.baksos.service.impl.PenanggungJawabServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/pj")
public class PenanggungJawabController {

    Logger log = LoggerFactory.getLogger(PenanggungJawabController.class);

    @Autowired
    private PenanggungJawabServiceImpl pjService;

    @GetMapping(value = "")
    public Map findAll() {
        Map m = new HashMap();
        m.put("data", pjService.findAll());
        m.put("respons", "00");
        m.put("message", "Data berhasil ditampilkan  ");
        log.info("FIND ALL: " + m);
        return m;
    }

    @PostMapping(value = "/save")
    public Map save(@RequestBody PenanggungJawab penanggungJawab) {
        Map m = new HashMap();
        if (penanggungJawab.getId() == null) {
            m.put("data", pjService.create(penanggungJawab));
            m.put("respons", "00");
            m.put("messages", "Data berhasil ditambahkan ");
        } else if (penanggungJawab.getId() != null) {
            m.put("data", pjService.update(penanggungJawab));
            m.put("respons", "00");
            m.put("messages", "Data berhasil diubah ");
            System.out.println("UPDATE ID: " + penanggungJawab.getId());
        } else {
            m.put("respons", "01");
            m.put("message", "Gagal menambah atau merubah data");
        }
        log.info("SAVE / UPDATE: " + m);
        return m;
    }

    @DeleteMapping(value = "/delete")
    public Map delete(@RequestBody PenanggungJawab penanggungJawab) {
        Map m = new HashMap();
        if (penanggungJawab.getId() != null) {
            m.put("data", pjService.delete(penanggungJawab));
            m.put("respons", "00");
            m.put("messages", "ID: " + penanggungJawab.getId() + " berhasil dihapus ");
        } else {
            m.put("respons", "01");
            m.put("message", "Data tidak ditemukan");
        }
        log.info("Delete: " + m);
        return m;
    }

    @PostMapping(value = "/find")
    public Map findByName(@RequestBody Search search) {
        Map m = new HashMap();
        if (search.getKey().equals("id")) {
            List<PenanggungJawab> penanggungJawabs = pjService.findById(Integer.parseInt(search.getValue()));
            System.out.println("GET ID: " + search.getValue());
            if (penanggungJawabs != null) {
                m.put("kode", "00");
                m.put("messages", "Id ditemukan ");
                m.put("data", penanggungJawabs);
            } else {
                m.put("kode", "01");
                m.put("messages", "Id Tidak Berhasil ditemukan");
            }
        } else if (search.getKey().equals("nama")) {
            List<PenanggungJawab> keadaan_nama = pjService.findByNama(search.getValue());
            System.out.println("GET NAMA: " + search.getValue());
            if (keadaan_nama != null) {
                m.put("kode", "00");
                m.put("messages", "Nama ditemukan ");
                m.put("data", keadaan_nama);
            } else {
                m.put("kode", "01");
                m.put("messages", "Nama Tidak Berhasil ditemukan");
            }
        } else {
            m.put("kode", "01");
            m.put("message", "Gagal !!!");
        }
        log.info("Info Searching : " + m);
        return m;
    }

    @PostMapping(value = "/order")
    public Map order(@RequestBody Search search) {
        Map m = new HashMap();
        if (search.getValue().equals("nama")) {
            m.put("kode", "00");
            m.put("messages", "Sukses Order By Nama");
            m.put("data", pjService.orderByNama());
        } else {
            m.put("kode", "02");
            m.put("messages", "GAGAL !! ");
        }
        log.info("Order : " + m);
        return m;
    }
}
