package com.titanic.buckpal.account.domain;

import static com.titanic.buckpal.common.AccountTestData.defaultAccount;
import static com.titanic.buckpal.common.ActivityTestData.defaultActivity;
import static org.assertj.core.api.Assertions.assertThat;
import com.titanic.buckpal.account.domain.Account.AccountId;
import org.junit.jupiter.api.Test;

/**
 * unit test
 */
public class AccountTest {

    @Test
    void calculatesBalance() {
        AccountId accountId = new AccountId(1L);
        Account account = defaultAccount()
            .withAccountId(accountId)
            .withBaselineBalance(Money.of(555L))
            .withActivityWindow(new ActivityWindow(
                defaultActivity()
                    .withTargetAccount(accountId)
                    .withMoney(Money.of(999L)).build(),
                defaultActivity()
                    .withTargetAccount(accountId)
                    .withMoney(Money.of(1L)).build()
            )).build();

        Money balance = account.calculate();
        assertThat(balance).isEqualTo(Money.of(1555L));
    }
}
