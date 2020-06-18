package com.quanlycauvn.controller;

import com.quanlycauvn.dao.UserDao;
import com.quanlycauvn.dao.UserDaoImpl;
import com.quanlycauvn.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/delete")
public class DeleteUserController extends HttpServlet {
    private UserDao userDao;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id=Integer.parseInt(req.getParameter("id"));
        if (id>0){
            userDao=new UserDaoImpl();
            userDao.deleteById(id);
            req.getSession().setAttribute("succmessage","Xóa thành công");
            resp.sendRedirect(req.getContextPath()+"/user");
        }
    }
}
