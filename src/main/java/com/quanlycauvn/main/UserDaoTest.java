package com.quanlycauvn.main;

import com.quanlycauvn.dao.UserDao;
import com.quanlycauvn.dao.UserDaoImpl;
import com.quanlycauvn.model.User;

public class UserDaoTest {
    public static void main(String[] args) {
        UserDao userDao= new UserDaoImpl();
        User user=userDao.findByUsername("admin");
        if(user!=null){
            System.out.println("Co");
        }else{
            System.out.println("khong co");
        }
//        List<User> userList= userDao.findAll();
//        System.out.println(userList.get(0).getUsername());
    }
}
