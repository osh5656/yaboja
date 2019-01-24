package com.yaboja.biz;

import com.yaboja.dto.MatchingDto;

public interface MatchingBiz {

	public int insert(MatchingDto dto);
	public MatchingDto selectOne(int userseq);
}
