package com.upuphone.xr.interconnect.main;

import com.upuphone.starrynetsdk.device.connection.DevicesConnector;
import com.upuphone.xr.interconnect.util.HostAlienCallExtKt;
import com.upuphone.xr.interconnect.util.log.ILog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class StarryNetAbilityInstallListener$useDevicesConnector$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Function1<DevicesConnector, Unit> $action;
    final /* synthetic */ String $description;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StarryNetAbilityInstallListener$useDevicesConnector$1(String str, Function1<? super DevicesConnector, Unit> function1) {
        super(0);
        this.$description = str;
        this.$action = function1;
    }

    public final void invoke() {
        StarryNetAbilityInstallListener starryNetAbilityInstallListener = StarryNetAbilityInstallListener.INSTANCE;
        String access$getTag = starryNetAbilityInstallListener.getTag();
        String str = this.$description;
        ILog.d(access$getTag, "Attempting to use connector for: " + str + ".");
        final String str2 = this.$description;
        AnonymousClass1 r1 = new Function0<Unit>() {
            public final void invoke() {
                String access$getTag = StarryNetAbilityInstallListener.INSTANCE.getTag();
                String str = str2;
                ILog.w(access$getTag, "Failed to perform on connector " + str + ".");
            }
        };
        final Function1<DevicesConnector, Unit> function1 = this.$action;
        starryNetAbilityInstallListener.useAfterInitialize(r1, new Function0<Unit>() {
            public final void invoke() {
                HostAlienCallExtKt.safeAlienCall(StarryNetAbilityInstallListener.devicesConnector, StarryNetAbilityInstallListener.INSTANCE.getTag(), function1);
            }
        });
    }
}
