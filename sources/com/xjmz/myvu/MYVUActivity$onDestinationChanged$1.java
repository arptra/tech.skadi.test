package com.xjmz.myvu;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.databinding.ActivityMyvuBinding;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.xjmz.myvu.MYVUActivity$onDestinationChanged$1", f = "MYVUActivity.kt", i = {}, l = {871}, m = "invokeSuspend", n = {}, s = {})
public final class MYVUActivity$onDestinationChanged$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ MYVUActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MYVUActivity$onDestinationChanged$1(MYVUActivity mYVUActivity, Continuation<? super MYVUActivity$onDestinationChanged$1> continuation) {
        super(2, continuation);
        this.this$0 = mYVUActivity;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new MYVUActivity$onDestinationChanged$1(this.this$0, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ULog.f6446a.a("MYVUActivity", "执行动画 mz_activity_to_next_close_enter");
            if (this.this$0.s != -1) {
                Animation loadAnimation = AnimationUtils.loadAnimation(this.this$0, R.anim.next_close_enter);
                Intrinsics.checkNotNullExpressionValue(loadAnimation, "loadAnimation(...)");
                ActivityMyvuBinding E0 = this.this$0.d;
                if (E0 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    E0 = null;
                }
                E0.e.startAnimation(loadAnimation);
            }
            this.label = 1;
            if (DelayKt.b(300, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.this$0.A1(false);
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((MYVUActivity$onDestinationChanged$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
