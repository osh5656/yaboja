package com.yaboja.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yaboja.biz.UserBiz;
import com.yaboja.dto.UserDto;

@Controller
public class MypageController {
   
   @Autowired
   private UserBiz userBiz;
   
   @RequestMapping("/mypage.do")
   public String mypage(Model model, HttpSession session, String userid) {
      UserDto dto=(UserDto)session.getAttribute("dto");
      userid = dto.getUserid();
      model.addAttribute("dto",userBiz.selectOne(userid));
      System.out.println("mypage : "+ userid);
      return "mypage";
   }
   
   //회원정보 수정하러가기
   @RequestMapping("/mypage_updateform.do")
   public String updateform(Model model,String userid, HttpSession session) {
      UserDto dto = (UserDto)session.getAttribute("dto");
      System.out.println("updateform : " + dto.getUserid());
      userid = dto.getUserid();
      model.addAttribute("dto",userBiz.selectOne(userid));
      System.out.println("userid : " + userid);
      return "mypage_update";
   }
   
   //수정하기
   @RequestMapping("/mypage_update.do")
   public String update(Model model, UserDto dto, String userid, HttpSession session) {

      int res = userBiz.update(dto);
      System.out.println("////"+res);
      //userid = dto.getUserid();
      
      if(res>0) {
         dto = userBiz.selectOne(userid);
         session.setAttribute("dto", dto);
         userid = dto.getUserid();
         
         System.out.println("수정성공");
         model.addAttribute("dto",userBiz.selectOne(userid));
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