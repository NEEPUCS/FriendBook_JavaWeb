package com.bjsxt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjsxt.pojo.Myfriend;
import com.bjsxt.service.MyFriendService;
import com.bjsxt.service.impl.MyFriendServiceImp;



public class MyUpdate extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		Myfriend  mf = new Myfriend();
		int id =Integer.parseInt(request.getParameter("id"));
		int userid = Integer.parseInt(request.getParameter("userid"));
		String name = request.getParameter("name");
		String sex = request.getParameter("sex");
		int age = Integer.parseInt(request.getParameter("age"));
		String qq = request.getParameter("qq");
		String tel = request.getParameter("tel");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		mf.setId(id);
		mf.setUserid(userid);
		mf.setName(name);
		mf.setSex(sex);
		mf.setAge(age);
		mf.setQq(qq);
		mf.setTelephone(tel);
		mf.setEmail(email);
		mf.setAddress(address);
		MyFriendService service = new MyFriendServiceImp();

		if(service.update(mf))
			response.sendRedirect("showAll");
		else
			response.sendRedirect("error.jsp");
		
		
	}

}
