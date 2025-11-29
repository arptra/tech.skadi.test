package com.upuphone.xr.sapp.fragment;

import com.upuphone.star.core.log.ULog;
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
@DebugMetadata(c = "com.upuphone.xr.sapp.fragment.WakeupRecordMainFragment$jumpByCondition$1", f = "WakeupRecordMainFragment.kt", i = {}, l = {221}, m = "invokeSuspend", n = {}, s = {})
public final class WakeupRecordMainFragment$jumpByCondition$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ WakeupRecordMainFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WakeupRecordMainFragment$jumpByCondition$1(WakeupRecordMainFragment wakeupRecordMainFragment, Continuation<? super WakeupRecordMainFragment$jumpByCondition$1> continuation) {
        super(2, continuation);
        this.this$0 = wakeupRecordMainFragment;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new WakeupRecordMainFragment$jumpByCondition$1(this.this$0, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        ULog.Delegate delegate;
        String str;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ULog.Delegate delegate2 = ULog.f6446a;
            WakeupRecordMainFragment wakeupRecordMainFragment = this.this$0;
            this.L$0 = delegate2;
            this.L$1 = "WakeupRecordMainFragment";
            this.label = 1;
            Object F0 = wakeupRecordMainFragment.L0(this);
            if (F0 == coroutine_suspended) {
                return coroutine_suspended;
            }
            str = "WakeupRecordMainFragment";
            ULog.Delegate delegate3 = delegate2;
            obj = F0;
            delegate = delegate3;
        } else if (i == 1) {
            str = (String) this.L$1;
            delegate = (ULog.Delegate) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        delegate.a(str, "isFlmWakeupOn: " + obj);
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((WakeupRecordMainFragment$jumpByCondition$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
