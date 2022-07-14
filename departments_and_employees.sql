--1. Создать таблицы и заполнить их начальными данными
create table departments (
    id serial primary key,
    name varchar(100));
    
create table employees (
    id serial primary key,
    name varchar(100),
    department_id int references departments(id));

insert into departments(name) values('Производственно-технический');
insert into departments(name) values('Отдел продаж');
insert into departments(name) values('ИТ');
insert into departments(name) values('Бухгалтерия');

insert into employees(name, department_id) values('Иванов И.И.', 1);
insert into employees(name, department_id) values('Петров П.П.', 1);
insert into employees(name, department_id) values('Сидоров С.С.', 1);
insert into employees(name, department_id) values('Мышкин М.С.', 3);
insert into employees(name, department_id) values('Котов Е.К.', 3);
insert into employees(name, department_id) values('Собакина Н.П.', 4);
insert into employees(name) values('Птичкин О.Л.');

--2. Выполнить запросы с left, rigth, full, cross соединениями
select * from employees as em left join departments as dep on em.department_id = dep.id;
select * from employees as em right join departments as dep on em.department_id = dep.id;
select * from employees as em full join departments as dep on em.department_id = dep.id;
select * from employees as em cross join departments as dep;

--3. Используя left join найти департаменты, у которых нет работников
select * from departments as dep 
    left join employees as em on dep.id = em.department_id
where em.id is null;

--4. Используя left и right join написать запросы, которые давали бы одинаковый результат 
--(порядок вывода колонок в эти запросах также должен быть идентичный). 
select em.name, em.id, dep.name, dep.id from employees as em left join departments as dep on em.department_id = dep.id;
select em.name, em.id, dep.name, dep.id from departments as dep left join employees as em on dep.id = em.department_id;

--5. Создать таблицу teens с атрибутами name, gender и заполнить ее. Используя cross join составить все возможные разнополые пары
create table teens (
    id serial primary key,
    name varchar(100),
    gender varchar(10));
    
insert into teens(name, gender) values('Иван', 'Мужской');
insert into teens(name, gender) values('Петр', 'Мужской');
insert into teens(name, gender) values('Мария', 'Женский');
insert into teens(name, gender) values('Ольга', 'Женский');

select teens1.name, teens2.name from teens as teens1 cross join teens as teens2 where teens1.gender <> teens2.gender;