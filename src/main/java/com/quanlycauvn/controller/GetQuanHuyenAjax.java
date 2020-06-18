package com.quanlycauvn.controller;

import com.google.gson.Gson;
import com.quanlycauvn.dao.QuanHuyenDao;
import com.quanlycauvn.dao.QuanHuyenDaoImpl;
import com.quanlycauvn.dao.TinhThanhPhoDao;
import com.quanlycauvn.dao.TinhThanhPhoDaoImpl;
import com.quanlycauvn.model.QuanHuyen;
import com.quanlycauvn.model.TinhThanhPho;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/getHuyenAjax")
public class GetQuanHuyenAjax extends HttpServlet {
    private QuanHuyenDao quanHuyenDao;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        quanHuyenDao=new QuanHuyenDaoImpl();
        List<QuanHuyen> quanHuyenList= quanHuyenDao.findByMaTp(req.getParameter("id"));
        Map<String,String> map=new LinkedHashMap<>();
        for(QuanHuyen quanHuyen:quanHuyenList){
            map.put(quanHuyen.getMaqh(),quanHuyen.getName());
        }
        String json=new Gson().toJson(map);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(json);
    }
}
