<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" >
<style type="text/css">
	h2 {
		margin-left:90px;
	}
	.container{
		margin-left:360px;
	}
</style>
</head>
<body>
	<div >
		<div class="container">
			<br> <br> <br> <br>
			<div class="page-header">
  				<h1>学生信息管理系统<small>登录界面</small></h1>
			</div>
			<br> <br> <br>
			<form class="form-horizontal" action="StudentServlet?method=login" method="post">
				<div class="form-group">
					<label for="inputEmail3" class="col-sm-2 control-label">账号：</label>
					<div class="col-xs-3">
						<input type="text" class="form-control" id="inputEmail3" placeholder="账号" name="username">
					</div>
				</div>
				<div class="form-group">
					<label for="inputPassword3" class="col-sm-2 control-label">密码：</label>
					<div class="col-xs-3">
						<input type="password" class="form-control" id="inputPassword3" name="password"	placeholder="Password">
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<div class="checkbox">
							<label> <input type="checkbox" name="remberme"> 记住我
							</label>
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="submit" class="btn btn-default">登录</button>
					</div>
				</div>
			</form>
			<font color="red">${err}</font>
		</div>
	</div>
</body>
</html>