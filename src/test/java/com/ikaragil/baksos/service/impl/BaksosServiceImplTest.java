package com.ikaragil.baksos.service.impl;

import com.ikaragil.baksos.domain.Baksos;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BaksosServiceImplTest {

    @Autowired
    private BaksosServiceImpl baksosService;

    @Test
    public void create() {
        Baksos baksos = new Baksos();
        baksos.setKode("20180101-5");
        baksos.setDeskripsi("TES SERVICE");
        baksos.setTgl_baksos("20180201");
        baksos.setId_jenis(1);
        baksos.setLongitude("123456");
        baksos.setLatitude("654321");
        baksos.setAlamat("Tes alamat");
        baksos.setId_penanggungjawab(1);
        baksos.setId_korwil(1);
        baksos.setId_keadaan(1);
        baksos.setId_barang(1);
        baksos.setQuantity("12");
        baksos.setSatuan("pcs");
        baksos.setTgl_input("20180104");
        baksos.setId_user(1);
        baksos.setStatus("BELUM TERLAKSANA");
        System.out.println("SAVE: "+ baksosService.create(baksos));
    }
}