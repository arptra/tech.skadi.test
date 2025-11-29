package com.upuphone.xr.sapp.vu.utils;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.vu.utils.VuScreenRecordHelper", f = "VuScreenRecordHelper.kt", i = {0, 0, 0}, l = {166}, m = "endScreenRecord", n = {"this", "$this$endScreenRecord_u24lambda_u240", "file"}, s = {"L$0", "L$1", "L$2"})
public final class VuScreenRecordHelper$endScreenRecord$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ VuScreenRecordHelper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VuScreenRecordHelper$endScreenRecord$1(VuScreenRecordHelper vuScreenRecordHelper, Continuation<? super VuScreenRecordHelper$endScreenRecord$1> continuation) {
        super(continuation);
        this.this$0 = vuScreenRecordHelper;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.A(this);
    }
}
