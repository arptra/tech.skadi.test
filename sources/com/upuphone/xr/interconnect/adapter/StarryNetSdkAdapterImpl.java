package com.upuphone.xr.interconnect.adapter;

import android.content.Context;
import com.upuphone.starrynet.api.StConstant;
import com.upuphone.starrynetsdk.StarryNet;
import com.upuphone.xr.interconnect.adapter.StarryNetSdkAdapter;
import com.upuphone.xr.interconnect.business.connect.BlePrimaryDeviceConnectionListener;
import com.upuphone.xr.interconnect.business.connect.BondStateListener;
import com.upuphone.xr.interconnect.business.connect.BondStateManager;
import com.upuphone.xr.interconnect.business.connect.ConnectionStateListener;
import com.upuphone.xr.interconnect.business.connect.ConnectionStateManager;
import com.upuphone.xr.interconnect.business.connect.ListenerLinkingCollector;
import com.upuphone.xr.interconnect.util.log.ILog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/upuphone/xr/interconnect/adapter/StarryNetSdkAdapterImpl;", "Lcom/upuphone/xr/interconnect/adapter/StarryNetSdkAdapter;", "()V", "runAsOnePkg", "", "getRunAsOnePkg", "()Ljava/lang/String;", "runAsOneService", "getRunAsOneService", "installStarryNet", "", "applicationContext", "Landroid/content/Context;", "SharedImpl_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class StarryNetSdkAdapterImpl implements StarryNetSdkAdapter {
    @NotNull
    public static final StarryNetSdkAdapterImpl INSTANCE = new StarryNetSdkAdapterImpl();
    @NotNull
    private static final String runAsOnePkg = StConstant.PACKAGE_NAME_RUN_AS_ONE;
    @NotNull
    private static final String runAsOneService = "com.upuphone.runasone.service.RunAsOneService";

    private StarryNetSdkAdapterImpl() {
    }

    @NotNull
    public BondStateManager createBondStateManager(@NotNull ListenerLinkingCollector<BondStateListener> listenerLinkingCollector) {
        return StarryNetSdkAdapter.DefaultImpls.createBondStateManager(this, listenerLinkingCollector);
    }

    @NotNull
    public ConnectionStateManager createConnectionStateManager(@NotNull BondStateManager bondStateManager, @NotNull ListenerLinkingCollector<ConnectionStateListener> listenerLinkingCollector, @NotNull ListenerLinkingCollector<BlePrimaryDeviceConnectionListener> listenerLinkingCollector2) {
        return StarryNetSdkAdapter.DefaultImpls.createConnectionStateManager(this, bondStateManager, listenerLinkingCollector, listenerLinkingCollector2);
    }

    @NotNull
    public String getRunAsOnePkg() {
        return runAsOnePkg;
    }

    @NotNull
    public String getRunAsOneService() {
        return runAsOneService;
    }

    public int installStarryNet(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "applicationContext");
        ILog.d("StarryNetSdkAdapterImpl", " overseas StarryNet.getInstance().install");
        return StarryNet.getInstance().install(context);
    }
}
