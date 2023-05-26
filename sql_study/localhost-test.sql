CREATE TABLE EMP (
    NO   NUMBER,
    NAME VARCHAR2(20),
    AGE  NUMBER
);

CREATE TABLE CUSTOMER (
    ID      NUMBER PRIMARY KEY, -- 유일한 값, 중복 안됨, 기본 not null
    NAME    VARCHAR2(20) NOT NULL, -- null 허용 안됨
    ADDRESS VARCHAR2(100)
);

CREATE TABLE ORDERS (
    ORDER_ID    NUMBER PRIMARY KEY,
    SALESMAN_ID NUMBER,
    ORDER_DATE  DATE NOT NULL
);

CREATE TABLE CATEGORIES (
    CATEGORY_ID NUMBER PRIMARY KEY,
    CATEGORY_NAME VARCHAR2(100) NOT NULL
);

CREATE TABLE LOCATION (
    LOCATION_ID NUMBER PRIMARY KEY,
    ADDRESS     VARCHAR2(255) NOT NULL,
    POSTAL_CODE VARCHAR2(20),
    CITY        VARCHAR2(50)
);

select * from nls_database_parameters where parameter = 'NLS_CHARACTERSET';

-- 성별 컬럼 추가
ALTER TABLE CUSTOMER ADD GENDER VARCHAR2(9);

-- 컬럼명 변경
ALTER TABLE CUSTOMER RENAME COLUMN GENDER TO GEN;
ALTER TABLE CUSTOMER RENAME COLUMN GEN TO GENDER; -- 원복

-- 컬럼 속성 변경
ALTER TABLE CUSTOMER MODIFY GENDER VARCHAR2(100); -- 크기 변경
ALTER TABLE CUSTOMER MODIFY GENDER NUMBER; -- 데이터 타입 변경
ALTER TABLE CUSTOMER MODIFY GENDER NOT NULL; -- 제약조건 수정
ALTER TABLE CUSTOMER MODIFY GENDER VARCHAR2(100) DEFAULT 'NONE'; -- 데이터 타입, 디폴트 값

-- 컬럼에 설명달기
COMMENT ON COLUMN CUSTOMER.GENDER IS '성별';

-- 컬럼 삭제
ALTER TABLE CUSTOMER DROP COLUMN NAME;
ALTER TABLE CUSTOMER DROP COLUMN ADDRESS;
ALTER TABLE CUSTOMER DROP COLUMN GENDER;

-- 테이블 구조 변경 QUIZ
ALTER TABLE EMP ADD SALARY NUMBER;

ALTER TABLE EMP MODIFY SALARY NOT NULL;

COMMENT ON COLUMN EMP.NO IS '번호';
COMMENT ON COLUMN EMP.NAME IS '이름';
COMMENT ON COLUMN EMP.AGE IS '나이';
COMMENT ON COLUMN EMP.SALARY IS '월급';

ALTER TABLE ORDERS ADD CUSTOMER_NAME VARCHAR2(50) NOT NULL;

ALTER TABLE ORDERS MODIFY SALESMAN_ID VARCHAR2(50);

ALTER TABLE ORDERS RENAME COLUMN SALESMAN_ID TO SALESMAN_NAME;

ALTER TABLE ORDERS MODIFY ORDER_DATE NULL;

COMMENT ON COLUMN ORDERS.ORDER_ID IS '주문번호';
COMMENT ON COLUMN ORDERS.SALESMAN_NAME IS '판매원 이름';
COMMENT ON COLUMN ORDERS.ORDER_DATE IS '주문 날짜';
COMMENT ON COLUMN ORDERS.CUSTOMER_NAME IS '고객 이름';

DROP TABLE EMP;
DROP TABLE CUSTOMER;
DROP TABLE LOCATION;
DROP TABLE ORDERS;
DROP TABLE CATEGORIES;

-- 데이터 추가

SELECT * FROM CUSTOMER;

INSERT INTO CUSTOMER(ID, NAME, ADDRESS) VALUES(1, '둘리', '인천');
INSERT INTO CUSTOMER VALUES(2, '둘리', '인천'); -- 완전한 데이터 추가시 컬럼명 생략 가능

