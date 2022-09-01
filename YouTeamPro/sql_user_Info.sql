
create table user_Info
(
id varchar2(10),
pw number(10) not null,
nick varchar2(10) not null,
score number(5) not null,
grade varchar2(5) not null,
time varchar2(10) not null,
constraint user_Info_id_pk primary key(id),
constraint user_Info_nick_uk unique(nick),
constraint user_Info_grade_ck check(grade in('1티어','2티어','3티어'))
);

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
values('Da On', 'name', 'hard');
insert into game
values('Ki Cheol', 'name', 'hard');
insert into game
values('Dae Ryun', 'name', 'hard');
insert into game
values('Dae Hyun', 'name', 'hard');
insert into game
values('Jun Yeong', 'name', 'hard');
insert into game
values('Hyeon Jae', 'name', 'hard');
insert into game
values('Kang Min', 'name', 'hard');
insert into game
values('Kang Woo', 'name', 'hard');
insert into game
values('yoohyeon', 'name', 'hard');
insert into game
values('Min Jin', 'name', 'hard');
insert into game
values('Su Min', 'name', 'hard');
insert into game
values('Chanho', 'name', 'hard');
insert into game
values('EunYu', 'name', 'hard');
insert into game
values('Eunkyung', 'name', 'hard');
insert into game
values('Jeong Min', 'name', 'hard');
insert into game
values('Jin Geun', 'name', 'hard');
insert into game
values('Hyeon Jun', 'name', 'hard');
insert into game
values('Si On', 'name', 'hard');
insert into game
values('Tae Yun', 'name', 'hard');
insert into game
values('Han Seong', 'name', 'hard');
insert into game
values('Chanik', 'name', 'hard');
insert into game
values('A Ra', 'name', 'hard');
insert into game
values('Ji Eun', 'name', 'hard');
insert into game
values('Jin Yeong', 'name', 'hard');
insert into game
values('Se yeon', 'name', 'hard');
commit;


select * from game;
select * from(
select * from game where type = 'animal'
order by DBMS_RANDOM.RANDOM
) where rownum < 2

