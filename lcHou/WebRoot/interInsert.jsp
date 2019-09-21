<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>北大青鸟晨练管理系统</title>
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
	<c:if test="${ p eq null }">
		<script>
			location.href = "iServlets?op=to&index=1";
		</script>
	</c:if>

	<c:if test="${ clist eq null }">
		<script>
			location.href = "iServlets?op=to";
		</script>
	</c:if>




	<!--头部-->
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



		<div class="right" id="add" style="width: 420px;margin: 3px;">
			<div class="location">
				<strong>你现在所在的位置是:</strong> <span>模拟面试管理页面 &gt;&gt; 模拟面试信息页面</span>
			</div>
			<p style="font-size: 15px;color: blue;margin: 13px">徐 州 中 博 模 拟 面
				试</p>

			<div class="providerAdd" style="width: 350px;height: 335px">
				<form id="userForm" method="post" action="#"
					style="margin-left:-90px">
					<input type="hidden" name="method" value="add">
					<p id="msg" style="margin-left: 80px;color: red;font-size: 13px">
					<div style=" margin-top:-10px">
						<input type="hidden" name="id" id="id"> <input
							type="hidden" name="name" value="${ mem }" id="mem"> <label
							style="font-size: 11px">学员员班级：</label> <select name="classId"
							id="classId" style="width:160px;">
							<option value="-1">请选择</option>
							<c:forEach items="${ clist }" var="c">
								<option value="${ c.classid }">${ c.classname }</option>
							</c:forEach>
						</select><span id="m" style="color:red"></span>
					</div>
					<div style="padding-top: 2px;">
						<label style="font-size: 11px">面试人员姓名：</label> <select name="stu"
							id="stu" style="width:160px;">
							<option value="-1">请选择</option>

						</select><span id="c" style="color: red"></span>
					</div>

					<div style="padding-top: 2px;">
						<label for="birthday" style="font-size: 11px">自 我 介 绍 ：</label> <input
							type="number" name="zi" id="zi"
							style="height: 32px; width: 160px; " min="0" max="10" oninput="if(value>10||value<0)value=10">(10分)
						<font color="red">*</font>
					</div>
					<div style="padding-top: 2px;">
						<label for="birthday" style="font-size: 11px">人 事 问 题 ：</label> <input
							type="number" name="pro" id="pro"
							style="height: 32px; width: 160px" min="0" max="10" oninput="if(value>10||value<0)value=10">(10分)
						<font color="red">*</font>
					</div>
					<div style="padding-top: 2px;">
						<label for="birthday" style="font-size: 11px">面 试 时 长 ：</label> <input
							type="number" name="time" id="memtime"
							style="height: 32px; width:160px; " min="0" max="10">(分钟)
						<font color="red">*</font>
					</div>

					<div style="padding-top: 2px;">
						<label style="font-size: 11px">面试表现评价：</label>
						<textarea name="evalute" id="evalute"
							style="border-color:rgb(73,135,192);height: 40px; width: 160px;"></textarea>
						<font color="red">*</font>
					</div>

					<div class="providerAddBtn">
						<input type="button" name="add" id="toAdds" value="保存"
							style="margin-left: -140px"> <input type="button"
							id="update" name="ppp" value="修改"> <input type="button"
							id="back" name="back" value="返回">
					</div>

				</form>

			</div>
		</div>








		<div class="right" style="margin: 4px;width: 600px;">
			<div class="location">
				<strong>你现在所在的位置是:</strong> <span>模拟面试管理页面</span>
			</div>
			<p style="font-size: 15px;color: blue;margin: 15px">徐 州 中 博 面 试 学
				员 信 息</p>


			<table class="providerTable" cellpadding="0" cellspacing="0">
				<tbody>
					<tr class="firstTr" style="background-color: pink">
						<th width="4%" style="font-size: 12px;font-weight: normal;">班
							级</th>
						<th width="4%" style="font-size: 12px;font-weight: normal;">学
							员</th>
						<th width="5%" style="font-size: 12px;font-weight: normal;">自我介绍</th>
						<th width="5%" style="font-size: 12px;font-weight: normal;">人事问题</th>
						<th width="4%" style="font-size: 12px;font-weight: normal;">总
							分</th>
						<th width="4%" style="font-size: 12px;font-weight: normal;">时
							长</th>
						<th width="8%" style="font-size: 12px;font-weight: normal;">评
							价</th>
						<th width="4%" style="font-size: 13px;font-weight: normal;">操作</th>
					</tr>
					<c:forEach items="${p.list}" var="f">
						<tr>
							<th width="1%"
								style="font-size: 12px;font-weight: normal;display: none">${f.id }</th>
							<th width="1%"
								style="font-size: 12px;font-weight: normal;display: none">${f.class1.classid }</th>
							<th width="3%"
								style="font-size: 12px;font-weight: normal;width:3px;">${f.class1.classname }</th>
							<th width="1%"
								style="font-size: 12px;font-weight: normal;display: none">${f.stu.stuid }</th>
							<th width="1%" style="font-size: 12px;font-weight: normal;">${f.stu.stuname }</th>
							<th width="1%" style="font-size: 12px;font-weight: normal;">${f.jieshao }</th>
							<th width="1%" style="font-size: 12px;font-weight: normal;">${f.problem }</th>
							<th width="1%" style="font-size: 12px;font-weight: normal;">${f.sum }</th>
							<th width="1%" style="font-size: 12px;font-weight: normal;">${f.time }</th>
							<th width="1%" style="font-size: 12px;font-weight: normal;">${f.evalute }</th>
							<th width="3%" id="fen"
								style="font-size: 13px;font-weight: normal;"><a
								class="modifyUser" href="#"><img src="images/xiugai.png"
									alt="修改" title="修改" onclick="memUpdate(${ f.id},this)"></a>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div class="page-bar" style="font-size: 12px;">
				<ul class="page-num-ul clearfix">
					<c:if test="${ p.index!=1 }">
						<a href="iServlets?op=to&index=1&mem=${ memberAll.id}"
							style="font-size:14px ;line-height: 3px;">首页</a>
					</c:if>
					<a href="iServlets?op=to&index=${p.index-1 }&mem=${ memberAll.id}"
						style="font-size:14px ;line-height: 3px;">上一页</a>
					<a href="iServlets?op=to&index=${p.index+1 }&mem=${ memberAll.id}"
						style="font-size:14px ;line-height: 3px;">下一页</a>
					<c:if test="${ p.index!=p.totalPage }">
						<a
							href="iServlets?op=to&index=${p.totalPage }&mem=${ memberAll.id}"
							style="font-size:14px ;line-height: 3px;">尾页</a>
					</c:if>
					<span style="font-size:14px ;line-height: 3px;">一共 ${ p.totalPage }
						页，当前是${ p.index }</span>
				</ul>
				<span class="page-go-form" style="font-size: 14px;color: red">
				</span>
			</div>
			<div id="ooo" style="color: red;font-size: 15px;margin: 5px"></div>

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
	<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>

