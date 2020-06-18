package com.quanlycauvn.dao;

import com.quanlycauvn.model.ChuDauTu;
import com.quanlycauvn.model.DRVN;

import java.util.List;

public interface DRVNDao extends GenericDao<DRVN, Integer> {
    DRVN findById(Integer id);
    List<DRVN> findAll();
    void save(DRVN t);
    void update(DRVN t);
    void deleteById(Integer id);
}
