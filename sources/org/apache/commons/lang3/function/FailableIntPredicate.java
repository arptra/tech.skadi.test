package org.apache.commons.lang3.function;

import com.honey.account.dc.b1;
import com.honey.account.dc.c1;
import com.honey.account.dc.d1;
import com.honey.account.dc.e1;
import com.honey.account.dc.f1;
import java.lang.Throwable;
import java.util.Objects;

@FunctionalInterface
public interface FailableIntPredicate<E extends Throwable> {
    public static final FailableIntPredicate FALSE = new c1();
    public static final FailableIntPredicate TRUE = new d1();

    static <E extends Throwable> FailableIntPredicate<E> falsePredicate() {
        return FALSE;
    }

    /* access modifiers changed from: private */
    /* synthetic */ boolean lambda$and$2(FailableIntPredicate failableIntPredicate, int i) throws Throwable {
        return test(i) && failableIntPredicate.test(i);
    }

    /* access modifiers changed from: private */
    /* synthetic */ boolean lambda$negate$3(int i) throws Throwable {
        return !test(i);
    }

    /* access modifiers changed from: private */
    /* synthetic */ boolean lambda$or$4(FailableIntPredicate failableIntPredicate, int i) throws Throwable {
        return test(i) || failableIntPredicate.test(i);
    }

    /* access modifiers changed from: private */
    static /* synthetic */ boolean lambda$static$0(int i) throws Throwable {
        return false;
    }

    /* access modifiers changed from: private */
    static /* synthetic */ boolean lambda$static$1(int i) throws Throwable {
        return true;
    }

    static <E extends Throwable> FailableIntPredicate<E> truePredicate() {
        return TRUE;
    }

    FailableIntPredicate<E> and(FailableIntPredicate<E> failableIntPredicate) {
        Objects.requireNonNull(failableIntPredicate);
        return new b1(this, failableIntPredicate);
    }

    FailableIntPredicate<E> negate() {
        return new f1(this);
    }

    FailableIntPredicate<E> or(FailableIntPredicate<E> failableIntPredicate) {
        Objects.requireNonNull(failableIntPredicate);
        return new e1(this, failableIntPredicate);
    }

    boolean test(int i) throws Throwable;
}
