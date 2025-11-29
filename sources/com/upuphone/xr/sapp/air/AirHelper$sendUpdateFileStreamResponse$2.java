package com.upuphone.xr.sapp.air;

import com.upuphone.xr.sapp.entity.AirSilentSendFileResponse;
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

@SourceDebugExtension({"SMAP\nAirHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AirHelper.kt\ncom/upuphone/xr/sapp/air/AirHelper$sendUpdateFileStreamResponse$2\n+ 2 GlassMessageHelper.kt\ncom/upuphone/xr/sapp/glass/GlassMessageHelper\n+ 3 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,576:1\n317#2:577\n318#2,2:587\n332#2,10:589\n314#3,9:578\n323#3,2:599\n*S KotlinDebug\n*F\n+ 1 AirHelper.kt\ncom/upuphone/xr/sapp/air/AirHelper$sendUpdateFileStreamResponse$2\n*L\n567#1:577\n567#1:587,2\n567#1:589,10\n567#1:578,9\n567#1:599,2\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.air.AirHelper$sendUpdateFileStreamResponse$2", f = "AirHelper.kt", i = {0, 0, 0, 0}, l = {578}, m = "invokeSuspend", n = {"action$iv", "subAction$iv", "message$iv", "bytes$iv"}, s = {"L$0", "L$1", "L$2", "L$3"})
public final class AirHelper$sendUpdateFileStreamResponse$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ byte[] $bytes;
    final /* synthetic */ AirSilentSendFileResponse $response;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AirHelper$sendUpdateFileStreamResponse$2(AirSilentSendFileResponse airSilentSendFileResponse, byte[] bArr, Continuation<? super AirHelper$sendUpdateFileStreamResponse$2> continuation) {
        super(2, continuation);
        this.$response = airSilentSendFileResponse;
        this.$bytes = bArr;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new AirHelper$sendUpdateFileStreamResponse$2(this.$response, this.$bytes, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            GlassMessageHelper glassMessageHelper = GlassMessageHelper.f7054a;
            JsonUtils jsonUtils = JsonUtils.f7893a;
            String d = jsonUtils.d(this.$response);
            byte[] bArr = this.$bytes;
            this.L$0 = "air_ota";
            this.L$1 = "request_send_update_file_stream";
            this.L$2 = d;
            this.L$3 = bArr;
            this.label = 1;
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(this), 1);
            cancellableContinuationImpl.x();
            GlassMessageHelper glassMessageHelper2 = GlassMessageHelper.f7054a;
            BaseActionData d2 = glassMessageHelper2.d("air_ota", "request_send_update_file_stream", d);
            cancellableContinuationImpl.E(new GlassMessageHelper$sendMessageAndWaitCallback$2$1(glassMessageHelper2.i(jsonUtils.d(d2), bArr, new GlassMessageHelper$sendMessageAndWaitCallback$2$listener$1(cancellableContinuationImpl), true)));
            Object u = cancellableContinuationImpl.u();
            if (u == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(this);
            }
            if (u == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            byte[] bArr2 = (byte[]) this.L$3;
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
        return ((AirHelper$sendUpdateFileStreamResponse$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
