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
insert
member (name, email, password)
VALUES ('test_member', 'test@email.com', '$2a$10$E/yr.OowFjDBcqU.B62ldOtO4v9/xk3Yh3Yl6bE6FicLM8cvpWnVe');

SET
@test_member = (select id from member where email = 'test@email.com');
SET
@role_user = (select id from role where name = 'USER');
SET
@role_per = (select id from role where name = 'PERFORMANCE_BUSINESS');
SET
@role_theater = (select id from role where name = 'THEATER_BUSINESS');

insert
member_role (member_id, role_id)
VALUES (@test_member, @role_user);

insert
member_role (member_id, role_id)
VALUES (@test_member, @role_theater);

insert
member_role (member_id, role_id)
VALUES (@test_member, @role_per);


-- insert multiplex
insert
multiplex (name, opening_day, start_time, end_time)
values ('gangnam', '2015-11-10', '09:00:00', '23:00:00');

-- insert theater
insert
theater (name, theater_type, multiplex_id)
values ('hall-1', 'NORMAL', 1);

SET
@test_theater = (select id from theater where name = 'hall-1');

insert
seat (position, theater_id)
values ('A1', @test_theater);

insert
seat (position, theater_id)
values ('B1', @test_theater);

insert
seat (position, theater_id)
values ('C1', @test_theater);


-- insert movie
insert
movie (title, director, original_price, release_date, age_rating)
values ('helloWorld', 'john', 9000, '2023-03-11', 'ALL');

insert
movie (title, director, original_price, release_date, age_rating)
values ('linux', 'hop', 10000, '2023-03-15', 'ALL');