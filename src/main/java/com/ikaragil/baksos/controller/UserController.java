package com.ikaragil.baksos.controller;

import com.ikaragil.baksos.domain.Search;
import com.ikaragil.baksos.domain.User;
import com.ikaragil.baksos.service.impl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(value = "/api/petugas")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    private Logger log = LoggerFactory.getLogger(UserController.class);

    @GetMapping(value = "")
    public Map findAll() {
        log.info("find all: " + userService.findAll());
        return userService.findAll();
    }

    @PostMapping(value = "/save")
    public Map addEdit(@RequestBody User user) {
        if (user.getId() == null) {
            log.info("save: " + user.toString());
            return userService.create(user);
        } else {
            log.info("update: " + user.toString());
            return userService.update(user);
        }
    }

    @DeleteMapping(value = "/delete")
    public Map delete(@RequestBody User user) {
        log.info("delete: " + user.toString());
        return userService.delete(user);
    }

    @PostMapping(value = "/order")
    public Map order(@RequestBody Search search) {
        log.info("order byname: " + userService.orderByNama(search));
        return userService.orderByNama(search);
    }

    @PostMapping(value = "/find")
    public Map find(@RequestBody Search search) {
        if (search.getKey().equals("id")) {
            log.info("find id: " + userService.findById(search));
            return userService.findById(search);
        } else {
            log.info("find nama: " + userService.findByNama(search));
            return userService.findByNama(search);
        }
    }
}
