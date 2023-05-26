CREATE TABLE DEPT ( -- 부서
    DEPT_NO NUMBER PRIMARY KEY,
    DEPT_NAME VARCHAR2(20) NOT NULL,
    DEPT_ADDRESS VARCHAR2(100)
);

CREATE TABLE EMP ( -- 사원
    EMP_NO NUMBER PRIMARY KEY,
    EMP_NAME VARCHAR2(20) NOT NULL,
    DEPT_NO NUMBER NOT NULL, -- 외래키 (DEPT 테이블의 DEPT_NO 컬럼을 참조한다)
    CONSTRAINT FK_DEPT_NO FOREIGN KEY(DEPT_NO) REFERENCES DEPT(DEPT_NO)
);

INSERT INTO DEPT VALUES(1, '인사부', NULL);
INSERT INTO DEPT VALUES(2, '연구부', NULL);
INSERT INTO DEPT VALUES(3, '홍보부', NULL);
SELECT * FROM DEPT;

INSERT INTO EMP VALUES(1001, '정소화', 3);
INSERT INTO EMP VALUES(1002, '김용욱', 1);
INSERT INTO EMP VALUES(1003, '고명석', 2);
INSERT INTO EMP VALUES(1004, '김연아', 4);

SELECT * FROM EMP;

DROP TABLE EMP; -- 자식 테이블
DROP TABLE DEPT; -- 부모 테이블

DROP TABLE DEPT CASCADE CONSTRAINTS;
DROP TABLE EMP CASCADE CONSTRAINTS;

-- 기본키와 외래키 QUIZ
CREATE TABLE CLASS(
    CLASS_NO NUMBER PRIMARY KEY,
    CLASS_NAME VARCHAR2(20) NOT NULL
);
INSERT INTO CLASS VALUES(1001, '수학');
INSERT INTO CLASS VALUES(1002, '국어');
SELECT * FROM CLASS;

CREATE TABLE STUDENT(
    STUDENT_NO NUMBER PRIMARY KEY,
    STUDENT_NAME VARCHAR2(20) NOT NULL
);
INSERT INTO STUDENT VALUES(2001, '정소화');
INSERT INTO STUDENT VALUES(2002, '김용욱');
INSERT INTO STUDENT VALUES(2003, '고명석');
SELECT * FROM STUDENT;

CREATE TABLE CLASS_STUDENT(
    CS_NO NUMBER PRIMARY KEY,
    CLASS_NO NUMBER NOT NULL,
    STUDENT_NO NUMBER NOT NULL,
    CONSTRAINT FK_CLASS_NO FOREIGN KEY(CLASS_NO) REFERENCES CLASS(CLASS_NO),
    CONSTRAINT FK_STUDENT_NO FOREIGN KEY(STUDENT_NO) REFERENCES STUDENT(STUDENT_NO)
);
INSERT INTO CLASS_STUDENT VALUES(1, 1001, 2001);
INSERT INTO CLASS_STUDENT VALUES(2, 1002, 2001);
INSERT INTO CLASS_STUDENT VALUES(3, 1001, 2002);
INSERT INTO CLASS_STUDENT VALUES(4, 1002, 2002);
INSERT INTO CLASS_STUDENT VALUES(5, 1002, 2003);
SELECT * FROM CLASS_STUDENT;


CREATE TABLE ACADEMY_A (
    STUDENT_NO NUMBER PRIMARY KEY,
    STUDNET_NAME VARCHAR2(20) NOT NULL
);
INSERT INTO ACADEMY_A VALUES(1001, '정소화');
INSERT INTO ACADEMY_A VALUES(1002, '김용욱');
INSERT INTO ACADEMY_A VALUES(1003, '고명석');
INSERT INTO ACADEMY_A VALUES(1004, '김연아');

