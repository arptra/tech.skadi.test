package com.upuphone.xr.sapp.glass;

import com.upuphone.xr.sapp.air.AirHelper;
import com.upuphone.xr.sapp.entity.AirSilentSendFileResponse;
import com.upuphone.xr.sapp.glass.AirGlassUpdater;
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
@DebugMetadata(c = "com.upuphone.xr.sapp.glass.AirGlassUpdater$sendUpdateFileStreamResponse$1", f = "AirGlassUpdater.kt", i = {}, l = {545}, m = "invokeSuspend", n = {}, s = {})
public final class AirGlassUpdater$sendUpdateFileStreamResponse$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ byte[] $bytes;
    final /* synthetic */ AirSilentSendFileResponse $response;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AirGlassUpdater$sendUpdateFileStreamResponse$1(AirSilentSendFileResponse airSilentSendFileResponse, byte[] bArr, Continuation<? super AirGlassUpdater$sendUpdateFileStreamResponse$1> continuation) {
        super(2, continuation);
        this.$response = airSilentSendFileResponse;
        this.$bytes = bArr;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new AirGlassUpdater$sendUpdateFileStreamResponse$1(this.$response, this.$bytes, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            AirGlassUpdater.Companion companion = AirGlassUpdater.g;
            AirSilentSendFileResponse airSilentSendFileResponse = this.$response;
            companion.c("sendUpdateFileStreamResponse, response: " + airSilentSendFileResponse);
            AirHelper airHelper = AirHelper.b;
            AirSilentSendFileResponse airSilentSendFileResponse2 = this.$response;
            byte[] bArr = this.$bytes;
            this.label = 1;
            if (AirHelper.a0(airHelper, airSilentSendFileResponse2, bArr, 0, this, 4, (Object) null) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Exception e) {
                AirGlassUpdater.Companion companion2 = AirGlassUpdater.g;
                companion2.d("sendUpdateFileStreamResponse, error: " + e);
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Unit unit = Unit.INSTANCE;
        AirGlassUpdater.Companion companion3 = AirGlassUpdater.g;
        companion3.c("sendUpdateFileStreamResponse, result: " + unit);
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((AirGlassUpdater$sendUpdateFileStreamResponse$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
