<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<c:url value="/view/static" var="url"></c:url>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${url}/bootrap4/css/bootstrap.min.css">
    <link rel="stylesheet" href="${url}/font awaresome/fontawesome-pro-5.12.0-web/css/all.min.css">
    <link rel="stylesheet" href="${url}/login.css">
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
            <h3>Login</h3>
            <c:if test="${!empty errmessage}">
                <div class="alert alert-danger">${errmessage}</div>
                <c:remove var="errmessage" scope="session" />
            </c:if>
            <c:if test="${!empty succmessage}">
                <div class="alert alert-success">${succmessage}</div>
                <c:remove var="succmessage" scope="session" />
            </c:if>
            <form action="login" method="POST">
                <div class="info d-flex">
                    <div>
                        <div class="username">
                            <input required name="username" type="text" id="username" class="input" autocomplete="off" placeholder="Nhập tên user">
                            <i class="fas fa-user"></i>
                        </div>
                        <div class="password">
                            <input required name="password" type="password" id="password" class="input" autocomplete="off" placeholder="Nhập mật khẩu">
                            <i class="fas fa-key"></i>
                        </div>
                        <div class="submit d-flex">
                            <button type="submit">Đăng nhập</button>

                            <a href="${pageContext.request.contextPath}/register"><button type="button" class="btn-dangky">Đăng ký</button></a>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>