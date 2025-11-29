package com.upuphone.xr.interconnect.business.connect;

import com.upuphone.runasone.device.StarryDevice;
import com.upuphone.xr.interconnect.petastep.PetaStepSerializer;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0000\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0016\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020 J\u0016\u0010!\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020 J\u001e\u0010\"\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00142\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020$J\u0016\u0010&\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020 J \u0010'\u001a\u00020\u001d2\u0006\u0010(\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u00142\u0006\u0010)\u001a\u00020$H\u0002J \u0010*\u001a\u00020\u001d2\u0006\u0010(\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u00142\u0006\u0010%\u001a\u00020$H\u0002J\u0018\u0010+\u001a\u00020\u001d2\u0006\u0010(\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u0014H\u0002J \u0010,\u001a\u00020\u001d2\u0006\u0010(\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u00142\u0006\u0010#\u001a\u00020$H\u0002JH\u0010-\u001a\u00020\u001d2\u0006\u0010(\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u00142\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020$2\u0006\u0010.\u001a\u00020$2\u0006\u0010/\u001a\u00020$2\u0006\u00100\u001a\u00020$2\u0006\u00101\u001a\u00020$H\u0002J0\u00102\u001a\u00020\u001d2\u0006\u0010(\u001a\u00020\b2\u0006\u0010.\u001a\u00020$2\u0006\u0010/\u001a\u00020$2\u0006\u00100\u001a\u00020$2\u0006\u00101\u001a\u00020$H\u0002R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\nR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\nR\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00140\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R!\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\u00188BX\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0019\u0010\n¨\u00063"}, d2 = {"Lcom/upuphone/xr/interconnect/business/connect/BaseConnectionManager;", "Lcom/upuphone/xr/interconnect/petastep/PetaStepSerializer;", "listenerLinkingCollector", "Lcom/upuphone/xr/interconnect/business/connect/ListenerLinkingCollector;", "Lcom/upuphone/xr/interconnect/business/connect/BaseConnectionListener;", "(Lcom/upuphone/xr/interconnect/business/connect/ListenerLinkingCollector;)V", "bleBoundGlassDeviceIds", "", "", "getBleBoundGlassDeviceIds", "()Ljava/util/Set;", "bleConnectedGlassDeviceIds", "getBleConnectedGlassDeviceIds", "boundRingDeviceIds", "getBoundRingDeviceIds", "brBoundGlassDeviceIds", "getBrBoundGlassDeviceIds", "brConnectedGlassDeviceIds", "glassDeviceInfoMap", "", "Lcom/upuphone/runasone/device/StarryDevice;", "getGlassDeviceInfoMap", "()Ljava/util/Map;", "listeners", "", "getListeners", "listeners$delegate", "Lkotlin/Lazy;", "onBindStateChangeForGlass", "", "device", "newState", "", "onBindStateChangeForRing", "onConnectStateChangeForGlass", "isBleConnected", "", "isBrConnected", "onConnectStateChangeForRing", "processBrUnbindingForGlass", "deviceId", "isBleBound", "reportGlassBleConnected", "reportGlassBothConnected", "reportGlassBrConnected", "reportGlassEvents", "isBleConnectEvent", "isBleDisconnectEvent", "isBrConnectEvent", "isBrDisconnectEvent", "updateSavedGlassDeviceIds", "SharedImpl_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nBaseConnectionManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BaseConnectionManager.kt\ncom/upuphone/xr/interconnect/business/connect/BaseConnectionManager\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,194:1\n1855#2,2:195\n1855#2,2:197\n1855#2,2:199\n1855#2,2:201\n1855#2,2:203\n1855#2,2:205\n1855#2,2:207\n1855#2,2:209\n1855#2,2:211\n*S KotlinDebug\n*F\n+ 1 BaseConnectionManager.kt\ncom/upuphone/xr/interconnect/business/connect/BaseConnectionManager\n*L\n42#1:195,2\n43#1:197,2\n47#1:199,2\n51#1:201,2\n71#1:203,2\n72#1:205,2\n74#1:207,2\n76#1:209,2\n106#1:211,2\n*E\n"})
public final class BaseConnectionManager extends PetaStepSerializer {
    @NotNull
    private final Set<String> bleBoundGlassDeviceIds = new HashSet();
    @NotNull
    private final Set<String> bleConnectedGlassDeviceIds = new HashSet();
    @NotNull
    private final Set<String> boundRingDeviceIds = new HashSet();
    @NotNull
    private final Set<String> brBoundGlassDeviceIds = new HashSet();
    /* access modifiers changed from: private */
    @NotNull
    public final Set<String> brConnectedGlassDeviceIds = new HashSet();
    @NotNull
    private final Map<String, StarryDevice> glassDeviceInfoMap = new HashMap();
    @NotNull
    private final Lazy listeners$delegate;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BaseConnectionManager(@NotNull ListenerLinkingCollector<BaseConnectionListener> listenerLinkingCollector) {
        super(AnonymousClass1.INSTANCE, (String) null, 2, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(listenerLinkingCollector, "listenerLinkingCollector");
        this.listeners$delegate = LazyKt.lazy(new BaseConnectionManager$listeners$2(listenerLinkingCollector));
    }

    /* access modifiers changed from: private */
    public final Set<BaseConnectionListener> getListeners() {
        return (Set) this.listeners$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final void processBrUnbindingForGlass(String str, StarryDevice starryDevice, boolean z) {
        if (this.brBoundGlassDeviceIds.remove(str)) {
            for (BaseConnectionListener onGlassBrUnbound : getListeners()) {
                onGlassBrUnbound.onGlassBrUnbound(str, starryDevice, z);
            }
        }
    }

    private final void reportGlassBleConnected(String str, StarryDevice starryDevice, boolean z) {
        for (BaseConnectionListener onGlassBleConnected : getListeners()) {
            onGlassBleConnected.onGlassBleConnected(str, starryDevice, z);
        }
    }

    private final void reportGlassBothConnected(String str, StarryDevice starryDevice) {
        for (BaseConnectionListener onGlassBleConnected : getListeners()) {
            onGlassBleConnected.onGlassBleConnected(str, starryDevice, false);
        }
        for (BaseConnectionListener onGlassBrConnected : getListeners()) {
            onGlassBrConnected.onGlassBrConnected(str, starryDevice, true);
        }
    }

    private final void reportGlassBrConnected(String str, StarryDevice starryDevice, boolean z) {
        for (BaseConnectionListener onGlassBrConnected : getListeners()) {
            onGlassBrConnected.onGlassBrConnected(str, starryDevice, z);
        }
    }

    /* access modifiers changed from: private */
    public final void reportGlassEvents(String str, StarryDevice starryDevice, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        if (z3 && z5) {
            reportGlassBothConnected(str, starryDevice);
        } else if (z3) {
            reportGlassBleConnected(str, starryDevice, z2);
        } else if (z5) {
            reportGlassBrConnected(str, starryDevice, z);
        } else if (z4 && z6) {
            for (BaseConnectionListener onGlassBrDisconnected : getListeners()) {
                onGlassBrDisconnected.onGlassBrDisconnected(str, starryDevice, true);
            }
            for (BaseConnectionListener onGlassBleDisconnected : getListeners()) {
                onGlassBleDisconnected.onGlassBleDisconnected(str, starryDevice, false);
            }
        } else if (z4) {
            for (BaseConnectionListener onGlassBleDisconnected2 : getListeners()) {
                onGlassBleDisconnected2.onGlassBleDisconnected(str, starryDevice, z2);
            }
        } else if (z6) {
            for (BaseConnectionListener onGlassBrDisconnected2 : getListeners()) {
                onGlassBrDisconnected2.onGlassBrDisconnected(str, starryDevice, z);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void updateSavedGlassDeviceIds(String str, boolean z, boolean z2, boolean z3, boolean z4) {
        if (z) {
            this.bleConnectedGlassDeviceIds.add(str);
        }
        if (z2) {
            this.bleConnectedGlassDeviceIds.remove(str);
        }
        if (z3) {
            this.brConnectedGlassDeviceIds.add(str);
        }
        if (z4) {
            this.brConnectedGlassDeviceIds.remove(str);
        }
    }

    @NotNull
    public final Set<String> getBleBoundGlassDeviceIds() {
        return this.bleBoundGlassDeviceIds;
    }

    @NotNull
    public final Set<String> getBleConnectedGlassDeviceIds() {
        return this.bleConnectedGlassDeviceIds;
    }

    @NotNull
    public final Set<String> getBoundRingDeviceIds() {
        return this.boundRingDeviceIds;
    }

    @NotNull
    public final Set<String> getBrBoundGlassDeviceIds() {
        return this.brBoundGlassDeviceIds;
    }

    @NotNull
    public final Map<String, StarryDevice> getGlassDeviceInfoMap() {
        return this.glassDeviceInfoMap;
    }

    public final void onBindStateChangeForGlass(@NotNull StarryDevice starryDevice, int i) {
        Intrinsics.checkNotNullParameter(starryDevice, "device");
        serialize("bind state change for glass", new BaseConnectionManager$onBindStateChangeForGlass$1(starryDevice, this, i));
    }

    public final void onBindStateChangeForRing(@NotNull StarryDevice starryDevice, int i) {
        Intrinsics.checkNotNullParameter(starryDevice, "device");
        serialize("bind state change for ring", new BaseConnectionManager$onBindStateChangeForRing$1(starryDevice, this, i));
    }

    public final void onConnectStateChangeForGlass(@NotNull StarryDevice starryDevice, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(starryDevice, "device");
        serialize("connect state change for glass", new BaseConnectionManager$onConnectStateChangeForGlass$1(starryDevice, this, z, z2));
    }

    public final void onConnectStateChangeForRing(@NotNull StarryDevice starryDevice, int i) {
        Intrinsics.checkNotNullParameter(starryDevice, "device");
        serialize("connect state change for ring", new BaseConnectionManager$onConnectStateChangeForRing$1(this, starryDevice, i));
    }
}
