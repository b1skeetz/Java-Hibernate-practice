drop table people;
create table people(
    id serial8 primary key,
    name varchar(100) not null,
    age int4 check (age < 100)
);

insert into people (name, age) VALUES ('Tom', 26),
                                      ('Ben', 12),
                                      ('Samanta', 38);