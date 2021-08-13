package com.titanic.buckpal.common;

import com.titanic.buckpal.account.domain.Account.AccountId;
import com.titanic.buckpal.account.domain.Activity;
import com.titanic.buckpal.account.domain.Activity.ActivityId;
import com.titanic.buckpal.account.domain.Money;
import java.time.LocalDateTime;

public class ActivityTestData {

    public static class ActivityBuilder {
        private ActivityId id;
        private AccountId ownerAccountId;
        private AccountId sourceAccountId;
        private AccountId targetAccountId;
        private LocalDateTime timestamp;
        private Money money;

        public ActivityBuilder withId(ActivityId id) {
            this.id = id;
            return this;
        }

        public ActivityBuilder withOwnerAccount(AccountId accountId) {
            this.ownerAccountId = accountId;
            return this;
        }

        public ActivityBuilder withSourceAccount(AccountId accountId) {
            this.sourceAccountId = accountId;
            return this;
        }

        public ActivityBuilder withTargetAccount(AccountId accountId) {
            this.targetAccountId = accountId;
            return this;
        }

        public ActivityBuilder withTimestamp(LocalDateTime timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public ActivityBuilder withMoney(Money money) {
            this.money = money;
            return this;
        }

        /*public Activity build() {
            return new Activity(
                this.id,
                this.ownerAccountId,
                this.sourceAccountId,
                this.targetAccountId,
                this.timestamp,
                this.money
            );
        }*/

    }

}
