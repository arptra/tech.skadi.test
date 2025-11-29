package com.upuphone.xr.sapp.datatrack;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.datatrack.DataTrackRuleHelper", f = "DataTrackRuleHelper.kt", i = {}, l = {221}, m = "shouldBlockEvent", n = {}, s = {})
public final class DataTrackRuleHelper$shouldBlockEvent$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DataTrackRuleHelper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DataTrackRuleHelper$shouldBlockEvent$1(DataTrackRuleHelper dataTrackRuleHelper, Continuation<? super DataTrackRuleHelper$shouldBlockEvent$1> continuation) {
        super(continuation);
        this.this$0 = dataTrackRuleHelper;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.p((String) null, this);
    }
}
