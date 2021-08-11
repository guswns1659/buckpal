package com.titanic.buckpal.account.adapter.out.persistence;

import com.titanic.buckpal.account.application.port.out.LoadAccountPort;
import com.titanic.buckpal.account.application.port.out.UpdateAccountStatePort;
import com.titanic.buckpal.account.common.PersistenceAdapter;
import com.titanic.buckpal.account.domain.Account;
import com.titanic.buckpal.account.domain.Account.AccountId;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;

/**
 * Account Bounded Context에서 Account를 DB에 CRUD하는 어댑터. Account 관련 객체만 의존성을 가지고 있음. 캡슐화
 */
@RequiredArgsConstructor
@PersistenceAdapter
public class AccountPersistenceAdapter implements LoadAccountPort, UpdateAccountStatePort {

    private final SpringDataAccountRepository accountRepository;
    private final ActivityRepository activityRepository;
    private final AccountMapper accountMapper;

    @Override
    public Account loadAccount(AccountId accountId, LocalDateTime baselineDate) {
        return null;
    }

    @Override
    public void updateActivities(Account account) {

    }
}
