package com.quanlycauvn.controller;

import com.google.gson.Gson;
import com.quanlycauvn.dao.QuanHuyenDao;
import com.quanlycauvn.dao.QuanHuyenDaoImpl;
import com.quanlycauvn.dao.XaPhuongThiTranDao;
import com.quanlycauvn.dao.XaPhuongThiTranDaoImpl;
import com.quanlycauvn.model.QuanHuyen;
import com.quanlycauvn.model.XaPhuongThiTran;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/getXaAjax")
public class GetPhuongXaAjax extends HttpServlet {
    private XaPhuongThiTranDao xaPhuongThiTranDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        xaPhuongThiTranDao = new XaPhuongThiTranDaoImpl();
        List<XaPhuongThiTran> xaPhuongThiTrans = xaPhuongThiTranDao.findByMaqh(req.getParameter("id"));
        Map<String, String> map = new LinkedHashMap<>();
        for (XaPhuongThiTran xaPhuongThiTran : xaPhuongThiTrans) {
            map.put(xaPhuongThiTran.getXaId(), xaPhuongThiTran.getName());
        }
        String json = new Gson().toJson(map);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(json);
    }
}
