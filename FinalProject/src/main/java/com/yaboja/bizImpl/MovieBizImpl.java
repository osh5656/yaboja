package com.yaboja.bizImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yaboja.biz.MovieBiz;
import com.yaboja.daoImpl.MovieDaoImpl;
@Service
public class MovieBizImpl implements MovieBiz {

	@Autowired
	MovieDaoImpl dao;
}
