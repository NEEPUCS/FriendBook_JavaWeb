<%@page import="com.bjsxt.pojo.Myfriend"%>
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
    
    <title>显示页---好友录</title>
    
<style type="text/css">
table,tr,td{border: 1px solid #666;border-collapse: collapse}
</style>

<script type="text/javascript">
/// 单选按钮的点击事件
function sel_radio(radio) {
	var mdf_link = document.getElementById("mdf_link");
	var id =radio.value;
	mdf_link.href ="mdf?id="+id;// 将链接提交到servlet
}
function check_del() {
	var dels = document.getElementsByName("dels");
	var flag = false;
	for(i=0;i<dels.length;i++){
		if(dels[i].checked==true){
			flag = true;
		}
	}
	if(flag==true){// 已经选中了，将选中的数据 提交到servlet中处理
		document.mydelete.submit();
		
	}else{
		alert("至少选中一条记录删除");
	}
}
function test() {
	alert("ok");
}
</script>

  </head>
  
  <body>
  
     <h1> 我的好友录</h1>
     <a href="add.jsp">增加新好友</a>
     <a href="javascript:void(0)" id="mdf_link">修改选中好友</a>
     <a href="javascript:void(0)" onclick="check_del()">删除选中好友</a>
     <!--<a href="index.jsp">返回主页</a> -->
    <hr>
    <!--   这里开始显示内容 -->
   
  <form action="delete" method="post" name="mydelete">
    <table>
    <tr>
    	<td width="50">修改</td>
    	<td width="50">删除</td>
    	<td width="50">姓名</td>
    	<td width="50">性别</td>
    	<td width="50">年龄</td>
    	<td width="150">tel</td>
    	<td width="150">qq</td>
    	<td width="250">email</td>
    	<td>address</td>
    </tr>
    
    <%
    List<Myfriend> mfs =null;
    if(session.getAttribute("mfs")!=null){
    	mfs = (List<Myfriend>)session.getAttribute("mfs");
    	//session.removeAttribute("mfs");
    }
    // 定义了四个变量
    int count;// 一共有多少条
    int pageNo=1;// 当前的页码
    int pageItem=15;// 每一页的条数
    int pageCount=0;// 总页数
    if(request.getParameter("pageNo")!=null){
    	pageNo = Integer.parseInt(request.getParameter("pageNo"));
    }
    if(mfs!=null){
    	count= mfs.size();
    	if(count % pageItem ==0)
    		pageCount = count/pageItem;
    	else
    		pageCount = count/pageItem+1;
    	//循环显示  32  3
    	for(int i =(pageNo-1)*pageItem;i<pageNo*pageItem && i<count;i++ ){
    			Myfriend mf = mfs.get(i);
    		%>
	    <tr>
	    <!-- 为单选按钮添加js点击事件，在点击事件中 获取单选按钮的ID，并修改超链接文本 -->
	    	<td><input type="radio" name="radio"  onclick="sel_radio(this)" value="<%=mf.getId()%>" />  </td>
	    	<td><input type="checkbox" name="dels" value="<%=mf.getId()%>"> </td>
	    	<td><%=mf.getName() %></td>
	    	<td><%=mf.getSex() %></td>
	    	<td><%=mf.getAge() %></td>
	    	<td><%=mf.getTelephone() %></td>
	    	<td><%=mf.getQq() %></td>
	    	<td><%=mf.getEmail() %></td>
	    	<td><%=mf.getAddress() %></td>
	    </tr>
    		<%
    	}
    }
    %>

    </table>
    </form>
    <!--  %
    	if(pageNo>1)
    		out.println("<a href ='friendsInfo.jsp?pageNo="+(pageNo-1)+"'>[上一页]</a>");
    
    	for(int i=1;i<=pageCount;i++){
    		if(pageNo==i)
    			out.println("["+i+"]");
    		else
    			out.println("<a href ='friendsInfo.jsp?pageNo="+i+"'>["+i+"]</a>");	
    	}
    	
    	if(pageNo<pageCount)
    		out.println("<a href='friendsInfo.jsp?pageNo="+(pageNo+1)+"'>[下一页]</a>");
    %-->
    
    <hr>
    <!-- ----------------------------------------- -->
    <%
    if(pageNo>1){
    %>
    	<a href = "friendsInfo.jsp?pageNo=<%=pageNo-1%>">[上一页]</a>
 	<%
    }
    // 当前页
    for(int i =1;i<=pageCount;i++){
    		if(pageNo ==i){
    			%>
    			[<%=i %>]
    			<%
    		}else{		
    	%>
    		<a href ="friendsInfo.jsp?pageNo=<%=i%>">[<%=i %>]</a>
    	<%
    		}
    }
    if(pageNo<pageCount){
    	%>
    	<a href = "friendsInfo.jsp?pageNo=<%=pageNo+1%>">[下一页]</a>
    <%	
    }
    %>
    
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
