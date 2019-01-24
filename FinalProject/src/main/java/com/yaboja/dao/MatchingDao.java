package com.yaboja.dao;

import com.yaboja.dto.MatchingDto;

public interface MatchingDao {
	String namespace="matching.";
	
	public int insert(MatchingDto dto);
	public MatchingDto selectOne(int userseq);
}
