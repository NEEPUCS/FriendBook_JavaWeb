package com.bjsxt.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class BaseServlet extends HttpServlet {
	@Override
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
	}
}
