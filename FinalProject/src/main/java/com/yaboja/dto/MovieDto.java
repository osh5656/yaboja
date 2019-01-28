package com.yaboja.dto;


public class MovieDto {
	
	// 영화번호 
    private int movieSeq;
    
    // 영화제목 
    private String movieTitle;
    
    // 관람객평 
    private String rating;

    // 장르 
    private String genre;
    
    // 상영시간
    private String time;

    // 영화개봉날짜 
    private String pupDate;

    // 영화체크(예정/상영/종영) 
    private String movieState;

    // 영화감독 
    private String director;

    // 출연배우 
    private String actor;

    // 이미지URL 
    private String imgUrl;
    
    // 네이버 영화 코드
    private String code;

	public MovieDto() {
		super();
	}

	public MovieDto(int movieSeq, String movieTitle, String rating, String genre, String time, String pupDate,
			String movieState, String director, String actor, String imgUrl, String code) {
		super();
		this.movieSeq = movieSeq;
		this.movieTitle = movieTitle;
		this.rating = rating;
		this.genre = genre;
		this.time = time;
		this.pupDate = pupDate;
		this.movieState = movieState;
		this.director = director;
		this.actor = actor;
		this.imgUrl = imgUrl;
		this.code = code;
	}
	
	

	public MovieDto(String movieTitle, String rating, String genre, String time, String pupDate, String movieState,
			String director, String actor, String imgUrl, String code) {
		super();
		this.movieTitle = movieTitle;
		this.rating = rating;
		this.genre = genre;
		this.time = time;
		this.pupDate = pupDate;
		this.movieState = movieState;
		this.director = director;
		this.actor = actor;
		this.imgUrl = imgUrl;
		this.code = code;
	}

	public int getMovieSeq() {
		return movieSeq;
	}

	public void setMovieSeq(int movieSeq) {
		this.movieSeq = movieSeq;
	}

	public String getMovieTitle() {
		return movieTitle;
	}

	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getPupDate() {
		return pupDate;
	}

	public void setPupDate(String pupDate) {
		this.pupDate = pupDate;
	}

	public String getMovieState() {
		return movieState;
	}

	public void setMovieState(String movieState) {
		this.movieState = movieState;
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

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "Movie [movieSeq=" + movieSeq + ", movieTitle=" + movieTitle + ", rating=" + rating + ", genre=" + genre
				+ ", time=" + time + ", pupDate=" + pupDate + ", movieState=" + movieState + ", director=" + director
				+ ", actor=" + actor + ", imgUrl=" + imgUrl + ", code=" + code + "]";
	}  
	
	



}
