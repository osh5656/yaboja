package com.yaboja.daoImpl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yaboja.dao.MatchingDao;
import com.yaboja.dto.MatchingDto;
@Repository
public class MatchingDaoImpl implements MatchingDao {

	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public int insert(MatchingDto dto) {
		int res = 0;
		
		try {
			res = sqlSession.insert(namespace+"insert",dto);
			
		} catch(Exception e) {
			System.out.println("insert 에러");
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public MatchingDto selectOne(int userseq) {
		MatchingDto dto = null;
		try {
			dto = sqlSession.selectOne(namespace+"selectOne",userseq);
		} catch(Exception e) {
			System.out.println("selectOne 에러");
			e.printStackTrace();
		}
		return dto;
	}
}
