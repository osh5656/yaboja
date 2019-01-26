package com.yaboja.biz;

import java.util.List;

import com.yaboja.dto.MatchingDto;

public interface MatchingBiz {

	public int insert(MatchingDto dto);
	public MatchingDto selectOne(int userseq);
	public int delete(int matchingseq);
	public List<MatchingDto> getMatchingApplicant(int userseq);

}
