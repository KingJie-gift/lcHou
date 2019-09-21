<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<head lang="en">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>面试管理系统</title>
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

	<!--头部-->
	<header class="publicHeader">
		<h1>徐州中博晨练管理系统</h1>
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
				<strong>你现在所在的位置是:</strong> <span>面试管理页面 &gt;&gt;查看个人信息</span>
			</div>
			<div class="search">
				<form id="userForm" name="userForm" method="post"
					action="iServlets?op=people">
					<p>
						<input name="method" value="query" class="input-text"
							type="hidden"> <label>日期：</label> <input type="hidden"
							name="id" value="${ stu.stuid }"> <input type="text"
							class="Wdate" id="times" name="times" readonly="readonly"
							value="${ time }" onclick="WdatePicker();" style=" width: 125px">
						<input type="hidden" name="pageIndex" value="1"> <input
							value="查 询" type="submit"
							style="width:160px;height:37px; margin-left:40px;margin-top: 12px">
						<a href="#" onclick="looks(${ stu.stuid })">查看近半个月的得分趋势</a>
					</p>
				</form>
			</div>
			<div id="query1">
				<table class="providerTable" cellpadding="0" cellspacing="0"
					style="margin-top: 25px">
					<tbody>
						<tr>
							<th colspan="7">学员 ${ stu.stuname } 的模拟面试信息：</th>
						</tr>
						<tr class="firstTr" style="background-color: pink">
							<th width="6%" style="font-size: 14px;font-weight: normal;">介绍得分</th>
							<th width="6%" style="font-size: 14px;font-weight: normal;">人事得分</th>
							<th width="8%" style="font-size: 14px;font-weight: normal;">总分</th>
							<th width="8%" style="font-size: 14px;font-weight: normal;">时长</th>
							<th width="5%" style="font-size: 14px;font-weight: normal;">时间</th>
							<th width="13%" style="font-size: 14px;font-weight: normal;">评价</th>
						</tr>

						<c:forEach items="${list}" var="f">

							<tr style="">
								<th width="2%" style="font-size: 14px;font-weight: normal;"
									id="name">${f.jieshao }</th>
								<th width="1%" style="font-size: 14px;font-weight: normal;"
									id="account" class="account">${f.problem }</th>
								<th width="1%" style="font-size: 14px;font-weight: normal;"
									id="pwd">${f.sum }</th>
								<th width="1%" style="font-size: 14px;font-weight: normal;"
									id="phone">${f.time }</th>
								<th width="20%" style="font-size: 14px;font-weight: normal;"
									id="motto">${f.date}</th>
								<th width="20%" style="font-size: 14px;font-weight: normal;"
									id="motto">${f.evalute}</th>
								 
							</tr>
						</c:forEach>
					</tbody>
				</table>

			</div>

			<div>${ image }</div>



		</div>
	</section>


	<footer class="footer"> 版权归北大青鸟 </footer>
	<script type="text/javascript" src="js/time.js"></script>
	<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
	<script type="text/javascript" src="js/common.js"></script>
	<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>


	</div>
</body>
</html>
<script src="jquery-1.12.4.js"></script>
<script type="text/javascript">
	function looks(id) {
		location.href = "testServlet?id=" + id;

	}

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
		location.href = "iServlets?op=to&index=1&mem=" + mem;
	}

	function look(id) {
		location.href = "iServlets?op=selectNow&id=" + id;
	}
</script>
