<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<html>
	<head lang="en">
		<title>北大青鸟晨练管理系统</title>
		<link type="text/css" rel="stylesheet" href="css/style.css">
		<link type="text/css" rel="stylesheet" href="css/public.css">
		<link href="css/WdatePicker.css" rel="stylesheet" type="text/css">
		<style type="text/css">
		.right{
		margin: 0 auto;
		text-align: center;
		margin-top: 90px;
		margin-left: 200px;
		}
		#msg{
		font-size: 18px;
		color: black;
		font-family: STCaiyun;
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
	</head>
<body>
<!--头部-->
    <header class="publicHeader">
        <h1>北大青鸟晨练管理系统</h1>
        <div class="publicHeaderR">
            <p><span></span><span style="color: #fff21b">  ${ a.name }</span> , 欢迎你！</p>
            <a href="#">退出</a>
        </div>
    </header>
<!--时间-->
    <section class="publicTime">
        <span id="time">2018年07月11日&nbsp;12:13:56&nbsp;星期三</span>
        <a href="#">温馨提示：为了能正常浏览，请使用高版本浏览器！（IE10+）</a>
    </section>
 <!--主体内容-->
	 <section class="publicMian ">
		 <div class="left">
			 <h2 class="leftH2"><span class="span1"></span>功能列表 <span></span></h2>
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
		 <input type="hidden" id="path" name="path" value="/SMBMS_C12_10">
		 <input type="hidden" id="referer" name="referer" value="http://localhost:9090/SMBMS_C12_10/logout.html">
		<div class="right" style="margin-top: 10px">
			<img class="wColck" src="images/clock.jpg" alt="">
			<div class="wFont" >
				<h2>系统管理员</h2>
				<p id="msg">欢迎来到北大青鸟晨练管理系统!</p>
				<p id="msg">请根据您的需要选择相应的菜单</p>
			</div>
			
			<c:if test="${less ne null}">
			<div id="paike">
			 <table  width="500px" style="background-color: rgb(170,209,242)">
			 <tr>
			 <td align="left" colspan="2">
			 <h4 style="margin: 20px">${a.name}                                你的负责演讲排课为</h4></td></tr>
			 
			<c:forEach items="${less}" var="l">
			<tr style="margin: 20px">
			<td style="margin: 20px">${l.class1.classname}</td>
			    <td>${l.talkTime}</td>
				<td style="margin-left: -100px"><c:if test="${l.none==0}">上午</c:if>
				<c:if test="${l.none==1}">下午</c:if>
				</td>
				<td style="margin: 20px">第${l.lesson}节课</td>
			</tr>
			</c:forEach>
		</table>
		</div>
		</c:if>
		
		
		</div>
	</section>

	<footer class="footer">
		版权归北大青鸟
	</footer>
	
<script type="text/javascript" src="js/time.js"></script>
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="js/common.js"></script>


  <div style="position: absolute; z-index: 19700; top: -1970px; left: -1970px;">
   
  </div>
 </body>
</html>
<script src="jquery-1.12.4.js"></script>
<script type="text/javascript">

$(function(){
	
	$("#paike").animate({"width":"500px"},1000,function(){
		$(this).find("table").slideDown("slow");
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


//
$(".inter").hide();
	$("#interview").click(function(){
		$(".inter").toggle();
		
	});
	
function insert(mem) {
	location.href = "iServlets?op=to&index=1&mem="+mem;
}

function look(id) {
	location.href = "iServlets?op=selectNow&id="+id;
}
</script>