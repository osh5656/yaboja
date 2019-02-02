-- 테이블 삭제 --
DROP TABLE REVIEWBOARDCOMENT;
DROP TABLE REVIEWBOARD;
DROP TABLE COIN;
DROP TABLE MATCHING;
DROP TABLE MATCHINGBOARD;
DROP TABLE MOVIE;
DROP TABLE CHATTING;
DROP TABLE USERS;
DROP TABLE CINEMA;

-- 시퀀스 삭제 --
DROP SEQUENCE REVIEWBOARDCOMENT_SEQ;
DROP SEQUENCE REVIEWBOARD_SEQ;
DROP SEQUENCE COIN_SEQ;
DROP SEQUENCE MATCHINGSEQ;
DROP SEQUENCE MATCHINGBOARDSQ;
DROP SEQUENCE CHATTINGSQ;
DROP SEQUENCE USERS_SEQ;
DROP SEQUENCE CINEMA_SEQ;
DROP SEQUENCE MOVIE_SEQ;

--CINEMA

CREATE SEQUENCE CINEMA_SEQ;
CREATE TABLE CINEMA
(
    CINEMASEQ    NUMBER           NOT NULL, 
    CINEMA       VARCHAR2(20)     NULL, 
    LATITUDE     VARCHAR2(200)    NULL, 
    LONGITUDE    VARCHAR2(200)    NULL, 
    CONSTRAINT CINEMA_PK PRIMARY KEY (CINEMASEQ)
);

INSERT INTO CINEMA VALUES(CINEMA_SEQ.NEXTVAL,'강남cgv','37.501504','127.0248359');
INSERT INTO CINEMA VALUES(CINEMA_SEQ.NEXTVAL,'강변cgv','37.5354717','127.0935526');
INSERT INTO CINEMA VALUES(CINEMA_SEQ.NEXTVAL,'건대입구cgv','37.5397613','127.0647906');
INSERT INTO CINEMA VALUES(CINEMA_SEQ.NEXTVAL,'구로cgv','37.5013174','126.8803539');
INSERT INTO CINEMA VALUES(CINEMA_SEQ.NEXTVAL,'대학로cgv','37.583422','126.9976447');
INSERT INTO CINEMA VALUES(CINEMA_SEQ.NEXTVAL,'동대문cgv','37.5668686','127.0053944');
INSERT INTO CINEMA VALUES(CINEMA_SEQ.NEXTVAL,'명동cgv','37.5633408','126.9806747');
INSERT INTO CINEMA VALUES(CINEMA_SEQ.NEXTVAL,'명동역cgv','37.561253','126.9831314');
INSERT INTO CINEMA VALUES(CINEMA_SEQ.NEXTVAL,'목동cgv','37.5262575','126.8728266');
INSERT INTO CINEMA VALUES(CINEMA_SEQ.NEXTVAL,'미아cgv','37.6120245','127.0285156');
INSERT INTO CINEMA VALUES(CINEMA_SEQ.NEXTVAL,'불광cgv','37.6096413','126.9266212');
INSERT INTO CINEMA VALUES(CINEMA_SEQ.NEXTVAL,'상봉cgv','37.5975887','127.0901351');
INSERT INTO CINEMA VALUES(CINEMA_SEQ.NEXTVAL,'성신여대cgv','37.5925601','127.014865');
INSERT INTO CINEMA VALUES(CINEMA_SEQ.NEXTVAL,'송파cgv','37.4771298','127.1233607');
INSERT INTO CINEMA VALUES(CINEMA_SEQ.NEXTVAL,'수유cgv','37.642358','127.0275765');
INSERT INTO CINEMA VALUES(CINEMA_SEQ.NEXTVAL,'신촌cgv','37.5564819','126.9381437');
INSERT INTO CINEMA VALUES(CINEMA_SEQ.NEXTVAL,'압구정cgv','37.5403017','126.8451133');
INSERT INTO CINEMA VALUES(CINEMA_SEQ.NEXTVAL,'여의도cgv','37.5254692','126.9232276');
INSERT INTO CINEMA VALUES(CINEMA_SEQ.NEXTVAL,'영등포cgv','37.5170117','126.9003228');
INSERT INTO CINEMA VALUES(CINEMA_SEQ.NEXTVAL,'왕십리cgv','37.5620999','127.0359082');
INSERT INTO CINEMA VALUES(CINEMA_SEQ.NEXTVAL,'용산cgv','37.5300859','126.9629793');
INSERT INTO CINEMA VALUES(CINEMA_SEQ.NEXTVAL,'중계cgv','37.6399709','127.0663748');
INSERT INTO CINEMA VALUES(CINEMA_SEQ.NEXTVAL,'천호cgv','37.5456582','127.1400606');
INSERT INTO CINEMA VALUES(CINEMA_SEQ.NEXTVAL,'청담cgv','37.5228508','127.0348377');
INSERT INTO CINEMA VALUES(CINEMA_SEQ.NEXTVAL,'피카다리cgv','37.5710462','126.9890101');
INSERT INTO CINEMA VALUES(CINEMA_SEQ.NEXTVAL,'하계cgv','37.6399709','127.0663748');
INSERT INTO CINEMA VALUES(CINEMA_SEQ.NEXTVAL,'홍대cgv','37.5564405','126.9204271');

