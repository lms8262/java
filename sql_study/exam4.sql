create table stores (
    store_id number primary key,
    store_name varchar2(100) not null,
    phone varchar2(100) not null,
    address varchar2(255) not null
);

create table customers (
    customer_id number primary key,
    name varchar2(100) not null,
    phone varchar2(100) not null,
    address varchar2(255) not null
);

create table orders (
    order_id number primary key,
    customer_id number not null,
    store_id number not null,
    status number not null,
    order_date date not null,
    CONSTRAINT FK_customer_id FOREIGN KEY(customer_id) REFERENCES customers(customer_id),
    CONSTRAINT FK_store_id FOREIGN KEY(store_id) REFERENCES stores(store_id)
);

create table order_items (
    item_id number primary key,
    order_id number not null,
    item_name varchar2(100) not null,
    price number not null,
    quantity number not null,
    CONSTRAINT FK_order_id FOREIGN KEY(order_id) REFERENCES orders(order_id)
);

insert into stores values(101, '완미족발', '02-142-9933', '서울 강남구 강남대로118길');
insert into stores values(102, '만구기네화로불닭발', '02-540-1974', '서울 강남구 강남대로122길 30');
insert into stores values(103, 'BBQ치킨', '02-142-0978', '서울 서초구 강남대로79길 48 1층');
insert into stores values(104, '금강바베큐', '02-511-0976', '서울 서초구 사평대로 349 서초빌딩');

insert into customers values(10, '이지은', '010-2222-3333', '서울 서초구 서초대로77길 55 에이프로스퀘어 3층');
insert into customers values(20, '유재석', '010-3333-3333', '서울 서초구 서초대로77길 55 에이프로스퀘어 2층');
insert into customers values(30, '하하', '010-4444-4444', '서울 서초구 서초대로77길 55 에이프로스퀘어 1층');

create SEQUENCE orders_seq
    increment by 1
    start with 1
    minvalue 1
    maxvalue 9999
    nocycle
    nocache
    noorder;

create SEQUENCE order_items_seq
    increment by 1
    start with 1
    minvalue 1
    maxvalue 9999
    nocycle
    nocache
    noorder;

select * from stores;
select * from customers;

insert into orders values(orders_seq.nextval, 10, 101, 0, to_date('2016-09-01-151212', 'YYYY-MM-DD-HH24MISS'));
insert into orders values(orders_seq.nextval, 20, 102, 0, to_date('2016-09-02-151212', 'YYYY-MM-DD-HH24MISS'));
insert into orders values(orders_seq.nextval, 20, 103, 0, to_date('2016-09-03-151212', 'YYYY-MM-DD-HH24MISS'));
insert into orders values(orders_seq.nextval, 30, 104, 0, to_date('2016-09-04-151212', 'YYYY-MM-DD-HH24MISS'));
insert into orders values(orders_seq.nextval, 30, 101, 0, to_date('2016-09-05-151212', 'YYYY-MM-DD-HH24MISS'));

select * from orders;

insert into order_items values(order_items_seq.nextval, 1, '불족발', 35000, 1);
insert into order_items values(order_items_seq.nextval, 2, '불닭발', 28000, 1);
insert into order_items values(order_items_seq.nextval, 3, '황금올리브', 28000, 1);
insert into order_items values(order_items_seq.nextval, 4, '바베큐', 48000, 1);
insert into order_items values(order_items_seq.nextval, 5, '불족발', 48000, 1);

select * from order_items;

select *
from orders
where order_date >= '2016-09-03';

select store_id, count(order_id) as count
from orders
group by store_id
having count(store_id) = 1;

select *
from orders
where store_id = (select store_id
                  from stores
                  where store_name = '완미족발');
                  
select *
from order_items
where order_id = (select o.order_id
                  from customers c, orders o
                  where c.customer_id = o.customer_id
                  and c.name = '이지은');
                  
create or replace view order_items_list
as (select item_name
    from order_items
    where price >= 40000);
    
select * from order_items_list;

drop table order_items;







