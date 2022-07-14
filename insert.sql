insert into role (name) values('admin');
insert into rules (name) values('full');
insert into role_rules (rules_id, role_id) values(1, 1);
insert into users (name, role_id) values('Petrovich', 1);
insert into category (name) values('To do');
insert into state (name) values('Created');
insert into item (name, user_id, state_id, category_id) values('Install PostrgeSQL', 1, 1, 1);
insert into comments (name, item_id) values('by Friday', 1);
insert into attachs  (name, item_id) values('readme.txt', 1);