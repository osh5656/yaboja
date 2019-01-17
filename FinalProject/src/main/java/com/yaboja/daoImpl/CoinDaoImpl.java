package com.yaboja.daoImpl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yaboja.dao.CoinDao;
@Repository
public class CoinDaoImpl implements CoinDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
}
