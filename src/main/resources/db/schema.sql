create table posts (
                       id serial primary key,
                       name varchar(2000),
                       description text,
                       created timestamp without time zone not null default now()
);

create table messages (
                       id serial primary key,
                       message text,
                       date timestamp without time zone not null default now(),
                       post int,
                       CONSTRAINT fk_post
                           FOREIGN KEY(post)
                           REFERENCES posts(id)
);
create table users_forum (
                       id serial primary key,
                       name varchar(2000),
                       password varchar(15)
);