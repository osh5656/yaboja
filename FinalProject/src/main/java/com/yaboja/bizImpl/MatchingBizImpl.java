package com.yaboja.bizImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yaboja.biz.MatchingBiz;
import com.yaboja.daoImpl.MatchingDaoImpl;
@Service
public class MatchingBizImpl implements MatchingBiz {

	@Autowired
	MatchingDaoImpl dao;
}
