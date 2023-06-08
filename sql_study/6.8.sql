select board_no, title, to_char(reg_date, 'yyyy.mm.dd') reg_date, views, content, img
from board
where board_no =1;

update board set views = (views + 1) where board_no = 1;

select * from board;

commit;

insert into board(board_no, user_id, title, content, reg_date, views, img)
values(board_seq.nextval, 'user3', '테스트', '내용입니다', sysdate, 0, '/img/test.jpg');

rollback;

update board set title = '수정제목', user_id = '수정', content = '수정', img = '수정' where board_no = 1;


