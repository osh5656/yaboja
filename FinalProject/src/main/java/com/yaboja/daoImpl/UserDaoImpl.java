package com.yaboja.daoImpl;

import java.util.HashMap;
import java.util.Map;

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
	public UserDto selectOne(String id) {
		UserDto dto = null;

		try {
			dto = sqlSession.selectOne(namespace + "selectOne", id);
		} catch (Exception e) {
			System.out.println("selectOne 에러");
			e.printStackTrace();
		}
		return dto;
	}

	public int insert(UserDto userdto) {
		int res=0;
				
		try {
			
			userdto.setUsergrade("user");
			res=sqlSession.insert(namespace+"insert", userdto);

		} catch (Exception e) {
			System.out.println(namespace+"insert 에러");
			e.printStackTrace();
		}
		return res;
	}
	public UserDto login(String userid, String userpw) {
		UserDto userdto = null;
		Map<String, String> map= new HashMap<String, String>();
		map.put("userid", userid);
		map.put("userpw", userpw);

		try {
			userdto= sqlSession.selectOne(namespace+"Login", map);
//			System.out.println(userdto);
		} catch (Exception e) {
			System.out.println("login 에러(userDao.login)");
		}
		return userdto;
	}
}
