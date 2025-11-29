package com.upuphone.xr.sapp.air;

import com.upuphone.xr.sapp.entity.BaseActionData;
import com.upuphone.xr.sapp.glass.GlassMessageHelper;
import com.upuphone.xr.sapp.glass.GlassMessageHelper$sendMessageAndWaitCallback$2$1;
import com.upuphone.xr.sapp.glass.GlassMessageHelper$sendMessageAndWaitCallback$2$listener$1;
import com.upuphone.xr.sapp.utils.JsonUtils;
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

@SourceDebugExtension({"SMAP\nAirHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AirHelper.kt\ncom/upuphone/xr/sapp/air/AirHelper$cancelSilentUpdate$2\n+ 2 GlassMessageHelper.kt\ncom/upuphone/xr/sapp/glass/GlassMessageHelper\n+ 3 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,576:1\n311#2,7:577\n318#2,2:593\n332#2,10:595\n314#3,9:584\n323#3,2:605\n*S KotlinDebug\n*F\n+ 1 AirHelper.kt\ncom/upuphone/xr/sapp/air/AirHelper$cancelSilentUpdate$2\n*L\n516#1:577,7\n516#1:593,2\n516#1:595,10\n516#1:584,9\n516#1:605,2\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.air.AirHelper$cancelSilentUpdate$2", f = "AirHelper.kt", i = {0, 0, 0}, l = {584}, m = "invokeSuspend", n = {"action$iv", "subAction$iv", "message$iv"}, s = {"L$0", "L$1", "L$2"})
public final class AirHelper$cancelSilentUpdate$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;

    public AirHelper$cancelSilentUpdate$2(Continuation<? super AirHelper$cancelSilentUpdate$2> continuation) {
        super(2, continuation);
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new AirHelper$cancelSilentUpdate$2(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            GlassMessageHelper glassMessageHelper = GlassMessageHelper.f7054a;
            this.L$0 = "air_ota_silence";
            this.L$1 = "cancel_silence_update";
            this.L$2 = "";
            this.label = 1;
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(this), 1);
            cancellableContinuationImpl.x();
            GlassMessageHelper glassMessageHelper2 = GlassMessageHelper.f7054a;
            BaseActionData d = glassMessageHelper2.d("air_ota_silence", "cancel_silence_update", "");
            cancellableContinuationImpl.E(new GlassMessageHelper$sendMessageAndWaitCallback$2$1(glassMessageHelper2.i(JsonUtils.f7893a.d(d), (byte[]) null, new GlassMessageHelper$sendMessageAndWaitCallback$2$listener$1(cancellableContinuationImpl), true)));
            Object u = cancellableContinuationImpl.u();
            if (u == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(this);
            }
            if (u == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            String str = (String) this.L$2;
            String str2 = (String) this.L$1;
            String str3 = (String) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((AirHelper$cancelSilentUpdate$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
