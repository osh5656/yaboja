package com.yaboja.daoImpl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yaboja.dao.MatchingboardDao;
import com.yaboja.dto.MatchingboardDto;
import com.yaboja.dto.UserDto;
@Repository
public class MatchingboardDaoImpl implements MatchingboardDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<MatchingboardDto> selectAll() {
		
		List<MatchingboardDto> res = null;
		try {
			
			res= sqlSession.selectList(namespace + "selectList");
		
		} catch (Exception e) {
			System.out.println("matchingboard selectList 에러");
			e.printStackTrace();
		}
		
		return res;
	}
	
	@Override
	public MatchingboardDto selectOne(int matchingboard) {
		
		MatchingboardDto res = null;
		try {
			res = sqlSession.selectOne(namespace+"selectOne",matchingboard);
		} catch (Exception e) {
			System.out.println("matchingboard selectOne 에러");
			e.printStackTrace();
		}
		return res;
	}
}
