--mysql
USE appDB;

CREATE TABLE USERS (
	Uid int PRIMARY KEY AUTO_INCREMENT,
    Uname varchar(12) NOT NULL UNIQUE,
    Upass varchar(12) NOT NULL,
    Urole varchar(12) NOT NULL,
    Fullname varchar(24)
);

CREATE TABLE CUSTOMERS (
	Cid int PRIMARY KEY AUTO_INCREMENT,
    Cname varchar(24) NOT NULL UNIQUE,
    Czip int,
    Ccity varchar(24),
    Caddress varchar(24)
);

CREATE TABLE ACTIVITIES (
	Aid int PRIMARY KEY AUTO_INCREMENT,
    Uid int,
    Cid int,
    Start datetime,
    Stop datetime,
    Comment varchar(100)
);

insert into appDB.USERS values (null,'Zoli','pass','employee','Szabó Zoltán');
insert into appDB.USERS values (null,'Ali','pass','admin','Mézga Aladár');

insert into appDB.CUSTOMERS values (null,'Csodás Gasztro Kft.',1111,'Budapest','Kicsi utca 1.');
insert into appDB.CUSTOMERS values (null,'Nagy Ügyvédi Iroda',2222,'Budapest','Nagy utca 1.');
insert into appDB.CUSTOMERS values (null,'Kis cukrászda',3333,'Budapest','Kis utca 1.');
insert into appDB.CUSTOMERS values (null,'Kocsma az it-sokhoz',4444,'Budapest','Google utca 1.');
insert into appDB.CUSTOMERS values (null,'Privát nyomda',5555,'Budapest','Privát utca 1.');

select * from appDB.USERS;
select * from appDB.CUSTOMERS;
select * from appDB.ACTIVITIES;

--truncate table USERS;
--truncate table CUSTOMERS;