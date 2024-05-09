create table Humanity(
    id serial8 primary key,
    name varchar(100) not null,
    age int check ( age > 0 and age < 120)
);

create table Passports(
    person_id int8 primary key,
    passport_number int not null,
    foreign key (person_id) references Humanity (id) on delete cascade
);