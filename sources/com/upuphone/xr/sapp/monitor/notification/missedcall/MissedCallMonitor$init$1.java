package com.upuphone.xr.sapp.monitor.notification.missedcall;

import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.interconnect.entity.StarryNetDevice;
import com.upuphone.xr.interconnect.listener.DeviceConnectionListener;
import com.upuphone.xr.interconnect.util.StarryNetDeviceExt;
import com.upuphone.xr.sapp.monitor.notification.SuperNotificationManager;
import com.upuphone.xr.sapp.monitor.starry.StarryMessageHelper;
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
@DebugMetadata(c = "com.upuphone.xr.sapp.monitor.notification.missedcall.MissedCallMonitor$init$1", f = "MissedCallMonitor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class MissedCallMonitor$init$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    public MissedCallMonitor$init$1(Continuation<? super MissedCallMonitor$init$1> continuation) {
        super(2, continuation);
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new MissedCallMonitor$init$1(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            StarryMessageHelper.f7799a.i(new DeviceConnectionListener() {
                public void onDeviceConnected(@Nullable StarryNetDevice starryNetDevice) {
                    if (starryNetDevice != null) {
                        StarryNetDeviceExt.isXrDevice(starryNetDevice);
                    }
                    boolean k = SuperNotificationManager.f7749a.k();
                    ULog.Delegate delegate = ULog.f6446a;
                    delegate.a("MissedCallMonitor", "onDeviceConnected MissedCallNotificationState:" + k);
                    if (k) {
                        MissedCallMonitor missedCallMonitor = MissedCallMonitor.f7773a;
                        missedCallMonitor.e();
                        missedCallMonitor.d();
                    }
                }

                public void onDeviceDisconnected(@Nullable StarryNetDevice starryNetDevice) {
                }
            });
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((MissedCallMonitor$init$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
