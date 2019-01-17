package com.yaboja.bizImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yaboja.biz.ReviewboardBiz;
import com.yaboja.daoImpl.ReviewboardDaoImpl;
@Service
public class ReviewboardBizImpl implements ReviewboardBiz {

	@Autowired
	ReviewboardDaoImpl dao;
}
