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
    CONSTRAINT unq_business_license_id UNIQUE (business_license),
    CONSTRAINT fk_member_id_for_business_information FOREIGN KEY (member_id) REFERENCES member (id) ON DELETE RESTRICT ON UPDATE RESTRICT
);
