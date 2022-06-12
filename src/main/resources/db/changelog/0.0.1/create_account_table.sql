--liquibase formatted sql
--changeset rmartikan:create_account_table splitStatements:true endDelimiter:;

create table ACCOUNT (
   id bigserial primary key,
   email varchar(255) unique not null,
   password varchar(66) not null,
   first_name varchar(100) not null,
   last_name varchar(100) not null,
   phone varchar (100),
   created_at timestamp with time zone default current_timestamp,
   updated_at timestamp with time zone,
   last_login_at timestamp with time zone
);

-- insert Admin user.
insert into ACCOUNT (email, password, first_name, last_name) values ('admin@admin.com', '$2a$10$PT1T01CxlZV44rIhUceQie5J5tWlzijeEBA5mPREo5xBPhdPaG4ri', 'Admin', 'Admin');