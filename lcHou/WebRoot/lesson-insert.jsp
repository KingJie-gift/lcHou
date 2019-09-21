
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head lang="en">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>超市订单管理系统</title>
<link type="text/css" rel="stylesheet" href="css/style.css">
<link type="text/css" rel="stylesheet" href="css/public.css">
<link href="css/WdatePicker.css" rel="stylesheet" type="text/css">

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
<body>

	<c:if test="${clist eq null}">
		<script type="text/javascript">
			location.href = "lcServlet?op=toselect";
		</script>
	</c:if>

	<!--头部-->
	<header class="publicHeader">
		<h1>超市订单管理系统</h1>
		<div class="publicHeaderR">
			<p>
				<span>下午好！</span><span style="color: #fff21b"> 系统管理员</span> , 欢迎你！
			</p>
			<a href="#">退出</a>
		</div>
	</header>
	<!--时间-->
	<section class="publicTime">
		<span id="time">2018年07月27日&nbsp;14:30:04&nbsp;星期五</span> <a href="#">温馨提示：为了能正常浏览，请使用高版本浏览器！（IE10+）</a>
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
		<input type="hidden" id="path" name="path" value="#"> <input
			type="hidden" id="referer" name="referer" value="#">

		<div class="right">
			<div class="location">
				<strong>你现在所在的位置是:</strong> <span>用户管理页面 &gt;&gt; 用户添加页面</span>
			</div>
			<div class="providerAdd" style="width: 600px;margin-left: 200px">
				<form id="userForm" name="userForm" method="post"
					action="lcServlet?op=lessInsert">
					<input type="hidden" name="method" value="add">

					<div>
						<label for="birthday">班&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;级:&nbsp;&nbsp;&nbsp;</label>
						<select name="classid" id="classid" style="width:150px;">
							<option value="-1">请选择</option>
							<c:forEach items="${clist}" var="c">
								<option value="${c.classid}">${c.classname}</option>
							</c:forEach>
						</select> <font color="red">*</font> <span id="cmsg"></span>
					</div>

					<div>
						<label for="birthday">&nbsp;&nbsp;&nbsp;星&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;期:&nbsp;&nbsp;&nbsp;</label>
						<select name="week" id="week" style="width:150px;margin: 3px">
							<option value="-1">请选择</option>
							<option value="周一">周一</option>
							<option value="周二">周二</option>
							<option value="周三">周三</option>
							<option value="周四">周四</option>
							<option value="周五">周五</option>
							<option value="周六">周六</option>
						</select> <font color="red">*</font> <span id="wmsg"></span>
					</div>

					<div>
						<label for="birthday">上/下午:&nbsp;&nbsp;&nbsp;</label> <select
							name="none" id="none" style="width:150px;margin: 4px">
							<option value="-1">请选择</option>
							<option value="0">上午</option>
							<option value="1">下午</option>
						</select> <font color="red">*</font> <span id="nmsg"></span>
					</div>

					<div>
						<label for="birthday">负责人:&nbsp;&nbsp;&nbsp;&nbsp;</label> <select
							name="memberid" id="memberid" style="width:150px;margin: 4px">
							<option value="-1">请选择</option>
						</select> <font color="red">*</font> <span id="mmsg"></span>
					</div>
					<div>
						<label for="birthday">
							&nbsp;&nbsp;&nbsp;课&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;节:&nbsp;&nbsp;&nbsp;</label>
						<select name="lesson" id="lesson" style="width:150px;margin: 4px">
							<option value="-1">请选择</option>
							<option value="1">D1</option>
							<option value="2">D2</option>
							<option value="3">D3</option>
							<option value="4">D4</option>
						</select> <font color="red">*</font> <span id="lmsg"></span>
					</div>
					<div>
						<label for="birthday"> 日 &nbsp;&nbsp;&nbsp;&nbsp; 期：</label> <input
							type="text" style="width:140px;margin: 4px" class="Wdate"
							id="birthday" name="birthday" readonly="readonly"
							onclick="WdatePicker();"> <font color="red">*</font>
					</div>

					<div class="providerAddBtn" style="margin-left: 170px">
						<input type="submit" name="add" id="add" value="保存"
							style="width: 100px"> <input type="button" id="back"
							name="back" value="返回">
					</div>
				</form>
				<c:if test="${rr ne null}">
					<span id="msg"> ${rr} </span>
				</c:if>
			</div>
		</div>
	</section>


	<footer class="footer"> 版权归北大青鸟 </footer>
	<script type="text/javascript" src="js/time.js"></script>
	<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
	<script type="text/javascript" src="js/common.js"></script>
	<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>

	<div
		style="position: absolute; z-index: 19700; top: -1970px; left: -1970px;">
		<iframe style="width: 186px; height: 198px;"
			src="calendar/My97DatePicker.html" frameborder="0" border="0"
			scrolling="no"></iframe>
	</div>
</body>
</html>
<script type="text/javascript" src="js/useradd.js"></script>

<script src="jquery-1.12.4.js"></script>
<script type="text/javascript">
function lood() {
	window.location.reload();
	
}

	//非空页面

	//下拉框绑定
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
	});

	//页面

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

	$(function() {
		//非空验证
		$("#classid").blur(function() {
			var classid = $("#classid").val();
			if (classid == "-1") {
				$("#cmsg").html("请选择班级！");
				return false;
			} else {
				$("#cmsg").html("");

			}
			return true;
		})
		$("#none").blur(function() {
			var none = $("#none").val();
			if (none == "-1") {
				$("#nmsg").html("请选择上/下午！");
				return false;
			} else {
				$("#nmsg").html("");

			}
			return true;
		})
		$("#week").blur(function() {
			var week = $("#week").val();
			if (week == "-1") {
				$("#wmsg").html("请选择星期！");
				return false;
			} else {
				$("#wmsg").html("");

			}
			return true;
		})
		$("#lesson").blur(function() {
			var lesson = $("#lesson").val();
			if (lesson == "-1") {
				$("#lmsg").html("请选择课节！");
				return false;
			} else {
				$("#lmsg").html("");

			}
			return true;
		})
		$("#memberid").blur(function() {
			var memberid = $("#memberid").val();
			if (memberid == "-1") {
				$("#mmsg").html("请选择记录人！");
				return false;
			} else {
				$("#mmsg").html("");

			}
			return true;
		})

		$("form").submit(function() {

			var classid = $("#classid").val();
			if (classid == "-1") {
				$("#cmsg").html("请选择班级！");
				return false;
			}

			var none = $("#none").val();
			if (none == "-1") {
				$("#nmsg").html("请选择上/下午！");
				return false;
			}

			var week = $("#week").val();
			if (week == "-1") {
				$("#wmsg").html("请选择星期！");
				return false;
			}

			var lesson = $("#lesson").val();
			if (lesson == "-1") {
				$("#lmsg").html("请选择课节！");
				return false;
			}

			var memberid = $("#memberid").val();
			if (memberid == "-1") {
				$("#mmsg").html("请选择记录人！");
				return false;
			}

		});
	});
</script>
