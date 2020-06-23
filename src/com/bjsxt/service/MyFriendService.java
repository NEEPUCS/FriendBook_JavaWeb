package com.bjsxt.service;

import java.util.List;

import com.bjsxt.pojo.Myfriend;

import com.bjsxt.servlet.MyFilter;


public interface MyFriendService {
	public List list(int userid);
	public List listByName(int userid,String name);
	public Myfriend selectById(int id);
	public boolean insert(Myfriend mf);
	public boolean update(Myfriend mf);
	public boolean delete(int id);
}
