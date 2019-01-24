package com.yaboja.biz;

import java.util.List;
import java.util.Map;

import com.yaboja.dto.MatchingboardDto;

public interface MatchingboardBiz {

	public List<MatchingboardDto> selectAll();
	public MatchingboardDto selectOne(int userseq);
	public int insert(Map<String,String> map);
	public MatchingboardDto userOne(int userseq);
}
