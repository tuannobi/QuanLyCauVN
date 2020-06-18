package com.quanlycauvn.dao;

import com.quanlycauvn.model.ThongTinNhanVien;
import com.quanlycauvn.util.HibernateUtil;
import org.hibernate.Session;

import javax.persistence.Query;
import java.util.List;

public class ThongTinNhanVienDaoImpl extends GenericDaoImpl<ThongTinNhanVien,Integer> implements ThongTinNhanVienDao {
    @Override
    public ThongTinNhanVien findByUserId(Integer userId) {
        ThongTinNhanVien thongTinNhanVien =null;
        String hql="from ThongTinChiTiet T where T.user.userId= :userId";
        try{
            Session session= HibernateUtil.getSessionFactory().openSession();
            Query query =session.createQuery(hql);
            query.setParameter("userId",userId);
            List<ThongTinNhanVien> thongTinNhanViens = query.getResultList();
            thongTinNhanVien = thongTinNhanViens.get(0);
        }catch (Exception e){
            e.printStackTrace();
        }
        return thongTinNhanVien;
    }
}
