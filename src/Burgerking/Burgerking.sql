show tables;

create table burgerking (
	idx int not null auto_increment primary key, 
	kind int not null,
	name varchar(20) not null,
	info varchar(50),
	kcal int not null default 500
);

desc burgerking;

insert into burgerking values (default, 1, '치즈와퍼', '', default);
insert into burgerking values (default, 1, '불고기와퍼', '', default);
insert into burgerking values (default, 1, '콰트로치즈와퍼', '', default);
insert into burgerking values (default, 1, '할라피뇨와퍼', '', default);
insert into burgerking values (default, 1, '크리스퍼치폴레와퍼', '', default);
insert into burgerking values (default, 1, '마늘와퍼', '', default);
insert into burgerking values (default, 1, '메이플갈릭와퍼', '', default);
insert into burgerking values (default, 1, '불끈와퍼', '', default);
insert into burgerking values (default, 1, '몬스터와퍼', '', default);
insert into burgerking values (default, 1, '베이컨치즈와퍼', '', default);
insert into burgerking values (default, 1, '불끈와퍼', '', default);
insert into burgerking values (default, 1, '몬스터와퍼', '', default);
insert into burgerking values (default, 1, '베이컨치즈와퍼', '', default);

insert into burgerking values (default, 2, '텐더', '', default);
insert into burgerking values (default, 2, '치킨랩', '', default);
insert into burgerking values (default, 2, '너겟', '', default);
insert into burgerking values (default, 2, '감자튀김', '', default);
insert into burgerking values (default, 2, '쉐이킹쉑', '', default);

insert into burgerking values (default, 3, '콜라', '', default);
insert into burgerking values (default, 3, '사이다', '', default);
insert into burgerking values (default, 3, '탄산수', '', default);
insert into burgerking values (default, 3, '물', '', default);


select * from burgerking;
