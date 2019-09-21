<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
<head lang="en">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>徐州中博晨练管理系统</title>
<link type="text/css" rel="stylesheet" href="css/style.css">
<link type="text/css" rel="stylesheet" href="css/public.css">
<link type="text/css" rel="stylesheet" href="css/WdatePicker.css">
<script></script>

</head>


<body style="position: static;">
	<!--头部-->
	<header class="publicHeader">
	<h1>北大青鸟晨练管理系统</h1>
	<div class="publicHeaderR">
		<p>
			<span>下午好！</span><span style="color: #fff21b"> 系统管理员</span> , 欢迎你！
		</p>
		<a href="#">退出</a>
	</div>
	<style>
#ff {
	font-size: 20px;
	text-align: center
}

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
	</header>
	<!--时间-->
	<section class="publicTime"> <span id="time">2018年07月25日&nbsp;14:37:22&nbsp;星期三</span>
	<a href="#">温馨提示：为了能正常浏览，请使用高版本浏览器！（IE10+）</a> </section>
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

	<div style="width: 1000px">
		<div id="ff">请选择你要操作的班级</div>
		<c:forEach items="${clist}" var="c">
			<span><input type="hidden" name="id" value="${c.classid}">
				<input type="button" name="cname" value="${c.classname}"
				onclick="ser(${c.classid},${va})"
				style="width: 100px; height: 45px;margin:50px;background-color: rgb(170,209,242)"">
			</span>
		</c:forEach>
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
<script>
	$(function() {

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
	function ser(id, t) {
		if (t == 1) {
			location.href = "lcServlet?op=select&index=1&id=" + id;
		} else {
			location.href = "lcServlet?op=selectToinsert&id=" + id;
		}
	}
</script>