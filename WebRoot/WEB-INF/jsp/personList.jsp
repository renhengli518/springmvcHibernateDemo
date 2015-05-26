<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
	<head>
		<title>personList.jsp</title>
	</head>

	<body>
		<a href="<%=path%>/per/addPersonUI">添加person</a>
		<br>
		<a href="<%=path%>/per/nameList">按照姓名查找</a>
		<br>
		<table border="1" width="500">
			<tr>
				<td>
					name
				</td>
				<td>
					age
				</td>
				<td>
					address
				</td>
				<td>
					删除
				</td>
				<td>
					编辑
				</td>
			</tr>
			<c:forEach items="${persons}" var="p">
				<tr>
					<td>
						${p.name }
					</td>
					<td>
						${p.age }
					</td>
					<td>
						${p.address }
					</td>
					<td>
						<a href="<%=path%>/per/delete?id=${p.id }">删除</a>
					</td>
					<td>
						<a href="<%=path%>/per/editUI?id=${p.id }">编辑</a>
					</td>
				</tr>
			</c:forEach>
		</table>
		<a href="<%=path%>/per/findAll">下一页</a>
		<a href="<%=path%>/per/findAll_1">上一页</a>
	</body>
</html>
