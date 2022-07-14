--1. Написать SQL скрипты по созданию таблиц и их заполнением:
create table car_bodies (
    id serial primary key,
    name varchar(100));
    
create table car_engines (
    id serial primary key,
    name varchar(100));    
    
create table car_transmissions (
    id serial primary key,
    name varchar(100));        

create table cars  (
    id serial primary key,
    name varchar(100),
    body_id int references car_bodies(id),
    engine_id int references car_engines(id),
    transmission_id int references car_transmissions(id));

insert into car_bodies(name) values('седан');
insert into car_bodies(name) values('хэтчбек');
insert into car_bodies(name) values('купе');
insert into car_bodies(name) values('джип');

insert into car_engines(name) values('V4');
insert into car_engines(name) values('V6');
insert into car_engines(name) values('V8');

insert into car_transmissions(name) values('АКПП');
insert into car_transmissions(name) values('МКП');
insert into car_transmissions(name) values('Вариатор');
insert into car_transmissions(name) values('Робот');

insert into cars(name, body_id, engine_id, transmission_id) values('Тойота королла', 1, 1, 1);
insert into cars(name, body_id, engine_id, transmission_id) values('Тойота прадо', 4, 2, 2);
insert into cars(name, body_id, engine_id, transmission_id) values('Ауди оллроад', 2, 1, 1);
insert into cars(name, body_id, engine_id, transmission_id) values('Нсссан кашкай', 4, 1, 3);
insert into cars(name, body_id, engine_id) values('Лада приора', 1, 1);
insert into cars(name, body_id) values('Лада калина', 1);
insert into cars(name) values('Лада гранта');

--2. Создать SQL запросы:
-- 1. Вывести список всех машин и все привязанные к ним детали. 
-- Нужно учесть, что каких-то деталей машина может и не содержать. 
-- В таком случае значение может быть null при выводе (например, название двигателя null);
select cars.id as id, 
       cars.name as car_name,
       car_bodies.name as body_name,
       car_engines.name as engine_name,
       car_transmissions.name as transmission_name
from cars 
    left join car_bodies on cars.body_id = car_bodies.id
    left join car_engines on cars.engine_id = car_engines.id
    left join car_transmissions on cars.transmission_id = car_transmissions.id;
    
-- 2. Вывести кузовы, которые не используются НИ в одной машине. 
select car_bodies.name from car_bodies
    left join cars on car_bodies.id = cars.body_id
where cars.id is null;

-- 3. Вывести двигатели, которые не используются НИ в одной машине. 
select car_engines.name from car_engines
    left join cars on car_engines.id = cars.body_id
where cars.id is null;

-- 4. Вывести коробки передач, которые не используются НИ в одной машине. 
select car_transmissions.name from car_transmissions
    left join cars on car_transmissions.id = cars.body_id
where cars.id is null;