CREATE TABLE ACADEMY_B (
    STUDENT_NO NUMBER PRIMARY KEY,
    STUDNET_NAME VARCHAR2(20) NOT NULL
);
INSERT INTO ACADEMY_B VALUES(1003, '고명석');
INSERT INTO ACADEMY_B VALUES(1004, '김연아');
INSERT INTO ACADEMY_B VALUES(1005, '김태환');
INSERT INTO ACADEMY_B VALUES(1006, '이윤아');

SELECT * FROM ACADEMY_A;
SELECT * FROM ACADEMY_B;

-- equi 조인: 두 테이블에서 컬럼의 값이 일치되는 행을 연결
SELECT t1.student_no, t1.studnet_name
FROM academy_a T1, academy_b T2
WHERE t1.student_no = t2.student_no;

-- non-equi 조인: =가 아닌걸 사용
SELECT *
FROM academy_a T1, academy_b T2
WHERE t1.student_no >= t2.student_no;

-- inner 조인: 교집합
select *
from academy_a t1
join academy_b t2
on t1.student_no = t2.student_no;

-- left 조인: 왼쪽 테이블의 모든 레코드를 가져오고 오른쪽 테이블은 공통된 것만 가져온다.
select *
from academy_a t1
left join academy_b t2
on t1.student_no = t2.student_no;

-- right 조인: 오른쪽 테이블의 모든 레코드를 가져오고 왼쪽 테이블은 공통된 것만 가져온다.
select *
from academy_a t1
right join academy_b t2
on t1.student_no = t2.student_no;

-- outer join: 합집합
select *
from academy_a t1
full outer join academy_b t2
on t1.student_no = t2.student_no;

-- natural 조인
select *
from academy_a t1
natural join academy_b t2;

-- 부서,직원 테이블 초기화
DROP TABLE EMP;
DROP TABLE DEPT;
CREATE TABLE DEPT (
    DEPT_NO      NUMBER PRIMARY KEY,
    DEPT_NAME    VARCHAR2(20) NOT NULL
);
CREATE TABLE EMP (
    EMP_NO      NUMBER PRIMARY KEY,
    EMP_NAME    VARCHAR2(20) NOT NULL,
    DEPT_NO NUMBER NOT NULL,
    CONSTRAINT FK_DEPT_NO FOREIGN KEY(DEPT_NO) REFERENCES DEPT (DEPT_NO)
);
INSERT INTO DEPT VALUES (1, '인사부');
INSERT INTO DEPT VALUES (2, '연구부');
INSERT INTO DEPT VALUES (3, '홍보부');
INSERT INTO EMP VALUES (1001, '정소화', 3);
INSERT INTO EMP VALUES (1002, '김용욱', 1);
INSERT INTO EMP VALUES (1003, '고명석', 2);

-- join quiz
-- quiz1 방법1 inner join
select t1.dept_name, t2.emp_name
from dept t1
join emp t2
on t1.dept_no = t2.dept_no;

-- quiz1 방법2 equi join
select t1.dept_name, t2.emp_name
from dept t1, emp t2
where t1.dept_no = t2.dept_no;

-- quiz2 방법1 inner join
select t1.student_no, t2.student_name, t3.class_name
from class_student t1
join student t2
on t1.student_no = t2.student_no
join class t3
on t1.class_no = t3.class_no;

-- quiz2 방법2 equi join
select t1.student_no, t2.student_name, t3.class_name
from class_student t1, student t2, class t3
where t1.student_no = t2.student_no
and t1.class_no = t3.class_no;

-- 집합 연산자
-- union all: 중복을 포함해서 조회
select * from academy_a
union all
select * from academy_b;

-- union: 중복을 제거해서 조회
select * from academy_a
union
select * from academy_b;

-- intersect: 공통된 부분만 중복 제거해서 조회
select * from academy_a
intersect
select * from academy_b;

-- minus: a테이블에서 공통된 부분을 포함한 b테이블을 제거하고 조회
select * from academy_a
minus
select * from academy_b;

-- having
select type, count(name) as count
from gift
group by type
having count(name) >= 2
order by type;






