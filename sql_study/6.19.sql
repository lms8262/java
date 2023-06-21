-- num 컬럼에서 가장 큰 값을 구하는 쿼리문
select nvl(max(num), 0) from board;

rollback;
truncate table board;
commit;

insert into board values(1, '하서', '1111', 'haseo@naver.com', '제목', '내용', '111', 10, sysdate);
insert into board values(2, '하서', '1111', 'haseo@naver.com', '제목', '내용', '111', 10, sysdate);

select * from board;

-- 전체 게시물의 개수 출력
select nvl(count(*), 0) from board
--where name like '%춘식%';
--where subject like '%운동%';
where content like '%여행%';

select num, name, subject, hitCount, to_char(created, 'YYYY-MM-DD') created
from board
where name like '%춘식%'
order by num desc;

select rownum rnum, data.* from (
select num, name, subject, hitCount, to_char(created, 'YYYY-MM-DD') created
from board
where name like '%춘식%'
order by num desc
) data;

select * from (
    select rownum rnum, data.* from (
        select num, name, subject, hitCount, to_char(created, 'YYYY-MM-DD') created
        from board
        where subject like '%춘식%'
        order by num desc
    ) data
)
where rnum >= 1 and rnum <= 5;


