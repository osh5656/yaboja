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
	public MovieDto selectOne(int movieseq) {
		MovieDto dto = null;
		
		try {
			dto = sqlSession.selectOne(namespace+"match_selectOne",movieseq);
		} catch (Exception e) {
			System.out.println("match_selectOne 에러");
			e.printStackTrace();
		}
		return dto;
	}

	@Override
	public List<MovieDto> selectList() {
		List<MovieDto> list = null;
		try {
			list = sqlSession.selectList(namespace+"selectList");
		} catch(Exception e) {
			System.out.println("selectList 에러");
			e.printStackTrace();
		}
		
		
		return list;
	}

	@Override
	public int getMovieSeq(String movietitle) {
		int res = 0;
		try {
			res = sqlSession.selectOne(namespace+"getMovieSeq",movietitle);
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("getMovieSeq 에러");
		}
		
		return res;
	}
	
	@Override
	public String getMovieTitle(int movieseq) {
		String movietitle = null;
		try {
			movietitle = sqlSession.selectOne(namespace+"getMovieTitle",movieseq);
		} catch(Exception e) {
			System.out.println("getMovieTitle 에러");
			e.printStackTrace();
		}
		return movietitle;

	}
}
