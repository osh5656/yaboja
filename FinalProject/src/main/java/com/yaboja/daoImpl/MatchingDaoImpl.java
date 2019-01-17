package com.yaboja.daoImpl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yaboja.dao.MatchingDao;
@Repository
public class MatchingDaoImpl implements MatchingDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
}
