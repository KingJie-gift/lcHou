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




	<c:if test="${ p eq null }">
		<script>
			location.href = "clServlet?op=Stdentfen&index=1";
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
		<div class="right" style="margin-top: 13px;width: 800px">
			<div class="location" style="width: 620px">
				<strong>你现在所在的位置是:</strong> <span>学员管理页面</span>
			</div>
			<p style="font-size: 15px;color: blue;margin: 13px;width: 450px">北
				大 青 鸟 全 部 学 员 信 息</p>
			<div class="search">
				<form method="post" action="">
					<p style="margin-left: -15px">
						<span>学员姓名：</span> <input name="name" id="name" class="input-text"
							type="text" style="width:110px" value="${ name }"> <span>班级角色：</span>
						<select name="cid">
							<option value="-1">--请选择--</option>
							<c:forEach items="${ clist }" var="c">
								<option value="${ c.classid }"
									<c:if test="${ c.classid==id }">selected="selected"</c:if>>${ c.classname }</option>
							</c:forEach>
						</select> <input type="hidden" name="pageIndex" value="1"> <input
							value="查 询" type="submit" id="searchbutton"> <a href="#"
							onclick="add()" style="width:40px;margin-left: 10px">添加</a>
					</p>
				</form>
			</div>
			<!--用户-->

			<table class="providerTable" cellpadding="0" cellspacing="0"
				style="width:650px;margin-left: 10px">
				<tbody>
					<tr class="firstTr"  style="background-color: rgb(170,209,242)"">
						<th width="4%" style="font-size: 13px;font-weight: normal;">学员姓名</th>
						<th width="4%" style="font-size: 13px;font-weight: normal;">班级类型</th>
						<th width="4%" style="font-size: 13px;font-weight: normal;">实施操作</th>
					</tr>
					<c:forEach items="${p.list}" var="f">
						<tr>
							<th width="1%" style="font-size: 12px;font-weight: normal;">${f.stuname }</th>
							<th width="1%" style="font-size: 12px;font-weight: normal;">${f.class1.classname }</th>
							<th width="3%" id="fen"
								style="font-size: 14px;font-weight: normal;"><a
								class="deleteUser" href="#"><img src="images/schu.png"
									alt="删除" title="删除" onclick="Studel(${ f.stuid },this)"></a>
						</tr>
					</c:forEach>
				</tbody>
			</table>

			<input type="hidden" id="totalPageCount" value="5">
			<script type="text/javascript">
				
			</script>
			<div class="page-bar" style="font-size: 13px;color: red">
				<ul class="page-num-ul clearfix">
					<c:if test="${ p.pageIndex!=1 }">
						<a href="clServlet?op=Stdentfen&index=1"
							style="font-size:13px ;line-height: 3px;">首页</a>
					</c:if>
					<a href="clServlet?op=Stdentfen&index=${p.pageIndex-1 }"
						style="font-size:13px ;line-height: 3px;">上一页</a>
					<a href="clServlet?op=Stdentfen&index=${p.pageIndex+1 }"
						style="font-size:13px ;line-height: 3px;">下一页</a>
					<c:if test="${ p.pageIndex!=p.pageCount }">
						<a href="clServlet?op=Stdentfen&index=${p.pageCount }"
							style="font-size:13px ;line-height: 3px;">尾页</a>
					</c:if>
					<span style="font-size:13px ;line-height: 3px;">一共 ${ p.pageCount }页，当前是${ p.pageIndex }
						数据共有：${ p.dataCount }</span>
				</ul>
				<span class="page-go-form" style="font-size: 14px;color: red">
				</span>


			</div>

			<script type="text/javascript" src="js/rollpage.js"></script>

		</div>

		<div id="add" style="margin-left: -1px">
			<div class="right" style="margin-left: 28px;margin-top: 13px">
				<div class="location">
					<strong>你现在所在的位置是:</strong> <span>学员添加页面</span>
				</div>
				<p
					style="font-size: 15px;color: blue;margin: 6px;margin-bottom: 9px">北
					大 青 鸟 学 员 添 加 功 能</p>
				<span style=" margin-top: 10px"><img src="images/zd.png"><img
					src="images/zd.png"><img src="images/zd.png"><img
					src="images/zd.png"><img src="images/zd.png"><img
					src="images/zd.png"><img src="images/zd.png"><img
					src="images/zd.png"><img src="images/zd.png"><img
					src="images/zd.png"><img src="images/zd.png"></span>
				<div class="providerAdd"
					style="margin-top:50px;padding: 30px;width:278px;margin-left: 8px">
					<form action="clServlet?op=Studentadd" method="post">
						<p style="font: 12px">
							请根据信息添加 <span style="font-weight: bolder;" id="addsu"> </span>
						</p>

						<div>
							学员名称：<input type="text" name="name" id="StuName"
								style="width:140px;padding: 5px"> <font color="red">*</font>
						</div>

						<div>
							班级类型：<select name="cid" id="classid"
								style=" width: 140px;margin-top: 30px">
								<option value="-1">--请选择--</option>
								<c:forEach items="${ clist }" var="c">
									<option value="${ c.classid }">${ c.classname }</option>
								</c:forEach>
							</select> <font color="red">*</font>
						</div>
						<div>
							<input type="button" name="Stuadd" id="Stuadd" value="保存"
								style="width: 120px;background-color:skyblue ;height:40px;margin-left: 80px;margin-top: 30px ">
						</div>
					</form>
					<div id="success" style="color: red">
						<c:if test="${ not empty success }">
					${ success }
					</c:if>
					</div>

				</div>

			</div>
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
	function lood() {
		window.location.reload();

	}
	//新增
	$(function() {
		$("#Stuadd").click(
				function() {
					var name = $("#StuName").val();
					var cid = $("#classid").val();

					$.getJSON("clServlet", "op=Studentadd&name=" + name
							+ "&cid=" + cid, function(r) {
						if (r.re == "1") {
							$(".page-go-form").html("亲，新增成功");
							setTimeout("lood()", 600);
						} else {
							$(".page-go-form").html("抱歉，新增失败哦");
						}

					});

				});

	});
	//删除
	function Studel(id, a) {
		if (confirm("是否删除？")) {
			$.getJSON("clServlet", "op=Studentdel&id=" + id, function(r) {
				if (r.result == "1") {
					$(a).parent().parent().parent().remove();
					$(".page-go-form").html("删除成功");
					setTimeout("lood()", 500);
				} else {
					$(".page-go-form").html("删除失败");
				}
			});
		}
	};

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
</script>
