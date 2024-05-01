create table people(
    id serial8 primary key,
    name varchar(100),
    age int4
);

insert into people (name, age) VALUES ('Tom', 26),
                                      ('Ben', 12),
                                      ('Samanta', 38);