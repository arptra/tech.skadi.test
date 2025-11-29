package com.xjsd.ai.assistant.accessibility.utils;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\b\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "T", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.xjsd.ai.assistant.accessibility.utils.AccessibilityOperateUtilKt$findWithTimeout$2", f = "AccessibilityOperateUtil.kt", i = {}, l = {53}, m = "invokeSuspend", n = {}, s = {})
final class AccessibilityOperateUtilKt$findWithTimeout$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<Object>, Object> {
    final /* synthetic */ long $delayMillis;
    final /* synthetic */ Function1<Object, Boolean> $judgeBlock;
    final /* synthetic */ Function0<Object> $this_findWithTimeout;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AccessibilityOperateUtilKt$findWithTimeout$2(Function0<Object> function0, Function1<Object, Boolean> function1, long j, Continuation<? super AccessibilityOperateUtilKt$findWithTimeout$2> continuation) {
        super(2, continuation);
        this.$this_findWithTimeout = function0;
        this.$judgeBlock = function1;
        this.$delayMillis = j;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new AccessibilityOperateUtilKt$findWithTimeout$2(this.$this_findWithTimeout, this.$judgeBlock, this.$delayMillis, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        long j;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0 || i == 1) {
            ResultKt.throwOnFailure(obj);
            do {
                Object invoke = this.$this_findWithTimeout.invoke();
                if (this.$judgeBlock.invoke(invoke).booleanValue()) {
                    return invoke;
                }
                j = this.$delayMillis;
                this.label = 1;
            } while (DelayKt.b(j, this) != coroutine_suspended);
            return coroutine_suspended;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<Object> continuation) {
        return ((AccessibilityOperateUtilKt$findWithTimeout$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
