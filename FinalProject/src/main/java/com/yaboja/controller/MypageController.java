package com.yaboja.controller;


import java.util.List;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;

import org.apache.http.HttpResponse;
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
import com.yaboja.dto.ReviewboardDto;
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
   @Autowired
   private MatchingBiz matchingBiz;
 


   @RequestMapping(value = "/mypage.do")
   public String mypage(Model model, HttpSession session, HttpServletResponse response) throws IOException{
	  response.setContentType("text/html; charset=UTF-8");
	  
	  if (session.getAttribute("dto") == null) {
			
		  PrintWriter out = response.getWriter();
		  out.println("<script>alert('로그인 해주세요.');history.back();</script>");
		  out.close();
			return null;
	  }else {
		  UserDto dto=(UserDto)session.getAttribute("dto"); // 세션정보
		  int userseq = dto.getUserseq();
		  List<ReviewboardDto> reviewdto = userBiz.myboardList(userseq);
		  UserDto userdto = userBiz.selectOne(userseq);
      
      
      MatchingboardDto matchingboarddto = matchingboardBiz.userOne(userdto.getUserseq());
//    System.out.println("//"+matchingboarddto.getUserseq());
      
      if(matchingboarddto ==null) {
      
      }
      else {
      
    	  MovieDto moviedto = movieBiz.selectOne(matchingboarddto.getMovieseq());      
    	  CinemaDto cinemadto = cinemaBiz.selectOne(matchingboarddto.getCinemaseq());      
    	  model.addAttribute("moviedto",moviedto);
    	  model.addAttribute("cinemadto",cinemadto);
    	  model.addAttribute("matchingboarddto", matchingboarddto);
      }
      model.addAttribute("boardlist",reviewdto);
      model.addAttribute("dto",userdto);
		}
      
    
      return "mypage";
   }


   
   @RequestMapping(value = "/matchboarddelete.do")
   public void matchboarddelete(Model model, HttpSession session,MatchingboardDto matchingboarddto, HttpServletResponse response,HttpServletRequest request) throws IOException {
      
      response.setContentType("text/html; charset=utf-8"); 
      UserDto userdto=(UserDto)session.getAttribute("dto");
      String matchingboard = request.getParameter("matchingboard");
      int res = matchingboardBiz.deleteMatchingboard(Integer.parseInt(matchingboard));
     
           if(res>0) {
              //신청온 매칭신청 
              // 작성자가 나인 매칭이 여러개 ; p =>E
            matchingBiz.autoReject(userdto.getUserseq());
           
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
   
  

	// 회원정보 수정하러가기
	@RequestMapping("/mypage_updateform.do")
	public String updateform(Model model, HttpSession session) {
		UserDto dto = (UserDto) session.getAttribute("dto");
		System.out.println("updateform : " + dto.getUserseq());
		int userseq = dto.getUserseq();
		model.addAttribute("dto", userBiz.selectOne(userseq));
		System.out.println("userid : " + userseq);
		return "mypage_update";
	}

	// 수정하기
	@RequestMapping("/mypage_update.do")
	public String update(Model model, UserDto dto, HttpSession session, int userseq) {

		int res = userBiz.update(dto);
		System.out.println("////" + res);

		if (res > 0) {
			dto = userBiz.selectOne(userseq);
			session.setAttribute("dto", dto);

			System.out.println("수정성공");
			model.addAttribute("dto", userBiz.selectOne(userseq));
			List<ReviewboardDto> reviewdto = userBiz.myboardList(userseq);

			System.out.println(">>>>>>>test : " + reviewdto);

			model.addAttribute("boardlist", reviewdto);
			return "mypage";
		}
		System.out.println("수정실패");
		return "mypage_update";
	}

	@RequestMapping("/userDelete.do")
	public String gradeUpdate(Model model, UserDto dto, HttpSession session) {
		dto = (UserDto) session.getAttribute("dto");
		int res = userBiz.gradeUpdate(dto);
		if (res > 0) {
			session.invalidate();
			System.out.println("탈퇴처리");
		}
		return "main";

	}
}