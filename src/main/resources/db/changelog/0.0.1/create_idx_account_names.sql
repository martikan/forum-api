--liquibase formatted sql
--changeset rmartikan:create_idx_account_names splitStatements:true endDelimiter:;

create index idx_account_names on ACCOUNT(first_name, last_name);