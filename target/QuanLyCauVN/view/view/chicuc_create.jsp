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
<%--    <jsp:include page="/view/layout/meta.jsp"/>--%>
<%--    <title>Document</title>--%>
<%--    <link rel="stylesheet" href="${pageContext.request.contextPath}/view/static/user_index.css">--%>
<%--    <jsp:include page="/view/layout/link.jsp" />--%>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/view/static/chicuc_create.css">
    <jsp:include page="/view/layout/link.jsp"/>
    <!-- <link rel="stylesheet" href="https://s3-us-west-2.amazonaws.com/s.cdpn.io/3/wtf-forms.css"> -->
</head>
<body class="xxx">
    <jsp:include page="/view/layout/menu.jsp"/>
<div id="content" style="transition: margin-left .5s;">
    <div class="container mb-5 parent">
        <div class="mb-4">
            <h2><i class="far fa-edit"></i> Thêm danh sách quản lý cầu</h2>
        </div>
        <form action="" method="POST">
            <div class="form-group">
                <label for="userId">&nbsp; Chi cục / Sở GTVT</label>
                <select name="userId" id="userId" class="form-control" required>
                    <option value="" disabled selected>Chọn chi cục / sở GTVT</option>
                    <c:forEach var="item" items="${userList}">
                        <option value="${item.userId}">${item.soGTVT.ten}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <label for="soThuTu">&nbsp; Tên cầu</label>
                <select name="soThuTu" id="soThuTu" class="form-control" required>
                    <option value="" disabled selected>Chọn tên cầu</option>
                    <c:forEach var="item" items="${cauList}">
                        <option value="${item.soThuTu}">${item.tenCau}</option>
                    </c:forEach>
                </select>
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