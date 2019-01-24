package com.yaboja.daoImpl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.yaboja.dao.MovieDao;

import com.yaboja.dto.MovieDto;
@Repository
public class MovieDaoImpl implements MovieDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public MovieDto selectOne(int movieseq) {
		MovieDto dto = null;
		
		try {
			dto = sqlSession.selectOne(namespace+"match_selectOne",movieseq);
		} catch (Exception e) {
			System.out.println("match_selectOne 에러");
			e.printStackTrace();
		}
		return dto;
	}

	@Override
	public List<MovieDto> selectList() {
		List<MovieDto> list = null;
		try {
			list = sqlSession.selectList(namespace+"selectList");
		} catch(Exception e) {
			System.out.println("selectList 에러");
			e.printStackTrace();
		}
		
		
		return list;
	}

	@Override
	public int getMovieSeq(String movietitle) {
		int res = 0;
		try {
			res = sqlSession.selectOne(namespace+"getMovieSeq",movietitle);
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("getMovieSeq 에러");
		}
		
		return res;
	}
}
