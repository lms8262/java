select board_no, title, to_char(reg_date, 'yyyy.mm.dd') reg_date, views, content, img
from board
where board_no =1;

update board set views = (views + 1) where board_no = 1;

select * from board;

commit;

insert into board(board_no, user_id, title, content, reg_date, views, img)
values(board_seq.nextval, 'user3', '�׽�Ʈ', '�����Դϴ�', sysdate, 0, '/img/test.jpg');

rollback;

update board set title = '��������', user_id = '����', content = '����', img = '����' where board_no = 1;


