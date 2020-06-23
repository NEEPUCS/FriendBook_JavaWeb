package com.bjsxt.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bjsxt.dao.MyFriendDao;
import com.bjsxt.pojo.Myfriend;
import com.bjsxt.util.DBUtil;



public class MyFriendDaoImp implements MyFriendDao{

	@Override
	public List<Myfriend> list(int userid) {
		Connection  conn = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet  rs=null;
		ArrayList<Myfriend>  mfs = null;
		try {
			ps = conn.prepareStatement("select * from myfriend where userid=? order by ID DESC");
			ps.setInt(1, userid);
			rs = ps.executeQuery();
			if(rs!=null){
				mfs = new ArrayList<Myfriend>();
				while(rs.next()){
					Myfriend  mf = fillMyFriend(rs);
					mfs.add(mf);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBUtil.closeAll(rs, ps, conn);
		return mfs;
	}

	@Override
	public List<Myfriend> listByName(int userid, String name) {
		Connection  conn = DBUtil.getConnection();
		PreparedStatement ps;
		ResultSet  rs=null;
		ArrayList<Myfriend>  mfs = null;
		try {

			ps = conn.prepareStatement("select * from myfriend where userid=? and name like '%"+name+"%' order by ID DESC");
			ps.setInt(1, userid);
			rs = ps.executeQuery();
			if(rs!=null){
				mfs = new ArrayList<Myfriend>();
				while(rs.next()){
					Myfriend  mf=fillMyFriend(rs);
					mfs.add(mf);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBUtil.closeAll(rs, null, conn);
		return mfs;
	}

	/**
	 * �����º���
	 * */
	@Override
	public boolean insert(Myfriend myfriend) {
		Connection  conn= DBUtil.getConnection();
		PreparedStatement ps;
		int res = 0;
		try {
			ps = conn.prepareStatement("insert into myfriend(userid,name,sex,age,qq,telephone,email,address) values(?,?,?,?,?,?,?,?)");
			ps.setInt(1, myfriend.getUserid());
			ps.setString(2, myfriend.getName());
			ps.setString(3, myfriend.getSex());
			ps.setInt(4, myfriend.getAge());
			ps.setString(5, myfriend.getQq());
			ps.setString(6, myfriend.getTelephone());
			ps.setString(7, myfriend.getEmail());
			ps.setString(8, myfriend.getAddress());
			res =ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBUtil.closeAll(null, null, conn);
		if(res>0)
			return true;
		else
			return false;
	}

	@Override
	public boolean update(Myfriend myfriend) {
		// TODO Auto-generated method stub
		Connection  conn= DBUtil.getConnection();
		int res=0;
		try {
			PreparedStatement  ps = conn.prepareStatement("update myfriend set userid=?,name=?,sex=?,age=?,qq=?,telephone=?,email=?,address=? where id=?");
			ps.setInt(1, myfriend.getUserid());
			ps.setString(2, myfriend.getName());
			ps.setString(3, myfriend.getSex());
			ps.setInt(4, myfriend.getAge());
			ps.setString(5, myfriend.getQq());
			ps.setString(6, myfriend.getTelephone());
			ps.setString(7, myfriend.getEmail());
			ps.setString(8, myfriend.getAddress());
			ps.setInt(9, myfriend.getId());
			res = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBUtil.closeAll(null, null, conn);
		if(res>0)
			return true;
		else
			return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		Connection  conn= DBUtil.getConnection();
		int res =0;
		try {
			PreparedStatement  ps = conn.prepareStatement("delete from myfriend where id=?");
			ps.setInt(1, id);
			res = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBUtil.closeAll(null, null, conn);
		if(res>0)
			return true;
		else
			return false;
	}

	/**
	 * ��ID ��ѯ��ǰ��¼
	 * */
	@Override
	public Myfriend selectById(int id) {
		// TODO Auto-generated method stub
		Connection  conn= DBUtil.getConnection();
		Myfriend  mf = null;
		try {
			PreparedStatement ps = conn.prepareStatement("select * from myfriend where id=?");
			ps.setInt(1, id);
			ResultSet  rs = ps.executeQuery();
			if(rs!=null){
				if(rs.next()){
					mf = fillMyFriend(rs);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBUtil.closeAll(null, null, conn);
		return mf;
	}
	/**
	 * ��װ���� ���� resultSet  ����myFriend
	 * */
	public Myfriend fillMyFriend(ResultSet  rs){
		Myfriend  mf =null;
		if(rs!=null)
		try {
			mf = new Myfriend();
			mf.setId(rs.getInt("id"));
			mf.setUserid(rs.getInt("userid"));
			mf.setName(rs.getString("name"));
			mf.setAge(rs.getInt("age"));
			mf.setSex(rs.getString("sex"));
			mf.setQq(rs.getString("qq"));
			mf.setTelephone(rs.getString("telephone"));
			mf.setEmail(rs.getString("email"));
			mf.setAddress(rs.getString("address"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mf;
	}


}
