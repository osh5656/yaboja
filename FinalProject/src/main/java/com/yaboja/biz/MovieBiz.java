package com.yaboja.biz;

import java.util.List;

import com.yaboja.dto.MovieDto;

public interface MovieBiz {
	
	public MovieDto selectOne(int movieseq);
	public List<MovieDto> selectList();
	public int getMovieSeq(String movietitle);

}
