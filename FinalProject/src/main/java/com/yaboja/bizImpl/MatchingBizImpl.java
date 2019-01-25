package com.yaboja.bizImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yaboja.biz.MatchingBiz;
import com.yaboja.daoImpl.MatchingDaoImpl;
import com.yaboja.dto.MatchingDto;
@Service
public class MatchingBizImpl implements MatchingBiz {

	@Autowired
	MatchingDaoImpl dao;

	@Override
	public int insert(MatchingDto dto) {
		// TODO Auto-generated method stub
		return dao.insert(dto);
	}

	@Override
	public MatchingDto selectOne(int userseq) {
		// TODO Auto-generated method stub
		return dao.selectOne(userseq);
	}

	@Override
	public int delete(int matchingseq) {
		// TODO Auto-generated method stub
		return dao.delete(matchingseq);
	}
}
