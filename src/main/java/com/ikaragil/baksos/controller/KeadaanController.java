package com.ikaragil.baksos.controller;

import com.ikaragil.baksos.domain.Keadaan;
import com.ikaragil.baksos.domain.Search;
import com.ikaragil.baksos.service.impl.KeadaanServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(value = "/api/kondisi")
public class KeadaanController {

    @Autowired
    private KeadaanServiceImpl keadaanService;

    private Logger log = LoggerFactory.getLogger(KeadaanController.class);

    @GetMapping(value = "")
    public Map findAll() {
        log.info("findAll: " + keadaanService.findAll());
        return keadaanService.findAll();
    }

    @PostMapping(value = "/save")
    public Map addEdit(@RequestBody Keadaan keadaan) {
        if (keadaan.getId() == null) {
            log.info("SAVE: " + keadaanService.create(keadaan));
            System.out.println(keadaan.toString());
            return keadaanService.create(keadaan);
        } else {
            log.info("UPDATE: " + keadaanService.update(keadaan));
            return keadaanService.update(keadaan);
        }

    }

    @DeleteMapping(value = "/delete")
    public Map delete(@RequestBody Keadaan keadaan) {
        log.info("delete: "+keadaanService.delete(keadaan));
        return keadaanService.delete(keadaan);
    }

    @PostMapping(value = "/order")
    public Map order(@RequestBody Search search) {
        log.info("orderByNama: "+keadaanService.orderByNama(search));
        return keadaanService.orderByNama(search);
    }

    @PostMapping(value = "/find")
    public Map find(@RequestBody Search search) {
        if (search.getKey().equals("id")) {
            log.info("findById: "+keadaanService.findById(search));
            return keadaanService.findById(search);
        } else {
            log.info("findByNama: "+keadaanService.findByNama(search));
            return keadaanService.findByNama(search);
        }
    }
}
