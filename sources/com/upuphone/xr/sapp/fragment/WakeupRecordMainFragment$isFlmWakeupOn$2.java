package com.upuphone.xr.sapp.fragment;

import android.os.Bundle;
import com.upuphone.star.core.log.ULog;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.fragment.WakeupRecordMainFragment$isFlmWakeupOn$2", f = "WakeupRecordMainFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class WakeupRecordMainFragment$isFlmWakeupOn$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    int label;
    final /* synthetic */ WakeupRecordMainFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WakeupRecordMainFragment$isFlmWakeupOn$2(WakeupRecordMainFragment wakeupRecordMainFragment, Continuation<? super WakeupRecordMainFragment$isFlmWakeupOn$2> continuation) {
        super(2, continuation);
        this.this$0 = wakeupRecordMainFragment;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new WakeupRecordMainFragment$isFlmWakeupOn$2(this.this$0, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            Bundle bundle = new Bundle();
            bundle.putString("sp_name", "voice_wake_up_sp");
            bundle.putString("sp_key", "voice_switch_ver410");
            bundle.putString("data_type", "boolean");
            boolean z = false;
            try {
                Bundle call = this.this$0.requireContext().getContentResolver().call("com.qualcomm.qti.sva.provider.SETTINGS", "getSharedPreferences", (String) null, bundle);
                if (call != null) {
                    z = call.getBoolean("result");
                }
            } catch (Exception e) {
                ULog.Delegate delegate = ULog.f6446a;
                String message = e.getMessage();
                delegate.c("WakeupRecordMainFragment", "call provider method error: " + message);
            }
            return Boxing.boxBoolean(z);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Boolean> continuation) {
        return ((WakeupRecordMainFragment$isFlmWakeupOn$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
