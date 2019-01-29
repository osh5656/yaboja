package com.yaboja.daoImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.yaboja.dao.MovieDao;
import com.yaboja.dto.MovieDto;

@Repository
public class MovieDaoImpl implements MovieDao {

	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public List<MovieDto> selectPresentMovies() {
		List<MovieDto> res = null;

		try {
		
			res = sqlSession.selectList(namespace + "selectPresentMovie");
			
		} catch (Exception e) {
			System.out.println("selectPresentMovie 에러");
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public List<MovieDto> selectEndMovies() {
		List<MovieDto> res = null;
		try {
			
			res = sqlSession.selectList(namespace + "selectEndMovie");
			
		} catch (Exception e) {
			System.out.println("selectPresentMovie 에러");
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int insert(List<MovieDto> movies) {
		int res = 0;

		try {
			res = sqlSession.insert(namespace + "insertAll", movies);
			System.out.println("들어간 영화 수 : " + res);
			String str = String.valueOf(res);
			Map<String, String> map = new HashMap<String, String>();
			map.put("str", str);
			sqlSession.update(namespace + "alter", map);
		} catch (Exception e) {
			System.out.println("insert 에러");
			e.printStackTrace();
		}

		return res;
	}
	
	@Override
	public void updateToEnd(List<MovieDto> updateToEndMovies) {
		int res = 0;

		try {			
			res = sqlSession.update(namespace + "updateToEnd",updateToEndMovies);
			if(res>0) {
				System.out.println("-----updateToEnd " +res + "개 종영작으로 바꿈------" );				
			}
		} catch (Exception e) {
			System.out.println("update 에러");
			e.printStackTrace();
		}
				
	}

	@Override
	public MovieDto selectOneMovie(int movieSeq) {
		MovieDto dto = null;
		try {
			dto = sqlSession.selectOne(namespace + "selectOneMovie", movieSeq);
		} catch (Exception e) {
			System.out.println("selectOneMovie 에러");
			e.printStackTrace();
		}
		return dto;
	}
}
