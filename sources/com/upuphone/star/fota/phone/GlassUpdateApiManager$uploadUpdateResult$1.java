package com.upuphone.star.fota.phone;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.star.fota.phone.GlassUpdateApiManager", f = "GlassUpdateApiManager.kt", i = {0, 0, 0, 1}, l = {181, 186}, m = "uploadUpdateResult", n = {"this_$iv", "url$iv", "params$iv", "this_$iv"}, s = {"L$0", "L$1", "L$2", "L$0"})
public final class GlassUpdateApiManager$uploadUpdateResult$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GlassUpdateApiManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GlassUpdateApiManager$uploadUpdateResult$1(GlassUpdateApiManager glassUpdateApiManager, Continuation<? super GlassUpdateApiManager$uploadUpdateResult$1> continuation) {
        super(continuation);
        this.this$0 = glassUpdateApiManager;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.k((GlassUpdateResultParam) null, this);
    }
}
