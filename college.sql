create table groups (
     id serial primary key,
     name varchar(20),
     year_admission int,
     teacher varchar(100)
);

create table students (
    id serial primary key,
    name varchar(100),
    birthdate date,
    groups_id int references groups(id)
);

insert into groups(name, year_admission, teacher) values ('АВН-20', 2020, 'Егорова Н.Н.');
insert into groups(name, year_admission, teacher) values ('СМ-20', 2020, 'Горохов В.А.');
insert into groups(name, year_admission, teacher) values ('АТ-22', 2022, 'Хрусталев Ю.П.');
insert into groups(name, year_admission, teacher) values ('СК-22', 2022, 'Черкашин В.Д.');

insert into students(name, birthdate, groups_id) values ('Иванов Иван', '2000-02-03', 1);
insert into students(name, birthdate, groups_id) values ('Соколова Света', '2002-01-24', 1);
insert into students(name, birthdate, groups_id) values ('Петров Петр', '2002-11-24', 3);

select 
st.name as "ФИО",
gr.name as "Группа"
from students as st join groups as gr on st.groups_id = gr.id;

select 
st.name as "ФИО",
gr.year_admission as "Год поступления"
from students as st join groups as gr on st.groups_id = gr.id;

select 
st.name as "ФИО",
gr.teacher as "Преподаватель"
from students as st join groups as gr on st.groups_id = gr.id

