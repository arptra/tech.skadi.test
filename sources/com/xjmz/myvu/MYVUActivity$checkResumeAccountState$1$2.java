package com.xjmz.myvu;

import android.app.Application;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.MainApplication;
import com.xjmz.myvu.account.UserLogOutHelper;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class MYVUActivity$checkResumeAccountState$1$2 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ MYVUActivity this$0;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.xjmz.myvu.MYVUActivity$checkResumeAccountState$1$2$1", f = "MYVUActivity.kt", i = {}, l = {1035}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.xjmz.myvu.MYVUActivity$checkResumeAccountState$1$2$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(mYVUActivity, continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Application application = mYVUActivity.getApplication();
                Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.upuphone.xr.sapp.MainApplication");
                MainApplication mainApplication = (MainApplication) application;
                if (mainApplication.x()) {
                    mainApplication.A(false);
                    ULog.f6446a.a("MYVUActivity", "isStartCold 应用是冷启动");
                    UserLogOutHelper userLogOutHelper = new UserLogOutHelper();
                    this.label = 1;
                    if (userLogOutHelper.d(this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    ULog.f6446a.a("MYVUActivity", "isStartCold 应用不是冷启动");
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
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MYVUActivity$checkResumeAccountState$1$2(MYVUActivity mYVUActivity) {
        super(1);
        this.this$0 = mYVUActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Throwable th) {
        LifecycleCoroutineScope a2 = LifecycleOwnerKt.a(this.this$0);
        CoroutineDispatcher b = Dispatchers.b();
        final MYVUActivity mYVUActivity = this.this$0;
        Job unused = BuildersKt__Builders_commonKt.d(a2, b, (CoroutineStart) null, new AnonymousClass1((Continuation<? super AnonymousClass1>) null), 2, (Object) null);
    }
}
