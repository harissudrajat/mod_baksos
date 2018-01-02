package com.ikaragil.baksos.controller;

import com.ikaragil.baksos.domain.Korwil;
import com.ikaragil.baksos.domain.Search;
import com.ikaragil.baksos.service.impl.KorwilServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/korwil")
public class KorwilController {

    Logger log = LoggerFactory.getLogger(KorwilController.class);

    @Autowired
    private KorwilServiceImpl korwilService;

    @GetMapping(value = "")
    public Map findAll() {
        Map m = new HashMap();
        m.put("data", korwilService.findAll());
        m.put("respons", "00");
        m.put("message", "Data berhasil ditampilkan ");
        log.info("FIND ALL: " + m);
        return m;
    }

    @PostMapping(value = "/save")
    public Map save(@RequestBody Korwil korwil) {
        Map m = new HashMap();
        if (korwil.getId() == null) {
            m.put("data", korwilService.create(korwil));
            m.put("respons", "00");
            m.put("message", "Data berhasil ditambahkan ");
        } else if (korwil.getId() != null) {
            m.put("data", korwilService.update(korwil));
            m.put("respons", "00");
            m.put("message", "Data berhasil diubah ");
            System.out.println("UPDATE ID: " + korwil.getId());
        } else {
            m.put("respons", "01");
            m.put("message", "Gagal menambah atau merubah data");
        }
        log.info("SAVE / UPDATE: " + m);
        return m;
    }

    @DeleteMapping(value = "/delete")
    public Map delete(@RequestBody Korwil korwil) {
        Map m = new HashMap();
        if (korwil.getId() != null) {
            m.put("data", korwilService.delete(korwil));
            m.put("respons", "00");
            m.put("message", "ID: " + korwil.getId() + " berhasil dihapus ");
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
            List<Korwil> korwils = korwilService.findById(Integer.parseInt(search.getValue()));
            System.out.println("GET ID: " + search.getId());
            if (korwils != null) {
                m.put("kode", "00");
                m.put("message", "Id ditemukan ");
                m.put("data", korwils);
            } else {
                m.put("kode", "01");
                m.put("message", "Id Tidak Berhasil ditemukan");
            }
        } else if (search.getKey().equals("nama")) {
            List<Korwil> keadaan_nama = korwilService.findByNama(search.getValue());
            System.out.println("GET NAMA: " + search.getValue());
            if (keadaan_nama != null) {
                m.put("kode", "00");
                m.put("message", "Nama ditemukan ");
                m.put("data", keadaan_nama);
            } else {
                m.put("kode", "01");
                m.put("message", "Nama Tidak Berhasil ditemukan");
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
            m.put("message", "Sukses Order By Nama");
            m.put("data", korwilService.orderByNama());
        } else {
            m.put("kode", "02");
            m.put("message", "GAGAL !! ");
        }
        log.info("Order : " + m);
        return m;
    }
}
