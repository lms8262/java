drop table dept;

create table dept(
    deptno varchar2(100) primary key,
    dept varchar2(100),
    loc varchar2(100)
);

insert into dept values('101', '���ߺ�', '��õ');
insert into dept values('102', 'ȫ����', '����');
insert into dept values('103', '������', '�λ�');

select * from dept;

commit;

drop table student;

create table student(
    name varchar2(100) primary key,
    age varchar2(100),
    java varchar2(100),
    orcle varchar2(100)
);

insert into student values('������', '20', 'A+', 'C');
insert into student values('������', '23', 'B+', 'A');
insert into student values('������', '21', 'F', 'A+');

select * from student;

commit;

