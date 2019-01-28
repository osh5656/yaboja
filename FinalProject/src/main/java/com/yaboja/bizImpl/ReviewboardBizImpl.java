package com.yaboja.bizImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yaboja.biz.ReviewboardBiz;
import com.yaboja.daoImpl.ReviewboardDaoImpl;
import com.yaboja.dto.ReviewboardDto;
@Service
public class ReviewboardBizImpl implements ReviewboardBiz {

   @Autowired
   ReviewboardDaoImpl dao;

   @Override
   public List<ReviewboardDto> selectList() {
      return dao.selectList();
   }

   @Override
   public ReviewboardDto selectOne(int reviewboardseq) {
	  dao.viewupdate(reviewboardseq);
      return dao.selectOne(reviewboardseq);
   }
   
   @Override
   public int insert(ReviewboardDto dto) {
      return dao.insert(dto);
   }


   @Override
   public int update(ReviewboardDto dto) {
      return dao.update(dto);
   }

   @Override
   public int delete(int reviewboardseq) {
      return dao.delete(reviewboardseq);
   }

   @Override
   public int viewupdate(int reviewboardseq) {
	   
      return dao.viewupdate(reviewboardseq);
   }
   
   
}