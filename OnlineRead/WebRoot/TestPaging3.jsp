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
<base href="<%=basePath%>">

<title>My JSP 'TestPaging3.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
	<TABLE cellSpacing=1 cellPadding=5 width="95%" align=center border=0>
					
<script type="text/javascript">

	//每页显示字数
	PageSize = 1000;
	//分页模式
	flag = 1;//1:根据字数自动分页 2:根据[NextPage]分页
	//默认页
	startpage = 1;
	//导航显示样式 0:常规 1:直接 3:下拉
	TopShowStyle = 1;
	DownShowStyle = 0;

	var currentSet, CutFlag, TotalByte, PageCount, key, tempText, tempPage;
	key = "";
	currentSet = 0;
	var Text = xmlArticle.selectSingleNode("//Content").text;
	TotalByte = Text.length;

	if (flag == 1) {
		PageCount = Math.round(TotalByte / PageSize);
		if (parseFloat("0." + TotalByte % PageSize) > 0) {
			if (parseFloat("0." + TotalByte % PageSize) < 0.5) {
				PageCount = PageCount + 1;
			}
		}
		var PageNum = new Array(PageCount + 1);
		var PageTitle = new Array(PageCount + 1);
		PageNum[0] = 0;
		PageTitle[0] = "";

		var sDrv1, sDrv2, sDrv3, sDrv4, sFlag;
		var sDrvL, sTemL;
		var sTem1, sTem2, k;
		sFlag = 0;

		for (j = 1; j < PageCount + 1; j++) {
			PageNum[j] = PageNum[j - 1] + PageSize;
			PageTitle[j] = "";
			//alert(j);
			sDrv1 = "<br>";
			sDrv2 = "<BR>";
			sDrv3 = "<Br>";
			sDrv4 = "<bR>";
			sDrvL = sDrv1.length;
			for (k = PageNum[j]; k <= TotalByte; k++) {
				sTem1 = Text.substring(PageNum[j] - sDrvL, k);
				sTemL = sTem1.length;
				sTem2 = sTem1.substring(sTemL - sDrvL, sTemL)
				if (sTem2 == sDrv1 || sTem2 == sDrv2 || sTem2 == sDrv3
						|| sTem2 == sDrv4) {
					sFlag = sFlag + 1;
					PageNum[j] = k;
					break;
				}
			}
			if (PageNum[j] > TotalByte) {
				break;
			}
		}
		if (j < PageCount) {
			PageNum.length = j;
			PageCount = j
		}
		if (PageCount > 1 && sFlag > 1 && PageCount < sFlag) {
			PageCount = sFlag + 1;
		}
	}

	function text_pagination(Page) {
		var Output, Byte;

		if (Page == null) {
			Page = 1;
		}

		Output = "";
		Output = Output
				+ "<table width=100% height=30 border=0 align=center cellpadding=0 cellspacing=0>";
		Output = Output + "<tr>";
		Output = Output + "<td height=1 background=Images/DotLine.gif></td>";
		Output = Output + "</tr>";

		//头部功能导航条
		Output = Output + "<tr>";

		//正文查找

		Output = Output + "<td align=right>";

		//页码显示方式一
		//第x页：分页标题
		if (Page == 0 || PageCount == 0) {
			Output = Output + "当前是：<font color=red>全文显示</font>";
		} else {
			if (TotalByte > PageSize) {
				Byte = PageNum[Page] - PageNum[Page - 1]
			} else {
				Byte = TotalByte
			}
			;
			if (TotalByte > PageSize) {
				Output = Output + "第 <font color=red>" + Page + "</font> 页";
			}
			if (PageTitle[Page] != "") {
				Output = Output + "：<font color=800000>" + PageTitle[Page]
						+ "</font>";
			}
			Output += '&nbsp;';
		}

		//显示方式二
		//下拉菜单选择
		//if (PageCount>0)
		//{
		// Output=Output+Article_PageNav(2,Page);
		// Output=Output+"&nbsp;</td>";
		//}

		//显示方式三
		//页码选择列表
		//Output=Output+"<td align=right bgcolor=#f0faff>";
		//Output=Output+Article_PageNav(0,Page);
		//Output=Output+"</td>";

		Output = Output + "</tr>";
		Output = Output + "<tr>";
		Output = Output + "<td height=1 background=Images/DotLine.gif></td>";
		Output = Output + "</tr>";
		Output = Output + "</table>";

		//显示正文
		if (Page == 0) {
			//不分页
			tempText = Text;
		} else {
			//分页
			if (flag == 1)
			//自动分页
			{
				tempText = Text.substring(PageNum[Page - 1], PageNum[Page]);
			} else {
				//手动分页
				if (PageTitle[Page - 1].length == 0) {
					tempText = Text.substring(PageNum[Page - 1] + 10,
							PageNum[Page]);
				} else {
					tempText = Text.substring(PageNum[Page - 1] + 11
							+ PageTitle[Page - 1].length, PageNum[Page]);
				}
			}
		}

		//布置内容
		Output = Output + "<div align=center>";
		Output = Output + Article_PageNav(TopShowStyle, Page);
		Output = Output + "</div>";

		Output = Output + "<div id=world>";
		Output = Output + tempText;
		Output = Output + "</div>";
		Output = Output + "<br>";

		Output = Output + "<div align=center>";
		Output = Output + Article_PageNav(DownShowStyle, Page);
		Output = Output + "</div>";

		article.innerHTML = Output;
		if (Page > 1) {
			document.location.href = '#top';
		}

		eval_r(document.all.keys).value = key;
		if (key != "") {
			searchkey();
		}
	}

	function Article_PageNav(ShowStyle, Page) {
		//分页码显示函数
		//参数为调用样式，0=简单样式，1=标准样式
		var temp = "";

		if (ShowStyle == 0)
		//简单样式
		{
			tempPage = Page;
			if (TotalByte > PageSize) {
				if (Page - 4 <= 1) {
					temp = temp + "<font face=webdings color=#999999>9</font>";
					if (Page <= 1) {
						temp = temp
								+ "<font face=webdings color=#999999>7</font>";
					} else {
						temp = temp + "<a href=javascript:text_pagination("
								+ (Page - 1)
								+ ")><font face=webdings>7</font></a>";
					}
					if (PageCount > 10) {
						for (i = 1; i < 8; i++) {
							if (i == Page) {
								temp = temp + "<font color=red>" + i
										+ "</font> ";
							} else {
								temp = temp
										+ "<a href=javascript:text_pagination("
										+ i + ") >" + i + "</a>" + " ";
							}
						}
						temp = temp + " ...";
					} else {
						for (i = 1; i < PageCount + 1; i++) {
							if (i == Page) {
								temp = temp + "<font color=red>" + i
										+ "</font> ";
							} else {
								temp = temp
										+ "<a href=javascript:text_pagination("
										+ i + ") >" + i + "</a>" + " ";
							}
						}
					}

					if (Page == PageCount) {
						temp = temp
								+ "<font face=webdings color=#999999>8</font>";
					} else {
						temp = temp + "<a href=javascript:text_pagination("
								+ (Page + 1)
								+ ")><font face=webdings>8</font></a>";
					}
					if (PageCount < 10) {
						temp = temp
								+ "<font face=webdings color=#999999>:</font>";
					} else {
						temp = temp + "<a href=javascript:text_pagination("
								+ PageCount
								+ ")><font face=webdings>:</font></a>";
					}
				} else if (Page + 4 <= PageCount) {
					temp = temp
							+ "<a href=javascript:text_pagination(1)><font face=webdings>9</font></a>";
					temp = temp + "<a href=javascript:text_pagination("
							+ (Page - 1) + ")><font face=webdings>7</font></a>";
					if (PageCount > 10) {
						temp = temp + "..";
						for (i = Page - 4; i < Page + 4; i++) {
							if (i == Page) {
								temp = temp + "<font color=red>" + i
										+ "</font> ";
							} else {
								temp = temp
										+ "<a href=javascript:text_pagination("
										+ i + ") >" + i + "</a>" + " ";
							}
						}

						temp = temp + " ..";
					} else {
						for (i = 1; i < PageCount + 1; i++) {
							if (i == Page) {
								temp = temp + "<font color=red>" + i
										+ "</font> ";
							} else {
								temp = temp
										+ "<a href=javascript:text_pagination("
										+ i + ") >" + i + "</a>" + " ";
							}
						}
					}

					if (Page == PageCount) {
						temp = temp
								+ "<font face=webdings color=#999999>8</font>";
					} else {
						temp = temp + "<a href=javascript:text_pagination("
								+ (Page + 1)
								+ ")><font face=webdings>8</font></a>";
					}
					temp = temp + "<a href=javascript:text_pagination("
							+ PageCount + ")><font face=webdings>:</font></a>";

				} else {
					temp = temp
							+ "<a href=javascript:text_pagination(1)><font face=webdings>9</font></a>";
					temp = temp + "<a href=javascript:text_pagination("
							+ (Page - 1) + ")><font face=webdings>7</font></a>";
					temp = temp + ".."

					for (i = Page - 2; i < PageCount + 1; i++) {
						if (i == Page) {
							temp = temp + "<font color=red>" + i + "</font> ";
						} else {
							temp = temp + "<a href=javascript:text_pagination("
									+ i + ") >" + i + "</a>" + " ";
						}
					}

					if (Page == PageCount) {
						temp = temp
								+ "<font face=webdings color=#999999>8</font>";
					} else {
						temp = temp + "<a href=javascript:text_pagination("
								+ (Page + 1)
								+ ")><font face=webdings>8</font></a>";
					}
					temp = temp + "<font face=webdings color=#999999>:</font>";
				}
			} else {
				if (TotalByte > PageSize) {
					temp = temp + "<font color=red>1</font> ";
				}
			}
			if (TotalByte > PageSize) {
				temp = temp + " <a href=javascript:text_pagination(0)>显示全部</a>"
			}
		} else if (ShowStyle == 1)
		//标准样式
		{
			if (TotalByte > PageSize) {
				if (Page != 0) {
					if (Page != 1) {
						temp = temp
								+ "<a href='#top' onclick=javascript:text_pagination("
								+ (Page - 1)
								+ ")><font color=3366cc>[上一页]</font></a>&nbsp;&nbsp;";
					}
				}
			}
			for (i = 1; i < PageCount + 1; i++) {
				if (Page == i) {
					if (Page != PageCount) {
						temp = temp + "<font color=800000>[" + i
								+ "]</font>&nbsp;&nbsp;";
					}
				} else {
					temp = temp
							+ "<a href='#top' onclick=javascript:text_pagination("
							+ i + ")><font color=3366cc>[" + i
							+ "]</font></a>&nbsp;&nbsp;";
				}
			}
			temp = temp + "<a name='foot'></a>";
			if (TotalByte > PageSize) {
				if (Page != 0) {
					if (Page != PageCount) {
						temp = temp
								+ "<a href='#top' onclick=javascript:text_pagination("
								+ (Page + 1)
								+ ")><font color=3366cc>[下一页]</font></a>  <a href=javascript:text_pagination(0)><font color=3366cc>显示全部</font></a>";
					}
				}
			}

		}

		return (temp);
	}

	//默认页
	text_pagination(startpage);

</script>

				</TABLE>
</body>
</html>
