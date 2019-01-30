package com.yaboja.dao;

import com.yaboja.dto.UserDto;

public interface UserDao {
   String namespace="user.";
   
   public UserDto getLogin(String userid, String userpw);
   //내정보보기
   public UserDto selectOne(int userseq);
   //내정보수정
   public int update(UserDto dto);
   //회원탈퇴
   public int delete(String userid);
   
   public UserDto selectOne1(String userid);
      
   
}