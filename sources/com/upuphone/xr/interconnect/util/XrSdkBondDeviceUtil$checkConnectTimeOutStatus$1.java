package com.upuphone.xr.interconnect.util;

import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.interconnect.InterconnectManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.interconnect.util.XrSdkBondDeviceUtil$checkConnectTimeOutStatus$1", f = "XrSdkBondDeviceUtil.kt", i = {}, l = {262}, m = "invokeSuspend", n = {}, s = {})
public final class XrSdkBondDeviceUtil$checkConnectTimeOutStatus$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    public XrSdkBondDeviceUtil$checkConnectTimeOutStatus$1(Continuation<? super XrSdkBondDeviceUtil$checkConnectTimeOutStatus$1> continuation) {
        super(2, continuation);
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new XrSdkBondDeviceUtil$checkConnectTimeOutStatus$1(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ULog.f6446a.o("XrSdkBondDeviceUtil", "delay checkout start");
            this.label = 1;
            if (DelayKt.b(10000, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ULog.Delegate delegate = ULog.f6446a;
        delegate.o("XrSdkBondDeviceUtil", "delay time out 10000");
        if (XrSdkBondDeviceUtil.deviceId != null) {
            InterconnectManager.getInstance().getStarryNetDeviceManager().getConnectedDevice();
            String access$getDeviceId$p = XrSdkBondDeviceUtil.deviceId;
            delegate.o("XrSdkBondDeviceUtil", "disconnectDevice deviceId = " + access$getDeviceId$p);
            Boxing.boxBoolean(InterconnectManager.getInstance().getStarryNetDeviceManager().disconnectDevice(XrSdkBondDeviceUtil.deviceId));
        }
        delegate.o("XrSdkBondDeviceUtil", "startDiscovery start");
        InterconnectManager.getInstance().getStarryNetDeviceManager().startDiscovery();
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((XrSdkBondDeviceUtil$checkConnectTimeOutStatus$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
