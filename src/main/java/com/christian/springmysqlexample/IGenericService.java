package com.christian.springmysqlexample;

import java.util.List;

public interface IGenericService<T> {
    List<T> findAll();
    void save(T object);
    void saveAll(Iterable<T> objects);
}
