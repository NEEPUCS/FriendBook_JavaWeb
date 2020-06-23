package com.bjsxt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjsxt.service.MyFriendService;
import com.bjsxt.service.impl.MyFriendServiceImp;



public class MyDelete extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String [] ids = request.getParameterValues("dels");
		MyFriendService service = new MyFriendServiceImp();
		
		for(String sid : ids){
			int  id = Integer.parseInt(sid);
			service.delete(id);
		}
		response.sendRedirect("showAll");
		
	}

}