select * from cinema;
delete from cinema;
delete from USERS;
--USERS

CREATE SEQUENCE USERS_SEQ;
CREATE TABLE USERS
(
    USERSEQ        NUMBER           NOT NULL, 
    USERID         VARCHAR2(200)    NULL, 
    USERPW         VARCHAR2(200)    NULL, 
    USERNAME       VARCHAR2(200)    NULL, 
    USERPROFILE    VARCHAR2(200)    NULL, 
    USERSEX        VARCHAR2(200)    NULL, 
    USERAGE        VARCHAR2(200)    NULL, 
    USERADDRESS    VARCHAR2(200)    NULL, 
    USEREMAIL      VARCHAR2(2000)    NULL, 
    USERCINEMA1    NUMBER           NULL, 
    USERCINEMA2    NUMBER           NULL, 
    USERCINEMA3    NUMBER           NULL, 
    USERGRADE      VARCHAR2(200)    NULL, 
    CONSTRAINT USERS_PK PRIMARY KEY (USERSEQ),
    CONSTRAINT FK_USERS_USERCINEMA1_CINEMA_CI FOREIGN KEY (USERCINEMA1)
    REFERENCES CINEMA (CINEMASEQ),
    CONSTRAINT FK_USERS_USERCINEMA2_CINEMA_CI FOREIGN KEY (USERCINEMA2)
    REFERENCES CINEMA (CINEMASEQ),
    CONSTRAINT FK_USERS_USERCINEMA3_CINEMA_CI FOREIGN KEY (USERCINEMA3)
    REFERENCES CINEMA (CINEMASEQ)
);    
 




-- 채팅 --
CREATE SEQUENCE CHATTINGSQ;
CREATE TABLE CHATTING(
    CHATSEQ        NUMBER            NOT NULL, 
    USERSEQ1       NUMBER            NULL, 
    USERSEQ2       NUMBER            NULL, 
    CHATCONTENT    VARCHAR2(2000)    NULL, 
    CHATTIME       DATE              NULL, 
    CHATREAD       NUMBER            NULL, 
    CONSTRAINT CHATTING_PK PRIMARY KEY (CHATSEQ)
);
ALTER TABLE CHATTING
    ADD CONSTRAINT FK_CHATTING_USERSEQ1_USERS_USE FOREIGN KEY (USERSEQ1)
        REFERENCES USERS (USERSEQ);



ALTER TABLE CHATTING
    ADD CONSTRAINT FK_CHATTING_USERSEQ2_USERS_USE FOREIGN KEY (USERSEQ2)
        REFERENCES USERS (USERSEQ);






-- 영화 --
CREATE SEQUENCE MOVIE_SEQ;
CREATE TABLE MOVIE(
    MOVIESEQ      NUMBER            NOT NULL, 
    MOVIETITLE    VARCHAR2(200)     NULL, 
    RATING        VARCHAR2(20)      NULL, 
    GENRE         VARCHAR2(200)     NULL, 
    TIME          VARCHAR2(2000)    NULL, 
    PUPDATE       VARCHAR2(200)     NULL, 
    MOVIESTATE    VARCHAR2(200)     NULL, 
    DIRECTOR      VARCHAR2(200)     NULL, 
    ACTOR         VARCHAR2(2000)    NULL, 
    IMGURL        VARCHAR2(2000)    NULL, 
    CODE          VARCHAR2(200)     NULL, 
    CONSTRAINT MOVIE_PK PRIMARY KEY (MOVIESEQ)
);



