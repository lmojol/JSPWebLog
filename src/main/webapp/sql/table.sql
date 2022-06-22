create table board(
bno varchar2(10),
bsubj varchar2(200),
bwriter varchar2(50),
bmemo varchar2(500),
bdate date,
bcnt number);

select * from board;

-------------------------

create table notices(
seq varchar2(200),
title varchar2(50),
writer varchar2(300),
content varchar2(300),
regdate DATE,
hit number);

select * from notices;

---------------------

create table nmember(
id varchar2(50),
pwd varchar2(50),
name varchar2(50),
gender varchar2(10),
birth varchar2(10),
is_lunar varchar2(10),
cphone varchar2(15),
email varchar2(50),
habit varchar2(20),
regdate date);

select * from nmember;