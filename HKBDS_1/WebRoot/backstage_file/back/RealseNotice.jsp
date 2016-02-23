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
<style type="text/css">
body {
	background: #FFF
}
</style>
<script language="javascript">
function check(){
	if(relaseNotice.n_item.value==""){
		alert("公告标题不能为空！");relaseNotice.n_item.focus();return false;	
	}else if(relaseNotice.notice.value==""){
		alert("公告内容不能为空！");relaseNotice.notice.focus();return false;
	}else{
	return true;
	}
}
</script>
<script src="backstage_file/javascript/check.js"></script>
</head>

<body>
<input type="hidden" id="msg" value="${requestScope.exceptionInfo }" />
	<div id="contentWrap">
		<div class="pageTitle">
			<h1>发布公告：</h1>
		</div>
		<div class="pageColumn">
			<div class="pageButton"></div>
			<center>
				<form action="NoticeServlet?operate=relaseNotice" name="relaseNotice" onSubmit="return check()" method="post">
					<table border="1" style="width:800px;">
						<tr>
							<td width="20%" style="text-align:right;">公&nbsp;&nbsp;告&nbsp;&nbsp;标&nbsp;&nbsp;题：</td>
							<td width="40%" style="text-align:left;"><input type="text"
								style="border:1px solid #03F; width:260px;" name="n_item" />
							</td>
						</tr>
						<tr>
							<td></td>
							<td></td>
						</tr>
						<tr>
							<td width="20%" style="height:100px;text-align:right;">公告内容：</td>
							<td width="40%" style="text-align:left;"><textarea cols="40"
									rows="5" style="border:1px solid #03F;" name="notice"></textarea>
							</td>
						</tr>
						<tr>
							<td></td>
							<td style="text-align:left;"><input type="submit" value="确定"
								style="border:1px solid #03F; width:60px;" />
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<input type="reset" value="重置"
								style="border:1px solid #03F; width:60px;" /></td>
						</tr>
					</table>
				</form>
			</center>
		</div>
	</div>
</body>
</html>
