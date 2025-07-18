show tables;

create table insa (
	idx int not null auto_increment primary key, /* 고유번호 */
	name varchar(20) not null, /* 성명 */
	age int default 20, /* 나이 */
	gender char(2) default '여자', /* 성별 */
	ipsail datetime default now() /* 입사일 */
);

desc insa;

insert into insa values (default, '홍길동', default, '남자', default);
insert into insa values (default, '김말숙', 30, default, '2020-5-10');
insert into insa (name) values ('오하늘');

select * from insa;
