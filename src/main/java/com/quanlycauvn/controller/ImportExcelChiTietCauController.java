package com.quanlycauvn.controller;

import com.quanlycauvn.dao.CauDao;
import com.quanlycauvn.dao.CauDaoImpl;
import com.quanlycauvn.model.*;
import com.quanlycauvn.util.Constant;
import com.quanlycauvn.util.ReadFileUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@WebServlet("/bogtvt/import")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 50, // 50MB
        maxRequestSize = 1024 * 1024 * 50) // 50MB
public class ImportExcelChiTietCauController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CauDao cauDao;
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User user=(User) request.getSession().getAttribute("user");
        for (Part part : request.getParts()) {
            String fileName = extractFileName(part);
            // refines the fileName in case it is an absolute path
            fileName = new File(fileName).getName();
//            part.write(this.getFolderUpload().getAbsolutePath() + File.separator + fileName);
            part.write(this.getFolderUpload().getAbsolutePath() + File.separator + Constant.NameFile.tempImportFileName);
        }
        //Process for Reading file
        ReadFileUtil readFileUtil =new ReadFileUtil();
        List<List<String>> data= readFileUtil.getValues();
        //Insert
        for(List<String> row:data){
            Cau cau=new Cau();
            cau.setTenCau(row.get(0));
            cau.setTongMucDauTu(Float.parseFloat(row.get(1)));
            cau.setNamXayDung((int)Double.parseDouble(row.get(2)));
            cau.setNamHoanThanh((int)Double.parseDouble(row.get(3)));
            cau.setNamDuaVaoKhaiThac((int)Double.parseDouble(row.get(4)));
            cau.setNgayTao(new Date());
            cau.setTaiTrongThietKe(row.get(7));
            cau.setDonViThietKe(row.get(8));
            cau.setDonViThiCong(row.get(9));
            cau.setDonViGiamSat(row.get(10));
            cau.setDonViQuanLy(row.get(11));
            cau.setQuocLo(row.get(12));
            cau.setTinhTrangCau(row.get(13));
            ChuDauTu chuDauTu=new ChuDauTu();
            chuDauTu.setMaChuDauTu((int)Double.parseDouble(row.get(14)));
            cau.setChuDauTu(chuDauTu);
            User saveUser =new User();
            saveUser.setUserId(user.getUserId());
            cau.setUser(saveUser);
            cau.setXaPhuongThiTran(new XaPhuongThiTran(row.get(16)));
            cau.setQuanHuyen(new QuanHuyen(row.get(17)));
            cau.setTinhThanhPho(new TinhThanhPho(row.get(18)));
            cauDao=new CauDaoImpl();
            cauDao.save(cau);
        }
        //
        request.setAttribute("message", "Upload File Success!");
        request.setAttribute("succmessage","Import thành công");
        response.sendRedirect(request.getContextPath()+"/bogtvt");
//        getServletContext().getRequestDispatcher(Constant.Path.urlCauGTVTIndex).forward(request, response);
    }
    /**
     * Extracts file name from HTTP header content-disposition
     */
    private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length() - 1);
            }
        }
        return "";
    }
    public File getFolderUpload() {
        File folderUpload = new File(System.getProperty("user.home") + "/Uploads");
        if (!folderUpload.exists()) {
            folderUpload.mkdirs();
        }
        return folderUpload;
    }

}
