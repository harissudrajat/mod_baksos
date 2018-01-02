package com.ikaragil.baksos.controller;

import com.ikaragil.baksos.domain.Search;
import com.ikaragil.baksos.domain.User;
import com.ikaragil.baksos.service.impl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/user")
public class UserController {

    Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserServiceImpl userService;

    @GetMapping(value = "")
    public Map findAll() {
        Map m = new HashMap();
        m.put("data", userService.findAll());
        m.put("respons", "00");
        m.put("message", "Data berhasil ditampilkan");
        log.info("FIND ALL: " + m);
        return m;
    }

    @PostMapping(value = "/save")
    public Map save(@RequestBody User user) {
        Map m = new HashMap();
        if (user.getId() == null) {
            m.put("data", userService.create(user));
            m.put("respons", "00");
            m.put("message", "Data berhasil ditambahkan");
        } else if (user.getId() != null) {
            m.put("data", userService.update(user));
            m.put("respons", "00");
            m.put("message", "Data berhasil diubah");
            System.out.println("UPDATE ID: " + user.getId());
        } else {
            m.put("respons", "01");
            m.put("message", "Gagal menambah atau merubah data");
        }
        log.info("SAVE / UPDATE: " + m);
        return m;
    }

    @DeleteMapping(value = "/delete")
    public Map delete(@RequestBody User user) {
        Map m = new HashMap();
        if (user.getId() != null) {
            m.put("data", userService.delete(user));
            m.put("respons", "00");
            m.put("message", "ID: " + user.getId() + " berhasil dihapus");
        } else {
            m.put("respons", "01");
            m.put("message", "Data tidak ditemukan");
        }
        log.info("Delete: " + m);
        return m;
    }

    @PostMapping(value = "/find")
    public Map findByName(@RequestBody Search search) {
        Map m = new HashMap();
        if (search.getKey().equals("id")) {
            List<User> user_id = userService.findById(Integer.parseInt(search.getValue()));
            System.out.println("GET ID: " + search.getValue());
            if (user_id != null) {
                m.put("kode", "00");
                m.put("message", "Id ditemukan");
                m.put("data", user_id);
            } else {
                m.put("kode", "01");
                m.put("message", "Id Tidak Berhasil ditemukan");
            }
        } else if (search.getKey().equals("nama")) {
            List<User> user_nama = userService.findByNama(search.getValue());
            System.out.println("GET NAMA: " + search.getValue());
            if (user_nama != null) {
                m.put("kode", "00");
                m.put("message", "Nama ditemukan");
                m.put("data", user_nama);
            } else {
                m.put("kode", "01");
                m.put("message", "Nama Tidak Berhasil ditemukan");
            }
        } else {
            m.put("kode", "01");
            m.put("message", "Gagal !!!");
        }
        log.info("Info Searching : " + m);
        return m;
    }

    @PostMapping(value = "/order")
    public Map order(@RequestBody Search search) {
        Map m = new HashMap();
        if (search.getValue().equals("nama")) {
            m.put("kode", "00");
            m.put("message", "Sukses Order By Nama");
            m.put("data", userService.orderByNama());
        } else {
            m.put("kode", "02");
            m.put("message", "GAGAL !!!");
        }
        log.info("Order : " + m);
        return m;
    }
}
