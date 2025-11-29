package org.apache.commons.lang3.compare;

import com.honey.account.zb.a;
import com.honey.account.zb.b;
import com.honey.account.zb.c;
import com.honey.account.zb.d;
import com.honey.account.zb.e;
import com.honey.account.zb.f;
import java.util.function.Predicate;

public class ComparableUtils {

    public static class ComparableCheckBuilder<A extends Comparable<A>> {

        /* renamed from: a  reason: collision with root package name */
        private final A f9150a;

        private boolean betweenOrdered(A a2, A a3) {
            return greaterThanOrEqualTo(a2) && lessThanOrEqualTo(a3);
        }

        private boolean betweenOrderedExclusive(A a2, A a3) {
            return greaterThan(a2) && lessThan(a3);
        }

        public boolean between(A a2, A a3) {
            return betweenOrdered(a2, a3) || betweenOrdered(a3, a2);
        }

        public boolean betweenExclusive(A a2, A a3) {
            return betweenOrderedExclusive(a2, a3) || betweenOrderedExclusive(a3, a2);
        }

        public boolean equalTo(A a2) {
            return this.f9150a.compareTo(a2) == 0;
        }

        public boolean greaterThan(A a2) {
            return this.f9150a.compareTo(a2) > 0;
        }

        public boolean greaterThanOrEqualTo(A a2) {
            return this.f9150a.compareTo(a2) >= 0;
        }

        public boolean lessThan(A a2) {
            return this.f9150a.compareTo(a2) < 0;
        }

        public boolean lessThanOrEqualTo(A a2) {
            return this.f9150a.compareTo(a2) <= 0;
        }

        private ComparableCheckBuilder(A a2) {
            this.f9150a = a2;
        }
    }

    private ComparableUtils() {
    }

    public static <A extends Comparable<A>> Predicate<A> between(A a2, A a3) {
        return new c(a2, a3);
    }

    public static <A extends Comparable<A>> Predicate<A> betweenExclusive(A a2, A a3) {
        return new d(a2, a3);
    }

    public static <A extends Comparable<A>> Predicate<A> ge(A a2) {
        return new a(a2);
    }

    public static <A extends Comparable<A>> Predicate<A> gt(A a2) {
        return new b(a2);
    }

    public static <A extends Comparable<A>> ComparableCheckBuilder<A> is(A a2) {
        return new ComparableCheckBuilder<>(a2);
    }

    public static <A extends Comparable<A>> Predicate<A> le(A a2) {
        return new f(a2);
    }

    public static <A extends Comparable<A>> Predicate<A> lt(A a2) {
        return new e(a2);
    }
}
