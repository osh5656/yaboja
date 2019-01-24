package com.yaboja.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yaboja.biz.CinemaBiz;
import com.yaboja.biz.MatchingboardBiz;
import com.yaboja.biz.MovieBiz;
import com.yaboja.biz.UserBiz;
import com.yaboja.dto.CinemaDto;
import com.yaboja.dto.MatchingboardDto;
import com.yaboja.dto.MovieDto;
import com.yaboja.dto.UserDto;

@Controller
public class MatchingboardController {

	@Autowired
	private MatchingboardBiz matchingboardBiz;
	@Autowired
	private UserBiz userBiz;
	@Autowired
	private MovieBiz movieBiz;
	@Autowired
	private CinemaBiz cinemaBiz;
	
	
	
	@RequestMapping(value = "/matchingboardlist.do")
	public String list(Model model, HttpSession session) {
//		UserDto dto = (UserDto)session.getAttribute("dto"); //userdto에   세션값 받아오기
		List<MatchingboardDto> list=matchingboardBiz.selectAll();//selectAll()의 값을 matchingdto list에 담음
		System.out.println("유저번호: "+list.get(0).getUserseq());
		System.out.println("영화번호: "+list.get(0).getMovieseq());
		System.out.println("영화관번호: "+list.get(0).getCinemaseq());
		List<UserDto> userinfo = new ArrayList<UserDto>();
		List<MovieDto> movieinfo = new ArrayList<MovieDto>();
		List<CinemaDto> cinemainfo = new ArrayList<CinemaDto>();
		int listsize = (list.size())-1;
//		System.out.println("리스트 사이즈:" +listsize);

		for(int i=0;i<list.size();i++) {
			 userinfo.add((UserDto) userBiz.selectOne(list.get(i).getUserseq()));
			 movieinfo.add((MovieDto) movieBiz.selectOne(list.get(i).getMovieseq()));
			 cinemainfo.add((CinemaDto) cinemaBiz.selectOne(list.get(i).getCinemaseq()));
		}


		
		UserDto userDto=userBiz.selectOne(list.get(0).getUserseq());
		MovieDto movieDto =movieBiz.selectOne(list.get(0).getMovieseq());
		CinemaDto cinemaDto =cinemaBiz.selectOne(list.get(0).getCinemaseq());
		System.out.println(userDto.getUsername()+"//"+userDto.getUsersex()+"//"+userDto.getUserage());
		System.out.println(movieDto.getMovieseq()+"영화명:"+movieDto.getMovietitle());
		System.out.println(cinemaDto.getCinemaseq()+"영화관명:"+cinemaDto.getCinema());
		
		model.addAttribute("matchingboardlist1", list);
		model.addAttribute("matchingboardlist2", userinfo);
		model.addAttribute("matchingboardlist3", movieinfo);
		model.addAttribute("matchingboardlist4", cinemainfo);
		model.addAttribute("listsize",listsize);
		
//		model.addAttribute("matchingboardlist4", cinemaBiz.selectOne(list.get(0).getCinemaseq()));

		return "match_list";
	}
	
	@RequestMapping(value = "/matchingboardselectone.do")
	public String detail(Model model, int matchingboard, HttpSession session, HttpServletRequest request) { //값을 담을 model 과 구분할 변수 id 를 파라미터로 담는다.
		System.out.println("//"+matchingboard);
		MatchingboardDto matchingboarddto =matchingboardBiz.selectOne(Integer.parseInt(request.getParameter("matchingboard")));
		UserDto userdto = userBiz.selectOne(matchingboarddto.getUserseq());
		CinemaDto cinemadto = cinemaBiz.selectOne(matchingboarddto.getCinemaseq());
		MovieDto moviedto = movieBiz.selectOne(matchingboarddto.getMovieseq());
		
//		System.out.println("user정보:"+matchingboarddto.getUserseq());
		model.addAttribute("matchingboarddetail1", matchingboarddto);
		model.addAttribute("matchingboarddetail2", userdto);
		model.addAttribute("matchingboarddetail3", moviedto);
		model.addAttribute("matchingboarddetail4", cinemadto);


		
		return "match_detail";
	}
	@RequestMapping(value = "/matchSuccess.do")
	public String match(Model model) {
		
		return "mypage_match_to";
	}
	
}
