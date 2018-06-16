--derby
CREATE TABLE APP.USERS
("USER" VARCHAR(25) NOT NULL,
PASSWORD VARCHAR(25) NOT NULL,
PRIMARY KEY ("USER"))

insert into app.USERS values ('valami','semmi');

select * from app.USERS;

--mysql
USE appDB;
CREATE TABLE USERS (
    User varchar(12) NOT NULL,
    Password varchar(12) NOT NULL,
    PRIMARY KEY (User)
);

insert into appDB.USERS values ('valami','semmi');

select * from appDB.USERS;