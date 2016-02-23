<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" type="text/css" href="css/style.css" />
<script src="http://libs.baidu.com/jquery/1.9.0/jquery.js"></script>
  </head>
  
  <body>
    <div id="header">
  <div>
    <div>
      <div id="logo"> <a href="index.jsp"><img src="images/logo.gif" alt="Logo"/></a> </div>
      <div>
	  <marquee align="absbottom" >好消息，好消息....客家美天有新的糕点推出来，敬请期待新的产品2015-2-15。</marquee>
        <div> <a href="view/signin.jsp">我的账户</a> <a href="view/blog.jsp">帮助</a> <a href="view/signin.jsp" class="last">登入</a> </div>
        <form action="#">
          <input type="text" id="search" maxlength="30" />
          <input type="submit" value="" id="searchbtn" />
        </form>
      </div>
    </div>
   <ul>
			<li ><a href="index.jsp">首页</a></li>
      <li class="current"><a href="ProductServlet?operate=manageProduct4">特色糕饼</a></li>
      <li><a href="view/about.jsp">关于我们+团队文化</a></li>
      <li><a href="view/services.jsp">创业道路and店面介绍</a></li>
      <li><a href="view/blog.jsp">基本信息</a></li>
      <li><a href="MessageServlet?operate=manageMessage1">游客留言</a></li>
			</ul>
    <div class="section"> <a href="index.jsp"><img src="images/wedding-cupcakes-small.jpg" alt="Image"/></a> </div>
  </div>
</div>
<div id="content">
  <div>
    <div id="account">
      <div>
        <form action="#">
          <span>SIGN-UP</span>
          <table>
            <tr>
              <td><label for="email">E-mail</label></td>
              <td><input type="text" id="email" /></td>
            </tr>
            <tr>
              <td><label for="login">账号</label></td>
              <td><input type="text" id="login" /></td>
            </tr>
            <tr>
              <td><label for="password">密码</label></td>
              <td><input type="text" id="password" /></td>
            </tr>
            <tr>
              <td><label for="confirmpass">确认<br />
                密码</label></td>
              <td><input type="text" id="confirmpass" /></td>
            </tr>
            <tr>
              <td></td>
              <td class="rememberme"><label for="rememberme">
                <input type="checkbox" id="rememberme" />
                Remember me on this computer</label></td>
            </tr>
          </table>
          <input type="submit" value="Sign-up" class="submitbtn" />
        </form>
      </div>
    </div>
  </div>
</div>
<div id="footer">
  <div class="section">
    <div>
      <div class="aside">
        <div>
          <div> <b>Too <span>BUSY</span> to shop?</b> <a href="signin.jsp">Sign up for free</a>
            <p>and we&#39;ll deliver it on your doorstep</p>
          </div>
        </div>
      </div>
      <div class="connect"> <span>分享链接</span>
        <!-- Baidu Button BEGIN -->
        <div id="bdshare"
										class="bdshare_t bds_tools_32 get-codes-bdshare"> <a class="bds_qzone"></a> <a class="bds_tsina"></a> <a
											class="bds_tqq"></a> <a class="bds_renren"></a> <span
											class="bds_more">更多</span> <a class="shareCount"></a> </div>
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
      <li class="first"> <a href="index.jsp"><img src="images/fruit-cake.jpg" alt="Image" /></a>
        <h2><a href="index.jsp">Tips on how to preserve</a></h2>
        <p>Lorem ipsum dolor sit amet, consectetuer adispiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet. <a href="index.jsp" class="readmore">read more</a></p>
      </li>
      <li> <a href="index.jsp"><img src="images/italian.jpg" alt="Image" /></a>
        <h2><a href="index.jsp">Menu of the day: Italian</a></h2>
        <p>Lorem ipsum dolor sit amet, consectetuer adispiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet. <a href="index.jsp" class="readmore">read more</a></p>
      </li>
      <li> <a href="index.jsp"><img src="images/fruit.jpg" alt="Image" /></a>
        <h2><a href="index.jsp">Fruit menu for your diet</a></h2>
        <p>Lorem ipsum dolor sit amet, consectetuer adispiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet. <a href="index.jsp" class="readmore">read more</a></p>
      </li>
      <li> <a href="index.jsp"><img src="images/desserts.jpg" alt="Image" /></a>
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
