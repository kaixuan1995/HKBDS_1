<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<title>客家美天蛋糕房</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="shortcut icon" href="./images/logo1.jpg" type="image/x-icon" />
<link rel="stylesheet" type="text/css" href="css/style.css" />
<script src="http://libs.baidu.com/jquery/1.9.0/jquery.js"></script>
<script charset="GBK" language="javascript"  type="text/javascript" src="./js/messagecheck.js"></script>
<%--ajax实现异步加载 --%>
<%-- <script language="javascript">
//创建异步对象
function createXMLHttpRequest() {
	
	try {
		return new XMLHttpRequest();//大多数浏览器
	} catch (e) {
		try {
			return ActvieXObject("Msxml2.XMLHTTP");//IE6.0
		} catch (e) {
			try {
				return ActvieXObject("Microsoft.XMLHTTP");//IE5.5及更早版本	
			} catch (e) {
				alert("哥们儿，您用的是什么浏览器啊？");
				throw e;
			}
		}
	}
}

window.onload = function() {//文档加载完毕后执行
	/*
	ajax四步操作，得到服务器的响应
	把响应结果显示到h1元素中
	 */
	/*
	1. 得到异步对象 
	 */
	var xmlHttp = createXMLHttpRequest();
	/*
	2. 打开与服务器的连接
	 * 指定请求方式
	 * 指定请求的URL
	 * 指定是否为异步请求
	 */
	xmlHttp
			.open(
					"GET",
					"<c:url value='/NoticeServlet?operate=manageNotice1'/>",
					true);
	/*
	3. 发送请求
	 */
	xmlHttp.send(null);//GET请求没有请求体，但也要给出null，不然FireFox可能会不能发送！
	/*
	4. 给异步对象的onreadystatechange事件注册监听器
	 */
	xmlHttp.onreadystatechange = function() {//当xmlHttp的状态发生变化时执行
		// 双重判断：xmlHttp的状态为4（服务器响应结束），以及服务器响应的状态码为200（响应成功）
		if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
			// 获取服务器的响应结束
			var text = xmlHttp.responseText;
			// 获取h1元素
			var h1 = document.getElementById("h1");
			h1.innerHTML = text;
		}
	};

};
</script> --%>

