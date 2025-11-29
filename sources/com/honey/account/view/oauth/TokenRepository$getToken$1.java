package com.honey.account.view.oauth;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.honey.account.view.oauth.TokenRepository", f = "TokenRepository.kt", i = {0}, l = {37}, m = "getToken-gIAlu-s", n = {"this"}, s = {"L$0"})
public final class TokenRepository$getToken$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TokenRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TokenRepository$getToken$1(TokenRepository tokenRepository, Continuation<? super TokenRepository$getToken$1> continuation) {
        super(continuation);
        this.this$0 = tokenRepository;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object r1 = this.this$0.m1732getTokengIAlus((String) null, this);
        return r1 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? r1 : Result.m19boximpl(r1);
    }
}
