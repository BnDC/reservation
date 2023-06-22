-- insert role
insert
role (name)
values ('ADMIN');

insert
role (name)
values ('THEATER_BUSINESS');

insert
role (name)
values ('PERFORMANCE_BUSINESS');

insert
role (name)
values ('USER');


-- insert super user
insert member (name, email, password)
VALUES ('test_member', 'test@email.com', '$2a$10$E/yr.OowFjDBcqU.B62ldOtO4v9/xk3Yh3Yl6bE6FicLM8cvpWnVe');

insert member_role (member_id, role_id)
VALUES ((select id from member where email = 'test@email.com'), (select id from role where name = 'USER'));

insert member_role (member_id, role_id)
VALUES ((select id from member where email = 'test@email.com'), (select id from role where name = 'PERFORMANCE_BUSINESS'));

insert member_role (member_id, role_id)
VALUES ((select id from member where email = 'test@email.com'), (select id from role where name = 'THEATER_BUSINESS'));


-- insert multiplex
insert
multiplex (name, opening_day, start_time, end_time)
values ('gangnam', '2015-11-10', '09:00:00', '23:00:00');

-- insert movie
insert
movie (title, director, original_price, release_date, age_rating)
values ('helloWorld', 'john', 9000, '2023-03-11', 'ALL');

insert
movie (title, director, original_price, release_date, age_rating)
values ('linux', 'hop', 10000, '2023-03-15', 'ALL');