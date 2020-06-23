package com.bjsxt.service;

import com.bjsxt.pojo.User;

public interface UserService {
	/**用户登陆
	 * 
	 * @param uname
	 * @param pwd
	 * @return
	 */
	User getUserInfoService(String uname, String pwd);
	
	/**用户注册
	 * 
	 * @param uname
	 * @param pwd
	 * @param sex
	 * @param age
	 * @param birthday
	 * @return
	 */
	int getUserInfoService(String uname, String pwd, String sex, int age,
			String birthday);
	
}
