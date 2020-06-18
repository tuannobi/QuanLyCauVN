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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/view/static/cau_create.css">

</head>
<body class="xxx">
<jsp:include page="/view/layout/menu.jsp"/>
<div id="content" style="transition: margin-left .5s;">
    <div id="content" style="transition: margin-left .5s;">
        <!-- add content -->
        <div class="container mb-5 parent">
            <div class="mb-4">
                <h2><i class="far fa-edit"></i> Thêm danh sách cầu</h2>
            </div>
            <form action="" method="POST">
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="tenCau">1. Tên cầu</label><br>
                        <input type="text" id="tenCau" placeholder="Nhập tên cầu" name="tenCau" value='' autocomplete="off" class="form-control" required>
                    </div>
                    <div class="form-group col-md-6">
                        <label for="tongMucDauTu">2. Tổng mức đầu tư</label><br>
                        <input type="number" id="tongMucDauTu" name="tongMucDauTu" value='' autocomplete="off" class="form-control" required>
                    </div>
                </div>

                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="taiTrongThietKe">3. Tải trọng thiết kế</label><br>
                        <select name="taiTrongThietKe" id="taiTrongThietKe" class="form-control" required>
                            <option disabled value="">Chọn tải trọng thiết kế</option>
                            <c:forEach var="item" items="${taiTrongThietKeList}">
                                <option value="${item}">${item}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group col-md-6">
                        <label for="donViThietKe">4. Đơn vị thiết kế</label><br>
                        <select name="donViThietKe" id="donViThietKe" class="form-control" required>
                            <option value="" disabled selected>Chọn đơn vị thiết kế</option>
                            <c:forEach var="item" items="${donViThietKeList}">
                                <option value="${item}">${item}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="donViThiCong">5. Đơn vị thi công</label><br>
                        <select name="donViThiCong" id="donViThiCong" class="form-control" required>
                            <option value="" disabled selected>Chọn đơn vị thi công</option>
                            <c:forEach var="item" items="${donViThiCongList}">
                                <option value="${item}">${item}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group col-md-6">
                        <label for="donViGiamSat">6. Đơn vị giám sát</label><br>
                        <select name="donViGiamSat" id="donViGiamSat" class="form-control" required>
                            <option value="" disabled selected>Chọn đơn vị giám sát</option>
                            <c:forEach var="item" items="${donViGiamSatList}">
                                <option value="${item}">${item}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="donViQuanLy">7. Đơn vị quản lý</label><br>
                        <select name="donViQuanLy" id="donViQuanLy" class="form-control" required>
                            <option value="" disabled selected>Chọn đơn vị quản lý</option><br>
                            <c:forEach var="item" items="${donViQuanLyList}">
                                <option value="${item}">${item}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group col-md-6">
                        <label for="quocLo">8. Quốc lộ</label>
                        <select name="quocLo" id="quocLo" class="form-control" required>
                            <option value="" disabled selected>Chọn quốc lộ</option>
                            <c:forEach var="item" items="${quocLoList}">
                                <option value="${item}">${item}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-4">
                        <label for="namXayDung">9. Năm xây dựng</label><br>
                        <input type="number" id="namXayDung" name="namXayDung" value='' class="form-control" required>
                    </div>
                    <div class="form-group col-md-4">
                        <label for="namHoanThanh">10. Năm hoàn thành</label><br>
                        <input type="number" id="namHoanThanh" name="namHoanThanh" value='' class="form-control" required>
                    </div>
                    <div class="form-group col-md-4">
                        <label for="namDuaVaoKhaiThac">11. Năm đưa vào khai thác</label><br>
                        <input type="number" id="namDuaVaoKhaiThac" name="namDuaVaoKhaiThac" value='' class="form-control" required>
                    </div>
                </div>
                <label>12. Vị trí xây dựng</label>
                <div class="form-row">
                    <div class="form-group col-md-4">
                        <label for="Tinh">Tỉnh</label>
                        <select name="tinh" id="Tinh" class="form-control" required>
                            <option value="" disabled selected>Chọn  tỉnh</option>
                            <c:forEach var="item" items="${tinhList}">
                                <option value="${item.matp}">${item.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group col-md-4">
                        <label for="Quan">Quận, huyện</label>
                        <select name="quan" id="Quan" class="form-control" required>
                            <option value="" disabled selected>Chọn  quận, huyện</option>
                        </select>
                    </div>
                    <div class="form-group col-md-4">
                        <label for="Xa">Xã, phường</label>
                        <select name="xa" id="Xa" class="form-control" required>
                            <option value="" disabled selected>Chọn  xã, phường</option>
                        </select>
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-4">
                        <label for="maChuDauTu">13. Chủ đầu tư</label>
                        <select name="maChuDauTu" id="maChuDauTu" class="form-control" required>
                            <option value="" disabled selected>Chọn chủ đầu tư</option>
                            <c:forEach var="item" items="${chuDauTuList}">
                                <option value="${item.maChuDauTu}">${item.maChuDauTu} + ${item.tenChuDauTu}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-4">
                        <label for="tinhTrangCau">14. Tình trạng cầu</label>
                        <select name="tinhTrangCau" id="tinhTrangCau" class="form-control" required>
                            <option value="" disabled selected>Chọn tình trạng cầu</option>
                            <c:forEach var="item" items="${tinhTrangCauList}">
                                <option value="${item}">${item}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <button type="submit" class="btn-submit"><i class="far fa-plus-circle"></i> Thêm</button>
            </form>

        </div>
    </div>

</div>

<script>

    $(document).on("change","#Tinh",(event)=>{
        let idTinh = $("#Tinh").val();
        $("#Quan").children().remove();
        $.ajax({
            type:"GET",
            url:"/QuanLyCauVN_war/getHuyenAjax?id="+idTinh,
            data:{id:idTinh},
            success:function(data){
                $("#Quan").append(
                    "<option value='' disabled selected>Chọn  quận, huyện</option>"
                );
                $.each(data,function(key,value){
                    $("#Quan").append(
                        "<option value='"+key+"'>"+value+"</option>"
                    );
                })
            },
            error:function(err){
                alert(err);
            }
        });
    });

    $(document).on("change","#Quan",(event)=>{
        let idQuan = $("#Quan").val();
        $("#Xa").children().remove();
        $.ajax({
            type:"GET",
            url:"/QuanLyCauVN_war/getXaAjax?id="+idQuan,
            data:{id:idQuan},
            success:function(data){
                $("#Xa").append(
                    "<option value='' disabled selected>Chọn  xã, phường</option>"
                );
                $.each(data,function(key,value){
                    $("#Xa").append(
                        "<option value='"+key+"'>"+value+"</option>"
                    );
                })
            },
            error:function(err){
                alert(err);
            }
        });
    });

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
    });
</script>
</body>
</html>
