package com.yaboja.dto;

import java.util.Date;

public class MoviecomentDto {

	// 영화게시판 글번호 
    private int moviecomentseq;

    // 영화번호 
    private int movieseq;

    // 작성자 
    private String userseq;

    // 내용 
    private String moviecomentcontent;

    // 날짜 
    private Date moviecomentdate;

    public int getMoviecomentseq() {
        return moviecomentseq;
    }

    public void setMoviecomentseq(int moviecomentseq) {
        this.moviecomentseq = moviecomentseq;
    }

    public int getMovieseq() {
        return movieseq;
    }

    public void setMovieseq(int movieseq) {
        this.movieseq = movieseq;
    }

    public String getUserseq() {
        return userseq;
    }

    public void setUserseq(String userseq) {
        this.userseq = userseq;
    }

    public String getMoviecomentcontent() {
        return moviecomentcontent;
    }

    public void setMoviecomentcontent(String moviecomentcontent) {
        this.moviecomentcontent = moviecomentcontent;
    }

    public Date getMoviecomentdate() {
        return moviecomentdate;
    }

    public void setMoviecomentdate(Date moviecomentdate) {
        this.moviecomentdate = moviecomentdate;
    }
}
