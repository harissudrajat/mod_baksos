package com.ikaragil.baksos.controller;

import com.ikaragil.baksos.domain.Korwil;
import com.ikaragil.baksos.domain.Search;
import com.ikaragil.baksos.service.impl.KorwilServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(value = "/api/korwil")
public class KorwilController {

    @Autowired
    private KorwilServiceImpl korwilService;

    private Logger log = LoggerFactory.getLogger(KorwilController.class);

    @GetMapping(value = "")
    public Map findAll() {
        log.info("find all: " + korwilService.findAll());
        return korwilService.findAll();
    }

    @PostMapping(value = "/save")
    public Map addEdit(@RequestBody Korwil korwil) {
        if (korwil.getId() == null) {
            log.info("save: " + korwil.toString());
            return korwilService.create(korwil);
        } else {
            log.info("update: " + korwil.toString());
            return korwilService.update(korwil);
        }
    }

    @DeleteMapping(value = "/delete")
    public Map delete(@RequestBody Korwil korwil) {
        log.info("delete: " + korwil.getId());
        return korwilService.delete(korwil);
    }

    @PostMapping(value = "/order")
    public Map order(@RequestBody Search search) {
        log.info("order byname: " + korwilService.orderByNama(search));
        return korwilService.orderByNama(search);
    }

    @PostMapping(value = "/find")
    public Map find(@RequestBody Search search) {
        if (search.getKey().equals("id")) {
            log.info("find id: " + korwilService.findById(search));
            return korwilService.findById(search);
        } else {
            log.info("find nama: " + korwilService.findByNama(search));
            return korwilService.findByNama(search);
        }
    }
}