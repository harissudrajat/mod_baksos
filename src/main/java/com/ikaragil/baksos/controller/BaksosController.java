package com.ikaragil.baksos.controller;

import com.ikaragil.baksos.domain.Baksos;
import com.ikaragil.baksos.domain.Search;
import com.ikaragil.baksos.service.impl.BaksosServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/baksos")
public class BaksosController {

    Logger log = LoggerFactory.getLogger(BaksosController.class);

    @Autowired
    private BaksosServiceImpl baksosService;

    @GetMapping(value = "")
    public Map findAll() {
        Map m = new HashMap();
        m.put("data", baksosService.findAll());
        m.put("respons", "00");
        m.put("message", "Data berhasil ditampilkan");
        log.info("Info Find All: " + m);
        return m;
    }

    @PostMapping(value = "/save")
    public Map addEdit(@RequestBody Baksos baksos) {
        Map m = new HashMap();
        if (baksos.getId() == null) {
            m.put("data", baksosService.create(baksos));
            m.put("respons", "00");
            m.put("message", "Data berhasil ditambahkan");
        } else if (baksos.getId() != null) {
            m.put("data", baksosService.update(baksos));
            m.put("respons", "00");
            m.put("message", "Data berhasil diubah");
            System.out.println("UPDATE ID: " + baksos.getId());
        } else {
            m.put("respons", "01");
            m.put("message", "Gagal menambah atau merubah data");
        }
        log.info("LOG SAVE / UPDATE: " + m);
        return m;
    }

    @DeleteMapping(value = "/delete")
    public Map delete(@RequestBody Baksos baksos) {
        Map m = new HashMap();
        if (baksos.getId() != null) {
            m.put("data", baksosService.delete(baksos));
            m.put("respons", "00");
            m.put("message", "ID: " + baksos.getId() + " berhasil dihapus");
        } else {
            m.put("respons", "01");
            m.put("message", "Data tidak ditemukan");
        }
        log.info("Delete: " + m);
        return m;
    }

    @PostMapping(value = "/find")
    public Map find(@RequestBody Search search) {
        Map m = new HashMap();
        if (search.getKey().equals("id")) {
            List<Baksos> findId = baksosService.findById(Integer.parseInt(search.getValue()));
            System.out.println("GET ID: " + search.getValue());
            if (findId != null) {
                m.put("kode", "00");
                m.put("message", "Id ditemukan");
                m.put("data", findId);
            } else {
                m.put("kode", "01");
                m.put("message", "Id Tidak Berhasil ditemukan");
            }
        } else if (search.getKey().equals("kode")) {
            List<Baksos> findKode = baksosService.findByNama(search.getValue());
            System.out.println("GET KODE BAKSOS: " + search.getValue());
            if (findKode != null) {
                m.put("kode", "00");
                m.put("message", "Kode Baksos ditemukan");
                m.put("data", findKode);
            } else {
                m.put("kode", "01");
                m.put("message", "Id Tidak Berhasil ditemukan");
            }
        } else if (search.getKey().equals("korwil")) {
            List<Baksos> findKorwil = baksosService.findByKorwil(Integer.parseInt(search.getValue()));
            System.out.println("GET ID KORWIL: " + search.getValue());
            if (findKorwil != null) {
                m.put("kode", "00");
                m.put("message", "Id ditemukan");
                m.put("data", findKorwil);
            } else {
                m.put("kode", "01");
                m.put("message", "Id Tidak Berhasil ditemukan");
            }
        } else if (search.getKey().equals("status")) {
            List<Baksos> findStatus = baksosService.findByStatus(search.getValue());
            System.out.println("GET STATUS: " + search.getValue());
            if (findStatus != null) {
                m.put("kode", "00");
                m.put("message", "Id ditemukan");
                m.put("data", findStatus);
            } else {
                m.put("kode", "01");
                m.put("message", "Id Tidak Berhasil ditemukan");
            }
        }
        return m;
    }

    @PostMapping(value = "/order")
    public Map order(@RequestBody Search search) {
        Map m = new HashMap();
        if (search.getValue().equals("nama")) {
            m.put("kode", "00");
            m.put("message", "Sukses Order By Nama");
            m.put("data", baksosService.orderByNama());
        } else {
            m.put("kode", "02");
            m.put("message", "GAGAL !!!");
        }
        log.info("Order : " + m);
        return m;
    }
}
