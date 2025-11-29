package com.honey.account.ka;

import com.xjsd.ai.assistant.phone.helper.HotWordMaintainer;
import java.util.function.Predicate;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class b implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f7458a;

    public /* synthetic */ b(Function1 function1) {
        this.f7458a = function1;
    }

    public final boolean test(Object obj) {
        return HotWordMaintainer.e(this.f7458a, obj);
    }
}
