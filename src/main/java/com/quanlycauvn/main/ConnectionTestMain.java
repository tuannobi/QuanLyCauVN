package com.quanlycauvn.main;

import com.quanlycauvn.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ConnectionTestMain {
    public static void main(String[] args) {
        Transaction transaction=null;
        Session session= HibernateUtil.getSessionFactory().openSession();
        if(session.isConnected()){
            System.out.println("Kết nối thành công");
        }else{
            System.out.println("Kết nối thất bại");
        }
    }
}
