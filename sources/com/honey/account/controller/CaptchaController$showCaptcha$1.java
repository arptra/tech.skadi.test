package com.honey.account.controller;

import android.app.Activity;
import android.util.Log;
import com.geetest.captcha.GTCaptcha4Client;
import com.honey.account.R;
import com.honey.account.controller.CaptchaController;
import com.honey.account.data.GeetestData;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.honey.account.controller.CaptchaController$showCaptcha$1", f = "CaptchaController.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class CaptchaController$showCaptcha$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ String $appId;
    final /* synthetic */ Activity $context;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CaptchaController$showCaptcha$1(Activity activity, String str, Continuation<? super CaptchaController$showCaptcha$1> continuation) {
        super(1, continuation);
        this.$context = activity;
        this.$appId = str;
    }

    /* access modifiers changed from: private */
    public static final void invokeSuspend$lambda$6$lambda$4(GTCaptcha4Client gTCaptcha4Client, Activity activity, boolean z, String str) {
        Unit unit;
        Log.d("CaptchaManager", "CaptchaManager addOnSuccessListener. status: " + z + ", callback: " + CaptchaController.mCallback + ", response: " + str);
        if (z) {
            GeetestData.Companion companion = GeetestData.Companion;
            Intrinsics.checkNotNull(str);
            GeetestData parseData = companion.parseData(str);
            if (parseData != null) {
                CaptchaController.Callback access$getMCallback$p = CaptchaController.mCallback;
                if (access$getMCallback$p != null) {
                    access$getMCallback$p.onSuccess(parseData);
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
                if (unit != null) {
                    return;
                }
            }
            CaptchaController.Callback access$getMCallback$p2 = CaptchaController.mCallback;
            if (access$getMCallback$p2 != null) {
                String string = activity.getString(R.string.not_network);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                access$getMCallback$p2.onFailed(500, string);
                Unit unit2 = Unit.INSTANCE;
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void invokeSuspend$lambda$6$lambda$5(String str) {
        Log.w("CaptchaManager", "CaptchaManager addOnFailureListener. msg: " + str);
    }

    @NotNull
    public final Continuation<Unit> create(@NotNull Continuation<?> continuation) {
        return new CaptchaController$showCaptcha$1(this.$context, this.$appId, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            Activity activity = this.$context;
            if (activity == null) {
                CaptchaController.Callback access$getMCallback$p = CaptchaController.mCallback;
                if (access$getMCallback$p != null) {
                    access$getMCallback$p.onFailed(500, "");
                }
                return Unit.INSTANCE;
            }
            String str = this.$appId;
            if (str == null) {
                CaptchaController.Callback access$getMCallback$p2 = CaptchaController.mCallback;
                if (access$getMCallback$p2 != null) {
                    access$getMCallback$p2.onFailed(500, "");
                }
                return Unit.INSTANCE;
            }
            GTCaptcha4Client access$newCaptcha4Client = CaptchaController.INSTANCE.newCaptcha4Client(activity, str);
            if (access$newCaptcha4Client != null) {
                access$newCaptcha4Client.g(new a(access$newCaptcha4Client, this.$context)).f(new b()).k();
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@Nullable Continuation<? super Unit> continuation) {
        return ((CaptchaController$showCaptcha$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
