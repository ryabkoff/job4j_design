create table devices(
    id serial primary key,
    name varchar(255),
    price float
);

create table people(
    id serial primary key,
    name varchar(255)
);

create table devices_people(
    id serial primary key,
    device_id int references devices(id),
    people_id int references people(id)
);

insert into people(name) values('Иван');
insert into people(name) values('Петр');
insert into people(name) values('Семен');
insert into people(name) values('Степан');
insert into people(name) values('Наташа');

insert into devices(name, price) values('notebook', 1000);
insert into devices(name, price) values('printer', 700);
insert into devices(name, price) values('phone', 100);
insert into devices(name, price) values('monitor', 300);
insert into devices(name, price) values('monitor', 400);

insert into devices_people(device_id, people_id) values(1, 1);
insert into devices_people(device_id, people_id) values(1, 2);
insert into devices_people(device_id, people_id) values(2, 1);
insert into devices_people(device_id, people_id) values(2, 2);
insert into devices_people(device_id, people_id) values(3, 3);
insert into devices_people(device_id, people_id) values(4, 1);
insert into devices_people(device_id, people_id) values(4, 2);
insert into devices_people(device_id, people_id) values(4, 3);

select avg(d.price) from devices as d;
select d.name, avg(d.price) from devices as d group by d.name;
select p.name,
       avg(d.price)
from devices_people as dp
    join people as p on dp.people_id = p.id
    join devices as d on dp.device_id = d.id
group by p.name;

select p.name,
       avg(d.price)
from devices_people as dp
    join people as p on dp.people_id = p.id
    join devices as d on dp.device_id = d.id
group by p.name
having avg(d.price) > 5000;
