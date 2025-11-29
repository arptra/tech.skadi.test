package com.upuphone.xr.interconnect.business.connect;

import com.upuphone.xr.interconnect.api.connection.ConnectionLevel;
import com.upuphone.xr.interconnect.util.log.ILog;
import io.netty.handler.codec.rtsp.RtspHeaders;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.interconnect.business.connect.DeviceConnectionLevelManager$restartTimeout$1", f = "DeviceConnectionLevelManager.kt", i = {}, l = {50}, m = "invokeSuspend", n = {}, s = {})
public final class DeviceConnectionLevelManager$restartTimeout$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ConnectionLevel $targetLevel;
    int label;
    final /* synthetic */ DeviceConnectionLevelManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeviceConnectionLevelManager$restartTimeout$1(DeviceConnectionLevelManager deviceConnectionLevelManager, ConnectionLevel connectionLevel, Continuation<? super DeviceConnectionLevelManager$restartTimeout$1> continuation) {
        super(2, continuation);
        this.this$0 = deviceConnectionLevelManager;
        this.$targetLevel = connectionLevel;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new DeviceConnectionLevelManager$restartTimeout$1(this.this$0, this.$targetLevel, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (DelayKt.b(15000, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        final DeviceConnectionLevelManager deviceConnectionLevelManager = this.this$0;
        final ConnectionLevel connectionLevel = this.$targetLevel;
        deviceConnectionLevelManager.serialize(RtspHeaders.Values.TIMEOUT, new Function0<Unit>() {

            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            /* renamed from: com.upuphone.xr.interconnect.business.connect.DeviceConnectionLevelManager$restartTimeout$1$1$WhenMappings */
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
                /* JADX WARNING: Failed to process nested try/catch */
                /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
                /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
                static {
                    /*
                        com.upuphone.xr.interconnect.api.connection.ConnectionLevel[] r0 = com.upuphone.xr.interconnect.api.connection.ConnectionLevel.values()
                        int r0 = r0.length
                        int[] r0 = new int[r0]
                        com.upuphone.xr.interconnect.api.connection.ConnectionLevel r1 = com.upuphone.xr.interconnect.api.connection.ConnectionLevel.ENHANCE     // Catch:{ NoSuchFieldError -> 0x0010 }
                        int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                        r2 = 1
                        r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
                    L_0x0010:
                        com.upuphone.xr.interconnect.api.connection.ConnectionLevel r1 = com.upuphone.xr.interconnect.api.connection.ConnectionLevel.BALANCE     // Catch:{ NoSuchFieldError -> 0x0019 }
                        int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                        r2 = 2
                        r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
                    L_0x0019:
                        com.upuphone.xr.interconnect.api.connection.ConnectionLevel r1 = com.upuphone.xr.interconnect.api.connection.ConnectionLevel.BASIC     // Catch:{ NoSuchFieldError -> 0x0022 }
                        int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                        r2 = 3
                        r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
                    L_0x0022:
                        $EnumSwitchMapping$0 = r0
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.interconnect.business.connect.DeviceConnectionLevelManager$restartTimeout$1.AnonymousClass1.WhenMappings.<clinit>():void");
                }
            }

            public final void invoke() {
                String access$getTag = deviceConnectionLevelManager.getTag();
                ConnectionLevel connectionLevel = connectionLevel;
                ILog.d(access$getTag, "Request for " + connectionLevel + " has timed out.");
                ConnectionLevel access$getRequestingLevel$p = deviceConnectionLevelManager.requestingLevel;
                if (access$getRequestingLevel$p != null) {
                    ConnectionLevel connectionLevel2 = connectionLevel;
                    DeviceConnectionLevelManager deviceConnectionLevelManager = deviceConnectionLevelManager;
                    if (access$getRequestingLevel$p == connectionLevel2) {
                        int i = WhenMappings.$EnumSwitchMapping$0[connectionLevel2.ordinal()];
                        if (i == 1) {
                            deviceConnectionLevelManager.informFail(deviceConnectionLevelManager.highRequestCallbacks, 1, (String) null);
                            deviceConnectionLevelManager.informFail(deviceConnectionLevelManager.mediumRequestCallbacks, 1, (String) null);
                        } else if (i == 2) {
                            deviceConnectionLevelManager.informFail(deviceConnectionLevelManager.mediumRequestCallbacks, 1, (String) null);
                        }
                        deviceConnectionLevelManager.requestingLevel = null;
                    }
                }
            }
        });
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((DeviceConnectionLevelManager$restartTimeout$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
