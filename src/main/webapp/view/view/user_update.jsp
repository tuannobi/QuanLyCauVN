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
            <h2><i class="far fa-edit"></i> Cập nhật phân quyền</h2>
        </div>
        <form action="" method="POST">
            <input type="hidden" name="userId" value="${user.userId}"/>
            <div class="role form-group">
                <label for="VaiTro">&nbsp; Chọn quyền</label>
                <input type="hidden" name="vaiTro" value="${user.vaiTro.maVaiTro}">
                <select disabled id="VaiTro" class="form-control" required>
                    <option value="" disabled selected>Chọn quyền</option>
                    <c:forEach var="item" items="${vaiTroList}">
                        <option value="${item.maVaiTro}" <c:if test="${user.vaiTro.maVaiTro == item.maVaiTro }">selected</c:if> >${item.loaiVaiTro}</option>
                    </c:forEach>
                </select>
            </div>
            <c:if test="${user.vaiTro.maVaiTro==1}">
                <div>
                    <div class="form-group">
                        <label for="Ten">&nbsp; Tên DRVN</label><br>
                        <input type="text" id="Ten" name="tenDRVN" value='${user.drvn.ten}' autocomplete="off" class="form-control" placeholder="Nhập tên">
                    </div>
                </div>
            </c:if>
           <c:if test="${user.vaiTro.maVaiTro==2}">
               <div>
                   <div class="form-group">
                       <label for="Ten">&nbsp; Tên Sở GTVT</label><br>
                       <input type="text" id="Ten1" name="tenSoGTVT" value='${user.soGTVT.ten}' autocomplete="off" class="form-control" placeholder="Nhập tên">
                   </div>
               </div>
           </c:if>
            <c:if test="${user.vaiTro.maVaiTro==3}">
                <div >
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="hoTen">1. Họ tên</label><br>
                            <input type="text" id="hoTen" placeholder="Nhập họ tên" name="hoTen" value='${user.thongTinNhanVien.hoTen}' autocomplete="off" class="form-control">
                        </div>
                        <div class="form-group col-md-6">
                            <label for="ngaySinh">2. Ngày sinh</label><br>
                            <input type="date" id="ngaySinh" name="ngaySinh" value='${user.thongTinNhanVien.ngaySinh}' autocomplete="off" class="form-control">
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="soDienThoai">3. Số điện thoại</label><br>
                            <input type="number" id="soDienThoai" name="soDienThoai" value='${user.thongTinNhanVien.SDT}' autocomplete="off" class="form-control">
                        </div>
                        <div class="form-group col-md-6">
                            <label for="email">4. Email</label><br>
                            <input type="email" id="email" name="email" value='${user.thongTinNhanVien.email}' autocomplete="off" class="form-control" placeholder="Nhập email">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="diaChi">5. Địa chỉ</label><br>
                        <input type="text" id="diaChi" name="diaChi" value='${user.thongTinNhanVien.diaChi}' autocomplete="off" class="form-control">
                    </div>
                </div>
            </c:if>
            <br>
            <c:if test="${!empty message}">
                <div class="alert alert-danger">Sai mật khẩu cũ</div>
                <c:remove var="message" scope="session" />
            </c:if>
            <label for="">&nbsp; Cập nhật mật khẩu</label><br>
            <label for="check-changePass" class="ml-3">Đổi mật khẩu: &nbsp;</label>
            <input name="check-changePass" type="checkbox" id="check-changePass">
            <div class="form-group col-md-6">
                <label for="oldPassword">Mật khẩu cũ</label><br>
                <input type="password" id="oldPassword" name="oldPassword" value='' autocomplete="off" class="form-control" required disabled="">
            </div>
            <div class="form-group col-md-6">
                <label for="newPassword">Mật khẩu mới</label><br>
                <input type="password" id="newPassword" name="newPassword" value='' autocomplete="off" class="form-control" required disabled="">
            </div>
            <button type="submit" class="btn-submit"><i class="far fa-pencil-alt"></i> Cập nhật</button>
        </form>

    </div>

</div>

<script>
    // var dropdown = document.getElementsByClassName("dropdown-btn");
    // var i;
    // for (i = 0; i < dropdown.length; i++) {
    //     dropdown[i].addEventListener("click", function() {
    //         this.classList.toggle("active");
    //         var dropdownContent = this.nextElementSibling;
    //         if (dropdownContent.style.display === "block") {
    //             dropdownContent.style.display = "none";
    //         } else {
    //             dropdownContent.style.display = "block";
    //         }
    //     });
    // }
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

        // checkbox change password
        $('input[type=checkbox]').change(function(){
            if ($(this).is(":checked")) {
                $('#oldPassword').removeAttr('disabled');
                $('#newPassword').removeAttr('disabled');
            }
            else{
                $('#oldPassword').attr('disabled','');
                $('#newPassword').attr('disabled','');
            }
        });

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
