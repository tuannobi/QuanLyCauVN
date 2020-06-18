package com.quanlycauvn.dao;

import com.quanlycauvn.model.TinhThanhPho;

import java.util.List;

public interface TinhThanhPhoDao extends GenericDao<TinhThanhPho,String> {
    TinhThanhPho findById(String id);
    List<TinhThanhPho> findAll();
    void save(TinhThanhPho t);
    void update(TinhThanhPho t);
    void deleteById(String id);
}
