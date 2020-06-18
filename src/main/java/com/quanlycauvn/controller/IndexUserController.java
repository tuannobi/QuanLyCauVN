package com.quanlycauvn.controller;

import com.quanlycauvn.dao.UserDao;
import com.quanlycauvn.dao.UserDaoImpl;
import com.quanlycauvn.dao.VaiTroDao;
import com.quanlycauvn.dao.VaiTroImpl;
import com.quanlycauvn.model.User;
import com.quanlycauvn.model.VaiTro;
import com.quanlycauvn.util.Constant;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/user")
public class IndexUserController extends HttpServlet {
    private UserDao userDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        userDao=new UserDaoImpl();
        List<User> users=userDao.findAll();
        req.setAttribute("userList",users);
        req.getRequestDispatcher(Constant.Path.urlUserIndex).forward(req,resp);
    }
}
