<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>登录</title>
		<link rel="stylesheet" type="text/css" href="css/pagestyle.css" />
		<link rel="stylesheet" type="text/css" href="zeromodal/zeroModal.css" />
		<link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css" />
		<link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap-theme.min.css" />
		<link rel="stylesheet" type="text/css" href="css/pagestyle.css" />
		<script type="text/javascript" src="jquery/jquery-1.9.1.min.js"></script>
		<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="zeromodal/zeroModal.min.js"></script>
		<script type="text/javascript">
			$(function() {
			    $("#reg").click(function () {
                    window.location.href = "register.jsp";
                })
			    
				$("#login").click(function() {
					$.ajax({
						type:"POST",
						url: "/subLogin.do",
						data:$("#loginForm").serialize(),
						success: function(data) {
							if(data.state == "true") {
								zeroModal.success({
									content: data.message,
									okFn: function() {
                                        window.location.href="/top.jsp"
									}
								});
							} else {
								zeroModal.error(data.message);
							}
						},
						error: function() {
							zeroModal.error("后台异常，请联系管理员！");
						}
					})
				});
			})
		</script>
	</head>

	<body>
		<h1 align="center">登录</h1>
		<form id="loginForm">
		<table class="easytable">
			<tr>
				<td>
					<label>账号:</label>
				</td>
				<td><input type="text" class="minput" id="email" name="email" placeholder="请输入邮箱账号"></td>
			</tr>
			<tr>
				<td>
					<label>密码:</label>
				</td>
				<td><input type="password" class="minput" id="pswd" name="pswd" placeholder="请输入密码"></td>
			</tr>
			<tr>
				<td colspan="2">
					<button type="button" class="btn btn-success btn-block" id="login">登录</button>
					<button type="button" class="btn btn-success btn-block" style="display: inline;" id="reg">注册</button>
				</td>
			</tr>
		</table>
		</form>
	</body>

</html>