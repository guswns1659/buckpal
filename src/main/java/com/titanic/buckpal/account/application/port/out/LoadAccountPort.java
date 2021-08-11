package com.titanic.buckpal.account.application.port.out;

import com.titanic.buckpal.account.domain.Account;
import com.titanic.buckpal.account.domain.Account.AccountId;
import java.time.LocalDateTime;

public interface LoadAccountPort {

    Account loadAccount(AccountId accountId, LocalDateTime baselineDate);

}
