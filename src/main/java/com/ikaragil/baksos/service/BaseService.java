package com.ikaragil.baksos.service;

import java.util.List;

public interface BaseService<T> {
    List<T> findAll();

    int create(T t);

    int update(T t);

    int delete(T t);

    List<T> findById(Integer id);

    List<T> findByNama(String nama);

    List<T> orderByNama();

}
