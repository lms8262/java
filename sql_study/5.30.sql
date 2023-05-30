create table sample(
    no number primary key,
    name varchar2(20),
    age number
);

insert into sample values(1, '양지은', 10);
insert into sample values(2, '박우진', 10);
insert into sample values(3, '김태은', 10);

select * from sample;

commit;

insert into sample values(4, '정지우', 10);

commit; -- 중요. 커밋한 이후에는 롤백이 되지 않는다.

rollback;

alter table sample modify age number check(age in(10, 11));

insert into sample values(5, '정지우', 12);

-- 초기화
drop table emp;

CREATE TABLE EMP (
    NO   NUMBER primary key,
    NAME VARCHAR2(20) not null,
    AGE  NUMBER
);

INSERT INTO EMP (NO, NAME, AGE) VALUES (1, '둘리', 10);
INSERT INTO EMP (NO, NAME, AGE) VALUES (2, '또치', 10);

select * from emp;

create unique index emp_uk on emp(age);
create unique index emp_uk on emp(name);

drop index emp_ix01;

-- 데이터 사전
SELECT * FROM USER_TABLES;
SELECT * FROM USER_INDEXES;
SELECT * FROM USER_VIEWS;

-- 프로시저
create or replace procedure ex_proc
(in_type in varchar2,
 in_name in varchar2) 
 is
 price number := 10000; -- 변수 선언, 값 대입
 begin
 insert into gift 
 values(11, in_type, in_name, price);
 commit;
end ex_proc;

exec ex_proc('가전제품', 'TV');
 


