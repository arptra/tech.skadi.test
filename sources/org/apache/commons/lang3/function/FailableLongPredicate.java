package org.apache.commons.lang3.function;

import com.honey.account.dc.p1;
import com.honey.account.dc.q1;
import com.honey.account.dc.r1;
import com.honey.account.dc.s1;
import com.honey.account.dc.t1;
import java.lang.Throwable;
import java.util.Objects;

@FunctionalInterface
public interface FailableLongPredicate<E extends Throwable> {
    public static final FailableLongPredicate FALSE = new s1();
    public static final FailableLongPredicate TRUE = new t1();

    static <E extends Throwable> FailableLongPredicate<E> falsePredicate() {
        return FALSE;
    }

    /* access modifiers changed from: private */
    /* synthetic */ boolean lambda$and$2(FailableLongPredicate failableLongPredicate, long j) throws Throwable {
        return test(j) && failableLongPredicate.test(j);
    }

    /* access modifiers changed from: private */
    /* synthetic */ boolean lambda$negate$3(long j) throws Throwable {
        return !test(j);
    }

    /* access modifiers changed from: private */
    /* synthetic */ boolean lambda$or$4(FailableLongPredicate failableLongPredicate, long j) throws Throwable {
        return test(j) || failableLongPredicate.test(j);
    }

    /* access modifiers changed from: private */
    static /* synthetic */ boolean lambda$static$0(long j) throws Throwable {
        return false;
    }

    /* access modifiers changed from: private */
    static /* synthetic */ boolean lambda$static$1(long j) throws Throwable {
        return true;
    }

    static <E extends Throwable> FailableLongPredicate<E> truePredicate() {
        return TRUE;
    }

    FailableLongPredicate<E> and(FailableLongPredicate<E> failableLongPredicate) {
        Objects.requireNonNull(failableLongPredicate);
        return new p1(this, failableLongPredicate);
    }

    FailableLongPredicate<E> negate() {
        return new q1(this);
    }

    FailableLongPredicate<E> or(FailableLongPredicate<E> failableLongPredicate) {
        Objects.requireNonNull(failableLongPredicate);
        return new r1(this, failableLongPredicate);
    }

    boolean test(long j) throws Throwable;
}
