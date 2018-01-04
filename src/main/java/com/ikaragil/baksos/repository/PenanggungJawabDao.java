package com.ikaragil.baksos.repository;

import com.ikaragil.baksos.domain.PenanggungJawab;

import java.util.List;

public interface PenanggungJawabDao extends BaseDao<PenanggungJawab> {

    List<PenanggungJawab> findByNama(String nama);
}
