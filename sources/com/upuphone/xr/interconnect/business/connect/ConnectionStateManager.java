package com.upuphone.xr.interconnect.business.connect;

import com.upuphone.runasone.constant.Constants;
import com.upuphone.runasone.device.StarryDevice;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.interconnect.business.connect.BaseConnectionListener;
import com.upuphone.xr.interconnect.entity.DeviceWrapper;
import com.upuphone.xr.interconnect.entity.StarryDeviceExt;
import com.upuphone.xr.interconnect.entity.StarryNetDevice;
import com.upuphone.xr.interconnect.petastep.PetaStepSerializer;
import com.upuphone.xr.interconnect.util.XrSdkBondDeviceUtil;
import com.upuphone.xr.interconnect.util.log.ILog;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.eclipse.jetty.util.ConcurrentHashSet;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0017\b \u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B)\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\b¢\u0006\u0002\u0010\fJ\u0018\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\u00112\u0006\u0010;\u001a\u00020\u001eH\u0004J \u0010<\u001a\u0002092\u0006\u0010=\u001a\u00020(2\u0006\u0010>\u001a\u00020.2\u0006\u0010:\u001a\u00020\u0011H\u0004J\u0010\u0010?\u001a\u0004\u0018\u00010\u001e2\u0006\u0010@\u001a\u00020(J\u0010\u0010A\u001a\u0004\u0018\u00010\u001e2\u0006\u0010>\u001a\u00020.J\u000e\u0010B\u001a\u00020C2\u0006\u0010>\u001a\u00020.J\u0010\u0010D\u001a\u0002092\u0006\u0010:\u001a\u00020\u001eH\u0016J\u0010\u0010E\u001a\u0002092\u0006\u0010:\u001a\u00020\u001eH\u0016J\u0016\u0010F\u001a\u0002092\u0006\u0010>\u001a\u00020.2\u0006\u0010G\u001a\u00020.J \u0010H\u001a\u0002092\u0006\u0010>\u001a\u00020.2\u0006\u0010:\u001a\u00020\u00112\u0006\u0010I\u001a\u00020CH\u0016J \u0010J\u001a\u0002092\u0006\u0010>\u001a\u00020.2\u0006\u0010:\u001a\u00020\u00112\u0006\u0010I\u001a\u00020CH\u0016J \u0010K\u001a\u0002092\u0006\u0010>\u001a\u00020.2\u0006\u0010:\u001a\u00020\u00112\u0006\u0010L\u001a\u00020CH\u0016J\u0018\u0010M\u001a\u0002092\u0006\u0010>\u001a\u00020.2\u0006\u0010:\u001a\u00020\u0011H\u0016J\u0018\u0010N\u001a\u0002092\u0006\u0010>\u001a\u00020.2\u0006\u0010:\u001a\u00020\u0011H\u0016J\u0018\u0010O\u001a\u0002092\u0006\u0010>\u001a\u00020.2\u0006\u0010:\u001a\u00020\u0011H\u0016J\u0018\u0010P\u001a\u0002092\u0006\u0010>\u001a\u00020.2\u0006\u0010:\u001a\u00020\u0011H\u0016J\u0018\u0010Q\u001a\u0002092\u0006\u0010>\u001a\u00020.2\u0006\u0010:\u001a\u00020\u0011H\u0016J\u0018\u0010R\u001a\u0002092\u0006\u0010>\u001a\u00020.2\u0006\u0010:\u001a\u00020\u0011H\u0016J\u0018\u0010S\u001a\u0002092\u0006\u0010>\u001a\u00020.2\u0006\u0010:\u001a\u00020\u0011H\u0016J\b\u0010T\u001a\u000209H\u0016J\u0010\u0010U\u001a\u0002092\u0006\u0010:\u001a\u00020\u001eH\u0016J\u0010\u0010V\u001a\u0002092\u0006\u0010W\u001a\u00020\u000fH\u0002J \u0010X\u001a\u0002092\u0006\u0010=\u001a\u00020(2\u0006\u0010>\u001a\u00020.2\u0006\u0010:\u001a\u00020\u0011H\u0002J\u0016\u0010Y\u001a\u0002092\u0006\u0010:\u001a\u00020\u00112\u0006\u0010;\u001a\u00020\u001eR\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u00118F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u00118F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0013R\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u001e8F¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0013\u0010!\u001a\u0004\u0018\u00010\u00118F¢\u0006\u0006\u001a\u0004\b\"\u0010\u0013R\u0013\u0010#\u001a\u0004\u0018\u00010\u001e8F¢\u0006\u0006\u001a\u0004\b$\u0010 R\u0010\u0010%\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010&\u001a\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u000f0'X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010)\u001a\b\u0012\u0004\u0012\u00020\u000f0*8F¢\u0006\u0006\u001a\u0004\b+\u0010,R\u001a\u0010-\u001a\b\u0012\u0004\u0012\u00020.0\u000eX\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u001aR\u0010\u00100\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R!\u00101\u001a\b\u0012\u0004\u0012\u00020\t0\u00188BX\u0002¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b2\u0010\u001aR!\u00105\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00188BX\u0002¢\u0006\f\n\u0004\b7\u00104\u001a\u0004\b6\u0010\u001a¨\u0006Z"}, d2 = {"Lcom/upuphone/xr/interconnect/business/connect/ConnectionStateManager;", "Lcom/upuphone/xr/interconnect/petastep/PetaStepSerializer;", "Lcom/upuphone/xr/interconnect/business/connect/BondStateListener;", "Lcom/upuphone/xr/interconnect/business/connect/BaseConnectionListener;", "Lcom/upuphone/xr/interconnect/business/connect/BaseConnectionIosConnectingListener;", "bondStateManager", "Lcom/upuphone/xr/interconnect/business/connect/BondStateManager;", "listenerLinkingCollector", "Lcom/upuphone/xr/interconnect/business/connect/ListenerLinkingCollector;", "Lcom/upuphone/xr/interconnect/business/connect/ConnectionStateListener;", "primaryDeviceConnectionListenerLinkingCollector", "Lcom/upuphone/xr/interconnect/business/connect/BlePrimaryDeviceConnectionListener;", "(Lcom/upuphone/xr/interconnect/business/connect/BondStateManager;Lcom/upuphone/xr/interconnect/business/connect/ListenerLinkingCollector;Lcom/upuphone/xr/interconnect/business/connect/ListenerLinkingCollector;)V", "_connectedPrimaryDevices", "", "Lcom/upuphone/xr/interconnect/entity/DeviceWrapper;", "bleConnectedPrimaryStarryDevice", "Lcom/upuphone/runasone/device/StarryDevice;", "getBleConnectedPrimaryStarryDevice", "()Lcom/upuphone/runasone/device/StarryDevice;", "getBondStateManager", "()Lcom/upuphone/xr/interconnect/business/connect/BondStateManager;", "connectedGlassDevice", "connectedPrimaryDevices", "", "getConnectedPrimaryDevices", "()Ljava/util/Set;", "connectedPrimaryGlassStarryDevice", "getConnectedPrimaryGlassStarryDevice", "connectedPrimaryGlassStarryNetDevice", "Lcom/upuphone/xr/interconnect/entity/StarryNetDevice;", "getConnectedPrimaryGlassStarryNetDevice", "()Lcom/upuphone/xr/interconnect/entity/StarryNetDevice;", "connectedPrimaryRingStarryDevice", "getConnectedPrimaryRingStarryDevice", "connectedPrimaryRingStarryNetDevice", "getConnectedPrimaryRingStarryNetDevice", "connectedRingDevice", "connectedSecondaryDeviceMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "connectedSecondaryDevices", "", "getConnectedSecondaryDevices", "()Ljava/util/Collection;", "connectingIosDeviceIds", "", "getConnectingIosDeviceIds", "glassBleConnectedDevice", "listeners", "getListeners", "listeners$delegate", "Lkotlin/Lazy;", "primaryDeviceConnectionListeners", "getPrimaryDeviceConnectionListeners", "primaryDeviceConnectionListeners$delegate", "addPrimaryGlassDevice", "", "device", "wrappedDevice", "addSecondaryGlassDevice", "terminalType", "deviceId", "getConnectedDevice", "type", "getConnectedPrimaryDevice", "isConnectedDevice", "", "onBinding", "onBound", "onDeviceRenamed", "newName", "onGlassBleConnectedDeviceUpdate", "isBrConnected", "onGlassBleDisconnected", "onGlassBrDisconnected", "isBleConnected", "onIosConnecting", "onRingBinding", "onRingBound", "onRingConnected", "onRingConnectedDeviceUpdate", "onRingDisconnected", "onRingUnbound", "onSetAllConnectionDisconnected", "onUnbound", "removePrimaryGlassDevice", "deviceWrapper", "removeSecondaryGlassDevice", "setBleConnectDevice", "SharedImpl_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nConnectionStateManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConnectionStateManager.kt\ncom/upuphone/xr/interconnect/business/connect/ConnectionStateManager\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,312:1\n1747#2,3:313\n288#2,2:316\n288#2,2:318\n1747#2,3:320\n1855#2,2:323\n1855#2,2:325\n1855#2,2:327\n1855#2,2:329\n1855#2,2:331\n1855#2,2:333\n1855#2,2:335\n1855#2,2:337\n1855#2,2:339\n1855#2,2:341\n1855#2,2:343\n*S KotlinDebug\n*F\n+ 1 ConnectionStateManager.kt\ncom/upuphone/xr/interconnect/business/connect/ConnectionStateManager\n*L\n53#1:313,3\n55#1:316,2\n57#1:318,2\n67#1:320,3\n78#1:323,2\n81#1:325,2\n90#1:327,2\n93#1:329,2\n113#1:331,2\n123#1:333,2\n234#1:335,2\n246#1:337,2\n249#1:339,2\n267#1:341,2\n270#1:343,2\n*E\n"})
public abstract class ConnectionStateManager extends PetaStepSerializer implements BondStateListener, BaseConnectionListener, BaseConnectionIosConnectingListener {
    /* access modifiers changed from: private */
    @NotNull
    public final Set<DeviceWrapper> _connectedPrimaryDevices;
    @NotNull
    private final BondStateManager bondStateManager;
    /* access modifiers changed from: private */
    @Nullable
    public volatile DeviceWrapper connectedGlassDevice;
    @NotNull
    private final Set<DeviceWrapper> connectedPrimaryDevices;
    /* access modifiers changed from: private */
    @Nullable
    public volatile DeviceWrapper connectedRingDevice;
    /* access modifiers changed from: private */
    @NotNull
    public final ConcurrentHashMap<Byte, DeviceWrapper> connectedSecondaryDeviceMap = new ConcurrentHashMap<>();
    @NotNull
    private final Set<String> connectingIosDeviceIds = new HashSet();
    @Nullable
    private volatile DeviceWrapper glassBleConnectedDevice;
    @NotNull
    private final Lazy listeners$delegate;
    @NotNull
    private final Lazy primaryDeviceConnectionListeners$delegate;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ConnectionStateManager(@NotNull BondStateManager bondStateManager2, @NotNull ListenerLinkingCollector<ConnectionStateListener> listenerLinkingCollector, @NotNull ListenerLinkingCollector<BlePrimaryDeviceConnectionListener> listenerLinkingCollector2) {
        super(AnonymousClass1.INSTANCE, (String) null, 2, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(bondStateManager2, "bondStateManager");
        Intrinsics.checkNotNullParameter(listenerLinkingCollector, "listenerLinkingCollector");
        Intrinsics.checkNotNullParameter(listenerLinkingCollector2, "primaryDeviceConnectionListenerLinkingCollector");
        this.bondStateManager = bondStateManager2;
        ConcurrentHashSet concurrentHashSet = new ConcurrentHashSet();
        this._connectedPrimaryDevices = concurrentHashSet;
        this.listeners$delegate = LazyKt.lazy(new ConnectionStateManager$listeners$2(listenerLinkingCollector));
        this.primaryDeviceConnectionListeners$delegate = LazyKt.lazy(new ConnectionStateManager$primaryDeviceConnectionListeners$2(listenerLinkingCollector2));
        this.connectedPrimaryDevices = concurrentHashSet;
    }

    /* access modifiers changed from: private */
    public final Set<ConnectionStateListener> getListeners() {
        return (Set) this.listeners$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final Set<BlePrimaryDeviceConnectionListener> getPrimaryDeviceConnectionListeners() {
        return (Set) this.primaryDeviceConnectionListeners$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final void removePrimaryGlassDevice(DeviceWrapper deviceWrapper) {
        String tag = getTag();
        String id = deviceWrapper.getId();
        byte terminalType = deviceWrapper.getDevice().getTerminalType();
        ILog.w(tag, "removePrimaryDevice device = " + id + ",type = " + terminalType);
        this._connectedPrimaryDevices.remove(deviceWrapper);
        for (ConnectionStateListener onPrimaryConnectionDisconnected : getListeners()) {
            StarryNetDevice device = deviceWrapper.getDevice();
            Intrinsics.checkNotNullExpressionValue(device, "getDevice(...)");
            onPrimaryConnectionDisconnected.onPrimaryConnectionDisconnected(device);
        }
        for (BlePrimaryDeviceConnectionListener onBlePrimaryDeviceDisconnected : getPrimaryDeviceConnectionListeners()) {
            StarryNetDevice device2 = deviceWrapper.getDevice();
            Intrinsics.checkNotNullExpressionValue(device2, "getDevice(...)");
            onBlePrimaryDeviceDisconnected.onBlePrimaryDeviceDisconnected(device2);
        }
        if (XrSdkBondDeviceUtil.INSTANCE.checkDeviceTypeIsGlass(deviceWrapper.getDevice().getTerminalType())) {
            ULog.f6446a.c("PetaStepSerializer", "removePrimaryDevice checkDeviceTypeIsGlass is true");
            DeviceWrapper deviceWrapper2 = this.connectedGlassDevice;
            if (Intrinsics.areEqual((Object) deviceWrapper2 != null ? deviceWrapper2.getId() : null, (Object) deviceWrapper.getId())) {
                this.connectedGlassDevice = null;
            }
        }
        DeviceWrapper deviceWrapper3 = this.glassBleConnectedDevice;
        if (Intrinsics.areEqual((Object) deviceWrapper3 != null ? deviceWrapper3.getId() : null, (Object) deviceWrapper.getId())) {
            ULog.f6446a.c("PetaStepSerializer", "removePrimaryDevice set bleConnectedDevice = null");
            this.glassBleConnectedDevice = null;
        }
    }

    /* access modifiers changed from: private */
    public final void removeSecondaryGlassDevice(byte b, String str, StarryDevice starryDevice) {
        for (ConnectionStateListener onSecondaryConnectionDisconnected : getListeners()) {
            onSecondaryConnectionDisconnected.onSecondaryConnectionDisconnected(StarryDeviceExt.wrapForConnection(starryDevice));
        }
        DeviceWrapper deviceWrapper = this.connectedSecondaryDeviceMap.get(Byte.valueOf(b));
        if (Intrinsics.areEqual((Object) deviceWrapper != null ? deviceWrapper.getId() : null, (Object) str)) {
            String tag = getTag();
            ILog.d(tag, "Removing connected type-" + b + " device #" + str + ".");
            this.connectedSecondaryDeviceMap.remove(Byte.valueOf(b));
        }
    }

    public final void addPrimaryGlassDevice(@NotNull StarryDevice starryDevice, @NotNull StarryNetDevice starryNetDevice) {
        Intrinsics.checkNotNullParameter(starryDevice, "device");
        Intrinsics.checkNotNullParameter(starryNetDevice, "wrappedDevice");
        String tag = getTag();
        String id = starryDevice.getId();
        byte terminalType = starryDevice.getTerminalType();
        ILog.w(tag, "addPrimaryDevice device = " + id + ",type = " + terminalType);
        Set<DeviceWrapper> set = this._connectedPrimaryDevices;
        if (!(set instanceof Collection) || !set.isEmpty()) {
            for (DeviceWrapper id2 : set) {
                if (Intrinsics.areEqual((Object) id2.getId(), (Object) starryDevice.getId())) {
                    String tag2 = getTag();
                    String id3 = starryDevice.getId();
                    ILog.d(tag2, "Not re-adding already connected device #" + id3 + ".");
                    return;
                }
            }
        }
        if (XrSdkBondDeviceUtil.INSTANCE.checkDeviceTypeIsGlass(starryDevice.getTerminalType())) {
            ULog.f6446a.c("PetaStepSerializer", "addPrimaryDevice checkDeviceTypeIsGlass is true");
            Set<DeviceWrapper> set2 = this._connectedPrimaryDevices;
            DeviceWrapper deviceWrapper = new DeviceWrapper(starryDevice, starryNetDevice);
            this.connectedGlassDevice = deviceWrapper;
            set2.add(deviceWrapper);
        }
        for (ConnectionStateListener onPrimaryConnectionConnected : getListeners()) {
            onPrimaryConnectionConnected.onPrimaryConnectionConnected(starryNetDevice);
        }
        for (BlePrimaryDeviceConnectionListener onBlePrimaryDeviceConnected : getPrimaryDeviceConnectionListeners()) {
            onBlePrimaryDeviceConnected.onBlePrimaryDeviceConnected(starryNetDevice);
        }
    }

    public final void addSecondaryGlassDevice(byte b, @NotNull String str, @NotNull StarryDevice starryDevice) {
        Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
        Intrinsics.checkNotNullParameter(starryDevice, "device");
        DeviceWrapper deviceWrapper = this.connectedSecondaryDeviceMap.get(Byte.valueOf(b));
        StarryNetDevice wrapForConnection = StarryDeviceExt.wrapForConnection(starryDevice);
        for (ConnectionStateListener onSecondaryConnectionConnected : getListeners()) {
            onSecondaryConnectionConnected.onSecondaryConnectionConnected(wrapForConnection);
        }
        String str2 = null;
        if (!Intrinsics.areEqual((Object) deviceWrapper != null ? deviceWrapper.getId() : null, (Object) str)) {
            String tag = getTag();
            if (deviceWrapper != null) {
                str2 = deviceWrapper.getId();
            }
            ILog.d(tag, "Replacing connected type-" + b + " device #" + str2 + " with #" + str + ".");
            this.connectedSecondaryDeviceMap.put(Byte.valueOf(b), new DeviceWrapper(starryDevice, wrapForConnection));
        }
    }

    @Nullable
    public final StarryDevice getBleConnectedPrimaryStarryDevice() {
        DeviceWrapper deviceWrapper = this.glassBleConnectedDevice;
        if (deviceWrapper != null) {
            return deviceWrapper.getOriginDevice();
        }
        return null;
    }

    @NotNull
    public final BondStateManager getBondStateManager() {
        return this.bondStateManager;
    }

    @Nullable
    public final StarryNetDevice getConnectedDevice(byte b) {
        T t;
        DeviceWrapper deviceWrapper = this.connectedSecondaryDeviceMap.get(Byte.valueOf(b));
        if (deviceWrapper == null) {
            Iterator<T> it = this.connectedPrimaryDevices.iterator();
            while (true) {
                if (!it.hasNext()) {
                    t = null;
                    break;
                }
                t = it.next();
                if (((DeviceWrapper) t).getOriginDevice().getTerminalType() == b) {
                    break;
                }
            }
            deviceWrapper = (DeviceWrapper) t;
        }
        if (deviceWrapper != null) {
            return deviceWrapper.getDevice();
        }
        return null;
    }

    @Nullable
    public final StarryNetDevice getConnectedPrimaryDevice(@NotNull String str) {
        T t;
        Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
        Iterator<T> it = this._connectedPrimaryDevices.iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            t = it.next();
            if (Intrinsics.areEqual((Object) ((DeviceWrapper) t).getId(), (Object) str)) {
                break;
            }
        }
        DeviceWrapper deviceWrapper = (DeviceWrapper) t;
        if (deviceWrapper != null) {
            return deviceWrapper.getDevice();
        }
        return null;
    }

    @NotNull
    public final Set<DeviceWrapper> getConnectedPrimaryDevices() {
        return this.connectedPrimaryDevices;
    }

    @Nullable
    public final StarryDevice getConnectedPrimaryGlassStarryDevice() {
        DeviceWrapper deviceWrapper = this.connectedGlassDevice;
        if (deviceWrapper != null) {
            return deviceWrapper.getOriginDevice();
        }
        return null;
    }

    @Nullable
    public final StarryNetDevice getConnectedPrimaryGlassStarryNetDevice() {
        DeviceWrapper deviceWrapper = this.connectedGlassDevice;
        if (deviceWrapper != null) {
            return deviceWrapper.getDevice();
        }
        return null;
    }

    @Nullable
    public final StarryDevice getConnectedPrimaryRingStarryDevice() {
        DeviceWrapper deviceWrapper = this.connectedRingDevice;
        if (deviceWrapper != null) {
            return deviceWrapper.getOriginDevice();
        }
        return null;
    }

    @Nullable
    public final StarryNetDevice getConnectedPrimaryRingStarryNetDevice() {
        DeviceWrapper deviceWrapper = this.connectedRingDevice;
        if (deviceWrapper != null) {
            return deviceWrapper.getDevice();
        }
        return null;
    }

    @NotNull
    public final Collection<DeviceWrapper> getConnectedSecondaryDevices() {
        Collection<DeviceWrapper> values = this.connectedSecondaryDeviceMap.values();
        Intrinsics.checkNotNullExpressionValue(values, "<get-values>(...)");
        return values;
    }

    @NotNull
    public final Set<String> getConnectingIosDeviceIds() {
        return this.connectingIosDeviceIds;
    }

    public final boolean isConnectedDevice(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
        Set<DeviceWrapper> set = this.connectedPrimaryDevices;
        if (!(set instanceof Collection) || !set.isEmpty()) {
            Iterator<T> it = set.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (Intrinsics.areEqual((Object) ((DeviceWrapper) it.next()).getId(), (Object) str)) {
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        Collection<DeviceWrapper> connectedSecondaryDevices = getConnectedSecondaryDevices();
        if (!(connectedSecondaryDevices instanceof Collection) || !connectedSecondaryDevices.isEmpty()) {
            for (DeviceWrapper id : connectedSecondaryDevices) {
                if (Intrinsics.areEqual((Object) id.getId(), (Object) str)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void onBinding(@NotNull StarryNetDevice starryNetDevice) {
        Intrinsics.checkNotNullParameter(starryNetDevice, "device");
        serialize("binding", new ConnectionStateManager$onBinding$1(this, starryNetDevice));
    }

    public void onBound(@NotNull StarryNetDevice starryNetDevice) {
        Intrinsics.checkNotNullParameter(starryNetDevice, "device");
        serialize("bound", new ConnectionStateManager$onBound$1(this, starryNetDevice));
    }

    public final void onDeviceRenamed(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
        Intrinsics.checkNotNullParameter(str2, "newName");
        serialize("update device name", new ConnectionStateManager$onDeviceRenamed$1(this, str, str2));
    }

    public void onGlassBleBinding(@NotNull String str, @NotNull StarryDevice starryDevice) {
        BaseConnectionListener.DefaultImpls.onGlassBleBinding(this, str, starryDevice);
    }

    public void onGlassBleBound(@NotNull String str, @NotNull StarryDevice starryDevice, boolean z) {
        BaseConnectionListener.DefaultImpls.onGlassBleBound(this, str, starryDevice, z);
    }

    public void onGlassBleConnected(@NotNull String str, @NotNull StarryDevice starryDevice, boolean z) {
        BaseConnectionListener.DefaultImpls.onGlassBleConnected(this, str, starryDevice, z);
    }

    public void onGlassBleConnectedDeviceUpdate(@NotNull String str, @NotNull StarryDevice starryDevice, boolean z) {
        Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
        Intrinsics.checkNotNullParameter(starryDevice, "device");
        serialize("ble info update", new ConnectionStateManager$onGlassBleConnectedDeviceUpdate$1(starryDevice, this, str));
    }

    public void onGlassBleDisconnected(@NotNull String str, @NotNull StarryDevice starryDevice, boolean z) {
        Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
        Intrinsics.checkNotNullParameter(starryDevice, "device");
        serialize("ble disconnection", new ConnectionStateManager$onGlassBleDisconnected$1(starryDevice, this, str, z));
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
        Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
        Intrinsics.checkNotNullParameter(starryDevice, "device");
        serialize("br disconnection", new ConnectionStateManager$onGlassBrDisconnected$1(starryDevice, this, str, z));
    }

    public void onGlassBrUnbound(@NotNull String str, @NotNull StarryDevice starryDevice, boolean z) {
        BaseConnectionListener.DefaultImpls.onGlassBrUnbound(this, str, starryDevice, z);
    }

    public void onIosConnecting(@NotNull String str, @NotNull StarryDevice starryDevice) {
        Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
        Intrinsics.checkNotNullParameter(starryDevice, "device");
        serialize("ios connecting confirmation", new ConnectionStateManager$onIosConnecting$1(this, str, starryDevice));
    }

    public void onRingBinding(@NotNull String str, @NotNull StarryDevice starryDevice) {
        Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
        Intrinsics.checkNotNullParameter(starryDevice, "device");
        serialize("onRingBound", new ConnectionStateManager$onRingBinding$1(str));
    }

    public void onRingBound(@NotNull String str, @NotNull StarryDevice starryDevice) {
        Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
        Intrinsics.checkNotNullParameter(starryDevice, "device");
        serialize("onRingBound", new ConnectionStateManager$onRingBound$1(str, this, starryDevice));
    }

    public void onRingConnected(@NotNull String str, @NotNull StarryDevice starryDevice) {
        Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
        Intrinsics.checkNotNullParameter(starryDevice, "device");
        ILog.e("PetaStepSerializer", "onRingConnected deviceId = " + str);
        if (XrSdkBondDeviceUtil.INSTANCE.checkDeviceTypeIsRing(starryDevice.getTerminalType())) {
            ULog.f6446a.c("PetaStepSerializer", "onRingConnected checkDeviceTypeIsRing is true");
            this.connectedRingDevice = new DeviceWrapper(starryDevice, StarryDeviceExt.wrapForConnection(starryDevice));
            for (ConnectionStateListener onPrimaryConnectionConnected : getListeners()) {
                DeviceWrapper deviceWrapper = this.connectedRingDevice;
                Intrinsics.checkNotNull(deviceWrapper);
                StarryNetDevice device = deviceWrapper.getDevice();
                Intrinsics.checkNotNullExpressionValue(device, "getDevice(...)");
                onPrimaryConnectionConnected.onPrimaryConnectionConnected(device);
            }
            for (BlePrimaryDeviceConnectionListener onBlePrimaryDeviceConnected : getPrimaryDeviceConnectionListeners()) {
                DeviceWrapper deviceWrapper2 = this.connectedRingDevice;
                Intrinsics.checkNotNull(deviceWrapper2);
                StarryNetDevice device2 = deviceWrapper2.getDevice();
                Intrinsics.checkNotNullExpressionValue(device2, "getDevice(...)");
                onBlePrimaryDeviceConnected.onBlePrimaryDeviceConnected(device2);
            }
        }
    }

    public void onRingConnectedDeviceUpdate(@NotNull String str, @NotNull StarryDevice starryDevice) {
        Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
        Intrinsics.checkNotNullParameter(starryDevice, "device");
        serialize("onRingConnectedDeviceUpdate", new ConnectionStateManager$onRingConnectedDeviceUpdate$1(str));
    }

    public void onRingDisconnected(@NotNull String str, @NotNull StarryDevice starryDevice) {
        Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
        Intrinsics.checkNotNullParameter(starryDevice, "device");
        serialize("onRingDisconnected", new ConnectionStateManager$onRingDisconnected$1(str, starryDevice, this));
    }

    public void onRingUnbound(@NotNull String str, @NotNull StarryDevice starryDevice) {
        Intrinsics.checkNotNullParameter(str, Constants.DEVICE_ID);
        Intrinsics.checkNotNullParameter(starryDevice, "device");
        serialize("onRingBound", new ConnectionStateManager$onRingUnbound$1(str, this, starryDevice));
    }

    public void onSetAllConnectionDisconnected() {
        int size = this.connectedSecondaryDeviceMap.size();
        ILog.e("PetaStepSerializer", "onSetAllConnectionDisconnected start connectedSecondaryDeviceMap size = " + size);
        int size2 = this._connectedPrimaryDevices.size();
        ILog.e("PetaStepSerializer", "onSetAllConnectionDisconnected start _connectedPrimaryDevices size = " + size2);
        Iterator<Map.Entry<Byte, DeviceWrapper>> it = this.connectedSecondaryDeviceMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry next = it.next();
            Object key = next.getKey();
            StarryNetDevice device = ((DeviceWrapper) next.getValue()).getDevice();
            ILog.e("PetaStepSerializer", "onSetAllConnectionDisconnected connectedSecondary DeviceMap key = " + key + " element = " + device);
            for (ConnectionStateListener onSecondaryConnectionDisconnected : getListeners()) {
                StarryDevice originDevice = ((DeviceWrapper) next.getValue()).getOriginDevice();
                Intrinsics.checkNotNullExpressionValue(originDevice, "getOriginDevice(...)");
                onSecondaryConnectionDisconnected.onSecondaryConnectionDisconnected(StarryDeviceExt.wrapForConnection(originDevice));
            }
            it.remove();
        }
        ILog.e("PetaStepSerializer", "onSetAllConnectionDisconnected start connectedPrimaryDeviceIterator");
        Iterator<DeviceWrapper> it2 = this._connectedPrimaryDevices.iterator();
        while (it2.hasNext()) {
            DeviceWrapper next2 = it2.next();
            StarryNetDevice device2 = next2.getDevice();
            ILog.e("PetaStepSerializer", "onSetAllConnectionDisconnected _connectedPrimary Devices data = " + device2);
            for (ConnectionStateListener onPrimaryConnectionDisconnected : getListeners()) {
                StarryNetDevice device3 = next2.getDevice();
                Intrinsics.checkNotNullExpressionValue(device3, "getDevice(...)");
                onPrimaryConnectionDisconnected.onPrimaryConnectionDisconnected(device3);
            }
            for (BlePrimaryDeviceConnectionListener onBlePrimaryDeviceDisconnected : getPrimaryDeviceConnectionListeners()) {
                StarryNetDevice device4 = next2.getDevice();
                Intrinsics.checkNotNullExpressionValue(device4, "getDevice(...)");
                onBlePrimaryDeviceDisconnected.onBlePrimaryDeviceDisconnected(device4);
            }
            it2.remove();
        }
        int size3 = this.connectedSecondaryDeviceMap.size();
        ILog.e("PetaStepSerializer", "onSetAllConnectionDisconnected end connectedSecondaryDeviceMap size = " + size3);
        int size4 = this._connectedPrimaryDevices.size();
        ILog.e("PetaStepSerializer", "onSetAllConnectionDisconnected end _connectedPrimaryDevices size = " + size4);
        this.glassBleConnectedDevice = null;
        ILog.e("PetaStepSerializer", "onSetAllConnectionDisconnected set bleConnectedDevice null");
        this.connectedGlassDevice = null;
    }

    public void onUnbound(@NotNull StarryNetDevice starryNetDevice) {
        Intrinsics.checkNotNullParameter(starryNetDevice, "device");
        serialize("unbound", new ConnectionStateManager$onUnbound$1(this, starryNetDevice));
    }

    public final void setBleConnectDevice(@NotNull StarryDevice starryDevice, @NotNull StarryNetDevice starryNetDevice) {
        Intrinsics.checkNotNullParameter(starryDevice, "device");
        Intrinsics.checkNotNullParameter(starryNetDevice, "wrappedDevice");
        this.glassBleConnectedDevice = new DeviceWrapper(starryDevice, starryNetDevice);
    }
}
