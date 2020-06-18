package com.quanlycauvn.main;

import com.quanlycauvn.model.User;
import com.quanlycauvn.model.VaiTro;
import com.quanlycauvn.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class VaiTroCrudTestMain {
    public static void main(String[] args) {
        retrieve();
    }

    public static void create(){
        VaiTro vaiTro1=new VaiTro(1,"DRVN","");
        VaiTro vaiTro2=new VaiTro(2,"ChiCuc/SoGTVT","");
        VaiTro vaiTro3=new VaiTro(3,"NhanVien","");
        Transaction transaction=null;
        try{
            Session session= HibernateUtil.getSessionFactory().openSession();
            transaction=session.beginTransaction();
            session.save(vaiTro1);
            session.save(vaiTro2);
            session.save(vaiTro3);
            transaction.commit();
        }catch (Exception e){
            if(transaction!=null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public static void retrieve(){

        try{
            Session session= HibernateUtil.getSessionFactory().openSession();
            List<VaiTro> vaiTros=session.createQuery("from VaiTro",VaiTro.class).getResultList();
            System.out.println(vaiTros.toString());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void retrieveUser(){

        try{
            Session session= HibernateUtil.getSessionFactory().openSession();
            List<User> users=session.createQuery("from User", User.class).getResultList();
//            System.out.println(users.toString());
            for(User user: users){
                System.out.println(user.getVaiTro().getLoaiVaiTro());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void update(){
        VaiTro vaiTro1=new VaiTro(1,"DRVN","");
        VaiTro vaiTro2=new VaiTro(2,"ChiCuc/SoGTVT","");
        VaiTro vaiTro3=new VaiTro(3,"NhanVien","");
        Transaction transaction=null;
        try{
            Session session= HibernateUtil.getSessionFactory().openSession();
            transaction=session.beginTransaction();
            session.update(vaiTro1);
            session.update(vaiTro2);
            session.update(vaiTro3);
            transaction.commit();
        }catch (Exception e){
            if(transaction!=null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public static void delete(){
        Transaction transaction=null;
        VaiTro vaiTro1=new VaiTro();
        VaiTro vaiTro2=new VaiTro();
        VaiTro vaiTro3=new VaiTro();
        vaiTro1.setMaVaiTro(8);
        vaiTro2.setMaVaiTro(9);
        vaiTro3.setMaVaiTro(10);
        try{
            Session session= HibernateUtil.getSessionFactory().openSession();
            transaction=session.beginTransaction();
            session.delete(vaiTro1);
            session.delete(vaiTro2);
            session.delete(vaiTro3);
            transaction.commit();
        }catch (Exception e){
            if(transaction!=null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

}
