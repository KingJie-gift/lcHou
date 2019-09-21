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
			location.href = "clServlet?op=memFen&index=1";
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
		<div class="right" style="margin-top: 13px">
			<div class="location">
				<strong>你现在所在的位置是:</strong> <span>晨练部管理页面</span>
			</div>
			<p style="font-size: 15px;color: blue;margin: 13px">北 大 青 鸟 部 员 信
				息</p>
			<!--用户-->
			<div class="search">
				<form method="post" action="">
					<p>
						<input name="method" value="query" class="input-text"
							type="hidden"> <span style="margin-left: -8px">部员姓名</span>
						<input name="name" class="input-text" type="text" value=""
							style="width:100px"> <span>班级</span> <select name="cid">
							<option value="-1">--请选择--</option>
							<c:forEach items="${ clist }" var="c">
								<option value="${ c.classid }"
									<c:if test="${ c.classid==id }">selected="selected"</c:if>>${ c.classname }</option>
							</c:forEach>
						</select> <input type="hidden" name="pageIndex" value="1"> <input
							value="查 询" type="submit" id="searchbutton"> <a href="#"
							onclick="add()" style="width:40px;margin-left:-50px">添加</a> <a
							href="#" onclick="update()" style="width:40px;margin-left: 1px">修改</a>
					</p>
				</form>
			</div>
			<table class="providerTable" cellpadding="0" cellspacing="0">
				<tbody>
					<tr class="firstTr" style="background-color: rgb(170,209,242)">
						<th width="8%" style="font-size: 12px;display: none;">id</th>
						<th width="8%" style="font-size: 12px;font-weight: normal;">部员姓名</th>
						<th width="8%" style="font-size: 12px;font-weight: normal;">所属班级</th>
						<th width="8%" style="font-size: 12px;font-weight: normal;">联系电话</th>
						<th width="8%" style="font-size: 12px;font-weight: normal;">正课时间</th>
						<th width="20%" style="font-size: 12px;font-weight: normal;">自我格言</th>
						<th width="10%" style="font-size: 12px;font-weight: normal;">简单操作</th>
					</tr>
					<c:forEach items="${p.list}" var="f">
						<c:if test="${ f.tag eq '1' }">
							<tr style="background-color: yellow">
								<th width="2%" id="memId" style="font-size: 12px;display: none;">${ f.c.classid }</th>
								<th width="2%" id="memId" style="font-size: 12px;display: none;">${ f.tag }</th>
								<th width="2%" id="memId" style="font-size: 12px;display: none;">${ f.id }</th>
								<th width="2%" style="font-size: 12px;font-weight: normal;">${ f.name }</th>
								<th width="4%" style="font-size: 12px;font-weight: normal;"
									id="name">${f.c.classname }</th>
								<th width="1%" style="font-size: 12px;font-weight: normal;"
									id="account" class="account">${f.phone }</th>
								<th width="1%" style="font-size: 12px;font-weight: normal;"
									id="pwd"><c:if test="${f.course eq '0' }">
								上午课
								</c:if> <c:if test="${f.course eq '1' }">
								下午课
								</c:if></th>
								<th width="20%" style="font-size: 12px;font-weight: normal;"
									id="motto">${f.motto}</th>
								<th width="10%"><a href="#" onclick="Teadel(${ f.id},this)"
									style="font-size: 12px;font-weight: normal;">删除</a> <a href="#"
									onclick="toUpdate(${f.id },this)"
									style="font-size: 12px;;font-weight: normal;">修改</a></th>
							</tr>

						</c:if>


						<c:if test="${ f.tag ne '1' }">
							<tr>
								<th width="2%" id="memId" style="font-size: 12px;display: none;">${ f.c.classid }</th>
								<th width="2%" id="memId" style="font-size: 12px;display: none;">${ f.tag }</th>
								<th width="2%" id="memId" style="font-size: 12px;display: none;">${ f.id }</th>
								<th width="2%" style="font-size: 12px;font-weight: normal;">${ f.name }</th>
								<th width="4%" style="font-size: 12px;font-weight: normal;"
									id="name">${f.c.classname }</th>
								<th width="1%" style="font-size: 12px;font-weight: normal;"
									id="account" class="account">${f.phone }</th>
								<c:if test="${f.course eq '0' }">
									<th width="1%" style="font-size: 12px;font-weight: normal;"
										id="pwd">上午课</th>
								</c:if>

								<c:if test="${f.course eq '1' }">
									<th width="1%" style="font-size: 12px;font-weight: normal;"
										id="pwd">下午课</th>
								</c:if>
								<th width="20%" style="font-size: 12px;font-weight: normal;"
									id="motto">${f.motto}</th>
								<th width="10%"><a href="#"
									style="font-size:12px ;font-weight: normal;"
									onclick="Teadel(${ f.id},this)">删除</a> <a href="#"
									style="font-size:12px;font-weight: normal;"
									onclick="toUpdate(${f.id },this)">修改</a></th>
							</tr>

						</c:if>
					</c:forEach>
				</tbody>
			</table>

			<div class="page-bar" style="font-size: 13px;">
				<ul class="page-num-ul clearfix">
					<c:if test="${ p.index!=1 }">
						<a href="clServlet?op=memFen&index=1"
							style="font-size:14px ;line-height: 3px;">首页</a>
					</c:if>
					<a href="clServlet?op=memFen&index=${p.index-1 }"
						style="font-size:14px ;line-height: 3px;">上一页</a>
					<a href="clServlet?op=memFen&index=${p.index+1 }"
						style="font-size:14px ;line-height: 3px;">下一页</a>
					<c:if test="${ p.index!=p.totalPage }">
						<a href="clServlet?op=memFen&index=${p.totalPage }"
							style="font-size:14px ;line-height: 3px;">尾页</a>
					</c:if>
					<span style="font-size:14px ;line-height: 3px;"> 当前是${ p.index }</span>
				</ul>
				<span class="page-go-form" style="font-size: 14px;color: red">
				<p style="font-size: 12px;color: red;margin;20px">漂黄为学员离部状态</p>
				</span>
			</div>
		</div>




		<script type="text/javascript" src="js/rollpage.js"></script>
		<div id="add" style="display: none">
			<div class="right" style="margin-left: 28px;margin-top: 13px">
				<div class="location" style="margin-left: 8px;margin-top: 13px">
					<strong>你现在所在的位置是:</strong> <span>部员添加页面</span>
				</div>
				<p style="font-size: 15px;color: blue;margin: 6px">徐 州 中 博 部 员 添
					加 功 能</p>

				<div class="providerAdd"
					style="margin-top:23px;padding: 30px;width:285px;margin-left: 8px">

					<form action="" method="post">
						<p style="font: 12px">请根据信息添加</p>

						<div>
							部员名称：<input type="text" name="name" id="memName"
								style="width:170px;padding: 5px"> <font color="red">*</font><span id="m" style="color: red"></span>
						</div>
						<div>
							班级类型：<select name="cid" id="cid" style=" width: 170px;">
								<option value="-1">请选择</option>
								<c:forEach items="${ clist }" var="c">
									<option value="${ c.classid }">${ c.classname }</option>
								</c:forEach>
							</select> <font color="red">*</font>
						</div>

						<div>
							正课时间：<select name="course" id="course" class="course"
								style=" width: 170px;">
								<option value="-1">--请选择--</option>
								<option value="0">上午课</option>
								<option value="1">下午课</option>
							</select> <font color="red">*</font>
						</div>

						<div>
							联系电话：<input type="text" name="phone" id="phone"
								style="width:170px;padding: 5px"> <font color="red">*</font>
						</div>
						<div>
							部员格言： <input type="text" name="motto" id="memMotto"
								style="width:170px;padding: 5px"><font color="red">*</font>
						</div>


						<div>
							<input type="button" name="add" id="memAdd" value="保存"
								style="width: 100px;height:40px;margin-left: 100px; ">
						</div>
					</form>
				</div>

			</div>
		</div>



		<div id="update">
			<div class="right" style="margin-left: 28px;margin-top: 13px">
				<div class="location" style="margin-left: 8px;margin-top: 13px">
					<strong>你现在所在的位置是:</strong> <span>部员页面</span>
				</div>
				<p style="font-size: 15px;color: blue;margin: 6px">徐 州 中 博 部 员 修
					改 功 能</p>

				<div class="providerAdd"
					style="margin-top:23px;padding: 30px;width:285px;margin-left: 8px">

					<form action="" method="post">
						<p style="font: 12px">
							请修改相关信息 <span style="font-weight: bolder;" id=""> </span> <span
								id="upSuccess" style="font-size: 16px"></span>
						</p>
						<div>
							<input type="hidden" name="name" id="Uname"
								style="width:200px;padding: 5px">
						</div>
						<div>
							<input type="hidden" name="教师id：" id="Uid"
								style="width:200px;padding: 5px">
						</div>

						<div>
							班级类型：<select name="cid" id="c" class="cid" style=" width: 200px;">
								<option value="-1">请选择</option>
								<c:forEach items="${ clist }" var="c">
									<option value="${ c.classid }">${ c.classname }</option>
								</c:forEach>
							</select> <font color="red">*</font>
						</div>

						<div>
							正课时间：<select name="course" id="course" class="course"
								style=" width: 200px;">
								<option value="-1">请选择</option>
								<option value="0">上午课</option>
								<option value="1">下午课</option>
							</select> <font color="red">*</font>
						</div>

						<div>
							联系电话：<input type="text" name="phone" id="Uphone"
								style="width:200px;padding: 5px"> <font color="red">*</font>
						</div>

						<div>
							部员格言： <input type="text" name="motto" id="Umotto"
								style="width:200px;padding: 5px"><font color="red">*</font>
						</div>
						<div>
							<p style="font-size: 12px;padding-top: 10px;padding-bottom: 15px">
								在职状态： &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input
									type="radio" name="Udis" value="0" id="yes">在职&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<input type="radio" name="Udis" value="1" id="no">离职
							</p>
						</div>

						<table>
							<tr>
								<td><input type="button" id="uuuu" value="修   改"
									style="width: 110px;height:40px;margin-left: 80px; background-color:skyblue ;margin-left: 20px"></td>
								<td><input type="button" id="reset" value="重   置"
									style="width: 110px;height:40px;margin-left: 80px; background-color:skyblue ;margin-left: 21px"></td>
							</tr>
							<c:if test="${ not empty update}">
								${ update }
								</c:if>
						</table>
					</form>
				</div>

			</div>
		</div>

		<div id="success"></div>


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

	$(function() {
		$("#reset").click(function() {
			$("#Uid").val("");
			$("#Uname").val("");
			$("#Ucounts").val("");
			$("#Upwd").val("");
			$("#Umotto").val("");
			$("#Uphone").val("");

		});

	});

	function update() {
		$("#add").css("display", "none");
		$("#update").css("display", "block");

	}

	function add() {
		$("#add").css("display", "block");
		$("#update").css("display", "none");

	}

	function toUpdate(id, a) {
		var teaId = id;
		var d = $(a).parent().parent().children().eq(1).html();
		var name = $(a).parent().parent().children().eq(3).html();
		var cname = $(a).parent().parent().children().eq(4).html();
		var cid = $(a).parent().parent().children().eq(0).html();
		//定义数组
		var array = new Array();
		var varray = new Array();
		$("#c option").each(function() {
			var txt = $(this).text();
			var v = $(this).val();
			if (txt != "请选择") {
				array.push(txt);
				varray.push(v);
			}
		});
		//遍历找到选中
		$(array).each(function(i, n) {
			if (n == cname) {
				$(".cid option[text='cname']").attr("selected", true);
			}
		});
		$(varray).each(function(i, n) {
			if (n == cid) {
				$(".cid").val(cid);
			}
		});

		//上课时间
		var course = $(a).parent().parent().children().eq(6).html();
		var courseid = 1;
		if (course == "上午课") {
			courseid = 0;
		}
		$(".course").val(courseid);
		$(".course option[text='course']").attr("selected", true);

		//
		var motto = $(a).parent().parent().children().eq(7).html();
		var phone = $(a).parent().parent().children().eq(5).html();
		$("#Uid").val(teaId);
		$("#Uname").val(name);
		$("#Umotto").val(motto);
		$("#Uphone").val(phone);

		//按钮
		if (d == 0) {
			$("#yes").prop("checked", true);
			$("#no").prop("checked", false);
		}
		if (d == 1) {
			$("#yes").prop("checked", false);
			$("#no").prop("checked", true);
		}

	}

	function Teadel(id, a) {
		if (confirm("是否删除？")) {
			$.getJSON("clServlet", "op=del&id=" + id, function(r) {
				if (r.re == "1") {
					$(a).parent().parent().remove();
					$(".page-go-form").html("删除成功");
					setTimeout("lood()", 500);
				} else {
					$(".page-go-form").html("删除失败");

				}
			});
		}

	};

	$(function() {
		$("#uuuu").click(
				function() {
					var id = $("#Uid").val();
					var name = $("#Uname").val();
					var motto = $("#Umotto").val();
					var phone = $("#Uphone").val();
					var cid = $("#c option:selected").val();
					var course = $(".course option:selected").val();
					var tag = $("input[type='radio']:checked").val();
					$.getJSON("clServlet", "op=memUpdate&id=" + id + "&name="
							+ name + "&motto=" + motto + "&phone=" + phone
							+ "&tag=" + tag + "&course=" + course + "&cid="
							+ cid, function(r) {
						if (r.re == "1") {
							$("#upSuccess").html("亲，修改成功");
							setTimeout("lood()", 500);
						} else {
							$("#upSuccess").html("抱歉，修改失败哦");
						}

					});
				});

	});

	$(function() {
		$("#memAdd").click(
				function() {
					var name = $("#memName").val();
					var course = $("#course").val();
					var cid = $("#cid").val();
					var motto = $("#memMotto").val();
					var phone = $("#phone").val();
					$.getJSON("clServlet", "op=memAdd&name=" + name + "&motto="
							+ motto + "&phone=" + phone + "&cid=" + cid
							+ "&course=" + course, function(r) {
						if (r.re == "1") {
							$(".page-go-form").html("亲，新增成功");
							setTimeout("lood()", 500);
						} else {
							$(".page-go-form").html("抱歉，新增失败哦");
						}

					});

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
</script>
