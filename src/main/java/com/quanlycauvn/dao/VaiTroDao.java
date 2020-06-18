package com.quanlycauvn.dao;

import com.quanlycauvn.model.VaiTro;

import java.util.List;

public interface VaiTroDao extends GenericDao<VaiTro,Integer> {
    VaiTro findById(Integer id);
    List<VaiTro> findAll();
    void save(VaiTro t);
    void update(VaiTro t);
    void deleteById(Integer id);
}
