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

    Logger log = LoggerFactory.getLogger(JenisController.class);

    @GetMapping(value = "")
    public Map findAll() {
        return null;
    }

    @PostMapping(value = "/save")
    public Map addEdit(@RequestBody Jenis jenis) {
        if (jenis.getId() == null) {
            return null;
        } else if (jenis.getId() != null) {
            return null;
        } else {
            return null;
        }

    }

    @DeleteMapping(value = "/delete")
    public Map delete(@RequestBody Jenis jenis) {
        return null;
    }

    @PostMapping(value = "/order")
    public Map order(@RequestBody Search search) {
        return null;
    }

    @PostMapping(value = "/find")
    public Map findByName(@RequestBody Search search) {
        if (search.getKey().equals("id")) {
            return null;
        } else if (search.getKey().equals("nama")) {
            return null;
        } else {
            return null;
        }
    }


}
