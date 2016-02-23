<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE jsp PUBLIC "-//W3C//DTD jsp 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>客家美天蛋糕房-后台管理</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link href="backstage_file/css/style.css" rel="stylesheet"
	type="text/css" />
<link href="backstage_file/css/zch.css" rel="stylesheet" type="text/css" />
<style type="text/css">
body {
	background: #FFF
}
</style>
<script src="backstage_file/javascript/check.js"></script>
</head>

<body>
<input type="hidden" id="msg" value="${requestScope.exceptionInfo }" />
	<div id="contentWrap">
		<div class="pageTitle">
			<h1>标准类别操作：</h1>
		</div>
		<div class="pageColumn">
			<div class="pageButton">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<form action="NoticeServlet?operate=manageNotice4" method="post">
					<input type="text" name="querynotice" placeholder="请输入关键字"
						style="width:150px; height:30px; border-color:#00F; border:1px solid #F00;"
						/> &nbsp;&nbsp;&nbsp; <input type="submit"
						value="查询" style="border:1px solid #00F; width:40px;" /></form>
			</div>
			<table>
				<thead>
					<th width="5%">序号</th>
					<th width="10%">公告标题</th>
					<th width="30%">公告内容</th>
					<th width="10%" colspan="2">操作</th>
				</thead>
				<tbody>
				<c:forEach var="entry" items="${noticelist}">
						<tr>
							<td><c:out value="${entry.id }"/></td>
							<td><c:out value="${entry.n_item}"/></td>
							<td><c:out value="${entry.notice }"/></td>
							<td><a href="NoticeServlet?operate=deleteNotice&id=${entry.id} ">删除</a></td>
							<td><a href="NoticeServlet?operate=manageNotice3&id=${entry.id} ">修改</a></td>
						</tr>
				</c:forEach>
				
				</tbody>
			</table>
		</div>
	</div>
	<div class="scott">
		<span class="disabled"> < </span><span class="current">1</span><a
			href="#">2</a><a href="#">3</a><a href="#">4</a><a href="#">5</a><a
			href="#">6</a><a href="#">7</a>...<a href="#">199</a><a href="#">200</a><a
			href="#"> > </a>
	</div>
</body>
</html>
