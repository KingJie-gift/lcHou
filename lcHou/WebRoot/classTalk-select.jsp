<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head lang="en">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>北大青鸟晨练管理系统</title>
<link type="text/css" rel="stylesheet" href="css/style.css">
<link type="text/css" rel="stylesheet" href="css/public.css">
<link type="text/css" rel="stylesheet" href="css/WdatePicker.css">
<script></script>
 

<c:if test="${pa eq null}">
	<script>
		location.href = "lcServlet?op=select&index=1";
	</script>
</c:if>
<body style="position: static;">

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
	<header class="publicHeader">
	<h1>北大青鸟晨练管理系统</h1>
	<div class="publicHeaderR">
		<p>
			<span>下午好！</span><span style="color: #fff21b"> 系统管理员</span> , 欢迎你！
		</p>
		<a href="#">退出</a>
	</div>
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
	<input type="hidden" id="path" name="path" value=""> <input
		type="hidden" id="referer" name="referer" value="">
	<div class="right">
		<div class="location">
			<strong>你现在所在的位置是:</strong> <span>用户管理页面</span>
		</div>
		<div class="search">
			<form action="lcServlet?op=select&id=${c.classid}&index=1"
				method="post">
				<select name="week">
					<option value="-1">请选择</option>
					<option value="1" <c:if test="${week eq '1'}">selected</c:if>>一周</option>
					<option value="2" <c:if test="${week eq '2'}">selected</c:if>>两周</option>
					<option value="3" <c:if test="${week eq '3'}">selected</c:if>>一月</option>
				</select> <input type="submit" value="查询">
			</form>
		</div>
		<!--用户-->
		<table class="providerTable" cellpadding="0" cellspacing="0" style="width: 1000px;margin-left: 10px">
			<tbody >
				<tr class="firstTr" style="background-color: rgb(170,209,242);font-size: 12px;">
					 
					<td>名字</td>
					 
					<td>演讲时间</td>
					<td>台风</td>
					<td>流畅性</td>
					<td>互动性</td>
					<td>内容</td>
					<td>总分</td>
					<td>评价</td>
					<td>日期</td>
					<td>评价者</td>
				</tr>

				<c:forEach items="${pa.list}" var="c">
					<tr style="font-size: 13px"> 
					 
						<td id="zhe"><a
							href="lcServlet?op=selectName&name=${c.sname}">${c.sname}</a></td>
						 
						<td>${c.time}</td>
						<td>${c.taifeng}</td>
						<td>${c.smooth}</td>
						<td>${c.active}</td>
						<td>${c.content}</td>
						<td>${c.sum}</td>
						<td>${c.evaluate}</td>
						<td>${c.talktime}</td>
						<td>${c.member1.name}</td>
					</tr>
				</c:forEach>


			</tbody>
		</table>

		<input type="hidden" id="totalPageCount" value="5">
		<script type="text/javascript">
			
		</script>
		<div class="page-bar">
			<ul class="page-num-ul clearfix">
				<a href="lcServlet?op=select&index=1&id=${c.classid}&week=${week}">首页</a>
				<a
					href="lcServlet?op=select&index=${pa.pageIndex-1}&id=${c.classid}&week=${week}">上一页</a>
				<a
					href="lcServlet?op=select&index=${pa.pageIndex+1}&id=${c.classid}&week=${week}">下一页</a>
				<a
					href="lcServlet?op=select&index=${pa.pageCount}&id=${c.classid}&week=${week}">尾页</a>
				&nbsp;&nbsp;
			</ul>


			<script type="text/javascript" src="js/rollpage.js"></script>

		</div>
	</section>

	<!--点击删除按钮后弹出的页面-->
	<div class="zhezhao"></div>
	<div class="remove" id="removeUse">
		<div class="removerChid">
			<h2>提示</h2>
			<div class="removeMain">
				<p>你确定要删除该用户吗？</p>
				<a href="javascript:;" id="yes">确定</a> <a href="javascript:;"
					id="no">取消</a>
			</div>
		</div>
	</div>

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
		$(".inter").hide();
		$("#interview").click(function(){
			$(".inter").toggle();
			
		});
		function insert(mem) {
			alert(mem);
			location.href = "iServlets?op=to&index=1&mem="+mem;
		}

		function look(id) {
			location.href = "iServlets?op=selectNow&id="+id;
		}
		
		
		$(".sp").hide();
		$("#classtalk").click(function() {
			$(".sp").toggle();
		})
		$(".sp1").hide();
		$("#classtalk1").click(function() {
			$(".sp1").toggle();
		})

		$("#look").click(function() {
			location.href = "lcServlet?op=talktoinsert&va=1&id=1";

		})
		$("#insert").click(function() {
			location.href = "lcServlet?op=talktoinsert&va=2";

		})
		$("#look1").click(function() {
			location.href = "lesson-select.jsp";

		})
		$("#insert1").click(function() {
			location.href = "lesson.insert.jsp";

		})
	})
</script>
