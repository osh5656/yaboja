package com.yaboja.dao;

import com.yaboja.dto.CinemaDto;

public interface CinemaDao {
	String namespace="cinema.";
	
	public CinemaDto selectOne(int cinemaseq);
}
