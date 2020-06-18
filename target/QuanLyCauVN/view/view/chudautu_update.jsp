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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/view/static/user_update.css">

</head>
<body class="xxx">
<jsp:include page="/view/layout/menu.jsp"/>
<div id="content" style="transition: margin-left .5s;">

    <div class="container mb-5 parent">
        <div class="mb-4">
            <h2><i class="far fa-edit"></i> Thêm thông tin chủ đầu tư</h2>
        </div>
        <form action="" method="POST">
            <input type="hidden" name="maChuDauTu" value="${chuDauTu.maChuDauTu}"/>
            <div>
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="hoTen">1. Họ tên</label><br>
                        <input type="text" id="hoTen" placeholder="Nhập họ tên" name="tenChuDauTu" value='${chuDauTu.tenChuDauTu}' autocomplete="off" class="form-control" required>
                    </div>
                    <div class="form-group col-md-6">
                        <label for="ngaySinh">2. Ngày sinh</label><br>
                        <input type="date" id="ngaySinh" name="ngaySinh" value='${chuDauTu.ngaySinh}' autocomplete="off" class="form-control" required>
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="soDienThoai">3. Số điện thoại</label><br>
                        <input type="number" id="soDienThoai" name="soDienThoai" value='${chuDauTu.SDT}' autocomplete="off" class="form-control" required>
                    </div>
                    <div class="form-group col-md-6">
                        <label for="email">4. Email</label><br>
                        <input type="email" id="email" name="email" value='${chuDauTu.email}' autocomplete="off" class="form-control" placeholder="Nhập email" required>
                    </div>
                </div>
                <div class="form-group">
                    <label for="diaChi">5. Địa chỉ</label><br>
                    <input type="text" id="diaChi" name="diaChi" value='${chuDauTu.diaChi}' autocomplete="off" class="form-control" required>
                </div>
            </div>
            <button type="submit" class="btn-submit"><i class="far fa-plus-circle"></i> Thêm</button>
        </form>

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
