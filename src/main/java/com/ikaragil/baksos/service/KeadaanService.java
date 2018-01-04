package com.ikaragil.baksos.service;

import com.ikaragil.baksos.domain.Keadaan;
import com.ikaragil.baksos.domain.Search;

import java.util.Map;

public interface KeadaanService extends BaseService<Keadaan> {

    Map findByNama(Search search);
}
