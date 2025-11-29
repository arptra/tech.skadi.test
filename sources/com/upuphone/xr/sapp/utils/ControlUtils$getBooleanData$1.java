package com.upuphone.xr.sapp.utils;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nControlUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ControlUtils.kt\ncom/upuphone/xr/sapp/utils/ControlUtils$getBooleanData$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n+ 4 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n*L\n1#1,1240:1\n53#2:1241\n55#2:1245\n50#3:1242\n55#3:1244\n107#4:1243\n*S KotlinDebug\n*F\n+ 1 ControlUtils.kt\ncom/upuphone/xr/sapp/utils/ControlUtils$getBooleanData$1\n*L\n1031#1:1241\n1031#1:1245\n1031#1:1242\n1031#1:1244\n1031#1:1243\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.utils.ControlUtils$getBooleanData$1", f = "ControlUtils.kt", i = {}, l = {1033}, m = "invokeSuspend", n = {}, s = {})
final class ControlUtils$getBooleanData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ boolean $default;
    final /* synthetic */ String $key;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ControlUtils$getBooleanData$1(String str, boolean z, Continuation<? super ControlUtils$getBooleanData$1> continuation) {
        super(2, continuation);
        this.$key = str;
        this.$default = z;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ControlUtils$getBooleanData$1(this.$key, this.$default, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ControlUtils$getBooleanData$1$invokeSuspend$$inlined$map$1 controlUtils$getBooleanData$1$invokeSuspend$$inlined$map$1 = new ControlUtils$getBooleanData$1$invokeSuspend$$inlined$map$1(ControlUtils.e.getData(), this.$key, this.$default);
            this.label = 1;
            obj = FlowKt.w(controlUtils$getBooleanData$1$invokeSuspend$$inlined$map$1, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return obj;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Boolean> continuation) {
        return ((ControlUtils$getBooleanData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
