package com.upuphone.xr.sapp.glass;

import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.interconnect.entity.StarryNetDevice;
import com.upuphone.xr.sapp.entity.GlassCheckUpdateState;
import com.upuphone.xr.sapp.entity.GlassUpdateProgress;
import com.upuphone.xr.sapp.entity.GlassUpdateState;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/upuphone/xr/sapp/glass/GlassUpdateInfoActivity$connectListener$1", "Lcom/upuphone/xr/sapp/glass/DeviceConnectListener;", "onDeviceConnected", "", "device", "Lcom/upuphone/xr/interconnect/entity/StarryNetDevice;", "onDeviceDisconnected", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class GlassUpdateInfoActivity$connectListener$1 implements DeviceConnectListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GlassUpdateInfoActivity f7064a;

    public GlassUpdateInfoActivity$connectListener$1(GlassUpdateInfoActivity glassUpdateInfoActivity) {
        this.f7064a = glassUpdateInfoActivity;
    }

    public void onDeviceConnected(StarryNetDevice starryNetDevice) {
        Intrinsics.checkNotNullParameter(starryNetDevice, "device");
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("GlassUpdateInfoActivity", "onDeviceConnected");
        GlassCheckUpdateState A0 = this.f7064a.g;
        if (A0 != null) {
            GlassUpdateInfoActivity glassUpdateInfoActivity = this.f7064a;
            delegate.a("GlassUpdateInfoActivity", "onDeviceConnected, handleGlassUpdateState");
            GlassUpdateInfoActivity.S0(glassUpdateInfoActivity, A0, (GlassUpdateState) glassUpdateInfoActivity.N0().e().getValue(), (GlassUpdateProgress) null, true, 4, (Object) null);
        }
    }

    public void onDeviceDisconnected(StarryNetDevice starryNetDevice) {
        Intrinsics.checkNotNullParameter(starryNetDevice, "device");
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("GlassUpdateInfoActivity", "onDeviceDisconnected");
        GlassCheckUpdateState A0 = this.f7064a.g;
        if (A0 != null) {
            GlassUpdateInfoActivity glassUpdateInfoActivity = this.f7064a;
            delegate.a("GlassUpdateInfoActivity", "onDeviceDisconnected, handleGlassUpdateState");
            GlassUpdateInfoActivity.S0(glassUpdateInfoActivity, A0, (GlassUpdateState) glassUpdateInfoActivity.N0().e().getValue(), (GlassUpdateProgress) null, false, 4, (Object) null);
        }
    }
}
