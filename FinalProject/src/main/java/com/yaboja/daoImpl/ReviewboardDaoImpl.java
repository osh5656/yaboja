package com.yaboja.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yaboja.dao.ReviewboardDao;
import com.yaboja.dto.ReviewboardDto;
@Repository
public class ReviewboardDaoImpl implements ReviewboardDao {

   @Autowired
   private SqlSessionTemplate sqlSession;

   @Override
   public List<ReviewboardDto> selectList() {
      List<ReviewboardDto> res = new ArrayList<ReviewboardDto>();
      
      try {
         res = sqlSession.selectList(namespace + "selectAll");
      } catch (Exception e) {
         System.out.println("selectAll 에러");
         e.printStackTrace();
      }
      
      return res;
   }

   @Override
   public ReviewboardDto selectOne(int reviewboardseq) {
      ReviewboardDto dto = sqlSession.selectOne(namespace + "selectOne", reviewboardseq);
      return dto;
   }
   
   @Override
   public int insert(ReviewboardDto dto) {
      int res = sqlSession.insert(namespace + "Insert", dto);
      return res;
   }

   @Override
   public int update(ReviewboardDto dto) {
      int res = sqlSession.update(namespace + "update", dto);
      return res;
   }
   
   @Override
   public int delete(int reviewboardseq) {
      int res = sqlSession.delete(namespace + "delete", reviewboardseq);
      return res;
   }

   @Override
   public int viewupdate(int reviewboardseq) {
      int res = sqlSession.update(namespace+"viewupdate",reviewboardseq);
      return res;
   }
}