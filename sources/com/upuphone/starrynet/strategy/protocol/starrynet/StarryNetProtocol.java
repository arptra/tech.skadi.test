package com.upuphone.starrynet.strategy.protocol.starrynet;

import Starry.StarryLinkEncrypt;
import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.honey.account.j7.i;
import com.upuphone.starrynet.api.IPublisher;
import com.upuphone.starrynet.api.StBroadcast;
import com.upuphone.starrynet.api.StConstant;
import com.upuphone.starrynet.api.StErrorCode;
import com.upuphone.starrynet.api.StTestConstant;
import com.upuphone.starrynet.api.bean.StDevice;
import com.upuphone.starrynet.common.StLog;
import com.upuphone.starrynet.common.utils.TrackManagerUtils;
import com.upuphone.starrynet.common.utils.Utils;
import com.upuphone.starrynet.common.utils.tracker.TrackerManager;
import com.upuphone.starrynet.core.ble.BluetoothConstants;
import com.upuphone.starrynet.core.ble.client.BleConnectManager;
import com.upuphone.starrynet.core.ble.server.BleServerCache;
import com.upuphone.starrynet.strategy.StarryNetController;
import com.upuphone.starrynet.strategy.StarryNetData;
import com.upuphone.starrynet.strategy.bean.StConnectDevice;
import com.upuphone.starrynet.strategy.bean.StDiscoveryDevice;
import com.upuphone.starrynet.strategy.channel.IConnectChannel;
import com.upuphone.starrynet.strategy.channel.IMessageCallback;
import com.upuphone.starrynet.strategy.channel.IMessageChannel;
import com.upuphone.starrynet.strategy.channel.IStarryNetChannel;
import com.upuphone.starrynet.strategy.channel.StarryNetChannelManager;
import com.upuphone.starrynet.strategy.channel.ap.ApChannel;
import com.upuphone.starrynet.strategy.channel.ble.BleServerChannel;
import com.upuphone.starrynet.strategy.channel.p2p.GcChannel;
import com.upuphone.starrynet.strategy.channel.p2p.GoChannel;
import com.upuphone.starrynet.strategy.channel.simpleble.MyvuRingBleClientChannel;
import com.upuphone.starrynet.strategy.channel.spp.negotiate.SPPNegotiateProtocolManager;
import com.upuphone.starrynet.strategy.config.CarConfigs;
import com.upuphone.starrynet.strategy.connector.IStarryNetConnector;
import com.upuphone.starrynet.strategy.data.StarryDeviceManager;
import com.upuphone.starrynet.strategy.discovery.IStarryNetDiscoverer;
import com.upuphone.starrynet.strategy.discovery.fastpair.FastPairRecord;
import com.upuphone.starrynet.strategy.encrypt.StarryNetDecryptHelper;
import com.upuphone.starrynet.strategy.encrypt.StarryNetEncryptHelper;
import com.upuphone.starrynet.strategy.message.ISendMessageListener;
import com.upuphone.starrynet.strategy.message.MessageManager;
import com.upuphone.starrynet.strategy.message.StarryMessage;
import com.upuphone.starrynet.strategy.netstack.XdpLinkManager;
import com.upuphone.starrynet.strategy.pair.IPairChannel;
import com.upuphone.starrynet.strategy.pair.IPairMsgCallback;
import com.upuphone.starrynet.strategy.pair.StarryNetPairManager;
import com.upuphone.starrynet.strategy.protocol.IProtocolCallback;
import com.upuphone.starrynet.strategy.protocol.ProtocolVersions;
import com.upuphone.starrynet.strategy.protocol.ProtocolVersionsCache;
import com.upuphone.starrynet.strategy.protocol.starrynet.StarryNetProtocolMessage;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressLint({"NewApi"})
public class StarryNetProtocol extends StarryNetProtocolMessage implements IPairChannel {
    public static int PROTOCOL_CONNECT_VERSION_CURRENT = 2;
    public static final int PROTOCOL_ENCRYPT_TYPE_SUPPORT = 5;
    private static final String TAG = "StarryNetProtocol";
    private boolean isP2PGoRole = false;
    private int mDefaultPort;
    private final IPublisher.IHandler mP2pMsgHandler = new IPublisher.IHandler() {
        public void onDeviceStateChanged(String str, int i) {
            StConnectDevice connectDevice = StarryDeviceManager.getInstance().getConnectDevice(str);
            if (connectDevice != null) {
                StLog.d(StarryNetProtocol.TAG, "onDeviceStateChanged, deviceId = " + str + ", status = " + i);
                if (connectDevice.getConnectVersion() >= 3) {
                    if (i == 1) {
                        connectDevice.setP2pPublish(true);
                        if (connectDevice.getTerminalType() == 3 && connectDevice.isProtocolConnected(8)) {
                            StarryNetProtocol.this.disconnect(connectDevice.getDevice());
                        }
                    } else if (i == 2) {
                        connectDevice.setP2pPublish(false);
                    }
                }
            }
        }

        public void onHandle(String str, byte[] bArr) {
            StLog.d(StarryNetProtocol.TAG, "onHandle deviceId:" + str + " data :" + Utils.bytes2HexString(bArr));
            StarryNetDecryptHelper parse = StarryNetDecryptHelper.parse(bArr);
            if (parse == null) {
                StLog.e(StarryNetProtocol.TAG, "The message is null");
                return;
            }
            byte[] identifier = parse.getIdentifier();
            StConnectDevice connectDevice = StarryDeviceManager.getInstance().getConnectDevice(identifier);
            if (connectDevice != null) {
                StarryLinkEncrypt.COMMAND command = parse.getCommand();
                StLog.d(StarryNetProtocol.TAG, "onRecv P2P CMD = " + command);
                int i = AnonymousClass9.$SwitchMap$Starry$StarryLinkEncrypt$COMMAND[command.ordinal()];
                if (i != 6) {
                    switch (i) {
                        case 11:
                            break;
                        case 12:
                            StarryNetProtocol.this.dealP2pDisconnect(connectDevice);
                            return;
                        case 13:
                            StarryNetProtocol.this.dealP2pActiveDisconnect(connectDevice);
                            return;
                        case 14:
                            StarryNetProtocol.this.dealPeerNameChange(connectDevice, parse.getData());
                            return;
                        default:
                            return;
                    }
                }
                if (connectDevice.isProtocolConnected(4)) {
                    StarryNetProtocol.this.mPair.onEvent(Utils.bytes2HexString(identifier), bArr, 10);
                } else if (connectDevice.isProtocolConnected(8)) {
                    StarryNetProtocol.this.mPair.onEvent(Utils.bytes2HexString(identifier), bArr, 11);
                }
            }
        }
    };
    private final boolean mP2pMutualAp;
    public final StarryNetPairManager mPair = new StarryNetPairManager(this);
    private boolean mPublisherRegister;
    protected final Map<String, IStarryNetChannel> mReadyChannelMap = new HashMap();

