package com.titanic.buckpal.account.domain;

import com.titanic.buckpal.account.domain.Account.AccountId;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Value;

/**
 * A money transfer activity between {@link Account}s
 */
@Value
@RequiredArgsConstructor
public class Activity {

    @Getter
    ActivityId id;

    @Getter
    @NonNull
    private final AccountId ownerAccountId;

    @Getter
    @NonNull
    private final AccountId sourceAccountId;

    @Getter
    @NonNull
    private final AccountId targetAccountId;

    @Getter
    @NonNull
    private final LocalDateTime localDateTime;

    @Getter
    @NonNull
    private final Money money;

    @Value
    public static class ActivityId {
        Long value;
    }

    public Activity(
        @NonNull AccountId ownerAccountId,
        @NonNull AccountId sourceAccountId,
        @NonNull AccountId targetAccountId,
        @NonNull LocalDateTime timestamp,
        @NonNull Money money) {
        this.id = null;
        this.ownerAccountId = ownerAccountId;
        this.sourceAccountId = sourceAccountId;
        this.targetAccountId = targetAccountId;
        this.localDateTime = timestamp;
        this.money = money;
    }
}
