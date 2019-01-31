package com.yaboja.dao;

import java.util.List;

import com.yaboja.dto.ReviewboardDto;

public interface ReviewboardDao {
	String namespace="reviewboard.";
	
	public List<ReviewboardDto> selectList();
	public ReviewboardDto selectOne(int reviewboardseq);
	public int insert(ReviewboardDto dto);
	public int update(ReviewboardDto dto);
	public int delete(int reviewboardseq);
	public int viewupdate(int reviewboardseq);
	  
	
}
