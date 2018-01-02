package com.ikaragil.baksos;

import com.ikaragil.baksos.domain.Baksos;
import com.ikaragil.baksos.domain.Barang;
import com.ikaragil.baksos.service.impl.BaksosServiceImpl;
import com.ikaragil.baksos.service.impl.BarangServiceImpl;
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

    @Test
    public void contextLoads() {
    }

    @Test
    public void findAll() {
    }


}