-- 불완전한 데이터 추가: 컬럼명 반드시 명시
INSERT INTO CUSTOMER(ID, NAME) VALUES(3, '또치');
INSERT INTO CUSTOMER(NAME) VALUES('마이콜'); -- NOT NULL 에러

INSERT INTO CUSTOMER VALUES(4, '둘리', '');
INSERT INTO CUSTOMER VALUES(5, '홍길동', NULL);

INSERT INTO CUSTOMER VALUES(5, '희동이', '서울'); -- PK 제약조건 에러

SELECT * FROM ORDERS;

INSERT INTO ORDERS VALUES(1001, 2002, SYSDATE); -- 현재 시간
INSERT INTO ORDERS VALUES(1002, 2002, '2022-08-27'); -- 특정 시간

INSERT INTO ORDERS VALUES(1003, 2002, TO_DATE('2022-08-27', 'YYYY-MM-DD')); -- 날짜 포맷
INSERT INTO ORDERS VALUES(1004, 2002, TO_DATE('2022-08-27 10:10:10', 'YYYY-MM-DD HH24:MI:SS')); -- 날짜 포맷

SELECT * FROM CUSTOMER;
SELECT * FROM ORDERS;

UPDATE CUSTOMER SET ADDRESS = '서울' WHERE ID = 2;
UPDATE CUSTOMER SET NAME = '훈이', ADDRESS = '제주도' WHERE ID = 3;
UPDATE ORDERS SET ORDER_DATE = '2023-05-22 12:12:12' WHERE ORDER_ID = 1002;

DELETE FROM CUSTOMER WHERE ID = 4;
DELETE FROM CUSTOMER WHERE NAME = '둘리';
DELETE FROM CUSTOMER; -- 모든 레코드 삭제

-- 2개 이상의 조건이 있을때
DELETE FROM ORDERS WHERE ORDER_ID = 1001 AND SALESMAN_ID = 2002;

-- 데이터 추가 QUIZ
CREATE TABLE BOOK (
    BOOK_NO NUMBER PRIMARY KEY,
    NAME VARCHAR2(100),
    PUBLISHER VARCHAR2(100),
    PRICE NUMBER
);
SELECT * FROM BOOK;

INSERT INTO BOOK VALUES(1, '역사1', '상상마당', 30000);
INSERT INTO BOOK VALUES(2, '역사2', '상상마당', 30000);
INSERT INTO BOOK VALUES(3, '스프링웹프로젝트', '한빛미디어', 50000);
INSERT INTO BOOK VALUES(4, '자바개발도서', '생능출판', NULL);

SELECT * FROM EMP;
INSERT INTO EMP VALUES(NULL, NULL, NULL);
INSERT INTO EMP VALUES(1, NULL, NULL);
INSERT INTO EMP VALUES(NULL, '둘리', 10);
INSERT INTO EMP VALUES(1, '둘리', 10);
INSERT INTO EMP VALUES(1, '둘리', 10);

CREATE TABLE CONTACTS (
    CONTACT_NO NUMBER PRIMARY KEY,
    FIRST_NAME VARCHAR2(10),
    LAST_NAME VARCHAR2(20),
    EMAIL VARCHAR2(100),
    PHONE NUMBER
);
SELECT * FROM CONTACTS;
INSERT INTO CONTACTS VALUES(1, '이', '서연', 'flor.stone@gmail.com', '010-3171-2341');
INSERT INTO CONTACTS VALUES(2, '이', '시우', 'lavera.emerson@gmail.com', '010-3171-4111');
INSERT INTO CONTACTS VALUES(3, '김', '지호', 'shyla.ortiz@gmail.com', '010-3171-4126');
INSERT INTO CONTACTS VALUES(4, '김', '윤서', 'jeni.levy@gmail.com', '010-8121-2341');
INSERT INTO CONTACTS VALUES(5, '최', '수아', 'fern.head@gmail.com', null);

CREATE TABLE CAL (
    MOMTH VARCHAR2(10),
    DAY_WEEK VARCHAR2(10),
    DAY VARCHAR2(10)
);
SELECT * FROM CAL;
INSERT INTO CAL VALUES(1, '일', 1);
INSERT INTO CAL VALUES(1, '월', 2);
INSERT INTO CAL VALUES(1, '화', 3);
INSERT INTO CAL VALUES(1, '수', 4);
INSERT INTO CAL VALUES(1, '목', 5);
INSERT INTO CAL VALUES(1, '금', 6);
INSERT INTO CAL VALUES(1, '토', 7);

