drop table if exists business_information;
drop table if exists member_role;
drop table if exists member;
drop table if exists role;
drop table if exists seat;
drop table if exists theater;
drop table if exists multiplex;


CREATE TABLE role
(
    id   bigint       NOT NULL AUTO_INCREMENT,
    name varchar(255) NOT NULL,
    CONSTRAINT unq_name_id UNIQUE (name),
    PRIMARY KEY (id)
);

CREATE TABLE member
(
    id       bigint       NOT NULL AUTO_INCREMENT,
    name     varchar(20)  NOT NULL,
    email    varchar(20)  NOT NULL,
    password varchar(255) NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT unq_email_id UNIQUE (email)
);

CREATE TABLE member_role
(
    id        bigint NOT NULL AUTO_INCREMENT,
    member_id bigint NOT NULL,
    role_id   bigint NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT unq_member_id_role_id UNIQUE (member_id, role_id),
    CONSTRAINT fk_member_id_for_member_role FOREIGN KEY (member_id) REFERENCES member (id) ON DELETE RESTRICT ON UPDATE RESTRICT,
    CONSTRAINT fk_role_id_for_member_role FOREIGN KEY (role_id) REFERENCES role (id) ON DELETE RESTRICT ON UPDATE RESTRICT
);

CREATE TABLE business_information
(
    id               bigint      NOT NULL AUTO_INCREMENT,
    business_license varchar(10) NOT NULL,
    member_id        bigint      NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT unq_business_license UNIQUE (business_license),
    CONSTRAINT fk_member_id_for_business_information FOREIGN KEY (member_id) REFERENCES member (id) ON DELETE RESTRICT ON UPDATE RESTRICT
);

CREATE TABLE multiplex
(
    id          bigint       NOT NULL AUTO_INCREMENT,
    name        varchar(10)  NOT NULL,
    opening_day timestamp(6) NOT NULL,
    start_time  time NOT NULL,
    end_time    time NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE theater
(
    id           bigint      NOT NULL AUTO_INCREMENT,
    name         varchar(10) NOT NULL,
    theater_type varchar(10) NOT NULL,
    multiplex_id bigint(6)   NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT fk_multiplex_id_for_theater FOREIGN KEY (multiplex_id) REFERENCES multiplex (id) ON DELETE RESTRICT ON UPDATE RESTRICT
);

CREATE TABLE seat
(
    id         bigint      NOT NULL AUTO_INCREMENT,
    position   varchar(10) NOT NULL,
    theater_id bigint      NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT unq_position UNIQUE (position),
    CONSTRAINT fk_theater_id_for_seat FOREIGN KEY (theater_id) REFERENCES theater (id) ON DELETE RESTRICT ON UPDATE RESTRICT
);
