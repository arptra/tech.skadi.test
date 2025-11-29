package com.upuphone.xr.sapp.fragment;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.fragment.FeedBackFragment", f = "FeedBackFragment.kt", i = {0, 1, 1, 2, 2, 3, 3, 3, 4, 5}, l = {661, 675, 676, 700, 718, 719}, m = "submitFeedBack", n = {"this", "this", "paramsHashMap", "this", "paramsHashMap", "this", "paramsHashMap", "deviceInfo", "this", "this"}, s = {"L$0", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$2", "L$0", "L$0"})
public final class FeedBackFragment$submitFeedBack$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FeedBackFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FeedBackFragment$submitFeedBack$1(FeedBackFragment feedBackFragment, Continuation<? super FeedBackFragment$submitFeedBack$1> continuation) {
        super(continuation);
        this.this$0 = feedBackFragment;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.H1(this);
    }
}
