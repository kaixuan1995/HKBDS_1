<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style type="text/css">
<!--
font{
	font-size:1px;
}
-->
</style>
<font>
 当前第[${page.pageNum }]页
    
    <c:if test="${page.pageNum>1}">
    <a href="${page.url }?operate=manageMessage1&pagenum=${page.pageNum-1 }">上一页</a>
    </c:if>
   
	<c:forEach var="pageNum" begin="${page.startPage}" end="${page.endPage}">
		[<a href="${page.url }?operate=manageMessage1&pagenum=${pageNum}">${pageNum }</a>]
	</c:forEach>  
	
	<c:if test="${page.pageNum<page.totalPage}">
	<a href="${page.url }?operate=manageMessage1&pagenum=${page.pageNum+1 }">下一页</a>
	</c:if>
	
	共[${page.totalPage }]页,共[${page.totalRecord}]纪录,
	
	<input type="text" style="width: 30px" id="pageNum">
	<input type="button" value=" GO " onclick="goWhich(document.getElementById('pageNum'))">
</font>
	<script type="text/javascript">
		function goWhich(input){
			var pageNum = input.value;
			if(pageNum==null || pageNum==""){
				alert("请输入页码！");
				return;
			}
			
			if(!pageNum.match("\\d+")){
				alert("请输入数字！");
				input.value="";
				return;
			}
			
			if(pageNum<1 || pageNum>${page.totalPage}){
				alert("无效的页码！");
				input.value="";
				return;
			}
			window.location.href="${page.url }?operate=manageMessage1&pagenum=" + pageNum;
		}
		
		
	</script>
