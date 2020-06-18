package com.quanlycauvn.dao;

import com.quanlycauvn.model.QuanHuyen;
import com.quanlycauvn.model.SoGTVT;

import java.util.List;

public interface SoGTVTDao extends GenericDao<SoGTVT, Integer> {
    SoGTVT findById(Integer id);
    List<SoGTVT> findAll();
    void save(SoGTVT t);
    void update(SoGTVT t);
    void deleteById(Integer id);
}
