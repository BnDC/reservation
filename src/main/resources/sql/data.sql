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


-- # insert member (name, email, password)
-- # VALUES ('test_member', 'test@email.com', 'test1234');

-- # insert member_role (member_id, role_id)
-- # VALUES ((select id from member where email = 'test@email.com'), (select id from role where name = 'USER'));