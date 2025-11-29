package com.upuphone.xr.interconnect.business.connect;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.upuphone.starrynet.api.StBroadcast;
import com.upuphone.xr.interconnect.api.StarryNetDeviceManagerImpl;
import com.upuphone.xr.interconnect.util.log.ILog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001c\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/upuphone/xr/interconnect/business/connect/DeviceNameChangeBroadcastReceiver;", "Landroid/content/BroadcastReceiver;", "connectManager", "Lcom/upuphone/xr/interconnect/business/connect/ConnectManager;", "(Lcom/upuphone/xr/interconnect/business/connect/ConnectManager;)V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "SharedImpl_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class DeviceNameChangeBroadcastReceiver extends BroadcastReceiver {
    @NotNull
    private final ConnectManager connectManager;

    public DeviceNameChangeBroadcastReceiver(@NotNull ConnectManager connectManager2) {
        Intrinsics.checkNotNullParameter(connectManager2, "connectManager");
        this.connectManager = connectManager2;
    }

    public void onReceive(@Nullable Context context, @Nullable Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(StBroadcast.EXTRA_DEVICE_ID);
            String stringExtra2 = intent.getStringExtra(StBroadcast.EXTRA_DEVICE_NAME);
            if (stringExtra2 == null) {
                stringExtra2 = "";
            }
            ILog.e(StarryNetDeviceManagerImpl.TAG, "收到设备名称改变广播，deviceId--" + stringExtra + "，deviceName--" + stringExtra2);
            if (stringExtra != null) {
                this.connectManager.onDeviceRenamed(stringExtra, stringExtra2);
            }
        }
    }
}
