drop table book;

create table book(
    book_no number primary key,
    book_name varchar2(255) not null,
    publication_date date not null,
    author varchar2(100) not null,
    publisher varchar2(100) not null,
    page number not null,
    book_intro clob not null,
    category varchar2(100) not null,
    img varchar2(255)
);

drop SEQUENCE book_no_seq;

create SEQUENCE book_no_seq
    increment by 1
    start with 1
    minvalue 1
    maxvalue 9999
    nocycle
    nocache
    noorder;

insert into book values(book_no_seq.nextval,'������� ���ܼ�', '2023-01-13', '��ī�� ������', '���������', 360, '�Խ��� ������ �������� �̸�� �Բ� ��ư��� 17�� �ҳ� �����...', '�Ҽ�', '/img/������� ���ܼ�.jpg');
insert into book values(book_no_seq.nextval,'������ũ è��', '2023-01-06', '�̳�쿡 Ÿ������', '���', 522, '������ ��ȭ�� Ȳ�ݱ⸦ ������ ������ũ�� �����, ���� �� ���⽺�� ��� ��� �ҵ��� ����� ��ȸ���� ���� �� ������ �Ŵ� ������ũ è��!!', '��ȭ', '/img/������ũ è��.jpg');
insert into book values(book_no_seq.nextval,'�δ� ��� ���°�', '2022-12-24', '������ ��Ʋ��', '������Ʈ�Ͻ�', 180, '100�� ���� �� 1%�� �˾Ҵ� ���� ��Ģ', '�ڱ��߼�', '/img/�δ� ��� ���°�.jpg');

select * from book;

commit;

-- webapp/img ���� �ȿ� �̹��� c:/Temp/img ���� ������ �Ű��ּ���. --

-- ����Ʈ
--select book_no, book_name, category, img
--from book;

-- ��ȭ, �Ҽ�, �� �� ����Ʈ
--select book_no, book_name, category, img
--from book
--where category = '��ȭ';

--select book_no, book_name, category, img
--from book
--where category = '�Ҽ�';

--select book_no, book_name, category, img
--from book
--where category not in('��ȭ', '�Ҽ�');

-- ������
--select book_no, book_name, to_char(publication_date, 'yyyy-mm-dd') publication_date, author, publisher, page, book_intro, category, img
--from book
--where book_no = 1;

-- �߰�
-- insert into book values(book_no_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?);

-- ����
--update book set book_name = ?, publication_date = ?, author = ?, publisher = ?, page = ?, book_intro = ?, category = ?, img = ?
--where book_no = ?;

-- ����
--delete from book where book_no = 2;




