package com.upuphone.xr.interconnect.util;

import com.upuphone.runasone.constant.Constants;
import com.upuphone.starrynetsdk.ability.relay.RelayAbility;
import com.upuphone.starrynetsdk.ability.relay.RelayBean;
import com.upuphone.xr.interconnect.InterconnectManager;
import com.upuphone.xr.interconnect.main.StarryNetAbilityManager;
import com.upuphone.xr.interconnect.util.log.ILog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/upuphone/xr/interconnect/util/ServiceExt;", "", "()V", "startPhoneService", "", "deviceId", "", "SharedImpl_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ServiceExt {
    @NotNull
    public static final ServiceExt INSTANCE = new ServiceExt();

    private ServiceExt() {
    }

    public final void startPhoneService(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
        RelayAbility relayAbility = StarryNetAbilityManager.getInstance().getRelayAbility();
        RelayBean obtain = RelayBean.obtain();
        obtain.setTargetDeviceId(str).setTargetUniteCode(InterconnectManager.getInstance().getPeerPackageName()).setHost("com.upuphone.star.launcher").setData(new byte[0]).setType(2);
        ILog.i("PhoneService", "Starting " + str + " phone service.");
        relayAbility.startRemote(obtain);
    }
}
