package org.apache.commons.lang3.function;

import com.honey.account.dc.d2;
import com.honey.account.dc.e2;
import com.honey.account.dc.f2;
import com.honey.account.dc.g2;
import com.honey.account.dc.h2;
import java.lang.Throwable;
import java.util.Objects;

@FunctionalInterface
public interface FailablePredicate<T, E extends Throwable> {
    public static final FailablePredicate FALSE = new f2();
    public static final FailablePredicate TRUE = new g2();

    static <T, E extends Throwable> FailablePredicate<T, E> falsePredicate() {
        return FALSE;
    }

    /* access modifiers changed from: private */
    /* synthetic */ boolean lambda$and$2(FailablePredicate failablePredicate, Object obj) throws Throwable {
        return test(obj) && failablePredicate.test(obj);
    }

    /* access modifiers changed from: private */
    /* synthetic */ boolean lambda$negate$3(Object obj) throws Throwable {
        return !test(obj);
    }

    /* access modifiers changed from: private */
    /* synthetic */ boolean lambda$or$4(FailablePredicate failablePredicate, Object obj) throws Throwable {
        return test(obj) || failablePredicate.test(obj);
    }

    /* access modifiers changed from: private */
    static /* synthetic */ boolean lambda$static$0(Object obj) throws Throwable {
        return false;
    }

    /* access modifiers changed from: private */
    static /* synthetic */ boolean lambda$static$1(Object obj) throws Throwable {
        return true;
    }

    static <T, E extends Throwable> FailablePredicate<T, E> truePredicate() {
        return TRUE;
    }

    FailablePredicate<T, E> and(FailablePredicate<? super T, E> failablePredicate) {
        Objects.requireNonNull(failablePredicate);
        return new e2(this, failablePredicate);
    }

    FailablePredicate<T, E> negate() {
        return new h2(this);
    }

    FailablePredicate<T, E> or(FailablePredicate<? super T, E> failablePredicate) {
        Objects.requireNonNull(failablePredicate);
        return new d2(this, failablePredicate);
    }

    boolean test(T t) throws Throwable;
}