CREATE TABLE GIFT (
    NO NUMBER PRIMARY KEY,
    NAME VARCHAR2(20),
    PRICE NUMBER
);
SELECT * FROM GIFT;
INSERT INTO GIFT VALUES(1, '참치세트', 100000);
INSERT INTO GIFT VALUES(2, '샴푸세트', 200000);
INSERT INTO GIFT VALUES(3, '세차용품세트', 300000);
INSERT INTO GIFT VALUES(4, '주방용품세트', 400000);
INSERT INTO GIFT VALUES(5, '산악용자전거', 500000);
INSERT INTO GIFT VALUES(6, 'LCD모니터', 600000);
INSERT INTO GIFT VALUES(7, '노트북', 700000);
INSERT INTO GIFT VALUES(8, '벽걸이TV', 800000);
INSERT INTO GIFT VALUES(9, '드럼세탁기', 900000);
INSERT INTO GIFT VALUES(10, '양쪽문냉장고', 1000000);

-- 데이터 수정 QUIZ
SELECT * FROM BOOK;
DELETE FROM BOOK;
INSERT INTO BOOK VALUES(1, '역사1', '상상마당', 10000);
INSERT INTO BOOK VALUES(2, '역사2', '상상마당', 11000);
INSERT INTO BOOK VALUES(3, '스프링웹프로젝트', '한빛미디어', 50000);
INSERT INTO BOOK VALUES(4, '자바프로그래밍', '생능출판', NULL);

UPDATE BOOK SET NAME = '자바개발도서' WHERE BOOK_NO = 4;

UPDATE BOOK SET PRICE = 30000 WHERE PUBLISHER = '상상마당';

SELECT * FROM CUSTOMER;
INSERT INTO CUSTOMER VALUES(1, '둘리', '인천');
INSERT INTO CUSTOMER VALUES(2, '둘리', NULL);
INSERT INTO CUSTOMER VALUES(3, '홍길동', NULL);
INSERT INTO CUSTOMER VALUES(4, '또치', NULL);

UPDATE CUSTOMER SET NAME = '둘리', ADDRESS = '인천';

-- 데이터 삭제 QUIZ
SELECT * FROM BOOK;
DELETE FROM BOOK;
INSERT INTO BOOK VALUES(1, '역사1', '상상마당', 10000);
INSERT INTO BOOK VALUES(2, '역사2', '상상마당', 11000);
INSERT INTO BOOK VALUES(3, '스프링웹프로젝트', '한빛미디어', 50000);
INSERT INTO BOOK VALUES(4, '자바프로그래밍', '생능출판', NULL);

DELETE FROM BOOK WHERE NAME = '역사1' AND PUBLISHER = '상상마당';

DELETE FROM BOOK WHERE BOOK_NO = 3;

DELETE FROM BOOK WHERE PRICE IS NULL;

DELETE FROM BOOK;

