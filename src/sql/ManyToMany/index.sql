drop table Actors_Movies;
drop table Actors;
drop table Movies;

create table Actors(
    id serial8 primary key,
    name varchar(100) not null unique,
    age int check(age > 0)
);

create table Movies(
    id serial8 primary key,
    name varchar(100) not null,
    year_of_production int check (year_of_production > 1900)
);

create table Actors_Movies(
    actor_id int8,
    movie_id int8,
    foreign key (actor_id) references Actors (id),
    foreign key (movie_id) references Movies (id),
    primary key (actor_id, movie_id)
);

