<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
	function toDelete(sid) {
		var flag = confirm("确定删除该学生？");
		if(flag){
			window.location.href="Delete?sid="+sid;
			alert("删除成功");
		}
	}
</script>
<body>
	<h2>欢迎使用学生信息管理系统</h2>
	<a href="index.jsp">返回主页</a><br><br>
	<form action="QueryServlet" method="post">
	<table border="1">
		<tr>
			<td colspan="8">
				按姓名查询:<input type="text" name="sname"/>
				按性别查询:<select name="gender">
						  <option value="null">--请选择--</option>
						  <option value="男">男</option>
						  <option value="女">女</option>
						</select>
				&nbsp;&nbsp;
						<input type="submit" value="查询">
			</td>
		</tr>
		<tr>
			<td>编号</td>
			<td>姓名</td>
			<td>性别</td>
			<td>电话</td>
			<td>生日</td>
			<td>爱好</td>
			<td>简介</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${pageBean.list}" var="stu">
			<tr>
				<td>${stu.sid}</td>
				<td>${stu.sname}</td>
				<td>${stu.gender}</td>
				<td>${stu.phone}</td>
				<td>${stu.birthday}</td>
				<td>${stu.hobby}</td>
				<td>${stu.info}</td>
				<td><a href="EditServlet?sid=${ stu.sid}">更新</a>
					<a href="#" onclick="toDelete(${stu.sid})">删除</a>
				</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="8">
				第${ pageBean.currentPage} /${pageBean.totalPage} &nbsp;&nbsp;
				每页显示${ pageBean.pageSize }条&nbsp;&nbsp;
				总记录数&nbsp;${pageBean.totalSize }
				<c:if test="${ pageBean.currentPage!=1}">
					<a href="StudentListServlet?currentPage=1">首页</a>&nbsp;
					<a href="StudentListServlet?currentPage=${pageBean.currentPage-1}">上一页</a>
				</c:if>
				<c:if test="${ pageBean.currentPage!=pageBean.totalPage}">
					<a href="StudentListServlet?currentPage=${pageBean.currentPage+1}">下一页</a>
					<a href="StudentListServlet?currentPage=${pageBean.totalPage }">尾页</a>&nbsp;
				</c:if>
			</td>
		</tr>
	</table>
	</form>
</body>
</html>