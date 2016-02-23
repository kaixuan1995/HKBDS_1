<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
	<script charset="GBK" language="javascript"  type="text/javascript" src="./js/productcheck.js"></script>
<style type="text/css">
body {
	background:#FFF
}
</style>
  </head>
  
  <body>
  <input type="hidden" id="msg" value="${requestScope.exceptionInfo }" />
   <div id="contentWrap">
  <div class="pageTitle">
    <h1>修改产品：</h1>
  </div>
  <div class="pageColumn">
    <div class="pageButton"> </div>
    <center>
      <form action="ProductServlet?operate=updateProduct&id=${flag.p_id }" name="updateProduct" method="post" enctype="multipart/form-data" onSubmit="return check()">
        <table border="1" style="width:800px;">
          <tr>
            <td width="20%" style="text-align:right;">产&nbsp;&nbsp;品&nbsp;&nbsp;名&nbsp;&nbsp;称：</td>
            <td width="40%" style="text-align:left;"><input type="text" style="border:1px solid #03F; width:260px;" name="p_name" value="${flag.p_name}"/></td>
          </tr>
		  
		   <tr>
            <td width="20%" style="text-align:right;">产&nbsp;&nbsp;品&nbsp;&nbsp;图&nbsp;&nbsp;片：</td>
            <td width="40%" style="text-align:left;"><img src="backstage_file/images/cake.jpg" style="width: 260px; height: 29px"/><br /><input type="file" style="border:1px solid #03F; width:260px;"name="p_image" /></td>
          </tr>
		  
          <tr>
            <td></td>
            <td></td>
          </tr>
          <tr>
            <td width="20%" style="height:100px;text-align:right;">产品详解：</td>
            <td width="40%" style="text-align:left;"><textarea cols="40" rows="5" style="border:1px solid #03F;" name="p_content" >${flag.p_content}</textarea></td>
          </tr>
          <tr>
            <td width="20%" style="text-align:right;">产&nbsp;&nbsp;品&nbsp;&nbsp;价&nbsp;&nbsp;格：</td>
            <td width="40%" style="text-align:left;"><input type="text" style="border:1px solid #03F; width:260px;" name="p_price" value="${flag.p_price}"/></td>
          </tr>
          <tr>
            <td width="20%" style="text-align:right;">产&nbsp;&nbsp;品&nbsp;&nbsp;类&nbsp;&nbsp;型：</td>
            <td width="40%" style="text-align:left;"><select name="p_category" style="border:1px solid #03F; width:260px;">
                <option value="礼品类">礼品类</option>
                <option value="饼类">饼类</option>
                <option value="蛋糕西饼类">蛋糕西饼类</option>
                <option value="烘焙原材料类">烘焙原材料类</option>
                <option value="烘焙工具类">烘焙工具类</option>
              </select>
            </td>
          </tr>
          <tr>
            <td></td>
            <td style="text-align:left;"><input type="submit" value="确定" style="border:1px solid #03F; width:60px;"/>
              &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
              <input type="reset" value="重置" style="border:1px solid #03F; width:60px;"/>
            </td>
          </tr>
        </table>
      </form>
    </center>
  </div>
</div>
  </body>
</html>
