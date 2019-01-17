package com.yaboja.daoImpl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yaboja.dao.MovieDao;
@Repository
public class MovieDaoImpl implements MovieDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
}
