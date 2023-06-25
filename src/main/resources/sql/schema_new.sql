drop table if exists reservation_item;
drop table if exists ticket;
drop table if exists reservation;

drop table if exists schedule;
drop table if exists movie;

drop table if exists seat;
drop table if exists theater;
drop table if exists multiplex;

drop table if exists business_information;
drop table if exists member_role;
drop table if exists member;
drop table if exists role;


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


-- theaters
CREATE TABLE multiplex
(
    id          bigint       NOT NULL AUTO_INCREMENT,
    name        varchar(10)  NOT NULL,
    opening_day timestamp(6) NOT NULL,
    start_time  time         NOT NULL,
    end_time    time         NOT NULL,
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


-- movies
CREATE TABLE movie
(
    id             bigint      NOT NULL AUTO_INCREMENT,
    title          varchar(20) NOT NULL,
    director       varchar(10) NOT NULL,
    original_price varchar(10) NOT NULL,
    release_date   varchar(10) NOT NULL,
    age_rating     varchar(10) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE schedule
(
    id         bigint       NOT NULL AUTO_INCREMENT,
    price      int          NOT NULL,
    start_time timestamp(6) NOT NULL,
    end_time   timestamp(6) NOT NULL,
    theater_id bigint       NOT NULL,
    movie_id   bigint       NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT fk_theater_id_for_schedule FOREIGN KEY (theater_id) REFERENCES theater (id) ON DELETE RESTRICT ON UPDATE RESTRICT,
    CONSTRAINT fk_movie_id_for_schedule FOREIGN KEY (movie_id) REFERENCES movie (id) ON DELETE RESTRICT ON UPDATE RESTRICT
);


-- tickets
CREATE TABLE ticket
(
    id          bigint NOT NULL AUTO_INCREMENT,
    is_reserved bool   NOT NULL,
    schedule_id bigint NOT NULL,
    seat_id     bigint NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT fk_schedule_id_for_ticket FOREIGN KEY (schedule_id) REFERENCES theater (id) ON DELETE RESTRICT ON UPDATE RESTRICT,
    CONSTRAINT fk_seat_id_for_ticket FOREIGN KEY (seat_id) REFERENCES seat (id) ON DELETE RESTRICT ON UPDATE RESTRICT
);

CREATE TABLE reservation
(
    id          bigint NOT NULL AUTO_INCREMENT,
    total_price int    NOT NULL,
    member_id   bigint NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE reservation_item
(
    id             bigint      NOT NULL AUTO_INCREMENT,
    reservation_id bigint      NOT NULL,
    ticket_type    varchar(20) NOT NULL,
    price          int         NOT NULL,
    ticket_id      bigint      NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT fk_reservation_id_for_reservation_item FOREIGN KEY (reservation_id) REFERENCES reservation (id) ON DELETE RESTRICT ON UPDATE RESTRICT,
    CONSTRAINT fk_ticket_id_for_reservation_item FOREIGN KEY (ticket_id) REFERENCES ticket (id) ON DELETE RESTRICT ON UPDATE RESTRICT
);
