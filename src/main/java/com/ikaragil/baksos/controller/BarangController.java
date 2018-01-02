package com.ikaragil.baksos.controller;

import com.ikaragil.baksos.domain.Barang;
import com.ikaragil.baksos.domain.Search;
import com.ikaragil.baksos.repository.impl.BarangDaoImpl;
import com.ikaragil.baksos.service.impl.BarangServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/barang")
public class BarangController {

    Logger log = LoggerFactory.getLogger(BarangController.class);

    @Autowired
    private BarangServiceImpl barangService;

    @Autowired
    private BarangDaoImpl barangDao;

    @GetMapping(value = "")
    public Map findAll() {
        Map m = new HashMap();
        m.put("data", barangService.findAll());
        m.put("respons", "00");
        m.put("message", "Data berhasil ditampilkan");
        log.info("FIND ALL: " + m);
        return m;
    }

    @PostMapping(value = "/save")
    public Map save(@RequestBody Barang barang) {
        Map m = new HashMap();
        if (barang.getId() == null) {
            m.put("data", barangService.create(barang));
            m.put("respons", "00");
            m.put("message", "Data berhasil ditambahkan");
        } else if (barang.getId() != null) {
            m.put("data", barangService.update(barang));
            m.put("respons", "00");
            m.put("message", "Data berhasil diubah");
            System.out.println("UPDATE ID: " + barang.getId());
        } else {
            m.put("respons", "01");
            m.put("message", "Gagal menambah atau merubah data");
        }
        log.info("SAVE / UPDATE: " + m);
        return m;
    }

    @DeleteMapping(value = "/delete")
    public Map delete(@RequestBody Barang barang) {
        Map m = new HashMap();
        if (barang.getId() != null) {
            m.put("data", barangService.delete(barang));
            m.put("respons", "00");
            m.put("message", "ID" + barang.getId() + " berhasil dihapus");
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
            List<Barang> barang_id = barangService.findById(Integer.parseInt(search.getValue()));
            System.out.println("GET ID: " + search.getValue());
            if (barang_id != null) {
                m.put("response", "00");
                m.put("message", "Id ditemukan");
                m.put("data", barang_id);
            } else {
                m.put("response", "01");
                m.put("message", "Id Tidak Berhasil ditemukan");
            }
        } else if (search.getKey().equals("nama")) {
            List<Barang> barang_nama = barangService.findByNama(search.getValue());
            System.out.println("GET NAMA: " + search.getValue());
            if (barang_nama != null) {
                m.put("response", "00");
                m.put("message", "Nama ditemukan");
                m.put("data", barang_nama);
            } else {
                m.put("response", "01");
                m.put("message", "Nama Tidak Berhasil ditemukan");
            }
        } else {
            m.put("response", "01");
            m.put("message", "Gagal !!!");
        }
        log.info("Info Searching : " + m);
        return m;
    }

    @PostMapping(value = "/order")
    public Map order(@RequestBody Search search) {
        Map m = new HashMap();
        if (search.getValue().equals("nama")) {
            m.put("response", "00");
            m.put("message", "Sukses Order By Nama");
            m.put("data", barangService.orderByNama());
        } else {
            m.put("response", "02");
            m.put("message", "GAGAL !!!");
        }
        log.info("Order : " + m);
        return m;
    }
}
