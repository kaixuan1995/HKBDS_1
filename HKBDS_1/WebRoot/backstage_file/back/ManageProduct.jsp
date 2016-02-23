<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE jsp PUBLIC "-//W3C//DTD jsp 4.01 Transitional//EN">
<jsp>
<head>
<base href="<%=basePath%>">
<title>客家美天蛋糕房-后台管理</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link href="backstage_file/css/style.css" rel="stylesheet" type="text/css" />
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
			<h1>用户信息操作：</h1>
		</div>
		<div class="pageColumn">
			<div class="pageButton">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<form action="ProductServlet?operate=manageProduct1" name="carsProducts" onSubmit="return check()" method="post">
					<td width="40%" style="text-align:left;"><select name="category"
						style="border:1px solid #03F; width:260px;">
							<option value="礼品类">礼品类</option>
							<option value="饼类">饼类</option>
							<option value="蛋糕西饼类">蛋糕西饼类</option>
							<option value="烘焙原材料类">烘焙原材料类</option>
							<option value="烘焙工具类">烘焙工具类</option>
					</select></td> &nbsp;&nbsp;&nbsp; <input type="submit" value="查询"
						style="border:1px solid #00F; width:40px;" />
				</form>
			</div>
			<table>
				<thead>
					<th width="5%">序号
					</th>
					<th width="10%">产品名称</th>
					<th width="20%">产品图片</th>
					<th width="10%">产品价格</th>
					<th width="10%">产品类型</th>
					<th width="30%">产品详解</th>
					<th width="20%" colspan="2">操作</th>
				</thead>
				<tbody>
				<c:forEach var="entry" items="${productlist}"> 
					<tr>
						<td>${entry.p_id}
						</td>
						<td>${entry.p_name }</td>
						<td><img src="ProductImages/${entry.p_image }" width="80" height="80"/>
						</td>
						<td>${entry.p_price }元</td>
						<td>${entry.p_category }</td>
						<td>${entry.p_content }</td>
						<td><a href="ProductServlet?operate=deleteProduct&id=${entry.p_id} ">删除</a></td>
						<td><a href="ProductServlet?operate=manageProduct3&id=${entry.p_id} ">修改</a></td>
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
</jsp>
