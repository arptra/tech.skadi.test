package com.xjmz.myvu;

import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.utils.AppUtils;
import com.upuphone.xr.sapp.vm.internal.SuperMessageManger;
import com.xjmz.myvu.account.AccountManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.xjmz.myvu.MYVUActivity$checkResumeAccountState$1$1", f = "MYVUActivity.kt", i = {}, l = {1018}, m = "invokeSuspend", n = {}, s = {})
public final class MYVUActivity$checkResumeAccountState$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ MYVUActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MYVUActivity$checkResumeAccountState$1$1(MYVUActivity mYVUActivity, Continuation<? super MYVUActivity$checkResumeAccountState$1$1> continuation) {
        super(2, continuation);
        this.this$0 = mYVUActivity;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new MYVUActivity$checkResumeAccountState$1$1(this.this$0, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ULog.Delegate delegate = ULog.f6446a;
            boolean H0 = this.this$0.l;
            delegate.g("MYVUActivity", "checkResumeAccountState() forceInvalidate: " + H0);
            AccountManager accountManager = AccountManager.f8217a;
            boolean H02 = this.this$0.l;
            final MYVUActivity mYVUActivity = this.this$0;
            AnonymousClass1 r3 = new Function1<Boolean, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke(((Boolean) obj).booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z) {
                    ULog.Delegate delegate = ULog.f6446a;
                    delegate.g("MYVUActivity", "checkResumeAccountState() called: " + z);
                    mYVUActivity.l = false;
                    if (z) {
                        SuperMessageManger.m.a().e0();
                        return;
                    }
                    delegate.g("MYVUActivity", "checkResumeAccountState-> 没有登录状态, 解绑");
                    AppUtils.f7842a.s();
                }
            };
            this.label = 1;
            if (accountManager.u(H02, r3, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((MYVUActivity$checkResumeAccountState$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
