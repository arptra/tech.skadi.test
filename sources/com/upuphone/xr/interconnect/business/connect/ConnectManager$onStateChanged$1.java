package com.upuphone.xr.interconnect.business.connect;

import com.upuphone.runasone.device.StarryDevice;
import com.upuphone.star.core.log.ULog;
import com.upuphone.starrynet.api.bean.StDevice;
import com.upuphone.starrynetsdk.ability.relay.RelayAbility;
import com.upuphone.starrynetsdk.device.connection.DevicesConnector;
import com.upuphone.starrynetsdk.device.discovery.DevicesDiscoverer;
import com.upuphone.xr.interconnect.InterconnectManager;
import com.upuphone.xr.interconnect.entity.StarryDeviceExt;
import com.upuphone.xr.interconnect.entity.StarryNetDevice;
import com.upuphone.xr.interconnect.main.StarryNetAbilityManager;
import com.upuphone.xr.interconnect.util.XrSdkBondDeviceUtil;
import com.upuphone.xr.interconnect.util.log.ILog;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension({"SMAP\nConnectManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConnectManager.kt\ncom/upuphone/xr/interconnect/business/connect/ConnectManager$onStateChanged$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,351:1\n1855#2:352\n1856#2:354\n1855#2,2:355\n1#3:353\n*S KotlinDebug\n*F\n+ 1 ConnectManager.kt\ncom/upuphone/xr/interconnect/business/connect/ConnectManager$onStateChanged$1\n*L\n215#1:352\n215#1:354\n239#1:355,2\n*E\n"})
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class ConnectManager$onStateChanged$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ boolean $isEnable;
    final /* synthetic */ ConnectManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ConnectManager$onStateChanged$1(ConnectManager connectManager, boolean z) {
        super(0);
        this.this$0 = connectManager;
        this.$isEnable = z;
    }

    public final void invoke() {
        StarryNetDevice starryNetDevice;
        StarryNetDevice starryNetDevice2;
        StDevice starryDevice;
        String access$getTag = this.this$0.getTag();
        boolean z = this.$isEnable;
        ILog.d(access$getTag, "Starrynet ability state update: " + z + ".");
        if (this.$isEnable) {
            ILog.d(this.this$0.getTag(), "initializing.");
            ConnectManager connectManager = this.this$0;
            DevicesConnector devicesConnector = new DevicesConnector();
            ConnectManager connectManager2 = this.this$0;
            int registerConnectionListener = devicesConnector.registerConnectionListener(connectManager2);
            if (registerConnectionListener == -301000 || registerConnectionListener == -300000) {
                String access$getTag2 = connectManager2.getTag();
                ILog.e(access$getTag2, "Failed registering: connection listener: " + registerConnectionListener + "!");
            }
            String access$getTag3 = connectManager2.getTag();
            boolean z2 = devicesConnector.getBondedDevices() != null && devicesConnector.getBondedDevices().size() > 0;
            ILog.e(access$getTag3, "onStateChanged it.bondedDevices is not empty = " + z2);
            List<StarryDevice> bondedDevices = devicesConnector.getBondedDevices();
            if (bondedDevices != null) {
                Intrinsics.checkNotNull(bondedDevices);
                StarryNetDevice starryNetDevice3 = null;
                starryNetDevice = null;
                for (StarryDevice starryDevice2 : bondedDevices) {
                    String access$getTag4 = connectManager2.getTag();
                    String id = starryDevice2 != null ? starryDevice2.getId() : null;
                    Integer valueOf = (starryDevice2 == null || (starryDevice = starryDevice2.getStarryDevice()) == null) ? null : Integer.valueOf(starryDevice.getBondStatus());
                    Byte valueOf2 = starryDevice2 != null ? Byte.valueOf(starryDevice2.getTerminalType()) : null;
                    ILog.d(access$getTag4, "onStateChanged Got bond device #" + id + ",bondStatus = " + valueOf + ".,device = " + starryDevice2 + ",terminalType = " + valueOf2);
                    if (starryDevice2 != null) {
                        XrSdkBondDeviceUtil xrSdkBondDeviceUtil = XrSdkBondDeviceUtil.INSTANCE;
                        if (xrSdkBondDeviceUtil.deviceTypeIsRingOrGlass(starryDevice2.getTerminalType())) {
                            ULog.f6446a.c("PetaStepSerializer", "onStateChanged getBindDevice deviceTypeIsRingOrGlass do not command   return");
                            if (xrSdkBondDeviceUtil.checkDeviceTypeIsRing(starryDevice2)) {
                                starryNetDevice = StarryDeviceExt.wrapForConnection(starryDevice2);
                            }
                            if (xrSdkBondDeviceUtil.checkDeviceTypeIsGlass(starryDevice2.getTerminalType())) {
                                starryNetDevice3 = StarryDeviceExt.wrapForConnection(starryDevice2);
                                Set<String> bleBoundGlassDeviceIds = connectManager2.baseConnectionManager.getBleBoundGlassDeviceIds();
                                String id2 = starryDevice2.getId();
                                Intrinsics.checkNotNullExpressionValue(id2, "getId(...)");
                                bleBoundGlassDeviceIds.add(id2);
                                Set<String> brBoundGlassDeviceIds = connectManager2.baseConnectionManager.getBrBoundGlassDeviceIds();
                                String id3 = starryDevice2.getId();
                                Intrinsics.checkNotNullExpressionValue(id3, "getId(...)");
                                brBoundGlassDeviceIds.add(id3);
                                if (starryNetDevice3 != null) {
                                    Map<String, StarryNetDevice> boundGlassDeviceMap = connectManager2.getBondStateManager().getBoundGlassDeviceMap();
                                    String id4 = starryDevice2.getId();
                                    Intrinsics.checkNotNullExpressionValue(id4, "getId(...)");
                                    boundGlassDeviceMap.put(id4, starryNetDevice3);
                                }
                            }
                        }
                    }
                }
                starryNetDevice2 = starryNetDevice3;
            } else {
                starryNetDevice2 = null;
                starryNetDevice = null;
            }
            String access$getTag5 = connectManager2.getTag();
            ILog.e(access$getTag5, "onStateChanged boundGlassDevice value is " + starryNetDevice2);
            String access$getTag6 = connectManager2.getTag();
            ILog.e(access$getTag6, "onStateChanged boundRingDevice value is " + starryNetDevice);
            XrSdkBondDeviceUtil xrSdkBondDeviceUtil2 = XrSdkBondDeviceUtil.INSTANCE;
            xrSdkBondDeviceUtil2.saveGlassBoundDevice(starryNetDevice2);
            xrSdkBondDeviceUtil2.saveRingBoundDevice(starryNetDevice);
            List<StarryDevice> connectedDevices = devicesConnector.getConnectedDevices();
            if (connectedDevices != null) {
                Intrinsics.checkNotNull(connectedDevices);
                for (StarryDevice starryDevice3 : connectedDevices) {
                    if (starryDevice3 != null) {
                        ULog.Delegate delegate = ULog.f6446a;
                        String id5 = starryDevice3.getId();
                        byte terminalType = starryDevice3.getTerminalType();
                        delegate.c("PetaStepSerializer", "onStateChanged connectedDevices device info id = " + id5 + ",type = " + terminalType);
                        XrSdkBondDeviceUtil xrSdkBondDeviceUtil3 = XrSdkBondDeviceUtil.INSTANCE;
                        if (xrSdkBondDeviceUtil3.checkDeviceTypeIsGlass(starryDevice3.getTerminalType())) {
                            delegate.c("PetaStepSerializer", "onStateChanged checkDeviceTypeIsGlass is true");
                            int connectionState = devicesConnector.getConnectionState(starryDevice3.getId());
                            if (connectionState == -301000 || connectionState == -300000) {
                                String id6 = starryDevice3.getId();
                                ILog.w("PetaStepSerializer", "onStateChanged Failed querying connection state of #" + id6 + ": " + connectionState + ".");
                            } else {
                                connectManager2.handleGlassConnectStateChange(devicesConnector, starryDevice3, connectionState);
                            }
                        }
                        if (xrSdkBondDeviceUtil3.checkDeviceTypeIsRing(starryDevice3.getTerminalType())) {
                            delegate.c("PetaStepSerializer", "onStateChanged checkDeviceTypeIsRing is true");
                            connectManager2.handleRingConnectStateChange(starryDevice3, devicesConnector.getConnectionState(starryDevice3.getId()));
                        }
                    }
                }
            }
            connectManager.devicesConnector = devicesConnector;
            this.this$0.devicesDiscoverer = new DevicesDiscoverer();
            RelayAbility relayAbility = StarryNetAbilityManager.getInstance().getRelayAbility();
            int registerRelayListener = relayAbility.registerRelayListener(this.this$0.messageRxProcessor, InterconnectManager.getInstance().getPeerPackageName());
            int registerRelayListener2 = relayAbility.registerRelayListener(this.this$0.peerAppRelayListener, new String[0]);
            String access$getTag7 = this.this$0.getTag();
            ILog.i(access$getTag7, "Relay listeners registration results: " + registerRelayListener + ", " + registerRelayListener2 + ".");
            PeerDeviceStatusManager peerDeviceStatusManager = this.this$0.getPeerDeviceStatusManager();
            Intrinsics.checkNotNull(relayAbility);
            peerDeviceStatusManager.onAbilityReady(relayAbility);
            InterconnectManager.getInstance().notifyStarrySdkStateChanged(true);
            return;
        }
        this.this$0.devicesConnector = null;
        this.this$0.devicesDiscoverer = null;
    }
}
