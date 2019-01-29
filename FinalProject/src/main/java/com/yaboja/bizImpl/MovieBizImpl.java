package com.yaboja.bizImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yaboja.biz.MovieBiz;
import com.yaboja.daoImpl.MovieDaoImpl;
import com.yaboja.dto.MovieDto;
@Service
public class MovieBizImpl implements MovieBiz {

	@Autowired
	MovieDaoImpl dao;

	@Override
	public MovieDto selectOne(int movieseq) {
		
		return dao.selectOne(movieseq) ;
	}

	@Override
	public List<MovieDto> selectList() {
		// TODO Auto-generated method stub
		return dao.selectList();
	}

	@Override
	public int getMovieSeq(String movietitle) {
		// TODO Auto-generated method stub
		return dao.getMovieSeq(movietitle);
	}

	@Override
	public String getMovieTitle(int movieseq) {
		// TODO Auto-generated method stub
		return dao.getMovieTitle(movieseq);
	}
}
