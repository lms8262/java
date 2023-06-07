drop table board;

create table board (
    board_no number primary key,
    user_id varchar2(50) not null,
    title varchar2(255) not null,
    content clob not null,
    reg_date date not null,
    views number not null,
    img varchar2(255)
);

create SEQUENCE board_seq
       increment by 1
       start with 1
       minvalue 1
       maxvalue 9999
       nocycle
       nocache
       noorder;
       
insert into board values(board_seq.nextval, 'user1', '���޳�', '��¼�� ¼����', sysdate, 0, '/img/����1.jpg');
insert into board values(board_seq.nextval, 'user1', '���� ���� �ѹ��� �ɶ� ��ǥ��', '��¼�� ¼����', sysdate, 0, '/img/����2.jpg');
insert into board values(board_seq.nextval, 'user2', '�ָ�����...', '��¼�� ¼����', sysdate, 0, '/img/����3.jpg');

select * from board;

commit;

select board_no, title, user_id, to_char(reg_date, 'yyyy.mm.dd') reg_date, views
from board;




