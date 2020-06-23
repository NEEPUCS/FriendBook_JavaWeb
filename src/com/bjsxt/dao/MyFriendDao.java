package com.bjsxt.dao;

import java.util.List;
import com.bjsxt.pojo.Myfriend;

public interface MyFriendDao {

	public List<Myfriend>  list(int userid);
	public List<Myfriend>  listByName(int userid,String name);
	public Myfriend  selectById(int id);

	public boolean insert(Myfriend  myfriend);

	public boolean update(Myfriend  myfriend);

	public boolean delete(int id);

}
