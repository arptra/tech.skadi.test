package com.upuphone.xr.interconnect.outer;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
public /* synthetic */ class DataBinderOperatorImpl$unset$1 extends FunctionReferenceImpl implements Function1<String, Unit> {
    public DataBinderOperatorImpl$unset$1(Object obj) {
        super(1, obj, DataBinderOperatorImpl.class, "logd", "logd(Ljava/lang/String;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "p0");
        ((DataBinderOperatorImpl) this.receiver).logd(str);
    }
}
