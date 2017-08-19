<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>注册</title>
		<link rel="stylesheet" type="text/css" href="css/pagestyle.css" />
		<link rel="stylesheet" type="text/css" href="zeromodal/zeroModal.css" />
		<link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css" />
		<link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap-theme.min.css" />
		<link rel="stylesheet" type="text/css" href="pagestyle.css" />
		<script type="text/javascript" src="jquery/jquery-1.9.1.min.js"></script>
		<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="zeromodal/zeroModal.min.js"></script>
		<script type="text/javascript">

			function put(a) {
				var length=a.length;
				if(length>=4){
				    $.ajax({
						url:"/checkCode.do?checkCode="+a,
						success:function (data) {
							if(data=="success"){
							   $("#sp").text("验证码填写正确")
							}else{
                                $("#sp").text("验证码填写错误")
								$("#checkCode").val("");
							}
							$("#sp").css({"background-color":"yellow","color":"red"})
                        },error:function () {
                            alert("错了")
                        }
					})
				}
            }
			$(function () {
			    //刷新验证码
                function myReload() {
                    document.getElementById("CreateCheckCode").src = document.getElementById("CreateCheckCode").src
                        + "?nocache=" + new Date().getTime();
                }

				$("#reg").click(function () {
					$.ajax({
						url:"/subRegister.do",
						data:$("#_form").serialize(),
						success:function (data) {
                            if (data.state == "true") {
                                zeroModal.success({
                                    content: data.message,
                                    okFn: function () {
                                        window.location.reload();
                                    }
                                });
                            } else {
                                zeroModal.error(data.message);
                            }
                        }
					})
                })
            })
		</script>
    </head>
    <body>
    	<h1 align="center">注册</h1>
		<form id="_form" action="" method="post">
		<table class="easytable">
			<tr>
				<td>
					<label>昵称:</label>
				</td>
				<td><input type="text" class="minput" id="nickname" name="nickname" placeholder="请输入昵称"></td>
			</tr>
			<tr>
				<td>
					<label>邮箱:</label>
				</td>
				<td><input type="email" class="minput" id="email" name="email" placeholder="请输入邮箱"></td>
			</tr>
			<tr>
				<td>
					<label>密码:</label>
				</td>
				<td><input type="password" class="minput" id="pswd" name="pswd" placeholder="请输入密码"></td>
			</tr>
			<tr>
				<td>
					<label>确认密码:</label>
				</td>
				<td><input type="password" class="minput" id="upass" name="upass" placeholder="请再次输入密码"></td>
			</tr>
			<tr>
				<td>
					<label>验证码:</label>
				</td>
				<td><input name="checkCode" type="text" oninput="put(this.value)" id="checkCode" title="验证码区分大小写" size="8" ,maxlength="4"/>
					<img src="/PictureCheckCode.do" id="CreateCheckCode" align="middle">
					<a href="" onclick="myReload()">看不清,换一个</a><span id="sp"></span>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<button type="button" class="btn btn-success btn-block" id="reg">注册</button>
				</td>
			</tr>
		</table>
		</form>
 	</body>
</html>