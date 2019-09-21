<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<html>
<head lang="en">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>北大青鸟晨练管理系统</title>
<link type="text/css" rel="stylesheet" href="css/style.css">
<link type="text/css" rel="stylesheet" href="css/public.css">
<link type="text/css" rel="stylesheet" href="css/WdatePicker.css">

<c:if test="${list eq null }">
<script>
location.href="lcServlet?op=selectToinsert";
</script>
</c:if>
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
	#cname{
	text-align:center
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
	<div class="right">
		<div class="location">
			<strong>你现在所在的位置是:</strong> <span>用户管理页面</span>
		</div>
		<div>
			<div id="cname"><h2>${c.classname}班小演讲</h2></div>
			<ul style="font-size: 13px">
			<li>1.演讲时间:要求3分钟,少于两分半要扣分</li>
			<li>2.台风:站姿,声音,手势各占一分</li>
			<li>3.流畅性:演讲内容不流畅丰富,不准备,卡克的要扣分</li>
			<li>4.内容丰富:内容准备充分,逻辑清晰</li>
			<li>5.互动性:能调节氛围，吸引大家注意力,有提问</li>
			</ul>
		</div>
		<!--用户-->
		<table class="providerTable" cellpadding="0" cellspacing="0">
			<tbody>
				<tr class="firstTr" style="background-color: pink;font-size: 13px">
				<td>名字</td>
				<td>演讲时间</td>
				<td>台风</td>
				<td>流畅性</td>
				<td>互动性</td>
				<td>内容</td>
				<td>总分</td>
				<td>评价</td>
				<td>操作</td>
				</tr>
				<c:forEach items="${list}" var="c">
				<tr style=""><td><input type="text" name="name" id="name" value="${c.stuname}"
						style="width: 65px;font-size: 12px; height: 25px"><input type="hidden" name="cid" id="cid"
						value="${c.cid}"></td>
					<td><input type="number" name="time" id="time"
						style="width: 65px;height: 25px "  oninput="if(value>3||value<0)value=3"></td>
					<td><input type="number" name="taifeng" id="taifeng"
						style="width: 65px; height: 25px"  oninput="if(value>3||value<0)value=3"></td>
					<td><input type="number" name="smooth" id="smooth"
						style="width: 65px; height: 25px"  oninput="if(value>3||value<0)value=3"></td>
					<td><input type="number" name="ctive" id="ctive"
						style="width: 65px; height: 25px"  oninput="if(value>3||value<0)value=3"></td>
					<td><input type="number" name="content" id="content"
						style="width: 65px;height: 25px " oninput="if(value>3||value<0)value=3"></td>
					<td><input type="text" name="sum" id="${c.stuid}" class="sum"
						style="width: 65px;height: 25px " onfocus="delayToCount(this,this.id)"></td>
					<td><textarea style="height: 25px; width: 195px" name="evaluate" id="evaluate"></textarea>
					</td>
					<td>
					<input type="button" value="插入">
					</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
		<input type="hidden" id="totalPageCount" value="5">
		<script type="text/javascript">	
		</script>
		<script type="text/javascript" src="js/rollpage.js"></script>
	</div>
	</section>
	<footer class="footer">版权归北大青鸟 </footer>
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

function delayToCount(obj,id){
var td_content=$(obj).parents("tr").children("td");
var time=$(td_content.eq(1)).find("input").val();
var taifeng=$(td_content.eq(2)).find("input").val();
var smooth=$(td_content.eq(3)).find("input").val();
var active=$(td_content.eq(4)).find("input").val();
var content=$(td_content.eq(5)).find("input").val();

var sum=parseInt(time)+parseInt(taifeng)+parseInt(smooth)+parseInt(active)+parseInt(content);
$(td_content.eq(6)).find("input").val(sum);

}
$(function(){
	var btn;
	$("input[type='button']").click(function(){
		btn = $(this);
		//取值
		var name=$(this).parent().parent().find("#name").val();
		var time=$(this).parent().parent().find("#time"). val();
		var taifeng=$(this).parent().parent().find("#taifeng").val();
		var smooth=$(this).parent().parent().find("#smooth").val();
		var active=$(this).parent().parent().find("#ctive").val();
		var sum=$(this).parent().parent().find(".sum").val();
		var evaluate=$(this).parent().parent().find("#evaluate").val();
	
		var cid=$(this).parent().parent().find("#cid").val();
		var content=$(this).parent().parent().find("#content").val();
		
		if(content==""||time==""||taifeng==""||smooth==""||active==""||evaluate==""){
			alert("请完整填写");
			
		}
		
		
		
		$.post(
		"lcServlet", 
		"op=talkInsert&name="+name+"&time="+time+"&taifeng="+taifeng+"&smooth="+smooth+"&active="+active+"&sum="+sum+"&content="+content+"&cid="+cid+"&evaluate="+evaluate+"&memberid=1", 
		function(r) {
			if (r.result == "1") {
			//$(btn).val("修改");
			
			if($(btn).val()=="插入"){
				$(btn).val("修改");
			}else if($(btn).val()=="修改"){
				
				alert("修改成功");
			}
			$(btn).css("background-color","rgb(170,209,242)");
			$(btn).css("color","block");
			} else {
		   $(btn).val("失败");
			}
		}, "json");
	});
	 
	
	
	//页面
$(function(){
	$(".inter").hide();
	$("#interview").click(function(){
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
	location.href = "iServlets?op=to&index=1&mem="+mem;
}

function look(id) {
	location.href = "iServlets?op=selectNow&id="+id;
}
}); 
</script>

