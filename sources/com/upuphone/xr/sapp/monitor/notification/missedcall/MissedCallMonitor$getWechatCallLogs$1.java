package com.upuphone.xr.sapp.monitor.notification.missedcall;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.monitor.notification.missedcall.MissedCallMonitor", f = "MissedCallMonitor.kt", i = {1}, l = {243, 254}, m = "getWechatCallLogs", n = {"map"}, s = {"L$0"})
public final class MissedCallMonitor$getWechatCallLogs$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MissedCallMonitor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MissedCallMonitor$getWechatCallLogs$1(MissedCallMonitor missedCallMonitor, Continuation<? super MissedCallMonitor$getWechatCallLogs$1> continuation) {
        super(continuation);
        this.this$0 = missedCallMonitor;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.g(this);
    }
}
