package com.honey.account.m3;

import com.upuphone.ai.NlgService;
import java.util.function.BiConsumer;
import kotlin.jvm.functions.Function2;

public final /* synthetic */ class a implements BiConsumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function2 f4939a;

    public /* synthetic */ a(Function2 function2) {
        this.f4939a = function2;
    }

    public final void accept(Object obj, Object obj2) {
        NlgService.g(this.f4939a, obj, obj2);
    }
}
