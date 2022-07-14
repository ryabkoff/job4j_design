create table type (
    id serial primary key,
    name varchar(20)
);

create table product (
    id serial primary key,
    name varchar(100),
    expired_date date,
    price float,
    type_id int references type(id)
);

insert into type(name) values('СЫР');
insert into type(name) values('КОЛБАСА');
insert into type(name) values('МОЛОКО');
insert into type(name) values('МОРОЖЕННОЕ');
insert into type(name) values('ХЛЕБ');

insert into product(name, expired_date, price, type_id) values('Сыр плавленный', '2022-12-31', 500, 1);
insert into product(name, expired_date, price, type_id) values('Сыр моцарелла', '2022-09-05', 600, 1);
insert into product(name, expired_date, price, type_id) values('Сыр костромской', '2022-02--02', 400, 1);
insert into product(name, expired_date, price, type_id) values('Финский сервелат', '2022-10-12', 520, 2);
insert into product(name, expired_date, price, type_id) values('Сливочное мороженное', '2022-06-12', 80, 4);
insert into product(name, expired_date, price, type_id) values('Молоко коровье', '2022-07-15', 95, 3);
insert into product(name, expired_date, price, type_id) values('Хлеб пшеничный', '2022-07-18', 40, 5);
insert into product(name, expired_date, price, type_id) values('Хлеб ржаной', '2022-07-20', 35, 5);
insert into product(name, expired_date, price, type_id) values('Хлеб дарницкий', '2022-07-21', 45, 5);
insert into product(name, expired_date, price, type_id) values('Хлеб цельнозерновой', '2022-07-21', 55, 5);
insert into product(name, expired_date, price, type_id) values('Хлеб отрубной', '2022-07-21', 58, 5);
insert into product(name, expired_date, price, type_id) values('Хлеб бездрожжевой', '2022-07-23', 88, 5);
insert into product(name, expired_date, price, type_id) values('Хлеб серый', '2022-07-23', 28, 5);
insert into product(name, expired_date, price, type_id) values('Хлеб формовой', '2022-07-23', 38, 5);
insert into product(name, expired_date, price, type_id) values('Батон', '2022-07-23', 39, 5);
insert into product(name, expired_date, price, type_id) values('Багет', '2022-07-23', 49, 5);
insert into product(name, expired_date, price, type_id) values('Хлеб бородинский', '2022-07-13', 69, 5);

--1. Написать запрос получение всех продуктов с типом "СЫР"
select p.name from product as p
    join type as t on p.type_id = t.id
where t.name = 'СЫР';

--2. Написать запрос получения всех продуктов, у кого в имени есть слово "мороженое"
select p.name from product as p
where p.name like '%мороженное%';

--3. Написать запрос, который выводит все продукты, срок годности которых уже истек
select p.name from product as p
where p.expired_date <= current_date;

--4. Написать запрос, который выводит самый дорогой продукт.
select p.name, p.price from product as p
    where p.price = (select max(p.price) from product as p)

--5. Написать запрос, который выводит для каждого типа количество продуктов к нему принадлежащих.
--В виде имя_типа, количество
select t.name, count(t.id) from product as p
    join type as t on p.type_id = t.id
group by t.id;

--6. Написать запрос получение всех продуктов с типом "СЫР" и "МОЛОКО"
select p.name from product as p
     join type as t on p.type_id = t.id
where t.name = 'СЫР' OR t.name = 'МОЛОКО';

--7. Написать запрос, который выводит тип продуктов, которых осталось меньше 10 штук.
--Под количеством подразумевается количество продуктов определенного типа.
--Например, если есть тип "СЫР" и продукты "Сыр плавленный" и "Сыр моцарелла", которые ему принадлежат,
--то количество продуктов типа "СЫР" будет 2.
select t.name, count(p.id) from product as p
     join type as t on p.type_id = t.id
group by t.id
having count(p.id) < 10;

--8. Вывести все продукты и их тип.
select p.name, t.name from product as p
     join type as t on p.type_id = t.id;