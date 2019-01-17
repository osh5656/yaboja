package com.yaboja.dto;

import java.util.Date;

public class MatchingboardDto {

	 // 매칭 게시 번호 
    private int matchingboard;

    // 영화 
    private int movieseq;

    // 작성자 
    private int userseq;

    // 제목 
    private String matchingboardtitle;

    // 내용 
    private String matchingboardcontent;

    // 날짜 
    private Date matchingboarddate;

    // 영화관 
    private String cinema;

    // 성별 
    private String usersex;

    // 프로필사진 
    private String userprofile;

    public int getMatchingboard() {
        return matchingboard;
    }

    public void setMatchingboard(int matchingboard) {
        this.matchingboard = matchingboard;
    }

    public int getMovieseq() {
        return movieseq;
    }

    public void setMovieseq(int movieseq) {
        this.movieseq = movieseq;
    }

    public int getUserseq() {
        return userseq;
    }

    public void setUserseq(int userseq) {
        this.userseq = userseq;
    }

    public String getMatchingboardtitle() {
        return matchingboardtitle;
    }

    public void setMatchingboardtitle(String matchingboardtitle) {
        this.matchingboardtitle = matchingboardtitle;
    }

    public String getMatchingboardcontent() {
        return matchingboardcontent;
    }

    public void setMatchingboardcontent(String matchingboardcontent) {
        this.matchingboardcontent = matchingboardcontent;
    }

    public Date getMatchingboarddate() {
        return matchingboarddate;
    }

    public void setMatchingboarddate(Date matchingboarddate) {
        this.matchingboarddate = matchingboarddate;
    }

    public String getCinema() {
        return cinema;
    }

    public void setCinema(String cinema) {
        this.cinema = cinema;
    }

    public String getUsersex() {
        return usersex;
    }

    public void setUsersex(String usersex) {
        this.usersex = usersex;
    }

    public String getUserprofile() {
        return userprofile;
    }

    public void setUserprofile(String userprofile) {
        this.userprofile = userprofile;
    }
}
