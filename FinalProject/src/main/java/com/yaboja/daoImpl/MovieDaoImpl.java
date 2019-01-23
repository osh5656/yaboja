package com.yaboja.daoImpl;

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
}
