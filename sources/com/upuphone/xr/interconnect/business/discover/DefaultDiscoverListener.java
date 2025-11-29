package com.upuphone.xr.interconnect.business.discover;

import android.text.TextUtils;
import com.upuphone.runasone.device.StarryDevice;
import com.upuphone.starrynet.api.bean.StDevice;
import com.upuphone.starrynetsdk.device.discovery.DiscoverListener;
import com.upuphone.xr.interconnect.api.StarryNetDeviceDiscoverListener;
import com.upuphone.xr.interconnect.api.StarryNetDeviceManagerImpl;
import com.upuphone.xr.interconnect.entity.StarryDeviceExt;
import com.upuphone.xr.interconnect.entity.StarryNetDevice;
import com.upuphone.xr.interconnect.util.log.ILog;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B'\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\u001c\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010\u0010\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u001a\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\"\u0010\u0016\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0015H\u0016J\b\u0010\u0019\u001a\u00020\u000bH\u0016R\u001a\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/upuphone/xr/interconnect/business/discover/DefaultDiscoverListener;", "Lcom/upuphone/starrynetsdk/device/discovery/DiscoverListener;", "foundDeviceMap", "", "", "Lcom/upuphone/xr/interconnect/entity/StarryNetDevice;", "starryNetDeviceDiscoverListenerList", "", "Lcom/upuphone/xr/interconnect/api/StarryNetDeviceDiscoverListener;", "(Ljava/util/Map;Ljava/util/List;)V", "onDeviceFound", "", "device", "Lcom/upuphone/runasone/device/StarryDevice;", "data", "", "onDeviceLose", "onDeviceRequestConnect", "starryDevice", "onError", "code", "", "onFastFound", "type", "beaconId", "onTimeout", "SharedImpl_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nDefaultDiscoverListener.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DefaultDiscoverListener.kt\ncom/upuphone/xr/interconnect/business/discover/DefaultDiscoverListener\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,64:1\n1855#2,2:65\n1855#2,2:67\n1855#2,2:69\n1855#2,2:71\n1855#2,2:73\n*S KotlinDebug\n*F\n+ 1 DefaultDiscoverListener.kt\ncom/upuphone/xr/interconnect/business/discover/DefaultDiscoverListener\n*L\n21#1:65,2\n32#1:67,2\n42#1:69,2\n54#1:71,2\n59#1:73,2\n*E\n"})
public final class DefaultDiscoverListener implements DiscoverListener {
    @NotNull
    private final Map<String, StarryNetDevice> foundDeviceMap;
    @NotNull
    private final List<StarryNetDeviceDiscoverListener> starryNetDeviceDiscoverListenerList;

    public DefaultDiscoverListener(@NotNull Map<String, StarryNetDevice> map, @NotNull List<? extends StarryNetDeviceDiscoverListener> list) {
        Intrinsics.checkNotNullParameter(map, "foundDeviceMap");
        Intrinsics.checkNotNullParameter(list, "starryNetDeviceDiscoverListenerList");
        this.foundDeviceMap = map;
        this.starryNetDeviceDiscoverListenerList = list;
    }

    public void onDeviceFound(@Nullable StarryDevice starryDevice, @Nullable byte[] bArr) {
        String id = starryDevice != null ? starryDevice.getId() : null;
        ILog.d(StarryNetDeviceManagerImpl.TAG, "DiscoverListener onDeviceFound--#" + id);
        if (starryDevice != null && !TextUtils.isEmpty(starryDevice.getId())) {
            StarryNetDevice wrapForDiscovery = StarryDeviceExt.wrapForDiscovery(starryDevice);
            Map<String, StarryNetDevice> map = this.foundDeviceMap;
            String id2 = starryDevice.getId();
            Intrinsics.checkNotNullExpressionValue(id2, "getId(...)");
            map.put(id2, wrapForDiscovery);
            for (StarryNetDeviceDiscoverListener onDeviceFound : this.starryNetDeviceDiscoverListenerList) {
                onDeviceFound.onDeviceFound(wrapForDiscovery);
            }
        }
    }

    public void onDeviceLose(@Nullable StarryDevice starryDevice) {
        StarryNetDevice remove;
        String id = starryDevice != null ? starryDevice.getId() : null;
        ILog.d(StarryNetDeviceManagerImpl.TAG, "DiscoverListener onDeviceLose--#" + id);
        if (starryDevice != null && !TextUtils.isEmpty(starryDevice.getId()) && (remove = this.foundDeviceMap.remove(starryDevice.getId())) != null) {
            for (StarryNetDeviceDiscoverListener onDeviceLose : this.starryNetDeviceDiscoverListenerList) {
                onDeviceLose.onDeviceLose(remove);
            }
        }
    }

    public void onDeviceRequestConnect(@NotNull StarryDevice starryDevice, @Nullable byte[] bArr) {
        Intrinsics.checkNotNullParameter(starryDevice, "starryDevice");
        String id = starryDevice.getId();
        ILog.d(StarryNetDeviceManagerImpl.TAG, "DiscoverListener onDeviceRequestConnect--#" + id);
    }

    public void onError(int i) {
        ILog.d(StarryNetDeviceManagerImpl.TAG, "DiscoverListener onError--" + i);
        for (StarryNetDeviceDiscoverListener onError : this.starryNetDeviceDiscoverListenerList) {
            onError.onError(i);
        }
    }

    public void onFastFound(@Nullable StarryDevice starryDevice, int i, int i2) {
        StDevice starryDevice2;
        Byte b = null;
        String id = starryDevice != null ? starryDevice.getId() : null;
        if (!(starryDevice == null || (starryDevice2 = starryDevice.getStarryDevice()) == null)) {
            b = Byte.valueOf(starryDevice2.getRegion());
        }
        ILog.d(StarryNetDeviceManagerImpl.TAG, "DiscoverListener onFastFound--#" + id + ",region = " + b + ", type--" + i + ", beaconId--" + i2);
        if (starryDevice != null && !TextUtils.isEmpty(starryDevice.getId())) {
            StarryNetDevice wrapForDiscovery = StarryDeviceExt.wrapForDiscovery(starryDevice);
            Map<String, StarryNetDevice> map = this.foundDeviceMap;
            String id2 = starryDevice.getId();
            Intrinsics.checkNotNullExpressionValue(id2, "getId(...)");
            map.put(id2, wrapForDiscovery);
            for (StarryNetDeviceDiscoverListener onFastFound : this.starryNetDeviceDiscoverListenerList) {
                onFastFound.onFastFound(wrapForDiscovery, i, i2);
            }
        }
    }

    public void onTimeout() {
        ILog.d(StarryNetDeviceManagerImpl.TAG, "DiscoverListener onTimeout--");
        for (StarryNetDeviceDiscoverListener onTimeout : this.starryNetDeviceDiscoverListenerList) {
            onTimeout.onTimeout();
        }
    }
}
