package com.quanlycauvn.main;

import com.quanlycauvn.dao.QuanHuyenDao;
import com.quanlycauvn.dao.QuanHuyenDaoImpl;
import com.quanlycauvn.dao.XaPhuongThiTranDao;
import com.quanlycauvn.dao.XaPhuongThiTranDaoImpl;
import com.quanlycauvn.model.XaPhuongThiTran;

public class FindHuyenMainTest {
    public static void main(String[] args) {
        XaPhuongThiTranDao quanHuyenDao=new XaPhuongThiTranDaoImpl();
        System.out.println(quanHuyenDao.findByMaqh("002").size());
    }
}