    /* renamed from: com.upuphone.starrynet.strategy.protocol.starrynet.StarryNetProtocol$9  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass9 {
        static final /* synthetic */ int[] $SwitchMap$Starry$StarryLinkEncrypt$COMMAND;

        /* JADX WARNING: Can't wrap try/catch for region: R(28:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|(3:27|28|30)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(30:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|30) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0084 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0090 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x009c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                Starry.StarryLinkEncrypt$COMMAND[] r0 = Starry.StarryLinkEncrypt.COMMAND.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$Starry$StarryLinkEncrypt$COMMAND = r0
                Starry.StarryLinkEncrypt$COMMAND r1 = Starry.StarryLinkEncrypt.COMMAND.AUTH_STATUE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$Starry$StarryLinkEncrypt$COMMAND     // Catch:{ NoSuchFieldError -> 0x001d }
                Starry.StarryLinkEncrypt$COMMAND r1 = Starry.StarryLinkEncrypt.COMMAND.WRITE_SWITCH_KEY     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$Starry$StarryLinkEncrypt$COMMAND     // Catch:{ NoSuchFieldError -> 0x0028 }
                Starry.StarryLinkEncrypt$COMMAND r1 = Starry.StarryLinkEncrypt.COMMAND.WRITE_SWITCH_INFO     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$Starry$StarryLinkEncrypt$COMMAND     // Catch:{ NoSuchFieldError -> 0x0033 }
                Starry.StarryLinkEncrypt$COMMAND r1 = Starry.StarryLinkEncrypt.COMMAND.READ_SWITCH_INFO     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$Starry$StarryLinkEncrypt$COMMAND     // Catch:{ NoSuchFieldError -> 0x003e }
                Starry.StarryLinkEncrypt$COMMAND r1 = Starry.StarryLinkEncrypt.COMMAND.READ_SWITCH_KEY     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$Starry$StarryLinkEncrypt$COMMAND     // Catch:{ NoSuchFieldError -> 0x0049 }
                Starry.StarryLinkEncrypt$COMMAND r1 = Starry.StarryLinkEncrypt.COMMAND.BOND_MSG_CHANGE     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$Starry$StarryLinkEncrypt$COMMAND     // Catch:{ NoSuchFieldError -> 0x0054 }
                Starry.StarryLinkEncrypt$COMMAND r1 = Starry.StarryLinkEncrypt.COMMAND.SPP_SERVER_UUID_SYNC     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = $SwitchMap$Starry$StarryLinkEncrypt$COMMAND     // Catch:{ NoSuchFieldError -> 0x0060 }
                Starry.StarryLinkEncrypt$COMMAND r1 = Starry.StarryLinkEncrypt.COMMAND.SPP_SERVER_REQUEST_CONNECT     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = $SwitchMap$Starry$StarryLinkEncrypt$COMMAND     // Catch:{ NoSuchFieldError -> 0x006c }
                Starry.StarryLinkEncrypt$COMMAND r1 = Starry.StarryLinkEncrypt.COMMAND.SPP_SERVER_REQUEST_STATE_OPEN     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = $SwitchMap$Starry$StarryLinkEncrypt$COMMAND     // Catch:{ NoSuchFieldError -> 0x0078 }
                Starry.StarryLinkEncrypt$COMMAND r1 = Starry.StarryLinkEncrypt.COMMAND.SPP_SERVER_REQUEST_STATE_CLOSE     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = $SwitchMap$Starry$StarryLinkEncrypt$COMMAND     // Catch:{ NoSuchFieldError -> 0x0084 }
                Starry.StarryLinkEncrypt$COMMAND r1 = Starry.StarryLinkEncrypt.COMMAND.UN_BONDED     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = $SwitchMap$Starry$StarryLinkEncrypt$COMMAND     // Catch:{ NoSuchFieldError -> 0x0090 }
                Starry.StarryLinkEncrypt$COMMAND r1 = Starry.StarryLinkEncrypt.COMMAND.DISCONNECT_P2P     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r0 = $SwitchMap$Starry$StarryLinkEncrypt$COMMAND     // Catch:{ NoSuchFieldError -> 0x009c }
                Starry.StarryLinkEncrypt$COMMAND r1 = Starry.StarryLinkEncrypt.COMMAND.DISCONNECT_P2P_ACTIVE     // Catch:{ NoSuchFieldError -> 0x009c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                int[] r0 = $SwitchMap$Starry$StarryLinkEncrypt$COMMAND     // Catch:{ NoSuchFieldError -> 0x00a8 }
                Starry.StarryLinkEncrypt$COMMAND r1 = Starry.StarryLinkEncrypt.COMMAND.PEERS_NAME_CHANGE     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.upuphone.starrynet.strategy.protocol.starrynet.StarryNetProtocol.AnonymousClass9.<clinit>():void");
        }
    }

    public StarryNetProtocol() {
        StarryNetChannelManager.getInstance().addProtocol(this);
        PROTOCOL_CONNECT_VERSION_CURRENT = getProtocolConnectVersion();
        this.mP2pMutualAp = deviceP2pMutualAp();
    }

    private void dealJsonData(byte[] bArr, StConnectDevice stConnectDevice, IStarryNetChannel iStarryNetChannel) {
        boolean z;
        ProtocolVersions parseJson = ProtocolVersions.parseJson(new String(bArr));
        if (parseJson == null) {
            StLog.i(TAG, "remoteVersions null");
            return;
        }
        byte[] hexString2Bytes = Utils.hexString2Bytes(parseJson.getSelfIdentifier());
        if (hexString2Bytes == null) {
            StLog.i(TAG, "data error, identifier is null");
            return;
        }
        if (parseJson.getCategoryID() != null) {
            stConnectDevice.setCategoryID(parseJson.getCategoryID());
        }
        StConnectDevice stConnectDevice2 = getStConnectDevice(stConnectDevice, hexString2Bytes);
        if (parseJson.getEncryptType() < 0 || parseJson.getConnectVersion() < 0 || parseJson.getMaxMtuSize() <= 0) {
            stConnectDevice2.setConnectVersion(2);
            stConnectDevice2.setEncrypt(4);
            StarryDeviceManager.getInstance().updateBondInfo(stConnectDevice2);
            z = true;
        } else {
            z = onDealVersionData(parseJson, stConnectDevice2, iStarryNetChannel);
        }
        if (z) {
            onReady(stConnectDevice2, iStarryNetChannel);
        }
    }

    /* access modifiers changed from: private */
    public void dealP2pActiveDisconnect(StConnectDevice stConnectDevice) {
        if (stConnectDevice.isProtocolConnected(4)) {
            IStarryNetDiscoverer discoveryManager = StarryNetData.getInstance().getDiscoveryManager();
            discoveryManager.setCarActiveDisconnect(stConnectDevice.getIdentifier2String());
            if (stConnectDevice.getTerminalType() == 9) {
                discoveryManager.disableFastConnect();
                discoveryManager.enableFastConnect();
            }
            sendP2pMsg(stConnectDevice, StarryNetEncryptHelper.generateDisconnectP2p());
        } else if (stConnectDevice.isProtocolConnected(8)) {
            FastPairRecord.getInstance().setActiveDisconnectPad(stConnectDevice.getIdentifier2String());
            disconnect(stConnectDevice.getDevice(), 11);
        }
    }

