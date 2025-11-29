package com.upuphone.star.fota.phone.utils;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import okhttp3.Call;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.star.fota.phone.utils.CallExtKt", f = "CallExt.kt", i = {0}, l = {51}, m = "awaitResponseResult", n = {"$this$awaitResponseResult"}, s = {"L$0"})
public final class CallExtKt$awaitResponseResult$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    public CallExtKt$awaitResponseResult$1(Continuation<? super CallExtKt$awaitResponseResult$1> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object a2 = CallExtKt.a((Call) null, this);
        return a2 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? a2 : Result.m19boximpl(a2);
    }
}
