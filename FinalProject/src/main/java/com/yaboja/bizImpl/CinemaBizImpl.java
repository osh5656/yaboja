package com.yaboja.bizImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yaboja.biz.CinemaBiz;
import com.yaboja.daoImpl.CinemaDaoImpl;
import com.yaboja.dto.CinemaDto;
@Service
public class CinemaBizImpl implements CinemaBiz{

	@Autowired
	CinemaDaoImpl dao;

	@Override
	public CinemaDto selectOne(int cinemaseq) {
		// TODO Auto-generated method stub
		return dao.selectOne(cinemaseq);
	}
}
