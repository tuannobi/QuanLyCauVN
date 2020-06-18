package com.quanlycauvn.dao;

import com.quanlycauvn.model.ChuDauTu;

import java.util.List;

public interface ChuDauTuDao extends GenericDao<ChuDauTu,Integer> {
    ChuDauTu findById(Integer id);
    List<ChuDauTu> findAll();
    void save(ChuDauTu t);
    void update(ChuDauTu t);
    void deleteById(Integer id);
}
