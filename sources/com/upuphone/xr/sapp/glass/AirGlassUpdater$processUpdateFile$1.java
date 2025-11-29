package com.upuphone.xr.sapp.glass;

import java.io.File;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.glass.AirGlassUpdater", f = "AirGlassUpdater.kt", i = {}, l = {222}, m = "processUpdateFile", n = {}, s = {})
public final class AirGlassUpdater$processUpdateFile$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AirGlassUpdater this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AirGlassUpdater$processUpdateFile$1(AirGlassUpdater airGlassUpdater, Continuation<? super AirGlassUpdater$processUpdateFile$1> continuation) {
        super(continuation);
        this.this$0 = airGlassUpdater;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.O((File) null, this);
    }
}
