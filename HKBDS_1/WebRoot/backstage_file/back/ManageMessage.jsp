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
	background:#FFF
}
</style>
  </head>
  
  <body>
   <div id="contentWrap">
  <div class="pageTitle">
    <h1>用户信息操作：</h1>
  </div>
  
<form action="MessageServlet?operate=manageMessage3" onSubmit="return check()" method="post" >
   
  <div class="pageColumn">
    <div class="pageButton"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        
        <input type="text" name="querymessage" placeholder="请输入关键字" style="width:150px; height:30px; border-color:#00F; border:1px solid #F00;" />
        &nbsp;&nbsp;&nbsp;
        <input type="submit" value="查询" style="border:1px solid #00F; width:40px;" />
      </form>
    </div>
    <table>
      <thead>
      <th width="5%"><input name="" type="checkbox" value="" /></th>
        <th width="10%">游客名称</th>
        <th width="10%">留言标题</th>
        <th width="10%">用户邮箱</th>
        <th width="20%">地址</th>
        <th width="30%">留言内容</th>
        <th width="10%">留言时间</th>
        <th width="10%">操作</th>
        </thead>
      <tbody>
      <c:forEach var="entry" items="${messagelist}">
        <tr>
          <td class="checkBox"><input name="" type="checkbox" value="" /></td>
          <td><c:out value="${entry.m_name }"/></td>
          <td><c:out value="${entry.m_item }"/></td>
          <td><c:out value="${entry.m_emil }"/></td>
          <td><c:out value="${entry.m_address }"/></td>
          <td><c:out value="${entry.m_message }"/></td>
          <td><c:out value="${entry.m_date }"/></td>
          <td><a href="MessageServlet?operate=deleteMessage&id=${entry.m_id }">删除</a></td>
        </tr>
        </c:forEach>
      </tbody>
    </table>
    
  </div>
</div>
<div class="scott"><span class="disabled"> < </span><span class="current">1</span><a href="#">2</a><a href="#">3</a><a href="#">4</a><a href="#">5</a><a href="#">6</a><a href="#">7</a>...<a href="#">199</a><a href="#">200</a><a href="#"> > </a></div>
  </body>
</html>
