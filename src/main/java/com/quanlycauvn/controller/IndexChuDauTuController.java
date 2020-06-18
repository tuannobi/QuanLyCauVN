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
import java.util.List;

@WebServlet("/chudautu")
public class IndexChuDauTuController extends HttpServlet {
    private ChuDauTuDao chuDauTuDao;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        chuDauTuDao=new ChuDauTuDaoImpl();
        List<ChuDauTu> chuDauTuList= chuDauTuDao.findAll();
        req.setAttribute("chuDauTuList",chuDauTuList);
        req.getRequestDispatcher(Constant.Path.urlChuDauTuIndex).forward(req,resp);
    }
}
