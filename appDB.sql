CREATE TABLE APP.USERS
("USER" VARCHAR(25) NOT NULL,
PASSWORD VARCHAR(25) NOT NULL,
PRIMARY KEY ("USER"))

insert into app.USERS values ('valami','semmi');

select * from app.USERS;