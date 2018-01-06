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

    private Logger log = LoggerFactory.getLogger(BarangController.class);

    @Autowired
    private BarangServiceImpl barangService;

    @GetMapping(value = "")
    public Map findAll() {
        return barangService.findAll();
    }

    @PostMapping(value = "/save")
    public Map save(@RequestBody Barang barang) {
        if (barang.getId() == null) {
            return barangService.create(barang);
        } else if (barang.getId() != null) {
            return barangService.update(barang);
        } else {
            return null;
        }
    }

    @DeleteMapping(value = "/delete")
    public Map delete(@RequestBody Barang barang) {
        return barangService.delete(barang);
    }

    @PostMapping(value = "/find")
    public Map find(@RequestBody Search search) {
        if (search.getKey().equals("id")) {
            return barangService.findById(search);
        } else if (search.getKey().equals("nama")) {
            return barangService.findByNama(search);
        } else {
            return null;
        }
    }

    @PostMapping(value = "/order")
    public Map order(@RequestBody Search search) {
        return barangService.orderByNama(search);
    }
}
