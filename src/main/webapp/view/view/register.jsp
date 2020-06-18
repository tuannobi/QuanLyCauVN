<%--
  Created by IntelliJ IDEA.
  User: Tuan
  Date: 6/10/2020
  Time: 4:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/view/static" var="url"></c:url>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${url}/bootrap4/css/bootstrap.min.css">
    <link rel="stylesheet" href="${url}/font awaresome/fontawesome-pro-5.12.0-web/css/all.min.css">
    <link rel="stylesheet" href="${url}/register.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <title>Login</title>
</head>
<body>
<div class="cover">
    <div class="form d-flex">
        <div>
            <div class="cover-icon">
                <div class="icon d-flex">
                    <i class="fas fa-user-alt"></i>
                </div>
            </div>
            <h3>Register</h3>

            <form action="register" method="POST">
                <div class="role">
                    <select name="vaiTro" id="VaiTro" class="form-control" required>
                        <option value="" disabled selected>Chọn quyền</option>
                        <c:forEach var="item" items="${vaiTroList}">
                            <option value="${item.maVaiTro}">${item.loaiVaiTro}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-DRVN">
                    <div class="form-group">
                        <label for="tenDRVN">Tên DRVN</label><br>
                        <input type="text" id="tenDRVN" name="tenDRVN" value='' autocomplete="off" class="form-control" placeholder="Nhập tên">
                    </div>
                </div>
                <div class="form-SoGTVT">
                    <div class="form-group">
                        <label for="tenSoGTVT">Tên Sở GTVT</label><br>
                        <input type="text" id="tenSoGTVT" name="tenSoGTVT" value='' autocomplete="off" class="form-control" placeholder="Nhập tên">
                    </div>
                </div>
                <div class="form-nhanvien">
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="hoTen">Họ tên</label><br>
                            <input type="text" id="hoTen" placeholder="Nhập họ tên" name="hoTen" value='' autocomplete="off" class="form-control">
                        </div>
                        <div class="form-group col-md-6">
                            <label for="ngaySinh">Ngày sinh</label><br>
                            <input type="date" id="ngaySinh" name="ngaySinh" value='' autocomplete="off" class="form-control">
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="soDienThoai">Số điện thoại</label><br>
                            <input type="number" id="soDienThoai" name="soDienThoai" value='' autocomplete="off" class="form-control">
                        </div>
                        <div class="form-group col-md-6">
                            <label for="email">Email</label><br>
                            <input type="Email" id="email" name="email" value='' autocomplete="off" class="form-control" placeholder="Nhập email">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="diaChi">Địa chỉ</label><br>
                        <input type="text" id="diaChi" name="diaChi" value='' autocomplete="off" class="form-control">
                    </div>
                </div>
                <div class="info d-flex">
                    <div>
                        <div class="username">
                            <input name="username" type="text" id="username" class="input" autocomplete="off" placeholder="Nhập tên user" required>
                            <i class="fas fa-user"></i>
                        </div>
                        <div class="password">
                            <input name="password" type="password" id="password" class="input" autocomplete="off" placeholder="Nhập mật khẩu" required>
                            <i class="fas fa-key"></i>
                        </div>
                        <div class="submit d-flex">
                            <button type="submit" class="btn-dangky">Tạo tài khoản</button>
                        </div>
                    </div>
                </div>

            </form>
        </div>
    </div>
</div>
<script>
    $(document).ready(function(){
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