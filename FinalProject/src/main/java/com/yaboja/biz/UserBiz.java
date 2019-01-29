package com.yaboja.biz;

import com.yaboja.dto.UserDto;

public interface UserBiz {


	public UserDto selectOne(int userseq);

   public UserDto getLogin(String userid, String userpw);
   //마이페이지
   public UserDto selectOne1(String userid);
   public int update(UserDto dto);
   public int delete(String userid);
}

