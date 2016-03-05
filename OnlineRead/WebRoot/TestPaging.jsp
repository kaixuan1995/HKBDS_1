<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'TestPaging.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <script src=http://code.jquery.com/jquery-1.7.2.min.js></script>

<script>
$('textarea').live('keyup change',function(e){
	var i = 0,
		of = '',
		src = this.value;
	while(this.clientHeight<this.scrollHeight){
		this.value = src.slice(0,-(++i));
	}
	of = src.slice(-i).replace(/^[\r\n]*/,'');
	if(i){
		if($(this).next('textarea')[0]){
			$(this).next('textarea').val(of+"\n"+$(this).next('textarea').val());
		}else{
			$(this).clone().insertAfter(this).val(of);
		}
		$(this).next('textarea').change();
	}
});
</script>
  <body>
    <textarea cols=100 rows=100></textarea>
    <a href="d:\resource\一个PS进阶的教程_对新手老手都有帮助.html">21</a>
  </body>
</html>
