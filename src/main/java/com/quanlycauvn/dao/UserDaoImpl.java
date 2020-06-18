package com.quanlycauvn.dao;

import com.quanlycauvn.model.User;
import com.quanlycauvn.util.HibernateUtil;
import org.hibernate.Session;

import javax.persistence.Query;
import java.util.List;

public class UserDaoImpl extends GenericDaoImpl<User,Integer> implements UserDao  {

    @Override
    public User findByUsername(String username) {
        User user=null;
        String hql="from User U where U.username= :username";
        try{
            Session session= HibernateUtil.getSessionFactory().openSession();
            Query query =session.createQuery(hql);
            query.setParameter("username",username);
            List<User> userList= query.getResultList();
            user=userList.get(0);
        }catch (Exception e){
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public User findUserByUsernameAndPassowrd(String username, String password) {
        User user=null;
        String hql="from User U where U.username= :username and U.password= :password";
        try{
            Session session= HibernateUtil.getSessionFactory().openSession();
            Query query =session.createQuery(hql);
            query.setParameter("username",username);
            query.setParameter("password",password);
            List<User> userList= query.getResultList();
            user=userList.get(0);
        }catch (Exception e){
            e.printStackTrace();
        }
        return user;
    }
}
