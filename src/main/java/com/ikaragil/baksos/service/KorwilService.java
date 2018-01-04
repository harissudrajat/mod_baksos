package com.ikaragil.baksos.service;

import com.ikaragil.baksos.domain.Korwil;
import com.ikaragil.baksos.domain.Search;

import java.util.Map;

public interface KorwilService extends BaseService<Korwil> {

    Map findByNama(Search search);
}
