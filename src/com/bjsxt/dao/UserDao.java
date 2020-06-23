package com.bjsxt.dao;

import com.bjsxt.pojo.User;

public interface UserDao {
	/**
	 * 根据用户名和密码，查询用户信息
	 *
	 */
	User getUserInfoDao(String uname, String pwd);

	
	int regUserInfoDao(String uname, String pwd, String sex, int age,
			String birthday);

}
