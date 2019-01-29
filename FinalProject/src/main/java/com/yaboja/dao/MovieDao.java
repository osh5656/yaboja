package com.yaboja.dao;

import java.util.ArrayList;
import java.util.List;


import com.yaboja.dto.MovieDto;

public interface MovieDao {
	String namespace="movie.";
	
	public List<MovieDto> selectPresentMovies();
	public List<MovieDto> selectEndMovies();
	public int insert(List<MovieDto> movies);
	public void updateToEnd(List<MovieDto> updateToEndMovies);
	public MovieDto selectOneMovie(int movieSeq);
}