<!--分页的样式-->
<style type="text/css">
<!--
#page a {
	float: left;
	margin: 5px 2px 0 1px;
	width: 45px;
	height: 20px;
	color: #0033CC;
	font: 12px/20px 宋体;
	text-align: center;
	text-decoration: none;
	border: 1px solid orange;
}
-->
</style>
</head>
<body>
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
						<a href="view/signin.jsp">我的账户</a> <a href="view/blog.jsp"> 帮助</a>
						<a href="view/signin.jsp" class="last">登入</a>
					</div>
					<form action="#">
						<input type="text" id="search" maxlength="30" /> <input
							type="submit" value="" id="searchbtn" />
					</form>
				</div>
			</div>
			<ul>
			<li ><a href="index.jsp">首页</a></li>
      <li><a href="ProductServlet?operate=manageProduct4&category=类">特色糕饼</a></li>
      <li><a href="view/about.jsp">关于我们+团队文化</a></li>
      <li><a href="view/services.jsp">创业道路and店面介绍</a></li>
      <li><a href="view/blog.jsp">基本信息</a></li>
      <li class="current"><a href="MessageServlet?operate=manageMessage1">游客留言</a></li>
			</ul>
			<div class="section">
				<a href="index.jsp"><img src="images/wedding-cupcakes-small.jpg"
					alt="Image" /> </a>
			</div>
		</div>
	</div>
	<form action="MessageServlet?operate=relaseMessage" name="relaseMessage" onsubmit="return check()" method="post">
	<div id="content">
		<div id="id="about">
			<fieldset align="left" style="width:900px;">
				<legend>游客留言</legend>
				<center>
				
					<table width="762" bordercolor="#6699CC" cellspacing="0"
						cellpadding="0" border="1">
						<tr align="center" class="tdfont">
							<td height="27" width="200"
								background="images/index_09_repeat.gif">留言作 者</td>
							<td height="27" background="images/index_09_repeat.gif">留言信息</td>
						</tr>
				<c:forEach var="entry" items="${sessionScope.page.list}" varStatus="status" > 
						<tr>
				                    
							<td><table width="200" cellspacing="0" cellpadding="0"
									border="0">
									<tr>
										<td colspan="3" align="center"><img src="images/1.gif"
											width="75" height="75"></td>
									</tr>
									<tr class="tdfont">
										<td align="right">NO:<c:out value="${status.count}"/> </td>
										<td width="22" height="15"><img
											src="images/logo_sanjiao.gif"></td>
										<td align="left" width="90"><c:out value="${entry.m_name }"/></td>
									</tr>
								</table></td>
							<td valign="top"><table width="562" cellspacing="0"
									cellpadding="0" border="0">
									<tr>
										<td class="tdfont" width="53">标题：<br> <font size="3"
											color="#3AA60D"><c:out value="${entry.m_item }"/></font></td>
										<td>&nbsp;</td>
										<td class="tdfont" width="53">时间：<br> <font size="3"
											color="#3AA60D"><c:out value="${entry.m_date }"/></font></td>
										<td>&nbsp;</td>
										<td>&nbsp;</td>
										<td width="19" height="16"><img
											src="images/icon_profile.gif" alt="住址" width="16" height="16">
											
										</td>
										<td width="19" height="16"><img
											src="images/icon_email.gif" alt="邮箱" width="16" height="16">
										</td>
										<td width="19" height="16"><img
											src="images/icon_editor_oicq.gif" alt="ICQC" width="16"
											height="16"></td>
										<td width="19" height="16"><img
											src="images/icon_homepage.gif" alt="主页" width="16"
											height="16"></td>
										<td width="19" height="16"><img src="images/icon_ip.gif"
											alt="IP" width="16" height="16"></td>
									</tr>
									<tr>
										<td colspan="10" height="75"
											background="images/index_09_repeat1.gif">内容：<br> <font size="3"
											color="#3AA60D"><c:out value="${entry.m_message }"/></font></td>
									</tr>
								</table></td>
						</tr>
						</c:forEach>
						
					    </table>
					<br /> <br />
					
					<table width="762" bordercolor="#6699CC" cellspacing="0"
						cellpadding="0" border="1">
						<tr>
							<td>名字：</td>
							<td><input type="text" maxlength="30" name="username"
								value="" class="textcontact" /></td>
							<td>留言标题：</td>
							<td><input type="text" maxlength="30" name="title" value=""
								class="textcontact" /></td>
						</tr>
						<tr>
							<td>邮箱</td>
							<td><input type="text" maxlength="30" name="email" value=""
								class="textcontact" /></td>
							<td>地址</td>
							<td><input type="text" maxlength="30" name="address"
								value="" class="textcontact" /></td>
						</tr>

						<tr>
							<td>留言内容</td>
							<td><textarea name="message" id="message" cols="30"
									rows="10"></textarea></td>
							<td>提交内容</td>
							<td><input type="submit" value="提交" class="submit" /></td>
						</tr>
					</table>
				</center>
			</fieldset>
			<!--分页 -->
			<jsp:include page="/view/page.jsp"></jsp:include>
		</div>

	</div>
    </form>
	<div id="footer">
		<!--<input type="text" maxlength="30" value="您的名字" class="textcontact" />
		<input type="submit" value="提交" class="submit" />
		-->
		<div class="section">
			<div>
				<div class="aside">
					<div>
						<div>
							<b>Too <span>BUSY</span> to shop?
							</b> <a href="signin.jsp">Sign up for free</a>
							<p>and we&#39;ll deliver it on your doorstep</p>
						</div>
					</div>
				</div>
				<div class="connect">
					<span>分享链接</span>
					<!-- Baidu Button BEGIN -->
					<div id="bdshare" class="bdshare_t bds_tools_32 get-codes-bdshare">
						<a class="bds_qzone"></a> <a class="bds_tsina"></a> <a
							class="bds_tqq"></a> <a class="bds_renren"></a> <span
							class="bds_more">更多</span> <a class="shareCount"></a>
					</div>
					<script type="text/javascript" id="bdshare_js" data="type=tools"></script>
					<script type="text/javascript" id="bdshell_js"></script>
					<script type="text/javascript">
						document.getElementById("bdshell_js").src =

						"http://bdimg.share.baidu.com/static/js/shell_v2.js?cdnversion="
								+ new Date().getHours();
					</script>
					<!-- Baidu Button END -->
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
					</p></li>
				<li><a href="index.jsp"><img src="images/italian.jpg"
						alt="Image" /> </a>
					<h2>
						<a href="index.jsp">Menu of the day: Italian</a>
					</h2>
					<p>
						Lorem ipsum dolor sit amet, consectetuer adispiscing elit, sed
						diam nonummy nibh euismod tincidunt ut laoreet. <a
							href="index.jsp" class="readmore">read more</a>
					</p></li>
				<li><a href="index.jsp"><img src="images/fruit.jpg"
						alt="Image" /> </a>
					<h2>
						<a href="index.jsp">Fruit menu for your diet</a>
					</h2>
					<p>
						Lorem ipsum dolor sit amet, consectetuer adispiscing elit, sed
						diam nonummy nibh euismod tincidunt ut laoreet. <a
							href="index.jsp" class="readmore">read more</a>
					</p></li>
				<li><a href="index.jsp"><img src="images/desserts.jpg"
						alt="Image" /> </a>
					<h2>
						<a href="index.jsp">Desserts for every occassion</a>
					</h2>
					<p>
						Lorem ipsum dolor sit amet, consectetuer adispiscing elit, sed
						diam nonummy nibh euismod tincidunt ut laoreet. <a
							href="index.jsp" class="readmore">read more</a>
					</p></li>
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
				<p>Copyright &copy; 2006-2008 cake delight All rights reserved</p>
			</div>
		</div>
	</div>
</body>
</html>
