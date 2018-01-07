package com.ikaragil.baksos.repository.impl;

import com.ikaragil.baksos.domain.Baksos;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BaksosDaoImplTest {

    @Autowired
    private BaksosDaoImpl baksosDao;

    @Test
    public void getCountId() {
        System.out.println("Count Id: "+ baksosDao.getCountId());
    }

    @Test
    public void getLastId() {
        System.out.println("Last Id: "+ baksosDao.getLastId());
    }

    @Test
    public void getDetail(){
        Baksos baksos = new Baksos();
        baksos.setKode("IKA201802-1");
        System.out.println("detail baksos: "+baksosDao.getDetail(baksos.getKode()));
    }
}