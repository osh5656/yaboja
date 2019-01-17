package com.yaboja.dto;

public class UserDto {

	// 사용자번호 
    private int userseq;

    // 아이디 
    private String userid;

    // 비밀번호 
    private String userpw;

    // 이름 
    private String username;

    // 프로필사진 
    private String userprofile;

    // 성별 
    private String usersex;

    // 연령대 
    private String userage;

    // 주소 
    private String useraddress;

    // 이메일 
    private String useremail;

    // 이메일(해쉬) 
    private String useremailhash;

    // 이메일체크 
    private String useremailcheck;

    // 등록영화관1 
    private int usertheater1;

    // 등록영화관2 
    private int usertheater2;

    // 등록영화관3 
    private int usertheater3;

    // 등급 
    private String usergrade;

    public int getUserseq() {
        return userseq;
    }

    public void setUserseq(int userseq) {
        this.userseq = userseq;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUserpw() {
        return userpw;
    }

    public void setUserpw(String userpw) {
        this.userpw = userpw;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserprofile() {
        return userprofile;
    }

    public void setUserprofile(String userprofile) {
        this.userprofile = userprofile;
    }

    public String getUsersex() {
        return usersex;
    }

    public void setUsersex(String usersex) {
        this.usersex = usersex;
    }

    public String getUserage() {
        return userage;
    }

    public void setUserage(String userage) {
        this.userage = userage;
    }

    public String getUseraddress() {
        return useraddress;
    }

    public void setUseraddress(String useraddress) {
        this.useraddress = useraddress;
    }

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    public String getUseremailhash() {
        return useremailhash;
    }

    public void setUseremailhash(String useremailhash) {
        this.useremailhash = useremailhash;
    }

    public String getUseremailcheck() {
        return useremailcheck;
    }

    public void setUseremailcheck(String useremailcheck) {
        this.useremailcheck = useremailcheck;
    }

    public int getUsertheater1() {
        return usertheater1;
    }

    public void setUsertheater1(int usertheater1) {
        this.usertheater1 = usertheater1;
    }

    public int getUsertheater2() {
        return usertheater2;
    }

    public void setUsertheater2(int usertheater2) {
        this.usertheater2 = usertheater2;
    }

    public int getUsertheater3() {
        return usertheater3;
    }

    public void setUsertheater3(int usertheater3) {
        this.usertheater3 = usertheater3;
    }

    public String getUsergrade() {
        return usergrade;
    }

    public void setUsergrade(String usergrade) {
        this.usergrade = usergrade;
    }
   
  
}
