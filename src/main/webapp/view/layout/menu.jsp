    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ page language="java" contentType="text/html; charset=UTF-8"
             pageEncoding="UTF-8"%>
    <div id="mySidebar" class="sidebar">
    <div class="box">
        <c:if test="${sessionScope.user.vaiTro.maVaiTro==1}">
            <a href="${pageContext.request.contextPath}/user" class="menu"> Quản lý phân quyền</a>
            <a href="${pageContext.request.contextPath}/bridge" class="menu"> Quản lý toàn bộ cầu</a>
            <a href="${pageContext.request.contextPath}/chicuc" class="menu"> Phân bổ cho các chi cục/ Sở GTVT</a>
            <a href="${pageContext.request.contextPath}/chart/tinhtrangcau" class="menu"> Thống kê theo tình trạng cầu</a>
        </c:if>
        <c:if test="${sessionScope.user.vaiTro.maVaiTro==2}">
            <a href="${pageContext.request.contextPath}/bogtvt" class="menu"> Quản lý cầu</a>
        </c:if>
        <c:if test="${sessionScope.user.vaiTro.maVaiTro==3}">
<%--            <a href="#" class="menu"> Quản lý chủ đầu tư</a>--%>
            <a href="${pageContext.request.contextPath}/nhanvien" class="menu">Xem thông tin cầu</a>
        </c:if>
        <c:if test="${sessionScope.user.vaiTro.maVaiTro==1 || sessionScope.user.vaiTro.maVaiTro==2}">
            <a href="${pageContext.request.contextPath}/chudautu" class="menu">Quản lý chủ đầu tư</a>
        </c:if>
    </div>
    </div>
    <div class="header">
    <div class="noidung">
    <i class="far fa-users-cog"></i>
    <h3>Quản lý cầu</h3>
    <div class="cover-ul">
    <ul class="ul1">
    <li class="username">
    <a href="">Xin chào ${sessionScope.user.username}</a>
    <ul class="submenu">
<%--    <li><a href="">Thông tin cá nhân</a></li>--%>
    <li><a href="${pageContext.request.contextPath}/logout">Đăng xuất</a></li>
    </ul>
    </li>
    </ul>
    </div>
    </div>
    </div>

    <div id="main" style="position: fixed;top: 0">
    <button class="openbtn"><i class="fas fa-align-left"></i></button>
    </div>
