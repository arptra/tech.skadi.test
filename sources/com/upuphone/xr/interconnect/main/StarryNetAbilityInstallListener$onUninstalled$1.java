package com.upuphone.xr.interconnect.main;

import com.upuphone.xr.interconnect.InterconnectManager;
import com.upuphone.xr.interconnect.util.log.ILog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class StarryNetAbilityInstallListener$onUninstalled$1 extends Lambda implements Function0<Unit> {
    public static final StarryNetAbilityInstallListener$onUninstalled$1 INSTANCE = new StarryNetAbilityInstallListener$onUninstalled$1();

    public StarryNetAbilityInstallListener$onUninstalled$1() {
        super(0);
    }

    public final void invoke() {
        ILog.i(StarryNetAbilityInstallListener.INSTANCE.getTag(), "StarryNet service uninstalled.");
        StarryNetAbilityInstallListener.isInstalled = false;
        StarryNetAbilityManager.getInstance().reset();
        InterconnectManager.getInstance().notifyStarrySdkStateChanged(false);
        StarryNetAbilityInstallListener.operationQueue.clear();
        InterconnectManager.getInstance().getStarryNetDeviceManager().setAllDeviceDisConnectionStatus();
    }
}