    /* access modifiers changed from: private */
    public void dealP2pDisconnect(StConnectDevice stConnectDevice) {
        if (stConnectDevice.isProtocolConnected(8)) {
            disconnect(stConnectDevice.getDevice(), 11);
        }
    }

    private int getConnectProfile(int i) {
        if (i == 1) {
            return 2;
        }
        if (i == 2) {
            return 1;
        }
        if (i == 10) {
            return 4;
        }
        if (i == 11) {
            return 8;
        }
        if (i == 12) {
            return 16;
        }
        if (i == 13) {
            return 32;
        }
        if (i == 21 || i == 20) {
            return 64;
        }
        if (i == 23) {
            return 2048;
        }
        if (i == 24) {
            return 1024;
        }
        return i;
    }

    private StConnectDevice getStConnectDevice(StConnectDevice stConnectDevice, byte[] bArr) {
        StConnectDevice connectDevice = StarryDeviceManager.getInstance().getConnectDevice(bArr);
        if (connectDevice == null) {
            connectDevice = new StConnectDevice();
            connectDevice.setIdentifier(bArr);
            connectDevice.setDeviceType((byte) 1);
            connectDevice.setCategoryID(stConnectDevice.getCategoryID());
            StDiscoveryDevice discoveryDevice = StarryDeviceManager.getInstance().getDiscoveryDevice(bArr);
            if (discoveryDevice != null) {
                connectDevice.setCategoryID(discoveryDevice.getCategoryID());
                connectDevice.setCompanyID(discoveryDevice.getCompanyID());
                connectDevice.setModelID(discoveryDevice.getModelID());
            }
            StLog.d(TAG, "insertBondInfo device terminal type is:" + connectDevice.getTerminalType());
            StarryDeviceManager.getInstance().insertBondInfo(connectDevice);
        }
        connectDevice.setBleMac(stConnectDevice.getBleMac());
        connectDevice.setDeviceName(stConnectDevice.getDeviceName());
        return connectDevice;
    }

    private boolean notifyApMutual() {
        return StarryNetData.getInstance().isMatchModel(CarConfigs.MODEL_NAME_CAR_417);
    }

