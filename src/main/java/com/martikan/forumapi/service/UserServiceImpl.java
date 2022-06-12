package com.martikan.forumapi.service;

import java.util.List;

import org.jooq.DSLContext;
import org.springframework.stereotype.Service;

import com.martikan.forumapi.model.Tables;
import com.martikan.forumapi.model.tables.pojos.Account;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final DSLContext context;

    @Override
    public List<Account> findTopN(final int pageSize) {
        return context
            .selectFrom(Tables.ACCOUNT)
            .orderBy(Tables.ACCOUNT.LAST_NAME.asc())
            .limit(pageSize)
            .fetchInto(Account.class);
    }

    @Override
    public List<Account> findNextN(int pageSize, List<Account> previousAccounts) {

        final var lastRecord = previousAccounts.get(previousAccounts.size() -1);

        return context
            .selectFrom(Tables.ACCOUNT)
            .orderBy(Tables.ACCOUNT.LAST_NAME.asc(), Tables.ACCOUNT.ID.asc())
            .seek(lastRecord.getLastName(), lastRecord.getId())
            .limit(pageSize)
            .fetchInto(Account.class);
    }

    @Override
    public Account findById(Long id) throws Exception {

        return context
            .selectFrom(Tables.ACCOUNT)
            .where(Tables.ACCOUNT.ID.eq(id))
            .fetchOptionalInto(Account.class)
            .orElseThrow(() -> new Exception("Entity not found"));

    }
    
}
