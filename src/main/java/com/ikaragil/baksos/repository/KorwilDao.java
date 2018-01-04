package com.ikaragil.baksos.repository;

import com.ikaragil.baksos.domain.Korwil;

import java.util.List;

public interface KorwilDao extends BaseDao<Korwil> {

    List<Korwil> findByNama(String nama);
}
