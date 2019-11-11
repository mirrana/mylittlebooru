-- Create database and user

set role postgres;
drop database if exists mylittlebooru;
drop database if exists booru;
drop role if exists booru;

create user booru with password '3uwr8prA';
create database booru owner booru;
grant all privileges on database booru to booru;


-- Create Data Model

set role booru;
\c booru;

create schema booru;
set search_path = booru,public;

create sequence tag_categories_id_seq start with 1;

create table tag_categories
(
    id          bigint default nextval('tag_categories_id_seq'),
    title       varchar(255) not null,
    description varchar(1000),
    constraint pk_tag_categories primary key (id),
    constraint u_tag_categories unique (title)
);

alter sequence tag_categories_id_seq owned by tag_categories.id;

insert into tag_categories (title, description)
values ('Artist', '');

insert into tag_categories (title, description)
values ('Character', '');

insert into tag_categories (title, description)
values ('Copyright', '');

insert into tag_categories (title, description)
values ('General', '');



create sequence tags_id_seq start with 1;

create table tags
(
    id          bigint       not null default nextval('tags_id_seq'),
    category    bigint       not null,
    title       varchar(255) not null,
    description varchar(1000),
    constraint pk_tags primary key (id),
    constraint fk_tags_tag_categories foreign key (category) references tag_categories
);

alter sequence tags_id_seq owned by tags.id;



create sequence tag_aliases_id_seq start with 1;

create table tag_aliases
(
    id     bigint       not null default nextval('tag_aliases_id_seq'),
    tag_id bigint       not null,
    alias  varchar(255) not null,
    constraint pk_tag_aliases primary key (id),
    constraint fk_tag_aliases_tags foreign key (tag_id) references tags
);

alter sequence tag_aliases_id_seq owned by tag_aliases.id;



create table ratings
(
    tag         char(1)      not null,
    title       varchar(255) not null,
    description varchar(1000),
    constraint pk_ratings primary key (tag),
    constraint u_ratings_01 unique (title)
);



create sequence files_id_seq start with 1;

create table files
(
    id          bigint       not null default nextval('files_id_seq'),
    file_path   varchar(255) not null, -- Relative to the data directory
    file_size   bigint       not null, -- in bytes
    md5         uuid         not null,
    mime_type   varchar(30)  not null,
    width       int          not null, -- pixels
    height      int          not null,
    title       varchar(255),
    description varchar(1000),
    rating      char(1)      not null,
    score       int,
    source      varchar(255),
    date_added  timestamp    not null,
    constraint pk_files primary key (id),
    constraint u_files_01 unique (file_path),
    constraint ck_files_file_size check (file_size > 0),
    constraint ck_files_width check (width is null or width > 0),
    constraint ck_files_height check (height is null or height > 0),
    constraint ck_files_score check (score is null or (score > 0 and score <= 10)),
    constraint fk_files_rating foreign key (rating) references ratings
);

alter sequence files_id_seq owned by files.id;



create table file_tags
(
    file_id bigint not null,
    tag_id  bigint not null,
    constraint pk_file_tags primary key (file_id, tag_id),
    constraint fk_file_tags_files foreign key (file_id) references files,
    constraint fk_file_tags_tags foreign key (tag_id) references tags
);



create sequence artists_id_seq start with 1;

create table artists
(
    id   bigint       not null default nextval('artists_id_seq'),
    name varchar(255) not null,
    constraint pk_artists primary key (id)
);

alter sequence artists_id_seq owned by artists.id;