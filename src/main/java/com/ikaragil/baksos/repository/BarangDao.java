package com.ikaragil.baksos.repository;

import com.ikaragil.baksos.domain.Barang;

import java.util.List;

public interface BarangDao extends BaseDao<Barang> {

    List<Barang> findByNama(String nama);
}
