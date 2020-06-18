package com.quanlycauvn.controller;

import com.quanlycauvn.dao.CauDao;
import com.quanlycauvn.dao.CauDaoImpl;
import com.quanlycauvn.model.Cau;
import com.quanlycauvn.util.Constant;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/nhanvien/detail")
public class DetailCauNhanVienController extends HttpServlet {
    private CauDao cauDao;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        if (id > 0) {
            cauDao=new CauDaoImpl();
            Cau cau= cauDao.findById(id);
            req.setAttribute("cau",cau);
            req.getRequestDispatcher(Constant.Path.urlCauNhanVienDetail).forward(req, resp);
        }
    }
}
