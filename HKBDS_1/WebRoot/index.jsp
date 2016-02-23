<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

<title>客家美天糕点房</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="css/style.css" />
<link rel="shortcut icon" href="./images/logo1.jpg" type="image/x-icon" />
<script src="http://libs.baidu.com/jquery/1.9.0/jquery.js"></script>
</head>
<body>
 <input type="hidden" id="msg" value="${requestScope.exceptionInfo }" />
	<div id="header">
		<div>
			<div>
				<div id="logo">
					<a href="index.jsp"><img src="images/logo.gif" alt="Logo" /> </a>
				</div>
				<div>
				<c:forEach var="entry" items="${sessionScope.noticelist}" varStatus="status">
				 <c:if test="${status.last}">  
					<marquee align="absbottom" onMouseOut="this.start()" onMouseOver="this.stop()" ><font color=red style="font-size:120%">公告主题：${entry.n_item} &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp 内容：${entry.notice }</font></marquee>
				 </c:if>
				</c:forEach>
					<div>
						<a href="view/signin.jsp">我的账户</a> <a href="view/blog.jsp">帮助</a>
						<a href="view/signin.jsp" class="last">登入</a>
					</div>
					<form action="#">
						<input type="text" id="search" maxlength="30" /> <input
							type="submit" value="" id="searchbtn" />
					</form>
				</div>
			</div>
			<ul>
				<li class="current"><a href="index.jsp">首页</a>
				</li>
				<li><a href="ProductServlet?operate=manageProduct4&category=类">特色糕饼</a>
				</li>
				<li><a href="view/about.jsp">关于我们+团队文化</a>
				</li>
				<li><a href="view/services.jsp">创业道路and店面介绍</a>
				</li>
				<li><a href="view/blog.jsp">基本信息</a>
				</li>
				<li><a href="MessageServlet?operate=manageMessage1">游客留言</a>
				</li>
			</ul>
			<div id="section">
				<ul>
					<li><a href="ProductServlet?operate=manageProduct4&category=礼品类">礼品类</a></li>
					<li><a href="ProductServlet?operate=manageProduct4&category=饼类">饼类</a></li>
					<li><a href="ProductServlet?operate=manageProduct4&category=蛋糕西饼">蛋糕西饼类</a></li>
					<li><a href="ProductServlet?operate=manageProduct4&category=烘焙原材料">烘焙原材料类</a></li>
					<li><a href="ProductServlet?operate=manageProduct4&category=烘焙工具">烘焙工具类</a></li>
					<li><img alt="" src="images/employ.png"></li>
				</ul>
				<a href="index.jsp"><img src="images/wedding-cupcakes-large.jpg"
					alt="Image" /> </a>
			</div>
		</div>
	</div>
	<div id="content">
		<div class="home">
			<div class="aside">
				<h1>欢迎来到我们的网站</h1>
				<p>
					<font size="+1">糕点是考虑到各种从成分如面粉，黄油，起酥油，发酵粉或鸡蛋制成的烘焙食品的名称。小蛋糕，馅饼和其他甜烘焙食品被称为“糕点”。
						&#34;pastries&#34;
						糕点也可指从这种焙烤食品是由面团。酥皮面团铺开薄薄地用作烘焙食品基地。常见的糕点菜肴包括馅饼，馅饼和乳蛋饼。
						糕点面包从由具有较高的脂肪含量，这有利于片状或易碎的质地区分。一个好的糕点明亮通风和脂肪，但足够牢固，能够支撑填充的重量。当进行shortcrust糕点，必须小心前彻底添加混合脂肪和面粉。
						<a href="index.jsp" class="readmore">阅读更多</a> </font>
				</p>
			</div>
			<div class="section">
				<div>
					<h2>客家美天历史</h2>
					<p>
						<font size="+1">《客家美天》创始于2013年，是一家致力于制作蛋糕、面包、糕点以及各种甜食的面包房，位于江西英雄城南昌新建县昌北经济开发区的江西农业大学生活服务中心。自成立以来，《客家美天》遵循着“好品质、好生活、好未来”的理念，为江西农业大学客户提供安全、可靠、美味的糕点。</font>
					</p>
				</div>
				<ul>
					<li class="first"><a href="index.jsp"><img
							src="images/cake.jpg" alt="Image" /> </a>
					</li>
					<li><a href="index.jsp"><img src="images/burgercake.jpg"
							alt="Image" /> </a>
					</li>
					<li><a href="index.jsp"><img src="images/cupcake.jpg"
							alt="Image" /> </a>
					</li>
				</ul>
			</div>
		</div>
	</div>
	<div id="footer">
		<div class="home">
			<div>
				<div class="aside">
					<div class="signup">
						<div>
							<b>Too <span>BUSY</span> to shop?</b> <a href="signin.jsp">Sign
								up for free</a>
							<p>and we&#39;ll deliver it on your doorstep</p>
						</div>
					</div>
					<div class="connect">
						<span>分享链接</span>
						<ul>
							<!-- Baidu Button BEGIN -->
							<div id="bdshare"
								class="bdshare_t bds_tools_32 get-codes-bdshare">
								<a class="bds_qzone"></a> <a class="bds_tsina"></a> <a
									class="bds_tqq"></a> <a class="bds_renren"></a> <span
									class="bds_more">更多</span> <a class="shareCount"></a>
							</div>
						</ul>
					</div>
				</div>
				<div class="section">
					<div>
						<div>
							<h3>
								<a href="index.jsp">每日惊喜蛋糕</a>
							</h3>
							<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit,
								sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna
								aliquam erat volutpat. Ut wisi enim ad minim veniam, quis
								nostrud exertation ullamcorper suscipit lobortis nisl ut aliquip
								ex ea commodo consequat. Duis autem vel eum iriure dolor in.</p>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div id="featured">
			<ul>
				<li class="first"><a href="index.jsp"><img
						src="images/fruit-cake.jpg" alt="Image" /> </a>
					<h2>
						<a href="index.jsp">Tips on how to preserve</a>
					</h2>
					<p>
						Lorem ipsum dolor sit amet, consectetuer adispiscing elit, sed
						diam nonummy nibh euismod tincidunt ut laoreet. <a
							href="index.jsp" class="readmore">read more</a>
					</p>
				</li>
				<li><a href="index.jsp"><img src="images/italian.jpg"
						alt="Image" /> </a>
					<h2>
						<a href="index.jsp">Menu of the day: Italian</a>
					</h2>
					<p>
						Lorem ipsum dolor sit amet, consectetuer adispiscing elit, sed
						diam nonummy nibh euismod tincidunt ut laoreet. <a
							href="index.jsp" class="readmore">read more</a>
					</p>
				</li>
				<li><a href="index.jsp"><img src="images/fruit.jpg"
						alt="Image" /> </a>
					<h2>
						<a href="index.jsp">Fruit menu for your diet</a>
					</h2>
					<p>
						Lorem ipsum dolor sit amet, consectetuer adispiscing elit, sed
						diam nonummy nibh euismod tincidunt ut laoreet. <a
							href="index.jsp" class="readmore">read more</a>
					</p>
				</li>
				<li><a href="index.jsp"><img src="images/desserts.jpg"
						alt="Image" /> </a>
					<h2>
						<a href="index.jsp">Desserts for every occassion</a>
					</h2>
					<p>
						Lorem ipsum dolor sit amet, consectetuer adispiscing elit, sed
						diam nonummy nibh euismod tincidunt ut laoreet. <a
							href="index.jsp" class="readmore">read more</a>
					</p>
				</li>
			</ul>
		</div>
		<div id="navigation">
			<div>
				<ul>
					<li class="first"><a href="index.jsp">help</a></li>
					<li><a href="index.jsp">about cake delight</a></li>
					<li><a href="index.jsp">cake delight talk</a></li>
					<li><a href="index.jsp">developers</a></li>
					<li><a href="index.jsp">privacy policy</a></li>
					<li><a href="index.jsp">terms of use(updated 10/15/08)</a></li>
				</ul>
				<p>Copyright &copy; 2006-2008 cake delight All rights reserved</p>
			</div>
		</div>
	</div>
</body>
</body>
</html>
