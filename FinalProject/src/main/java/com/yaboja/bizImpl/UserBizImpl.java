package com.yaboja.bizImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yaboja.biz.UserBiz;
import com.yaboja.daoImpl.UserDaoImpl;
import com.yaboja.dto.UserDto;
@Service
public class UserBizImpl implements UserBiz {

   @Autowired
   UserDaoImpl dao;

   @Override
   public UserDto getLogin(String userid, String userpw) {
      return dao.getLogin(userid,userpw);
   }

   @Override
   public UserDto selectOne(String userid) {
      return dao.selectOne(userid);
   }

   @Override
   public int update(UserDto dto) {
      return dao.update(dto);
   }

   @Override
   public int delete(String userid) {
      return dao.delete(userid);
   }
}