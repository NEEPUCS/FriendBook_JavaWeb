package com.bjsxt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bjsxt.pojo.Myfriend;
import com.bjsxt.pojo.User;
import com.bjsxt.service.MyFriendService;
import com.bjsxt.service.impl.MyFriendServiceImp;



public class MyAdd extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
		
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		User user = (User)(session.getAttribute("login"));
		//int userid = user.getUid();
		int userid=user.getUid();
		System.out.println(userid);
		String name= request.getParameter("name");
		String sex = request.getParameter("sex");
		int age = Integer.parseInt(request.getParameter("age"));
		String qq = request.getParameter("qq");
		String tel = request.getParameter("tel");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		Myfriend  mf = new Myfriend();
		mf.setUserid(userid);
		mf.setName(name);
		mf.setSex(sex);
		mf.setAge(age);
		mf.setQq(qq);
		mf.setTelephone(tel);
		mf.setEmail(email);
		mf.setAddress(address);
		System.out.println(mf);
		MyFriendService service = new MyFriendServiceImp();
		if(service.insert(mf))
			response.sendRedirect("showAll");
		else
			response.sendRedirect("error.jsp");
		
	}

}
