package com.yaboja.daoImpl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yaboja.dao.CinemaDao;
import com.yaboja.dto.CinemaDto;
@Repository
public class CinemaDaoImpl implements CinemaDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public CinemaDto selectOne(int cinemaseq) {
		CinemaDto dto = null;
		
		try {
			dto = sqlSession.selectOne(namespace+"match_selectOne",cinemaseq);
		
		} catch (Exception e) {
			System.out.println("match_selectOne 에러");
			e.printStackTrace();
		}
		return dto;
	}
}
