create table organization
(
    id   int auto_increment
        primary key,
    name varchar(100) not null
);

INSERT INTO mydb.organization (id, name) VALUES (1, 'ai');
INSERT INTO mydb.organization (id, name) VALUES (2, 'music');
