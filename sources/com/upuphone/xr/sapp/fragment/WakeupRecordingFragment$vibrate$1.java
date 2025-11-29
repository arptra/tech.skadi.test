package com.upuphone.xr.sapp.fragment;

import android.content.Context;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.os.VibratorManager;
import com.honey.account.h8.jb;
import com.honey.account.h8.ta;
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
@DebugMetadata(c = "com.upuphone.xr.sapp.fragment.WakeupRecordingFragment$vibrate$1", f = "WakeupRecordingFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class WakeupRecordingFragment$vibrate$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ WakeupRecordingFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WakeupRecordingFragment$vibrate$1(WakeupRecordingFragment wakeupRecordingFragment, Continuation<? super WakeupRecordingFragment$vibrate$1> continuation) {
        super(2, continuation);
        this.this$0 = wakeupRecordingFragment;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new WakeupRecordingFragment$vibrate$1(this.this$0, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            Vibrator vibrator = null;
            if (Build.VERSION.SDK_INT >= 31) {
                Context context = this.this$0.getContext();
                Object systemService = context != null ? context.getSystemService("vibrator_manager") : null;
                VibratorManager a2 = jb.a(systemService) ? ta.a(systemService) : null;
                if (a2 != null) {
                    vibrator = a2.getDefaultVibrator();
                }
            } else {
                Context context2 = this.this$0.getContext();
                Object systemService2 = context2 != null ? context2.getSystemService("vibrator") : null;
                if (systemService2 instanceof Vibrator) {
                    vibrator = (Vibrator) systemService2;
                }
            }
            if (vibrator != null) {
                vibrator.vibrate(VibrationEffect.createOneShot(300, -1));
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((WakeupRecordingFragment$vibrate$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
