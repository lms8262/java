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

insert into book values(book_no_seq.nextval,'스즈메의 문단속', '2023-01-13', '신카이 마코토', '대원씨아이', 360, '규슈의 조용한 마을에서 이모와 함께 살아가는 17살 소녀 스즈메...', '소설', '/img/스즈메의 문단속.jpg');
insert into book values(book_no_seq.nextval,'슬램덩크 챔프', '2023-01-06', '이노우에 타케히코', '대원', 522, '스포츠 만화의 황금기를 가져온 슬램덩크의 명장면, 명대사 등 엑기스만 골라 담아 팬들이 절대로 후회하지 않을 한 권으로 꼽는 슬램덩크 챔프!!', '만화', '/img/슬램덩크 챔프.jpg');
insert into book values(book_no_seq.nextval,'부는 어디서 오는가', '2022-12-24', '월리스 와틀스', '포레스트북스', 180, '100년 동안 단 1%만 알았던 부의 법칙', '자기계발서', '/img/부는 어디서 오는가.jpg');

select * from book;

commit;

-- webapp/img 폴더 안에 이미지 c:/Temp/img 폴더 안으로 옮겨주세요. --

-- 리스트
--select book_no, book_name, category, img
--from book;

-- 만화, 소설, 그 외 리스트
--select book_no, book_name, category, img
--from book
--where category = '만화';

--select book_no, book_name, category, img
--from book
--where category = '소설';

--select book_no, book_name, category, img
--from book
--where category not in('만화', '소설');

-- 상세정보
--select book_no, book_name, to_char(publication_date, 'yyyy-mm-dd') publication_date, author, publisher, page, book_intro, category, img
--from book
--where book_no = 1;

-- 추가
-- insert into book values(book_no_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?);

-- 수정
--update book set book_name = ?, publication_date = ?, author = ?, publisher = ?, page = ?, book_intro = ?, category = ?, img = ?
--where book_no = ?;

-- 삭제
--delete from book where book_no = 2;




