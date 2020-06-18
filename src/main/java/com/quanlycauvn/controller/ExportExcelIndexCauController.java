package com.quanlycauvn.controller;

import com.quanlycauvn.util.AdvancedDb2ExcelExporter;
import com.quanlycauvn.util.Constant;
import com.quanlycauvn.util.ExcelExporterFromMySql;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

@WebServlet("/bridge/exportExcel")
public class ExportExcelIndexCauController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ExcelExporterFromMySql excelExporterFromMySql=new ExcelExporterFromMySql();
        excelExporterFromMySql.export("cau");

        String fileName = this.getFolderDownload().getAbsolutePath() + File.separator+ Constant.NameFile.tempExportFileName;
        System.out.println(fileName);
        String fileType = "text/xlsx";
        // Find this file id in database to get file name, and file type

        // You must tell the browser the file type you are going to send
        // for example application/pdf, text/plain, text/html, image/jpg
        resp.setContentType(fileType);

        // Make sure to show the download dialog
        resp.setHeader("Content-disposition","attachment; filename="+Constant.NameFile.tempExportFileName);

        // Assume file name is retrieved from database
        // For example D:\\file\\test.pdf

        File my_file = new File(fileName);

        // This should send the file to browser
        OutputStream out = resp.getOutputStream();
        FileInputStream in = new FileInputStream(my_file);
        byte[] buffer = new byte[4096];
        int length;
        while ((length = in.read(buffer)) > 0){
            out.write(buffer, 0, length);
        }
        in.close();
        out.flush();
    }

    public File getFolderDownload() {
        File folderUpload = new File(System.getProperty("user.home") + "/Uploads");
        if (!folderUpload.exists()) {
            folderUpload.mkdirs();
        }
        return folderUpload;
    }
}
