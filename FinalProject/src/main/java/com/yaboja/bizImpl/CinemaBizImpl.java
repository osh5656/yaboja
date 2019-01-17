package com.yaboja.bizImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yaboja.biz.CinemaBiz;
import com.yaboja.daoImpl.CinemaDaoImpl;
@Service
public class CinemaBizImpl implements CinemaBiz{

	@Autowired
	CinemaDaoImpl dao;
}
