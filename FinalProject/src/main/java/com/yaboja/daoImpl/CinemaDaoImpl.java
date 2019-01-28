package com.yaboja.daoImpl;

import java.util.List;

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
	public List<CinemaDto> selectAll() {
		
		List<CinemaDto> list=null;
		
		try {
			list=sqlSession.selectList(namespace+"selectAll");
		} catch (Exception e) {
			System.out.println("Cinema selectAll 에러");
			e.printStackTrace();
		}
		return list;
	}
}
