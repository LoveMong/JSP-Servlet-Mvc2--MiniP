<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
<title>LoginRegister</title>
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
								<div class="col-xs-6">
									<a href="#" class="active" id="login-form-link">Login</a>
								</div>
								<div class="col-xs-6">
									<a href="#" id="register-form-link">Register</a>
								</div>
							</div>
							<hr>
						</div>
						<div class="panel-body">
							<div class="row">
								<div class="col-lg-12">
									<form id="login-form" action="/member/login.do" method="post" role="form" style="display: block;" name="frm">
										<div class="form-group">
											<input type="text" name="userid" id="userid" tabindex="1" class="form-control" placeholder="ID" value="">
										</div>
										<div class="form-group">
											<input type="password" name="pwd" id="pwd" tabindex="2" class="form-control" placeholder="Password">
										</div>
										<div class="form-group text-center">
											<!-- <input type="checkbox" tabindex="3" class="" name="remember" id="remember">
	 										<!-- <label for="remember"> Remember Me</label> 아이디 저장 -->
										</div>
										<div class="form-group">
											<div class="row">
												<div class="col-sm-6 col-sm-offset-3">
													<input type="submit" name="login-submit" id="login-submit" tabindex="4" class="form-control btn btn-login" value="Log In" onclick="return loginCheck()">
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
								
									<form id="register-form" action="/member/join.do" method="post" role="form" style="display: none;" name="jrm">
										<div class="form-group">
											<input type="text" name=userid id="userid" tabindex="1" class="form-control" placeholder="ID" value="">
										</div>
										<div class="form-group">
											<input type="button" tabindex="2" class="form-control" value="Check ID" id="idCheck">
										</div>
										<div class="form-group">
											<input type="text" name="name" id="name" tabindex="3" class="form-control" placeholder="Name" value="">
										</div>
										<div class="form-group">
											<input type="email" name="email" id="email" tabindex="4" class="form-control" placeholder="Email Address">
										</div>
										<div class="form-group">
											<input type="text" name="phone" id="phone" tabindex="5" class="form-control" placeholder="Phone Number">
										</div>
										<div class="form-group">
											<input type="password" name="pwd" id="jpwd" tabindex="6" class="form-control" placeholder="Password">
										</div>
										<div class="form-group">
											<input type="password" name="cpwd" id="cpwd" tabindex="7" class="form-control" placeholder="Confirm Password">
										</div>
										<div class="form-group">
											<div class="row">
												<div class="col-sm-6 col-sm-offset-3">
													<input type="submit" name="register-submit" id="register-submit" tabindex="4" class="form-control btn btn-register" value="Register Now" onclick="return joinCheck()">
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
</body>
</html>