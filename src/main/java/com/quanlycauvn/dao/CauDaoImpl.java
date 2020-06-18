package com.quanlycauvn.dao;

import com.quanlycauvn.model.Cau;
import com.quanlycauvn.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CauDaoImpl extends GenericDaoImpl<Cau,Integer> implements CauDao  {

    @Override
    public void updateUser(int userId, int maCau) {
        Transaction transaction=null;
        String hql="update Cau set userId= :userId where soThuTu= :maCau";
        try{
            Session session= HibernateUtil.getSessionFactory().openSession();
            transaction=session.beginTransaction();
            Query query=session.createQuery(hql);
            query.setParameter("userId",userId);
            query.setParameter("maCau",maCau);
            query.executeUpdate();
            transaction.commit();
        }catch (Exception e){
            if(transaction!=null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void updateUserIsNull(int maCau) {
        Transaction transaction=null;
        String hql="update Cau set userId= null where soThuTu= :maCau";
        try{
            Session session= HibernateUtil.getSessionFactory().openSession();
            transaction=session.beginTransaction();
            Query query=session.createQuery(hql);
            query.setParameter("maCau",maCau);
            query.executeUpdate();
            transaction.commit();
        }catch (Exception e){
            if(transaction!=null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }


    @Override
    public Map<String,Integer> groupByTinhTrang() {
        Transaction transaction=null;
        String hql="from Cau";
        List<String> tinhTrangGroups=new ArrayList<>();
        Map<String,Integer> map=new HashMap<>();
        try{
            CauDao cauDao=new CauDaoImpl();
            List<Cau> caus=cauDao.findAll();
            int countCauRatYeu=0;
            int countCauYeu=0;
            int countCauBinhThuong=0;
            for(Cau cau:caus){
                if(cau.getTinhTrangCau().equals("Cầu rất yếu"))
                    countCauRatYeu++;
            }
            for(Cau cau:caus){
                if(cau.getTinhTrangCau().equals("Cầu yếu"))
                    countCauYeu++;
            }
            for(Cau cau:caus){
                if(cau.getTinhTrangCau().equals("Cầu bình thường"))
                    countCauBinhThuong++;
            }
            map.put("Cầu rất yếu",countCauRatYeu);
            map.put("Cầu yếu",countCauYeu);
            map.put("Cầu bình thường",countCauBinhThuong);
        }catch (Exception e){
            if(transaction!=null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return map;
    }
}
