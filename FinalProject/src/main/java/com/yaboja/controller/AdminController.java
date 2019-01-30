package com.yaboja.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yaboja.biz.UserBiz;
import com.yaboja.dto.UserDto;

@Controller
public class AdminController {

	
	@Autowired
	UserBiz userBiz;
	
	

	@RequestMapping(value="adminPreferences.do", method = RequestMethod.GET)
	public String adminPreferences(Model model) {
		List<UserDto> userList=userBiz.selectAll();
		model.addAttribute("userList", userList);
		return "admin_user";
	}
	@RequestMapping(value="dropUser.do", method = RequestMethod.GET)
	public String dropUser(int userseq,Model model) {
		
		int res=userBiz.updateUser(userseq,"drop");
		if(res>0) {
		List<UserDto> userList=userBiz.selectAll();
		model.addAttribute("userList", userList);
		return "admin_user";
		}else {
			return "admin_user";
		}
	}
	@RequestMapping(value="advanceUser.do", method = RequestMethod.GET)
	public String advanceUser(int userseq,Model model) {
		
		int res=userBiz.updateUser(userseq,"admin");
		if(res>0) {
		List<UserDto> userList=userBiz.selectAll();
		model.addAttribute("userList", userList);
		return "admin_user";
		}else {
			return "admin_user";
		}
	}
}
