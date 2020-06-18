package com.quanlycauvn.controller;

import com.quanlycauvn.dao.CauDao;
import com.quanlycauvn.dao.CauDaoImpl;
import com.quanlycauvn.dao.UserDao;
import com.quanlycauvn.dao.UserDaoImpl;
import com.quanlycauvn.model.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet("/chicuc/delete")
public class DeleteChiCucController extends HttpServlet {
    private CauDao cauDao;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id=Integer.parseInt(req.getParameter("id"));
        if (id>0){
            cauDao=new CauDaoImpl();
            cauDao.updateUserIsNull(id);
            req.getSession().setAttribute("succmessage","Xóa thành công");
            resp.sendRedirect(req.getContextPath()+"/chicuc");
        }
    }
}
