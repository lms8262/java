CREATE TABLE DEPT ( -- �μ�
    DEPT_NO NUMBER PRIMARY KEY,
    DEPT_NAME VARCHAR2(20) NOT NULL,
    DEPT_ADDRESS VARCHAR2(100)
);

CREATE TABLE EMP ( -- ���
    EMP_NO NUMBER PRIMARY KEY,
    EMP_NAME VARCHAR2(20) NOT NULL,
    DEPT_NO NUMBER NOT NULL, -- �ܷ�Ű (DEPT ���̺��� DEPT_NO �÷��� �����Ѵ�)
    CONSTRAINT FK_DEPT_NO FOREIGN KEY(DEPT_NO) REFERENCES DEPT(DEPT_NO)
);

INSERT INTO DEPT VALUES(1, '�λ��', NULL);
INSERT INTO DEPT VALUES(2, '������', NULL);
INSERT INTO DEPT VALUES(3, 'ȫ����', NULL);
SELECT * FROM DEPT;

INSERT INTO EMP VALUES(1001, '����ȭ', 3);
INSERT INTO EMP VALUES(1002, '����', 1);
INSERT INTO EMP VALUES(1003, '���', 2);
INSERT INTO EMP VALUES(1004, '�迬��', 4);

SELECT * FROM EMP;

DROP TABLE EMP; -- �ڽ� ���̺�
DROP TABLE DEPT; -- �θ� ���̺�

DROP TABLE DEPT CASCADE CONSTRAINTS;
DROP TABLE EMP CASCADE CONSTRAINTS;

-- �⺻Ű�� �ܷ�Ű QUIZ
CREATE TABLE CLASS(
    CLASS_NO NUMBER PRIMARY KEY,
    CLASS_NAME VARCHAR2(20) NOT NULL
);
INSERT INTO CLASS VALUES(1001, '����');
INSERT INTO CLASS VALUES(1002, '����');
SELECT * FROM CLASS;

CREATE TABLE STUDENT(
    STUDENT_NO NUMBER PRIMARY KEY,
    STUDENT_NAME VARCHAR2(20) NOT NULL
);
INSERT INTO STUDENT VALUES(2001, '����ȭ');
INSERT INTO STUDENT VALUES(2002, '����');
INSERT INTO STUDENT VALUES(2003, '���');
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
INSERT INTO ACADEMY_A VALUES(1001, '����ȭ');
INSERT INTO ACADEMY_A VALUES(1002, '����');
INSERT INTO ACADEMY_A VALUES(1003, '���');
INSERT INTO ACADEMY_A VALUES(1004, '�迬��');

CREATE TABLE ACADEMY_B (
    STUDENT_NO NUMBER PRIMARY KEY,
    STUDNET_NAME VARCHAR2(20) NOT NULL
);
INSERT INTO ACADEMY_B VALUES(1003, '���');
INSERT INTO ACADEMY_B VALUES(1004, '�迬��');
INSERT INTO ACADEMY_B VALUES(1005, '����ȯ');
INSERT INTO ACADEMY_B VALUES(1006, '������');

SELECT * FROM ACADEMY_A;
SELECT * FROM ACADEMY_B;

-- equi ����: �� ���̺��� �÷��� ���� ��ġ�Ǵ� ���� ����
SELECT t1.student_no, t1.studnet_name
FROM academy_a T1, academy_b T2
WHERE t1.student_no = t2.student_no;

-- non-equi ����: =�� �ƴѰ� ���
SELECT *
FROM academy_a T1, academy_b T2
WHERE t1.student_no >= t2.student_no;

-- inner ����: ������
select *
from academy_a t1
join academy_b t2
on t1.student_no = t2.student_no;

-- left ����: ���� ���̺��� ��� ���ڵ带 �������� ������ ���̺��� ����� �͸� �����´�.
select *
from academy_a t1
left join academy_b t2
on t1.student_no = t2.student_no;

-- right ����: ������ ���̺��� ��� ���ڵ带 �������� ���� ���̺��� ����� �͸� �����´�.
select *
from academy_a t1
right join academy_b t2
on t1.student_no = t2.student_no;

-- outer join: ������
select *
from academy_a t1
full outer join academy_b t2
on t1.student_no = t2.student_no;

-- natural ����
select *
from academy_a t1
natural join academy_b t2;

-- �μ�,���� ���̺� �ʱ�ȭ
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
INSERT INTO DEPT VALUES (1, '�λ��');
INSERT INTO DEPT VALUES (2, '������');
INSERT INTO DEPT VALUES (3, 'ȫ����');
INSERT INTO EMP VALUES (1001, '����ȭ', 3);
INSERT INTO EMP VALUES (1002, '����', 1);
INSERT INTO EMP VALUES (1003, '���', 2);

-- join quiz
-- quiz1 ���1 inner join
select t1.dept_name, t2.emp_name
from dept t1
join emp t2
on t1.dept_no = t2.dept_no;

-- quiz1 ���2 equi join
select t1.dept_name, t2.emp_name
from dept t1, emp t2
where t1.dept_no = t2.dept_no;

-- quiz2 ���1 inner join
select t1.student_no, t2.student_name, t3.class_name
from class_student t1
join student t2
on t1.student_no = t2.student_no
join class t3
on t1.class_no = t3.class_no;

-- quiz2 ���2 equi join
select t1.student_no, t2.student_name, t3.class_name
from class_student t1, student t2, class t3
where t1.student_no = t2.student_no
and t1.class_no = t3.class_no;

-- ���� ������
-- union all: �ߺ��� �����ؼ� ��ȸ
select * from academy_a
union all
select * from academy_b;

-- union: �ߺ��� �����ؼ� ��ȸ
select * from academy_a
union
select * from academy_b;

-- intersect: ����� �κи� �ߺ� �����ؼ� ��ȸ
select * from academy_a
intersect
select * from academy_b;

-- minus: a���̺��� ����� �κ��� ������ b���̺��� �����ϰ� ��ȸ
select * from academy_a
minus
select * from academy_b;

-- having
select type, count(name) as count
from gift
group by type
having count(name) >= 2
order by type;






