<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="InsertServlet?type='updata'" accept-charset="UTF-8">
	<input type="hidden" name="sid" value="${stu.sid}">
		<table border="1">
			<tr>
				<td>姓名</td>
				<td><input type="text" name="sname" value="${stu.sname}"></td>
			</tr>
			<tr>
				<td>性别</td>
				<td><input type="radio" name="gender" value="男"
					 <c:if test="${stu.gender=='男'}">checked</c:if>>男
					 <input type="radio" name="gender" value="女"
					 <c:if test="${stu.gender=='女'}">checked</c:if>>女
				</td>
			</tr>
			<tr>
				<td>电话</td>
				<td><input type="text" name="phone" value="${stu.phone}"></td>
			</tr>
			<tr>
				<td>生日</td>
				<td><input type="text" name="birthday" value="${stu.birthday}"></td>
			</tr>
			<tr>
				<td>爱好</td>
				<td>
				 <input type="checkbox" value="游泳" name="hobby" 
				 	<c:if test="${fn:contains(stu.hobby,'游泳')}">checked</c:if>/>游泳
				 <input type="checkbox" value="唱歌" name="hobby" 
				 	<c:if test="${fn:contains(stu.hobby,'唱歌')}">checked</c:if>/>唱歌 
				 <input type="checkbox" value="跳舞" name="hobby" 
					<c:if test="${fn:contains(stu.hobby,'跳舞')}">checked</c:if>/>跳舞 
				 <input type="checkbox" value="篮球" name="hobby" 
				 	<c:if test="${fn:contains(stu.hobby,'篮球')}">checked</c:if>/>篮球
				 <input type="checkbox" value="足球" name="hobby"
					<c:if test="${fn:contains(stu.hobby,'足球')}">checked</c:if>/>足球
				</td>
			</tr>
			<tr>
				<td>简介</td>
				<td><textarea name="info" rows="5" cols="25">${stu.info}</textarea></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="更新" /></td>
			</tr>
		</table>
	</form>
</body>
</html>