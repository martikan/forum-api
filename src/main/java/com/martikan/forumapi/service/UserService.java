package com.martikan.forumapi.service;

import java.util.List;

import com.martikan.forumapi.model.tables.pojos.Account;

public interface UserService {

    List<Account> findTopN(final int pageSize);

    List<Account> findNextN(final int pageSize, final List<Account> previousAccounts);

    Account findById(final Long id) throws Exception;
    
}
