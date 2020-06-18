<%--
  Created by IntelliJ IDEA.
  User: Tuan
  Date: 6/12/2020
  Time: 3:31 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="/view/layout/meta.jsp"/>
    <title>Document</title>
    <jsp:include page="/view/layout/link.jsp" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/view/static/cau_detail.css">
    <script src="https://polyfill.io/v3/polyfill.min.js?features=default"></script>
    <script src="http://maps.googleapis.com/maps/api/js?key=\#{your_app_key}&sensor=false"></script>
</head>
<body class="xxx">
<jsp:include page="/view/layout/menu.jsp"/>
<div id="content" style="transition: margin-left .5s;">
    <div class="container mb-5 parent">
        <div class="mb-4">
            <h2><i class="far fa-edit"></i> Thông tin chi tiết</h2>
        </div>
        <table class="table table-sm table-bordered table-striped table-hover">
            <thead>
            <tr>
                <th>Danh mục</th>
                <th id="col-inf">Thông tin</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>Tên cầu</td>
                <td>${cau.tenCau}</td>
            </tr>
            <tr>
                <td>Tổng mức đầu tư</td>
                <td>${cau.tongMucDauTu}</td>
            </tr>
            <tr>
                <td>Tải trọng thiết kế</td>
                <td>${cau.taiTrongThietKe}</td>
            </tr>
            <tr>
                <td>Đơn vị thiết kế</td>
                <td>${cau.donViThietKe}</td>
            </tr>
            <tr>
                <td>Đơn vị thi công</td>
                <td>${cau.donViThiCong}</td>
            </tr>
            <tr>
                <td>Đơn vị tư vấn giám sát</td>
                <td>${cau.donViGiamSat}</td>
            </tr>
            <tr>
                <td>Đơn vị quản lý</td>
                <td>${cau.donViQuanLy}</td>
            </tr>
            <tr>
                <td>Chủ đầu tư</td>
                <td>${cau.chuDauTu.tenChuDauTu}<a href=""></a></td>
            </tr>
            <tr>
                <td>Tình trạng</td>
                <td>${cau.tinhTrangCau}</td>
            </tr>
            <tr>
                <td>Năm xây dựng</td>
                <td>${cau.namXayDung}</td>
            </tr>
            <tr>
                <td>Năm hoàn thành</td>
                <td>${cau.namHoanThanh}</td>
            </tr>
            <tr>
                <td>Năm đưa vào khai thác</td>
                <td>${cau.namDuaVaoKhaiThac}</td>
            </tr>
            <tr>
                <td colspan="2">Vị trí xây dựng</td>
            </tr>
            <tr>
                <td>Tỉnh</td>
                <td>${cau.tinhThanhPho.name}</td>
            </tr>
            <tr>
                <td>Quận, huyện</td>
                <td>${cau.quanHuyen.name}</td>
            </tr>
            <tr>
                <td>Xã, phường</td>
                <td>${cau.xaPhuongThiTran.name}</td>
            </tr>
            <tr>
                <td>Quốc lộ</td>
                <td>${cau.quocLo}</td>
            </tr>
            <tr>
                <td>Ngày tạo</td>
                <td>${cau.ngayTao}</td>
            </tr>
            <tr>
                <td>${cau.ngayCapNhat}</td>
                <td></td>
            </tr>
            <tr>
                <td>Vị trí bản đồ</td>
                <td><input type="checkbox" id="js-checkbox">&nbsp; Hiển thị</td>
            </tr>
            </tbody>
        </table>
        <div id="map" style="width:100%;height:400px;display:none;">

        </div>
    </div>
</div>

<script>
    var dropdown = document.getElementsByClassName("dropdown-btn");
    var i;
    for (i = 0; i < dropdown.length; i++) {
        dropdown[i].addEventListener("click", function() {
            this.classList.toggle("active");
            var dropdownContent = this.nextElementSibling;
            if (dropdownContent.style.display === "block") {
                dropdownContent.style.display = "none";
            } else {
                dropdownContent.style.display = "block";
            }
        });
    }
    $(document).ready(function(){
        let i =0;
        $(".openbtn").click(function(){
            if(i===1){
                $("#mySidebar").css('width','250px');
                $("#main,#content").css('margin-left',"250px");
                i=0;
            }
            else{
                $("#mySidebar").css('width','0');
                $("#main,#content").css('margin-left',"0");
                i=1;
            }
        });
    });
    $('#js-checkbox').change(()=>{
        if($("#js-checkbox").is(':checked')){
            $("#map").css("display","block");
        }
        else{
            $("#map").css("display","none");
        }
    });
    //Khoi tao Map
    function initialize() {
        //Khai bao cac thuoc tinh
        var mapProp = {
            //Tam ban do, quy dinh boi kinh do va vi do
            center:new google.maps.LatLng(51.508742, -0.120850),
            //set default zoom cua ban do khi duoc load
            zoom:10,
            //Dinh nghia type
            mapTypeId:google.maps.MapTypeId.ROADMAP
        };
        //Truyen tham so cho cac thuoc tinh Map cho the div chua Map
        var map=new google.maps.Map(document.getElementById("map"), mapProp);

        var marker = new google.maps.Marker({
            position:{lat: 51.508742,lng:-0.120850},
            map:map,
            title:'hello'
        });

    }
    google.maps.event.addDomListener(window, 'load', initialize);


</script>
</body>
</html>
