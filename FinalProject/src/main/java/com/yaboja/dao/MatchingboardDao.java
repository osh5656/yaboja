package com.yaboja.dao;

import java.util.List;
import java.util.Map;

import com.yaboja.dto.MatchingboardDto;

public interface MatchingboardDao {
	String namespace="matchingboard.";
	
	public List<MatchingboardDto> selectAll();
	public MatchingboardDto selectOne(int matchingboard);
	public int insert(Map<String,String> map);
	public MatchingboardDto userOne(int userseq);
	public int update(Map<String,String> map);
}

