package com.ikaragil.baksos.service.impl;

import com.ikaragil.baksos.domain.Baksos;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BaksosServiceImplTest {

    private Logger log = LoggerFactory.getLogger(BaksosServiceImplTest.class);

    @Autowired
    private BaksosServiceImpl baksosService;

    @Test
    public void findByKorwil() {
    }

    @Test
    public void findByStatus() {
        String status = "selesai";
        try {
            List<Baksos> baksos = baksosService.findByStatus(status);
            Map m = new HashMap();
            m.put("data", baksos);
            System.out.println(m.toString());
        } catch (Exception e) {
            System.out.println("data kosong");
        }
    }

    @Test
    public void findAll() {
        log.info(baksosService.findAll().toString());
    }

    @Test
    public void create() {
    }

    @Test
    public void update() {
    }

    @Test
    public void delete() {
    }

    @Test
    public void findById() {
    }

    @Test
    public void findByNama() {
    }

    @Test
    public void orderByNama() {
    }
}