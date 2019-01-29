CREATE TABLE USER_ACCOUNT
(
ACC_NUMBER CHAR(10) ,
SSN	CHAR(14) UNIQUE,
BAL	NUMBER DEFAULT 0,
PHONE VARCHAR2(11) NOT NULL,
U_NAME VARCHAR2(20) NOT NULL,
ESTDATE DATE NOT NULL,
ID	VARCHAR2(10),
PASSWORD VARCHAR2(15),
CONSTRAINTS PK_ACCOUNT PRIMARY KEY(ACC_NUMBER, ID)
);
DROP TABLE USER_ACCOUNT;

CREATE SEQUENCE SEQ_ACC
START WITH 1
INCREMENT BY 1
NOCYCLE
NOCACHE;


COMMENT ON COLUMN USER_ACCOUNT.ACC_NUMBER IS '계좌 번호';
COMMENT ON COLUMN USER_ACCOUNT.SSN IS '주민등록번호';
COMMENT ON COLUMN USER_ACCOUNT.BAL IS '현재 잔액';
COMMENT ON COLUMN USER_ACCOUNT.U_NAME IS '이름';
COMMENT ON COLUMN USER_ACCOUNT.ESTDATE IS '통장 개설 날짜';
COMMENT ON COLUMN USER_ACCOUNT.ID IS '아이디';
COMMENT ON COLUMN USER_ACCOUNT.PASSWORD IS '비밀번호';



SELECT * FROM USER_ACCOUNT;

DROP TABLE BANK_LOG;
CREATE TABLE BANK_LOG
(
ID CHAR(10) NOT NULL,
RECEIVER_ID CHAR(10),
EX_DATE DATE NOT NULL,
DEPOSIT NUMBER,
WITHDRAW NUMBER,
USER_COMMENT VARCHAR2(50)
);

COMMENT ON COLUMN BANK_LOG.ID IS '아이디';
COMMENT ON COLUMN BANK_LOG.RECEIVER_ID IS '받는사람 아이디';
COMMENT ON COLUMN BANK_LOG.EX_DATE IS '거래일시';
COMMENT ON COLUMN BANK_LOG.DEPOSIT IS '입금액';
COMMENT ON COLUMN BANK_LOG.WITHDRAW IS '출금액';
COMMENT ON COLUMN BANK_LOG.USER_COMMENT IS '메세지';

COMMIT;
delete from user_account;
select id from user_account where id = 'tjrghekt' and password = '1234';

