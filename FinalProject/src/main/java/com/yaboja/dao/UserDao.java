package com.yaboja.dao;

import com.yaboja.dto.UserDto;

public interface UserDao {
	String namespace="user.";
	
	public UserDto selectOne(String id);
	public int insert(UserDto userdto);
	public UserDto login(String userid, String userpw);
}
