package com.yaboja.dto;

import java.util.Date;

public class MovieDto {

	// 영화번호 
    private int movieseq;

    // 장르 
    private String genre;

    // 영화제목 
    private String movietitle;

    // 영화개봉날짜 
    private Date movieopendate;

    // 영화체크(예정/상영/종영) 
    private String moviestate;

    // 영화감독 
    private String director;

    // 출연배우 
    private String actor;

    // 관람객평 
    private int userng;

    // 이미지URL 
    private String image;

    public int getMovieseq() {
        return movieseq;
    }

    public void setMovieseq(int movieseq) {
        this.movieseq = movieseq;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getMovietitle() {
        return movietitle;
    }

    public void setMovietitle(String movietitle) {
        this.movietitle = movietitle;
    }

    public Date getMovieopendate() {
        return movieopendate;
    }

    public void setMovieopendate(Date movieopendate) {
        this.movieopendate = movieopendate;
    }

    public String getMoviestate() {
        return moviestate;
    }

    public void setMoviestate(String moviestate) {
        this.moviestate = moviestate;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public int getUserng() {
        return userng;
    }

    public void setUserng(int userng) {
        this.userng = userng;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
