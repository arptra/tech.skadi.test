package com.upuphone.xr.interconnect.adapter;

import android.content.Context;
import com.upuphone.xr.interconnect.business.connect.BlePrimaryDeviceConnectionListener;
import com.upuphone.xr.interconnect.business.connect.BondStateListener;
import com.upuphone.xr.interconnect.business.connect.BondStateManager;
import com.upuphone.xr.interconnect.business.connect.BondStateManagerImpl;
import com.upuphone.xr.interconnect.business.connect.ConnectionStateListener;
import com.upuphone.xr.interconnect.business.connect.ConnectionStateManager;
import com.upuphone.xr.interconnect.business.connect.ConnectionStateManagerImpl;
import com.upuphone.xr.interconnect.business.connect.ListenerLinkingCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\u0016\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J,\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00100\u000b2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u000bH\u0016J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H&R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005¨\u0006\u0017"}, d2 = {"Lcom/upuphone/xr/interconnect/adapter/StarryNetSdkAdapter;", "", "runAsOnePkg", "", "getRunAsOnePkg", "()Ljava/lang/String;", "runAsOneService", "getRunAsOneService", "createBondStateManager", "Lcom/upuphone/xr/interconnect/business/connect/BondStateManager;", "listenerLinkingCollector", "Lcom/upuphone/xr/interconnect/business/connect/ListenerLinkingCollector;", "Lcom/upuphone/xr/interconnect/business/connect/BondStateListener;", "createConnectionStateManager", "Lcom/upuphone/xr/interconnect/business/connect/ConnectionStateManager;", "bondStateManager", "Lcom/upuphone/xr/interconnect/business/connect/ConnectionStateListener;", "primaryDeviceConnectionListenerLinkingCollector", "Lcom/upuphone/xr/interconnect/business/connect/BlePrimaryDeviceConnectionListener;", "installStarryNet", "", "applicationContext", "Landroid/content/Context;", "SharedImpl_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface StarryNetSdkAdapter {

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class DefaultImpls {
        @NotNull
        public static BondStateManager createBondStateManager(@NotNull StarryNetSdkAdapter starryNetSdkAdapter, @NotNull ListenerLinkingCollector<BondStateListener> listenerLinkingCollector) {
            Intrinsics.checkNotNullParameter(listenerLinkingCollector, "listenerLinkingCollector");
            return new BondStateManagerImpl(listenerLinkingCollector);
        }

        @NotNull
        public static ConnectionStateManager createConnectionStateManager(@NotNull StarryNetSdkAdapter starryNetSdkAdapter, @NotNull BondStateManager bondStateManager, @NotNull ListenerLinkingCollector<ConnectionStateListener> listenerLinkingCollector, @NotNull ListenerLinkingCollector<BlePrimaryDeviceConnectionListener> listenerLinkingCollector2) {
            Intrinsics.checkNotNullParameter(bondStateManager, "bondStateManager");
            Intrinsics.checkNotNullParameter(listenerLinkingCollector, "listenerLinkingCollector");
            Intrinsics.checkNotNullParameter(listenerLinkingCollector2, "primaryDeviceConnectionListenerLinkingCollector");
            return new ConnectionStateManagerImpl(bondStateManager, listenerLinkingCollector, listenerLinkingCollector2);
        }
    }

    @NotNull
    BondStateManager createBondStateManager(@NotNull ListenerLinkingCollector<BondStateListener> listenerLinkingCollector);

    @NotNull
    ConnectionStateManager createConnectionStateManager(@NotNull BondStateManager bondStateManager, @NotNull ListenerLinkingCollector<ConnectionStateListener> listenerLinkingCollector, @NotNull ListenerLinkingCollector<BlePrimaryDeviceConnectionListener> listenerLinkingCollector2);

    @Nullable
    String getRunAsOnePkg();

    @Nullable
    String getRunAsOneService();

    int installStarryNet(@NotNull Context context);
}
