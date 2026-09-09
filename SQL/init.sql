drop database if EXISTS school;
create database school;
use school;

create table student(
sid varchar(3) primary key,
sname varchar(10) not null,
spassword varchar(10) not null,
sright int(1) not null,
sflag int(1) not null
);

create table course(
cid varchar(3) primary key,
cname varchar(10) not null,
cflag int(1) not null
);

/*drop table course;
drop table score;*/
create table score(
sid varchar(3),
cid varchar(3),
score int(3) not null,
scflag int(1) not null,
primary key(sid,cid),
foreign key (sid) references student(sid) on delete restrict on update restrict,
foreign key (cid) references course(cid) on delete restrict on update restrict
);

CREATE TABLE teacher(
tid int not null AUTO_INCREMENT PRIMARY KEY,
tname VARCHAR(20) not null,
tpassword VARCHAR(10) not null,
tright int(1) not null,
tflag int(1) not null
);

CREATE TABLE timeable(
tid int,
cid VARCHAR(3),
classroom VARCHAR(20) not null,
classtime VARCHAR(20) not null,
ttflag int(1) not null,
primary key(tid,cid),
foreign key (tid) references teacher(tid) on delete restrict on update restrict,
foreign key (cid) references course(cid) on delete restrict on update restrict
);

INSERT INTO teacher VALUES(null,'teacherKobe','123',1,0);
INSERT INTO teacher VALUES(null,'teacherLaoda','123',1,0);
INSERT INTO teacher VALUES(null,'teacherZhang','123',1,0);
INSERT INTO teacher VALUES(null,'teacherXu','123',1,0);

INSERT INTO timeable VALUES(1,'c01','鹰郡','星期一1-2',0);
INSERT INTO timeable VALUES(1,'c02','洛杉矶','星期二1-2',0);
INSERT INTO timeable VALUES(2,'c02','恒大玉壶天下','星期三1-2',0);
INSERT INTO timeable VALUES(3,'c03','许家村','星期一1-2',0);

insert into student values ('s00','admin','admin',1,1);
insert into student values ('s01','kobe','kobe',0,1);
insert into student values ('s02','laoda','laoda',0,1);
insert into student values ('s03','bryant','bryant',0,1);
insert into student values ('s04','man','man',0,1);

insert into course values ('c01','JavaWeb',1);
insert into course values ('c02','JavaSE',1);
insert into course values ('c03','JavaEE',1);
insert into course values ('c04','JavaME',1);

insert into score values ('s01','c01',90,1);
insert into score values ('s01','c02',80,1);
insert into score values ('s02','c02',90,1);
insert into score values ('s03','c03',90,1);


create table studenthistroy(
sid varchar(3) primary key,
sname varchar(10) not null,
spassword varchar(10) not null,
sright int(1) not null,
sflag int(1) not null
); 


create table coursehistroy(
cid varchar(3) primary key,
cname varchar(10) not null,
cflag int(1) not null
);

create table scorehistroy(
sid varchar(3),
cid varchar(3),
score int(3) not null,
scflag int(1) not null,
primary key(sid,cid)
);



select * FROM score INNER JOIN student ON score.sid = student.sid INNER JOIN course ON score.cid = course.cid;

SELECT s.sid,s.sname,c.cid,c.cname,sc.score FROM student s INNER JOIN score sc ON s.sid = sc.sid INNER JOIN course c ON sc.cid = c.cid;

/*create VIEW scoreEX AS select * FROM score INNER JOIN student ON score.sid = student.sid INNER JOIN course ON score.cid = course.cid;*/

CREATE VIEW scoreEX AS SELECT s.sid,s.sname,c.cid,c.cname,sc.score FROM student s INNER JOIN score sc ON s.sid = sc.sid INNER JOIN course c ON sc.cid = c.cid;