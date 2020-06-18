package com.quanlycauvn.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<T,K extends Serializable> {
    T findById(K id);
    List<T> findAll();
    void save(T t);
    void update(T t);
    void deleteById(K id);
}
