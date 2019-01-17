package com.yaboja.daoImpl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yaboja.dao.ReviewboardDao;
@Repository
public class ReviewboardDaoImpl implements ReviewboardDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
}
