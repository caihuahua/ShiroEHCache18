<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>导航</title>
		<link rel="stylesheet" type="text/css" href="css/pagestyle.css" />
		<link rel="stylesheet" type="text/css" href="zeromodal/zeroModal.css" />
		<link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css" />
		<link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap-theme.min.css" />
		<link rel="stylesheet" type="text/css" href="pagestyle.css" />
		<script type="text/javascript" src="jquery/jquery-1.9.1.min.js"></script>
		<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="zeromodal/zeroModal.min.js"></script>
	</head>

	<body>
					<nav class="navbar navbar-inverse" >
						<div class="container-fluid">
							<div class="navbar-header">
									<img alt="Brand" src="img/mx.png" >
							</div>

							<div class="collapse navbar-collapse">
								<ul class="nav navbar-nav">
									<li class="active">
										<a href="login.jsp" target="iFrame1">登录 <span class="sr-only">(current)</span></a>
									</li>
									<li>
										<a href="register.jsp" target="iFrame1">注册</a>
									</li>
									<li class="dropdown">
										<a href="#" target="iFrame1" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">管理<span class="caret"></span></a>
										<ul class="dropdown-menu">
											<li>
												<a href="manage.jsp" target="iFrame1">管理</a>
											</li>
											<li>
												<a href="#">Another action</a>
											</li>
											<li>
												<a href="#">Something else here</a>
											</li>
											<li role="separator" class="divider"></li>
											<li>
												<a href="#">Separated link</a>
											</li>
											<li role="separator" class="divider"></li>
											<li>
												<a href="#">One more separated link</a>
											</li>
										</ul>
									</li>
								</ul>
								<form class="navbar-form navbar-left">
									<div class="form-group">
										<input type="text" class="form-control" placeholder="Search">
									</div>
									<button type="submit" class="btn btn-default">Submit</button>
								</form>
								<ul class="nav navbar-nav navbar-right">
									<li>
										<a href="#">Link</a>
									</li>
									<li class="dropdown">
										<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dropdown <span class="caret"></span></a>
										<ul class="dropdown-menu">
											<li>
												<a href="#">Action</a>
											</li>
											<li>
												<a href="#">Another action</a>
											</li>
											<li>
												<a href="#">Something else here</a>
											</li>
											<li role="separator" class="divider"></li>
											<li>
												<a href="#">Separated link</a>
											</li>
										</ul>
									</li>
								</ul>
							</div>
							<!-- /.navbar-collapse -->
						</div>
						</nav>
						
					<iframe name="iFrame1" frameborder="no" src="login.jsp" height="800px" width="100%" scrolling="auto"> </iframe>
	</body>

</html>