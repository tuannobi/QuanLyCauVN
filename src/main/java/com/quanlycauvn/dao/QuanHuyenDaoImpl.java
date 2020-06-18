package com.quanlycauvn.dao;

import com.quanlycauvn.model.QuanHuyen;
import com.quanlycauvn.model.User;
import com.quanlycauvn.util.HibernateUtil;
import org.hibernate.Session;

import javax.persistence.Query;
import java.util.List;

public class QuanHuyenDaoImpl extends GenericDaoImpl<QuanHuyen,String> implements QuanHuyenDao {
    @Override
    public List<QuanHuyen> findByMaTp(String matp) {
        List<QuanHuyen> list=null;
        String hql="from QuanHuyen U where U.tinhThanhPho.matp= :matp";
        try{
            Session session= HibernateUtil.getSessionFactory().openSession();
            Query query =session.createQuery(hql);
            query.setParameter("matp",matp);
            list= query.getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
}
