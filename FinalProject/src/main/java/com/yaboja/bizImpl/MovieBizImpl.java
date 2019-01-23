package com.yaboja.bizImpl;

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
}
