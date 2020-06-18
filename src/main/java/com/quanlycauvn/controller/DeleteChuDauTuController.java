package com.quanlycauvn.controller;

import com.quanlycauvn.dao.ChuDauTuDao;
import com.quanlycauvn.dao.ChuDauTuDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/chudautu/delete")
public class DeleteChuDauTuController extends HttpServlet {
    private ChuDauTuDao chuDauTuDao;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id=Integer.parseInt(req.getParameter("id"));
        if (id>0){
            chuDauTuDao=new ChuDauTuDaoImpl();
            chuDauTuDao.deleteById(id);
            req.setAttribute("succmessage","Xóa thành công");
            resp.sendRedirect(req.getContextPath()+"/chudautu");
        }
    }
}
