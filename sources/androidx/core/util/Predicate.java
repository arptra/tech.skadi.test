package androidx.core.util;

import android.annotation.SuppressLint;

@SuppressLint({"UnknownNullness"})
public interface Predicate<T> {
    boolean test(Object obj);
}
