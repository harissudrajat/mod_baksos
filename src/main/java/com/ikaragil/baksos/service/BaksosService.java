package com.ikaragil.baksos.service;

import com.ikaragil.baksos.domain.Baksos;
import com.ikaragil.baksos.domain.Search;

import java.util.Map;

public interface BaksosService extends BaseService<Baksos> {

    Map findByKorwil(Search search);

    Map findByStatus(Search search);

    Map findByKode(Search search);

    Map getDetail(Search search);
}
