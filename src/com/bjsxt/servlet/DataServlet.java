package com.bjsxt.servlet;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bjsxt.pojo.User;
import com.bjsxt.service.UserService;
import com.bjsxt.service.impl.UserServiceImpl;


public  class DataServlet extends BaseServlet {
	/*@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//设置请求、响应编码格式
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		//获取请求信息
		String methodName = req.getParameter("method");
		//处理请求信息(动态调用方法处理请求--》反射)
			try {
				//反射方法获取所在类的类对象
				Class cla = this.getClass();
				//反射方法获取要被调用的方法对象
				Method m= cla.getMethod(methodName, HttpServletRequest.class,HttpServletResponse.class);
				//反射执行的方法
				m.invoke(this, req,resp);
			} catch (Exception e) {
				e.printStackTrace();
			} 
	}*/
	
	
	//登陆处理方法
	public void Userlogin(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		//获取请求信息
				String uname = req.getParameter("uname");
				String pwd = req.getParameter("pwd");
				//处理请求信息
				System.out.println("DataServlet.Userlogin()"+uname+":"+pwd);
				
					//创建业务层对象
					UserService us = new UserServiceImpl();
					User u= us.getUserInfoService(uname,pwd);
					req.getSession().setAttribute("login", u);
					System.out.println("用户查询登陆结果为："+u);
					
					

				//响应处理结果
					//直接响应	
					//请求转发
					
					//获取session对象
					HttpSession hs = req.getSession();
					
					if (u!=null) {//登陆成功
						//将用户信息存储到session
						hs.setAttribute("user", u);
						
						//重定向到mian.jsp
						resp.sendRedirect("/16/main.jsp");
					}else {//登录失败
						//将登陆标记添加
						hs.setAttribute("flag", "loginfalse");
						//重定向到login.jsp
						resp.sendRedirect("/16/login.jsp");
					}
	}
	//退出处理方法
	public void UserOut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		//获取请求信息
		//处理请求信息
			//获取session、销毁session
			HttpSession hs = req.getSession();
			hs.invalidate();
		//相应处理结果
			//直接响应
			//请求转发
			//重定向
		resp.sendRedirect("/16/login.jsp");
		}
	//注册处理方法
	public void UserReg(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		//获取请求信息
				String uname = req.getParameter("uname");
				String pwd = req.getParameter("pwd");
				String sex = req.getParameter("sex");
				int age =Integer.parseInt(req.getParameter("age")) ;
				String birthday = req.getParameter("birthday");
				//处理请求信息
					//获取业务层对象
				    UserService us = new UserServiceImpl();
				     //处理注册
				    int i=us.getUserInfoService(uname, pwd,sex,age,birthday);
				    
				//相应处理结果
				    //获取session对象
				    HttpSession hs = req.getSession();
					//重定向到登陆界面
				    if(i>0){
						//注册成功，添加标记到session
				    	hs.setAttribute("flag", "regsuccess");
						resp.sendRedirect("/16/login.jsp");
					}else{
						//重定向到注册页面
						resp.sendRedirect("/16/login.jsp");
					}
	}
}
