package com.ikaragil.baksos.repository;

import com.ikaragil.baksos.domain.Keadaan;

import java.util.List;

public interface KeadaanDao extends BaseDao<Keadaan> {

    List<Keadaan> findByNama(String nama);
}
