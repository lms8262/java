select * from board;

-- 조회수 늘리기
update board set hitCount = hitCount +1 where num = 1;

-- 조회
select * from board where num = 1;

update board set name='하서', pwd='11', email='haseo@haseo.com', subject='제목', content='내용' where num = 7;

delete board where num = 7;

rollback;
commit; 