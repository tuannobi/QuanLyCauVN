package com.quanlycauvn.controller;


import com.quanlycauvn.dao.UserDao;
import com.quanlycauvn.dao.UserDaoImpl;
import com.quanlycauvn.model.User;
import com.quanlycauvn.util.Constant;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/login")
public class LoginController extends HttpServlet {
    private UserDao userDao;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession(false);//neu khong tim thay session thi khong tao moi
        if (session!=null && session.getAttribute("user")!=null){
            resp.sendRedirect(req.getContextPath()+"/user");
            return;
        }

        req.getRequestDispatcher(Constant.Path.urlLOGIN).forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getServletPath());
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        userDao= new UserDaoImpl();
        User user=userDao.findUserByUsernameAndPassowrd(username,password);
        if(user!=null){
            HttpSession session=req.getSession();
            session.setAttribute("user",user);
            switch (user.getVaiTro().getMaVaiTro()){
                case 1:
                    resp.sendRedirect(req.getContextPath()+ "/user");
                    break;
                case 2:
                    resp.sendRedirect(req.getContextPath()+ "/bogtvt");
                    break;
                case 3:
                    resp.sendRedirect(req.getContextPath()+ "/nhanvien");
                    break;
            }
        }else
        {
            req.setAttribute("errmessage","Sai tên đăng nhập hoặc mật khẩu");
            req.getRequestDispatcher(Constant.Path.urlLOGIN).forward(req,resp);
        }
    }
}
