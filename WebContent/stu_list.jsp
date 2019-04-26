<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="js/jquery-1.11.3.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<div class="page-header">
  		<h1>欢迎您！<small>${username}
  			&nbsp;&nbsp;&nbsp;&nbsp;
  		<a href="StudentServlet?method=logout" class="btn btn-default">安全退出</a></small></h1>
		
	</div>
	<div class="page-header">
  		<h1>学生信息管理系统<small>学生列表</small></h1>
	</div>
	<form action="StudentServlet?method=queryStudent" method="post" class="form-group" id="form">
	<table class="table table-striped">
		<tr>
			<td colspan="9">
				按姓名查询:<input type="text" name="sname"/>
				按性别查询:<select name="gender"  >
						  <option value="null">--请选择--</option>
						  <option value="男">男</option>
						  <option value="女">女</option>
						</select>
				&nbsp;&nbsp;
						<input type="submit" value="查询" class="btn btn-default">
						<a href="insert.jsp" class="btn btn-default">添加</a>
			</td>
		</tr>
		<tr>
			<td>编号</td>
			<td>姓名</td>
			<td>班级</td>
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
				<td>${stu.grade}</td>
				<td>${stu.gender}</td>
				<td>${stu.phone}</td>
				<td>${stu.birthday}</td>
				<td>${stu.hobby}</td>
				<td>${stu.info}</td>
				<td><a href="StudentServlet?method=updataUI&sid=${ stu.sid}" class="btn btn-default">更新</a>
					<input id="${ stu.sid}" type="button" class="btn btn-default del" value="删除">
				</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="9">
				第${ pageBean.currentPage} /${pageBean.totalPage} &nbsp;&nbsp;
				每页显示${ pageBean.pageSize }条&nbsp;&nbsp;
				总记录数&nbsp;${pageBean.totalSize }
				<c:if test="${ pageBean.currentPage!=1}">
					<a href="${pageContext.request.contextPath}/${pageBean.url}&currentPage=1">首页</a>&nbsp;
					<a href="${pageContext.request.contextPath}/${pageBean.url}&currentPage=${pageBean.prePage}">上一页</a>
				</c:if>
				<c:if test="${ pageBean.currentPage!=pageBean.totalPage}">
					<a href="${pageContext.request.contextPath}/${pageBean.url}&currentPage=${pageBean.nextPage}">下一页</a>
					<a href="${pageContext.request.contextPath}/${pageBean.url}&currentPage=${pageBean.totalPage}">尾页</a>&nbsp;
				</c:if>
			</td>
		</tr>
	</table>
	</form>
</body>
<script type="text/javascript">
$(".del").click(function(){
	var id = this.id;
	if(confirm("是否删除?")){
		window.location.href="${pageContext.request.contextPath}/StudentServlet?method=delete&sid="+id;
	}
});
</script>
</html>