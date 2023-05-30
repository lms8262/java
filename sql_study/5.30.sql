create table sample(
    no number primary key,
    name varchar2(20),
    age number
);

insert into sample values(1, '������', 10);
insert into sample values(2, '�ڿ���', 10);
insert into sample values(3, '������', 10);

select * from sample;

commit;

insert into sample values(4, '������', 10);

commit; -- �߿�. Ŀ���� ���Ŀ��� �ѹ��� ���� �ʴ´�.

rollback;

alter table sample modify age number check(age in(10, 11));

insert into sample values(5, '������', 12);

-- �ʱ�ȭ
drop table emp;

CREATE TABLE EMP (
    NO   NUMBER primary key,
    NAME VARCHAR2(20) not null,
    AGE  NUMBER
);

INSERT INTO EMP (NO, NAME, AGE) VALUES (1, '�Ѹ�', 10);
INSERT INTO EMP (NO, NAME, AGE) VALUES (2, '��ġ', 10);

select * from emp;

create unique index emp_uk on emp(age);
create unique index emp_uk on emp(name);

drop index emp_ix01;

-- ������ ����
SELECT * FROM USER_TABLES;
SELECT * FROM USER_INDEXES;
SELECT * FROM USER_VIEWS;

-- ���ν���
create or replace procedure ex_proc
(in_type in varchar2,
 in_name in varchar2) 
 is
 price number := 10000; -- ���� ����, �� ����
 begin
 insert into gift 
 values(11, in_type, in_name, price);
 commit;
end ex_proc;

exec ex_proc('������ǰ', 'TV');
 


