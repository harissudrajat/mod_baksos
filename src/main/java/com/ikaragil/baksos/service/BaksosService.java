package com.ikaragil.baksos.service;

import com.ikaragil.baksos.domain.Baksos;

import java.util.List;

public interface BaksosService extends BaseService<Baksos> {

    List<Baksos> findByKorwil(Integer id_korwil);

    List<Baksos> findByStatus(String status);
}
