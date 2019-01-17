package com.yaboja.daoImpl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yaboja.dao.ReviewboardcomentDao;
@Repository
public class ReviewboardcomentDaoImpl implements ReviewboardcomentDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
}
