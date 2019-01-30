package com.yaboja.bizImpl;

import java.util.List;
import java.util.Map;

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

	@Override
	public List<MatchingDto> getMatchingApplicant(int userseq) {
		// TODO Auto-generated method stub
		return dao.getMatchingApplicant(userseq);
	}

	@Override
	public int acceptance(Map<String, String> map) {
		// TODO Auto-generated method stub
		return dao.acceptance(map);
	}

	@Override
	public int rejection(Map<String, String> map) {
		// TODO Auto-generated method stub
		return dao.rejection(map);
	}

	@Override
	public int rejectionOne(Map<String, String> map) {
		// TODO Auto-generated method stub
		return dao.rejectionOne(map);
	}

	@Override
	public MatchingDto matchSuccess(int userseq) {
		// TODO Auto-generated method stub
		return dao.matchSuccess(userseq);
	}

	@Override
	public MatchingDto insertCheck(int userseq) {
		// TODO Auto-generated method stub
		return dao.insertCheck(userseq);
	}
}
