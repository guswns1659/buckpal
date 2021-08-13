package com.titanic.buckpal.account.domain;

import java.math.BigInteger;
import lombok.NonNull;
import lombok.Value;

@Value
public class Money {

    public static Money ZERO = Money.of(0L);

    // @Value change field private final
    @NonNull BigInteger amount;

    public static Money of(long value) {
        return new Money(BigInteger.valueOf(value));
    }

    public static Money add(Money a, Money b) {
        return new Money(a.amount.add(b.amount));
    }

    public Money negate() {
        return new Money(this.amount.negate());
    }

}
