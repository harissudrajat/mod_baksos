package com.ikaragil.baksos;

import com.ikaragil.baksos.domain.Baksos;
import com.ikaragil.baksos.domain.Barang;
import com.ikaragil.baksos.domain.Korwil;
import com.ikaragil.baksos.service.impl.BaksosServiceImpl;
import com.ikaragil.baksos.service.impl.BarangServiceImpl;
import com.ikaragil.baksos.service.impl.KorwilServiceImpl;
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
public class BaksosApplicationTests {

    private Logger log = LoggerFactory.getLogger(BaksosApplicationTests.class);

    @Autowired
    private KorwilServiceImpl korwilService;

    @Test
    public void contextLoads() {
    }

    @Test
    public void update() {
        Korwil korwil = new Korwil();
        korwil.setId(Long.parseLong("4"));
        korwil.setNama("Jabar");
        korwil.setAlamat("Jabar");
        System.out.println("EDIT TEST: " + korwilService.update(korwil));
    }

    @Test
    public void remove() {
        Korwil korwil = new Korwil();
        korwil.setId(Long.parseLong("6"));

        System.out.println(korwilService.delete(korwil).toString());

    }


}
