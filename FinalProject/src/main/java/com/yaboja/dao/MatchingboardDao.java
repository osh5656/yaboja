package com.yaboja.dao;

import java.util.List;

import com.yaboja.dto.MatchingboardDto;

public interface MatchingboardDao {
	String namespace="matchingboard.";
	
	public List<MatchingboardDto> selectAll();
	public MatchingboardDto selectOne(int matchingboard);
}

