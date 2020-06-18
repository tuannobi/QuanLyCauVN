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
                <td>Tên chủ đầu tư</td>
                <td>${chuDauTu.tenChuDauTu}</td>
            </tr>
            <tr>
                <td>Ngày sinh</td>
                <td>${chuDauTu.ngaySinh}</td>
            </tr>
            <tr>
                <td>Địa chỉ</td>
                <td>${chuDauTu.diaChi}</td>
            </tr>
            <tr>
                <td>Số điện thoại</td>
                <td>${chuDauTu.SDT}</td>
            </tr>
            <tr>
                <td>Email</td>
                <td>${chuDauTu.email}</td>
            </tr>
            </tbody>
        </table>

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

</script>
</body>
</html>
