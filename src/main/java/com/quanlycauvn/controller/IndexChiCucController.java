package com.quanlycauvn.controller;

import com.quanlycauvn.dao.CauDao;
import com.quanlycauvn.dao.CauDaoImpl;
import com.quanlycauvn.dao.UserDao;
import com.quanlycauvn.dao.UserDaoImpl;
import com.quanlycauvn.model.Cau;
import com.quanlycauvn.model.User;
import com.quanlycauvn.util.Constant;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/chicuc")
public class IndexChiCucController extends HttpServlet {
    private CauDao cauDao;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        cauDao=new CauDaoImpl();
        List<Cau> caus=cauDao.findAll();
        List<Cau> cauSoGTVTList=new ArrayList<>();
        if(caus.size()>0){
            for(Cau cau:caus){
                if(cau.getUser()!=null){
                    if(cau.getUser().getVaiTro().getMaVaiTro()==2){
                        cauSoGTVTList.add(cau);
                    }
                }
            }
        }
            req.setAttribute("cauList",cauSoGTVTList);
            req.getRequestDispatcher(Constant.Path.urlChiCucIndex).forward(req,resp);

    }
}
