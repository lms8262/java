create table book_category(
    category_no number primary key,
    category_name varchar2(50) not null
);

insert into book_category values(100, '만화');
insert into book_category values(200, '소설');
insert into book_category values(300, '기타');

select * from book_category;

drop table book;

create table book(
    book_no number primary key,
    book_name varchar2(255) not null,
    publication_date date,
    author varchar2(100) not null,
    publisher varchar2(100),
    page number,
    book_intro clob not null,
    category_no number not null,
    img varchar2(255) default '/img/no_image.gif' not null,
    CONSTRAINT FK_category_no FOREIGN KEY(category_no) REFERENCES book_category(category_no)
);

select * from book;

commit;


