--mysql
CREATE DATABASE IF NOT EXISTS `appdb`

USE appdb;

CREATE TABLE IF NOT EXISTS users (
	id smallint UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    name varchar(12) NOT NULL UNIQUE,
    pass varchar(12) NOT NULL,
    role varchar(12) NOT NULL,
	active tinyint(1) UNSIGNED,
    fullname varchar(24)
);

CREATE TABLE IF NOT EXISTS customers (
	id smallint UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    name varchar(24) NOT NULL UNIQUE,
    zip smallint UNSIGNED,
    city varchar(24),
    address varchar(24)
);

CREATE TABLE IF NOT EXISTS activities (
	id int UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    users_id smallint UNSIGNED NOT NULL,
    customers_id smallint UNSIGNED NOT NULL,
    start datetime,
    stop datetime,
    comment varchar(100),
	CONSTRAINT `fk_activites_users`
	FOREIGN KEY (users_id) REFERENCES users (id)
	ON DELETE RESTRICT ON UPDATE CASCADE,
	CONSTRAINT `fk_activites_customers`
	FOREIGN KEY (customers_id) REFERENCES customers (id)
	ON DELETE RESTRICT ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS `version` (`version` varchar(24));

insert into version values ('20180701 teszt');

insert into appdb.users values (null,'Zoli','pass','user', 1, 'Szabó Zoltán');
insert into appdb.users values (null,'Admin','pass','admin', 1, 'Szabó Zoltán admin');

insert into appdb.customers values (null,'Csodás Gasztro Kft.',1111,'Budapest','Kicsi utca 1.');
insert into appdb.customers values (null,'Nagy Ügyvédi Iroda',2222,'Budapest','Nagy utca 1.');
insert into appdb.customers values (null,'Kis cukrászda',3333,'Budapest','Kis utca 1.');
insert into appdb.customers values (null,'Kocsma az it-sokhoz',4444,'Budapest','Google utca 1.');
insert into appdb.customers values (null,'Privát nyomda',5555,'Budapest','Privát utca 1.');

--fk teszt
--insert into appdb.activities (id, users_id, customers_id) values (null, 1, 1);
--delete from appdb.users where id = 1;
--update appdb.users set id = 100 where id = 1;

select * from appdb.users;
select * from appdb.customers;
select * from appdb.activities;

--delete from appdb.users;
--delete from appdb.customers;
--delete from appdb.activities;

--truncate table users;
--truncate table customers;
--truncate table activities;
