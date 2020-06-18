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
<c:url value="/view/static" var="url"></c:url>
<!DOCTYPE html>
<html lang="en">
<head>
<%--    <jsp:include page="/view/layout/meta.jsp"/>--%>
<%--    <title>Document</title>--%>
<%--    <link rel="stylesheet" href="${pageContext.request.contextPath}/view/static/user_index.css">--%>
<%--    <jsp:include page="/view/layout/link.jsp" />--%>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Prohibit</title>
    <!-- <link rel="stylesheet" href="https://s3-us-west-2.amazonaws.com/s.cdpn.io/3/wtf-forms.css"> -->
</head>
<body class="xxx">
<div id="content" style="transition: margin-left .5s;">
    <h1>Quyền của bạn là ${sessionScope.user.vaiTro.loaiVaiTro}</h1>
    <h1>Không có quyền truy cập trang này</h1>
</div>

</body>
</html>