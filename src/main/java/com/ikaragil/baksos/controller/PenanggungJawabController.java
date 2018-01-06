package com.ikaragil.baksos.controller;

import com.ikaragil.baksos.domain.PenanggungJawab;
import com.ikaragil.baksos.domain.Search;
import com.ikaragil.baksos.service.impl.PenanggungJawabServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(value = "/api/pj")
public class PenanggungJawabController {

    @Autowired
    private PenanggungJawabServiceImpl penanggungJawabService;

    private Logger log = LoggerFactory.getLogger(PenanggungJawabController.class);

    @GetMapping(value = "")
    public Map findAll() {
        log.info("find all: " + penanggungJawabService.findAll());
        return penanggungJawabService.findAll();
    }

    @PostMapping(value = "/save")
    public Map addEdit(@RequestBody PenanggungJawab penanggungJawab) {
        if (penanggungJawab.getId() == null) {
            log.info("save: " + penanggungJawab.toString());
            return penanggungJawabService.create(penanggungJawab);
        } else {
            log.info("update: " + penanggungJawab.toString());
            return penanggungJawabService.update(penanggungJawab);
        }
    }

    @DeleteMapping(value = "/delete")
    public Map delete(@RequestBody PenanggungJawab penanggungJawab) {
        log.info("delete: " + penanggungJawab.toString());
        return penanggungJawabService.delete(penanggungJawab);
    }

    @PostMapping(value = "/order")
    public Map order(@RequestBody Search search) {
        log.info("order byname: " + penanggungJawabService.orderByNama(search));
        return penanggungJawabService.orderByNama(search);
    }

    @PostMapping(value = "/find")
    public Map find(@RequestBody Search search) {
        if (search.getKey().equals("id")) {
            log.info("find id: " + penanggungJawabService.findById(search));
            return penanggungJawabService.findById(search);
        } else {
            log.info("find nama: " + penanggungJawabService.findByNama(search));
            return penanggungJawabService.findByNama(search);
        }
    }
}
