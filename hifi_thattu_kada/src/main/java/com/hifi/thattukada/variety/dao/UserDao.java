package com.hifi.thattukada.variety.dao;

import java.util.List;

import com.hifi.thattukada.variety.vo.UserVO;

public interface UserDao {
	public List userList();
	public boolean userLogin(UserVO userVo);
}
