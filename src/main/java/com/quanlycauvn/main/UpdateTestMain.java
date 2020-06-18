package com.quanlycauvn.main;

import com.quanlycauvn.dao.VaiTroDao;
import com.quanlycauvn.dao.VaiTroImpl;
import com.quanlycauvn.model.VaiTro;
import com.quanlycauvn.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UpdateTestMain {
    public static void main(String[] args) {
        VaiTroDao vaiTroDao=new VaiTroImpl();
        VaiTro vaiTro=vaiTroDao.findById(3);
        System.out.println(vaiTro.toString());
        Transaction transaction=null;
        try{
            Session session= HibernateUtil.getSessionFactory().openSession();
            transaction=session.beginTransaction();
            session.update(vaiTro);
            transaction.commit();
        }catch (Exception e){
            if(transaction!=null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
