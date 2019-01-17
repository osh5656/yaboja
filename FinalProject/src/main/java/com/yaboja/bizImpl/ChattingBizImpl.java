package com.yaboja.bizImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yaboja.biz.ChattingBiz;
import com.yaboja.daoImpl.ChattingDaoImpl;
@Service
public class ChattingBizImpl implements ChattingBiz {

	@Autowired
	ChattingDaoImpl dao;
}
