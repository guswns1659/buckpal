package com.titanic.buckpal.account.domain;

import com.titanic.buckpal.account.domain.Account.AccountId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import lombok.NonNull;

/**
 * A window of account activities.
 */
public class ActivityWindow {

    private List<Activity> activities;

    // TODO : create constructor
    public ActivityWindow(@NonNull List<Activity> activities) {
        this.activities = activities;
    }

    public ActivityWindow(@NonNull Activity... activities) {
        this.activities = new ArrayList<>(Arrays.asList(activities));
    }

    public Money calculateBalance(AccountId accountId) {
        Money depositBalance = activities.stream()
            .filter(a -> a.getTargetAccountId().equals(accountId))
            .map(Activity::getMoney)
            .reduce(Money.ZERO, Money::add);

        Money withdrawalBalance = activities.stream()
            .filter(a -> a.getSourceAccountId().equals(accountId))
            .map(Activity::getMoney)
            .reduce(Money.ZERO, Money::add);

        return Money.add(depositBalance, withdrawalBalance.negate());
    }

    public void addActivity(Activity activity) {
        this.activities.add(activity);
    }

    public List<Activity> getActivities() {
        return Collections.unmodifiableList(this.activities);
    }

}
