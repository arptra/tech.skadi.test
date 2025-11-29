package com.upuphone.xr.sapp.guide.wifi;

import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.interconnect.entity.StarryNetDevice;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.glass.DeviceConnectListener;
import com.upuphone.xr.sapp.guide.adapter.WifiListAdapter;
import com.upuphone.xr.sapp.utils.ContextExtKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/upuphone/xr/sapp/guide/wifi/WifiSettingFragment$connectListener$1", "Lcom/upuphone/xr/sapp/glass/DeviceConnectListener;", "onDeviceConnected", "", "device", "Lcom/upuphone/xr/interconnect/entity/StarryNetDevice;", "onDeviceDisconnected", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class WifiSettingFragment$connectListener$1 implements DeviceConnectListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WifiSettingFragment f7095a;

    public WifiSettingFragment$connectListener$1(WifiSettingFragment wifiSettingFragment) {
        this.f7095a = wifiSettingFragment;
    }

    public void onDeviceConnected(StarryNetDevice starryNetDevice) {
        Intrinsics.checkNotNullParameter(starryNetDevice, "device");
        ULog.f6446a.a("WifiSettingFragment", "onDeviceConnected");
    }

    public void onDeviceDisconnected(StarryNetDevice starryNetDevice) {
        Intrinsics.checkNotNullParameter(starryNetDevice, "device");
        ULog.f6446a.a("WifiSettingFragment", "onDeviceDisconnected");
        ContextExtKt.e(R.string.glass_disconnect_toast, 0, 2, (Object) null);
        WifiListAdapter S0 = this.f7095a.k;
        if (S0 != null) {
            S0.H(false);
        }
        WifiListAdapter S02 = this.f7095a.k;
        if (S02 != null) {
            S02.notifyDataSetChanged();
        }
        WifiSettingFragment.x.a().removeCallbacksAndMessages((Object) null);
    }
}
