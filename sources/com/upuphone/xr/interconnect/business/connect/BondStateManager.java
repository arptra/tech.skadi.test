package com.upuphone.xr.interconnect.business.connect;

import android.content.Context;
import com.upuphone.runasone.constant.Constants;
import com.upuphone.runasone.device.StarryDevice;
import com.upuphone.xr.interconnect.InterconnectManager;
import com.upuphone.xr.interconnect.business.connect.BaseConnectionListener;
import com.upuphone.xr.interconnect.entity.StarryDeviceExt;
import com.upuphone.xr.interconnect.entity.StarryNetDevice;
import com.upuphone.xr.interconnect.petastep.PetaStepSerializer;
import com.upuphone.xr.interconnect.util.XrSdkBondDeviceUtil;
import com.upuphone.xr.interconnect.util.log.ILog;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b \u0018\u00002\u00020\u00012\u00020\u0002B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006J\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\rH\u0004J\u0016\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\tJ\u0018\u0010 \u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020!H\u0016J\u0016\u0010\"\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020!J\u0018\u0010#\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\rH\u0004J\u0018\u0010$\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020!H\u0004R\u001e\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nX\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\r0\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R!\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u00158DX\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017¨\u0006%"}, d2 = {"Lcom/upuphone/xr/interconnect/business/connect/BondStateManager;", "Lcom/upuphone/xr/interconnect/petastep/PetaStepSerializer;", "Lcom/upuphone/xr/interconnect/business/connect/BaseConnectionListener;", "listenerLinkingCollector", "Lcom/upuphone/xr/interconnect/business/connect/ListenerLinkingCollector;", "Lcom/upuphone/xr/interconnect/business/connect/BondStateListener;", "(Lcom/upuphone/xr/interconnect/business/connect/ListenerLinkingCollector;)V", "bindingGlassDevices", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "boundDeviceList", "", "Lcom/upuphone/xr/interconnect/entity/StarryNetDevice;", "getBoundDeviceList", "()Ljava/util/List;", "boundGlassDeviceMap", "", "getBoundGlassDeviceMap", "()Ljava/util/Map;", "listeners", "", "getListeners", "()Ljava/util/Set;", "listeners$delegate", "Lkotlin/Lazy;", "addDevice", "", "deviceId", "device", "onDeviceRenamed", "newName", "onGlassBleBinding", "Lcom/upuphone/runasone/device/StarryDevice;", "onIosBinding", "removeDevice", "setDeviceBinding", "SharedImpl_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nBondStateManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BondStateManager.kt\ncom/upuphone/xr/interconnect/business/connect/BondStateManager\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,82:1\n1855#2,2:83\n1855#2,2:85\n1855#2,2:87\n*S KotlinDebug\n*F\n+ 1 BondStateManager.kt\ncom/upuphone/xr/interconnect/business/connect/BondStateManager\n*L\n25#1:83,2\n52#1:85,2\n66#1:87,2\n*E\n"})
public abstract class BondStateManager extends PetaStepSerializer implements BaseConnectionListener {
    @NotNull
    private final HashSet<String> bindingGlassDevices = new HashSet<>();
    @NotNull
    private final Map<String, StarryNetDevice> boundGlassDeviceMap = new ConcurrentHashMap();
    @NotNull
    private final Lazy listeners$delegate;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BondStateManager(@NotNull ListenerLinkingCollector<BondStateListener> listenerLinkingCollector) {
        super(AnonymousClass1.INSTANCE, (String) null, 2, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(listenerLinkingCollector, "listenerLinkingCollector");
        this.listeners$delegate = LazyKt.lazy(new BondStateManager$listeners$2(listenerLinkingCollector));
    }

    public final void addDevice(@NotNull String str, @NotNull StarryNetDevice starryNetDevice) {
        Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
        Intrinsics.checkNotNullParameter(starryNetDevice, "device");
        String tag = getTag();
        ILog.d(tag, "#" + str + " is bound.");
        this.bindingGlassDevices.remove(str);
        Map<String, StarryNetDevice> map = this.boundGlassDeviceMap;
        for (BondStateListener onBound : getListeners()) {
            onBound.onBound(starryNetDevice);
        }
        map.put(str, starryNetDevice);
        XrSdkBondDeviceUtil xrSdkBondDeviceUtil = XrSdkBondDeviceUtil.INSTANCE;
        if (xrSdkBondDeviceUtil.checkDeviceTypeIsGlass(starryNetDevice.getTerminalType())) {
            ILog.e(getTag(), "cancelTimeOutJob after addDevice");
            xrSdkBondDeviceUtil.cancelTimeOutJob("bound");
            Context context = InterconnectManager.getInstance().getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            xrSdkBondDeviceUtil.saveBondedGlassDeviceFromSp(context, starryNetDevice);
        }
    }

    @NotNull
    public final List<StarryNetDevice> getBoundDeviceList() {
        return CollectionsKt.toList(this.boundGlassDeviceMap.values());
    }

    @NotNull
    public final Map<String, StarryNetDevice> getBoundGlassDeviceMap() {
        return this.boundGlassDeviceMap;
    }

    @NotNull
    public final Set<BondStateListener> getListeners() {
        return (Set) this.listeners$delegate.getValue();
    }

    public final void onDeviceRenamed(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
        Intrinsics.checkNotNullParameter(str2, "newName");
        serialize("device renaming", new BondStateManager$onDeviceRenamed$1(this, str, str2));
    }

    public void onGlassBleBinding(@NotNull String str, @NotNull StarryDevice starryDevice) {
        Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
        Intrinsics.checkNotNullParameter(starryDevice, "device");
        serialize("ble binding", new BondStateManager$onGlassBleBinding$1(this, str, starryDevice));
    }

    public void onGlassBleBound(@NotNull String str, @NotNull StarryDevice starryDevice, boolean z) {
        BaseConnectionListener.DefaultImpls.onGlassBleBound(this, str, starryDevice, z);
    }

    public void onGlassBleConnected(@NotNull String str, @NotNull StarryDevice starryDevice, boolean z) {
        BaseConnectionListener.DefaultImpls.onGlassBleConnected(this, str, starryDevice, z);
    }

    public void onGlassBleConnectedDeviceUpdate(@NotNull String str, @NotNull StarryDevice starryDevice, boolean z) {
        BaseConnectionListener.DefaultImpls.onGlassBleConnectedDeviceUpdate(this, str, starryDevice, z);
    }

    public void onGlassBleDisconnected(@NotNull String str, @NotNull StarryDevice starryDevice, boolean z) {
        BaseConnectionListener.DefaultImpls.onGlassBleDisconnected(this, str, starryDevice, z);
    }

    public void onGlassBleUnbound(@NotNull String str, @NotNull StarryDevice starryDevice, boolean z) {
        BaseConnectionListener.DefaultImpls.onGlassBleUnbound(this, str, starryDevice, z);
    }

    public void onGlassBrBound(@NotNull String str, @NotNull StarryDevice starryDevice, boolean z) {
        BaseConnectionListener.DefaultImpls.onGlassBrBound(this, str, starryDevice, z);
    }

    public void onGlassBrConnected(@NotNull String str, @NotNull StarryDevice starryDevice, boolean z) {
        BaseConnectionListener.DefaultImpls.onGlassBrConnected(this, str, starryDevice, z);
    }

    public void onGlassBrDisconnected(@NotNull String str, @NotNull StarryDevice starryDevice, boolean z) {
        BaseConnectionListener.DefaultImpls.onGlassBrDisconnected(this, str, starryDevice, z);
    }

    public void onGlassBrUnbound(@NotNull String str, @NotNull StarryDevice starryDevice, boolean z) {
        BaseConnectionListener.DefaultImpls.onGlassBrUnbound(this, str, starryDevice, z);
    }

    public final void onIosBinding(@NotNull String str, @NotNull StarryDevice starryDevice) {
        Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
        Intrinsics.checkNotNullParameter(starryDevice, "device");
        serialize("ios entering binding process", new BondStateManager$onIosBinding$1(this, str, starryDevice));
    }

    public void onRingBinding(@NotNull String str, @NotNull StarryDevice starryDevice) {
        BaseConnectionListener.DefaultImpls.onRingBinding(this, str, starryDevice);
    }

    public void onRingBound(@NotNull String str, @NotNull StarryDevice starryDevice) {
        BaseConnectionListener.DefaultImpls.onRingBound(this, str, starryDevice);
    }

    public void onRingConnected(@NotNull String str, @NotNull StarryDevice starryDevice) {
        BaseConnectionListener.DefaultImpls.onRingConnected(this, str, starryDevice);
    }

    public void onRingConnectedDeviceUpdate(@NotNull String str, @NotNull StarryDevice starryDevice) {
        BaseConnectionListener.DefaultImpls.onRingConnectedDeviceUpdate(this, str, starryDevice);
    }

    public void onRingDisconnected(@NotNull String str, @NotNull StarryDevice starryDevice) {
        BaseConnectionListener.DefaultImpls.onRingDisconnected(this, str, starryDevice);
    }

    public void onRingUnbound(@NotNull String str, @NotNull StarryDevice starryDevice) {
        BaseConnectionListener.DefaultImpls.onRingUnbound(this, str, starryDevice);
    }

    public void onSetAllConnectionDisconnected() {
        BaseConnectionListener.DefaultImpls.onSetAllConnectionDisconnected(this);
    }

    public final void removeDevice(@NotNull String str, @NotNull StarryNetDevice starryNetDevice) {
        Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
        Intrinsics.checkNotNullParameter(starryNetDevice, "device");
        String tag = getTag();
        ILog.d(tag, "#" + str + " is unbound.");
        if (this.bindingGlassDevices.remove(str) || this.boundGlassDeviceMap.remove(str) != null) {
            for (BondStateListener onUnbound : getListeners()) {
                onUnbound.onUnbound(starryNetDevice);
            }
        }
        XrSdkBondDeviceUtil xrSdkBondDeviceUtil = XrSdkBondDeviceUtil.INSTANCE;
        if (xrSdkBondDeviceUtil.checkDeviceTypeIsGlass(starryNetDevice.getTerminalType())) {
            ILog.e(getTag(), "removeDevice if is glass  clearBondedGlassDeviceFromSp");
            Context context = InterconnectManager.getInstance().getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            xrSdkBondDeviceUtil.clearBondedGlassDeviceFromSp(context);
        }
    }

    public final void setDeviceBinding(@NotNull String str, @NotNull StarryDevice starryDevice) {
        Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
        Intrinsics.checkNotNullParameter(starryDevice, "device");
        String tag = getTag();
        ILog.d(tag, "#" + str + " is said to be binding.");
        if (!this.bindingGlassDevices.contains(str) && !this.boundGlassDeviceMap.containsKey(str)) {
            this.bindingGlassDevices.add(str);
            for (BondStateListener onBinding : getListeners()) {
                onBinding.onBinding(StarryDeviceExt.wrapForConnection(starryDevice));
            }
        }
    }
}
