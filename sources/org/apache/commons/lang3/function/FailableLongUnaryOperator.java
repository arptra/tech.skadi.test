package org.apache.commons.lang3.function;

import com.honey.account.dc.w1;
import com.honey.account.dc.x1;
import com.honey.account.dc.y1;
import com.honey.account.dc.z1;
import java.lang.Throwable;
import java.util.Objects;

public interface FailableLongUnaryOperator<E extends Throwable> {
    public static final FailableLongUnaryOperator NOP = new y1();

    static <E extends Throwable> FailableLongUnaryOperator<E> identity() {
        return new w1();
    }

    /* access modifiers changed from: private */
    /* synthetic */ long lambda$andThen$2(FailableLongUnaryOperator failableLongUnaryOperator, long j) throws Throwable {
        return failableLongUnaryOperator.applyAsLong(applyAsLong(j));
    }

    /* access modifiers changed from: private */
    /* synthetic */ long lambda$compose$3(FailableLongUnaryOperator failableLongUnaryOperator, long j) throws Throwable {
        return applyAsLong(failableLongUnaryOperator.applyAsLong(j));
    }

    /* access modifiers changed from: private */
    static /* synthetic */ long lambda$identity$1(long j) throws Throwable {
        return j;
    }

    /* access modifiers changed from: private */
    static /* synthetic */ long lambda$static$0(long j) throws Throwable {
        return 0;
    }

    static <E extends Throwable> FailableLongUnaryOperator<E> nop() {
        return NOP;
    }

    FailableLongUnaryOperator<E> andThen(FailableLongUnaryOperator<E> failableLongUnaryOperator) {
        Objects.requireNonNull(failableLongUnaryOperator);
        return new x1(this, failableLongUnaryOperator);
    }

    long applyAsLong(long j) throws Throwable;

    FailableLongUnaryOperator<E> compose(FailableLongUnaryOperator<E> failableLongUnaryOperator) {
        Objects.requireNonNull(failableLongUnaryOperator);
        return new z1(this, failableLongUnaryOperator);
    }
}
