package com.yaboja.bizImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yaboja.biz.MatchingboardBiz;
import com.yaboja.daoImpl.MatchingboardDaoImpl;
@Service
public class MatchingboardBizImpl implements MatchingboardBiz {

	@Autowired
	MatchingboardDaoImpl dao;
}
