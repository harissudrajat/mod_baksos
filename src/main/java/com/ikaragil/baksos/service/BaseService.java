package com.ikaragil.baksos.service;

import com.ikaragil.baksos.domain.Search;

import java.util.Map;

public interface BaseService<T> {
    Map findAll();

    Map create(T t);

    Map update(T t);

    Map delete(T t);

    Map findById(Search search);

//    Map findByNama(Search search);

    Map orderByNama(Search search);

}
