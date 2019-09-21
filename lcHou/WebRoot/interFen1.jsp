<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head >

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
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">   
    <title>徐州中博晨练管理系统</title>
    <link type="text/css" rel="stylesheet" href="css/style.css">
    <link type="text/css" rel="stylesheet" href="css/public.css">
	<link href="css/WdatePicker.css" rel="stylesheet" type="text/css">
</head>
<body>
 



<!--头部-->
    <header class="publicHeader">
        <h1>北大青鸟晨练管理系统</h1>
        <div class="publicHeaderR">
            <p><span>下午好！</span><span style="color: #fff21b"> 系统管理员</span> , 欢迎你！</p>
            <a href="#">退出</a>
        </div>
    </header>
<!--时间-->
    <section class="publicTime">
        <span id="time">2018年07月27日&nbsp;14:30:04&nbsp;星期五</span>
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
     <input type="hidden" id="path" name="path" value="#">
     <input type="hidden" id="referer" name="referer" value="#">

<div class="right"  id="add" style="width: 420px;margin-top: 3px;margin-left: 30px" >
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>教师页面 &gt;&gt;教师简介页面</span>
        </div>
        <p style="font-size: 15px;color: blue;margin-top: 13px;padding-left: 15px" ">您 的 基 本 信 息</p>
			 
        <div class="providerAdd" style="">
        <div ><img src="images/y.jpg" class="radius-circle rotate-hover"
					height="60" alt=""  style="border-color:black"/><span style="font-size: 20px;font-weight: bolder;font-family:sans-serif;color:black;">${teacherAll.name }</span></div>
  <h3 style="padding: 10px;font-size: 14px;font-weight: normal;">我的介绍：大家好，我是教质部经理朱青朱老师</h4>
  <h4 style="padding: 10px;font-size: 14px;font-weight: normal;color: black;">我的格言:工作 ${ teacherAll.motto }</h4>
  <h3 style="padding: 10px;font-size: 14px;font-weight: normal;">我的联系方式 ：${ teacherAll.phone }</h4>
  <h3 style="padding: 10px;font-size: 14px;font-weight: normal;">我的班级有：
  <c:forEach items="${ list }" var="c">
  <p style="color: black;padding: 5px">${ c.classname }------->共有${ c.count }位学员</p>
  </c:forEach>
  
 </h3>
        </div>
</div>



<div class="right"  id="add" style="width: 420px;margin-left: 10px;margin-top: 3px" >
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>教师页面 &gt;&gt;班级基本信息</span>
        </div>
        <p style="font-size: 15px;color: blue;margin: 13px">您 的 班 级 基 本 信 息</p>
			 
        <div class="providerAdd" style="">
         <c:forEach items="${ list }" var="c">
        <div ><span style="font-size:13px;font-weight:normal;color:red;"> 班级名称：<a href="#" onclick="toLook(${ c.classid })">${ c.classname }</a></span></div>
  <span style="font-size: 12px;font-weight: normal;"></span>
  <h4 style="font-size: 12px;font-weight: normal;color: black;">班级学员人数：${ c.count }</h4>
  <h3 style="font-size: 12px;font-weight: normal;padding: 1px"> 本班教员：${ c.coach.name }</h4>
  <h3 style="font-size: 12px;font-weight: normal;">本班级的格言：${ c.motto }
  </h3>
  </c:forEach>
  

        </div>
</div>

 




</section>


<footer class="footer">
    版权归北大青鸟
</footer>
<script type="text/javascript" src="js/time.js"></script>
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>

</body>
</html>
<script type="text/javascript" src="js/useradd.js"></script>

<script src="jquery-1.12.4.js"></script>
<script type="text/javascript">

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
function toLook(cid){
location.href="iServlets?op=info&index=1&cid="+cid;	  
	  
}

function insert(mem) {
location.href = "iServlets?op=to&index=1&mem="+mem;
}

function look(id) {
location.href = "iServlets?op=selectNow&id="+id;
}
</script>
