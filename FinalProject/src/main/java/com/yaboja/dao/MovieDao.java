package com.yaboja.dao;

import java.util.List;

import com.yaboja.dto.MovieDto;

public interface MovieDao {
	String namespace="movie.";
	
	
	public List<MovieDto> selectList();
	public MovieDto selectOne(int movieseq);
	public int getMovieSeq(String movietitle);
	public String getMovieTitle(int movieseq);
	

}
