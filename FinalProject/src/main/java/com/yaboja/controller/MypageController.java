package com.yaboja.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yaboja.biz.UserBiz;
import com.yaboja.dto.ReviewboardDto;
import com.yaboja.dto.UserDto;

@Controller
public class MypageController {
   
   @Autowired
   private UserBiz userBiz;
   
   @RequestMapping("/mypage.do")
	public String mypage(Model model, HttpSession session) {
		UserDto dto=(UserDto)session.getAttribute("dto");
		int userseq = dto.getUserseq();
		List<ReviewboardDto> reviewdto = userBiz.myboardList(userseq);
		
		System.out.println(">>>>>>>내게시글 : " + reviewdto);

		model.addAttribute("boardlist",reviewdto);
		model.addAttribute("dto",userBiz.selectOne(userseq));
		System.out.println("mypage : "+ userseq);
		return "mypage";
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
 	public String update(Model model, UserDto dto, HttpSession session, int userseq) {

 		int res = userBiz.update(dto);
 		System.out.println("////"+res);
 		
 		if(res>0) {
 			dto = userBiz.selectOne(userseq);
 			session.setAttribute("dto", dto);
 			
 			System.out.println("수정성공");
 			model.addAttribute("dto",userBiz.selectOne(userseq));
 			List<ReviewboardDto> reviewdto = userBiz.myboardList(userseq);
 			
 			System.out.println(">>>>>>>test : " + reviewdto);

 			model.addAttribute("boardlist",reviewdto);
 			return "mypage";
 		}
 			System.out.println("수정실패");
 			return "mypage_update";
 	}
   
 	@RequestMapping("/userDelete.do")
	public String gradeUpdate(Model model,UserDto dto, HttpSession session) {
		dto = (UserDto)session.getAttribute("dto");
		int res = userBiz.gradeUpdate(dto);
		if(res>0) {
			session.setAttribute("dto", dto);
			System.out.println("탈퇴처리");
		}
		return "main";
	}
}