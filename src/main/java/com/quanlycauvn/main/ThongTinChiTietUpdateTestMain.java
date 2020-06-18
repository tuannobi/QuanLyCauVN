package com.quanlycauvn.main;

import com.quanlycauvn.model.ThongTinNhanVien;
import com.quanlycauvn.model.User;
import com.quanlycauvn.model.VaiTro;
import com.quanlycauvn.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ThongTinChiTietUpdateTestMain {
    public static void main(String[] args) {
        ThongTinNhanVien thongTinNhanVien =new ThongTinNhanVien();
        Transaction transaction=null;
        try{
            Session session= HibernateUtil.getSessionFactory().openSession();
            transaction=session.beginTransaction();
            thongTinNhanVien =session.get(ThongTinNhanVien.class,8);
            VaiTro vaiTro= session.get(VaiTro.class,3);
            thongTinNhanVien.setHoTen("thongtinchitiet");
            User user=session.get(User.class, thongTinNhanVien.getUser().getUserId());
            user.setUsername("tuantuatlsjflasn");
            session.update(thongTinNhanVien);
            transaction.commit();
        }catch (Exception e){
            if(transaction!=null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
