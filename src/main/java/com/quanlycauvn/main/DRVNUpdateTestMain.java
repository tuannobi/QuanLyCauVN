package com.quanlycauvn.main;

import com.quanlycauvn.dao.DRVNDao;
import com.quanlycauvn.dao.DRVNDaoImpl;
import com.quanlycauvn.dao.UserDao;
import com.quanlycauvn.dao.UserDaoImpl;
import com.quanlycauvn.model.DRVN;
import com.quanlycauvn.model.User;
import com.quanlycauvn.model.VaiTro;

public class DRVNUpdateTestMain {
    public static void main(String[] args) {
        DRVNDao drvnDao=new DRVNDaoImpl();
        UserDao userDao=new UserDaoImpl();
        User user=userDao.findById(19);
        DRVN drvn=new DRVN();
        User tempUser=new User();
        tempUser.setUserId(19);
        tempUser.setUsername("tuantuantuan");
        tempUser.setPassword(user.getPassword());
        tempUser.setVaiTro(user.getVaiTro());
        VaiTro vaiTro=new VaiTro();
        vaiTro.setMaVaiTro(1);
        user.setVaiTro(vaiTro);
        drvn.setMaDRVN(3);
        drvn.setUser(tempUser);
        drvn.setTen("helllo");
        drvnDao.update(drvn);
    }
}
