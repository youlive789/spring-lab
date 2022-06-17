create table book (
    id identity not null primary key,
    name varchar(20) not null,
    page_size bigint not null
);

insert into book (name, page_size) values ('test1', 1);
insert into book (name, page_size) values ('test2', 1);
insert into book (name, page_size) values ('test3', 1);
insert into book (name, page_size) values ('test4', 1);
insert into book (name, page_size) values ('test5', 1);
insert into book (name, page_size) values ('test6', 1);