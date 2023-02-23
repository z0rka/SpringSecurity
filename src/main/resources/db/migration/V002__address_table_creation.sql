CREATE TABLE IF NOT EXISTS my_app.address
(
    id           integer NOT NULL DEFAULT nextval('my_app.my_app_id_seq') primary key,
    country      text    NOT NULL,
    city         text    NOT NULL,
    street       text    NOT NULL,
    house        text    NOT NULL,
    fk_user_info_id integer constraint fk_user_info_primary_key references my_app.user_info
);