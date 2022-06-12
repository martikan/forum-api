--liquibase formatted sql
--changeset rmartikan:create_role_table splitStatements:true endDelimiter:;

create table ROLE (
   id bigserial primary key,
   name varchar(50) unique not null
);

-- Insert pre-defined roles.
insert into ROLE(name) values('ROLE_SUPER_ADMIN');
insert into ROLE(name) values('ROLE_ADMIN');
insert into ROLE(name) values('ROLE_USER');