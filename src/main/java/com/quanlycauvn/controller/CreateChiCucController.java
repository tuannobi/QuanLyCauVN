package com.quanlycauvn.controller;

import com.quanlycauvn.dao.CauDao;
import com.quanlycauvn.dao.CauDaoImpl;
import com.quanlycauvn.dao.UserDao;
import com.quanlycauvn.dao.UserDaoImpl;
import com.quanlycauvn.model.*;
import com.quanlycauvn.util.Constant;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet("/chicuc/create")
public class CreateChiCucController extends HttpServlet {
    private UserDao userDao;
    private CauDao cauDao;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        userDao=new UserDaoImpl();
        cauDao=new CauDaoImpl();
        List<User> users=userDao.findAll();
        List<Cau> caus=cauDao.findAll();
        List<User> userSoGTVTList=new ArrayList<>();
        List<Cau> cauSoGTVTList=new ArrayList<>();
        for(User user:users){
            if(user.getVaiTro().getMaVaiTro()==2){
                userSoGTVTList.add(user);
            }
        }
        for(Cau cau:caus){
            if(cau.getUser()==null){
                cauSoGTVTList.add(cau);
            }
        }

        req.setAttribute("userList",userSoGTVTList);
        req.setAttribute("cauList",cauSoGTVTList);
        req.getRequestDispatcher(Constant.Path.urlChiCucCreate).forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        int userId=Integer.parseInt(req.getParameter("userId"));
        int maCau=Integer.parseInt(req.getParameter("soThuTu"));
        Cau modelCau=cauDao.findById(maCau);
        Cau saveCau=new Cau();
        User user=new User();
        user.setUserId(userId);
        saveCau.setTenCau(modelCau.getTenCau());
        saveCau.setSoThuTu(maCau);
        saveCau.setNgayCapNhat(new Date());
        saveCau.setXaPhuongThiTran(new XaPhuongThiTran(modelCau.getXaPhuongThiTran().getXaId()));
        saveCau.setQuanHuyen(new QuanHuyen(modelCau.getQuanHuyen().getMaqh()));
        saveCau.setTinhThanhPho(new TinhThanhPho(modelCau.getTinhThanhPho().getMatp()));
        saveCau.setChuDauTu(new ChuDauTu(modelCau.getChuDauTu().getMaChuDauTu()));
        saveCau.setTinhTrangCau(modelCau.getTinhTrangCau());
        saveCau.setQuocLo(modelCau.getQuocLo());
        saveCau.setDonViQuanLy(modelCau.getDonViQuanLy());
        saveCau.setDonViGiamSat(modelCau.getDonViGiamSat());
        saveCau.setDonViThiCong(modelCau.getDonViThiCong());
        saveCau.setDonViThietKe(modelCau.getDonViThietKe());
        saveCau.setUser(user);
        saveCau.setNamXayDung(modelCau.getNamXayDung());
        saveCau.setNamDuaVaoKhaiThac(modelCau.getNamDuaVaoKhaiThac());
        saveCau.setNamHoanThanh(modelCau.getNamHoanThanh());
        saveCau.setNgayTao(modelCau.getNgayTao());
        saveCau.setTongMucDauTu(modelCau.getTongMucDauTu());
        saveCau.setTaiTrongThietKe(modelCau.getTaiTrongThietKe());

        cauDao=new CauDaoImpl();
        cauDao.update(saveCau);
        req.getSession().setAttribute("succmessage","Thêm thành công");
        resp.sendRedirect(req.getContextPath()+"/chicuc");
    }
}
