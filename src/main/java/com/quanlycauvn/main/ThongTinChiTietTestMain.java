package com.quanlycauvn.main;

import com.quanlycauvn.dao.ThongTinNhanVienDao;
import com.quanlycauvn.dao.ThongTinNhanVienDaoImpl;
import com.quanlycauvn.model.ThongTinNhanVien;

public class ThongTinChiTietTestMain {
    public static void main(String[] args) {
        ThongTinNhanVienDao thongTinNhanVienDao =new ThongTinNhanVienDaoImpl();
        ThongTinNhanVien thongTinNhanVien = thongTinNhanVienDao.findByUserId(1);
        System.out.println(thongTinNhanVien.getHoTen());
    }
}
