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

    private Account setUpAccount() {
        AccountId accountId = new AccountId(1L);
        return defaultAccount()
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
    }

    @Test
    void calculatesBalance() {
        Account account = setUpAccount();

        Money balance = account.calculate();
        assertThat(balance).isEqualTo(Money.of(1555L));
    }

    @Test
    void withdrawalSucceeds() {
        Account account = setUpAccount();

        boolean success = account.withdraw(Money.of(555L), new AccountId(99L));

        assertThat(success).isTrue();
        assertThat(account.getActivityWindow().getActivities()).hasSize(3);
        assertThat(account.calculateBalance()).isEqualTo(Money.of(1000L));
    }

    @Test
    void depositSuccess() {
        Account account = setUpAccount();

        boolean success = account.deposit(Money.of(445L), new AccountId(99L));

        assertThat(success).isTrue();
        assertThat(account.getActivityWindow().getActivities()).hasSize(3);
        assertThat(account.calculateBalance()).isEqualTo(Money.of(2000L));
    }
}
