package com.yaboja.dao;

import com.yaboja.dto.MovieDto;

public interface MovieDao {
	String namespace="movie.";
	
	public MovieDto selectOne(int movieseq);
	

}
