create table card(
    id serial primary key,
    shelf int,
    cell int);
    
create table authors(
     id serial primary key,
     name varchar(50));

create table books(
    id serial primary key,
    name varchar(255),
    pages int,
    author_id int references authors(id),
    card_id int references card(id) unique);
    
create table books_authors(
     id serial primary key,
     book_id int references books(id),
     author_id int references authors(id));
