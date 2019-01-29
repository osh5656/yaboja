package com.yaboja.controller;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yaboja.biz.CinemaBiz;
import com.yaboja.biz.CoinBiz;
import com.yaboja.biz.MatchingBiz;
import com.yaboja.biz.MatchingboardBiz;
import com.yaboja.biz.MovieBiz;
import com.yaboja.biz.UserBiz;
import com.yaboja.dto.CinemaDto;
import com.yaboja.dto.Criteria;
import com.yaboja.dto.MatchingDto;
import com.yaboja.dto.MatchingboardDto;
import com.yaboja.dto.MovieDto;
import com.yaboja.dto.PageMaker;
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
	@Autowired
	private MatchingBiz matchingBiz;
	@Autowired
	private CoinBiz coinBiz;
	
	
	private static final Logger logger = LoggerFactory.getLogger(MatchingboardController.class);

	@RequestMapping(value = "/matchingboardlist.do", method = RequestMethod.GET)
	public String list(Criteria cri,Model model, HttpSession session) {
//		UserDto dto = (UserDto)session.getAttribute("dto"); //userdto에   세션값 받아오기
		//1.List<MatchingboardDto> list = matchingboardBiz.selectAll();// selectAll()의 값을 matchingdto list에 담음
		logger.info("글목록페이징 1 단계 성공 controller");
		System.out.println("////"+cri);
		
		
		//////
		UserDto userdto = (UserDto) session.getAttribute("dto");

		int coin_charge = 0;
		int coin_use = 0;
		int coin_val = 0;

		coin_charge = coinBiz.coin(userdto.getUserseq(), "충전");

		coin_use = coinBiz.coin(userdto.getUserseq(), "매칭");

		coin_val = ((coin_charge - coin_use) / 500);

		
		model.addAttribute("user_name", userdto.getUsername());
		model.addAttribute("coin", coin_val);
		
		
		////
		
		
		List<MatchingboardDto> list = matchingboardBiz.listPage(cri);
		List<UserDto> userinfo = new ArrayList<UserDto>();
		List<MovieDto> movieinfo = new ArrayList<MovieDto>();
		List<CinemaDto> cinemainfo = new ArrayList<CinemaDto>();
		int listsize = (list.size()) - 1;
//		System.out.println("리스트 사이즈:" +listsize);

		for (int i = 0; i < list.size(); i++) {
			userinfo.add((UserDto) userBiz.selectOne(list.get(i).getUserseq()));
			movieinfo.add((MovieDto) movieBiz.selectOne(list.get(i).getMovieseq()));
			cinemainfo.add((CinemaDto) cinemaBiz.selectOne(list.get(i).getCinemaseq()));
		}

		// UserDto userDto=userBiz.selectOne(list.get(0).getUserseq());
		// MovieDto movieDto =movieBiz.selectOne(list.get(0).getMovieseq());
		// CinemaDto cinemaDto =cinemaBiz.selectOne(list.get(0).getCinemaseq());
		// System.out.println(userDto.getUsername()+"//"+userDto.getUsersex()+"//"+userDto.getUserage());
		// System.out.println(movieDto.getMovieseq()+"영화명:"+movieDto.getMovietitle());
		// System.out.println(cinemaDto.getCinemaseq()+"영화관명:"+cinemaDto.getCinema());

		model.addAttribute("matchingboardlist1", list);
		model.addAttribute("matchingboardlist2", userinfo);
		model.addAttribute("matchingboardlist3", movieinfo);
		model.addAttribute("matchingboardlist4", cinemainfo);
		model.addAttribute("listsize", listsize);
		
		//페이징 기능 추가
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(matchingboardBiz.listCount());
		model.addAttribute("pageMaker", pageMaker);
        //페이징 기능 추가
//		model.addAttribute("matchingboardlist4", cinemaBiz.selectOne(list.get(0).getCinemaseq()));
		return "match_list";
	

	
	}

	@RequestMapping(value = "/matchingboardselectone.do")
	public String detail(Model model, int matchingboard, HttpSession session, HttpServletRequest request) { // 값을 담을
																											// model 과
																											// 구분할 변수 id
																											// 를 파라미터로
																											// 담는다.
		System.out.println("//" + matchingboard);
		MatchingboardDto matchingboarddto = matchingboardBiz
				.selectOne(Integer.parseInt(request.getParameter("matchingboard")));
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

	@RequestMapping(value = "/matchingForm.do")
	public String getMatchingForm(Model model, HttpServletResponse response, HttpSession session) throws IOException {
		response.setContentType("text/html; charset=UTF-8");
		MatchingboardDto matchingboarddto = null;

		MatchingDto matchingdto = null;
		int userseq = ((UserDto)session.getAttribute("dto")).getUserseq();


		matchingboarddto = matchingboardBiz.userOne(userseq);

		matchingdto = matchingBiz.selectOne(userseq);
		
		if(matchingboarddto == null) {
			if(matchingdto == null) {
				List<CinemaDto> cinemaList = cinemaBiz.selectList();
				List<MovieDto> movieList = movieBiz.selectList();
				model.addAttribute("cinemaList", cinemaList);
				model.addAttribute("movieList",movieList);
				
				return "match_insert";
			}else {
				if(matchingdto.getMatchingstate().equals("P")) {
					PrintWriter out = response.getWriter();
					out.println("<script>alert('이미 신청 중인 매칭이 있습니다.');history.back();</script>");
					out.close();
					return null;
				}else if(matchingdto.getMatchingstate().equals("S")) {
					PrintWriter out = response.getWriter();
					out.println("<script>alert('이미 진행 중인 매칭이 있습니다.');history.back();</script>");
					out.close();
					return null;
				}else if(matchingdto.getMatchingstate().equals("E")) {
					List<CinemaDto> cinemaList = cinemaBiz.selectList();
					List<MovieDto> movieList = movieBiz.selectList();
					model.addAttribute("cinemaList", cinemaList);
					model.addAttribute("movieList",movieList);
					return "match_insert";
				}
			}
			
		}else if(matchingboarddto != null){
			

			PrintWriter out = response.getWriter();
			out.println("<script>alert('이미 작성한 매칭이 있습니다.');history.back();</script>");
			out.close();
			return null;

			
		}
		
		return null;

	}

	@RequestMapping(value = "/matchingboard_insert.do", method = RequestMethod.POST)
	public void matchingboardInsert(Model model, HttpSession session, HttpServletResponse response, HttpServletRequest request, String cinema,
			String title, String moviename, String matchingboardcontent) throws IOException {
		String movieseq = String.valueOf(movieBiz.getMovieSeq(moviename));
		String cinemaseq = String.valueOf(cinemaBiz.getCinemaSeq(cinema));
		Map<String, String> map = new HashMap<String, String>();

		map.put("movieseq", movieseq);
		map.put("userseq", String.valueOf(((UserDto) session.getAttribute("dto")).getUserseq()));
		map.put("matchingboardtitle", title);
		map.put("matchingboardcontent",matchingboardcontent);
		map.put("cinemaseq", cinemaseq); 
		int res = matchingboardBiz.insert(map);
		
		///////////////////////////
		
		UserDto userdto = (UserDto) session.getAttribute("dto");

		int point_val_01 = 500;

		if (request.getParameter("point_val_01") != null) {
			point_val_01 = Integer.parseInt(request.getParameter("point_val_01"));
			coinBiz.coin_insert(userdto.getUserseq(), point_val_01, "매칭");
			System.out.println("매칭완료");
		}

		model.addAttribute("point_val_01", point_val_01);
	
		//////////////////

		response.sendRedirect("matchingboardlist.do");
	}

	@RequestMapping(value = "/matching_insert.do")
	public void match(Model model, HttpServletResponse response, HttpSession session, HttpServletRequest request)
			throws IOException {
		int userseq = ((UserDto) session.getAttribute("dto")).getUserseq();
		int matchingwriter = Integer.parseInt(request.getParameter("userseq"));
		response.setContentType("text/html; charset=UTF-8");
		MatchingDto dto = null;
		dto = matchingBiz.selectOne(userseq);

		if(dto == null || dto.getMatchingstate().equals("E")) {
	
			MatchingDto matchingDto = new MatchingDto();
			matchingDto.setMatchingwriter(matchingwriter);
			matchingDto.setMatchingapplicant(userseq);

			int res = matchingBiz.insert(matchingDto);
			if (res > 0) {
				PrintWriter out = response.getWriter();
				out.println("<script>alert('매칭 신청 성공');location.href='mypage_match_to.do';</script>");
				out.close();

			} else {
				PrintWriter out = response.getWriter();
				out.println("<script>alert('매칭 신청 실패');history.back();</script>");
				out.close();
			}
		}else if(dto.getMatchingstate().equals("P")){
			PrintWriter out = response.getWriter();
			out.println("<script>alert('신청 중인 매칭이 있습니다.');history.back();</script>");
			out.close();
		}else if(dto.getMatchingstate().equals("S")) {
			PrintWriter out = response.getWriter();
			out.println("<script>alert('진행 중인 매칭이 있습니다.');history.back();</script>");
			out.close();
		}
	}
	
	@RequestMapping(value="/mypage_match_to.do", method=RequestMethod.GET)
	public String getMypage_match_to(Model model,HttpSession session) {
		int userseq = ((UserDto)session.getAttribute("dto")).getUserseq();
		MatchingDto matchingdto = matchingBiz.selectOne(userseq);
		//System.out.println("/////"+matchingdto.getMatchingwriter());
		UserDto writerUser = null;
		MatchingboardDto matchingboarddto = null;
		if(matchingdto != null) {
			writerUser = userBiz.selectOne(matchingdto.getMatchingwriter());
			matchingboarddto = matchingboardBiz.userOne(matchingdto.getMatchingwriter());
		}
		

		//System.out.println("////"+writerUser.getUsername());

		//System.out.println("////"+writerUser.getUsername());
		
		
		
		MatchingboardDto boarddto = matchingboardBiz.userOne(userseq);
		List<MatchingDto> matchingList = matchingBiz.getMatchingApplicant(userseq);
		List<UserDto> userList = new ArrayList<UserDto>();
		for(int i = 0 ; i < matchingList.size() ; i++) {
			userList.add(userBiz.selectOne(matchingList.get(i).getMatchingapplicant()));
		}
		model.addAttribute("writerUser", writerUser);
		model.addAttribute("matchingboarddto", matchingboarddto);
		model.addAttribute("matchingdto", matchingdto);
		
		model.addAttribute("boarddto",boarddto);
		model.addAttribute("matchingList",matchingList);
		model.addAttribute("userList",userList);
		

		return "mypage_match_to";
	}

	
	
	@RequestMapping(value="/matchingdelete.do", method=RequestMethod.GET)
	public void matchingdelete(Model model,HttpSession session,int matchingseq,HttpServletResponse response) throws IOException {
		int res = matchingBiz.delete(matchingseq);
		
		response.sendRedirect("mypage_match_to.do");
	}
	
	@RequestMapping(value="/match_update.do", method=RequestMethod.GET)
	public String getMatchingBoardUpdate(Model model, HttpServletRequest request) {
		String matchingboard = request.getParameter("matchingboard");
		MatchingboardDto matchingboarddto = matchingboardBiz.selectOne(Integer.parseInt(matchingboard));
		UserDto userdto = userBiz.selectOne(matchingboarddto.getUserseq());
		CinemaDto cinemadto = cinemaBiz.selectOne(matchingboarddto.getCinemaseq());
		MovieDto moviedto = movieBiz.selectOne(matchingboarddto.getMovieseq());
		List<CinemaDto> cinemaList = cinemaBiz.selectList();
		List<MovieDto> movieList = movieBiz.selectList();
				
		model.addAttribute("matchingboarddto",matchingboarddto);
		model.addAttribute("userdto",userdto);
		model.addAttribute("cinemadto",cinemadto);
		model.addAttribute("movieddto",moviedto);
		model.addAttribute("cinemaList", cinemaList);
		model.addAttribute("movieList",movieList);

		
		return "match_update";
	}
	
	@RequestMapping(value="/matchingboard_update.do", method=RequestMethod.POST)
	public void matchingBoardUpdate(HttpServletResponse response,String cinema,String title,String moviename, String matchingboardcontent,String matchingboard) throws IOException {
		response.setContentType("text/html; charset=UTF-8");
		String matchingboardseq = String.valueOf(matchingboard);
		String movieseq = String.valueOf(movieBiz.getMovieSeq(moviename));
		String cinemaseq = String.valueOf(cinemaBiz.getCinemaSeq(cinema));
		Map<String, String> map  = new HashMap<String, String>();
		map.put("matchingboard",matchingboardseq);
		map.put("movieseq",movieseq);
		map.put("matchingboardtitle", title);
		map.put("matchingboardcontent",matchingboardcontent);
		map.put("cinemaseq", cinemaseq);
		
		int res = matchingboardBiz.update(map);
		if(res > 0) {
			PrintWriter out = response.getWriter();
			out.println("<script>alert('글 수정 성공');location.href='matchingboardlist.do'</script>");
			out.close();
		}else {
			PrintWriter out = response.getWriter();
			out.println("<script>alert('글 수정 실패');history.back();</script>");
			out.close();
		}
		
		
	}


	// 글 목록  + 페이징
	@RequestMapping(value = "/listPage.do", method = RequestMethod.GET)
	public void listPage(@ModelAttribute("cri") Criteria cri, Model model) {
		System.out.println("페이지 ㅋㅋ");
		List<MatchingboardDto> list = matchingboardBiz.listPage(cri);
		model.addAttribute("list", list);
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(matchingboardBiz.listCount());
		model.addAttribute("pageMaker", pageMaker);
	}


}
