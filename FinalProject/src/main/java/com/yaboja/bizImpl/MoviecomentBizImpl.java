package com.yaboja.bizImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yaboja.biz.MoviecomentBiz;
import com.yaboja.daoImpl.MoviecomentDaoImpl;
@Service
public class MoviecomentBizImpl implements MoviecomentBiz {

	@Autowired
	MoviecomentDaoImpl dao;
}
