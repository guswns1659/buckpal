package com.titanic.buckpal.account.application.port.out;

import com.titanic.buckpal.account.domain.Account;

public interface UpdateAccountStatePort {
    void updateActivities(Account account);
}
