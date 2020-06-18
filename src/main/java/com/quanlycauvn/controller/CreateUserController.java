package com.quanlycauvn.controller;

import com.quanlycauvn.dao.*;
import com.quanlycauvn.model.*;
import com.quanlycauvn.util.Constant;
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

@WebServlet("/user/create")
public class CreateUserController extends HttpServlet {
    private VaiTroDao vaiTroDao;
    private UserDao userDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        vaiTroDao=new VaiTroImpl();
        List<VaiTro> vaiTros=vaiTroDao.findAll();
        req.setAttribute("vaiTroList",vaiTros);
        req.getRequestDispatcher(Constant.Path.urlUserCreate).forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        userDao=new UserDaoImpl();
        int maVaiTro=Integer.parseInt(req.getParameter("vaiTro"));
        User user=new User();
        String username="";
        String password="";
        switch (maVaiTro){
            case 1:
                username=req.getParameter("username");
                password=req.getParameter("password");
                String tenDRVN=req.getParameter("tenDRVN");
                VaiTro vaiTroDRVN=new VaiTro();
                vaiTroDRVN.setMaVaiTro(1);
                DRVN drvn=new DRVN();
                drvn.setTen(tenDRVN);
                user.setDrvn(drvn);
                user.setVaiTro(vaiTroDRVN);
                user.setUsername(username);
                user.setPassword(password);
                drvn.setUser(user);
                userDao.save(user);
                break;
            case 2:
                username=req.getParameter("username");
                password=req.getParameter("password");
                String tenSoGTVT=req.getParameter("tenSoGTVT");
                VaiTro vaiTro=new VaiTro();
                vaiTro.setMaVaiTro(2);
                SoGTVT soGTVT=new SoGTVT();
                soGTVT.setTen(tenSoGTVT);
                user.setSoGTVT(soGTVT);
                user.setVaiTro(vaiTro);
                user.setUsername(username);
                user.setPassword(password);
                soGTVT.setUser(user);
                userDao.save(user);
                break;
            case 3:
                username=req.getParameter("username");
                password=req.getParameter("password");
                VaiTro vaiTroNhanVien=new VaiTro();
                vaiTroNhanVien.setMaVaiTro(3);
                String hoTen=req.getParameter("hoTen");
                Date ngaySinh= null;
                try {
                    ngaySinh = Utils.StringToDateMySql(req.getParameter("ngaySinh"));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                String soDienThoai=req.getParameter("soDienThoai");
                String email=req.getParameter("email");
                String diaChi=req.getParameter("diaChi");
                ThongTinNhanVien thongTinNhanVien=new ThongTinNhanVien();
                thongTinNhanVien.setHoTen(hoTen);
                thongTinNhanVien.setDiaChi(diaChi);
                thongTinNhanVien.setEmail(email);
                thongTinNhanVien.setNgaySinh(ngaySinh);
                thongTinNhanVien.setSDT(soDienThoai);
                user.setUsername(username);
                user.setPassword(password);
                user.setVaiTro(vaiTroNhanVien);
                thongTinNhanVien.setUser(user);
                user.setThongTinNhanVien(thongTinNhanVien);
                userDao.save(user);
                break;
        }
        req.getSession().setAttribute("succmessage","Thêm thành công");
        resp.sendRedirect(req.getContextPath()+"/user");
    }
}
