package com.bjsxt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bjsxt.pojo.Myfriend;
import com.bjsxt.service.MyFriendService;
import com.bjsxt.service.impl.MyFriendServiceImp;


public class MyMdf extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));// ��ȡID
		MyFriendService  service = new MyFriendServiceImp();// ����service
		Myfriend  mf = service.selectById(id);// ͨ��service�е�selectById ����Ҫ�޸ĵĶ���
		HttpSession  session = request.getSession();
		session.setAttribute("myfriend", mf);// ��Ҫ�޸ĵ����� ����Ҫ��ʾҳ��  ׼���޸�
		response.sendRedirect("update.jsp");// ��ת����ʾҳ��
		
		
	}

}
