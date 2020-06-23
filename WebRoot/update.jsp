<%@page import="com.bjsxt.pojo.Myfriend"%>
<%@page import="com.bjsxt.servlet.MyFilter"%>
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
    
    <title>修改选中好友---好友录</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
table,tr,td{border: 1px solid #999;border-collapse: collapse;}
table{width: 300px;height: 300px;}
</style>
<script type="text/javascript">
function checkAdd() {
	var name = document.getElementById("name");
	var age = document.getElementById("age");
	var qq = document.getElementById("qq");
	var tel = document.getElementById("tel");
	var email = document.getElementById("email");
	var address = document.getElementById("address");
	if(name.value=="" || name.value.length<2){
		alert("账号不能为空或长度小于2");
		name.focus();
		return false;
	}
	if(age.value==""){
		alert("年龄不能为空");
		age.focus();
		return false;
	}
	if(qq.value=="" || qq.value.length<5){
		alert("qq不能为空或长度小于5");
		qq.focus();
		return false;
	}
	if(tel.value=="" || tel.value.length<7){
		alert("电话不能为空或长度小于7");
		tel.focus();
		return false;
	}
	if(email.value=="" || email.value.length<3){
		alert("邮箱不能为空或长度小于3");
		email.focus();
		return false;
	}
	if(address.value=="" || address.value.length<3){
		alert("地址不能为空或长度小于3");
		address.focus();
		return false;
	}
	
	
}
</script>
  </head>
  
  <body>
  <%
  	Myfriend  mf= null;
  	String  m_chk="";
  	String  f_chk="";
  if(session.getAttribute("myfriend")!=null){
	  mf = (Myfriend)session.getAttribute("myfriend");
	  session.removeAttribute("myfriend");
	  
	  if(mf.getSex().equals("M"))
		  m_chk = "checked";
	  else
		  f_chk = "checked";
  }
  %>
    <h1> 我的好友录</h1>
    <hr>
    <center>
    <form action="update" method="post" onsubmit="return checkAdd()">
    	<input type="hidden" name="id" value="<%=mf.getId()%>">
      	<input type="hidden" name="userid" value="<%=mf.getUserid()%>">
    <h2>修改好友</h2>
    	<table>
    	<tr>
    		<td>名字</td>
    		<td align="center"><input type="text" name="name" id="name" value="<%=mf.getName() %>" /></td>
    	</tr>
    	<tr>
    		<td>性别</td>
    		<td align="center">
    		<input type="radio" name="sex" value="M" <%=m_chk %>>男
    		<input type="radio" name="sex" value="F" <%=f_chk %>>女
    		</td>
    	</tr>
    	<tr>
    		<td>年龄</td>
    		<td align="center"><input type="text" name="age" id="age" value="<%=mf.getAge() %>" /></td>
    	</tr>
    	<tr>
    		<td>QQ</td>
    		<td align="center"><input type="text" name="qq" id="qq" value="<%=mf.getQq() %>" /></td>
    	</tr>
    	<tr>
    		<td>电话</td>
    		<td align="center"><input type="text" name="tel" id="tel" value="<%=mf.getTelephone() %>" /></td>
    	</tr>
    	<tr>
    		<td>email</td>
    		<td align="center"><input type="text" name="email" id="email" value="<%=mf.getEmail() %>" /></td>
    	</tr>
    	<tr>
    		<td>地址</td>
    		<td align="center"><input type="text" name="address" id="address" value="<%=mf.getAddress() %>" /></td>
    	</tr>
    	<tr>
    		<td colspan="2" align="center">
    		<input type="submit" value="修改" />
    		<input type="reset"  value="重置" />
			</td>
    		
    	</tr>
    	</table>
    
    </form>
    </center>
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
