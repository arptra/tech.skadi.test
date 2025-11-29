package org.apache.commons.lang3.function;

import com.honey.account.dc.a0;
import com.honey.account.dc.b0;
import com.honey.account.dc.c0;
import com.honey.account.dc.d0;
import com.honey.account.dc.z;
import java.lang.Throwable;
import java.util.Objects;

@FunctionalInterface
public interface FailableBiPredicate<T, U, E extends Throwable> {
    public static final FailableBiPredicate FALSE = new c0();
    public static final FailableBiPredicate TRUE = new d0();

    static <T, U, E extends Throwable> FailableBiPredicate<T, U, E> falsePredicate() {
        return FALSE;
    }

    /* access modifiers changed from: private */
    /* synthetic */ boolean lambda$and$2(FailableBiPredicate failableBiPredicate, Object obj, Object obj2) throws Throwable {
        return test(obj, obj2) && failableBiPredicate.test(obj, obj2);
    }

    /* access modifiers changed from: private */
    /* synthetic */ boolean lambda$negate$3(Object obj, Object obj2) throws Throwable {
        return !test(obj, obj2);
    }

    /* access modifiers changed from: private */
    /* synthetic */ boolean lambda$or$4(FailableBiPredicate failableBiPredicate, Object obj, Object obj2) throws Throwable {
        return test(obj, obj2) || failableBiPredicate.test(obj, obj2);
    }

    /* access modifiers changed from: private */
    static /* synthetic */ boolean lambda$static$0(Object obj, Object obj2) throws Throwable {
        return false;
    }

    /* access modifiers changed from: private */
    static /* synthetic */ boolean lambda$static$1(Object obj, Object obj2) throws Throwable {
        return true;
    }

    static <T, U, E extends Throwable> FailableBiPredicate<T, U, E> truePredicate() {
        return TRUE;
    }

    FailableBiPredicate<T, U, E> and(FailableBiPredicate<? super T, ? super U, E> failableBiPredicate) {
        Objects.requireNonNull(failableBiPredicate);
        return new a0(this, failableBiPredicate);
    }

    FailableBiPredicate<T, U, E> negate() {
        return new z(this);
    }

    FailableBiPredicate<T, U, E> or(FailableBiPredicate<? super T, ? super U, E> failableBiPredicate) {
        Objects.requireNonNull(failableBiPredicate);
        return new b0(this, failableBiPredicate);
    }

    boolean test(T t, U u) throws Throwable;
}
