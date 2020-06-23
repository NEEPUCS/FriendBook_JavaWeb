package com.bjsxt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bjsxt.dao.MyFriendDao;
import com.bjsxt.dao.impl.MyFriendDaoImp;
import com.bjsxt.pojo.Myfriend;
import com.bjsxt.pojo.User;



public class ShowByName extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String name = request.getParameter("sname");
		
		HttpSession  session = request.getSession();
		User  user = (User)session.getAttribute("login");
		// ����service����
		MyFriendDao   dao = new MyFriendDaoImp();
		List<Myfriend>  list =dao.listByName(user.getUid(), name);
		session.setAttribute("mfs", list);
		response.sendRedirect("friendsInfo.jsp");
		
	}

}