-- 매칭게시판 --
CREATE SEQUENCE MATCHINGBOARDSQ;
CREATE TABLE MATCHINGBOARD
(
    MATCHINGBOARD           NUMBER           NOT NULL, 
    MOVIESEQ                NUMBER           NOT NULL, 
    USERSEQ                 NUMBER           NOT NULL, 
    MATCHINGBOARDTITLE      VARCHAR2(200)    NOT NULL, 
    MATCHINGBOARDCONTENT    VARCHAR2(200)    NOT NULL, 
    MATCHINGBOARDDATE       DATE             NOT NULL, 
    CINEMASEQ               NUMBER           NOT NULL,
    CONSTRAINT MATCHINGBOARD_PK PRIMARY KEY (MATCHINGBOARD)
);
ALTER TABLE MATCHINGBOARD
    ADD CONSTRAINT FK_MATCHINGBOARD_USERSEQ_USERS FOREIGN KEY (USERSEQ)
        REFERENCES USERS (USERSEQ);

ALTER TABLE MATCHINGBOARD
    ADD CONSTRAINT FK_MATCHINGBOARD_MOVIESEQ_MOVI FOREIGN KEY (MOVIESEQ)
        REFERENCES MOVIE (MOVIESEQ);

ALTER TABLE MATCHINGBOARD
    ADD CONSTRAINT FK_MATCHINGBOARD_CINEMASEQ_CIN FOREIGN KEY (CINEMASEQ)
        REFERENCES CINEMA (CINEMASEQ);
ALTER TABLE MATCHINGBOARD
   ADD CONSTRAINT UQ_MATCHINGBOARD_USERSEQ UNIQUE (USERSEQ);

        
        

   
   
-- 매칭 --
CREATE SEQUENCE MATCHINGSEQ;
CREATE TABLE MATCHING(
    MATCHINGSEQ          NUMBER          NOT NULL, 
    MATCHINGWRITER       NUMBER          NULL, 
    MATCHINGAPPLICANT    NUMBER          NULL, 
    MATCHINGSTATE        VARCHAR2(20)    NULL, 
    WRITERNOTICE         NUMBER          NULL, 
    APPLICANTNOTICE      NUMBER          NULL, 
    MATCHINGDATE         DATE            NULL, 
    SELECTEDAPPLICANT    VARCHAR2(20)    NULL, 
    CINEMASEQ            NUMBER          NULL, 
    MOVIESEQ             NUMBER          NULL, 
    CONSTRAINT MATCHING_PK PRIMARY KEY (MATCHINGSEQ)
);

ALTER TABLE MATCHING
    ADD CONSTRAINT FK_MATCHING_MATCHINGAPPLICANT_ FOREIGN KEY (MATCHINGAPPLICANT)
        REFERENCES USERS (USERSEQ);
ALTER TABLE MATCHING
    ADD CONSTRAINT FK_MATCHING_MOVIESEQ_MOVIE_MOV FOREIGN KEY (MOVIESEQ)
        REFERENCES MOVIE (MOVIESEQ);
ALTER TABLE MATCHING
    ADD CONSTRAINT FK_MATCHING_CINEMASEQ_CINEMA_C FOREIGN KEY (CINEMASEQ)
        REFERENCES CINEMA (CINEMASEQ);
ALTER TABLE MATCHING
    ADD CONSTRAINT FK_MATCHING_MATCHINGWRITER_USE FOREIGN KEY (MATCHINGWRITER)
        REFERENCES USERS (USERSEQ);
        

--코인--

CREATE SEQUENCE COIN_SEQ;
CREATE TABLE COIN
(
    COINSEQ     NUMBER    NOT NULL, 
    USERSEQ     NUMBER    NOT NULL, 
    COINLOG     NUMBER    NOT NULL, 
    COINDATE    DATE      NOT NULL,
    COINSTATE   VARCHAR(200) NOT NULL,
    CONSTRAINT COIN_PK PRIMARY KEY (COINSEQ)
);

