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
<c:url value="/view/static" var="url"></c:url>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="/view/layout/meta.jsp"/>
    <title>Document</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/view/static/user_create.css">
    <jsp:include page="/view/layout/link.jsp" />

</head>
<body class="xxx">
<jsp:include page="/view/layout/menu.jsp"/>
<div id="content" style="transition: margin-left .5s;">
    <div id="content" style="transition: margin-left .5s;">
        <!-- add content -->
        <div class="container mb-5 parent">
            <div class="mb-4">
                <h2><i class="far fa-edit"></i> Thêm thông tin phân quyền</h2>
            </div>
            <form action="" method="POST">
                <div class="role form-group">
                    <label for="VaiTro">&nbsp; Chọn quyền</label>
                    <select name="vaiTro" id="VaiTro" class="form-control" required>
                        <option value="" disabled selected>Chọn quyền</option>
                        <c:forEach var="vaiTro" items="${vaiTroList}">
                            <option value="<c:out value="${vaiTro.maVaiTro}"/>"><c:out value="${vaiTro.loaiVaiTro}"/></option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-DRVN mt-3">
                    <div class="form-group">
                        <label for="Ten">&nbsp; Tên DRVN</label><br>
                        <input type="text" id="Ten" name="tenDRVN" value='' autocomplete="off" class="form-control" placeholder="Nhập tên">
                    </div>
                </div>
                <div class="form-SoGTVT mt-3">
                    <div class="form-group">
                        <label for="Ten">&nbsp; Tên Sở GTVT</label><br>
                        <input type="text" id="Ten1" name="tenSoGTVT" value='' autocomplete="off" class="form-control" placeholder="Nhập tên">
                    </div>
                </div>
                <div class="form-nhanvien">
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="hoTen">1. Họ tên</label><br>
                            <input type="text" id="hoTen" placeholder="Nhập họ tên" name="hoTen" value='' autocomplete="off" class="form-control">
                        </div>
                        <div class="form-group col-md-6">
                            <label for="ngaySinh">2. Ngày sinh</label><br>
                            <input type="date" id="ngaySinh" name="ngaySinh" value='' autocomplete="off" class="form-control">
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="soDienThoai">3. Số điện thoại</label><br>
                            <input type="number" id="soDienThoai" name="soDienThoai" value='' autocomplete="off" class="form-control">
                        </div>
                        <div class="form-group col-md-6">
                            <label for="email">4. Email</label><br>
                            <input type="email" id="email" name="email" value='' autocomplete="off" class="form-control" placeholder="Nhập email">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="diaChi">5. Địa chỉ</label><br>
                        <input type="text" id="diaChi" name="diaChi" value='' autocomplete="off" class="form-control">
                    </div>
                </div>
                <!-- <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="VaiTro">6. Vai trò</label><br>
                        <select name="VaiTro" id="VaiTro" class="form-control" required>
                            <option value="" disabled selected>Chọn vai trò</option>
                        </select>
                    </div>
                </div> -->
                <br>
                <label for="">&nbsp; Tạo tài khoản</label>
                <div class="form-group col-md-6">
                    <label for="username">Username</label><br>
                    <input type="text" id="username" name="username" value='' autocomplete="off" class="form-control" required>
                </div>
                <div class="form-group col-md-6">
                    <label for="password">Password</label><br>
                    <input type="password" id="password" name="password" value='' autocomplete="off" class="form-control" required>
                </div>
                <button type="submit" class="btn-submit"><i class="far fa-plus-circle"></i> Thêm</button>
            </form>

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
    $(document).ready(function () {
        $('#verticalScroll').DataTable({
            "scrollY": "380px",
            "scrollCollapse": true
        });
        $('.dataTables_length').addClass('bs-select');

        $("#VaiTro").change(function(){
            let value = $("#VaiTro").val();
            if(value==1){
                $(".form-DRVN").css("display","block");
                $(".form-SoGTVT").css("display","none");
                $(".form-nhanvien").css("display","none");
            }
            if(value==2){
                $(".form-DRVN").css("display","none");
                $(".form-SoGTVT").css("display","block");
                $(".form-nhanvien").css("display","none");
            }
            if(value==3){
                $(".form-DRVN").css("display","none");
                $(".form-SoGTVT").css("display","none");
                $(".form-nhanvien").css("display","block");
            }
        });
    });
</script>
</body>
</html>
