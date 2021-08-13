package com.titanic.buckpal.common;

import com.titanic.buckpal.account.domain.Account;
import com.titanic.buckpal.account.domain.Account.AccountId;
import com.titanic.buckpal.account.domain.ActivityWindow;
import com.titanic.buckpal.account.domain.Money;

public class AccountTestData {

    /*public static AccountBuilder defaultAccount() {
        return new AccountBuilder().withAccountId(new AccountId(42L))
            .withBaselineBalance(Money.of(999L))
            .withActivityWindow(new ActivityWindow(new ActivityWindow(
                ActivityTestData.
            )

            ))
    }*/

    public static class AccountBuilder {

        private AccountId accountId;
        private Money baselineBalance;
        private ActivityWindow activityWindow;

        public AccountBuilder withAccountId(AccountId accountId) {
            this.accountId = accountId;
            return this;
        }

        public AccountBuilder withBaselineBalance(Money baselineBalance) {
            this.baselineBalance = baselineBalance;
            return this;
        }

        public AccountBuilder withActivityWindow(ActivityWindow activityWindow) {
            this.activityWindow = activityWindow;
            return this;
        }

        public Account build() {
            return Account.withId(accountId, baselineBalance, activityWindow);
        }
    }

}
