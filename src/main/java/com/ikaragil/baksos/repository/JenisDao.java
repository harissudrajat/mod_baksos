package com.ikaragil.baksos.repository;

import com.ikaragil.baksos.domain.Jenis;

import java.util.List;

public interface JenisDao extends BaseDao<Jenis> {
    List<Jenis> findByNama(String nama);

}
