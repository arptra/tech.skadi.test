package com.upuphone.ar.translation.utils;

import android.content.Context;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.translation.utils.NetworkUtils", f = "NetworkUtils.kt", i = {0}, l = {84}, m = "isInternalNetworkCapabilities", n = {"callback"}, s = {"L$0"})
public final class NetworkUtils$isInternalNetworkCapabilities$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ NetworkUtils this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NetworkUtils$isInternalNetworkCapabilities$1(NetworkUtils networkUtils, Continuation<? super NetworkUtils$isInternalNetworkCapabilities$1> continuation) {
        super(continuation);
        this.this$0 = networkUtils;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.b((Context) null, (Function1) null, this);
    }
}
