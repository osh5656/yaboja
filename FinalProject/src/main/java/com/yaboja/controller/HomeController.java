package com.yaboja.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yaboja.biz.CoinBiz;
import com.yaboja.biz.ReviewboardBiz;
import com.yaboja.biz.ReviewboardcomentBiz;
import com.yaboja.biz.UserBiz;
import com.yaboja.dto.CoinDto;
import com.yaboja.dto.ReviewboardDto;
import com.yaboja.dto.ReviewboardcomentDto;
import com.yaboja.dto.UserDto;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	@Autowired
	UserBiz userBiz;
	@Autowired
	private CoinBiz coinBiz;
	@Autowired
	ReviewboardcomentBiz reviewboardcomentBiz;
	@Autowired
	private ReviewboardBiz reviewBiz;
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "home";
	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////
	@RequestMapping(value = "/main.do", method = RequestMethod.GET)
	public String getMain() {
		return "main";
	}
	
	@RequestMapping(value = "/loginform.do", method = RequestMethod.GET)
	public String getLoginForm() {
		return "loginform";
	}

	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String Login(String userid, String userpw, HttpSession session, HttpServletResponse response)
			throws IOException {
		UserDto dto = userBiz.getLogin(userid, userpw);
		System.out.println(userid + userpw);
		if (dto != null) {
			System.out.println("로그인 성공");
			session.setAttribute("dto", dto);
		} else {
			System.out.println("로그인 실패");
		}
		
		
		return "main";
	}
	
	@RequestMapping(value = "/mypage.do", method = RequestMethod.GET)
	public String getMypage() {
		return "mypage";
	}


	
}
