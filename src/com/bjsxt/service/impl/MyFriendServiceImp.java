package com.bjsxt.service.impl;

import java.util.List;

import com.bjsxt.dao.MyFriendDao;
import com.bjsxt.dao.impl.MyFriendDaoImp;
import com.bjsxt.pojo.Myfriend;
import com.bjsxt.service.MyFriendService;



public class MyFriendServiceImp implements MyFriendService {

	private MyFriendDao dao = new MyFriendDaoImp();
	@Override
	public List list(int userid) {
		// TODO Auto-generated method stub
		return dao.list(userid);
	}

	@Override
	public List listByName(int userid, String name) {
		// TODO Auto-generated method stub
		return dao.listByName(userid, name);
	}

	@Override
	public Myfriend selectById(int id) {
		// TODO Auto-generated method stub
		return dao.selectById(id);
	}

	@Override
	public boolean insert(Myfriend mf) {
		// TODO Auto-generated method stub
		return dao.insert(mf);
	}

	@Override
	public boolean update(Myfriend mf) {
		// TODO Auto-generated method stub
		return dao.update(mf);
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return dao.delete(id);
	}

}
