select * from test1;

show databases;

show tables;

/* 테이블 생성 */
create table test1 (
	name varchar(20) not null,
	age int default 20,
	birthday datetime now(),
	job char(6),
	gender char(2) default '여자',
	address varchar(10) default '서울'
);


/* 테이블 구조보기 */
desc test1;

create table busan (
	idx int not null auto_increment,/* idx 자동증가 설정 */
	name varchar(20) not null,
    age int,
    primary key(idx)
);

insert into busan (name, age) values ('홍길동',30);
insert into busan values (default,'김말숙',20);
insert into busan values (default,'이기자',40);
insert into busan values (default,'오나라',65);
insert into busan values (default,'김연아',34);
insert into busan values (default,'감강찬',28);
insert into busan values (default,'소나무',67);
insert into busan values (default,'이하늘',11);
insert into busan values (default,'대나무',15);
insert into busan values (default,'감나무',45);
insert into busan values (default,'고인돌',23);

select *from busan;

/* 필드추가(add column) */
alter table busan add column job char(10);
desc busan;

/* 필드 속성변경(modify) */
alter table busan modify column job char(15); 

/* 필드명 변경(change column) */
alter table busan change column job work varchar(20);

/* 필드 삭제(drop colomn) */
alter table busan drop column work;
desc busan;

select * from test1;

/* test1 테이블에 성별필드(gender(char(2))default '여자')추가 */
alter table test1 add column gender char(2) default '여자';
alter table test1 add column address varchar(10) default '서울';

insert into test1 values('아톰', default, default, '', default, '서울');
insert into test1 values('비톰', 37, '1987-11-14', '회사원', '남자', '삼척');
insert into test1 values('씨톰', 14, '2010-7-24', '학생', default, '울산');
insert into test1 values('디톰', 27, '2002-3-7', '학생', '남자', '포항');
insert into test1 values('이톰', 32, '1993-8-30', '', default, '거제');
insert into test1 values('홍길순', 32, '1993-8-30', '', default, '청주');
insert into test1 values('홍나순', 32, '1993-8-30', '', default, '청주');

/* 데이터찾기 */
select * from test1 where name = '홍길동';
select * from test1 where name = '홍길';
select * from test1 where gender = '여자';
select * from test1 where age < 30; /* 30 아래 */
select * from test1 where age >= 30 and age < 40; /* 30대만 출력 */
select * from test1 where address = '서울';
select * from test1 where job = '회사원';
select * from test1 where job = '회사원' or job = '장군';
select * from test1 where job = '장군' and age < 30;
select * from test1 where gender = '여자';
select * from test1 where gender = '여자' and address = '서울';
select * from test1 where birthday < '2000-1-1';
select * from test1 where birthday >= '2025-1-1' and birthday <= '2025-12-31';
select * from test1 where job='회사원' and gender='남자';
select * from test1 where name like '홍%'; /* 홍씨 찾기 */
select * from test1 where name like '%톰'; /* 톰자돌림 찾기 */
select distinct * from test1 where name like '%톰'; /* 중복걸러 보여주기 */