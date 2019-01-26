package com.yaboja.biz;

import java.util.List;
import java.util.Map;

import com.yaboja.dto.Criteria;
import com.yaboja.dto.MatchingboardDto;

public interface MatchingboardBiz {

	//목록
	public List<MatchingboardDto> selectAll();
	public MatchingboardDto selectOne(int userseq);
	public int insert(Map<String,String> map);
	public MatchingboardDto userOne(int userseq);
	//목록 + 페이징
	public List<MatchingboardDto> listPage(Criteria cri);
	//게시물 총 개수
	public int listCount();
}
