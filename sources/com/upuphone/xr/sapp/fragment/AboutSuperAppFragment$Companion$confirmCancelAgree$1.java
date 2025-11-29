package com.upuphone.xr.sapp.fragment;

import android.content.Context;
import com.upuphone.xr.sapp.MainApplication;
import com.upuphone.xr.sapp.fragment.AboutSuperAppFragment;
import com.upuphone.xr.sapp.utils.AppUtils;
import com.upuphone.xr.sapp.utils.HttpRequestUtil;
import com.upuphone.xr.sapp.vu.utils.ArSpaceUtil;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.fragment.AboutSuperAppFragment$Companion$confirmCancelAgree$1", f = "AboutSuperAppFragment.kt", i = {}, l = {139}, m = "invokeSuspend", n = {}, s = {})
public final class AboutSuperAppFragment$Companion$confirmCancelAgree$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AboutSuperAppFragment$Companion$confirmCancelAgree$1(Context context, Continuation<? super AboutSuperAppFragment$Companion$confirmCancelAgree$1> continuation) {
        super(2, continuation);
        this.$context = context;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new AboutSuperAppFragment$Companion$confirmCancelAgree$1(this.$context, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            HttpRequestUtil httpRequestUtil = HttpRequestUtil.f7890a;
            this.label = 1;
            if (httpRequestUtil.t("3", this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        AboutSuperAppFragment.Companion companion = AboutSuperAppFragment.l;
        if (companion.j()) {
            AppUtils.f7842a.a(this.$context);
            companion.g(AboutSuperAppFragment.m, this.$context);
            ArSpaceUtil.f8089a.e();
        }
        MainApplication.k.f().p();
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((AboutSuperAppFragment$Companion$confirmCancelAgree$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
