<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="/docs/4.0/assets/img/favicons/favicon.ico">
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/product.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/board.js"></script>
    <title>JSP&Servlet MiniProject</title>
    <link rel="canonical" href="https://getbootstrap.com/docs/4.0/examples/jumbotron/">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/shopping.css?after">
    <link href="<%=request.getContextPath()%>/bootstrap/css/bootstrap.css" rel="stylesheet">
  </head>

  <body>

    <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
      <a class="navbar-brand" href="#">Navbar</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>

      <div class="collapse navbar-collapse" id="navbarsExampleDefault">
        <ul class="navbar-nav mr-auto">
          <li class="nav-item active">
            <a class="nav-link" href="../hello.do">Home <span class="sr-only">(current)</span></a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="/member/edit.do?userid=${loginUser.userid}">Edit Profile</a>
          </li>
          <c:choose>
          	<c:when test="${loginUser.userid == null }">          
          		<li class="nav-item">
          			<a class="nav-link" href="/member/login.do">Login</a>
          		</li>
          	</c:when>
          	<c:when test="${loginUser.userid != null }">          
          		<li class="nav-item">
          			<a class="nav-link" href="/member/logOut.do">Logout</a>
          		</li>
          	</c:when>
          
          </c:choose>
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="http://example.com" id="dropdown01" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Dropdown</a>
            <div class="dropdown-menu" aria-labelledby="dropdown01">
              <a class="dropdown-item" href="">MEMBER</a>
              <a class="dropdown-item" href="/product/list.do">PRODUCT</a>
              <a class="dropdown-item" href="/board/list.do">BOARD</a>
            </div>
          </li>
        </ul>
        <ul class="navbar-nav mr-auto" style="margin-left: 600px;">
          <c:choose>
          	<c:when test="${loginUser.userid == null }">
          		<li class="nav-item" style="text-align: left;">
          			안녕하세요, 방문자님
          		</li>          	
          	</c:when>
          	<c:when test="${loginUser.userid != null }">
          		<li class="nav-item" style="text-align: left;">
          			안녕하세요, ${loginUser.name}(${loginUser.userid})님
          		</li>          	
          	</c:when>
          </c:choose>
         </ul>
      </div>
    </nav>

    <main role="main" style="margin-top: 100px; margin-bottom: 120px">