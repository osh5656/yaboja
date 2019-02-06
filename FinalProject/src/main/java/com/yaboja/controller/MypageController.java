package com.yaboja.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.yaboja.biz.MovieBiz;
import com.yaboja.biz.ReviewboardBiz;

import com.yaboja.biz.UserBiz;
import com.yaboja.dto.CinemaDto;
import com.yaboja.dto.MovieDto;
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
	private CinemaBiz cinemaBiz;

	@Autowired
	private ReviewboardBiz reviewBiz;

	@RequestMapping("/mypage.do")
	public String mypage(Model model, HttpSession session, HttpServletResponse response) throws IOException {

		response.setContentType("text/html; charset=UTF-8");

		if (session.getAttribute("dto") == null) {
			PrintWriter out = response.getWriter();
			out.println("<script>alert('로그인 해주세요.');history.back();</script>");
			out.close();
			return null;
		} else {
			UserDto dto = (UserDto) session.getAttribute("dto");
			int userseq = dto.getUserseq();
			String userprofile = dto.getUserprofile();
			System.out.println(">>>>>프로필사진_" + userprofile);
			List<ReviewboardDto> reviewdto = userBiz.myboardList(userseq);

			List<MovieDto> moviedto = new ArrayList<MovieDto>();
			for (int i = 0; i < reviewdto.size(); i++) {
				moviedto.add(reviewBiz.selectOne1(reviewdto.get(i).getMovietitle()));
				System.out.println(">>>>>내게시글영화제목test_" + moviedto.get(i).getMovietitle());
			}
			// cinema 출력
			CinemaDto cinemadto1 = cinemaBiz.selectOne(dto.getUsercinema1());
			CinemaDto cinemadto2 = cinemaBiz.selectOne(dto.getUsercinema2());
			CinemaDto cinemadto3 = cinemaBiz.selectOne(dto.getUsercinema3());
			model.addAttribute("cinemadto1", cinemadto1);
			model.addAttribute("cinemadto2", cinemadto2);
			model.addAttribute("cinemadto3", cinemadto3);
			model.addAttribute("moviedto", moviedto);
			model.addAttribute("boardlist", reviewdto);
			model.addAttribute("dto", userBiz.selectOne(userseq));
			System.out.println("mypage : UserSeq_" + userseq);
		}
			return "mypage";
	}

	// 회원정보 수정하러가기
	@RequestMapping("/mypage_updateform.do")
	public String updateform(Model model, HttpSession session) {
		UserDto dto = (UserDto) session.getAttribute("dto");

		int userseq = dto.getUserseq();

		List<CinemaDto> cinemaList = cinemaBiz.selectAll();
		model.addAttribute("cinemaList", cinemaList);
		model.addAttribute("dto", userBiz.selectOne(userseq));
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
			List<MovieDto> moviedto = new ArrayList<MovieDto>();
			for (int i = 0; i < reviewdto.size(); i++) {
				moviedto.add(reviewBiz.selectOne1(reviewdto.get(i).getMovietitle()));
				System.out.println(">>>>>내게시글영화제목test_" + moviedto.get(i).getMovietitle());
			}

			CinemaDto cinemadto1 = cinemaBiz.selectOne(dto.getUsercinema1());
			CinemaDto cinemadto2 = cinemaBiz.selectOne(dto.getUsercinema2());
			CinemaDto cinemadto3 = cinemaBiz.selectOne(dto.getUsercinema3());

			model.addAttribute("cinemadto1", cinemadto1);
			model.addAttribute("cinemadto2", cinemadto2);
			model.addAttribute("cinemadto3", cinemadto3);
			model.addAttribute("moviedto", moviedto);
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