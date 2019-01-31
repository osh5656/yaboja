package com.yaboja.biz;

import java.util.List;

import com.yaboja.dto.ReviewboardDto;

public interface ReviewboardBiz {

	public List<ReviewboardDto> selectList();

	public ReviewboardDto selectOne(int reviewboardseq);

	public int insert(ReviewboardDto dto);

	public int update(ReviewboardDto dto);

	public int delete(int reviewboardseq);
	
	public int viewupdate(int reviewboardseq);
}
