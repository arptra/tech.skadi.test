package com.upuphone.xr.sapp.air;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nAirHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AirHelper.kt\ncom/upuphone/xr/sapp/air/AirHelper$waitForGlassUpdateAppReady$2\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,576:1\n314#2,11:577\n*S KotlinDebug\n*F\n+ 1 AirHelper.kt\ncom/upuphone/xr/sapp/air/AirHelper$waitForGlassUpdateAppReady$2\n*L\n274#1:577,11\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.air.AirHelper$waitForGlassUpdateAppReady$2", f = "AirHelper.kt", i = {}, l = {577}, m = "invokeSuspend", n = {}, s = {})
final class AirHelper$waitForGlassUpdateAppReady$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    int label;

    public AirHelper$waitForGlassUpdateAppReady$2(Continuation<? super AirHelper$waitForGlassUpdateAppReady$2> continuation) {
        super(2, continuation);
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new AirHelper$waitForGlassUpdateAppReady$2(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(this), 1);
            cancellableContinuationImpl.x();
            AirHelper$waitForGlassUpdateAppReady$2$1$listener$1 airHelper$waitForGlassUpdateAppReady$2$1$listener$1 = new AirHelper$waitForGlassUpdateAppReady$2$1$listener$1(cancellableContinuationImpl);
            AirHelper.b.l(airHelper$waitForGlassUpdateAppReady$2$1$listener$1);
            cancellableContinuationImpl.E(new AirHelper$waitForGlassUpdateAppReady$2$1$1(airHelper$waitForGlassUpdateAppReady$2$1$listener$1));
            obj = cancellableContinuationImpl.u();
            if (obj == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(this);
            }
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
        return ((AirHelper$waitForGlassUpdateAppReady$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