    private void processRemoteStarryNetStackAction(StConnectDevice stConnectDevice, byte[] bArr) {
        IStarryNetChannel readyChannel = getReadyChannel(stConnectDevice.getIdentifier2String());
        StDevice device = stConnectDevice.getDevice();
        if (readyChannel != null) {
            StLog.i(TAG, "processRemoteStarryNetAction :" + Utils.byteArrayToInt(bArr));
            readyChannel.sendMsg(device, StarryNetEncryptHelper.generateRemoteStarryNetStack(bArr), 10);
        }
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean starryNetStackActionLoad(android.os.Bundle r5, com.upuphone.starrynet.strategy.bean.StConnectDevice r6) {
        /*
            r4 = this;
            java.lang.String r4 = "starryNetActionLoad finally:"
            java.lang.String r0 = "iface_name"
            java.lang.String r0 = r5.getString(r0)
            java.lang.String r1 = "mtu"
            int r5 = r5.getInt(r1)
            com.upuphone.starrynet.api.bean.StDevice r6 = r6.getDevice()
            com.upuphone.starrynet.strategy.netstack.XdpLinkManager r1 = com.upuphone.starrynet.strategy.netstack.XdpLinkManager.getInstance()
            byte r1 = r1.getCapByteFromIfname(r0)
            boolean r6 = r6.isSupportStarryNetStack(r1)
            java.lang.String r1 = "StarryNetProtocol"
            r2 = 0
            if (r6 != 0) goto L_0x003d
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "remote device "
            r4.append(r5)
            r4.append(r0)
            java.lang.String r5 = " not support StarryNetStack"
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            com.upuphone.starrynet.common.StLog.i(r1, r4)
            return r2
        L_0x003d:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x008d }
            r6.<init>()     // Catch:{ Exception -> 0x008d }
            java.lang.String r3 = "starryNetActionLoad ipAddr:"
            r6.append(r3)     // Catch:{ Exception -> 0x008d }
            java.lang.String r3 = com.upuphone.starrynet.strategy.netstack.XdpLinkManager.getLocalP2PAddress()     // Catch:{ Exception -> 0x008d }
            r6.append(r3)     // Catch:{ Exception -> 0x008d }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x008d }
            com.upuphone.starrynet.common.StLog.i(r1, r6)     // Catch:{ Exception -> 0x008d }
            com.upuphone.starrynet.strategy.netstack.XdpLinkManager r6 = com.upuphone.starrynet.strategy.netstack.XdpLinkManager.getInstance()     // Catch:{ Exception -> 0x008d }
            java.lang.String r3 = com.upuphone.starrynet.strategy.netstack.XdpLinkManager.getLocalP2PAddress()     // Catch:{ Exception -> 0x008d }
            int r5 = r6.loadXdp(r0, r3, r5)     // Catch:{ Exception -> 0x008d }
            r6 = 1
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x008d, all -> 0x008a }
            r0.<init>()     // Catch:{ Exception -> 0x008d, all -> 0x008a }
            java.lang.String r3 = "starryNetActionLoad return:"
            r0.append(r3)     // Catch:{ Exception -> 0x008d, all -> 0x008a }
            r0.append(r5)     // Catch:{ Exception -> 0x008d, all -> 0x008a }
            java.lang.String r5 = r0.toString()     // Catch:{ Exception -> 0x008d, all -> 0x008a }
            com.upuphone.starrynet.common.StLog.i(r1, r5)     // Catch:{ Exception -> 0x008d, all -> 0x008a }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r4)
            r5.append(r6)
            java.lang.String r4 = r5.toString()
            com.upuphone.starrynet.common.StLog.i(r1, r4)
            r2 = r6
            goto L_0x00a6
        L_0x008a:
            r5 = move-exception
            r2 = r6
            goto L_0x00a7
        L_0x008d:
            r5 = move-exception
            goto L_0x0091
        L_0x008f:
            r5 = move-exception
            goto L_0x00a7
        L_0x0091:
            r5.printStackTrace()     // Catch:{ all -> 0x008f }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r4)
            r5.append(r2)
            java.lang.String r4 = r5.toString()
            com.upuphone.starrynet.common.StLog.i(r1, r4)
        L_0x00a6:
            return r2
        L_0x00a7:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r4)
            r6.append(r2)
            java.lang.String r4 = r6.toString()
            com.upuphone.starrynet.common.StLog.i(r1, r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.starrynet.strategy.protocol.starrynet.StarryNetProtocol.starryNetStackActionLoad(android.os.Bundle, com.upuphone.starrynet.strategy.bean.StConnectDevice):boolean");
    }

    private boolean starryNetStackActionUnload(Bundle bundle, StConnectDevice stConnectDevice) {
        try {
            XdpLinkManager.getInstance().unload(bundle.getString(StConstant.STARRY_NET_STACK_IFACE_NAME));
            return true;
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    private void trackOfflineRemoveBondResult(StDevice stDevice) {
        TrackerManager.getInstance().getUnpairDeviceTracker().peerModelID(stDevice.getModelID()).result(stDevice.getTerminalType(), stDevice.getIdentifier2String(), StarryNetData.getInstance().getOwnDevice().getTerminalType() == 2 ? 0 : 1).startReport();
    }

    public int cancelAuth(final StDevice stDevice) {
        StLog.d(TAG, "cancelAuth device = " + stDevice);
        if (stDevice == null) {
            return StErrorCode.CONNECT_STRATEGY_BLE_PARAM_ERROR;
        }
        StConnectDevice connectDevice = StarryDeviceManager.getInstance().getConnectDevice(stDevice.getIdentifier());
        if (connectDevice == null || connectDevice.getBleBondStatus() != 1) {
            byte terminalType = StarryNetData.getInstance().getOwnDevice().getTerminalType();
            if (terminalType != 1 && terminalType != 9) {
                return StErrorCode.CONNECT_STRATEGY_BLE_BOND_STATUS_ERROR;
            }
            StLog.d(TAG, "cancel auth, then disconnect");
            BleConnectManager.getInstance().disconnect(stDevice.getBleMac());
            return StErrorCode.CONNECT_STRATEGY_BLE_BOND_STATUS_ERROR;
        }
        final IStarryNetChannel readyChannel = getReadyChannel(stDevice.getIdentifier2String());
        if (readyChannel == null) {
            return StErrorCode.CONNECT_STRATEGY_BLE_PARAM_ERROR;
        }
        readyChannel.sendMsg(stDevice, StarryNetEncryptHelper.generateCancelAuth(), 10, new IMessageCallback() {
            public void onResult(int i) {
                readyChannel.disconnect(stDevice);
            }
        });
        return 0;
    }

    public int connect(final StDevice stDevice, int i) {
        final IConnectChannel connectChannel = StarryNetChannelManager.getInstance().getConnectChannel(i);
        if (connectChannel == null) {
            StLog.w(TAG, "connect, but cannot find IConnectChannel, profile=" + i);
            return StErrorCode.CONNECT_STRATEGY_BLE_PARAM_ERROR;
        }
        boolean z = true;
        if (i == 10) {
            ((GoChannel) connectChannel).setDefaultPort(this.mDefaultPort);
            StLog.d(TAG, StTestConstant.POINT_P2P_CONNECT_STEP_1);
            TrackManagerUtils.trackP2pConnectSuccessRateStart();
            TrackManagerUtils.trackP2pConnectTime(true);
        } else if (i == 12) {
            ((ApChannel) connectChannel).setDefaultPort(this.mDefaultPort);
        } else if (i == 1 && getReadyChannel(stDevice.getIdentifier2String()) != null) {
            StLog.e(TAG, "ble channel ready, return");
            return 0;
        }
        if (i == 10 || i == 11) {
            if (i != 10) {
                z = false;
            }
            this.isP2PGoRole = z;
            boolean isWifiApOpen = isWifiApOpen();
            StLog.d(TAG, "wifiApOpen = " + isWifiApOpen + ", mP2pMutualAp = " + this.mP2pMutualAp);
            if (isWifiApOpen && this.mP2pMutualAp) {
                if (notifyApMutual()) {
                    StarryDeviceManager.getInstance().connectFail(stDevice, StErrorCode.CONNECT_STRATEGY_P2P_MUTUAL_AP_FAIL, 2);
                    return 0;
                }
                disableWifiAp();
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        connectChannel.connect(stDevice);
                    }
                }, 500);
                return 0;
            }
        }
        return connectChannel.connect(stDevice);
    }

    public void connectP2p(final StConnectDevice stConnectDevice) {
        if (stConnectDevice != null) {
            this.isP2PGoRole = false;
            final GcChannel gcChannel = (GcChannel) StarryNetChannelManager.getInstance().getConnectChannel(11);
            if (gcChannel == null) {
                StLog.e(TAG, "connectP2p channel is null");
                return;
            }
            boolean isWifiApOpen = isWifiApOpen();
            StLog.d(TAG, "ApOpen = " + isWifiApOpen + ", mP2pMutualAp = " + this.mP2pMutualAp);
            if (!isWifiApOpen || !this.mP2pMutualAp) {
                gcChannel.connect(stConnectDevice.getSsid(), stConnectDevice.getPwd(), stConnectDevice.getFreq(), stConnectDevice.getPort(), stConnectDevice.getIdentifier(), stConnectDevice.getAddress());
            } else if (notifyApMutual()) {
                StarryDeviceManager.getInstance().connectFail(stConnectDevice.getDevice(), StErrorCode.CONNECT_STRATEGY_P2P_MUTUAL_AP_FAIL, 2);
            } else {
                disableWifiAp();
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        StarryNetProtocol.this.sysP2pMacAddress(stConnectDevice, "");
                        gcChannel.connect(stConnectDevice.getSsid(), stConnectDevice.getPwd(), stConnectDevice.getFreq(), stConnectDevice.getPort(), stConnectDevice.getIdentifier(), stConnectDevice.getAddress());
                    }
                }, 1000);
            }
        }
    }

    public int createBond(StDevice stDevice) {
        IStarryNetChannel readyChannel;
        if (stDevice == null || (readyChannel = getReadyChannel(stDevice.getIdentifier2String())) == null) {
            return StErrorCode.CONNECT_STRATEGY_BLE_PARAM_ERROR;
        }
        if (needDeviceSwitch(stDevice)) {
            Handler handler = this.mHandler;
            handler.sendMessageDelayed(Message.obtain(handler, 4, stDevice), 200);
            return 0;
        }
        this.mPair.createBond(stDevice, readyChannel.getProfile());
        return 0;
    }

    public /* bridge */ /* synthetic */ void dealGcIpMsg(StConnectDevice stConnectDevice, byte[] bArr) {
        super.dealGcIpMsg(stConnectDevice, bArr);
    }

    public boolean deviceP2pMutualAp() {
        return (StarryNetData.getInstance().getOwnDevice().getTerminalType() == 9) || (StarryNetData.getInstance().isMatchModel(CarConfigs.MODEL_NAME_CAR_DS11) || StarryNetData.getInstance().isMatchModel(CarConfigs.MODEL_NAME_CAR_DX11) || StarryNetData.getInstance().isMatchModel(CarConfigs.MODEL_NAME_CAR_CS11_PLUS) || StarryNetData.getInstance().isMatchModel(CarConfigs.MODEL_NAME_CAR_417) || StarryNetData.getInstance().isMatchModel(CarConfigs.MODEL_NAME_CAR_XE08)) || StarryNetData.getInstance().isMatchModel(StarryNetData.MODEL_NAME_MEIZU_2431);
    }

    public void disableWifiAp() {
        ApChannel apChannel = (ApChannel) StarryNetChannelManager.getInstance().getConnectChannel(12);
        if (apChannel != null) {
            apChannel.closeAp();
        }
    }

    public int disconnect(StDevice stDevice, int i) {
        IConnectChannel connectChannel = StarryNetChannelManager.getInstance().getConnectChannel(i);
        if (connectChannel == null) {
            return StErrorCode.CONNECT_STRATEGY_BLE_PARAM_ERROR;
        }
        return connectChannel.disconnect(stDevice);
    }

    public void disconnectP2p(StDevice stDevice) {
        if (stDevice != null) {
            StarryNetController.getConnectManager().disconnectP2p(stDevice);
        }
    }

    public IMessageChannel getMessageChannel(StDevice stDevice) {
        return getReadyChannel(stDevice.getIdentifier2String());
    }

    public /* bridge */ /* synthetic */ String getP2pMacAddress() {
        return super.getP2pMacAddress();
    }

    public int getProfile() {
        return 1;
    }

    public int getProtocolConnectVersion() {
        return 2;
    }

    public IStarryNetChannel getReadyChannel(String str) {
        return this.mReadyChannelMap.get(str);
    }

    public void init() {
        BleServerChannel bleServerChannel = (BleServerChannel) StarryNetChannelManager.getInstance().getStarryNetChannel(2);
        if (bleServerChannel != null) {
            bleServerChannel.init();
        }
    }

    public boolean isP2PGoRole() {
        return this.isP2PGoRole;
    }

    public boolean isWifiApOpen() {
        ApChannel apChannel = (ApChannel) StarryNetChannelManager.getInstance().getConnectChannel(12);
        if (apChannel == null) {
            return false;
        }
        return apChannel.isApCreated();
    }

    public boolean needDeviceSwitch(StDevice stDevice) {
        byte terminalType = StarryNetData.getInstance().getOwnDevice().getTerminalType();
        IStarryNetConnector connectManager = StarryNetController.getConnectManager();
        if (terminalType == 3) {
            int deviceConnectable = connectManager.getDeviceConnectable(stDevice);
            if (deviceConnectable == 102000) {
                return false;
            }
            for (StConnectDevice next : deviceConnectable == 102007 ? StarryDeviceManager.getInstance().getBondInfoByTerminal(1) : StarryDeviceManager.getInstance().getBondedInfo()) {
                StLog.e(TAG, "needDeviceSwitch device = " + next);
                if (next.isBleConnected()) {
                    if (next.isProtocolConnected(4)) {
                        disconnect(next.getDevice(), 10);
                    } else if (next.isProtocolConnected(8)) {
                        disconnect(next.getDevice(), 11);
                    }
                }
                removeBond(next.getDevice());
            }
            return true;
        }
        byte terminalType2 = stDevice.getTerminalType();
        if (terminalType2 != 3) {
            return false;
        }
        List<StConnectDevice> connectedDeviceByTerminal = StarryDeviceManager.getInstance().getConnectedDeviceByTerminal(terminalType2);
        if (connectedDeviceByTerminal.size() == 0) {
            return false;
        }
        StLog.d(TAG, "needDeviceSwitch, list = " + connectedDeviceByTerminal);
        for (StConnectDevice next2 : connectedDeviceByTerminal) {
            if (next2.getDevice().equals(stDevice)) {
                return false;
            }
            if (terminalType == 9) {
                removeBond(next2.getDevice());
            } else {
                if (next2.isProtocolConnected(4)) {
                    disconnect(next2.getDevice(), 10);
                } else if (next2.isProtocolConnected(8)) {
                    disconnect(next2.getDevice(), 11);
                }
                if (next2.isBleConnected()) {
                    disconnect(next2.getDevice(), 1);
                }
            }
        }
        return true;
    }

    public void onBrEdrBondStateChange(StConnectDevice stConnectDevice, int i, int i2) {
        if (i2 == 32 && i == 16) {
            StLog.d(TAG, "onBrEdrBondStateChange, br/edr connect fail, " + stConnectDevice.getDeviceName());
            StarryDeviceManager.getInstance().connectFail(stConnectDevice.getDevice(), StErrorCode.CONNECT_STRATEGY_BR_EDR_CONNECT_FAIL, 8);
        }
    }

    public boolean onConnected(StConnectDevice stConnectDevice, IConnectChannel iConnectChannel) {
        if (stConnectDevice == null) {
            StLog.i(TAG, "onConnected connectDevice is null");
            return false;
        }
        int profile = iConnectChannel.getProfile();
        StLog.i(TAG, "channel onConnected " + stConnectDevice + " profile = " + profile);
        if (!(profile == 1 || profile == 2)) {
            if (profile != 20 && profile != 21 && profile != 11 && profile != 23 && profile != 24) {
                return false;
            }
            onConnected(stConnectDevice, getConnectProfile(profile));
        }
        return true;
    }

    public boolean onDealVersionData(ProtocolVersions protocolVersions, final StConnectDevice stConnectDevice, final IStarryNetChannel iStarryNetChannel) {
        ProtocolVersions buildResponseVersions = ProtocolVersions.buildResponseVersions(protocolVersions);
        ProtocolVersionsCache.updateProtocolVersion(protocolVersions.getSelfIdentifier(), buildResponseVersions);
        byte[] buildBytesFromVersions = ProtocolVersions.buildBytesFromVersions(buildResponseVersions);
        StLog.d(TAG, "onDealProtocolVersion, response ProtocolVersion data =" + buildBytesFromVersions.length);
        int min = Math.min(protocolVersions.getMaxMtuSize(), 512);
        StLog.d(TAG, "put dest mtu=%d into BleServerCache", Integer.valueOf(min));
        BleServerCache.getInstance().putExpectedMtu(stConnectDevice.getBleMac(), min);
        iStarryNetChannel.sendMsg(stConnectDevice.getDevice(), buildBytesFromVersions, 11, new IMessageCallback() {
            public void onResult(int i) {
                if (i != 0) {
                    iStarryNetChannel.disconnect(stConnectDevice.getDevice());
                }
            }
        });
        if (buildResponseVersions.getConnectVersion() <= 0 || buildResponseVersions.getEncryptType() <= 0) {
            StLog.w(TAG, "onReady connectDevice version is not support");
            return false;
        }
        stConnectDevice.setConnectVersion(buildResponseVersions.getConnectVersion());
        stConnectDevice.setEncrypt(buildResponseVersions.getEncryptType());
        StarryDeviceManager.getInstance().updateBondInfo(stConnectDevice);
        return true;
    }

    public boolean onDisconnected(StConnectDevice stConnectDevice, IConnectChannel iConnectChannel) {
        if (stConnectDevice == null) {
            StLog.i(TAG, "onDisconnected connectDevice is null");
            return false;
        }
        int profile = iConnectChannel.getProfile();
        StLog.d(TAG, "channel onDisconnected " + stConnectDevice + " profile = " + profile);
        if (profile == 1 || profile == 2) {
            this.mHandler.removeMessages(2);
            this.mReadyChannelMap.remove(stConnectDevice.getIdentifier2String());
            onDisconnected(stConnectDevice, getConnectProfile(profile));
            return true;
        } else if (profile != 20 && profile != 21 && profile != 11 && profile != 23 && profile != 24 && profile != 10) {
            return false;
        } else {
            onDisconnected(stConnectDevice, getConnectProfile(profile));
            return true;
        }
    }

    public void onReady(StConnectDevice stConnectDevice, IStarryNetChannel iStarryNetChannel) {
        if (stConnectDevice == null) {
            StLog.i(TAG, "onReady connectDevice is null");
            return;
        }
        StLog.d(TAG, "onReady " + stConnectDevice);
        this.mReadyChannelMap.put(stConnectDevice.getIdentifier2String(), iStarryNetChannel);
        starryNetStackSyncCaps(stConnectDevice, iStarryNetChannel.getProfile());
    }

    public void onRecv(StConnectDevice stConnectDevice, byte[] bArr, int i, IStarryNetChannel iStarryNetChannel) {
        StarryNetDecryptHelper parse;
        if (stConnectDevice != null) {
            if (i == 11) {
                dealJsonData(bArr, stConnectDevice, iStarryNetChannel);
            } else if (i == 10 && (parse = StarryNetDecryptHelper.parse(bArr)) != null) {
                StarryNetProtocolMessage.MsgObj msgObj = new StarryNetProtocolMessage.MsgObj(stConnectDevice, iStarryNetChannel, parse);
                StarryLinkEncrypt.COMMAND command = parse.getCommand();
                StLog.d(TAG, "onRecv CMD = " + command);
                switch (AnonymousClass9.$SwitchMap$Starry$StarryLinkEncrypt$COMMAND[command.ordinal()]) {
                    case 1:
                        Message.obtain(this.mHandler, 3, msgObj).sendToTarget();
                        return;
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                        if (this.mPair != null && iStarryNetChannel != null) {
                            this.mPair.onEvent(stConnectDevice.getBleMac(), bArr, iStarryNetChannel.getProfile());
                            return;
                        }
                        return;
                    case 7:
                        SPPNegotiateProtocolManager.getInstance().handleServerUUIDSync(stConnectDevice.getDevice(), bArr);
                        return;
                    case 8:
                        SPPNegotiateProtocolManager.getInstance().handleServerRequestConnect(stConnectDevice, stConnectDevice.getDevice(), bArr);
                        return;
                    case 9:
                        SPPNegotiateProtocolManager.getInstance().handleServerRequestStateChange(stConnectDevice, true);
                        return;
                    case 10:
                        SPPNegotiateProtocolManager.getInstance().handleServerRequestStateChange(stConnectDevice, false);
                        return;
                    default:
                        Message.obtain(this.mHandler, 1, msgObj).sendToTarget();
                        return;
                }
            }
        }
    }

    public void readMsg(StDevice stDevice, int i, byte[] bArr, IPairMsgCallback iPairMsgCallback) {
        if (i == 0) {
            BleConnectManager.getInstance().read(stDevice.getBleMac(), BluetoothConstants.STARRY_NET_SERVICE_UUID, BluetoothConstants.STARRY_NET_READ_UUID, new i(iPairMsgCallback, stDevice));
        }
    }

    public void regRemoveDeviceBroadcast(Context context) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(StBroadcast.LOCAL_ACTION_REMOVE_DEVICE);
        LocalBroadcastManager.b(context).c(new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
                StConnectDevice connectDevice = StarryDeviceManager.getInstance().getConnectDevice(intent.getByteArrayExtra(StBroadcast.EXTRA_DEVICE_ID));
                if (connectDevice == null) {
                    StLog.d(StarryNetProtocol.TAG, "LocalBroadcastManager bond info is null");
                    return;
                }
                StLog.d(StarryNetProtocol.TAG, "LocalBroadcastManager remove device, " + connectDevice.getDeviceName());
                TrackerManager.getInstance().getUnpairDeviceTracker().startUnpair(connectDevice.getTerminalType(), connectDevice.getIdentifier2String()).way(1);
                StarryNetProtocol.this.removeBond(connectDevice.getDevice());
            }
        }, intentFilter);
    }

    public IPublisher.IHandler registerPublisher(IPublisher iPublisher) {
        GoChannel goChannel = (GoChannel) StarryNetChannelManager.getInstance().getConnectChannel(10);
        GcChannel gcChannel = (GcChannel) StarryNetChannelManager.getInstance().getConnectChannel(11);
        if (goChannel == null && gcChannel == null) {
            StLog.w(TAG, "registerPublisher, but cannot find p2p IConnectChannel");
            return null;
        }
        if (goChannel != null) {
            goChannel.registerPublisher(iPublisher);
        }
        if (gcChannel != null) {
            gcChannel.registerPublisher(iPublisher);
        }
        this.mPublisherRegister = true;
        return this.mP2pMsgHandler;
    }

    public int removeBond(StDevice stDevice) {
        StLog.d(TAG, "removeBond " + stDevice.getDeviceName());
        StConnectDevice connectDevice = StarryDeviceManager.getInstance().getConnectDevice(stDevice.getIdentifier());
        if (connectDevice == null) {
            return StErrorCode.DISCOVERY_STRATEGY_INVALID_PARAM;
        }
        IStarryNetChannel readyChannel = getReadyChannel(stDevice.getIdentifier2String());
        if (readyChannel != null) {
            StLog.d(TAG, "removeBond getProfile " + readyChannel.getProfile());
            this.mPair.removeBond(connectDevice, readyChannel.getProfile());
        } else if (stDevice.getTerminalType() == 5) {
            ((MyvuRingBleClientChannel) StarryNetChannelManager.getInstance().getConnectChannel(25)).removeBond(stDevice);
        } else if (!this.mPublisherRegister || !connectDevice.isP2pPublish()) {
            trackOfflineRemoveBondResult(stDevice);
            StarryDeviceManager.getInstance().updateBondInfo(connectDevice, 0);
        } else {
            StLog.d(TAG, "removeBond by p2p");
            if (connectDevice.isProtocolConnected(4)) {
                this.mPair.removeBond(connectDevice, 10);
            } else if (connectDevice.isProtocolConnected(8)) {
                this.mPair.removeBond(connectDevice, 11);
            }
        }
        return 0;
    }

    public int requestAuth(StDevice stDevice, byte[] bArr) {
        StLog.d(TAG, "requestAuth device = " + stDevice);
        if (stDevice == null) {
            return StErrorCode.CONNECT_STRATEGY_BLE_PARAM_ERROR;
        }
        StConnectDevice connectDevice = StarryDeviceManager.getInstance().getConnectDevice(stDevice.getIdentifier());
        if (connectDevice == null || connectDevice.getBleBondStatus() != 1) {
            return StErrorCode.CONNECT_STRATEGY_BLE_BOND_STATUS_ERROR;
        }
        IStarryNetChannel readyChannel = getReadyChannel(stDevice.getIdentifier2String());
        return readyChannel == null ? StErrorCode.CONNECT_STRATEGY_BLE_PARAM_ERROR : readyChannel.sendMsg(stDevice, StarryNetEncryptHelper.generateAuthMessage(bArr), 10);
    }

    public int sendMsg(StDevice stDevice, byte[] bArr) {
        IStarryNetChannel readyChannel;
        StLog.d(TAG, "sendMsg device = " + stDevice);
        if (stDevice == null || (readyChannel = getReadyChannel(stDevice.getIdentifier2String())) == null) {
            return StErrorCode.CONNECT_STRATEGY_BLE_PARAM_ERROR;
        }
        return readyChannel.sendMsg(stDevice, bArr);
    }

    public boolean sendP2pMsg(StConnectDevice stConnectDevice, byte[] bArr) {
        if (!this.mPublisherRegister) {
            return false;
        }
        if (stConnectDevice.isProtocolConnected(4)) {
            GoChannel goChannel = (GoChannel) StarryNetChannelManager.getInstance().getConnectChannel(10);
            if (goChannel != null) {
                return goChannel.sendP2pMsg(stConnectDevice.getDevice(), bArr);
            }
            StLog.w(TAG, "cannot find GO ConnectChannel");
            return false;
        } else if (!stConnectDevice.isProtocolConnected(8)) {
            return false;
        } else {
            GcChannel gcChannel = (GcChannel) StarryNetChannelManager.getInstance().getConnectChannel(11);
            if (gcChannel != null) {
                return gcChannel.sendP2pMsg(stConnectDevice.getDevice(), bArr);
            }
            StLog.w(TAG, "cannot find GC ConnectChannel");
            return false;
        }
    }

    public int sendStarryNetMsg(StDevice stDevice, byte[] bArr) {
        StLog.d(TAG, "sendMsg device = " + stDevice);
        if (stDevice == null) {
            return StErrorCode.CONNECT_STRATEGY_BLE_PARAM_ERROR;
        }
        IStarryNetChannel readyChannel = getReadyChannel(stDevice.getIdentifier2String());
        if (readyChannel != null) {
            return readyChannel.sendMsg(stDevice, bArr, 10);
        }
        StConnectDevice connectDevice = StarryDeviceManager.getInstance().getConnectDevice(stDevice.getIdentifier());
        if (connectDevice != null) {
            sendP2pMsg(connectDevice, bArr);
        }
        return StErrorCode.CONNECT_STRATEGY_BLE_PARAM_ERROR;
    }

    public void setDefaultPort(int i) {
        this.mDefaultPort = i;
    }

    public void setProtocolCallback(IProtocolCallback iProtocolCallback) {
        this.mCallback = iProtocolCallback;
    }

    public boolean starryNetStackActionCmd(int i, Bundle bundle, StConnectDevice stConnectDevice) {
        if (!XdpLinkManager.getInstance().isSupportStarryNetStack()) {
            StLog.i(TAG, "self device not support StarryNetStack");
            return false;
        } else if (i == 0) {
            return starryNetStackActionLoad(bundle, stConnectDevice);
        } else {
            if (i != 1) {
                return false;
            }
            return starryNetStackActionUnload(bundle, stConnectDevice);
        }
    }

    public void starryNetStackSyncCaps(StConnectDevice stConnectDevice, int i) {
        if (!XdpLinkManager.getInstance().isSupportStarryNetStack()) {
            StLog.i(TAG, "starryNetStackSyncCaps no isSupportStarryNet");
        } else if (i == 1 || i == 2) {
            processRemoteStarryNetStackAction(stConnectDevice, Utils.intToByteArray(XdpLinkManager.getInstance().getOwnXdpCapacity()));
        } else {
            StLog.i(TAG, "starryNetStackSyncCaps: only Support p2p");
        }
    }

    public /* bridge */ /* synthetic */ void startSppServerListen(StConnectDevice stConnectDevice) {
        super.startSppServerListen(stConnectDevice);
    }

    public /* bridge */ /* synthetic */ void stopSppChannel(StConnectDevice stConnectDevice, int i) {
        super.stopSppChannel(stConnectDevice, i);
    }

    public /* bridge */ /* synthetic */ void sysP2pMacAddress(StConnectDevice stConnectDevice, String str) {
        super.sysP2pMacAddress(stConnectDevice, str);
    }

    public void updateBondStateChanged(StDevice stDevice, int i) {
        StLog.d(TAG, "updateBondStateChanged connectDevice " + stDevice + " new state = " + i);
        StConnectDevice connectDevice = StarryDeviceManager.getInstance().getConnectDevice(stDevice.getIdentifier());
        if (connectDevice == null) {
            StLog.i(TAG, "updateBondStateChanged connectDevice is null");
            return;
        }
        this.mHandler.removeMessages(2);
        if (i == 4) {
            IStarryNetChannel readyChannel = getReadyChannel(stDevice.getIdentifier2String());
            if (readyChannel == null) {
                StLog.i(TAG, "updateBondStateChanged channel is close");
            } else if (!readyChannel.isConnected(connectDevice.getBleMac())) {
                StLog.i(TAG, "updateBondStateChanged channel is disconnect");
            } else {
                onConnected(connectDevice, getConnectProfile(readyChannel.getProfile()));
            }
        }
    }

    public void disconnect(StDevice stDevice) {
        StLog.d(TAG, "disconnect device = " + stDevice);
        IStarryNetChannel readyChannel = getReadyChannel(stDevice.getIdentifier2String());
        if (readyChannel != null) {
            readyChannel.disconnect(stDevice);
        }
    }

    public void sendMsg(final StDevice stDevice, int i, final byte[] bArr, final IPairMsgCallback iPairMsgCallback) {
        if (i == 0) {
            MessageManager.getInstance().sendInnerBleClientMultipleMessage(stDevice, true, 16, bArr, new ISendMessageListener() {
                public void onSendFail(StarryMessage starryMessage, int i, String str) {
                    StLog.d(StarryNetProtocol.TAG, "sendMsg onResponse code = " + i + ",msg=" + str);
                    IPairMsgCallback iPairMsgCallback = iPairMsgCallback;
                    if (iPairMsgCallback != null) {
                        iPairMsgCallback.onResponse(stDevice, bArr, -1);
                    }
                }

                public void onSendSuccess(StarryMessage starryMessage) {
                    StLog.d(StarryNetProtocol.TAG, "sendMsg success ");
                    IPairMsgCallback iPairMsgCallback = iPairMsgCallback;
                    if (iPairMsgCallback != null) {
                        iPairMsgCallback.onResponse(stDevice, bArr, 0);
                    }
                }
            });
            return;
        }
        MessageManager.getInstance().sendInnerBleServerMultipleMessage(stDevice, true, 16, bArr, new ISendMessageListener() {
            public void onSendFail(StarryMessage starryMessage, int i, String str) {
                StLog.d(StarryNetProtocol.TAG, "sendMsg onResponse code = " + i + ",msg=" + str);
                iPairMsgCallback.onResponse(stDevice, (byte[]) null, -1);
            }

            public void onSendSuccess(StarryMessage starryMessage) {
                StLog.d(StarryNetProtocol.TAG, "sendMsg success ");
                iPairMsgCallback.onResponse(stDevice, (byte[]) null, 0);
            }
        });
    }

    public int sendStarryNetMsg(StDevice stDevice, byte[] bArr, IMessageCallback iMessageCallback) {
        IStarryNetChannel readyChannel;
        StLog.d(TAG, "sendMsg device = " + stDevice);
        if (stDevice == null || (readyChannel = getReadyChannel(stDevice.getIdentifier2String())) == null) {
            return StErrorCode.CONNECT_STRATEGY_BLE_PARAM_ERROR;
        }
        return readyChannel.sendMsg(stDevice, bArr, 10, iMessageCallback);
    }
}
