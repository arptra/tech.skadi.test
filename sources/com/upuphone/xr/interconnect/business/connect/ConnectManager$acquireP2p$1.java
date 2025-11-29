package com.upuphone.xr.interconnect.business.connect;

import com.upuphone.xr.interconnect.api.connection.ConnectionLevel;
import com.upuphone.xr.interconnect.common.IP2pAcquireCallback;
import com.upuphone.xr.interconnect.common.IRequestCallback;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/upuphone/xr/interconnect/business/connect/DeviceConnectionLevelManager;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class ConnectManager$acquireP2p$1 extends Lambda implements Function1<DeviceConnectionLevelManager, Unit> {
    final /* synthetic */ IP2pAcquireCallback $callback;
    final /* synthetic */ String $identifier;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ConnectManager$acquireP2p$1(String str, IP2pAcquireCallback iP2pAcquireCallback) {
        super(1);
        this.$identifier = str;
        this.$callback = iP2pAcquireCallback;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((DeviceConnectionLevelManager) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull DeviceConnectionLevelManager deviceConnectionLevelManager) {
        Intrinsics.checkNotNullParameter(deviceConnectionLevelManager, "$this$manageDeviceConnectionLevel");
        String str = this.$identifier;
        ConnectionLevel connectionLevel = ConnectionLevel.ENHANCE;
        final IP2pAcquireCallback iP2pAcquireCallback = this.$callback;
        deviceConnectionLevelManager.request(str, connectionLevel, new IRequestCallback.Stub() {
            public void onFail(int i, @Nullable String str) {
                if (i != 1) {
                    IP2pAcquireCallback iP2pAcquireCallback = iP2pAcquireCallback;
                    if (iP2pAcquireCallback != null) {
                        iP2pAcquireCallback.onFail(-4);
                        return;
                    }
                    return;
                }
                IP2pAcquireCallback iP2pAcquireCallback2 = iP2pAcquireCallback;
                if (iP2pAcquireCallback2 != null) {
                    iP2pAcquireCallback2.onTimeout();
                }
            }

            public void onSuccess() {
                IP2pAcquireCallback iP2pAcquireCallback = iP2pAcquireCallback;
                if (iP2pAcquireCallback != null) {
                    iP2pAcquireCallback.onSuccess();
                }
            }
        });
    }
}
