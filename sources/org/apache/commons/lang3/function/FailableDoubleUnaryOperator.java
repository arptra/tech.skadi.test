package org.apache.commons.lang3.function;

import com.honey.account.dc.q0;
import com.honey.account.dc.r0;
import com.honey.account.dc.s0;
import com.honey.account.dc.t0;
import java.lang.Throwable;
import java.util.Objects;

public interface FailableDoubleUnaryOperator<E extends Throwable> {
    public static final FailableDoubleUnaryOperator NOP = new r0();

    static <E extends Throwable> FailableDoubleUnaryOperator<E> identity() {
        return new q0();
    }

    /* access modifiers changed from: private */
    /* synthetic */ double lambda$andThen$2(FailableDoubleUnaryOperator failableDoubleUnaryOperator, double d) throws Throwable {
        return failableDoubleUnaryOperator.applyAsDouble(applyAsDouble(d));
    }

    /* access modifiers changed from: private */
    /* synthetic */ double lambda$compose$3(FailableDoubleUnaryOperator failableDoubleUnaryOperator, double d) throws Throwable {
        return applyAsDouble(failableDoubleUnaryOperator.applyAsDouble(d));
    }

    /* access modifiers changed from: private */
    static /* synthetic */ double lambda$identity$1(double d) throws Throwable {
        return d;
    }

    /* access modifiers changed from: private */
    static /* synthetic */ double lambda$static$0(double d) throws Throwable {
        return 0.0d;
    }

    static <E extends Throwable> FailableDoubleUnaryOperator<E> nop() {
        return NOP;
    }

    FailableDoubleUnaryOperator<E> andThen(FailableDoubleUnaryOperator<E> failableDoubleUnaryOperator) {
        Objects.requireNonNull(failableDoubleUnaryOperator);
        return new t0(this, failableDoubleUnaryOperator);
    }

    double applyAsDouble(double d) throws Throwable;

    FailableDoubleUnaryOperator<E> compose(FailableDoubleUnaryOperator<E> failableDoubleUnaryOperator) {
        Objects.requireNonNull(failableDoubleUnaryOperator);
        return new s0(this, failableDoubleUnaryOperator);
    }
}
