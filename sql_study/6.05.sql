drop table student CASCADE CONSTRAINTS;

create table student (
    id number primary key,
    username varchar2(20),
    univ varchar2(40),
    birth date,
    email varchar2(40)
);

create SEQUENCE id_seq
       INCREMENT BY 1
       START WITH 1
       MINVALUE 1
       MAXVALUE 9999
       NOCYCLE
       NOCACHE
       NOORDER;
       
insert into student values(id_seq.nextval, '박사랑', 'bb대학교', '2000-01-01', 'park@bbuniv.com');
INSERT INTO STUDENT VALUES(id_seq.NEXTVAL, '나최고', 'CC대학교', '1999-10-11', 'na@ccuniv.com');
INSERT INTO STUDENT VALUES(id_seq.NEXTVAL, '김길동', 'BB대학교', '2002-06-14', 'kim@bbuniv.com');
INSERT INTO STUDENT VALUES(id_seq.NEXTVAL, '홍길동', 'AA대학교', '2001-05-22', 'hong@aauniv.com');

select * from student;

commit;