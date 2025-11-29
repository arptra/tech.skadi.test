package org.apache.commons.lang3.function;

import com.honey.account.dc.j0;
import com.honey.account.dc.k0;
import com.honey.account.dc.l0;
import com.honey.account.dc.m0;
import com.honey.account.dc.n0;
import java.lang.Throwable;
import java.util.Objects;

@FunctionalInterface
public interface FailableDoublePredicate<E extends Throwable> {
    public static final FailableDoublePredicate FALSE = new m0();
    public static final FailableDoublePredicate TRUE = new n0();

    static <E extends Throwable> FailableDoublePredicate<E> falsePredicate() {
        return FALSE;
    }

    /* access modifiers changed from: private */
    /* synthetic */ boolean lambda$and$2(FailableDoublePredicate failableDoublePredicate, double d) throws Throwable {
        return test(d) && failableDoublePredicate.test(d);
    }

    /* access modifiers changed from: private */
    /* synthetic */ boolean lambda$negate$3(double d) throws Throwable {
        return !test(d);
    }

    /* access modifiers changed from: private */
    /* synthetic */ boolean lambda$or$4(FailableDoublePredicate failableDoublePredicate, double d) throws Throwable {
        return test(d) || failableDoublePredicate.test(d);
    }

    /* access modifiers changed from: private */
    static /* synthetic */ boolean lambda$static$0(double d) throws Throwable {
        return false;
    }

    /* access modifiers changed from: private */
    static /* synthetic */ boolean lambda$static$1(double d) throws Throwable {
        return true;
    }

    static <E extends Throwable> FailableDoublePredicate<E> truePredicate() {
        return TRUE;
    }

    FailableDoublePredicate<E> and(FailableDoublePredicate<E> failableDoublePredicate) {
        Objects.requireNonNull(failableDoublePredicate);
        return new k0(this, failableDoublePredicate);
    }

    FailableDoublePredicate<E> negate() {
        return new l0(this);
    }

    FailableDoublePredicate<E> or(FailableDoublePredicate<E> failableDoublePredicate) {
        Objects.requireNonNull(failableDoublePredicate);
        return new j0(this, failableDoublePredicate);
    }

    boolean test(double d) throws Throwable;
}
