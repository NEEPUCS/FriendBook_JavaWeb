<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
	function show_selName() {
		var selShow = document.getElementById("sel_name");
		if(selShow.style.display==""){
			selShow.style.display="none";
		}else{
			selShow.style.display="";
		}
	}
	</script>
  </head>
  
  <body>
    <h1> 我的好友录</h1>
    <hr>
    <%
    request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
	System.out.print("用户信息："+session.getAttribute("login"));
    if(session.getAttribute("login")!=null){
    %>
    <div style="float: right; margin-top: -40px;margin-right: 50px"><a href ="exit">注销</a></div>
   <p><a href ="java:void(0)" onclick="show_selName()">按名字查询好友  </a></p>
    <div id = "sel_name" style="display: none;">
    <form action="showByName" method="post">
    <input type="text" name="sname" /> &nbsp;<input type="submit" value="查询">
    </form>
    </div>
    
    <%
    }else{
    %>
   <h2> 你还没有权限查看此页面，请先<a href ="login.jsp">登录</a></h2>
    <%} %>
    <hr>
    当前时间：
    <%
    	Date  date = new Date();
    	SimpleDateFormat  sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    	String time =sdf.format(date);
    	out.print(time);
    %>
  </body>
</html>
