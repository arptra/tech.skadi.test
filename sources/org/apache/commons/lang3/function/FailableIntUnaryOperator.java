package org.apache.commons.lang3.function;

import com.honey.account.dc.i1;
import com.honey.account.dc.j1;
import com.honey.account.dc.k1;
import com.honey.account.dc.l1;
import java.lang.Throwable;
import java.util.Objects;

public interface FailableIntUnaryOperator<E extends Throwable> {
    public static final FailableIntUnaryOperator NOP = new i1();

    static <E extends Throwable> FailableIntUnaryOperator<E> identity() {
        return new l1();
    }

    /* access modifiers changed from: private */
    /* synthetic */ int lambda$andThen$2(FailableIntUnaryOperator failableIntUnaryOperator, int i) throws Throwable {
        return failableIntUnaryOperator.applyAsInt(applyAsInt(i));
    }

    /* access modifiers changed from: private */
    /* synthetic */ int lambda$compose$3(FailableIntUnaryOperator failableIntUnaryOperator, int i) throws Throwable {
        return applyAsInt(failableIntUnaryOperator.applyAsInt(i));
    }

    /* access modifiers changed from: private */
    static /* synthetic */ int lambda$identity$1(int i) throws Throwable {
        return i;
    }

    /* access modifiers changed from: private */
    static /* synthetic */ int lambda$static$0(int i) throws Throwable {
        return 0;
    }

    static <E extends Throwable> FailableIntUnaryOperator<E> nop() {
        return NOP;
    }

    FailableIntUnaryOperator<E> andThen(FailableIntUnaryOperator<E> failableIntUnaryOperator) {
        Objects.requireNonNull(failableIntUnaryOperator);
        return new k1(this, failableIntUnaryOperator);
    }

    int applyAsInt(int i) throws Throwable;

    FailableIntUnaryOperator<E> compose(FailableIntUnaryOperator<E> failableIntUnaryOperator) {
        Objects.requireNonNull(failableIntUnaryOperator);
        return new j1(this, failableIntUnaryOperator);
    }
}
