<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!DOCTYPE html>
<html lang="zh-cn">
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title></title>
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<script src="js/jquery.js"></script>
<script src="js/pintuer.js"></script>
</head>
<body>
<div class="panel admin-panel">
  <div class="panel-head"><strong><span class="icon-key"></span>新用户注册 </strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="data">
    <input type="hidden" name="method" value="UserReg" />
           
      <div class="form-group">
        <div class="label">
          <label for="sitename">用户名：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" id="mpass" name="uname" size="50" placeholder="请输入新用户名" data-validate="required:请输入原始密码" />       
        </div>
      </div>      
      <div class="form-group">
        <div class="label">
          <label for="sitename">新密码：</label>
        </div>
        <div class="field">
          <input type="password" class="input w50" name="pwd" size="50" placeholder="请输入新密码" data-validate="required:请输入新密码,length#>=5:新密码不能小于5位" />         
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label for="sitename">确认新密码：</label>
        </div>
        <div class="field">
          <input type="password" class="input w50" name="" size="50" placeholder="请再次输入新密码" data-validate="required:请再次输入新密码,repeat#pwd:两次输入的密码不一致" />          
        </div>
      </div>
      	<div style="position:relative;left:100px; top:-10px">
      		性别：男<input type="radio" name="sex" value="男" checked="checked">女<input type="radio" name="sex" value="女" >
      	</div>
      	<!-- 年龄 -->
      	<div class="form-group">
        <div class="label">
          <label for="sitename">年龄：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" id="mpass" name="age" size="50" placeholder="请输入年龄"  />       
        </div>
      </div>      
        <!-- 出生日期 -->
      <div class="form-group">
        <div class="label">
          <label for="sitename">出生日期：</label>
        </div>
        <div class="field">
          <input type="date" class="input w50" id="mpass" name="birthday" size="50"  />       
        </div>
        
      </div>      
      <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="field">
          <button class="button bg-main icon-check-square-o" type="submit"> 提交</button>   
        </div>
      </div>      
    </form>
  </div>
</div>
</body></html>
