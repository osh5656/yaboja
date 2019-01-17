package com.yaboja.daoImpl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yaboja.dao.MoviecomentDao;
@Repository
public class MoviecomentDaoImpl implements MoviecomentDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
}
