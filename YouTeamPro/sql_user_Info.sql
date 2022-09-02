
create table user_Info
(
id varchar2(10),
pw varchar2(10) not null,
nick varchar2(10) not null,
score number(5) ,
grade varchar2(5) ,
times number(10) ,
constraint user_Info_id_pk primary key(id),
constraint user_Info_nick_uk unique(nick),
constraint user_Info_grade_ck check(grade in('1티어','2티어','3티어'))
);

select * from user_info;
insert into user_Info(id, pw, nick) values ('ddd','dddd','ddd');

create table game
(
word varchar2(20),
type varchar2(10) not null,
difficulty varchar2(10)not null,
constraint game_word_pk primary key(word)
);

insert into game
values('Brazil', 'country', 'easy');
insert into game
values('Canada', 'country', 'easy');
insert into game
values('France', 'country', 'easy');
insert into game
values('Turkey', 'country', 'easy');
insert into game
values('Germany', 'country', 'easy');
insert into game
values('India', 'country', 'easy');
insert into game
values('Italy', 'country', 'easy');
insert into game
values('Swiss', 'country', 'easy');
insert into game
values('Senegal', 'country', 'easy');
insert into game
values('Mexico', 'country', 'easy');

insert into game
values('whale', 'animal', 'easy');
insert into game
values('koala', 'animal', 'easy');
insert into game
values('deer', 'animal', 'easy');
insert into game
values('fox', 'animal', 'easy');
insert into game
values('eagle', 'animal', 'easy');
insert into game
values('frog', 'animal', 'easy');
insert into game
values('bat', 'animal', 'easy');
insert into game
values('monkey', 'animal', 'easy');
insert into game
values('camel', 'animal', 'easy');
insert into game
values('panda', 'animal', 'easy');

insert into game
values('GUUCCI', 'brand', 'normal');
insert into game
values('PRADA', 'brand', 'normal');
insert into game
values('discovery', 'brand', 'normal');
insert into game
values('audi', 'brand', 'normal');
insert into game
values('maserati', 'brand', 'normal');
insert into game
values('bentley', 'brand', 'normal');
insert into game
values('nivea', 'brand', 'normal');
insert into game
values('mediheal', 'brand', 'normal');
insert into game
values('innisfree', 'brand', 'normal');
insert into game
values('Tesla', 'brand', 'normal');

insert into game
values('coffee', 'food','normal');
insert into game
values('shrimp', 'food', 'normal');
insert into game
values('cucumber', 'food', 'normal');
insert into game
values('salmon', 'food', 'normal');
insert into game
values('toast', 'food', 'normal');
insert into game
values('sandwich', 'food', 'normal');
insert into game
values('popcorn', 'food', 'normal');
insert into game
values('watermelon', 'food', 'normal');
insert into game
values('pasta', 'food', 'normal');
insert into game
values('avocado', 'food', 'normal');

insert into game
values('DaOn', 'name', 'hard');
insert into game
values('KiCheol', 'name', 'hard');
insert into game
values('DaeRyun', 'name', 'hard');
insert into game
values('DaeHyun', 'name', 'hard');
insert into game
values('JunYeong', 'name', 'hard');
insert into game
values('HyeonJae', 'name', 'hard');
insert into game
values('KangMin', 'name', 'hard');
insert into game
values('KangWoo', 'name', 'hard');
insert into game
values('yoohyeon', 'name', 'hard');
insert into game
values('MinJin', 'name', 'hard');
insert into game
values('SuMin', 'name', 'hard');
insert into game
values('Chanho', 'name', 'hard');
insert into game
values('EunYu', 'name', 'hard');
insert into game
values('Eunkyung', 'name', 'hard');
insert into game
values('JeongMin', 'name', 'hard');
insert into game
values('JinGeun', 'name', 'hard');
insert into game
values('HyeonJun', 'name', 'hard');
insert into game
values('SiOn', 'name', 'hard');
insert into game
values('TaeYun', 'name', 'hard');
insert into game
values('HanSeong', 'name', 'hard');
insert into game
values('Chanik', 'name', 'hard');
insert into game
values('ARa', 'name', 'hard');
insert into game
values('JiEun', 'name', 'hard');
insert into game
values('JinYeong', 'name', 'hard');
insert into game
values('Seyeon', 'name', 'hard');
commit;

commit;

select * from game where type = 'brand';
select * from(
select * from game where type = 'animal'
order by DBMS_RANDOM.RANDOM
) where rownum < 2
drop table user_info cascade constraints
drop table game cascade constraints
select * from game;
update user_Info set score = 200 ,times = 100 where id = 1;
