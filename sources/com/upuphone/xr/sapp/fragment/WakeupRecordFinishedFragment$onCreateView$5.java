package com.upuphone.xr.sapp.fragment;

import com.upuphone.xr.sapp.databinding.WakeupRecordFinishedFragmentBinding;
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
@DebugMetadata(c = "com.upuphone.xr.sapp.fragment.WakeupRecordFinishedFragment$onCreateView$5", f = "WakeupRecordFinishedFragment.kt", i = {}, l = {70}, m = "invokeSuspend", n = {}, s = {})
public final class WakeupRecordFinishedFragment$onCreateView$5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ WakeupRecordFinishedFragmentBinding $binding;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WakeupRecordFinishedFragment$onCreateView$5(WakeupRecordFinishedFragmentBinding wakeupRecordFinishedFragmentBinding, Continuation<? super WakeupRecordFinishedFragment$onCreateView$5> continuation) {
        super(2, continuation);
        this.$binding = wakeupRecordFinishedFragmentBinding;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new WakeupRecordFinishedFragment$onCreateView$5(this.$binding, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (DelayKt.b(400, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.$binding.e.playAnimation();
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((WakeupRecordFinishedFragment$onCreateView$5) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
