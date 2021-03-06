CREATE TABLE TB_SCHEDULE
(
S_ID  CHAR(10) PRIMARY KEY,
TITLE   VARCHAR2(20),
S_DATE    DATE NOT NULL,
S_CONTENT VARCHAR2(50)
);
COMMENT ON COLUMN TB_SCHEDULE.S_ID IS '일정번호';
COMMENT ON COLUMN TB_SCHEDULE.TITLE IS '제목';
COMMENT ON COLUMN TB_SCHEDULE.S_DATE IS '날짜';
COMMENT ON COLUMN TB_SCHEDULE.S_CONTENT IS '내용';

CREATE SEQUENCE SEQ_ID
START WITH 1
INCREMENT BY 1
NOCYCLE
CACHE 10;

COMMIT;

SELECT COUNT(*)
FROM TB_SCHEDULE
WHERE S_DATE = '2019/01/01';

DELETE TB_SCHEDULE;
DROP TABLE TB_SCHEDULE;
insert into tb_schedule 
values ( (20190101||LPAD( (select count(*) from tb_schedule where s_date = '2019/01/01')+1 ,2 ,0)),
        'TEST6' ,
        '2019/01/01' ,
        '11' );