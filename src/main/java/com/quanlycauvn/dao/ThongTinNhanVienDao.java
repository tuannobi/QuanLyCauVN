package com.quanlycauvn.dao;

import com.quanlycauvn.model.ThongTinNhanVien;

import java.util.List;

public interface ThongTinNhanVienDao extends GenericDao<ThongTinNhanVien,Integer> {
    ThongTinNhanVien findById(Integer id);
    List<ThongTinNhanVien> findAll();
    ThongTinNhanVien findByUserId(Integer userId);
    void save(ThongTinNhanVien t);
    void update(ThongTinNhanVien t);
    void deleteById(Integer id);
}
