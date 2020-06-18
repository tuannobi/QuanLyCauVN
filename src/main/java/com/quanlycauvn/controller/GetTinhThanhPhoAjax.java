package com.quanlycauvn.controller;

import com.google.gson.Gson;
import com.quanlycauvn.dao.TinhThanhPhoDao;
import com.quanlycauvn.dao.TinhThanhPhoDaoImpl;
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

@WebServlet("/getTinhAjax")
public class GetTinhThanhPhoAjax extends HttpServlet {
    private TinhThanhPhoDao tinhThanhPhoDao;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        tinhThanhPhoDao=new TinhThanhPhoDaoImpl();
        List<TinhThanhPho> tinhThanhPhoList= tinhThanhPhoDao.findAll();
        Map<String,String> map=new LinkedHashMap<>();
        for(TinhThanhPho tinhThanhPho:tinhThanhPhoList){
            map.put(tinhThanhPho.getMatp(),tinhThanhPho.getName());
        }
        String json=new Gson().toJson(map);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(json);
    }
}
