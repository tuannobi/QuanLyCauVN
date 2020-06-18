package com.quanlycauvn.controller;

import com.google.gson.Gson;
import com.quanlycauvn.dao.CauDao;
import com.quanlycauvn.dao.CauDaoImpl;
import com.quanlycauvn.model.Cau;
import com.quanlycauvn.model.QuanHuyen;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/getThongKeTheoTinhTrangAjax")
public class GetThongKeTheoTinhTrangAjax extends HttpServlet {
    private CauDao cauDao;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        cauDao=new CauDaoImpl();
        Map<String,Integer> map=cauDao.groupByTinhTrang();
        String json=new Gson().toJson(map);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(json);
    }
}
