CREATE TABLE Movie-Matching.USER(
    USERSEQ           NUMBER            NOT NULL, 
    USERID            VARCHAR2(200)     NULL, 
    USERPW            VARCHAR2(200)     NULL, 
    USERNAME          VARCHAR2(200)     NULL, 
    USERPROFILE       VARCHAR2(200)     NULL, 
    USERSEX           VARCHAR2(200)     NULL, 
    USERAGE           VARCHAR2(200)     NULL, 
    USERADDRESS       VARCHAR2(200)     NULL, 
    USEREMAIL         BLOB              NULL, 
    USEREMAILHASH     VARCHAR2(2000)    NULL, 
    USEREMAILCHECK    VARCHAR2(200)     NULL, 
    USERTEATHER1      NUMBER            NULL, 
    USERTEATHER2      NUMBER            NULL, 
    USERTEATHER3      NUMBER            NULL, 
    USERGRADE         VARCHAR2(200)     NULL, 
    CONSTRAINT USER_PK PRIMARY KEY (USERSEQ)
);