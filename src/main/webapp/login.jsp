<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>登录</title>
		<link rel="stylesheet" type="text/css" href="css/pagestyle.css" />
		<link rel="stylesheet" type="text/css" href="zeromodal/zeroModal.css" />
		<link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css" />
		<link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap-theme.min.css" />
		<link rel="stylesheet" type="text/css" href="pagestyle.css" />
		<script type="text/javascript" src="jquery/jquery-1.9.1.min.js"></script>
		<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="zeromodal/zeroModal.min.js"></script>
		<script type="text/javascript">
			$(function() {
				$("#userid").focus();
				$("#login").click(function() {
					var userid = $("#userid").val();
					userpass
					var pass = $("#userpass").val();
					if(!userid) {
						zeroModal.alert({
							content: "请输入用户名！",
							okFn: function() {
								$("input").focus()
							}
						});
						return
					}
					$.ajax({
						url: "/material/addMaterial.do?materialName=" + $("#materialName").val(),
						success: function(data) {
							if(data.state == "true") {
								zeroModal.success({
									content: data.message,
									okFn: function() {
										$("input").val("");
									},
									cancel: true,
									cancelTitle: '返回',
									cancelFn: function() {
										history.back(-1);
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
		<table class="easytable">
			<tr>
				<td>
					<label>账号:</label>
				</td>
				<td><input type="text" class="minput" id="userid" name="" placeholder="请输入账号"></td>
			</tr>
			<tr>
				<td>
					<label>密码:</label>
				</td>
				<td><input type="password" class="minput" id="userpass" name="" placeholder="请输入密码"></td>
			</tr>
			<tr>
				<td colspan="2">
					<button type="button" class="btn btn-success btn-block" id="login">登录</button>
					<button type="button" class="btn btn-success btn-block" style="display: inline;" id="reg">注册</button>
				</td>
			</tr>
		</table>
	</body>

</html>