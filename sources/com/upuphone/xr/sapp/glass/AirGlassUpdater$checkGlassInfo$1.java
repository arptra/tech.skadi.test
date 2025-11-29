package com.upuphone.xr.sapp.glass;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.glass.AirGlassUpdater", f = "AirGlassUpdater.kt", i = {0}, l = {169}, m = "checkGlassInfo", n = {"this"}, s = {"L$0"})
public final class AirGlassUpdater$checkGlassInfo$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AirGlassUpdater this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AirGlassUpdater$checkGlassInfo$1(AirGlassUpdater airGlassUpdater, Continuation<? super AirGlassUpdater$checkGlassInfo$1> continuation) {
        super(continuation);
        this.this$0 = airGlassUpdater;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.f(0, this);
    }
}
