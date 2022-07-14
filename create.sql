create table rules (
    id serial primary key,
    name varchar(50)
);

create table role (
    id serial primary key,
    name varchar(50)
);

create table role_rules (
    id serial primary key,
    rules_id int references rules(id),
    role_id int references role(id)
);

create table users (
    id serial primary key,
    name varchar(50),
    role_id int references role(id)
);
    
create table state (
    id serial primary key,
    name varchar(50)
);
        
create table category (
    id serial primary key,
    name varchar(50)
);

create table item (
    id serial primary key,
    name varchar(50),
    user_id int references users(id),
    state_id int references state(id),
    category_id int references category(id)
);

create table comments (
    id serial primary key,
    name varchar(100),
    item_id int references item(id)
);

create table attachs (
    id serial primary key,
    name varchar(50),
    item_id int references item(id)
);
    