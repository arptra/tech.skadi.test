package com.upuphone.xr.sapp.contract;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.contract.CheckNaviSupportController", f = "CheckNaviSupportController.kt", i = {}, l = {57}, m = "checkNaviRegionSupport", n = {}, s = {})
public final class CheckNaviSupportController$checkNaviRegionSupport$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CheckNaviSupportController this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CheckNaviSupportController$checkNaviRegionSupport$1(CheckNaviSupportController checkNaviSupportController, Continuation<? super CheckNaviSupportController$checkNaviRegionSupport$1> continuation) {
        super(continuation);
        this.this$0 = checkNaviSupportController;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a((String) null, this);
    }
}
