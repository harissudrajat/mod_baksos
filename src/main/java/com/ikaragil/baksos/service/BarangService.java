package com.ikaragil.baksos.service;

import com.ikaragil.baksos.domain.Barang;
import com.ikaragil.baksos.domain.Search;

import java.util.Map;

public interface BarangService extends BaseService<Barang> {

    Map findByNama(Search search);
}
