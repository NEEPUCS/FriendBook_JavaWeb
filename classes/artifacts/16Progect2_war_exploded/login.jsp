<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!-- 
	添加前端代码书写插件
		插件在资料中，将查询包放到myEclipse的安装目录中的drops文件中，然后重启myEclipse即可。
		安装后快捷键为:ctrl+E
	模版套用:
		在自己的项目中创建模版对应的jsp文件
		将jsp文件中的basepath代码移动到其他位置
		然后将模版中的HTML代码整个复制到对应的jsp中
		然后将basepath在移动会head标签中
		将模版中的前端资源文件复制到webRoot下。
 --> 

 
 <!DOCTYPE html>
<html lang="zh-cn">
<head>
	<base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title>登录</title>  
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    <script src="js/jquery.js"></script>
    <script src="js/pintuer.js"></script>  
</head>
<body>
<div class="bg"></div>
<div class="container">
    <div class="line bouncein">
        <div class="xs6 xm4 xs3-move xm4-move">
            <div style="height:150px;"></div>
            <div class="media media-y margin-big-bottom">           
            </div>         
            <form action="data" method="get">
            
            <!-- 声明处理请求的方法 -->
            <input type="hidden" name="method" value="Userlogin" />
            <div class="panel loginbox">
                <div class="text-center margin-big padding-big-top"><h1>超级管理系统</h1></div>
                
                <!-- 声明java代码块 -->
                <% 
                //获取session中的标记
                Object obj =session.getAttribute("flag"); 
               		if(obj!=null){ 
               			if("loginfalse".equals((String)obj)){ %>
               			<div style="text-align:center;color:red"; ><h1>用户名或密码错误</h1></div>
		              <%
		               	 }else if("regsuccess".equals((String)obj)){
			              %>
			            <div style="text-align:center;color:red"; ><h1>新用户注册成功</h1></div>
	         	     <%
	               		}
	               	}
	               		session.invalidate();/* 销毁session */
	                %>
                
                <div class="panel-body" style="padding:30px; padding-bottom:10px; padding-top:10px;">
                    <div class="form-group">
                        <div class="field field-icon-right">
                            <input type="text" class="input input-big" name="uname" placeholder="登录账号" data-validate="required:请填写账号" />
                            <span class="icon icon-user margin-small"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="field field-icon-right">
                            <input type="password" class="input input-big" name="pwd" placeholder="登录密码" data-validate="required:请填写密码" />
                            <span class="icon icon-key margin-small"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="field">
                            <input type="text" class="input input-big" name="code" placeholder="填写右侧的验证码" data-validate="required:请填写右侧的验证码" />
                           <img src="images/passcode.jpg" alt="" width="100" height="32" class="passcode" style="height:43px;cursor:pointer;" onclick="this.src=this.src+'?'">  
                                                   
                        </div>
                    </div>
                </div>
                <div style="padding:30px;"><input type="submit" class="button button-block bg-main text-big input-big" value="登录"></div>
                <div style="font-size:20px; position:relative;left:300px;top:-20px"><a href="reg.jsp">注册</a></div>
            </div>
            </form>          
        </div>
    </div>
</div>

</body>
</html>
