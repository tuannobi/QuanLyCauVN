package com.quanlycauvn.main;

import com.quanlycauvn.dao.VaiTroDao;
import com.quanlycauvn.dao.VaiTroImpl;
import com.quanlycauvn.model.VaiTro;

import java.util.List;

public class GenericTestMain {
    public static void main(String[] args) {
        VaiTro vaiTro= new VaiTro(2,"Bộ giao thông vận tải","");
        VaiTroDao vaiTroDao=new VaiTroImpl();
//        vaiTroDao.save(vaiTro);
        List<VaiTro> vaiTroList=vaiTroDao.findAll();
        for(VaiTro vaiTro1:vaiTroList){
            System.out.println(vaiTro1.getLoaiVaiTro());
        }
    }
}
