package com.yaboja.dao;

import java.util.List;

import com.yaboja.dto.CinemaDto;

public interface CinemaDao {
	String namespace="cinema.";
	
	public List<CinemaDto> selectAll();
}
