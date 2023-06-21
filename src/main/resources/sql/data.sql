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

insert
multiplex (name, opening_day, start_time, end_time)
values ('gangnam', '2015-11-10', '09:00:00', '23:00:00');

-- # insert member (name, email, password)
-- # VALUES ('test_member', 'test@email.com', 'test1234');

-- # insert member_role (member_id, role_id)
-- # VALUES ((select id from member where email = 'test@email.com'), (select id from role where name = 'USER'));