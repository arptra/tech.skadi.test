package com.honey.account.o3;

import com.upuphone.ai.ttsengine.base.service.RequestQueue;
import java.util.function.Predicate;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class a implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f4966a;

    public /* synthetic */ a(Function1 function1) {
        this.f4966a = function1;
    }

    public final boolean test(Object obj) {
        return RequestQueue.d(this.f4966a, obj);
    }
}
