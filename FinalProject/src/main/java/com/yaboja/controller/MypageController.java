package com.yaboja.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yaboja.biz.UserBiz;
import com.yaboja.dto.UserDto;

@Controller
public class MypageController {
   
   @Autowired
   private UserBiz userBiz;
   
   @RequestMapping("/mypage.do")
   public String mypage(Model model, HttpSession session) {
      UserDto dto=(UserDto)session.getAttribute("dto");
      int userseq = dto.getUserseq();
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