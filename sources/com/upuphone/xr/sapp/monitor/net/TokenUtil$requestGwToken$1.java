package com.upuphone.xr.sapp.monitor.net;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.monitor.net.TokenUtil", f = "TokenUtil.kt", i = {0}, l = {359}, m = "requestGwToken", n = {"this"}, s = {"L$0"})
public final class TokenUtil$requestGwToken$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TokenUtil this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TokenUtil$requestGwToken$1(TokenUtil tokenUtil, Continuation<? super TokenUtil$requestGwToken$1> continuation) {
        super(continuation);
        this.this$0 = tokenUtil;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.l((String) null, this);
    }
}
