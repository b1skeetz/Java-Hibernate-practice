create table items(
    id serial8 primary key,
    person_id int8,
    item_name varchar(100) not null,
    foreign key (person_id) references people (id) on delete set null
);

insert into items (person_id, item_name) VALUES (1, 'Book'),
                                                (1, 'AirPods'),
                                                (2, 'IPhone'),
                                                (3, 'Kindle'),
                                                (3, 'TV'),
                                                (3, 'PlayStation');