create table regist (
    id number primary key,
    name varchar2(20),
    address varchar2(50),
    grade varchar2(20),
    phone varchar2(50)
);

create sequence re_seq
    increment by 1
    start with 101
    minvalue 101
    maxvalue 9999
    nocycle
    nocache
    noorder;

insert into regist values(re_seq.nextval, '������', '�����', 'silver', '010-1111-1111');
insert into regist values(re_seq.nextval, 'ȫ�浿', '��õ��', 'gold', '010-2222-2222');
insert into regist values(re_seq.nextval, '����', '������', 'vip', '010-3333-3333');

select * from regist;

select * from regist where id=101;
commit;

