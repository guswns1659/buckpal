package com.titanic.buckpal.account.domain;

import lombok.Getter;
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

    @Value
    public static class ActivityId {
        Long value;
    }
}
