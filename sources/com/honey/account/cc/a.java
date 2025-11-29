package com.honey.account.cc;

import java.util.function.Predicate;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.Pair;

public final /* synthetic */ class a implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f7217a;

    public /* synthetic */ a(String str) {
        this.f7217a = str;
    }

    public final boolean test(Object obj) {
        return StringUtils.equals(this.f7217a, (CharSequence) ((Pair) obj).getKey());
    }
}
