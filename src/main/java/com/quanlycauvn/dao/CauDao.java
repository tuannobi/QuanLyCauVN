package com.quanlycauvn.dao;

import com.quanlycauvn.model.Cau;

import java.util.List;
import java.util.Map;

public interface CauDao extends GenericDao<Cau,Integer> {
    Cau findById(Integer id);
    List<Cau> findAll();
    void save(Cau t);
    void update(Cau t);
    void deleteById(Integer id);
    void updateUser(int userId,int maCau);
    void updateUserIsNull(int maCau);
    Map<String,Integer> groupByTinhTrang();
}
