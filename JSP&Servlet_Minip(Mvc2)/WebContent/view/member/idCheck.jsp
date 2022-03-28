<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/login_register.js"></script>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<title>아이디 중복 체크</title>
</head>
<body>
	<h2>Check ID</h2>
		<form id="login-form" action="idCheck.do" method="get" role="form" style="display: block;" name="frm">
			<div class="form-group">
				<input type="text" name="userid" id="userid" tabindex="1" class="form-control" placeholder="ID" value="${userid}">
			</div>
			<div class="form-group">
				<input type="submit" tabindex="2" class="form-control" placeholder="Submit" value="중복 체크">
			</div>
			<div class="form-group text-center" style="color: red">
				<c:if test="${result == 1 }">
					<script type="text/javascript">
						opener.document.frm.userid.value = "";
					</script>
					${userid}는 이미 사용중인 아이디입니다.
				</c:if>
				<c:if test="${result == -1}">
					${userid}는 사용 가능한 아이디입니다.
					<input type="button" id="start" value="사용" class="form-control">
				</c:if>
			</div>
		</form>
</body>
</html>