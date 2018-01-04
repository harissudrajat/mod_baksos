package com.ikaragil.baksos.service;

import com.ikaragil.baksos.domain.PenanggungJawab;
import com.ikaragil.baksos.domain.Search;

import java.util.Map;

public interface PenanggungJawabService extends BaseService<PenanggungJawab> {

    Map findByNama(Search search);
}
