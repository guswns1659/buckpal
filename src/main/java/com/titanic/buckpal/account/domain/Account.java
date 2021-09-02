package com.titanic.buckpal.account.domain;

import java.time.LocalDateTime;
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

    /**
     * Tries to withdraw a certain amount of money from this account. If successful, creates a new activity with a
     * negative value.
     */
    public boolean withdraw(Money money, AccountId targetAccountId) {

        if (!mayWithdraw(money)) {
            return false;
        }

        Activity withdrawal = new Activity(
            this.id,
            this.id,
            targetAccountId,
            LocalDateTime.now(),
            money
        );
        this.activityWindow.addActivity(withdrawal);
        return true;
    }

    public Money calculateBalance() {
        return Money.add(this.baselineBalance,
            this.activityWindow.calculateBalance(this.id));
    }

    private boolean mayWithdraw(Money money) {
        return Money.add(this.calculateBalance(),
            money.negate()).isPositiveOrZero();
    }

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
