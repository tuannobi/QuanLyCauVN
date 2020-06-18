package com.quanlycauvn.controller;

import com.quanlycauvn.dao.*;
import com.quanlycauvn.model.*;
import com.quanlycauvn.util.Constant;
import com.quanlycauvn.util.ReadFileUtil;
import com.quanlycauvn.util.Utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

@WebServlet("/bridge/update")
public class UpdateCauController extends HttpServlet {
    private CauDao cauDao;
    private ChuDauTuDao chuDauTuDao;
    private TinhThanhPhoDao tinhThanhPhoDao;
    private ReadFileUtil readFileUtil;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        if (id > 0) {
            cauDao=new CauDaoImpl();
            Cau cau= cauDao.findById(id);
            req.setAttribute("cau",cau);
            readFileUtil=new ReadFileUtil();
            req.setAttribute("taiTrongThietKeList",readFileUtil.readTextFile("TaiTrongThietKe.txt"));
            req.setAttribute("donViThietKeList",readFileUtil.readTextFile("DonViThietKe.txt"));
            req.setAttribute("donViThiCongList",readFileUtil.readTextFile("DonViThiCong.txt"));
            req.setAttribute("donViGiamSatList",readFileUtil.readTextFile("DonViGiamSat.txt"));
            req.setAttribute("donViQuanLyList",readFileUtil.readTextFile("DonViQuanLy.txt"));
            req.setAttribute("quocLoList",readFileUtil.readTextFile("QuocLo.txt"));
            req.setAttribute("tinhTrangCauList",readFileUtil.readTextFile("TinhTrangCau.txt"));
            chuDauTuDao=new ChuDauTuDaoImpl();
            List<ChuDauTu> chuDauTus=chuDauTuDao.findAll();
            tinhThanhPhoDao=new TinhThanhPhoDaoImpl();
            List<TinhThanhPho> tinhThanhPhos=tinhThanhPhoDao.findAll();
            req.setAttribute("tinhList",tinhThanhPhos);
            req.setAttribute("chuDauTuList",chuDauTus);
            req.getRequestDispatcher(Constant.Path.urlCauEdit).forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        cauDao=new CauDaoImpl();
        String tenCau=req.getParameter("tenCau");
        float tongMucDauTu=Float.parseFloat(req.getParameter("tongMucDauTu"));
        int namXayDung=Integer.parseInt(req.getParameter("namXayDung"));
        int namHoanThanh=Integer.parseInt(req.getParameter("namHoanThanh"));
        int namDuaVaoKhaiThac=Integer.parseInt(req.getParameter("namDuaVaoKhaiThac"));
        Date ngayTao=new Date();
        String taiTrongThietKe=req.getParameter("taiTrongThietKe");
        String donViThietKe=req.getParameter("donViThietKe");
        String donViThiCong=req.getParameter("donViThiCong");
        String donViGiamSat=req.getParameter("donViGiamSat");
        String donViQuanLy=req.getParameter("donViQuanLy");
        String quocLo=req.getParameter("quocLo");
        String tinhTrangCau=req.getParameter("tinhTrangCau");
        int maChuDauTu=Integer.parseInt(req.getParameter("maChuDauTu"));
        String maTinhThanhPho=req.getParameter("tinh");
        String maQuanHuyen=req.getParameter("quan");
        String maXaPhuong=req.getParameter("xa");
        TinhThanhPho tinhThanhPho=new TinhThanhPho(maTinhThanhPho);
        QuanHuyen quanHuyen=new QuanHuyen(maQuanHuyen);
        XaPhuongThiTran xaPhuongThiTran=new XaPhuongThiTran(maXaPhuong);
        ChuDauTu chuDauTu=new ChuDauTu();
        chuDauTu.setMaChuDauTu(maChuDauTu);
        Cau cau=new Cau();
        cau.setSoThuTu(Integer.parseInt(req.getParameter("maCau")));
        cau.setTenCau(tenCau);
        cau.setTongMucDauTu(tongMucDauTu);
        cau.setNamXayDung(namXayDung);
        cau.setNamHoanThanh(namHoanThanh);
        cau.setNamDuaVaoKhaiThac(namDuaVaoKhaiThac);
        cau.setNgayTao(ngayTao);
        cau.setTaiTrongThietKe(taiTrongThietKe);
        cau.setDonViThietKe(donViThietKe);
        cau.setDonViThiCong(donViThiCong);
        cau.setDonViGiamSat(donViGiamSat);
        cau.setDonViQuanLy(donViQuanLy);
        cau.setQuocLo(quocLo);
        cau.setTinhTrangCau(tinhTrangCau);
        cau.setChuDauTu(chuDauTu);
        cau.setTinhThanhPho(tinhThanhPho);
        cau.setQuanHuyen(quanHuyen);
        cau.setXaPhuongThiTran(xaPhuongThiTran);
        cau.setNgayCapNhat(new Date());
        cauDao.update(cau);
        req.getSession().setAttribute("succmessage","Cập nhật thành công");
        resp.sendRedirect(req.getContextPath()+"/bridge");
    }
}
