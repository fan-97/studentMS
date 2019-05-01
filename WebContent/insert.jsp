<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<title>Insert title here</title>
</head>
<body>
	<div class="page-header">
  		<h1>学生信息管理系统<small>添加学生</small></h1>
	</div>
	<a href="StudentServlet?method=goHead" class="btn btn-default">返回主页</a><br><br>
	<form method="post" action="StudentServlet?method=insertOne" accept-charset="UTF-8">
		<table class="table table-hover">
			<tr>
				<td>姓名</td>
				<td><input type="text" name="sname"></td>
			</tr>
			<tr>
				<td>班级</td>
				<td><input type="text" name="grade" ></td>
			</tr>
			<tr>
				<td>性别</td>
				<td><input type="radio" name="gender" value="男">男
					 <input type="radio" name="gender" value="女">女
				</td>
			</tr>
			<tr>
				<td>电话</td>
				<td><input type="text" name="phone"></td>
			</tr>
			<tr>
				<td>生日</td>
				<td><input type="date" name="birthday" /></td>
			</tr>
			<tr>
				<td>爱好</td>
				<td>
				 <input type="checkbox" value="游泳" name="hobby"/>游泳
				 <input type="checkbox" value="唱歌" name="hobby"/>唱歌 
				 <input type="checkbox" value="跳舞" name="hobby"/>跳舞 
				 <input type="checkbox" value="篮球" name="hobby"/>篮球
				 <input type="checkbox" value="足球" name="hobby"/>足球
				</td>
			</tr>
			<tr>
				<td>简介</td>
				<td><textarea name="info" rows="5" cols="25"></textarea></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="添加" class="btn btn-default"/></td>
			</tr>
		</table>
	</form>
</body>
</html>