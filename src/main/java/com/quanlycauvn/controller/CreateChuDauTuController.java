package com.quanlycauvn.controller;

import com.quanlycauvn.dao.ChuDauTuDao;
import com.quanlycauvn.dao.ChuDauTuDaoImpl;
import com.quanlycauvn.model.ChuDauTu;
import com.quanlycauvn.util.Constant;
import com.quanlycauvn.util.Utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;

@WebServlet("/chudautu/create")
public class CreateChuDauTuController extends HttpServlet {
    private ChuDauTuDao chuDauTuDao;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(Constant.Path.urlChuDauTuCreate).forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        chuDauTuDao=new ChuDauTuDaoImpl();
        ChuDauTu chuDauTu=new ChuDauTu();
        chuDauTu.setTenChuDauTu(req.getParameter("tenChuDauTu"));
        try {
            chuDauTu.setNgaySinh(Utils.StringToDateMySql(req.getParameter("ngaySinh")));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        chuDauTu.setDiaChi(req.getParameter("diaChi"));
        chuDauTu.setSDT(req.getParameter("soDienThoai"));
        chuDauTu.setEmail(req.getParameter("email"));
        chuDauTuDao.save(chuDauTu);
        req.setAttribute("succmessage","Thêm thành công");
        resp.sendRedirect(req.getContextPath()+"/chudautu");
    }
}
