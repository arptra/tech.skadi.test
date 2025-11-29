package com.upuphone.xr.sapp.contract;

import com.upuphone.ar.navi.lite.base.ULatLng;
import com.upuphone.ar.navi.lite.search.PoiSearchManager;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.MainApplication;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nReceiveLocationEventManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ReceiveLocationEventManager.kt\ncom/upuphone/xr/sapp/contract/ReceiveLocationEventManager$getCountryCode$2\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,123:1\n314#2,11:124\n*S KotlinDebug\n*F\n+ 1 ReceiveLocationEventManager.kt\ncom/upuphone/xr/sapp/contract/ReceiveLocationEventManager$getCountryCode$2\n*L\n65#1:124,11\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.contract.ReceiveLocationEventManager$getCountryCode$2", f = "ReceiveLocationEventManager.kt", i = {}, l = {124}, m = "invokeSuspend", n = {}, s = {})
public final class ReceiveLocationEventManager$getCountryCode$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ ULatLng $latLng;
    Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ReceiveLocationEventManager$getCountryCode$2(ULatLng uLatLng, Continuation<? super ReceiveLocationEventManager$getCountryCode$2> continuation) {
        super(2, continuation);
        this.$latLng = uLatLng;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ReceiveLocationEventManager$getCountryCode$2(this.$latLng, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ULatLng uLatLng = this.$latLng;
            this.L$0 = uLatLng;
            this.label = 1;
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(this), 1);
            cancellableContinuationImpl.x();
            try {
                PoiSearchManager.f().c(MainApplication.k.d(), uLatLng, new ReceiveLocationEventManager$getCountryCode$2$1$1(cancellableContinuationImpl));
            } catch (Exception e) {
                cancellableContinuationImpl.m("", (Function1) null);
                ULog.Delegate delegate = ULog.f6446a;
                String message = e.getMessage();
                delegate.c("ReceiveLocationEventManager", "getCountryCode 错误: " + message);
            }
            obj = cancellableContinuationImpl.u();
            if (obj == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(this);
            }
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ULatLng uLatLng2 = (ULatLng) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return obj;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super String> continuation) {
        return ((ReceiveLocationEventManager$getCountryCode$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
