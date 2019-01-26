package com.yaboja.dao;

import java.util.List;

import com.yaboja.dto.MatchingDto;

public interface MatchingDao {
	String namespace="matching.";
	
	public int insert(MatchingDto dto);
	public MatchingDto selectOne(int userseq);
	public int delete(int matchingseq);
	public List<MatchingDto> getMatchingApplicant(int userseq);
}