</body>
</html>
<script type="text/javascript" src="js/useradd.js"></script>

<script src="jquery-1.12.4.js"></script>
<script type="text/javascript">
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
//非空，查重
$(function(){
	$("#classId").bind(
			"change",
			function() {
				var id = $("#classId").val();
				$.getJSON("iServlets", "op=stuinfo&id=" + id,
						function(data) {
							$("#stu option:not(:first)").remove();
							for (var i = 0; i < data.length; i++) {
								$("#stu").append(
										"<option value='"+data[i].stuid+"'>"
												+ data[i].stuname);

							}
						});
			});
	
	
	 
	$("#classId").blur(function(){
		var typeName=$("#classId").val();
		if(typeName=="-1"){
			$("#m").html("非空");
			return false;
		}else{
			$("#m").html("");
		}
		return true;
	});
	
	$("#toAdds").click(function(){
		var typeName=$("#classId").val();
		if(typeName=="-1"){
			$("#m").html("非空");
			return false;
		}else{
			$("#m").html("");
		}
		return true;
		
		
	});
	
	$("#stu").blur(function(){
		var id=$("#stu").val();
		if(id==1){
			$("#c").html("已存在");
		}else{
			$("#c").html("");
		}
		  
	});
});
 


	function lood() {
		window.location.reload();
	}

	//下拉框绑定

	$(function() {
		$("#classId").bind(
				"change",
				function() {
					var id = $("#classId").val();
					$.getJSON("iServlets", "op=stuinfo&id=" + id,
							function(data) {
								$("#stu option:not(:first)").remove();
								for (var i = 0; i < data.length; i++) {
									$("#stu").append(
											"<option value='"+data[i].stuid+"'>"
													+ data[i].stuname);

								}
							});
				});

		//添加
		$("#toAdds").click(
				function() {
					var cid = $("#classId").val();
					var mem = $("#mem").val();
					var name = $("#stu").val();
					var evalute = $("#evalute").val();
					var time = $("#memtime").val();
					var zi = $("#zi").val();
					var pro = $("#pro").val();
					$.getJSON("iServlets", "op=add&name=" + name + "&cid="
							+ cid + "&evalute=" + evalute + "&time=" + time
							+ "&zi=" + zi + "&pro=" + pro + "&mem=" + mem,

					function(r) {
						if (r.re == "1") {
							$("#ooo").html("成功");
							setTimeout("lood()", 500);
						} else {
							$("#ooo").html("失败");
						}

					});

				});
	});

	//去修改
	function memUpdate(id, a) {
		var ids = id;
		$("#id").val(ids);
		var cid = $(a).parent().parent().parent().children().eq(1).html();
		var cname = $(a).parent().parent().parent().children().eq(2).html();
		var classArray = new Array();
		var classValueArray = new Array();
		$("#classId option").each(function() {
			var txt = $(this).text();
			var v = $(this).val();
			if (txt != "请选择") {
				classArray.push(txt);
				classValueArray.push(v);
			}
		});
		//遍历找到选中
		$(classArray).each(function(i, n) {
			if (n == cname) {
				$("#classId option[text='cid']").attr("selected", true);
			}
		});
		$(classValueArray).each(function(i, n) {
			if (n == cid) {
				$("#classId").val(cid);
			}
		});
		var stuid = $(a).parent().parent().parent().children().eq(3).html();
		var stuname = $(a).parent().parent().parent().children().eq(4).html();
		$("#stu").append(
				"<option value='"+stuid+"' selected>" + stuname + "</option>");

		var zi = $(a).parent().parent().parent().children().eq(5).html();
		var pro = $(a).parent().parent().parent().children().eq(6).html();
		var time = $(a).parent().parent().parent().children().eq(8).html();
		var evalute = $(a).parent().parent().parent().children().eq(9).html();
		$("#evalute").val(evalute);
		$("#zi").val(zi);
		$("#pro").val(pro);
		$("#memtime").val(time);
	}

	//修改
	$("#update").click(
			function() {
				var id = $("#id").val();
				var evalute = $("#evalute").val();
				var zi = $("#zi").val();
				var pro = $("#pro").val();
				var time = $("#memtime").val();
				var cid = $("#classId option:selected").val();
				var stuid = $("#stu option:selected").val();
				$.getJSON("iServlets", "op=toUpdate&id=" + id + "&evalute="
						+ evalute + "&zi=" + zi + "&pro=" + pro + "&stuid="
						+ stuid + "&cid=" + cid + "&time=" + time, function(r) {
					if (r.re == "1") {
						$("#ooo").html("修改成功");
						setTimeout("lood()", 500);
					} else {
						$("#ooo").html("抱歉，修改失败");
					}

				});

			});

	//页面



	function insert(mem) {
		location.href = "iServlets?op=to&index=1&mem=" + mem;
	}

	function look(id) {
		location.href = "iServlets?op=selectNow&id=" + id;
	}
</script>
