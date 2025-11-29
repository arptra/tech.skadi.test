package com.honey.account.x4;

import com.upuphone.ar.transcribe.phone.helper.TitleGenerator;
import java.util.function.Predicate;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class c implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f5306a;

    public /* synthetic */ c(Function1 function1) {
        this.f5306a = function1;
    }

    public final boolean test(Object obj) {
        return TitleGenerator.e(this.f5306a, obj);
    }
}
