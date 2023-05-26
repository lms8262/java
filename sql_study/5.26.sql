-- 스칼라 서브쿼리: select절에 서브쿼리가 온다
select t1.student_no,
        (select t2.student_name
        from academy_b t2
        where t2.student_no = t1.student_no) as name
from academy_a t1;

-- 인라인 뷰: from절에 서브쿼리가 온다.
select t1.student_no, t2.student_name
from academy_a t1,
    (select student_no, student_name from academy_b) t2
where t1.student_no = t2.student_no;

-- 중첩 서브쿼리
-- 비연관 서브쿼리: 메인쿼리와 관계를 맺고 있지 않다.
select * 
from academy_a
where student_name = (select student_name from academy_b where student_no = 1003);

--연관 서브쿼리: 메인쿼리와 관계를 맺고 있다.
select student_no
from academy_a t1
where student_name = (select t2.student_name
                      from academy_b t2
                      where t2.student_no = t1.student_no);

-- 단일행 서브쿼리: 행 하나만 반환
select *
from academy_a
where student_name = (select student_name
                      from academy_b
                      where student_no = 1003);
                      
-- 다중행 서브쿼리: 여러행의 데이터를 반환(연관서브쿼리가 아닌데 여러행을 반환할 경우 in을 사용한다.)
select *
from academy_a
where student_name in (select student_name
                      from academy_b
                      where student_no = 1003 or student_no = 1004);

-- 다중 컬럼 서브쿼리: 서브쿼리가 여러개의 컬럼 반환
select *
from academy_a
where (student_name, student_no) in (select student_name, student_no
                                     from academy_b
                                     where student_no = 1003 or student_no = 1004);
                                     
-- 뷰
create or replace view academy_all as
select student_no from academy_a;

select * from academy_all where student_name = '김연아';

create or replace view academy_student_name as
select student_name from academy_a;

select * from academy_student_name;

create or replace view academy_join as
select t1.student_name, t1.student_no
from academy_a t1, academy_b t2
where t1.student_no = t2.student_no;

select * from academy_join;

drop view academy_join;

-- 순위 함수
select student_name, score, rank() over(order by score desc)
from student_grade;

select student_name, score, dense_rank() over(order by score desc)
from student_grade;

select student_name, score, row_number() over(order by score desc)
from student_grade;

-- 합계
select type, sum(price)as sum
from gift
group by type;

select type, sum(price) over(partition by type) as sum
from gift;

-- 시퀀스
create sequence emp_seq
    INCREMENT BY 1 -- 1씩 증가 시킴
    START WITH 1 -- 시작값
    MINVALUE 1 -- 최소값
    MAXVALUE 9999 -- 최대값
    NOCYCLE
    NOCACHE
    NOORDER;
    
select emp_seq.nextval from dual; -- 증가
select emp_seq.currval from dual; -- 현재값 조회

insert into emp values(emp_seq.nextval, '둘리', 10);
insert into emp values(emp_seq.nextval, '또치', 10);
insert into emp values(emp_seq.nextval, '고길동', 10);

select * from emp;

drop table dept cascade constraints;

alter SEQUENCE emp_seq INCREMENT BY 2;
alter SEQUENCE emp_seq MAXVALUE 999999;

drop SEQUENCE emp_seq;

alter SEQUENCE emp_seq INCREMENT BY 4; -- 증가값 4로 변경
select emp_seq.nextval from dual; -- 증가 10이 된다.
alter SEQUENCE emp_seq INCREMENT BY 1; -- 증가값 1씩 되도록 변경





