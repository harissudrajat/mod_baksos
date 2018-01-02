package com.ikaragil.baksos.repository;

import com.ikaragil.baksos.domain.Baksos;

import java.util.List;

public interface BaksosDao extends BaseDao<Baksos> {

    List<Baksos> findByKorwil(Integer id_korwil);

    List<Baksos> findByStatus(String status);
}
