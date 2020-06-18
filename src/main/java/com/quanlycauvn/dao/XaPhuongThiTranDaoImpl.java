package com.quanlycauvn.dao;

import com.quanlycauvn.model.QuanHuyen;
import com.quanlycauvn.model.XaPhuongThiTran;
import com.quanlycauvn.util.HibernateUtil;
import org.hibernate.Session;

import javax.persistence.Query;
import java.util.List;

public class XaPhuongThiTranDaoImpl extends GenericDaoImpl<XaPhuongThiTran,String> implements XaPhuongThiTranDao {
    @Override
    public List<XaPhuongThiTran> findByMaqh(String maqh) {
        List<XaPhuongThiTran> list=null;
        String hql="from XaPhuongThiTran U where U.quanHuyen.maqh= :maqh";
        try{
            Session session= HibernateUtil.getSessionFactory().openSession();
            Query query =session.createQuery(hql);
            query.setParameter("maqh",maqh);
            list= query.getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
}
