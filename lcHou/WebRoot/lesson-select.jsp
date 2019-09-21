<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<html>
<head lang="en">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>北大青鸟晨练管理系统</title>
<link type="text/css" rel="stylesheet" href="css/style.css">
<link type="text/css" rel="stylesheet" href="css/public.css">
<link type="text/css" rel="stylesheet" href="css/WdatePicker.css">
<script></script>


<style>
#classtalk{
    background: url("images/yh.png") 0  center no-repeat;
}
#classtalk1{
    background: url("images/yh.png") 0  center no-repeat;
}

#interview{
    background: url("images/zd.png") 0  center no-repeat;
}
#look a{
color:black
}
#look1 a{
color:black
}
#insert a{
color:black
}
#insert1 a{
color:black
}	
</style>
</head>
<body style="position: static;">


	<c:if test="${clist eq null}">
		<script type="text/javascript">
			location.href = "lcServlet?op=toselect";
		</script>
	</c:if>

	<c:if test="${llist eq null}">
		<script type="text/javascript">
			location.href = "lcServlet?op=lessSelect";
		</script>
	</c:if>



	<header class="publicHeader">
		<h1>北大青鸟晨练管理系统</h1>
		<div class="publicHeaderR">
			<p>
				<span>下午好！</span><span style="color: #fff21b"> 系统管理员</span> , 欢迎你！
			</p>
			<a href="#">退出</a>
		</div>
		<style>
#fen {
	font-size: 15px;
	font-weight: normal;
}
</style>
	</header>
	<section class="publicTime">
		<span id="time">2018年07月25日&nbsp;14:37:22&nbsp;星期三</span> <a href="#">温馨提示：为了能正常浏览，请使用高版本浏览器！（IE10+）</a>
	</section>
	<!--主体内容-->
	<section class="publicMian ">
		<div class="left">
			<h2 class="leftH2">
				<span class="span1"></span>功能列表 <span></span>
			</h2>
			<nav>
				<ul class="list">
				  <li><a href="Classfen.jsp">班级管理</a></li>
				  <li><a href="teaFen.jsp">教师管理</a></li>
				  <li><a href="Stufen.jsp">学员管理</a></li>
				   <li><a href="memFen.jsp">晨练部管理</a></li>
				  <li id="classtalk"><a href="#">演讲课管理</a>  </li>
					<c:if test="${a.type==0}">
					
					<li class="sp" id="insert"><a href="#">添加</a></li>
					</c:if>
					<c:if test="${a.type==1}">			
					<li class="sp" id="look" ><a href="#">查看</a></li>
					
					</c:if>
				    <li id="classtalk1"><a href="#">演讲课排课</a></li>
					<li class="sp1" id="look1"><a href="#">查看</a></li>
					<li class="sp1" id="insert1"><a href="#">添加</a></li>

				  <li id="interview"><a href="#">模拟面试管理</a></li>
				  <c:if test="${a.type==0}">
				  <li id="insert" class="inter"   onclick="insert(${ memberAll.id})"><a href="#">添加</a> </li>				  
				  </c:if>
				  
				    <c:if test="${ a.type==1 }">
                 <li id="look" class="inter"  onclick="look(${ teacherAll.id })"><a href="#">查看</a></li>
				  </c:if>
				    
					 
				 </ul>
			</nav>
		</div>
		<input type="hidden" id="path" name="path" value=""> <input
			type="hidden" id="referer" name="referer" value="">
		<div class="right" style="margin-top: 13px;width: 800px;margin-left: 70px">
			<div class="location">
				<strong>你现在所在的位置是:</strong> <span>排課页面</span>
			</div>
			<p style="font-size: 15px;color: blue;margin: 13px">徐 州 中 博 演 讲
				排 課 信 息</p>
			<!--用户-->

			<table class="providerTable" cellpadding="0" cellspacing="0">
				<tbody>
					<tr class="firstTr" style="background-color: rgb(170,209,242);font-size: 12px">
						<td>班级</td>
						<td>星期</td>
						<td>上/下午</td>
						<td>课节</td>
						<td>负责人</td>
					</tr>
					<c:forEach items="${llist}" var="e">
						<c:if test="${ memberAll.id eq e.member.id }">

							<tr style="font-size: 12px;background-color: yellow">
								<td>${e.class1.classname}</td>
								<td>${e.week}</td>
								<td><c:if test="${e.none==0}">上午</c:if> <c:if
										test="${e.none==1}">下午</c:if></td>
								<td>${e.lesson}</td>
								<td>${e.member.name}</td>
							</tr>
						</c:if>


						<c:if test="${ memberAll.id ne e.member.id }">

							<tr style="font-size: 12px;">
								<td>${e.class1.classname}</td>
								<td>${e.week}</td>
								<td><c:if test="${e.none==0}">上午</c:if> <c:if
										test="${e.none==1}">下午</c:if></td>
								<td>${e.lesson}</td>
								<td>${e.member.name}</td>
							</tr>
						</c:if>
					</c:forEach>
				</tbody>
				
			</table>
