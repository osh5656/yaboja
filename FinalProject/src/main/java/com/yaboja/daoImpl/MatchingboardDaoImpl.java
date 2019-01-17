package com.yaboja.daoImpl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yaboja.dao.MatchingboardDao;
@Repository
public class MatchingboardDaoImpl implements MatchingboardDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
}
