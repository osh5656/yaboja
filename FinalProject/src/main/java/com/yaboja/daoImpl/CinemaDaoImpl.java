package com.yaboja.daoImpl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yaboja.dao.CinemaDao;
@Repository
public class CinemaDaoImpl implements CinemaDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
}
