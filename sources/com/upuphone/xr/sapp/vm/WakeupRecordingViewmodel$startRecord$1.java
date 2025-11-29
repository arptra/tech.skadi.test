package com.upuphone.xr.sapp.vm;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.vm.WakeupRecordingViewmodel", f = "WakeupRecordingViewmodel.kt", i = {0}, l = {193}, m = "startRecord", n = {"this"}, s = {"L$0"})
public final class WakeupRecordingViewmodel$startRecord$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ WakeupRecordingViewmodel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WakeupRecordingViewmodel$startRecord$1(WakeupRecordingViewmodel wakeupRecordingViewmodel, Continuation<? super WakeupRecordingViewmodel$startRecord$1> continuation) {
        super(continuation);
        this.this$0 = wakeupRecordingViewmodel;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.X(this);
    }
}
