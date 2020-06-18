package com.quanlycauvn.main;

import com.quanlycauvn.dao.CauDao;
import com.quanlycauvn.dao.CauDaoImpl;
import com.quanlycauvn.model.Cau;

public class UpdateCauTestMain {
    public static void main(String[] args) {
        CauDao cauDao=new CauDaoImpl();
        cauDao.updateUser(19,2);
    }
}
