package com.yaboja.dao;

import com.yaboja.dto.UserDto;

public interface UserDao {
	String namespace="user.";
	
	public UserDto getLogin(String userid, String userpw);
}
