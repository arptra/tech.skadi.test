package com.upuphone.xr.sapp.fragment;

import com.alibaba.fastjson.asm.Opcodes;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.utils.StaticMethodUtilsKt;
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
@DebugMetadata(c = "com.upuphone.xr.sapp.fragment.WakeupRecordMainFragment$jumpByCondition$2", f = "WakeupRecordMainFragment.kt", i = {}, l = {229}, m = "invokeSuspend", n = {}, s = {})
public final class WakeupRecordMainFragment$jumpByCondition$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ WakeupRecordMainFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WakeupRecordMainFragment$jumpByCondition$2(WakeupRecordMainFragment wakeupRecordMainFragment, Continuation<? super WakeupRecordMainFragment$jumpByCondition$2> continuation) {
        super(2, continuation);
        this.this$0 = wakeupRecordMainFragment;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new WakeupRecordMainFragment$jumpByCondition$2(this.this$0, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            WakeupRecordMainFragment wakeupRecordMainFragment = this.this$0;
            this.label = 1;
            obj = wakeupRecordMainFragment.L0(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (((Boolean) obj).booleanValue()) {
            this.this$0.T0(Opcodes.IFNONNULL);
        } else {
            StaticMethodUtilsKt.t(this.this$0, R.id.wakeupRecordingFragment);
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((WakeupRecordMainFragment$jumpByCondition$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
