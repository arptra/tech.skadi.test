package com.upuphone.xr.interconnect.main;

import android.content.Context;
import com.upuphone.xr.interconnect.InterconnectManager;
import com.upuphone.xr.interconnect.util.log.ILog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension({"SMAP\nStarryNetAbilityInstallListener.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StarryNetAbilityInstallListener.kt\ncom/upuphone/xr/interconnect/main/StarryNetAbilityInstallListener$onInstalled$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,102:1\n1855#2,2:103\n*S KotlinDebug\n*F\n+ 1 StarryNetAbilityInstallListener.kt\ncom/upuphone/xr/interconnect/main/StarryNetAbilityInstallListener$onInstalled$1\n*L\n86#1:103,2\n*E\n"})
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class StarryNetAbilityInstallListener$onInstalled$1 extends Lambda implements Function0<Unit> {
    public static final StarryNetAbilityInstallListener$onInstalled$1 INSTANCE = new StarryNetAbilityInstallListener$onInstalled$1();

    public StarryNetAbilityInstallListener$onInstalled$1() {
        super(0);
    }

    public final void invoke() {
        ILog.i(StarryNetAbilityInstallListener.INSTANCE.getTag(), "StarryNet service installed.");
        StarryNetAbilityInstallListener.isInstalled = true;
        Context context = InterconnectManager.getInstance().getContext();
        StarryNetAbilityManager.getInstance().init(context);
        InterconnectManager.getInstance().getStarryNetDlna().attachDlnaBridge(context);
        for (Function0 invoke : StarryNetAbilityInstallListener.operationQueue) {
            invoke.invoke();
        }
        StarryNetAbilityInstallListener.operationQueue.clear();
    }
}
