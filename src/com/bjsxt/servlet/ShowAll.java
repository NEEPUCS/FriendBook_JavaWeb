package com.bjsxt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bjsxt.pojo.Myfriend;
import com.bjsxt.pojo.User;
import com.bjsxt.service.MyFriendService;
import com.bjsxt.service.impl.MyFriendServiceImp;



public class ShowAll extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession  session = request.getSession();
		User user = (User)session.getAttribute("login");
		System.out.println("session user:"+user);
		System.out.println("session Uid:"+user.getUid());
		MyFriendService ms = new MyFriendServiceImp();
		List<Myfriend>  list = ms.list(user.getUid());
		
		session.setAttribute("mfs", list);
		response.sendRedirect("friendsInfo.jsp");
	}

}
