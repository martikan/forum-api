--liquibase formatted sql
--changeset rmartikan:create_post_table splitStatements:true endDelimiter:;

create table POST (
   id bigserial primary key,
   author_id bigserial not null,
   title varchar(100) not null,
   description text,
   created_at timestamp with time zone default current_timestamp,
   updated_at timestamp with time zone
);
