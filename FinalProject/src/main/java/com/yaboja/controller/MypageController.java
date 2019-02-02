package com.yaboja.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yaboja.biz.CinemaBiz;
import com.yaboja.biz.MatchingBiz;
import com.yaboja.biz.MatchingboardBiz;
import com.yaboja.biz.MovieBiz;
import com.yaboja.biz.UserBiz;
import com.yaboja.dto.CinemaDto;
import com.yaboja.dto.MatchingboardDto;
import com.yaboja.dto.MovieDto;
import com.yaboja.dto.UserDto;

@Controller
public class MypageController {
   
   @Autowired
   private UserBiz userBiz;
   @Autowired
   private MovieBiz movieBiz;
   @Autowired
   private CinemaBiz cinemaBiz;
   @Autowired
   private MatchingboardBiz matchingboardBiz;
//   @Autowired
//   private MatchingBiz matchingBiz;
   
   @RequestMapping(value = "/mypage.do")
   public String mypage(Model model, HttpSession session) {
	   System.out.println("컨트롤러접속");
      UserDto dto=(UserDto)session.getAttribute("dto"); // 세션정보
      int userseq = dto.getUserseq();
      UserDto userdto = userBiz.selectOne(userseq);
      System.out.println("//");
      MatchingboardDto matchingboarddto = matchingboardBiz.userOne(userdto.getUserseq());
//      System.out.println("//"+matchingboarddto.getUserseq());
      if(matchingboarddto ==null) {
      }else {
      MovieDto moviedto = movieBiz.selectOne(matchingboarddto.getMovieseq());
      CinemaDto cinemadto = cinemaBiz.selectOne(matchingboarddto.getCinemaseq());
      model.addAttribute("moviedto",moviedto);
      model.addAttribute("cinemadto",cinemadto);
      model.addAttribute("matchingboarddto", matchingboarddto);
      }
      model.addAttribute("dto",userdto);
     
      
    
      return "mypage";
   }
   
   @RequestMapping(value = "/matchboarddelete.do")
   public void matchboarddelete(Model model, MatchingboardDto matchingboarddto, HttpServletResponse response,HttpServletRequest request) throws IOException {
	   
	   response.setContentType("text/html; charset=utf-8"); 
	   String matchingboard = request.getParameter("matchingboard");
	   int res = matchingboardBiz.deleteMatchingboard(Integer.parseInt(matchingboard));
	   
	   	  if(res>0) {
	         System.out.println("삭제성공");
	         PrintWriter out = response.getWriter();
	         out.println("<script>alert('삭제 성공');location.href='mypage.do';</script>");
	         out.close();
	      }else {
	         System.out.println("삭제실패");
	         PrintWriter out = response.getWriter();
	         out.println("<script>alert('삭제 실패');location.href='mypage.do';</script>");
	         out.close();
	      }
	   
   }
   
   //회원정보 수정하러가기
   @RequestMapping("/mypage_updateform.do")
   public String updateform(Model model, HttpSession session) {
      UserDto dto = (UserDto)session.getAttribute("dto");
      System.out.println("updateform : " + dto.getUserseq());
      int userseq = dto.getUserseq();
      model.addAttribute("dto",userBiz.selectOne(userseq));
      System.out.println("userid : " + userseq);
      return "mypage_update";
   }
   
   //수정하기
   @RequestMapping("/mypage_update.do")
   public String update(Model model, HttpSession session) {
	  UserDto dto=(UserDto)session.getAttribute("dto");
	   int userseq = dto.getUserseq();
      int res = userBiz.update(dto);

      
      System.out.println("////"+res);
      //userid = dto.getUserid();
      
      if(res>0) {
    	  
    	  UserDto dto1 =(UserDto)session.getAttribute("dto");
    	  dto1=userBiz.selectOne(userseq);
    	  session.setAttribute("dto1",dto1);
          
    	  
          System.out.println("수정성공");
         model.addAttribute("dto",userBiz.selectOne(userseq));
         return "mypage";
      }
         System.out.println("수정실패");
         return "mypage_update";
   }
   
   @RequestMapping(value="/userDelete.do")
   public String delete(Model model, UserDto dto, String userid) {
      int res = userBiz.delete(userid);
      if(res>0) {
         System.out.println("삭제성공");
         return "main";
      }else {
         System.out.println("삭제실패");
         return "mypage";
      }
   }
}