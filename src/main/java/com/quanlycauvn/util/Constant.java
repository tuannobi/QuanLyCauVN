package com.quanlycauvn.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Constant {
    public static class Path{
        public static final String urlLOGIN="/view/view/login.jsp";
        public static final String urlRoleIndex="/view/view/user_index.jsp";
        public static final String urlRegisterIndex="/view/view/register.jsp";

        public static final String urlUserIndex="/view/view/user_index.jsp";
        public static final String urlUserCreate="/view/view/user_create.jsp";
        public static final String urlUserEdit="/view/view/user_update.jsp";

        public static final String urlChiCucIndex="/view/view/chicuc_index.jsp";
        public static final String urlChiCucCreate="/view/view/chicuc_create.jsp";
        public static final String urlChicucEdit="/view/view/chicuc_update.jsp";

        public static final String urlCauIndex="/view/view/cau_index.jsp";
        public static final String urlCauCreate="/view/view/cau_create.jsp";
        public static final String urlCauEdit="/view/view/cau_update.jsp";
        public static final String urlCauDetail="/view/view/cau_detail.jsp";

        public static final String urlCauGTVTIndex="/view/view/cau_bogtvt_index.jsp";
        public static final String urlCauGTVTEdit="/view/view/cau_bogtvt_update.jsp";
        public static final String urlCauGTVTDetail="/view/view/cau_bogtvt_detail.jsp";

        public static final String urlChartTinhTrangCau="/view/view/tinhtrangcau_chart.jsp";

        public static final String urlProhibit="/view/view/prohibit.jsp";
        public static final String urlCauNhanVienDetail="/view/view/cau_nhanvien_detail.jsp";
        public static final String urlCauNhanVienIndex="/view/view/cau_nhanvien_index.jsp";

        public static final String urlChuDauTuIndex="/view/view/chudautu_index.jsp";
        public static final String urlChuDauTuEdit="/view/view/chudautu_update.jsp";
        public static final String urlChuDauTuCreate="/view/view/chudautu_create.jsp";
        public static final String urlChuDauTuDetail="/view/view/chudautu_detail.jsp";
    }

    public static class ArrayList{
        public static final List<String> taiTrongThietKeList= new java.util.ArrayList<>(Arrays.asList(
                "Tải trọng 1",
                "Tải trọng 2",
                "Tải trọng 3"
        ));
        public static final List<String> donViThietKeList= new java.util.ArrayList<>(Arrays.asList(
                "Đơn vị thiết kế 1",
                "Đon  vị thiết kế 2",
                "Đơn vị thiết kế 3"
        ));
        public static final List<String> donViThiCongList= new java.util.ArrayList<>(Arrays.asList(
                "Đơn vị thi công 1",
                "Đon vị thi công 2",
                "Đon vị thi công 3"
        ));
        public static final List<String> donViGiamSatList= new java.util.ArrayList<>(Arrays.asList(
                "Đơn vị giám sát 1",
                "Đơn vị giám sát 2",
                "Đơn vị giám sát 3"
        ));
        public static final List<String> donViQuanLyList= new java.util.ArrayList<>(Arrays.asList(
                "Đơn vị quản lý 1",
                "Đơn vị quản lý 2",
                "Đơn vị quản lý 3"
        ));
        public static final List<String> quocLoList= new java.util.ArrayList<>(Arrays.asList(
                "Quốc lộ 1",
                "Quốc lộ 2",
                "Quốc lộ 3"
        ));
        public static final List<String> tinhTrangCauList= new java.util.ArrayList<>(Arrays.asList(
                "Cầu rất yếu",
                "Cầu yếu",
                "Cầu bình thường"
        ));
    }

    public static class NameFile{
        public static final String tempExportFileName="Exportdata.xlsx";
        public static final String tempImportFileName="Importdata.xlsx";
    }
}
