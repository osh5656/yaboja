package com.yaboja.biz;

import com.yaboja.dto.UserDto;

public interface UserBiz {

	public UserDto selectOne(String id);
	public int insert(UserDto userdto);
	public UserDto login(String userid,String userpw);

}
