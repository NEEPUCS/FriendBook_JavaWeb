package com.bjsxt.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bjsxt.dao.UserDao;
import com.bjsxt.pojo.User;
import com.bjsxt.util.DBUtil;
/**
 * 导的不是jdbc包，全是sql包
 *
 */
public class UserDaoImpl implements UserDao {
	//查询用户信息
	@Override
	public User getUserInfoDao(String uname, String pwd) {
		//声明jdbc变量
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		//声明变量
		User u=null;
		
		try {
			
			//创建连接
			conn=DBUtil.getConnection();
			//创建sql命令
			String sql="select * from t_user where uname=? and pwd=?";
			//创建SQL命令对象
			ps=conn.prepareStatement(sql);
			//给占位符赋值
			ps.setString(1,	uname);
			ps.setString(2, pwd);
			//执行sql命令
			rs=ps.executeQuery();
			//遍历
			while (rs.next()) {
				//给变量赋值
				u=new User();
				u.setUid(rs.getInt("uid"));
				u.setUname(rs.getString("uname"));
				u.setPwd(rs.getString("pwd"));
				u.setSex(rs.getString("sex"));
				u.setAge(rs.getInt("age"));
				u.setBirthday(rs.getString("birthday"));
			}
			//关闭资源
			//返回结果
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeAll(rs, ps, conn);
		}
		
		return u;
	}

	//用户注册
	@Override
	public int regUserInfoDao(String uname, String pwd, String sex, int age,
			String birthday) {
		
		//创建sql语句
		String sql="insert into t_user values(default,?,?,?,?,?)";
		return DBUtil.executeDML(sql, uname,pwd,sex,age,birthday);
	}

}
