package com.yaboja.bizImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yaboja.biz.CoinBiz;
import com.yaboja.daoImpl.CoinDaoImpl;
@Service
public class CoinBizImpl implements CoinBiz {

	@Autowired
	CoinDaoImpl dao;
}
