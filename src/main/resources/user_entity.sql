create table user_entity
(
    id              bigint auto_increment
        primary key,
    email           varchar(255) null,
    name            varchar(255) null,
    organization_id int          null,
    constraint organization_id
        foreign key (organization_id) references organization (id)
);

INSERT INTO mydb.user_entity (id, email, name, organization_id) VALUES (7, 'ershow@gmail.com', 'Peter', 1);
INSERT INTO mydb.user_entity (id, email, name, organization_id) VALUES (8, 'ge82mot@mytum.de', 'Peter', 1);
INSERT INTO mydb.user_entity (id, email, name, organization_id) VALUES (9, 'sheeran@mytum.de', 'Sheeran', 2);
INSERT INTO mydb.user_entity (id, email, name, organization_id) VALUES (10, 'lee@munchen.de', 'Lee', 2);
INSERT INTO mydb.user_entity (id, email, name, organization_id) VALUES (11, 'soeder@berlin.de', 'Soeder', 1);
INSERT INTO mydb.user_entity (id, email, name, organization_id) VALUES (16, 'ge54mot@mytum.de', 'Alice', 1);
