create schema if not exists my_app;

create sequence if not exists my_app.my_app_id_seq;

create table if not exists my_app.product
(
    id   integer not null default nextval('my_app.my_app_id_seq') primary key,
    name text    not null,
    cost float   not null
);

create table if not exists my_app.user_info
(

    id       integer not null default nextval('my_app.my_app_id_seq') primary key,
    name     text    not null unique ,
    password text    not null,
    role     text    not null
)