package com.honey.account.q;

import android.content.ClipData;
import androidx.core.util.Predicate;

public final /* synthetic */ class b implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ java.util.function.Predicate f3076a;

    public /* synthetic */ b(java.util.function.Predicate predicate) {
        this.f3076a = predicate;
    }

    public final boolean test(Object obj) {
        return this.f3076a.test((ClipData.Item) obj);
    }
}
