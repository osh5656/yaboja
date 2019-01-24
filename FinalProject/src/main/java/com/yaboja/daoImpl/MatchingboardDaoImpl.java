package com.yaboja.daoImpl;

import java.util.List;
import java.util.Map;

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
	
	public MatchingboardDto selectOne(int matchingboard) {
		
		MatchingboardDto res = null;
		try {
			res = sqlSession.selectOne(namespace+"selectOne",matchingboard);
		} catch (Exception e) {
			System.out.println("selectOne 에러");
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int insert(Map<String, String> map) {
		int res = 0;
		try {
			res = sqlSession.insert(namespace+"insert",map);
		} catch(Exception e) {
			System.out.println("insert 에러");
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public MatchingboardDto userOne(int userseq) {
		MatchingboardDto matchingboarddto = null;
		try {
			matchingboarddto = sqlSession.selectOne(namespace+"userOne",userseq);
		} catch(Exception e) {
			System.out.println("userOne 에러");
			e.printStackTrace();
		}
		return matchingboarddto;
	}
}
