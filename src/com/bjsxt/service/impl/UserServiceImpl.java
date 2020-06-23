package com.bjsxt.service.impl;

import com.bjsxt.dao.UserDao;
import com.bjsxt.dao.impl.UserDaoImpl;
import com.bjsxt.pojo.User;
import com.bjsxt.service.UserService;

public class UserServiceImpl implements UserService {
	//创建Dao对象
	UserDao ud = new UserDaoImpl();
	
	
	@Override
	public User getUserInfoService(String uname, String pwd) {
		//处理登录业务
		return ud.getUserInfoDao(uname,pwd);
	}

	
	//用户注册
	@Override
	public int getUserInfoService(String uname, String pwd, String sex,
			int age, String birthday) {
		//处理注册业务
		return ud.regUserInfoDao(uname,pwd,sex,age,birthday);
	}

}
