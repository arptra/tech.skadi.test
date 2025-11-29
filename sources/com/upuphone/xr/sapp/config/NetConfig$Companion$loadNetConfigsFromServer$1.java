package com.upuphone.xr.sapp.config;

import com.upuphone.xr.sapp.config.NetConfig;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.config.NetConfig$Companion", f = "NetConfig.kt", i = {0}, l = {258, 313}, m = "loadNetConfigsFromServer", n = {"this"}, s = {"L$0"})
public final class NetConfig$Companion$loadNetConfigsFromServer$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ NetConfig.Companion this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NetConfig$Companion$loadNetConfigsFromServer$1(NetConfig.Companion companion, Continuation<? super NetConfig$Companion$loadNetConfigsFromServer$1> continuation) {
        super(continuation);
        this.this$0 = companion;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.y(this);
    }
}
