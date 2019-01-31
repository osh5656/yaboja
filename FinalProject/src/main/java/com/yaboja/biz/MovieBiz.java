package com.yaboja.biz;

import java.util.List;

import com.yaboja.dto.MovieDto;

public interface MovieBiz {
	

	public List<MovieDto> selectPresentMovies();
	public List<MovieDto> selectEndMovies();
	public int insert();

	public MovieDto selectOne(int movieseq);
	public List<MovieDto> selectList();
	public int getMovieSeq(String movietitle);
	public String getMovieTitle(int movieseq);


}
