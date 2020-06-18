package com.quanlycauvn.controller;

import com.quanlycauvn.dao.CauDao;
import com.quanlycauvn.dao.CauDaoImpl;
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

@WebServlet("/bogtvt")
public class IndexCauBoGTVTController extends HttpServlet {
    private CauDao cauDao;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        cauDao=new CauDaoImpl();
        User user= (User) req.getSession().getAttribute("user");
        System.out.println("UserId login "+user.getUserId());
        List<Cau> caus=cauDao.findAll();
        List<Cau> cauGTVT=new ArrayList<>();
        for(Cau cau:caus){
            if(cau.getUser()!=null){
                if(cau.getUser().getUserId()==user.getUserId())
                    cauGTVT.add(cau);
            }
        }
        req.setAttribute("cauList",cauGTVT);
        req.getRequestDispatcher(Constant.Path.urlCauGTVTIndex).forward(req,resp);
    }
}
