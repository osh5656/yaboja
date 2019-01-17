package com.yaboja.bizImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yaboja.biz.ReviewboardcomentBiz;
import com.yaboja.daoImpl.ReviewboardcomentDaoImpl;
@Service
public class ReviewboardcomentBizImpl implements ReviewboardcomentBiz {

	@Autowired
	ReviewboardcomentDaoImpl dao;
}
