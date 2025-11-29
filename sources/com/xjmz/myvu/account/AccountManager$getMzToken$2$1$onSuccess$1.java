package com.xjmz.myvu.account;

import android.content.Intent;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.monitor.net.TokenUtil;
import com.xjmz.myvu.account.MzTokenResult;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.xjmz.myvu.account.AccountManager$getMzToken$2$1$onSuccess$1", f = "AccountManager.kt", i = {}, l = {328}, m = "invokeSuspend", n = {}, s = {})
public final class AccountManager$getMzToken$2$1$onSuccess$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CancellableContinuation<MzTokenResult> $continuation;
    final /* synthetic */ boolean $forceInvalidate;
    final /* synthetic */ String $token;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AccountManager$getMzToken$2$1$onSuccess$1(boolean z, String str, CancellableContinuation<? super MzTokenResult> cancellableContinuation, Continuation<? super AccountManager$getMzToken$2$1$onSuccess$1> continuation) {
        super(2, continuation);
        this.$forceInvalidate = z;
        this.$token = str;
        this.$continuation = cancellableContinuation;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new AccountManager$getMzToken$2$1$onSuccess$1(this.$forceInvalidate, this.$token, this.$continuation, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        String str;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.$forceInvalidate && (str = this.$token) != null && !StringsKt.isBlank(str)) {
                ULog.f6446a.g("AccountManager", "getMzToken onSuccess() refresh gwToken...");
                TokenUtil tokenUtil = TokenUtil.f7744a;
                String str2 = this.$token;
                this.label = 1;
                if (tokenUtil.m(str2, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        CancellableContinuation<MzTokenResult> cancellableContinuation = this.$continuation;
        Result.Companion companion = Result.Companion;
        cancellableContinuation.resumeWith(Result.m20constructorimpl(new MzTokenResult(1, this.$token, (Intent) null, (MzTokenResult.OriginError) null, 12, (DefaultConstructorMarker) null)));
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((AccountManager$getMzToken$2$1$onSuccess$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
