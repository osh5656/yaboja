package com.yaboja.controller;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.ArrayList;

import java.util.List;


import javax.servlet.http.HttpServletResponse;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yaboja.bizImpl.MatchingboardBizImpl;

import com.yaboja.dto.CinemaDto;
import com.yaboja.dto.MovieDto;





@Controller

public class MatchingController {

	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private MatchingboardBizImpl biz;
	
	MovieDto dto;
		
	@RequestMapping(value = "/map.do", method = RequestMethod.GET)
	public String getSelectCinema(Model model) {
		
		
		System.out.println("지도로보기에 잘도착했소");
		
		
		
		return "matchingBoard/map";
	}
	@RequestMapping(value = "/getJson.do", method = RequestMethod.GET)
	@ResponseBody
	public String getCinemaLoc(Model model,HttpServletResponse response) throws IOException {
		
		
		System.out.println("json값에 잘도착했소");
		JSONObject jsonObject = new JSONObject();
		JSONArray markerArray = new JSONArray();

		// marker의 JSON 정보를 담을 Array 선언
		List<CinemaDto> list = new ArrayList<CinemaDto>();
		list.add(new CinemaDto(1,"CGV강남","37.5015645","127.0341247"));
		list.add(new CinemaDto(2,"CGV산본","37.3589284","126.9310358"));
		list.add(new CinemaDto(2,"LOTTE신사","37.5165737","127.0195558"));
		
		for (int i = 0; i < list.size(); i++) {
			
			CinemaDto dto = list.get(i);
			String imgSrc = null;
			if(dto.getCinema().contains("CGV")) {
				imgSrc = "img/cgv.png";
			}else if(dto.getCinema().contains("LOTTE")) {
				imgSrc = "img/lotte.png";
			}
			
			
			
			JSONObject markerInfo = new JSONObject();

			markerInfo.put("html","<a href=\"\" style='font-size:20px;'><img src=\""+imgSrc+"\" width=\"50px\" height=\"50px\"/>"+dto.getCinema()+"</a>");
			markerInfo.put("lat", list.get(i).getLatitude());
			markerInfo.put("lng", list.get(i).getLongitude());

			markerArray.add(markerInfo);
		}
		jsonObject.put("positions", markerArray);
		
		response.setContentType("text/xml; charset=utf-8");
			
	    
	    PrintWriter out = response.getWriter();
	    out.print(jsonObject.toJSONString());
						
		return null;
	}
	
	
	
	
}
