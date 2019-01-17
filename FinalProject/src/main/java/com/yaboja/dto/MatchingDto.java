package com.yaboja.dto;

import java.util.Date;

public class MatchingDto {

	// 매칭 번호 
    private int matchingseq;

    // 사용자1_작성 
    private int matchingwriter;

    // 사용자2_신청 
    private int matchingapplicant;

    // 매칭 상 
    private String matchingstate;

    // 작성자알림 
    private String writernotice;

    // 신청자알림 
    private String applicantnotice;

    // 날짜 
    private Date matchingdate;

    // 선택 체 
    private String selectedapplicant;

    public int getMatchingseq() {
        return matchingseq;
    }

    public void setMatchingseq(int matchingseq) {
        this.matchingseq = matchingseq;
    }

    public int getMatchingwriter() {
        return matchingwriter;
    }

    public void setMatchingwriter(int matchingwriter) {
        this.matchingwriter = matchingwriter;
    }

    public int getMatchingapplicant() {
        return matchingapplicant;
    }

    public void setMatchingapplicant(int matchingapplicant) {
        this.matchingapplicant = matchingapplicant;
    }

    public String getMatchingstate() {
        return matchingstate;
    }

    public void setMatchingstate(String matchingstate) {
        this.matchingstate = matchingstate;
    }

    public String getWriternotice() {
        return writernotice;
    }

    public void setWriternotice(String writernotice) {
        this.writernotice = writernotice;
    }

    public String getApplicantnotice() {
        return applicantnotice;
    }

    public void setApplicantnotice(String applicantnotice) {
        this.applicantnotice = applicantnotice;
    }

    public Date getMatchingdate() {
        return matchingdate;
    }

    public void setMatchingdate(Date matchingdate) {
        this.matchingdate = matchingdate;
    }

    public String getSelectedapplicant() {
        return selectedapplicant;
    }

    public void setSelectedapplicant(String selectedapplicant) {
        this.selectedapplicant = selectedapplicant;
    }
}