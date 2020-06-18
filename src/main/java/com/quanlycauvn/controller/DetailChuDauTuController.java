package com.quanlycauvn.controller;

import com.quanlycauvn.dao.ChuDauTuDao;
import com.quanlycauvn.dao.ChuDauTuDaoImpl;
import com.quanlycauvn.model.ChuDauTu;
import com.quanlycauvn.util.Constant;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/chudautu/detail")
public class DetailChuDauTuController extends HttpServlet {
    private ChuDauTuDao chuDauTuDao;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        chuDauTuDao=new ChuDauTuDaoImpl();
        ChuDauTu chuDauTu=chuDauTuDao.findById(Integer.parseInt(req.getParameter("id")));
        if(chuDauTu!=null){
            req.setAttribute("chuDauTu",chuDauTu);
            req.getRequestDispatcher(Constant.Path.urlChuDauTuDetail).forward(req,resp);
        }
    }
}