-- 예제 테이블 초기화
DROP TABLE CUSTOMER;
CREATE TABLE CUSTOMER (
    ID      NUMBER PRIMARY KEY,
    NAME    VARCHAR2(20) NOT NULL,
    ADDRESS VARCHAR2(100)
);
INSERT INTO CUSTOMER(ID, NAME, ADDRESS) VALUES(1, '둘리', '인천');
INSERT INTO CUSTOMER(ID, NAME, ADDRESS) VALUES(2, '둘리', '서울');
INSERT INTO CUSTOMER(ID, NAME, ADDRESS) VALUES(3, '홍길동','서울');
INSERT INTO CUSTOMER(ID, NAME, ADDRESS) VALUES(4, '또치', '제주도');
INSERT INTO CUSTOMER(ID, NAME, ADDRESS) VALUES(5, '도우너', '');
DROP TABLE ORDERS;
CREATE TABLE ORDERS (
    ORDER_ID    NUMBER PRIMARY KEY,
    SALESMAN_ID NUMBER,
    ORDER_DATE  DATE NOT NULL
);
INSERT INTO ORDERS(ORDER_ID, SALESMAN_ID, ORDER_DATE) VALUES(1001, 2002, '2022-01-01');
INSERT INTO ORDERS(ORDER_ID, SALESMAN_ID, ORDER_DATE) VALUES(1002, 2002, '2022-01-02');
INSERT INTO ORDERS(ORDER_ID, SALESMAN_ID, ORDER_DATE) VALUES(1003, 2002, '2022-01-03');
INSERT INTO ORDERS(ORDER_ID, SALESMAN_ID, ORDER_DATE) VALUES(1004, 2002, '2022-01-04');
DROP TABLE BOOK;
CREATE TABLE BOOK (
    BOOK_NO NUMBER PRIMARY KEY, --도서번호
    TITLE VARCHAR2(100) NOT NULL, --제목
    PUBLISHER VARCHAR2(100), --출판사
    PRICE NUMBER --가격
);
INSERT INTO BOOK (BOOK_NO, TITLE, PUBLISHER, PRICE) VALUES (1, '역사1', '상상마당', 10000);
INSERT INTO BOOK (BOOK_NO, TITLE, PUBLISHER, PRICE) VALUES (2, '역사2', '상상마당', 11000);
INSERT INTO BOOK (BOOK_NO, TITLE, PUBLISHER, PRICE) VALUES (3, '스프링웹프로젝트', '한빛미디어', 50000);
INSERT INTO BOOK (BOOK_NO, TITLE, PUBLISHER, PRICE) VALUES (4, '자바프로그래밍', '생능출판', 25000);
 DROP TABLE CONTACTS;
 CREATE TABLE CONTACTS 
  (
    CONTACT_NO NUMBER PRIMARY KEY,
    FIRST_NAME  VARCHAR2( 255 ) NOT NULL,
    LAST_NAME   VARCHAR2( 255 ) NOT NULL,
    EMAIL       VARCHAR2( 255 ) NOT NULL,
    PHONE       VARCHAR2( 20 )         
  );
INSERT INTO CONTACTS VALUES (1,'이','서연','flor.stone@gmail.com','010-3171-2341');
INSERT INTO CONTACTS VALUES (2,'이','시우','lavera.emerson@gmail.com','010-3171-4111');
INSERT INTO CONTACTS VALUES (3,'김','지호','shyla.ortiz@gmail.com','010-3171-4126');
INSERT INTO CONTACTS VALUES (4,'김','윤서','jeni.levy@gmail.com','010-8121-2341');
INSERT INTO CONTACTS VALUES (5,'최','수아','fern.head@gmail.com', NULL);
DROP TABLE GIFT;
CREATE TABLE GIFT (
    NO    NUMBER,
    TYPE  VARCHAR2(20),
    NAME  VARCHAR2(20),
    PRICE NUMBER
);
INSERT INTO GIFT VALUES(1,'식품','참치세트',100000);
INSERT INTO GIFT VALUES(2,'생활용품','샴푸세트',200000);
INSERT INTO GIFT VALUES(3,'생활용품','세차용품세트',300000);
INSERT INTO GIFT VALUES(4,'생활용품','주방용품세트',400000);
INSERT INTO GIFT VALUES(5,'운동장비','산악용자전거',500000);
INSERT INTO GIFT VALUES(6,'가전제품','LCD모니터',600000);
INSERT INTO GIFT VALUES(7,'가전제품','노트북',700000);
INSERT INTO GIFT VALUES(8,'가전제품','벽걸이TV',800000);
INSERT INTO GIFT VALUES(9,'가전제품','드럼세탁기',900000);
INSERT INTO GIFT VALUES(10,'가전제품','양쪽문냉장고',1000000);

-- 데이터 조회
SELECT * FROM CUSTOMER;

SELECT NAME, ID, ADDRESS FROM CUSTOMER;

SELECT * FROM CUSTOMER ORDER BY ID; -- 오름차순(디폴트)
SELECT * FROM CUSTOMER ORDER BY ID DESC; -- 내림차순

SELECT * FROM GIFT;
SELECT TYPE FROM GIFT GROUP BY TYPE; -- GROUP BY 컬럼에 있는것만 SELECT에 쓸 수 있다.

SELECT TYPE, COUNT(NAME) FROM GIFT GROUP BY TYPE;
SELECT TYPE, SUM(PRICE) FROM GIFT GROUP BY TYPE;




