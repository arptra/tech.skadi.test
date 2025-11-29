package com.upuphone.xr.sapp.monitor.notification;

import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.interconnect.entity.StarryNetDevice;
import com.upuphone.xr.interconnect.listener.DeviceConnectionListener;
import com.upuphone.xr.interconnect.util.StarryNetDeviceExt;
import com.upuphone.xr.sapp.monitor.schedule.ScheduleDataSyncManager;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nSuperNotificationManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SuperNotificationManager.kt\ncom/upuphone/xr/sapp/monitor/notification/SuperNotificationManager$initStarryChange$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,725:1\n1#2:726\n*E\n"})
@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/upuphone/xr/sapp/monitor/notification/SuperNotificationManager$initStarryChange$1", "Lcom/upuphone/xr/interconnect/listener/DeviceConnectionListener;", "onDeviceConnected", "", "device", "Lcom/upuphone/xr/interconnect/entity/StarryNetDevice;", "onDeviceDisconnected", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class SuperNotificationManager$initStarryChange$1 extends DeviceConnectionListener {
    public void onDeviceConnected(@Nullable StarryNetDevice starryNetDevice) {
        if (starryNetDevice != null) {
            StarryNetDeviceExt.isXrDevice(starryNetDevice);
        }
        ULog.f6446a.a("SuperNotificationManager", "onDeviceConnected syncReminderConfig");
        SuperNotificationManager.f7749a.P();
        ScheduleDataSyncManager.f7777a.h();
    }

    public void onDeviceDisconnected(@Nullable StarryNetDevice starryNetDevice) {
        if (starryNetDevice != null) {
            StarryNetDeviceExt.isXrDevice(starryNetDevice);
        }
        ScheduleDataSyncManager.f7777a.e();
    }
}
