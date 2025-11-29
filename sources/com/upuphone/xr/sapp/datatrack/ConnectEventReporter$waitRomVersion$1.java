package com.upuphone.xr.sapp.datatrack;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.datatrack.ConnectEventReporter", f = "ConnectEventReporter.kt", i = {}, l = {61}, m = "waitRomVersion", n = {}, s = {})
public final class ConnectEventReporter$waitRomVersion$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ConnectEventReporter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ConnectEventReporter$waitRomVersion$1(ConnectEventReporter connectEventReporter, Continuation<? super ConnectEventReporter$waitRomVersion$1> continuation) {
        super(continuation);
        this.this$0 = connectEventReporter;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.p(this);
    }
}
