<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE jsp PUBLIC "-//W3C//DTD jsp 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>客家美天蛋糕房</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/style.css" />
	<link rel="shortcut icon" href="./images/logo1.jpg" type="image/x-icon" />
	<script src="http://libs.baidu.com/jquery/1.9.0/jquery.js"></script>
	<style type="text/css">
<!--
#page a {
 float:left;
 margin:5px 2px 0 1px;
 width:45px;
 height:20px;
 color:#0033CC;
 font:12px/20px 宋体;
 text-align:center;
 text-decoration:none;
 border:1px solid orange;
 }
-->
</style>
  </head>
  
  <body>
   <div id="header">
		<div>
			<div>
				<div id="logo">
					<a href="index.jsp"><img src="images/logo.gif" alt="Logo"/></a>
				</div>
				<div>
                <c:forEach var="entry" items="${sessionScope.noticelist}" varStatus="status">
				 <c:if test="${status.last}">  
					<marquee align="absbottom" onMouseOut="this.start()" onMouseOver="this.stop()" ><font color=red style="font-size:120%">公告主题：${entry.n_item} &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp 内容：${entry.notice }</font></marquee>
				 </c:if>
				</c:forEach>				<div>
						<a href="view/signin.jsp">我的账户</a>
						<a href="view/blog.jsp">帮助</a>
						<a href="view/signin.jsp" class="last">登入</a>
					</div>
					<form action="#">
						<input type="text" id="search" maxlength="30" />
						<input type="submit" value="" id="searchbtn" />
					</form>
				</div>
			</div>
			<ul>
			<li ><a href="index.jsp">首页</a></li>
      <li class="current"><a href="ProductServlet?operate=manageProduct4&category=类">特色糕饼</a></li>
      <li><a href="view/about.jsp">关于我们+团队文化</a></li>
      <li><a href="view/services.jsp">创业道路and店面介绍</a></li>
      <li><a href="view/blog.jsp">基本信息</a></li>
      <li><a href="MessageServlet?operate=manageMessage1">游客留言</a></li>
			</ul>
			<div class="section">
				<a href="index.jsp"><img src="images/wedding-cupcakes-small.jpg" alt="Image"/></a>
			</div>
		</div>
	</div>
	<div id="content">
		<div>
			<h1>The Pastry shop</h1>
			<%-- 产品展示区 --%>
			<ul>
			<c:forEach var="entry" items="${sessionScope.page.list}" varStatus="status">
				<li>
					<div>
						<div>
							<h1><a href="index.jsp"><c:out value="${entry.p_name}"/></a></h1>
							<p style="width: 950px; "><c:out value="${entry.p_content}"/></p>
							<p class="view">价格：<c:out value="${entry.p_price}"/></p>
							<p class="view">类别：<c:out value="${entry.p_category}"/></p>
							<a href="MessageServlet?operate=manageMessage1" class="view" target="_blank">留言</a>
						</div>
						<a href="index.jsp"><img src="ProductImages/${entry.p_image }" alt="Image" width="450" height="218"/></a>
					</div>
				</li>
			</c:forEach>		
				
			</ul>
			<%-- 产品展示区 --%>
			
			<!--分页 -->
			<jsp:include page="/view/Productpage.jsp"></jsp:include>
			
		</div>
			  	
	</div>
	<div id="footer">
		<div class="section">
			<div>
				<div class="aside">
					<div>
						<div>
							<b>Too <span>BUSY</span> to shop?</b>
							<a href="signin.jsp">免费注册</a>
							<p>and we&#39;ll deliver it on your doorstep</p>
						</div>
					</div>
				</div>
				<div class="connect">
					<span>分享链接</span>
					<!-- Baidu Button BEGIN -->
									<div id="bdshare"
										class="bdshare_t bds_tools_32 get-codes-bdshare">
										<a class="bds_qzone"></a> <a class="bds_tsina"></a> <a
											class="bds_tqq"></a> <a class="bds_renren"></a> <span
											class="bds_more">更多</span> <a class="shareCount"></a>
									</div>
									<script type="text/javascript" id="bdshare_js"
										data="type=tools"></script>
									<script type="text/javascript" id="bdshell_js"></script>
									<script type="text/javascript">
										document.getElementById("bdshell_js").src = "http://bdimg.share.baidu.com/static/js/shell_v2.js?cdnversion="
												+ new Date().getHours();
									</script>
									<!-- Baidu Button END -->
				</div>
			</div>
		</div>
		<div id="featured">
			<ul>
				<li class="first">
					<a href="index.jsp"><img src="images/fruit-cake.jpg" alt="Image" /></a>
					<h2><a href="index.jsp">Tips on how to preserve</a></h2>
					<p>Lorem ipsum dolor sit amet, consectetuer adispiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet. <a href="index.jsp" class="readmore">read more</a></p>
				</li>
				<li>
					<a href="index.jsp"><img src="images/italian.jpg" alt="Image" /></a>
					<h2><a href="index.jsp">Menu of the day: Italian</a></h2>
					<p>Lorem ipsum dolor sit amet, consectetuer adispiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet. <a href="index.jsp" class="readmore">查看更多</a></p>
				</li>
				<li>
					<a href="index.jsp"><img src="images/fruit.jpg" alt="Image" /></a>
					<h2><a href="index.jsp">Fruit menu for your diet</a></h2>
					<p>Lorem ipsum dolor sit amet, consectetuer adispiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet. <a href="index.jsp" class="readmore">read more</a></p>
				</li>
				<li>
					<a href="index.jsp"><img src="images/desserts.jpg" alt="Image" /></a>
					<h2><a href="index.jsp">Desserts for every occassion</a></h2>
					<p>Lorem ipsum dolor sit amet, consectetuer adispiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet. <a href="index.jsp" class="readmore">read more</a></p>
				</li>
			</ul>
		</div>
		<div id="navigation">
			<div>
				<ul>
					<li class="first"><a href="index.jsp">帮助</a></li>
					<li><a href="index.jsp">about cake delight</a></li>
					<li><a href="index.jsp">cake delight talk</a></li>
					<li><a href="index.jsp">developers</a></li>
					<li><a href="index.jsp">privacy policy</a></li>
					<li><a href="index.jsp">terms of use(updated 10/15/08)</a></li>
				</ul>
				<p>Copyright &copy; 2006-2008 cake delight  All rights reserved</p>
			</div>
		</div>
	</div>
  </body>
</html>
