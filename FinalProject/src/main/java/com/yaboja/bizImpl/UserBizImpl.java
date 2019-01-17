package com.yaboja.bizImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yaboja.biz.UserBiz;
import com.yaboja.daoImpl.UserDaoImpl;
@Service
public class UserBizImpl implements UserBiz {

	@Autowired
	UserDaoImpl dao;
}
