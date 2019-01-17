package com.yaboja.biz;

import com.yaboja.dto.UserDto;

public interface UserBiz {

	public UserDto getLogin(String userid, String userpw);
}
