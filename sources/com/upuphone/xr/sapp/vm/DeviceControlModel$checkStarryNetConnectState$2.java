package com.upuphone.xr.sapp.vm;

import com.upuphone.star.core.log.ULog;
import com.upuphone.starrynetsdk.ability.relay.RemoteListener;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\t"}, d2 = {"com/upuphone/xr/sapp/vm/DeviceControlModel$checkStarryNetConnectState$2", "Lcom/upuphone/starrynetsdk/ability/relay/RemoteListener;", "onFailure", "", "uniteCode", "", "code", "", "onSuccess", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class DeviceControlModel$checkStarryNetConnectState$2 implements RemoteListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DeviceControlModel f7996a;

    public DeviceControlModel$checkStarryNetConnectState$2(DeviceControlModel deviceControlModel) {
        this.f7996a = deviceControlModel;
    }

    public void onFailure(String str, int i) {
        ULog.f6446a.a("DeviceControlModel", "checkStarryNetConnectState::starrynet fail");
    }

    public void onSuccess(String str) {
        ULog.f6446a.a("DeviceControlModel", "checkStarryNetConnectState::starrynet ok");
        this.f7996a.s.removeCallbacksAndMessages((Object) null);
        this.f7996a.t = false;
    }
}
