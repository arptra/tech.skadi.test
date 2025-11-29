package com.upuphone.ar.translation.phone.helper;

import com.upuphone.ar.translation.ext.LogExt;
import com.upuphone.ar.translation.interconnect.entity.TelephoneNotification;
import com.upuphone.ar.translation.utils.JsonUtils;
import com.upuphone.ar.translation.utils.PreferencesUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.translation.phone.helper.EarlyInterConnectHelper$sendTelephoneCallAudio$1", f = "EarlyInterConnectHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class EarlyInterConnectHelper$sendTelephoneCallAudio$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ EarlyInterConnectHelper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EarlyInterConnectHelper$sendTelephoneCallAudio$1(EarlyInterConnectHelper earlyInterConnectHelper, Continuation<? super EarlyInterConnectHelper$sendTelephoneCallAudio$1> continuation) {
        super(2, continuation);
        this.this$0 = earlyInterConnectHelper;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new EarlyInterConnectHelper$sendTelephoneCallAudio$1(this.this$0, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            TelephoneNotification telephoneNotification = new TelephoneNotification((String) null, new TelephoneNotification.Data("telephone_call_audio", PreferencesUtils.i()), 1, (DefaultConstructorMarker) null);
            EarlyInterConnectHelper earlyInterConnectHelper = this.this$0;
            LogExt.j("sendTelephoneCallAudio callAudio=" + telephoneNotification, "EarlyInterConnectHelper");
            earlyInterConnectHelper.sendMessage(JsonUtils.d(telephoneNotification));
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((EarlyInterConnectHelper$sendTelephoneCallAudio$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
