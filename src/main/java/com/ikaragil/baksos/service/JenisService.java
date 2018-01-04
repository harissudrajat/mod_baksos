package com.ikaragil.baksos.service;

import com.ikaragil.baksos.domain.Jenis;
import com.ikaragil.baksos.domain.Search;

import java.util.Map;

public interface JenisService extends BaseService<Jenis> {

    Map findByNama(Search search);

}
