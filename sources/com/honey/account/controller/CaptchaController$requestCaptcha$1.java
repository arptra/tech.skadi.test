package com.honey.account.controller;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.honey.account.controller.CaptchaController$requestCaptcha$1", f = "CaptchaController.kt", i = {}, l = {54}, m = "invokeSuspend", n = {}, s = {})
public final class CaptchaController$requestCaptcha$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    int label;

    public CaptchaController$requestCaptcha$1(Continuation<? super CaptchaController$requestCaptcha$1> continuation) {
        super(1, continuation);
    }

    @NotNull
    public final Continuation<Unit> create(@NotNull Continuation<?> continuation) {
        return new CaptchaController$requestCaptcha$1(continuation);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0020, code lost:
        r4 = (android.app.Activity) r4.get();
     */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r4) {
        /*
            r3 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r3.label
            r2 = 1
            if (r1 == 0) goto L_0x0017
            if (r1 != r2) goto L_0x000f
            kotlin.ResultKt.throwOnFailure(r4)
            goto L_0x0056
        L_0x000f:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            java.lang.String r4 = "call to 'resume' before 'invoke' with coroutine"
            r3.<init>(r4)
            throw r3
        L_0x0017:
            kotlin.ResultKt.throwOnFailure(r4)
            java.lang.ref.WeakReference r4 = com.honey.account.controller.CaptchaController.mContextWeakReference
            if (r4 == 0) goto L_0x0059
            java.lang.Object r4 = r4.get()
            android.app.Activity r4 = (android.app.Activity) r4
            if (r4 != 0) goto L_0x0029
            goto L_0x0059
        L_0x0029:
            boolean r1 = com.honey.account.utils.network.NetworkUtilsKt.isNetworkConnected(r4)
            if (r1 != 0) goto L_0x0048
            com.honey.account.controller.CaptchaController$Callback r3 = com.honey.account.controller.CaptchaController.mCallback
            if (r3 == 0) goto L_0x0045
            int r0 = com.honey.account.R.string.not_network
            java.lang.String r4 = r4.getString(r0)
            java.lang.String r0 = "getString(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r0)
            r0 = 500(0x1f4, float:7.0E-43)
            r3.onFailed(r0, r4)
        L_0x0045:
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
            return r3
        L_0x0048:
            com.honey.account.controller.CaptchaController$requestCaptcha$1$1 r1 = new com.honey.account.controller.CaptchaController$requestCaptcha$1$1
            r1.<init>(r4)
            r3.label = r2
            java.lang.Object r3 = com.honey.account.utils.coroutine.CoroutineUtilsKt.launchIO(r1, r3)
            if (r3 != r0) goto L_0x0056
            return r0
        L_0x0056:
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
            return r3
        L_0x0059:
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.honey.account.controller.CaptchaController$requestCaptcha$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object invoke(@Nullable Continuation<? super Unit> continuation) {
        return ((CaptchaController$requestCaptcha$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
