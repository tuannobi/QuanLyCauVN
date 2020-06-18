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

@WebServlet("/user/update")
public class UpdateUserController extends HttpServlet {
    private VaiTroDao vaiTroDao;
    private UserDao userDao;
    private ThongTinNhanVienDao thongTinNhanVienDao;
    private DRVNDao drvnDao;
    private SoGTVTDao soGTVTDao;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id=Integer.parseInt(req.getParameter("id"));
        if (id>0){
            userDao=new UserDaoImpl();
            vaiTroDao=new VaiTroImpl();
            User user=userDao.findById(id);
            if (user!=null){
                List<VaiTro> vaiTros=vaiTroDao.findAll();
                req.setAttribute("user",user);
                req.setAttribute("vaiTroList",vaiTros);
                req.getRequestDispatcher(Constant.Path.urlUserEdit).forward(req,resp);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        int userId=Integer.parseInt(req.getParameter("userId"));
        System.out.println("UserId: "+userId);
        String isCheck=req.getParameter("check-changePass");
        userDao=new UserDaoImpl();
        User user=userDao.findById(userId);
        User updateUser=null;
        switch (user.getVaiTro().getMaVaiTro()){
            case 1:
                drvnDao=new DRVNDaoImpl();
                DRVN drvn=new DRVN();
                if(isCheck!=null){
                    if(user.getPassword().equals(req.getParameter("oldPassword"))){
                        updateUser=new User();
                        updateUser.setUserId(userId);
                        updateUser.setUsername(user.getUsername());
                        updateUser.setPassword(req.getParameter("newPassword"));
                        updateUser.setVaiTro(new VaiTro(user.getVaiTro().getMaVaiTro()));
                    }else{
                        req.getSession().setAttribute("message","Mật khẩu cũ sai");
                        resp.sendRedirect(req.getContextPath()+"/user/update?id="+user.getUserId());
                        return;
                    }
                }else{
                    updateUser=new User();
                    updateUser.setUserId(userId);
                    System.out.println("ID: "+updateUser.getUserId());
                    updateUser.setUsername(user.getUsername());
                    updateUser.setPassword(user.getPassword());
                    updateUser.setVaiTro(new VaiTro(user.getVaiTro().getMaVaiTro()));
                }
                drvn.setMaDRVN(user.getDrvn().getMaDRVN());
                drvn.setTen(req.getParameter("tenDRVN"));
                drvn.setUser(updateUser);
                drvnDao.update(drvn);
                break;
            case 2:
                soGTVTDao=new SoGTVTDaoImpl();
                SoGTVT soGTVT=new SoGTVT();
                if(isCheck!=null){
                    if(user.getPassword().equals(req.getParameter("oldPassword"))){
                        updateUser=new User();
                        updateUser.setUserId(userId);
                        updateUser.setUsername(user.getUsername());
                        updateUser.setPassword(req.getParameter("newPassword"));
                        updateUser.setVaiTro(new VaiTro(user.getVaiTro().getMaVaiTro()));
                    }else{
                        req.getSession().setAttribute("message","Mật khẩu cũ sai");
                        resp.sendRedirect(req.getContextPath()+"/user/update?id="+user.getUserId());
                        return;
                    }
                }else{
                    updateUser=new User();
                    updateUser.setUserId(userId);
                    updateUser.setUsername(user.getUsername());
                    updateUser.setPassword(user.getPassword());
                    updateUser.setVaiTro(new VaiTro(user.getVaiTro().getMaVaiTro()));
                }
                soGTVT.setMaSoGTVT(user.getSoGTVT().getMaSoGTVT());
                soGTVT.setTen(req.getParameter("tenSoGTVT"));
                soGTVT.setUser(updateUser);
                soGTVTDao.update(soGTVT);
                break;
            case 3:
                thongTinNhanVienDao=new ThongTinNhanVienDaoImpl();
                ThongTinNhanVien thongTinNhanVien=new ThongTinNhanVien();
                if(isCheck!=null){
                    if(user.getPassword().equals(req.getParameter("oldPassword"))){
                        updateUser=new User();
                        updateUser.setUserId(userId);
                        updateUser.setUsername(user.getUsername());
                        updateUser.setPassword(req.getParameter("newPassword"));
                        updateUser.setVaiTro(new VaiTro(user.getVaiTro().getMaVaiTro()));
                    }else{
                        req.getSession().setAttribute("message","Mật khẩu cũ sai");
                        resp.sendRedirect(req.getContextPath()+"/user/update?id="+user.getUserId());
                        return;
                    }
                }else{
                    updateUser=new User();
                    updateUser.setUserId(userId);
                    updateUser.setUsername(user.getUsername());
                    updateUser.setPassword(user.getPassword());
                    updateUser.setVaiTro(new VaiTro(user.getVaiTro().getMaVaiTro()));
                }
                thongTinNhanVien.setMaThongTin(user.getThongTinNhanVien().getMaThongTin());
                thongTinNhanVien.setHoTen(req.getParameter("hoTen"));
                thongTinNhanVien.setDiaChi(req.getParameter("diaChi"));
                thongTinNhanVien.setEmail(req.getParameter("email"));
                try {
                    thongTinNhanVien.setNgaySinh(Utils.StringToDateMySql(req.getParameter("ngaySinh")));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                thongTinNhanVien.setSDT(req.getParameter("soDienThoai"));

                thongTinNhanVien.setUser(updateUser);
                thongTinNhanVienDao.update(thongTinNhanVien);
                break;
        }
        req.getSession().setAttribute("succmessage","Cập nhật thành công");
        resp.sendRedirect(req.getContextPath()+"/user");
    }
}
