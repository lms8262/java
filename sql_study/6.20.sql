select * from board;

-- ��ȸ�� �ø���
update board set hitCount = hitCount +1 where num = 1;

-- ��ȸ
select * from board where num = 1;

update board set name='�ϼ�', pwd='11', email='haseo@haseo.com', subject='����', content='����' where num = 7;

delete board where num = 7;

rollback;
commit; 