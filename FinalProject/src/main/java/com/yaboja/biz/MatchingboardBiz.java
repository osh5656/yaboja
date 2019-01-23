package com.yaboja.biz;

import java.util.List;

import com.yaboja.dto.MatchingboardDto;

public interface MatchingboardBiz {

	public List<MatchingboardDto> selectAll();
	public MatchingboardDto selectOne(int userseq);
}
