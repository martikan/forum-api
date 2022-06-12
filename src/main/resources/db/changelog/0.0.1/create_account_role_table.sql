--liquibase formatted sql
--changeset rmartikan:create_account_role_table splitStatements:true endDelimiter:;

create table ACCOUNT_ROLE (
     account_id bigint not null,
     role_id bigint not null,
     primary key(account_id, role_id),
     constraint FK_ACCOUNT_ROLE_ACCOUNT foreign key(account_id)
         references ACCOUNT(id)
         on delete cascade,
     constraint FK_ACCOUNT_ROLE_ROLE foreign key(role_id)
         references ROLE(id)
);

-- Insert Admin roles.
insert into ACCOUNT_ROLE (account_id, role_id) values (1, 1);
insert into ACCOUNT_ROLE (account_id, role_id) values (1, 2);
insert into ACCOUNT_ROLE (account_id, role_id) values (1, 3);