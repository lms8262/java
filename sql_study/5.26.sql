-- ��Į�� ��������: select���� ���������� �´�
select t1.student_no,
        (select t2.student_name
        from academy_b t2
        where t2.student_no = t1.student_no) as name
from academy_a t1;

-- �ζ��� ��: from���� ���������� �´�.
select t1.student_no, t2.student_name
from academy_a t1,
    (select student_no, student_name from academy_b) t2
where t1.student_no = t2.student_no;

-- ��ø ��������
-- �񿬰� ��������: ���������� ���踦 �ΰ� ���� �ʴ�.
select * 
from academy_a
where student_name = (select student_name from academy_b where student_no = 1003);

--���� ��������: ���������� ���踦 �ΰ� �ִ�.
select student_no
from academy_a t1
where student_name = (select t2.student_name
                      from academy_b t2
                      where t2.student_no = t1.student_no);

-- ������ ��������: �� �ϳ��� ��ȯ
select *
from academy_a
where student_name = (select student_name
                      from academy_b
                      where student_no = 1003);
                      
-- ������ ��������: �������� �����͸� ��ȯ(�������������� �ƴѵ� �������� ��ȯ�� ��� in�� ����Ѵ�.)
select *
from academy_a
where student_name in (select student_name
                      from academy_b
                      where student_no = 1003 or student_no = 1004);

-- ���� �÷� ��������: ���������� �������� �÷� ��ȯ
select *
from academy_a
where (student_name, student_no) in (select student_name, student_no
                                     from academy_b
                                     where student_no = 1003 or student_no = 1004);
                                     
-- ��
create or replace view academy_all as
select student_no from academy_a;

select * from academy_all where student_name = '�迬��';

create or replace view academy_student_name as
select student_name from academy_a;

select * from academy_student_name;

create or replace view academy_join as
select t1.student_name, t1.student_no
from academy_a t1, academy_b t2
where t1.student_no = t2.student_no;

select * from academy_join;

drop view academy_join;

-- ���� �Լ�
select student_name, score, rank() over(order by score desc)
from student_grade;

select student_name, score, dense_rank() over(order by score desc)
from student_grade;

select student_name, score, row_number() over(order by score desc)
from student_grade;

-- �հ�
select type, sum(price)as sum
from gift
group by type;

select type, sum(price) over(partition by type) as sum
from gift;

-- ������
create sequence emp_seq
    INCREMENT BY 1 -- 1�� ���� ��Ŵ
    START WITH 1 -- ���۰�
    MINVALUE 1 -- �ּҰ�
    MAXVALUE 9999 -- �ִ밪
    NOCYCLE
    NOCACHE
    NOORDER;
    
select emp_seq.nextval from dual; -- ����
select emp_seq.currval from dual; -- ���簪 ��ȸ

insert into emp values(emp_seq.nextval, '�Ѹ�', 10);
insert into emp values(emp_seq.nextval, '��ġ', 10);
insert into emp values(emp_seq.nextval, '��浿', 10);

select * from emp;

drop table dept cascade constraints;

alter SEQUENCE emp_seq INCREMENT BY 2;
alter SEQUENCE emp_seq MAXVALUE 999999;

drop SEQUENCE emp_seq;

alter SEQUENCE emp_seq INCREMENT BY 4; -- ������ 4�� ����
select emp_seq.nextval from dual; -- ���� 10�� �ȴ�.
alter SEQUENCE emp_seq INCREMENT BY 1; -- ������ 1�� �ǵ��� ����





