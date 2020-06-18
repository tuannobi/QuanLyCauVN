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

@WebServlet("/chudautu/update")
public class UpdateChuDauTuController extends HttpServlet {
    private ChuDauTuDao chuDauTuDao;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        chuDauTuDao=new ChuDauTuDaoImpl();
        ChuDauTu chuDauTu=chuDauTuDao.findById(Integer.parseInt(req.getParameter("id")));
        req.setAttribute("chuDauTu",chuDauTu);
        req.getRequestDispatcher(Constant.Path.urlChuDauTuEdit).forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        ChuDauTu chuDauTu=new ChuDauTu();
        chuDauTuDao=new ChuDauTuDaoImpl();
        chuDauTu.setMaChuDauTu(Integer.parseInt(req.getParameter("maChuDauTu")));
        chuDauTu.setTenChuDauTu(req.getParameter("tenChuDauTu"));
        try {
            chuDauTu.setNgaySinh(Utils.StringToDateMySql(req.getParameter("ngaySinh")));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        chuDauTu.setDiaChi(req.getParameter("diaChi"));
        chuDauTu.setSDT(req.getParameter("soDienThoai"));
        chuDauTu.setEmail(req.getParameter("email"));
        chuDauTuDao.update(chuDauTu);
        req.setAttribute("succmessage","Cập nhật thành công");
        resp.sendRedirect(req.getContextPath()+"/chudautu");
    }
}
