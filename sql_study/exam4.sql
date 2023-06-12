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

insert into stores values(101, '�Ϲ�����', '02-142-9933', '���� ������ �������118��');
insert into stores values(102, '�������ȭ�κҴ߹�', '02-540-1974', '���� ������ �������122�� 30');
insert into stores values(103, 'BBQġŲ', '02-142-0978', '���� ���ʱ� �������79�� 48 1��');
insert into stores values(104, '�ݰ��ٺ�ť', '02-511-0976', '���� ���ʱ� ������ 349 ���ʺ���');

insert into customers values(10, '������', '010-2222-3333', '���� ���ʱ� ���ʴ��77�� 55 �������ν����� 3��');
insert into customers values(20, '���缮', '010-3333-3333', '���� ���ʱ� ���ʴ��77�� 55 �������ν����� 2��');
insert into customers values(30, '����', '010-4444-4444', '���� ���ʱ� ���ʴ��77�� 55 �������ν����� 1��');

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

insert into order_items values(order_items_seq.nextval, 1, '������', 35000, 1);
insert into order_items values(order_items_seq.nextval, 2, '�Ҵ߹�', 28000, 1);
insert into order_items values(order_items_seq.nextval, 3, 'Ȳ�ݿø���', 28000, 1);
insert into order_items values(order_items_seq.nextval, 4, '�ٺ�ť', 48000, 1);
insert into order_items values(order_items_seq.nextval, 5, '������', 48000, 1);

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
                  where store_name = '�Ϲ�����');
                  
select *
from order_items
where order_id = (select o.order_id
                  from customers c, orders o
                  where c.customer_id = o.customer_id
                  and c.name = '������');
                  
create or replace view order_items_list
as (select item_name
    from order_items
    where price >= 40000);
    
select * from order_items_list;

drop table order_items;







