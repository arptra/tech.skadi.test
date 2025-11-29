package com.upuphone.ar.tici.phone.starrynet;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.tici.phone.starrynet.TiciMessageHelper", f = "TiciMessageHelper.kt", i = {}, l = {218}, m = "sendAndWaitForMsgId-hUnOzRk", n = {}, s = {})
public final class TiciMessageHelper$sendAndWaitForMsgId$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TiciMessageHelper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TiciMessageHelper$sendAndWaitForMsgId$1(TiciMessageHelper ticiMessageHelper, Continuation<? super TiciMessageHelper$sendAndWaitForMsgId$1> continuation) {
        super(continuation);
        this.this$0 = ticiMessageHelper;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object d = this.this$0.d((String) null, (String) null, (String) null, (String) null, 0, this);
        return d == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? d : Result.m19boximpl(d);
    }
}