ALTER TABLE COIN
    ADD CONSTRAINT FK_COIN_USERSEQ FOREIGN KEY (USERSEQ)
        REFERENCES USERS (USERSEQ);
       
        
--영화정보 댓글
DROP SEQUENCE MOVIECOMENT_SEQ;
DROP TABLE MOVIECOMENT;

CREATE SEQUENCE MOVIECOMENT_SEQ;


CREATE TABLE MOVIECOMENT
(
    MOVIECOMENTSEQ        NUMBER            NOT NULL, 
    MOVIESEQ              NUMBER            NULL, 
    USERNAME              VARCHAR2(200)     NULL, 
    MOVIECOMENTCONTENT    VARCHAR2(2000)    NULL, 
    MOVIECOMENTDATE       DATE              NULL, 
    USERSEQ               NUMBER            NULL, 
    CONSTRAINT MOVIECOMENT_PK PRIMARY KEY (MOVIECOMENTSEQ)
);

ALTER TABLE MOVIECOMENT
    ADD CONSTRAINT FK_MOVIECOMENT FOREIGN KEY (MOVIESEQ)
        REFERENCES MOVIE (MOVIESEQ);

ALTER TABLE MOVIECOMENT
    ADD CONSTRAINT FK_MOVIE_USERSEQ FOREIGN KEY (USERSEQ)
        REFERENCES USERS (USERSEQ);

        
        
        
        
        
-- 리뷰게시판 --

CREATE SEQUENCE REVIEWBOARD_SEQ;
CREATE TABLE REVIEWBOARD(
   REVIEWBOARDSEQ NUMBER NOT NULL,
   USERSEQ NUMBER NOT NULL,
   MOVIETITLE NUMBER NOT NULL,
   REVIEWBOARDTITLE VARCHAR2(200) NULL,
   REVIEWBOARDCONTENT VARCHAR2(4000) NULL,
   REVIEWBOARDDATE DATE NULL,
   REVIEWBOARDVIEW NUMBER NOT NULL,
   CONSTRAINT REVIEWBOARD_PK PRIMARY KEY (REVIEWBOARDSEQ)
   );
    
   ALTER TABLE REVIEWBOARD
    ADD CONSTRAINT FK_REVIEWBOARD_USERSEQ_USERS_U FOREIGN KEY (USERSEQ)
        REFERENCES USERS (USERSEQ);
        
    ALTER TABLE REVIEWBOARD
    ADD CONSTRAINT FK_REVIEWBOARD_MOVIETITLE_MOVI FOREIGN KEY (MOVIETITLE)
        REFERENCES MOVIE (MOVIESEQ);




-- 리뷰게시판 댓글  --
CREATE SEQUENCE REVIEWBOARDCOMENT_SEQ;
CREATE TABLE REVIEWBOARDCOMENT
(
    REVIEWBOARDCOMENTSEQ        NUMBER            NOT NULL, 
    REVIEWBOARDSEQ               NUMBER            NULL, 
    REVIEWBOARDCOMENTCONTENT    VARCHAR2(2000)    NULL, 
    USERNAME                      VARCHAR2(200)      NULL, 
    REVIEWBOARDCOMENTDATE       DATE              NULL,
    USERSEQ                     NUMBER       NULL,
    CONSTRAINT REVIEWBOARDCOMENT_PK PRIMARY KEY (REVIEWBOARDCOMENTSEQ)
);

ALTER TABLE REVIEWBOARDCOMENT
    ADD CONSTRAINT FK_REVIEWBOARDCOMENT FOREIGN KEY (REVIEWBOARDSEQ)
        REFERENCES REVIEWBOARD (REVIEWBOARDSEQ);

ALTER TABLE REVIEWBOARDCOMENT
    ADD CONSTRAINT FK_REVIEW_USERSEQ FOREIGN KEY (USERSEQ)
        REFERENCES USERS (USERSEQ);
        
delete from movie;

delete from MATCHING;

delete from matchingboard;

delete from chatting;

INSERT INTO USERS VALUES(1000,'admin','123','최강일','1','남','20','서울','네이버',null,null,null,'admin');

delete from MATCHINGBOARD;