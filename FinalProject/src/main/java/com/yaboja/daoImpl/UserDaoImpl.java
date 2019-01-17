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
}
