<%--
  Created by IntelliJ IDEA.
  User: Tuan
  Date: 6/11/2020
  Time: 2:36 AM
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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/view/static/cau_index.css">
</head>
<body class="xxx">
    <jsp:include page="/view/layout/menu.jsp"/>
<div id="content" style="transition: margin-left .5s;">
    <div class="table1 container">
        <c:if test="${!empty errmessage}">
            <div class="alert alert-danger">${errmessage}</div>
            <c:remove var="errmessage" scope="session" />
        </c:if>
        <c:if test="${!empty succmessage}">
            <div class="alert alert-success">${succmessage}</div>
            <c:remove var="succmessage" scope="session" />
        </c:if>
<%--        <button type="button" onclick="window.location.href='bogtvt/create'; return false;" class="btn btn-success btn-add"><i class="fal fa-plus-circle"></i> Thêm</button>--%>
<%--    <div class="d-flex">--%>
        <form name="myForm" method="post" action="bogtvt/import" enctype="multipart/form-data">
            <label class="btn btn-info x">
                Import <input onchange="myForm.submit();" type="file" hidden name="file" size="60" />
            </label>
        </form>
        <button type="button" onclick="window.location.href='bogtvt/exportExcel'; return false;" class="btn btn-primary btn-add text-white"><i class="fad fa-file-export"></i> Xuất Excel</button>
<%--    </div>--%>

        <table id="verticalScroll" class="table table-sm table-bordered table-striped table-hover">
            <thead>
            <tr>
                <th scope="col">STT</th>
                <th scope="col">Tên cầu</th>
                <th scope="col">Năm xây dựng</th>
                <th scope="col">Năm hoàn thành</th>
                <th scope="col">Đơn vị quản lý</th>
                <th scope="col">Quốc lộ</th>
                <th scope="col">Tình trạng</th>
                <th scope="col">Ngày cập nhật</th>
                <th scope="col">Xem chi tiết</th>
                <th scope="col">Sửa</th>
            </tr>
            </thead>
            <tbody>
                    <c:forEach var="item" items="${cauList}">
                        <c:url var="updateLink" value="bogtvt/update">
                            <c:param name="id" value="${item.soThuTu}" />
                        </c:url>
                        <c:url var="detailLink" value="bogtvt/detail">
                            <c:param name="id" value="${item.soThuTu}" />
                        </c:url>
                        <tr>
                            <td class="align-center">${item.soThuTu}</td>
                            <td id="tenCau">${item.tenCau}</td>
                            <td class="align-center">${item.namXayDung}</td>
                            <td class="align-center">${item.namHoanThanh}</td>
                            <td id="donViQuanLy">${item.donViQuanLy}</td>
                            <td id="quocLo">${item.quocLo}</td>
                            <td class="align-center">${item.tinhTrangCau}</td>
                            <td class="align-center">${item.ngayCapNhat}</td>
                            <td class="align-center"><a href="${detailLink}" class="detail">Chi tiết</a></td>
                            <td class="align-center"><a href="${updateLink}"><i class="fad fa-edit"></i></a></td>
<%--                            <td class="delete align-center" id="xoa"><i class="fal fa-times"></i></td>--%>
<%--                            <td class="align-center"><i class="fal fa-times delete" id="${item.soThuTu}"></i></td>--%>
                        </tr>
                    </c:forEach>
            <!-- add row table -->
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
        $(document).ready(function () {
            $('#verticalScroll').DataTable({
                "scrollY": "380px",
                "scrollCollapse": true
            });
            $('.dataTables_length').addClass('bs-select');
        });


        $(document).on("click",".delete",(event)=>{
            let id = event.target.id;
            $('.xxx').append("<div id='over' style='display:none;width:100%;height:300%;background:#342e2e;position:absolute;top:0;left:0;opacity:0.6;z-index:999999' onclick=clickCloseDialog()></div>");
            $("#content").append("<div class='dialog' style='width: 500px;display: none;position: fixed;overflow: hidden;top: 20%;left: 55%;margin-left: -300px;z-index: 99999999;background-color: #fff;padding-bottom: 15px;'>\
                <div style='padding: 10px;text-transform: uppercase;background-color: tomato;color: #FFF;font-weight:bold;font-size:18px'>\
                <span><i class='fas fa-exclamation-triangle'></i> Warning</span>\
                </div>\
                <p>Bạn xác nhận muốn xóa?</p>\
                <div style='display:flex;justify-content: space-evenly;'>\
                    <a href='bridge/delete?id="+id+"'><button type='button' class='btn btn-secondary' onclick=clickCloseDialog()>Có</button></a>\
                    <a href=''><button type='button' class='btn btn-secondary' onclick=clickCloseDialog()>Không</button></a>\
                    </div>\
                    </div>");
            $('#over').fadeIn(300);
            $('.dialog').fadeIn(300,function(){
                $('.dialog').css('visibility','visible');
            });
        });

        function clickCloseDialog(){
            $('#over, .dialog').fadeOut(300 , function() {
                $('.dialog').css('visibility','hidden');
                $('body').css('overflow','visible');
            });
            $('#over, .dialog').remove();
        }



    </script>
</body>
</html>