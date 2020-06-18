package com.quanlycauvn.dao;

import com.quanlycauvn.model.QuanHuyen;
import com.quanlycauvn.model.XaPhuongThiTran;

import java.util.List;

public interface XaPhuongThiTranDao extends GenericDao<XaPhuongThiTran,String> {
    XaPhuongThiTran findById(String id);
    List<XaPhuongThiTran> findAll();
    void save(XaPhuongThiTran t);
    void update(XaPhuongThiTran t);
    void deleteById(String id);
    List<XaPhuongThiTran> findByMaqh(String maqh);
}
