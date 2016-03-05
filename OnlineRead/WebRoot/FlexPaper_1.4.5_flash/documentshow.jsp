<span style="color:#009900;">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>


<title>文档显示页面</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
22 <link rel="stylesheet" type="text/css" href="styles.css">
23 -->
<style type="text/css" media="screen">
html,body {
	height: 100%;
}

body {
	margin: 0;
	padding: 0;
	overflow: auto;
}

#flashContent {
	display: none;
}
</style>

<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/flexpaper_flash.js">
 </script>
</head>

<body>
	<div>
		<br /> <Br /> <br />
	</div>
	<div style="position:absolute;left:200px;top:10px;">
		<a id="viewerPlaceHolder"
			style="width:650px;height:700px;display:block"></a>

		<script type="text/javascript">
				 var fp = new FlexPaperViewer(
				 'FlexPaperViewer',
				 'viewerPlaceHolder', { config : {
				 SwfFile : escape('http://localhost:8080/OnlineRead/FlexPaper_1.4.5_flash/Paper.swf'),
				 Scale : 0.8,
				 ZoomTransition : 'easeOut',
				 ZoomTime : 0.5,
				 ZoomInterval : 0.2,
				 FitPageOnLoad : true,
				 FitWidthOnLoad : false,
				 PrintEnabled : false,
				 FullScreenAsMaxWindow : false,
				 ProgressiveLoading : true,
				 MinZoomSize : 0.2,
				 MaxZoomSize : 5,
				 SearchMatchAll : false,
				 InitViewMode : 'Portrait',
				 ViewModeToolsVisible : true,
				 ZoomToolsVisible : true,
				 NavToolsVisible : true,
				 CursorToolsVisible : true,
				 SearchToolsVisible : true,
				
				 localeChain: 'zh_CN'
 }});
 </script>
	</div>
</body>
</html>
</span>