<p style="font-size: 12px;color: red; margin:20px ">漂黄为当前登录部员的任务浏览</p>
			<input type="hidden" id="totalPageCount" value="5">
			<script type="text/javascript">
				
			</script>
			<script type="text/javascript" src="js/rollpage.js"></script>

		</div>
	</section>



	<footer class="footer"> 版权归北大青鸟 </footer>
	<script type="text/javascript" src="js/time.js"></script>
	<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
	<script type="text/javascript" src="js/common.js"></script>
	<script type="text/javascript" src="js/WdatePicker.js"></script>
	<script type="text/javascript" src="js/userlist.js"></script>

	<div
		style="position: absolute; z-index: 19700; top: -1970px; left: -1970px;">
		<iframe style="width: 186px; height: 198px;"
			src="./超市订单管理系统_files/My97DatePicker.html" frameborder="0" border="0"
			scrolling="no"></iframe>
	</div>
	<div>
		<object id="ClCache" click="sendMsg" host="" width="0" height="0"></object>
	</div>
	<div id="yddWrapper" tag-info="这是有道词典 “Chrome 划词扩展 V3” 插入的节点"
		draggable="true" style="left: 945px; top: 440px;"></div>
	<template id="yodaoDictPanel" tag-info="这是有道词典 “Chrome 划词扩展 V3” 插入的节点"></template>
</body>
</html>


<script src="jquery-1.12.4.js"></script>
<script type="text/javascript">
	$(function() {
		$("#none").bind(
				"change",
				function() {
					var id = $("#none").val();
					$.getJSON("lcServlet", "op=meminfo&id=" + id,
							function(data) {
								$("#memberid option:not(:first)").remove();
								for (var i = 0; i < data.length; i++) {
									$("#memberid").append(
											"<option value='"+data[i].id+"'>"
													+ data[i].name);
								}
							});
				});

		//页面

		$(function() {
			$(".inter").hide();
			$("#interview").click(function() {
				$(".inter").toggle();

			});

			$(".sp").hide();
			$("#classtalk").click(function() {
				$(".sp").toggle();
			});

			$(".sp1").hide();
			$("#classtalk1").click(function() {
				$(".sp1").toggle();
			});

			$("#look").click(function() {
				location.href = "lcServlet?op=talktoinsert&va=1&id=1";

			});
			$("#insert").click(function() {
				location.href = "lcServlet?op=talktoinsert&va=2";

			});

			$("#look1").click(function() {
				location.href = "lesson-select.jsp";

			});
			$("#insert1").click(function() {
				location.href = "lesson-insert.jsp";

			});

		});

		function insert(mem) {
			alert(mem);
			location.href = "iServlets?op=to&index=1&mem=" + mem;
		}

		function look(id) {
			location.href = "iServlets?op=selectNow&id=" + id;
		}
	});
</script>
