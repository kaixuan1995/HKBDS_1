<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
<link href="backstage_file/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="javascript/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		//setMenuHeight
		$('.menu').height($(window).height() - 51 - 27 - 26);
		$('.sidebar').height($(window).height() - 51 - 27 - 26);
		$('.page').height($(window).height() - 51 - 27 - 26);
		$('.page iframe').width($(window).width() - 15 - 168);

		//menu on and off
		$('.btn').click(function() {
			$('.menu').toggle();

			if ($(".menu").is(":hidden")) {
				$('.page iframe').width($(window).width() - 15 + 5);
			} else {
				$('.page iframe').width($(window).width() - 15 - 168);
			}
		});

		//
		$('.subMenu a[href="#"]').click(function() {
			$(this).next('ul').toggle();
			return false;
		});
	})
</script>
<script src="backstage_file/javascript/check.js"></script>
</head>

<body>
<input type="hidden" id="msg" value="${requestScope.exceptionInfo }" />
	<div id="wrap">
		<div id="header">
			<div class="logo fleft"></div>
			<div class="nav fleft"></div>
			<a class="logout fright" href="./loginout"><font size="4" color="red">注销 </font></a>
			<div class="clear"></div>
			<div class="subnav">
				<div class="subnavLeft fleft"></div>
				<div class="fleft"></div>
				<div class="subnavRight fright"></div>
			</div>
		</div>
		<!--#header -->
		<nobr>
			<div id="content">
				<div class="space"></div>
				<div class="menu fleft">
					<ul>
						<li class="subMenuTitle">操作列表</li>
						<li>公告管理
							<ul>
								<li><a href="backstage_file/back/RealseNotice.jsp" target="right">发布公告</a>
								</li>
							</ul>
							<ul>
								<li><a href="NoticeServlet?operate=manageNotice" target="right">管理公告</a>
								</li>
							</ul></li>
						<li>留言管理
							<ul>
								<li><a href="MessageServlet?operate=manageMessage" target="right">管理留言</a>
								</li>
							</ul></li>

						<li>产品管理
							<ul>
								<li><a href="backstage_file/back/Products.jsp" target="right">发布新产品</a>
								</li>
								<li><a href="ProductServlet?operate=manageProduct" target="right">管理产品</a>
								</li>
							</ul></li>

					</ul>
				</div>
				<div class="sidebar fleft">
					<div class="btn"></div>
				</div>
				<div class="page">
					<iframe width="100%" scrolling="auto" height="100%"
						frameborder="false" allowtransparency="true"
						style="border: medium none;" src="backstage_file/back/main.jsp" id="rightMain"
						name="right"></iframe>
				</div>
		</nobr>
	</div>
	<!--#content -->
	<div class="clear"></div>
	<div id="footer"></div>
	<!--#footer -->
	</div>
	<!--#wrap -->
	<div style="text-align:center;"></div>
</body>
</html>
