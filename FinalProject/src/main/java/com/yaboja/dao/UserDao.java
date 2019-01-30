package com.yaboja.dao;

import java.util.List;

import com.yaboja.dto.UserDto;

public interface UserDao {
	String namespace="user.";
	

	public UserDto selectOne(String id);
	public int insert(UserDto userdto);
	public UserDto login(String userid, String userpw);
	public List<UserDto> selectAll();
	public int updateUser(int userseq, String grade);
}
