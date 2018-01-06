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

    private Logger log = LoggerFactory.getLogger(JenisController.class);

    @GetMapping(value = "")
    public Map findAll() {
        return jenisService.findAll();
    }

    @PostMapping(value = "/save")
    public Map addEdit(@RequestBody Jenis jenis) {
        if (jenis.getId() == null) {
            return jenisService.create(jenis);
        } else {
            return jenisService.update(jenis);
        }

    }

    @DeleteMapping(value = "/delete")
    public Map delete(@RequestBody Jenis jenis) {
        return jenisService.delete(jenis);
    }

    @PostMapping(value = "/order")
    public Map order(@RequestBody Search search) {
        return jenisService.orderByNama(search);
    }

    @PostMapping(value = "/find")
    public Map find(@RequestBody Search search) {
        if (search.getKey().equals("id")) {
            return jenisService.findById(search);
        } else {
            return jenisService.findByNama(search);
        }
    }
}
