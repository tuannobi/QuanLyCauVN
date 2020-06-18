package com.quanlycauvn.main;

import com.quanlycauvn.dao.CauDao;
import com.quanlycauvn.dao.CauDaoImpl;

public class DeleteChiCuc {
    public static void main(String[] args) {
        CauDao cauDao=new CauDaoImpl();
        cauDao.updateUserIsNull(2);
    }
}
