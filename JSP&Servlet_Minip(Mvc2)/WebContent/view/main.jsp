<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

  <body>
	
	<jsp:include page="/view/common/header.jsp"></jsp:include>

      <div class="jumbotron">
        <div class="container">
          <c:choose>
          	<c:when test="${loginUser == null }">
          		<h2 class="display-3">안녕하세요, 방문자님!</h2>
          	</c:when>
          	<c:when test="${loginUser != null }">
          		<h2 class="display-3">안녕하세요, ${loginUser.name}(${loginUser.userid})님!</h2>
          	</c:when>          
          </c:choose>
          <p style="margin: 30px">안녕하세요. 이번에는 MiniProject로 MVC 2Model기반 JSP&Servlet을 이용한 회원관리, 상품관리, 게시판을 만들었습니다. 감사합니다. </p>
          <p><a class="btn btn-primary btn-lg" href="https://github.com/LoveMong" role="button">More Project &raquo;</a></p>
        </div>
      </div>

      <div class="container">
        <!-- Example row of columns -->
        <div class="row">
          <div class="col-md-4">
            <h2 >회 원 관 리</h2>
            <p>&#183; 로그인, 로그아웃, 회원가입, 회원정보수정 기능 구현<br>
               &#183; 로그인, 회원가입, 정보수정 JS사용 유효성 검사 적용<br>
               &#183; 회원가입 시 비밀번호 암호화 구현(BCrypt 사용) <br>
               &#183; Filter 사용 사용자 인증<br>
               &#183; Bootstrap Example Template CSS 적용 
            </p>            
          </div>
          <div class="col-md-4">
            <h2>상 품 관 리</h2>
            <p>&#183; 상품 등록, 수정, 삭제 기능 구현<br>
               &#183; 등록, 수정, 삭제 JS사용 유효성 검사 적용<br>
               &#183; Mutipart사용 파일 업로드 구현 <br>
               &#183; 상품 리스트 정보 Paging 처리 <br>
               &#183; Bootstrap Example Template CSS 적용 
            </p>            
            <p><a class="btn btn-secondary" href="/product/list.do" role="button">View details &raquo;</a></p>
          </div>
          <div class="col-md-4">
            <h2>게 시 판</h2>
            <p>&#183; 게시판 등록, 수정, 삭제 기능 구현<br>
               &#183; 등록, 수정, 삭제 JS사용 유효성 검사 적용<br>
               &#183; 게시글 리스트 Paging 처리 <br>
               &#183; Bootstrap Example Template CSS 적용 
            </p>            
            <p><a class="btn btn-secondary" href="/board/list.do" role="button">View details &raquo;</a></p>
          </div>
        </div>

        <hr>

      </div>
      
      <jsp:include page="/view/common/footer.jsp"></jsp:include>

  </body>
</html>
