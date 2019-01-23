package com.yaboja.bizImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yaboja.biz.MatchingboardBiz;
import com.yaboja.dao.MatchingboardDao;
import com.yaboja.daoImpl.MatchingboardDaoImpl;
import com.yaboja.dto.MatchingboardDto;
@Service
public class MatchingboardBizImpl implements MatchingboardBiz {

	@Autowired
	MatchingboardDao dao;
	
	@Override
	public List<MatchingboardDto> selectAll(){
		return dao.selectAll();
	}

	@Override
	public MatchingboardDto selectOne(int matchingboard) {
		// TODO Auto-generated method stub
		return null;
	}
}
