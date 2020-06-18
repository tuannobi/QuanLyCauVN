package com.quanlycauvn.dao;

import com.quanlycauvn.model.QuanHuyen;

import java.util.List;

public interface QuanHuyenDao extends GenericDao<QuanHuyen,String> {
    QuanHuyen findById(String id);
    List<QuanHuyen> findAll();
    void save(QuanHuyen t);
    void update(QuanHuyen t);
    void deleteById(String id);
    List<QuanHuyen> findByMaTp(String matp);
}
