<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
    <!-- Font Awesome icons (free version)-->
    <script
      src="https://use.fontawesome.com/releases/v6.1.0/js/all.js"
      crossorigin="anonymous"
    ></script>
    <!-- Google fonts-->
    <link
      href="https://fonts.googleapis.com/css?family=Catamaran:100,200,300,400,500,600,700,800,900"
      rel="stylesheet"
    />
    <link
      href="https://fonts.googleapis.com/css?family=Lato:100,100i,300,300i,400,400i,700,700i,900,900i"
      rel="stylesheet"
    />
    <!-- Core theme CSS (includes Bootstrap)-->
    <link href="css/hfmem_before.css" rel="stylesheet" />
    <link href="css/hfmem_after.css" rel="stylesheet" />
    <link href="css/adnotice_before.css" rel="stylesheet" />
    <link href="css/adnotice_after.css" rel="stylesheet" />

    <title>Insert title here</title>
  </head>
  <body id="page-top">
    <!-- Navigation-->
    <div class="container d-flex flex-row justify-content-end welcome">
      <i class="fa-regular fa-bell"></i
      ><span id="welcome">관리자님 환영합니다!</span
      ><a id="logout" href="#">Logout</a>
    </div>
    <nav class="navbar navbar-expand-lg navbar-dark navbar-custom">
      <div class="container px-5">
        <a href="/adminMain"><img src="images/A_logo.png"  id="logo" /></a>
     
        <button
          class="navbar-toggler"
          type="button"
          data-bs-toggle="collapse"
          data-bs-target="#navbarResponsive"
          aria-controls="navbarResponsive"
          aria-expanded="false"
          aria-label="Toggle navigation"
        >
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ms-auto">
         <li class="nav-item">
              <a class="nav-link" href="/market" id="new">회원관리</a></li>
            <li class="nav-item nav-link">|</li>
            <li class="nav-item"><a class="nav-link" href="/board">카테고리관리</a></li>
             <li class="nav-item nav-link">|</li>
            <li class="nav-item"><a class="nav-link" href="/board">신고관리</a></li>
             <li class="nav-item nav-link">|</li>
            <li class="nav-item"><a class="nav-link" href="/adminNotice">공지사항관리</a></li>
             <li class="nav-item nav-link">|</li>
            <li class="nav-item"><a class="nav-link" href="/board">1:1문의</a></li>
             <li class="nav-item nav-link">|</li>
            <li class="nav-item"><a class="nav-link" href="/adminQList">자주묻는질문</a></li>
          </ul>
        </div>
       
      </div>
    </nav>
    
  </body>
</html>
