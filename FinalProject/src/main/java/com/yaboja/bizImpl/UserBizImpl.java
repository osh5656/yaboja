package com.yaboja.bizImpl;

import java.util.List;

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

	public UserDto selectOne(String id) {
		UserDto dto=dao.selectOne(id);
		return dto;
	}

	public int insert(UserDto userdto) {
		return dao.insert(userdto);
	}
	public UserDto login(String userid,String userpw) {
		return dao.login(userid,userpw);

	}
	public List<UserDto> selectAll(){
		return dao.selectAll();
	}

	@Override
	public int updateUser(int userseq, String grade) {
		return dao.updateUser(userseq,grade);
	}
}
