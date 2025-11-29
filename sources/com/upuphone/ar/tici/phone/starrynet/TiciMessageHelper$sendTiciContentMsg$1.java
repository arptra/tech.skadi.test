package com.upuphone.ar.tici.phone.starrynet;

import com.upuphone.ar.tici.phone.starrynet.msg.SendContentMsg;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.tici.phone.starrynet.TiciMessageHelper", f = "TiciMessageHelper.kt", i = {}, l = {34}, m = "sendTiciContentMsg-0E7RQCE", n = {}, s = {})
public final class TiciMessageHelper$sendTiciContentMsg$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TiciMessageHelper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TiciMessageHelper$sendTiciContentMsg$1(TiciMessageHelper ticiMessageHelper, Continuation<? super TiciMessageHelper$sendTiciContentMsg$1> continuation) {
        super(continuation);
        this.this$0 = ticiMessageHelper;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object g = this.this$0.g((SendContentMsg) null, 0, this);
        return g == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? g : Result.m19boximpl(g);
    }
}
