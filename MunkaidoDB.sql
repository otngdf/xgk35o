
CREATE DATABASE IF NOT EXISTS `MunkaidoDB`;

USE MunkaidoDB;

CREATE TABLE IF NOT EXISTS users (
	id smallint UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    name varchar(12) NOT NULL UNIQUE,
    pass char(128) NOT NULL,
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

alter table customers
add COLUMN `username` varchar(12) NOT NULL,
add COLUMN `pass` char(128) NOT NULL;
ALTER TABLE `customers` DROP INDEX `name`;
ALTER TABLE `customers` ADD UNIQUE `name`(`name`, `username`);

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

insert into version values ('20210520 final');

insert into users values (null,'Zoli', SHA2('pass',512), 'user', 1, 'Szabó Zoltán');
insert into users values (null,'Admin', SHA2('pass',512), 'admin', 1, 'Szabó Zoltán admin');

insert into customers values (null,'Csodás Gasztro Kft.',1111,'Budapest','Kicsi utca 1.', 'csoda', SHA2('pass',512));
insert into customers values (null,'Nagy Ügyvédi Iroda',2222,'Budapest','Nagy utca 1.', 'nagy', SHA2('pass',512));
insert into customers values (null,'Kis cukrászda',3333,'Budapest','Kis utca 1.', 'kis', SHA2('pass',512));
insert into customers values (null,'Kocsma az it-sokhoz',4444,'Budapest','Google utca 1.', 'kocsma', SHA2('pass',512));
insert into customers values (null,'Privát nyomda',5555,'Budapest','Privát utca 1.', 'nyomda', SHA2('pass',512));

insert into activities values	(null, 1, 1, '2021-03-01 12:00:00', '2021-03-01 15:00:00', 'Teszt munka');

COMMIT;