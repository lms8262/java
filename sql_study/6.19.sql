-- num �÷����� ���� ū ���� ���ϴ� ������
select nvl(max(num), 0) from board;

rollback;
truncate table board;
commit;

insert into board values(1, '�ϼ�', '1111', 'haseo@naver.com', '����', '����', '111', 10, sysdate);
insert into board values(2, '�ϼ�', '1111', 'haseo@naver.com', '����', '����', '111', 10, sysdate);

select * from board;

-- ��ü �Խù��� ���� ���
select nvl(count(*), 0) from board
--where name like '%���%';
--where subject like '%�%';
where content like '%����%';

select num, name, subject, hitCount, to_char(created, 'YYYY-MM-DD') created
from board
where name like '%���%'
order by num desc;

select rownum rnum, data.* from (
select num, name, subject, hitCount, to_char(created, 'YYYY-MM-DD') created
from board
where name like '%���%'
order by num desc
) data;

select * from (
    select rownum rnum, data.* from (
        select num, name, subject, hitCount, to_char(created, 'YYYY-MM-DD') created
        from board
        where subject like '%���%'
        order by num desc
    ) data
)
where rnum >= 1 and rnum <= 5;


