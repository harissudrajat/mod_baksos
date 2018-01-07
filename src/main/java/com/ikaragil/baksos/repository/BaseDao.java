package com.ikaragil.baksos.repository;

import com.ikaragil.baksos.domain.Search;

import java.util.List;

public interface BaseDao<T> {
    List<T> findAll();
    int create(T t);
    int update(T t);
    int delete(T t);
    List<T> orderByNama();
    List<T> findById(Long id);
//    List<T> findByNama(Search search);


}
