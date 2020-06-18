package com.quanlycauvn.controller;

import com.quanlycauvn.dao.*;
import com.quanlycauvn.model.*;
import com.quanlycauvn.util.Constant;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet("/chicuc/update")
public class UpdateChiCucController extends HttpServlet {
    private UserDao userDao;
    private CauDao cauDao;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Cau cau=null;
        if (id > 0) {
            userDao=new UserDaoImpl();
            cauDao=new CauDaoImpl();
            cau=cauDao.findById(id);
            List<User> users=userDao.findAll();
            List<Cau> caus=cauDao.findAll();
            List<User> userSoGTVTList=new ArrayList<>();
            List<Cau> cauSoGTVTList=new ArrayList<>();
            for(User user:users){
                if(user.getVaiTro().getMaVaiTro()==2){
                    userSoGTVTList.add(user);
                }
            }
            for(Cau tempCau:caus){
                if(tempCau.getUser()==null){
                    cauSoGTVTList.add(tempCau);
                }
            }
            req.setAttribute("cau",cau);
            req.setAttribute("userList",userSoGTVTList);
            req.setAttribute("cauList",cauSoGTVTList);
            req.getRequestDispatcher(Constant.Path.urlChicucEdit).forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        int userId=Integer.parseInt(req.getParameter("userId"));
        int maCau=Integer.parseInt(req.getParameter("soThuTu"));
        int oldMaCau=Integer.parseInt(req.getParameter("oldSoThuTu"));
        System.out.println("User id: "+userId);
        System.out.println("ma cau: "+maCau);
        cauDao=new CauDaoImpl();
        cauDao.updateUserIsNull(oldMaCau);
        cauDao.updateUser(userId,maCau);
        req.getSession().setAttribute("succmessage","Cập nhật thành công");
        resp.sendRedirect(req.getContextPath()+"/chicuc");
    }
}
