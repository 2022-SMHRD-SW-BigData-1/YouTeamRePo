create table user_Info
(
id varchar2(10),
pw varchar2(10) not null,
nick varchar2(10) not null,
score number(5) ,
grade varchar2(5) ,
time varchar2(10) ,
constraint user_Info_id_pk primary key(id),
constraint user_Info_nick_uk unique(nick),
constraint user_Info_grade_ck check(grade in('1티어','2티어','3티어'))
);

commit;

insert into user_Info(id, pw, nick) values ('ddd','dddd','ddd');

select * from user_info;