<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
<title>Edit Profile</title>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/login_register.js"></script>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/login.css">


<!------ Include the above in your HEAD tag ---------->
</head>
<body>

	<div class="container">
	    	<div class="row">
				<div class="col-md-6 col-md-offset-3">
					<div class="panel panel-login">
						<div class="panel-heading">
							<div class="row">						
								<div class="col-xs-6" style="width: 100%; margin-top: 20px">
									<a style="color: green; font-size: 30px">Edit Profile</a>
								</div>
							</div>
							<hr>
						</div>
						<div class="panel-body">
							<div class="row">
								<div class="col-lg-12">
									<form id="login-form" action="/member/edit.do" method="post" role="form" style="display: block;" name="prm">
										<div class="form-group">
											<input type="text" name="userid" id="userid" tabindex="1" class="form-control" placeholder="ID" value="${userInfo.userid}" readonly="readonly">
										</div>
										<div class="form-group">
											<input type="text" name="name" id="name" tabindex="2" class="form-control" placeholder="Name" value="${userInfo.name}" readonly="readonly">
										</div>
										<div class="form-group">
											<input type="password" name="pwd" id="epwd" tabindex="2" class="form-control" placeholder="Password">
										</div>
										<div class="form-group">
											<input type="password" name="cpwd" id="ecpwd" tabindex="2" class="form-control" placeholder="Password Comfirm">
										</div>
										<div class="form-group">
											<input type="email" name="email" id="email" tabindex="2" class="form-control" placeholder="Eamil Adress" value="${userInfo.email}">
										</div>
										<div class="form-group">
											<input type="text" name="phone" id="phone" tabindex="2" class="form-control" placeholder="Phone Number" value="${userInfo.phone}">
										</div>
										<div class="form-group text-center"> 									
										</div>
										<div class="form-group">
											<div class="row">
												<div class="col-sm-6 col-sm-offset-3">
													<input type="submit" name="edit-submit" id="edit-submit" tabindex="4" class="form-control btn btn-login" value="Modify" onclick="return editCheck()">
												</div>
											</div>
										</div>
										<div class="form-group">
											<div class="row">
												<div class="col-lg-12">
													<div class="text-center" style="color: red">
														<!-- <a href="https://phpoll.com/recover" tabindex="5" class="forgot-password">Forgot Password?</a> -->
														${message }
													</div>
												</div>
											</div>
										</div>
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<script type="text/javascript">
		

		
		
		</script>

</body>
</html>