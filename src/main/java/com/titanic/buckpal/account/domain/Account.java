package com.titanic.buckpal.account.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

/**
 * An account that hold a certain amount of money. An Account object only contains a window of the latest account
 * activities. The total balance of the account is the sum of a baseline balance that was valid before the first
 * activity in the window and the sum of the activity values.
 */
@AllArgsConstructor(access = AccessLevel.PRIVATE) // always private
public class Account {

    @Getter
    private final AccountId id;

    @Getter
    private final Money baselineBalance;

    @Getter
    private final ActivityWindow activityWindow;

    @Value
    public static class AccountId {
        Long value;
    }

    public static Account withId(AccountId accountId, Money baselineBalance, ActivityWindow activityWindow) {
        return new Account(accountId, baselineBalance, activityWindow);
    }

    public Money calculate() {
        return Money.add(
            this.baselineBalance,
            this.activityWindow.calculateBalance(this.id));
    }

}
