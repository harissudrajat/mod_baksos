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

    @PostMapping(value = "/detail")
    public Map getDetail(@RequestBody Search search){
        if (search.getKey().equals("kode")){
            return baksosService.getDetail(search);
        } else {
            return null;
        }
    }

    @GetMapping(value = "")
    public Map findAll() {
        return baksosService.findAll();
    }

    @PostMapping(value = "/save")
    public Map addEdit(@RequestBody Baksos baksos) {
        if (baksos.getId() == null) {
            return baksosService.create(baksos);
        } else {
            return baksosService.update(baksos);
        }
    }

    @DeleteMapping(value = "/delete")
    public Map delete(@RequestBody Baksos baksos) {
        return baksosService.delete(baksos);
    }

    @PostMapping(value = "/find")
    public Map find(@RequestBody Search search) {
        if (search.getKey().equals("id")) {
            return baksosService.findById(search);
        } else if (search.getKey().equals("kode")) {
            return baksosService.findByKode(search);
        } else if (search.getKey().equals("korwil")) {
            return baksosService.findByKorwil(search);
        } else if (search.getKey().equals("status")) {
            return baksosService.findByStatus(search);
        } else {
            return null;
        }
    }

    @PostMapping(value = "/order")
    public Map order(@RequestBody Search search) {
        return baksosService.orderByNama(search);
    }
}
