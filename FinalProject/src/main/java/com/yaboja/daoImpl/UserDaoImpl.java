package com.yaboja.daoImpl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yaboja.dao.UserDao;
import com.yaboja.dto.UserDto;
@Repository
public class UserDaoImpl implements UserDao {

   @Autowired
   private SqlSessionTemplate sqlSession;

   @Override
   public UserDto getLogin(String userid, String userpw) {
      UserDto res = null;
      UserDto dto = new UserDto();
      dto.setUserid(userid);
      dto.setUserpw(userpw);
      try {
         res = sqlSession.selectOne(namespace+"selectOne",dto);
      }catch(Exception e) {
         System.out.println("selectOne 에러");
         e.printStackTrace();
      }
      return res;
   }

   @Override
   public UserDto selectOne(String userid) {
      UserDto dto = sqlSession.selectOne(namespace+"userOne",userid);
      return dto;
   }

   @Override
   public int update(UserDto dto) {
      System.out.println("mappertest시작전");
      System.out.println(dto);
      int res = sqlSession.update(namespace + "userUpdate",dto);
      System.out.println("mappertest시작후"+res);
      System.out.println("dao id : "+ dto.toString());
      return res;
   }

   @Override
   public int delete(String userid) {
      int res = sqlSession.delete(namespace + "userDelete",userid);
      return res;
   }
}