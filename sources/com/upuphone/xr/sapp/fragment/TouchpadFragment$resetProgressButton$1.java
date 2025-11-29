package com.upuphone.xr.sapp.fragment;

import androidx.core.content.ContextCompat;
import com.meizu.common.widget.CircularProgressButton;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.databinding.FragmentTouchpadBinding;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.fragment.TouchpadFragment$resetProgressButton$1", f = "TouchpadFragment.kt", i = {0, 1}, l = {458, 468}, m = "invokeSuspend", n = {"progressButton", "$this$invokeSuspend_u24lambda_u240"}, s = {"L$0", "L$1"})
public final class TouchpadFragment$resetProgressButton$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $delayTime;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ TouchpadFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TouchpadFragment$resetProgressButton$1(TouchpadFragment touchpadFragment, long j, Continuation<? super TouchpadFragment$resetProgressButton$1> continuation) {
        super(2, continuation);
        this.this$0 = touchpadFragment;
        this.$delayTime = j;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TouchpadFragment$resetProgressButton$1(this.this$0, this.$delayTime, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        CircularProgressButton circularProgressButton;
        CircularProgressButton circularProgressButton2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            FragmentTouchpadBinding H0 = this.this$0.j;
            if (H0 == null || (circularProgressButton2 = H0.d) == null) {
                return Unit.INSTANCE;
            }
            ULog.Delegate delegate = ULog.f6446a;
            long j = this.$delayTime;
            delegate.a("TouchpadFragment", "resetProgressButton-delay, delayTime: " + j);
            long max = Math.max(this.$delayTime, 20);
            this.L$0 = circularProgressButton2;
            this.label = 1;
            if (DelayKt.b(max, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
            circularProgressButton2 = (CircularProgressButton) this.L$0;
        } else if (i == 2) {
            circularProgressButton = (CircularProgressButton) this.L$1;
            CircularProgressButton circularProgressButton3 = (CircularProgressButton) this.L$0;
            ResultKt.throwOnFailure(obj);
            circularProgressButton.setBackground(ContextCompat.getDrawable(circularProgressButton.getContext(), R.drawable.touchpad_screen_shot));
            ULog.Delegate delegate2 = ULog.f6446a;
            CircularProgressButton.State state = circularProgressButton.getState();
            int progress = circularProgressButton.getProgress();
            delegate2.a("TouchpadFragment", "resetProgressButton-after, state: " + state + ", progress: " + progress);
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ULog.Delegate delegate3 = ULog.f6446a;
        CircularProgressButton.State state2 = circularProgressButton2.getState();
        int progress2 = circularProgressButton2.getProgress();
        delegate3.a("TouchpadFragment", "resetProgressButton-before, state: " + state2 + ", progress: " + progress2);
        circularProgressButton2.setProgress(0, false);
        circularProgressButton2.setState(CircularProgressButton.State.IDLE, false, false);
        this.L$0 = circularProgressButton2;
        this.L$1 = circularProgressButton2;
        this.label = 2;
        if (DelayKt.b(20, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        circularProgressButton = circularProgressButton2;
        circularProgressButton.setBackground(ContextCompat.getDrawable(circularProgressButton.getContext(), R.drawable.touchpad_screen_shot));
        ULog.Delegate delegate22 = ULog.f6446a;
        CircularProgressButton.State state3 = circularProgressButton.getState();
        int progress3 = circularProgressButton.getProgress();
        delegate22.a("TouchpadFragment", "resetProgressButton-after, state: " + state3 + ", progress: " + progress3);
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TouchpadFragment$resetProgressButton$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
